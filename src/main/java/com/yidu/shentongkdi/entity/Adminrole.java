package com.yidu.shentongkdi.entity;

import java.io.Serializable;

/**
 * (Adminrole)实体类
 *
 * @author makejava
 * @since 2021-01-12 10:48:23
 */
public class Adminrole implements Serializable {
    private static final long serialVersionUID = -95743937908317039L;
    
    private Integer adminrole;
    
    private Integer adminid;
    
    private Integer roleid;


    public Integer getAdminrole() {
        return adminrole;
    }

    public void setAdminrole(Integer adminrole) {
        this.adminrole = adminrole;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "Adminrole{" +
                "adminrole=" + adminrole +
                ", adminid=" + adminid +
                ", roleid=" + roleid +
                '}';
    }
}