package com.yidu.shentongkdi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Orders)实体类
 *
 * @author makejava
 * @since 2020-12-28 14:56:39
 */
@Component
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

    public Orders() {
    }

    public Orders(Integer oid, Integer picid, Integer seid, Double weight, Double amount, Integer amountstate, Integer state) {
        this.oid = oid;
        this.picid = picid;
        this.seid = seid;
        this.weight = weight;
        this.amount = amount;
        this.amountstate = amountstate;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", picid=" + picid +
                ", seid=" + seid +
                ", weight=" + weight +
                ", amount=" + amount +
                ", amountstate=" + amountstate +
                ", state=" + state +
                '}';
    }
}