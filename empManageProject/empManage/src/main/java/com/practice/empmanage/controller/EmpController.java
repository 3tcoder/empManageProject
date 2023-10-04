package com.practice.empmanage.controller;

import com.practice.empmanage.pojo.Emp;
import com.practice.empmanage.pojo.PageBean;
import com.practice.empmanage.pojo.Result;
import com.practice.empmanage.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping()
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") LocalDate end) {
        log.info("page of {}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    @GetMapping("/{id}")
    public Result selectId(@PathVariable Integer id) {
        log.info("emp.select by id = " + id);
        Emp emp = empService.selectId(id);
        return Result.success(emp);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("emp.delete " + ids);
        empService.delete(ids);

        return Result.success();
    }

    @PostMapping()
    public Result insert(@RequestBody Emp emp) {
        log.info("emp.insert");
        empService.insert(emp);
        return Result.success();
    }

    @PutMapping()
    public Result update(@RequestBody Emp emp) {
        log.info("emp.update");
        empService.update(emp);
        return Result.success();
    }
}
