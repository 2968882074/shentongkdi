package com.yidu.shentongkdi.entity;

import org.springframework.stereotype.Component;


import java.io.Serializable;

/**
 * (Charge)实体类
 *
 * @author makejava
 * @since 2021-01-11 14:30:32
 */
@Component
public class Charge implements Serializable {
    private static final long serialVersionUID = 703729478992586010L;
    
    private Integer chid;
    
    private String commence;
    
    private String those;
    
    private String goods;
    
    private String chargetime;
    
    private String price;
    
    private String predicttime;

    public Charge() {
    }

    public Charge(Integer chid, String commence, String those, String goods, String chargetime, String price, String predicttime) {
        this.chid = chid;
        this.commence = commence;
        this.those = those;
        this.goods = goods;
        this.chargetime = chargetime;
        this.price = price;
        this.predicttime = predicttime;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "chid=" + chid +
                ", commence='" + commence + '\'' +
                ", those='" + those + '\'' +
                ", goods='" + goods + '\'' +
                ", chargetime='" + chargetime + '\'' +
                ", price='" + price + '\'' +
                ", predicttime='" + predicttime + '\'' +
                '}';
    }

    public Integer getChid() {
        return chid;
    }

    public void setChid(Integer chid) {
        this.chid = chid;
    }

    public String getCommence() {
        return commence;
    }

    public void setCommence(String commence) {
        this.commence = commence;
    }

    public String getThose() {
        return those;
    }

    public void setThose(String those) {
        this.those = those;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getChargetime() {
        return chargetime;
    }

    public void setChargetime(String chargetime) {
        this.chargetime = chargetime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPredicttime() {
        return predicttime;
    }

    public void setPredicttime(String predicttime) {
        this.predicttime = predicttime;
    }

}