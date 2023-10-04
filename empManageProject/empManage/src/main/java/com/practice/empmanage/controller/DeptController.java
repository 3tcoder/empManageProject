package com.practice.empmanage.controller;

import com.practice.empmanage.pojo.Dept;
import com.practice.empmanage.pojo.Result;
import com.practice.empmanage.service.DeptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptServiceImpl deptServiceImpl;

    @GetMapping()
    public Result list() {
        log.info("List all informations of Dept.");
        List<Dept> depts = deptServiceImpl.list();
        return Result.success(depts);
    }

    @DeleteMapping("/{id}")
    public Result deleteId(@PathVariable Integer id) {
        log.info("Delete where id = " + id + ".");
        deptServiceImpl.deleteId(id);
        return Result.success();
    }

    @PostMapping()
    public Result insert(@RequestBody Dept dept) {
        log.info("Insert " + dept.getName() + " into dept.");
        deptServiceImpl.insert(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectId(@PathVariable Integer id) {
        log.info("select where id = " + id);
        Dept dept = deptServiceImpl.selectId(id);
        return Result.success(dept);
    }

    @PutMapping()
    public Result update(@RequestBody Dept dept) {
        log.info("update dept set name = " + dept.getName() + "where id = " + dept.getId());
        deptServiceImpl.update(dept);
        return Result.success();
    }

}
