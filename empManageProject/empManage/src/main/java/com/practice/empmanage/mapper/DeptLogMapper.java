package com.practice.empmanage.mapper;

import com.practice.empmanage.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {

    @Insert("insert into dept_log values (#{id}, #{create_time}, #{description})")
    void insert(DeptLog deptLog);
}
