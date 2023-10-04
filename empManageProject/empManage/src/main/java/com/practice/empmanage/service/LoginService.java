package com.practice.empmanage.service;

import com.practice.empmanage.pojo.Emp;
import com.practice.empmanage.pojo.User;

/**
 * @author wusiyu
 */
public interface LoginService {
    Emp login(User user);
}
