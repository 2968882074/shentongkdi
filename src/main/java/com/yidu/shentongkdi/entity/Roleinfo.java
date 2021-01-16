package com.yidu.shentongkdi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (Roleinfo)实体类
 *
 * @author makejava
 * @since 2020-12-29 14:28:49
 */
public class Roleinfo implements Serializable {
    private static final long serialVersionUID = -69955605481789772L;

    private Integer roleid;

    private String rolename;

    private Integer rolegroup;

    private Integer rolestate;

    private List<Menuinfo> menulist;


    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Integer getRolegroup() {
        return rolegroup;
    }

    public void setRolegroup(Integer rolegroup) {
        this.rolegroup = rolegroup;
    }

    public Integer getRolestate() {
        return rolestate;
    }

    public void setRolestate(Integer rolestate) {
        this.rolestate = rolestate;
    }

    public List<Menuinfo> getMenulist() {
        return menulist;
    }

    public void setMenulist(List<Menuinfo> menulist) {
        this.menulist = menulist;
    }

    @Override
    public String toString() {
        return "Roleinfo{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", rolegroup=" + rolegroup +
                ", rolestate=" + rolestate +
                ", menulist=" + menulist +
                '}';
    }
}