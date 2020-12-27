package com.yidu.shentongkdi.entity;

import java.io.Serializable;

/**
 * (Line)实体类
 *
 * @author makejava
 * @since 2020-12-27 12:10:37
 */
public class Line implements Serializable {
    private static final long serialVersionUID = -31066904040745022L;
    
    private Integer lid;
    
    private Integer line;
    
    private String linename;
    
    private String linepath;


    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public String getLinename() {
        return linename;
    }

    public void setLinename(String linename) {
        this.linename = linename;
    }

    public String getLinepath() {
        return linepath;
    }

    public void setLinepath(String linepath) {
        this.linepath = linepath;
    }

}