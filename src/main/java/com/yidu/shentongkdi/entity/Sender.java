package com.yidu.shentongkdi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Sender)实体类
 *
 * @author makejava
 * @since 2021-01-11 11:00:58
 */
@Component
public class Sender implements Serializable {
    private static final long serialVersionUID = -16369159201327479L;
    
    private Integer seid;
    
    private String sname;
    
    private String saddress;
    
    private String slandline;
    
    private String sphone;
    
    private String sdetailedaddress;
    
    private String spayment;
    
    private String semail;
    
    private String sendertime;


    public Integer getSeid() {
        return seid;
    }

    public void setSeid(Integer seid) {
        this.seid = seid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getSlandline() {
        return slandline;
    }

    public void setSlandline(String slandline) {
        this.slandline = slandline;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSdetailedaddress() {
        return sdetailedaddress;
    }

    public void setSdetailedaddress(String sdetailedaddress) {
        this.sdetailedaddress = sdetailedaddress;
    }

    public String getSpayment() {
        return spayment;
    }

    public void setSpayment(String spayment) {
        this.spayment = spayment;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getSendertime() {
        return sendertime;
    }

    public void setSendertime(String sendertime) {
        this.sendertime = sendertime;
    }

    @Override
    public String toString() {
        return "Sender{" +
                "seid=" + seid +
                ", sname='" + sname + '\'' +
                ", saddress='" + saddress + '\'' +
                ", slandline='" + slandline + '\'' +
                ", sphone='" + sphone + '\'' +
                ", sdetailedaddress='" + sdetailedaddress + '\'' +
                ", spayment='" + spayment + '\'' +
                ", semail='" + semail + '\'' +
                ", sendertime='" + sendertime + '\'' +
                '}';
    }
}