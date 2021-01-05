package com.yidu.shentongkdi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Totalwatehouse)实体类
 *
 * @author makejava
 * @since 2020-12-28 14:56:39
 */
@Component
public class Totalwatehouse implements Serializable {
    private static final long serialVersionUID = -83450510768166476L;
    
    private Integer twid;
    
    private String twname;
    
    private String twtime;
    
    private Integer state;
    
    private String code;


    public Integer getTwid() {
        return twid;
    }

    public void setTwid(Integer twid) {
        this.twid = twid;
    }

    public String getTwname() {
        return twname;
    }

    public void setTwname(String twname) {
        this.twname = twname;
    }

    public String getTwtime() {
        return twtime;
    }

    public void setTwtime(String twtime) {
        this.twtime = twtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Totalwatehouse() {
    }

    public Totalwatehouse(Integer twid, String twname, String twtime, Integer state, String code) {
        this.twid = twid;
        this.twname = twname;
        this.twtime = twtime;
        this.state = state;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Totalwatehouse{" +
                "twid=" + twid +
                ", twname='" + twname + '\'' +
                ", twtime='" + twtime + '\'' +
                ", state=" + state +
                ", code='" + code + '\'' +
                '}';
    }
}