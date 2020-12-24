package com.lx.emp.dao;

import com.lx.emp.pojo.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {

    /**
     * 根据主键删除
     * @param permissionId
     * @return
     */
    int deleteByPrimaryKey(Integer permissionId);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insert(Permission record);

    /**
     * 判空处理插入数据
     * @param record
     * @return
     */
    int insertSelective(Permission record);

    /**
     * 根据主键查询
     * @param permissionId
     * @return
     */
    Permission selectByPrimaryKey(Integer permissionId);

    /**
     * 判空处理更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     * 根据主键更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(Permission record);

    /**
     * 根据角色id获取权限列表
     * @param roleid
     * @return
     */
    @Select("SELECT p.* from r_role_permission rp,tb_permission p where rp.role_id = #{roleid} and rp.permission_id = p.permission_id")
    List<Permission> findByRoleId(@Param("roleid") String roleid);

    @Select("select * from tb_permission")
    List<Permission> findAll();

}