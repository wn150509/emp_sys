package com.lx.emp.dao;

import com.lx.emp.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepartmentMapper {

    /**
     * 根据主键删除
     * @param deptId
     * @return
     */
    int deleteByPrimaryKey(String deptId);

    /**
     * 插入部门
     * @param record
     * @return
     */
    int insert(Department record);

    /**
     * 判断插入
     * @param record
     * @return
     */
    int insertSelective(Department record);

    /**
     * 根据主键查询
     * @param deptId
     * @return
     */
    Department selectByPrimaryKey(String deptId);

    /**
     * 根据判断更新部门
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Department record);

    /**
     * 更新部门
     * @param record
     * @return
     */
    int updateByPrimaryKey(Department record);

    /**
     * 根据部门名查询所有
     * @param departmentName
     * @return
     */
    @Select("select * from tb_dept where dept_name like concat('%',#{departmentName},'%')")
    List<Department> findAll(@Param("departmentName") String departmentName);
}