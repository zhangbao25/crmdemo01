package com.shsxt.crmdemo01.dao;

import com.shsxt.crmdemo01.po.Role;
import com.shsxt.crmdemo01.vo.RoleVo;

import java.util.List;

public interface RoleDao {

    List<Role> selectRole(RoleVo vo);

    void addRole(Role role);

    Role selectRoleById(String roleId);

    void updateRole(Role role);

    void deleteRole(List<String> roleId);

}
