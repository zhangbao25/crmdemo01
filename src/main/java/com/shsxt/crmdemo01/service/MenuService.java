package com.shsxt.crmdemo01.service;

import com.shsxt.crmdemo01.po.Menu;
import com.shsxt.crmdemo01.vo.MenuVo;

import java.util.List;

public interface MenuService {

    List<Menu> selectList();

    void insert(MenuVo vo);

    void update(MenuVo vo);

}
