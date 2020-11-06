package com.shsxt.crmdemo01.service;

import com.shsxt.crmdemo01.po.UserRole;
import com.shsxt.crmdemo01.vo.MenuVo;

import java.util.List;

public interface DemoService {
    List<UserRole> selectList();

    void updateRole(String userId,String[] roleIds);

    void updateMenu(String roleId, String[] menuIds);

    List<MenuVo> selectMenu(String id);

}
