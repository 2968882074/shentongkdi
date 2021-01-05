package com.yidu.shentongkdi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Driver)货车司机实体类
 *
 * @author makejava
 * @since 2021-01-04 15:09:17
 */
@Component
public class Driver implements Serializable {
    private static final long serialVersionUID = -15620743255830556L;

    private Integer tcid;

    private Integer trid;

    private Integer chanuffeurid;


    public Integer getTcid() {
        return tcid;
    }

    public void setTcid(Integer tcid) {
        this.tcid = tcid;
    }

    public Integer getTrid() {
        return trid;
    }

    public void setTrid(Integer trid) {
        this.trid = trid;
    }

    public Integer getChanuffeurid() {
        return chanuffeurid;
    }

    public void setChanuffeurid(Integer chanuffeurid) {
        this.chanuffeurid = chanuffeurid;
    }

}