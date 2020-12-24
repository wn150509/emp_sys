package com.lx.emp.dao;

import com.lx.emp.pojo.Department;
import com.lx.emp.pojo.Salery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaleryMapper {

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insert(Salery record);

    /**
     * 判空处理插入数据
     * @param record
     * @return
     */
    int insertSelective(Salery record);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Salery selectByPrimaryKey(Integer id);

    /**
     * 判空处理更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Salery record);

    /**
     * 根据主键更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(Salery record);

    /**
     * 根据员工姓名和编号模糊查询
     * @param empName
     * @param no
     * @return
     */
    @Select("select * from tb_salery where emp_name like concat('%',#{empName},'%') and emp_no like concat('%',#{no},'%')")
    List<Salery> findAll(@Param("empName") String empName, @Param("no")String no);
}