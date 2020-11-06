package com.shsxt.crmdemo01.service;

import com.shsxt.crmdemo01.po.Role;
import com.shsxt.crmdemo01.vo.RoleVo;

import java.util.List;
import java.util.Map;

public interface RoleService {

    Map<String, Object> selectRole(RoleVo vo);

    void addRole(Role role);

    Role selectRoleById(String roleId);

    void updateRole(Role role);

    void deleteRole(List<String> roleId);

}
