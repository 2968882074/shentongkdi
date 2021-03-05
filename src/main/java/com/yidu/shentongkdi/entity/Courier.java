package com.yidu.shentongkdi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Courier)实体类
 *
 * @author makejava
 * @since 2021-01-08 13:58:36
 */
@Component
public class Courier implements Serializable {
    private static final long serialVersionUID = -46508741435222396L;
    
    private Integer courid;
    
    private Integer userid;
    
    private String couname;
    
    private String worknumber;
    
    private String phonenumber;
    
    private String couaddress;


    public Integer getCourid() {
        return courid;
    }

    public void setCourid(Integer courid) {
        this.courid = courid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getCouname() {
        return couname;
    }

    public void setCouname(String couname) {
        this.couname = couname;
    }

    public String getWorknumber() {
        return worknumber;
    }

    public void setWorknumber(String worknumber) {
        this.worknumber = worknumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCouaddress() {
        return couaddress;
    }

    public void setCouaddress(String couaddress) {
        this.couaddress = couaddress;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "courid=" + courid +
                ", userid=" + userid +
                ", couname='" + couname + '\'' +
                ", worknumber='" + worknumber + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", couaddress='" + couaddress + '\'' +
                '}';
    }
}