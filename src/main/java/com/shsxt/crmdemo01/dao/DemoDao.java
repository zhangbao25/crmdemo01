package com.shsxt.crmdemo01.dao;

import com.shsxt.crmdemo01.po.UserRole;
import com.shsxt.crmdemo01.vo.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemoDao {

    List<UserRole> selectList();

    void deleteRole(String userId);

    void insertRole(@Param("userId")String userId, @Param("array")String[] roleIds);

    void deleteMenu(String roleId);

    void insertMenu(@Param("roleId") String roleId, @Param("array")String[] menuIds);

    List<MenuVo> selectMenu(String id);

}
