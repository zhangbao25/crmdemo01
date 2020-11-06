package com.shsxt.crmdemo01.controller;

import com.shsxt.crmdemo01.po.SaleChance;
import com.shsxt.crmdemo01.service.SaleChanceService;
import com.shsxt.crmdemo01.vo.SaleChanceVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("sale_chance")
public class SaleChanceController {
    @Resource
    private SaleChanceService saleChanceService;

    @RequestMapping("index")
    public String index(){
        return "saleChance/sale_chance";
    }

    @RequestMapping("toAddOrUpdatePage")
    public String toAddOrUpdatePage(HttpServletRequest request, String saleChanceId){
        if(saleChanceId!=null){
            SaleChance saleChance=saleChanceService.selectSaleChanceInfoById(saleChanceId);
            request.setAttribute("saleChance",saleChance);
        }
        return "saleChance/add_update";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> list(SaleChanceVo vo){
        Map<String, Object> map= saleChanceService.selectList(vo);
        return map;
    }
    @RequestMapping("add")
    @ResponseBody
    //增加数据
    public String insert(SaleChance saleChance){
        saleChanceService.insert(saleChance);
        return "success";
    }

    @RequestMapping("update")
    @ResponseBody
    //修改数据update
    public String update(SaleChance saleChance){
        saleChanceService.update(saleChance);
        return "success";
    }

//    @RequestMapping("delete")
//    @ResponseBody
//    //删除单条数据
//    public String delete(String ids){
//        saleChanceService.delete(ids);
//        return "success";
//    }


    @RequestMapping("delete")
    @ResponseBody
    public String delete(String[] ids){
        saleChanceService.deleteIds(ids);
        return "success";
    }
}
