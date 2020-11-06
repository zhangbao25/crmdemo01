package com.shsxt.crmdemo01.service.impl;

import com.shsxt.crmdemo01.dao.DemoDao;
import com.shsxt.crmdemo01.po.UserRole;
import com.shsxt.crmdemo01.service.DemoService;
import com.shsxt.crmdemo01.vo.MenuVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Resource
    private DemoDao demoDao;

    @Override
    public List<UserRole> selectList() {
        List<UserRole> list=demoDao.selectList();
        return list;
    }

    @Override
    public void updateRole(String userId,String[] roleIds) {
        demoDao.deleteRole(userId);
        demoDao.insertRole(userId,roleIds);
    }

    @Override
    public void updateMenu(String roleId, String[] menuIds) {
        demoDao.deleteMenu(roleId);
        demoDao.insertMenu(roleId,menuIds);
    }

    @Override
    public List<MenuVo> selectMenu(String id) {
        List<MenuVo> list=demoDao.selectMenu(id);
        return list;
    }


}
