package com.lx.emp.dao;

import com.lx.emp.pojo.Attendence;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AttendenceMapper {

    /**
     * 根据主键删除
     * @param attendId
     * @return
     */
    int deleteByPrimaryKey(Integer attendId);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insert(Attendence record);

    /**
     * 插入考勤数据
     * @param record
     * @return
     */
    int insertSelective(Attendence record);

    /**
     * 根据主键查询考勤数据
     * @param attendId
     * @return
     */
    Attendence selectByPrimaryKey(Integer attendId);

    /**
     * 根据上班时间和员工号获取考勤记录
     * @param no
     * @param begin
     * @param end
     * @return
     */
    @Select("select * from tb_attend where emp_no = #{no} and attend_begin_time between #{begin} and #{end}")
    Attendence getByEmpNoAndBeginTime(@Param("no") String no, @Param("begin") String begin,@Param("end") String end);

    /**
     * 根据下班打卡时间和员工号获取考勤记录
     * @param no
     * @param begin
     * @param end
     * @return
     */
    @Select("select * from tb_attend where emp_no = #{no} and attend_end_time between #{begin} and #{end}")
    Attendence getByEmpNoAndEndTime(@Param("no") String no, @Param("begin") String begin,@Param("end") String end);

    /**
     * 修改考勤记录
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Attendence record);

    /**
     * 修改考勤记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(Attendence record);

    /**
     * 根据姓名和员工获取考勤列表
     * @param name
     * @param no
     * @return
     */
    @Select("select * from tb_attend where emp_no like concat('%',#{no},'%') and emp_name like concat('%',#{name},'%') order by attend_begin_time desc")
    List<Attendence> findAll(@Param("name") String name, @Param("no") String no);
}