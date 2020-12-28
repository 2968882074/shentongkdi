package com.yidu.shentongkdi.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-12-28 13:45:32
 */
public class User implements Serializable {
    private static final long serialVersionUID = 499511146029465221L;
    
    private Integer userid;
    
    private String username;
    
    private String userpass;
    
    private String uphone;
    
    private String sex;
    
    private String age;
    
    private String chinaname;
    
    private String chinald;
    
    private String address;
    
    private String nation;


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getChinaname() {
        return chinaname;
    }

    public void setChinaname(String chinaname) {
        this.chinaname = chinaname;
    }

    public String getChinald() {
        return chinald;
    }

    public void setChinald(String chinald) {
        this.chinald = chinald;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

}