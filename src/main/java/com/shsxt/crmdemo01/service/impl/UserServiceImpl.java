package com.shsxt.crmdemo01.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crmdemo01.dao.UserDao;
import com.shsxt.crmdemo01.exception.MyException;
import com.shsxt.crmdemo01.exception.ParamsException;
import com.shsxt.crmdemo01.po.User;
import com.shsxt.crmdemo01.service.UserService;
import com.shsxt.crmdemo01.utils.Md5Util;
import com.shsxt.crmdemo01.vo.UserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User selectUserByUserNameAndPwd(String userName, String userPwd) throws ParamsException, MyException {
        if(userName==null||"".equals(userName.trim())){
            throw new ParamsException(500,"用户姓名不能为空");
        }
        if(userPwd==null||"".equals(userPwd.trim())){
            throw new ParamsException(500,"用户密码不能为空");
        }
        User user = userDao.selectUserByUserName(userName);
        if(user==null){
            throw new MyException(300,"用户名不存在");
        }
        String userPwd1 = user.getUserPwd();
        String encode = Md5Util.encode(userPwd);
        //如果从前台传过来的密码，进行MD5加密过后，与数据库一样
        if(!userPwd1.equals(encode)){
            throw new MyException(400,"用户密码错误");
        }
        return user;

    }
    @Override
    public void updatePwd(String id, String oldPwd, String newPwd, String repeatPwd) throws ParamsException, MyException {
        //认证新密码，确认密码不能为空
        if (oldPwd == null || "".equals(oldPwd.trim())) {
            System.out.println("旧密码不能为空");
            throw new ParamsException(20002, "旧密码不能为空");
        }
        if(!newPwd.equals(repeatPwd)){
            System.out.println("确认密码与新密码不同");
            throw new MyException(500,"确认密码与新密码不同");
        }
        //根据id 查询用户
        User u = userDao.selectUserInfoById(id);
        String encode = Md5Util.encode(oldPwd);

        String userPwd = u.getUserPwd();

        System.out.println(encode);
        System.out.println(userPwd);

        if(!encode.equals(userPwd)){
            System.out.println("旧密码与数据库密码不同");
            return;
        }
        userDao.updateUserPwd(id,Md5Util.encode(newPwd));
    }

    @Override
    public Map<String, Object> selectList(UserVo vo) {
        //开启分页
        PageHelper.startPage(vo.getPage(),vo.getLimit());
        List<User> list=userDao.selectList(vo);
        PageInfo<User> pageInfo=new PageInfo(list);
        Map<String, Object> map=new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", list);
        return map;
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User selectUserInfoById(String id) {
        User user = userDao.selectUserInfoById(id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        user.setUpdateDate(new Date());
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(List<String> ids) {
        userDao.deleteUser(ids);
    }


}
