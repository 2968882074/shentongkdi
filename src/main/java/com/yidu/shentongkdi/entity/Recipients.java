package com.yidu.shentongkdi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Recipients)实体类
 *
 * @author makejava
 * @since 2021-01-06 10:43:33
 */
@Component
public class Recipients implements Serializable {
    private static final long serialVersionUID = 985162053309699962L;
    
    private Integer reid;
    
    private String rename;
    
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

    public String getRename() {
        return rename;
    }

    public void setRename(String rename) {
        this.rename = rename;
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