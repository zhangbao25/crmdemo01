package com.shsxt.crmdemo01.po;

import lombok.Data;

import java.util.List;

@Data
public class Menu{
    private Integer id;
    private String menuName;
    private Integer pid;
    private List<Menu> list;

}
