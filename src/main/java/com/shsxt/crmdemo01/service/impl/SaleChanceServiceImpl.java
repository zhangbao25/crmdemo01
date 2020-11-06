package com.shsxt.crmdemo01.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crmdemo01.dao.SaleChanceDao;
import com.shsxt.crmdemo01.po.SaleChance;
import com.shsxt.crmdemo01.service.SaleChanceService;
import com.shsxt.crmdemo01.vo.SaleChanceVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaleChanceServiceImpl implements SaleChanceService {
    @Resource
    private SaleChanceDao saleChanceDao;
    @Override
    public Map<String, Object> selectList(SaleChanceVo vo) {
        //使用 pageHelper 帮我们处理了总记录数
        PageHelper.startPage(vo.getPage(),vo.getLimit());
        List<SaleChance> list = saleChanceDao.selectList(vo);
        PageInfo<SaleChance> PageInfo = new PageInfo<>();
        Map<String, Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",PageInfo.getTotal());
        map.put("data",list);
        return map;
    }

    @Override
    public void insert(SaleChance saleChance) {
        saleChance.setCreateDate(new Date());
        saleChance.setCreateMan("张豹");
        saleChanceDao.insert(saleChance);
    }

    @Override
    public SaleChance selectSaleChanceInfoById(String saleChanceId) {
        SaleChance saleChance=saleChanceDao.selectSaleChanceInfoById(saleChanceId);
        return saleChance;
    }

    @Override
    public void update(SaleChance saleChance) {
        saleChanceDao.update(saleChance);
    }

    @Override
    public void delete(String ids) {
        saleChanceDao.delete(ids);
    }

    @Override
    public void deleteIds(String[] ids) {
        saleChanceDao.deleteIds(ids);
    }
}
