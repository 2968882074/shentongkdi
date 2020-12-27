package com.yidu.shentongkdi.entity;

import java.io.Serializable;

/**
 * (Freight)实体类
 *
 * @author makejava
 * @since 2020-12-27 12:11:48
 */
public class Freight implements Serializable {
    private static final long serialVersionUID = 849594267533644217L;
    
    private Integer tlid;
    
    private Integer trid;
    
    private Integer lid;


    public Integer getTlid() {
        return tlid;
    }

    public void setTlid(Integer tlid) {
        this.tlid = tlid;
    }

    public Integer getTrid() {
        return trid;
    }

    public void setTrid(Integer trid) {
        this.trid = trid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

}