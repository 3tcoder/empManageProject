package com.practice.empmanage.service;

import com.practice.empmanage.anno.Log;
import com.practice.empmanage.mapper.EmpMapper;
import com.practice.empmanage.pojo.Emp;
import com.practice.empmanage.pojo.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wusiyu
 */
@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        Long count = empMapper.count();
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.list(start, pageSize, name, gender, begin, end);
        return new PageBean(count, empList);
    }

    @Override
    @Log
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    @Log
    public void insert(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp selectId(Integer id) {
        Emp emp = empMapper.selectId(id);
        return emp;
    }

    @Override
    @Log
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
}
