package com.lx.emp.dao;

import com.lx.emp.pojo.Vacation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VacationMapper {

    /**
     * 根据主键
     * @param vacationId
     * @return
     */
    int deleteByPrimaryKey(Integer vacationId);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insert(Vacation record);

    /**
     * 判空处理插入数据
     * @param record
     * @return
     */
    int insertSelective(Vacation record);

    /**
     * 主键查询
     * @param vacationId
     * @return
     */
    Vacation selectByPrimaryKey(Integer vacationId);

    /**
     * 判空处理更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Vacation record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Vacation record);

    /**
     * 更具名字编号模糊查询
     * @param name
     * @param no
     * @return
     */
    @Select("select * from tb_vacation where emp_no like concat('%',#{no},'%') and emp_name like concat('%',#{name},'%')")
    List<Vacation> findAll(@Param("name") String name, @Param("no")String no);

    /**
     * 根据编号查询所有
     * @param no
     * @return
     */
    @Select("select * from tb_vacation where emp_no = #{no}")
    List<Vacation> findAllByEmpNo(@Param("no") String no);

    /**
     * 根据状态查询所有
     * @param name
     * @param no
     * @param status
     * @return
     */
    @Select("select * from tb_vacation where status = #{status} and emp_no like concat('%',#{no},'%') and emp_name like concat('%',#{name},'%')")
    List<Vacation> findAllByStatus(@Param("name") String name, @Param("no")String no,@Param("status") int status);


}