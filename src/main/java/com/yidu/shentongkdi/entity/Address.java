package com.yidu.shentongkdi.entity;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Address)实体类
 *
 * @author makejava
 * @since 2021-01-07 14:00:17
 */
@Mapper
@Component
public class Address implements Serializable {
    private static final long serialVersionUID = -99872768161518128L;
    
    private Integer aid;
    
    private String aname;
    
    private String phone;
    
    private String phonespecial;
    
    private String alevel;
    
    private String detail;
    
    private Integer userid;


    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhonespecial() {
        return phonespecial;
    }

    public void setPhonespecial(String phonespecial) {
        this.phonespecial = phonespecial;
    }

    public String getAlevel() {
        return alevel;
    }

    public void setAlevel(String alevel) {
        this.alevel = alevel;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", phone='" + phone + '\'' +
                ", phonespecial='" + phonespecial + '\'' +
                ", alevel='" + alevel + '\'' +
                ", detail='" + detail + '\'' +
                ", userid=" + userid +
                '}';
    }
}