package com.lx.emp.dao;

import com.lx.emp.pojo.RolePermission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper {

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
    int insert(RolePermission record);

    /**
     * 判空处理插入
     * @param record
     * @return
     */
    int insertSelective(RolePermission record);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    RolePermission selectByPrimaryKey(Integer id);

    /**
     * 判空处理更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(RolePermission record);

    /**
     * 更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(RolePermission record);

    /**
     * 根据主键删除
     * @param roleId
     */
    @Delete("delete from r_role_permission where role_id = #{roleId}")
    void deleteByRoleId(@Param("roleId") String roleId);
}