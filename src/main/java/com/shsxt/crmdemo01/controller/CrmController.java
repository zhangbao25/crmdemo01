package com.shsxt.crmdemo01.controller;

import com.shsxt.crmdemo01.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrmController extends BaseController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("main")
    public String main(){
        return "main";
    }

    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }
}
