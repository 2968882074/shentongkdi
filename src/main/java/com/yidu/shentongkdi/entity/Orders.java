package com.yidu.shentongkdi.entity;

import java.io.Serializable;

/**
 * (Orders)实体类
 *
 * @author makejava
 * @since 2020-12-28 14:56:39
 */
public class Orders implements Serializable {
    private static final long serialVersionUID = -60026962333419028L;
    
    private Integer oid;
    
    private Integer picid;
    
    private Integer seid;
    
    private Double weight;
    
    private Double amount;
    
    private Integer amountstate;
    
    private Integer state;


    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getAmountstate() {
        return amountstate;
    }

    public void setAmountstate(Integer amountstate) {
        this.amountstate = amountstate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}