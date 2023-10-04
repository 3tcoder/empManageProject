package com.practice.empmanage.service;

import com.practice.empmanage.pojo.Dept;

import java.util.List;


public interface DeptService {

    List<Dept> list();

    void deleteId(Integer id);

    void insert(Dept dept);

    Dept selectId(Integer id);

    void update(Dept dept);
}
