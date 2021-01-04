package com.yidu.shentongkdi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2020-12-29 13:51:42
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = 827990816352582174L;
    
    private Integer adminid;
    
    private String adminname;
    
    private String adminpass;
    
    private String compellation;
    
    private String adminimg;
    
    private Integer state;

    private List<Roleinfo> rolelist;


    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpass() {
        return adminpass;
    }

    public void setAdminpass(String adminpass) {
        this.adminpass = adminpass;
    }

    public String getCompellation() {
        return compellation;
    }

    public void setCompellation(String compellation) {
        this.compellation = compellation;
    }

    public String getAdminimg() {
        return adminimg;
    }

    public void setAdminimg(String adminimg) {
        this.adminimg = adminimg;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<Roleinfo> getRolelist() {
        return rolelist;
    }

    public void setRolelist(List<Roleinfo> rolelist) {
        this.rolelist = rolelist;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminid=" + adminid +
                ", adminname='" + adminname + '\'' +
                ", adminpass='" + adminpass + '\'' +
                ", compellation='" + compellation + '\'' +
                ", adminimg='" + adminimg + '\'' +
                ", state=" + state +
                ", rolelist=" + rolelist +
                '}';
    }
}