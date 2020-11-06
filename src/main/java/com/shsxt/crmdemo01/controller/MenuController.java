package com.shsxt.crmdemo01.controller;

import com.shsxt.crmdemo01.base.BaseController;
import com.shsxt.crmdemo01.base.ResultInfo;
import com.shsxt.crmdemo01.po.Menu;
import com.shsxt.crmdemo01.service.MenuService;
import com.shsxt.crmdemo01.vo.MenuVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController extends BaseController {
    @Resource
    private MenuService menuService;

    @RequestMapping("list")
    public ResultInfo selectList(){
        List<Menu> list=menuService.selectList();
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setCode(200);
        resultInfo.setMsg("菜单：");
        resultInfo.setResult(list);
        return resultInfo;
    }
    @RequestMapping("insert")
    public ResultInfo insert(MenuVo vo){
        menuService.insert(vo);
        ResultInfo resultInfo = new ResultInfo();
        return resultInfo;
    }

    @RequestMapping("update")
    public ResultInfo update(MenuVo vo){
        menuService.update(vo);
        ResultInfo resultInfo = new ResultInfo();
        return resultInfo;
    }

    @RequestMapping("delete")
    public ResultInfo delete(MenuVo vo){
        menuService.update(vo);
        ResultInfo resultInfo = new ResultInfo();
        return resultInfo;
    }
}
