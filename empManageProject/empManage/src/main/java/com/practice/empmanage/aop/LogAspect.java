package com.practice.empmanage.aop;

import com.alibaba.fastjson.JSONObject;
import com.practice.empmanage.mapper.OperateLogMapper;
import com.practice.empmanage.pojo.OperateLog;
import com.practice.empmanage.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.practice.empmanage.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String jwt = request.getHeader("token");
        Claims claims = JWTUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");

        String className = joinPoint.getTarget().getClass().getName();

        String methodName = joinPoint.getSignature().getName();

        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // execute
        long end = System.currentTimeMillis();
        long costTime = end - begin;

        String returnValue = JSONObject.toJSONString(result);

        OperateLog operateLog = new OperateLog(null, operateUser, LocalDateTime.now(),
                className, methodName, methodParams, returnValue, costTime);

        operateLogMapper.insert(operateLog);

        log.info("AOP is recording its log...");
        return result;
    }
}
