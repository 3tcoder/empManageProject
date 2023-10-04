package com.practice.empmanage.service;

import com.practice.empmanage.anno.Log;
import com.practice.empmanage.mapper.DeptMapper;
import com.practice.empmanage.mapper.EmpMapper;
import com.practice.empmanage.pojo.Dept;
import com.practice.empmanage.pojo.DeptLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wusiyu
 */
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Log
    public void deleteId(Integer id) {
        try {
            deptMapper.deleteId(id);
            empMapper.deleteByDeptId(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("delete all from dept where id = " + id);
            deptLogService.insert(deptLog);
        }

    }

    @Override
    @Log
    public void insert(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept selectId(Integer id) {
        return deptMapper.selectId(id);
    }

    @Override
    @Log
    public void update(Dept dept) {
        deptMapper.update(dept);
    }
}
