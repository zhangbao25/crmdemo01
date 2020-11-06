package com.shsxt.crmdemo01.dao;

import com.shsxt.crmdemo01.po.User;
import com.shsxt.crmdemo01.vo.UserVo;

import java.util.List;

public interface UserDao {

   User selectUserByUserName(String userName);

   User selectUserInfoById(String id);

   void updateUserPwd(String id, String userPwd);

    List<User> selectList(UserVo vo);

    void insertUser(User user);

    void updateUser(User user);


    void deleteUser(List<String> ids);

}
