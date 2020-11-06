package com.shsxt.crmdemo01.vo;

import com.shsxt.crmdemo01.base.BaseQuery;
import lombok.Data;

@Data
public class UserVo extends BaseQuery {
    private String userName;
    private String email;
    private String phone;

}
