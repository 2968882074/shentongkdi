package com.yidu.shentongkdi.entity;

import java.io.Serializable;

/**
 * (Rolemenu)实体类
 *
 * @author makejava
 * @since 2021-01-11 08:40:47
 */
public class Rolemenu implements Serializable {
    private static final long serialVersionUID = 809472822751507263L;
    
    private Integer rolemenu;
    
    private Integer roleid;
    
    private String menuid;


    public Integer getRolemenu() {
        return rolemenu;
    }

    public void setRolemenu(Integer rolemenu) {
        this.rolemenu = rolemenu;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    @Override
    public String toString() {
        return "Rolemenu{" +
                "rolemenu=" + rolemenu +
                ", roleid=" + roleid +
                ", menuid='" + menuid + '\'' +
                '}';
    }
}