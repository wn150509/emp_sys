package com.lx.emp.dao;

import com.lx.emp.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    /**
     * 根据主键删除
     * @param roleId
     * @return
     */
    int deleteByPrimaryKey(String roleId);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insert(Role record);

    /**
     * 判空处理插入数据
     * @param record
     * @return
     */
    int insertSelective(Role record);

    /**
     * 根据主键查询
     * @param roleId
     * @return
     */
    Role selectByPrimaryKey(String roleId);

    /**
     * 判空处理更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * 根据主键更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(Role record);

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_role")
    List<Role> findAll();
}