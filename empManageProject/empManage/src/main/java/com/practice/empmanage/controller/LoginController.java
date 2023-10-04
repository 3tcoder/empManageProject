package com.practice.empmanage.controller;

import com.practice.empmanage.pojo.Emp;
import com.practice.empmanage.pojo.Result;
import com.practice.empmanage.pojo.User;
import com.practice.empmanage.service.LoginService;
import com.practice.empmanage.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wusiyu
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping()
    public Result login(@RequestBody User user) {
        log.info("login...");
        Emp emp = loginService.login(user);
        if (emp != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", emp.getUsername());
            claims.put("password", emp.getPassword());
            claims.put("name", emp.getName());
            String jwt = JWTUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("username or password is wrong!");

    }
}
