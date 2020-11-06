package com.shsxt.crmdemo01.service;

import com.shsxt.crmdemo01.exception.MyException;
import com.shsxt.crmdemo01.exception.ParamsException;
import com.shsxt.crmdemo01.po.User;
import com.shsxt.crmdemo01.vo.UserVo;

import java.util.List;
import java.util.Map;

public interface UserService {
    User selectUserByUserNameAndPwd(String userName, String userPwd) throws ParamsException, MyException;

    void updatePwd(String id, String oldPwd, String newPwd, String repeatPwd) throws ParamsException, MyException;

    Map<String, Object> selectList(UserVo vo);

    void insertUser(User user);

    User selectUserInfoById(String id);

    void updateUser(User user);

//    void deleteUser(String[] ids);

    void deleteUser(List<String> ids);

}
