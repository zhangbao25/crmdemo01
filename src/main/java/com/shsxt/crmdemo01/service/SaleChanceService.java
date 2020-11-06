package com.shsxt.crmdemo01.service;

import com.shsxt.crmdemo01.po.SaleChance;
import com.shsxt.crmdemo01.vo.SaleChanceVo;

import java.util.Map;

public interface SaleChanceService {
    Map<String, Object> selectList(SaleChanceVo vo);


    void insert(SaleChance saleChance);

    SaleChance selectSaleChanceInfoById(String saleChanceId);

    void update(SaleChance saleChance);

    void delete(String ids);

    void deleteIds(String[] ids);

}
