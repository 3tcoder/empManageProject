package com.practice.empmanage.service;

import com.practice.empmanage.pojo.Emp;
import com.practice.empmanage.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;


public interface EmpService {
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void insert(Emp emp);

    Emp selectId(Integer id);

    void update(Emp emp);
}
