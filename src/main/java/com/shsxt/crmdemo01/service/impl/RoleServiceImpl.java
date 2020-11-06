package com.shsxt.crmdemo01.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crmdemo01.dao.RoleDao;
import com.shsxt.crmdemo01.po.Role;
import com.shsxt.crmdemo01.service.RoleService;
import com.shsxt.crmdemo01.vo.RoleVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    @Override
    public Map<String, Object> selectRole(RoleVo vo) {
        //开启分页
        PageHelper.startPage(vo.getPage(),vo.getLimit());
        List<Role> list=roleDao.selectRole(vo);
        PageInfo<Role> pageInfo=new PageInfo<>(list);

        Map<String, Object> map=new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", list);

        return map;
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public Role selectRoleById(String roleId) {
        Role role=roleDao.selectRoleById(roleId);
        return role;
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public void deleteRole(List<String> roleId) {
        roleDao.deleteRole(roleId);
    }
}
