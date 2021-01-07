package com.yidu.shentongkdi.entity;

import java.io.Serializable;

/**
 * (Recipients)实体类
 *
 * @author makejava
 * @since 2021-01-07 13:52:03
 */
public class Recipients implements Serializable {
    private static final long serialVersionUID = -10361155276444238L;
    
    private Integer reid;
    
    private String rname;
    
    private String rephone;
    
    private String readdress;
    
    private String redetailedaddress;
    
    private String relandline;
    
    private Integer reweight;
    
    private String retype;
    
    private String repredicttime;
    
    private String repredictprice;


    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRephone() {
        return rephone;
    }

    public void setRephone(String rephone) {
        this.rephone = rephone;
    }

    public String getReaddress() {
        return readdress;
    }

    public void setReaddress(String readdress) {
        this.readdress = readdress;
    }

    public String getRedetailedaddress() {
        return redetailedaddress;
    }

    public void setRedetailedaddress(String redetailedaddress) {
        this.redetailedaddress = redetailedaddress;
    }

    public String getRelandline() {
        return relandline;
    }

    public void setRelandline(String relandline) {
        this.relandline = relandline;
    }

    public Integer getReweight() {
        return reweight;
    }

    public void setReweight(Integer reweight) {
        this.reweight = reweight;
    }

    public String getRetype() {
        return retype;
    }

    public void setRetype(String retype) {
        this.retype = retype;
    }

    public String getRepredicttime() {
        return repredicttime;
    }

    public void setRepredicttime(String repredicttime) {
        this.repredicttime = repredicttime;
    }

    public String getRepredictprice() {
        return repredictprice;
    }

    public void setRepredictprice(String repredictprice) {
        this.repredictprice = repredictprice;
    }

}