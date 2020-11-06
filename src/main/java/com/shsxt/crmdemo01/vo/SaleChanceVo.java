package com.shsxt.crmdemo01.vo;

import com.shsxt.crmdemo01.base.BaseQuery;

public class SaleChanceVo extends BaseQuery {
    private String createMan;
    private String state;

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
