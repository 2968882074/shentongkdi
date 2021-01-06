package com.yidu.shentongkdi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Orders)实体类
 *
 * @author makejava
 * @since 2021-01-05 15:55:09
 */
@Component
public class Orders implements Serializable {
    private static final long serialVersionUID = -10539219958481836L;
    
    private Integer oid;
    
    private Integer reid;
    
    private Integer seid;
    
    private Double weight;
    
    private Double amount;
    
    private Integer amountstate;
    
    private Integer state;

    private Recipients recipients;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Recipients getRecipients() {
        return recipients;
    }

    public void setRecipients(Recipients recipients) {
        this.recipients = recipients;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
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

    public Orders(Integer oid, Integer reid, Integer seid, Double weight, Double amount, Integer amountstate, Integer state) {
        this.oid = oid;
        this.reid = reid;
        this.seid = seid;
        this.weight = weight;
        this.amount = amount;
        this.amountstate = amountstate;
        this.state = state;
    }

    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", reid=" + reid +
                ", seid=" + seid +
                ", weight=" + weight +
                ", amount=" + amount +
                ", amountstate=" + amountstate +
                ", state=" + state +
                '}';
    }
}