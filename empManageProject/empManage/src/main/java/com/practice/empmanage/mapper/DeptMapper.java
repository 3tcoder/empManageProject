package com.practice.empmanage.mapper;

import com.practice.empmanage.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select id, name, create_time, update_time from dept")
    public List<Dept> list();

    @Delete("delete from dept where id = #{id}")
    public void deleteId(Integer id);

    @Insert("insert into dept (name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept selectId(Integer id);

    @Update("update dept set name = #{name} where id = #{id}")
    void update(Dept dept);
}
