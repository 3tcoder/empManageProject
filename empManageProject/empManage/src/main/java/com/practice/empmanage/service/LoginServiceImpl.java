package com.practice.empmanage.service;

import com.practice.empmanage.mapper.LoginMapper;
import com.practice.empmanage.pojo.Emp;
import com.practice.empmanage.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wusiyu
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Emp login(User user) {
        Emp emp = loginMapper.login(user);
        return emp;
    }
}
