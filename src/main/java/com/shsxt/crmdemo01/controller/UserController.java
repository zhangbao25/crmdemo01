package com.shsxt.crmdemo01.controller;

import com.shsxt.crmdemo01.base.BaseController;
import com.shsxt.crmdemo01.base.ResultInfo;
import com.shsxt.crmdemo01.exception.MyException;
import com.shsxt.crmdemo01.exception.ParamsException;
import com.shsxt.crmdemo01.po.User;
import com.shsxt.crmdemo01.service.UserService;
import com.shsxt.crmdemo01.utils.Md5Util;
import com.shsxt.crmdemo01.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping("toPasswordPage")
    public String toPasswordPage(){
        return "user/password";
    }



    @RequestMapping("index")
    public String index() {
        return "user/user";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> selectList(UserVo vo) {
        Map<String, Object> map = userService.selectList(vo);
        return map;
    }

    @RequestMapping("addOrUpdateUserPage")
    public String addOrUpdateUserPage(HttpServletRequest request,String id) {
        if(id!=null && !"".equals(id)){
            User u=userService.selectUserInfoById(id);
            request.setAttribute("user",u);
        }
        return "user/add_update";
    }




    @RequestMapping("login")
    @ResponseBody
    public ResultInfo login(String userName,String userPwd) throws MyException, ParamsException {

        /*try {
            u=userService.selectUserByUserNameAndPwd(userName,userPwd);
        } catch (ParamsException e) {
            e.printStackTrace();
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setCode(400);
            resultInfo.setMsg(e.getMsg());
            return resultInfo;
        } catch (MyException e) {
            e.printStackTrace();
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setCode(400);
            resultInfo.setMsg(e.getMsg());
            return resultInfo;
        }*/
        User u=userService.selectUserByUserNameAndPwd(userName,userPwd);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(200);
        resultInfo.setMsg("");
        resultInfo.setResult(u);
        return resultInfo;
    }
    @ResponseBody
    @RequestMapping("updatePwd")
    public ResultInfo updatePwd(HttpServletRequest request, String oldPwd, String newPwd, String repeatPwd){
        String id="";
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if(cookie.getName().equals("id")){
                id = cookie.getValue();
            }
        }
        try {
            userService.updatePwd(id,oldPwd,newPwd,repeatPwd);
        } catch (ParamsException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("add")
    @ResponseBody
    public ResultInfo insertUser(User user){
        String pwd = "123456";
        String encode = Md5Util.encode(pwd);

        user.setUserPwd(encode);

        user.setIsValid(1);
        user.setCreateDate(new Date());
        userService.insertUser(user);

        return success();
    }
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo updateUser(User user) {
        userService.updateUser(user);
        return success();
    }
//
//    @RequestMapping("delete")
//    @ResponseBody
//    public String deleteUser(String[] ids) {
//        userService.deleteUser(ids);
//        return "success";
//    }

    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo deleteUser(@RequestParam List<String> ids) {
        userService.deleteUser(ids);
        return success();
    }
}
