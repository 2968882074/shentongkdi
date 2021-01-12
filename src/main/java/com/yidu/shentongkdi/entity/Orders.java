package com.yidu.shentongkdi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Orders)实体类
 *
 * @author makejava
 * @since 2021-01-12 14:03:58
 */
@Component
public class Orders implements Serializable {
    private static final long serialVersionUID = -89529553158149280L;
    
    private Integer oid;
    
    private Integer reid;
    
    private Integer seid;
    
    private Double weight;
    
    private Double amount;
    
    private Integer amountstate;
    
    private Integer state;
    
    private Integer wayid;
    
    private Integer brid;
    
    private Integer picid;
    
    private Integer userid;
    
    private Integer courid;
    
    private String downtime;

    private Recipients recipients;

    private Sender sender;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Recipients getRecipients() {
        return recipients;
    }

    public void setRecipients(Recipients recipients) {
        this.recipients = recipients;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
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

    public Integer getWayid() {
        return wayid;
    }

    public void setWayid(Integer wayid) {
        this.wayid = wayid;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public Integer getPicid() {
        return picid;
    }

    public void setPicid(Integer picid) {
        this.picid = picid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCourid() {
        return courid;
    }

    public void setCourid(Integer courid) {
        this.courid = courid;
    }

    public String getDowntime() {
        return downtime;
    }

    public void setDowntime(String downtime) {
        this.downtime = downtime;
    }

}