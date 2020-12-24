package com.lx.emp.dao;

import com.lx.emp.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 根据主键查询
     * @param empId
     * @return
     */
    int deleteByPrimaryKey(Integer empId);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insert(Employee record);

    /**
     * 判空插入数据
     * @param record
     * @return
     */
    int insertSelective(Employee record);

    /**
     * 根据主键查询
     * @param empId
     * @return
     */
    Employee selectByPrimaryKey(Integer empId);

    /**
     * 判空更新信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * 更新信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Employee record);

    /**
     * 模糊查询
     * @param name
     * @param no
     * @param deptId
     * @return
     */
    @Select("select e.*,d.dept_name from tb_emp e,tb_dept d where e.dept_id = d.dept_id and e.emp_no like concat('%',#{no},'%') and e.emp_name like concat('%',#{name},'%') and e.dept_id like concat('%',#{deptId},'%') order by emp_id")
    List<Employee> findAll(@Param("name") String name,
                           @Param("no") String no,
                           @Param("deptId") String deptId);

    /**
     * 根据员工编号查询
     * @param empNO
     * @return
     */
    @Select("select * from tb_emp where emp_no = #{empNO}")
    Employee selectByEmpNO(String empNO);

    /**
     * 更改密码
     * @param no
     * @param password
     * @return
     */
    @Update("UPDATE tb_emp set emp_password = #{password} where emp_no = #{no}")
    int changePassword(@Param("no") String no,@Param("password") String password);


}