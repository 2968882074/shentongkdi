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
    
    private Double weight;
    
    private Double amount;
    
    private Integer amountstate;
    
    private Integer state;

    private Recipients recipients;

    private Sender sender;

    private int seid;

    private int reid;

    public int getSeid() {
        return seid;
    }

    public void setSeid(int seid) {
        this.seid = seid;
    }

    public int getReid() {
        return reid;
    }

    public void setReid(int reid) {
        this.reid = reid;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

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


}