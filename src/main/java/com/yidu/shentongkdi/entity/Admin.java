package com.yidu.shentongkdi.entity;

import org.springframework.stereotype.Controller;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2020-12-13 17:56:17
 */
@Controller
public class Admin implements Serializable {
    private static final long serialVersionUID = -74133084323957476L;
    
    private Integer adminid;
    
    private String adminname;
    
    private String adminpass;
    
    private String compellation;
    
    private Integer state;


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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}