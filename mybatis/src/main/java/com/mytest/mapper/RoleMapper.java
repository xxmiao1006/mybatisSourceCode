package com.mytest.mapper;

import com.mytest.pojo.Role;

/**
 * @author xxm
 * @date 2021/2/3 10:04
 */
public interface RoleMapper {
    //@Select(value = "select id,role_name AS roleName ,note from role where id=#{id}")
    Role getRole(Long id);
    Role findRole(String roleName);
    int deleteRole(Long id);
    int insertRole(Role role);
}