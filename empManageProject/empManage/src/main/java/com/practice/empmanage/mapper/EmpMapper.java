package com.practice.empmanage.mapper;

import com.practice.empmanage.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    List<Emp> list(int start, int pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    @Select("select count(*) from emp")
    Long count();

    void delete(List<Integer> ids);

    void insert(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp selectId(Integer id);

    void update(Emp emp);

    @Delete("delete from emp where dept_id = #{id}")
    void deleteByDeptId(Integer id);
}
