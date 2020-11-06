package com.shsxt.crmdemo01.controller;

import com.shsxt.crmdemo01.base.BaseController;
import com.shsxt.crmdemo01.base.ResultInfo;
import com.shsxt.crmdemo01.po.Role;
import com.shsxt.crmdemo01.service.RoleService;
import com.shsxt.crmdemo01.vo.RoleVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("role")
public class RoleController extends BaseController {
    @Resource
    private RoleService roleService;

    @RequestMapping("index")
    public String index(){
        return "role/role";
    }


    @RequestMapping("toAddGrantPage")
    public String toAddGrantPage(){
        return "role/grant";
    }



    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> selectRole(RoleVo vo){
        Map<String, Object> map=roleService.selectRole(vo);
        return map;
    }


    @RequestMapping("addOrUpdateRolePage")
    public String addOrUpdateRolePage(HttpServletRequest request,String roleId){
        if(roleId!=null  && !"".equals(roleId)){
            Role u=roleService.selectRoleById(roleId);
            request.setAttribute("role",u);
        }
        return "role/add_update";
    }

    @RequestMapping("add")
    @ResponseBody
    public ResultInfo addRole(Role role){
//        role.setId(100);
        role.setCreateDate(new Date());
        role.setUpdateDate(new Date());
        role.setIsValid(1);
        roleService.addRole(role);
        return success();
    }
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo updateRole(Role role){
        role.setUpdateDate(new Date());
        roleService.updateRole(role);
        return success();
    }
    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo deleteRole(@RequestParam List<String> roleId){

        roleService.deleteRole(roleId);
        return success();
    }





}
