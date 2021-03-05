package com.yidu.shentongkdi.entity;

import java.io.Serializable;

/**
 * (Pickup)实体类
 *
 * @author makejava
 * @since 2021-03-05 10:36:19
 */
public class Pickup implements Serializable {
    private static final long serialVersionUID = -87920828816146575L;
    
    private Integer picid;
    
    private Integer seid;
    
    private String coding;
    
    private String starttime;
    
    private String stoptime;
    
    private String remark;


    public Integer getPicid() {
        return picid;
    }

    public void setPicid(Integer picid) {
        this.picid = picid;
    }

    public Integer getSeid() {
        return seid;
    }

    public void setSeid(Integer seid) {
        this.seid = seid;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getStoptime() {
        return stoptime;
    }

    public void setStoptime(String stoptime) {
        this.stoptime = stoptime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}