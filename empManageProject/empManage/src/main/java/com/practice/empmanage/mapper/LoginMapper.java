package com.practice.empmanage.mapper;

import com.practice.empmanage.pojo.Emp;
import com.practice.empmanage.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author wusiyu
 */
@Mapper
public interface LoginMapper {
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp login(User user);
}
