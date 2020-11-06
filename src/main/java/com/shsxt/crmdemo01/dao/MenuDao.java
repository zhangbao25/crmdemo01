package com.shsxt.crmdemo01.dao;

import com.shsxt.crmdemo01.po.Menu;
import com.shsxt.crmdemo01.vo.MenuVo;

import java.util.List;

public interface MenuDao {


    List<Menu> selectList();

    void insertList(MenuVo vo);

    void update(MenuVo vo);

}
