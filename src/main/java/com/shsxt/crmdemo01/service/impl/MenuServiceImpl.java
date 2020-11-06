package com.shsxt.crmdemo01.service.impl;

import com.shsxt.crmdemo01.dao.MenuDao;
import com.shsxt.crmdemo01.po.Menu;
import com.shsxt.crmdemo01.service.MenuService;
import com.shsxt.crmdemo01.vo.MenuVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDao menuDao;


    @Override
    public List<Menu> selectList() {
        List<Menu> list=menuDao.selectList();
        return list;
    }

    @Override
    public void insert(MenuVo vo) {
        menuDao.insertList(vo);
    }

    @Override
    public void update(MenuVo vo) {
        menuDao.update(vo);
    }
}
