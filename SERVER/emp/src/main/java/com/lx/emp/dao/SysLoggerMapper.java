package com.lx.emp.dao;

import com.lx.emp.pojo.SysLogger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysLoggerMapper {

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
    int insert(SysLogger record);

    /**
     * 判空处理插入数据
     * @param record
     * @return
     */
    int insertSelective(SysLogger record);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    SysLogger selectByPrimaryKey(Integer id);

    /**
     * 判空处理更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysLogger record);

    /**
     * 判空处理系统日志
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(SysLogger record);

    /**
     * 更新日志
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysLogger record);

    /**
     * 查询所有日志
     * @return
     */
    @Select("select * from sys_logger")
    List<SysLogger> findAll();
}