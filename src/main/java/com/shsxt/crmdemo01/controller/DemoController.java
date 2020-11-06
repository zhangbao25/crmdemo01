package com.shsxt.crmdemo01.controller;

import com.shsxt.crmdemo01.base.ResultInfo;
import com.shsxt.crmdemo01.po.UserRole;
import com.shsxt.crmdemo01.service.DemoService;
import com.shsxt.crmdemo01.vo.MenuVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("demo")
public class DemoController {
    @Resource
    private DemoService demoService;

    //查询用户和角色
    @RequestMapping("select")
    public ResultInfo selectList(){
        List<UserRole> list=demoService.selectList();
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setCode(200);
        resultInfo.setMsg("用户角色表");
        resultInfo.setResult(list);
        return resultInfo;
    }

    //用户分配指定角色    先删除该用户下的角色再添加角色  r_user_role
    @RequestMapping("updateRole")
    public ResultInfo updateRole(String userId,String[] roleIds){
        demoService.updateRole(userId,roleIds);
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setCode(200);
        resultInfo.setMsg("修改角色成功");
        return resultInfo;
    }
    //角色分配指定菜单    先删除该角色下的菜单再添加菜单  r_role_menu
    @RequestMapping("updateMenu")
    public ResultInfo updateMenu(String roleId,String[] MenuIds){
        demoService.updateMenu(roleId,MenuIds);
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setCode(200);
        resultInfo.setMsg("修改菜单成功");
        return resultInfo;
    }

    //根据用户id 查询该用户拥有的菜单权限
    @RequestMapping("selectMenu")
    public ResultInfo selectMenu(String id){
        List<MenuVo> list=demoService.selectMenu(id);
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setCode(200);
        resultInfo.setMsg(id+"号用户菜单权限表");
        resultInfo.setResult(list);
        return resultInfo;
    }

}
