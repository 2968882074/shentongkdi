package com.yidu.shentongkdi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * (Menuinfo)实体类
 *
 * @author makejava
 * @since 2020-12-29 14:28:49
 */
public class Menuinfo implements Serializable {
    private static final long serialVersionUID = 153877870627210881L;
    
    private String menuid;
    
    private String title;
    
    private Integer menustate;
    
    private String url;
    
    private String previd;
    
    private String iconcls;

    private List<Menuinfo> menulist;

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMenustate() {
        return menustate;
    }

    public void setMenustate(Integer menustate) {
        this.menustate = menustate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrevid() {
        return previd;
    }

    public void setPrevid(String previd) {
        this.previd = previd;
    }

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    public List<Menuinfo> getMenulist() {
        return menulist;
    }

    public void setMenulist(List<Menuinfo> menulist) {
        this.menulist = menulist;
    }

    @Override
    public String toString() {
        return "Menuinfo{" +
                "menuid='" + menuid + '\'' +
                ", title='" + title + '\'' +
                ", menustate=" + menustate +
                ", url='" + url + '\'' +
                ", previd='" + previd + '\'' +
                ", iconcls='" + iconcls + '\'' +
                ", menulist=" + menulist +
                '}';
    }
}