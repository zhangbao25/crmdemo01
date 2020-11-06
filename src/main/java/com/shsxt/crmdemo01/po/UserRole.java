package com.shsxt.crmdemo01.po;

import com.shsxt.crmdemo01.vo.UserRoleVo;
import lombok.Data;

import java.util.List;

@Data
public class UserRole {
    private Integer id;//用户id
    private String userName;//用户名称
    private String userPwd;//用户密码
    private List<UserRoleVo> list;
}
