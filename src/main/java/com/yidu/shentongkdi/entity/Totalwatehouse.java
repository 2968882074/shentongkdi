package com.yidu.shentongkdi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Totalwatehouse)实体类
 *
 * @author makejava
 * @since 2021-03-04 14:00:11
 */
@Component
public class Totalwatehouse implements Serializable {
    private static final long serialVersionUID = -72297688988643500L;
    
    private Integer twid;
    
    private String twname;
    
    private String entertwtime;
    
    private String gotime;
    
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

    public String getEntertwtime() {
        return entertwtime;
    }

    public void setEntertwtime(String entertwtime) {
        this.entertwtime = entertwtime;
    }

    public String getGotime() {
        return gotime;
    }

    public void setGotime(String gotime) {
        this.gotime = gotime;
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

    @Override
    public String toString() {
        return "Totalwatehouse{" +
                "twid=" + twid +
                ", twname='" + twname + '\'' +
                ", entertwtime='" + entertwtime + '\'' +
                ", gotime='" + gotime + '\'' +
                ", state=" + state +
                ", code='" + code + '\'' +
                '}';
    }
}