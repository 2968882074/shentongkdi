package com.yidu.shentongkdi.entity;

import org.springframework.stereotype.Controller;

import java.io.Serializable;

/**
 * (Freight)货车线路表的实体类
 *
 * @author makejava
 * @since 2020-12-27 12:11:48
 */
@Controller
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

    public Freight() {
    }

    public Freight(Integer tlid, Integer trid, Integer lid) {
        this.tlid = tlid;
        this.trid = trid;
        this.lid = lid;
    }

    public Freight(Integer trid, Integer lid) {
        this.trid = trid;
        this.lid = lid;
    }

    @Override
    public String toString() {
        return "Freight{" +
                "tlid=" + tlid +
                ", trid=" + trid +
                ", lid=" + lid +
                '}';
    }
}