package com.yidu.shentongkdi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Waybill)运单表实体类
 *
 * @author makejava
 * @since 2021-01-29 14:56:13
 */
@Component
public class Waybill implements Serializable {
    private static final long serialVersionUID = 434696236110286749L;

    
    private String wnumber;
    
    private String wstate;
    
    private String wtime;



    public String getWnumber() {
        return wnumber;
    }

    public void setWnumber(String wnumber) {
        this.wnumber = wnumber;
    }

    public String getWstate() {
        return wstate;
    }

    public void setWstate(String wstate) {
        this.wstate = wstate;
    }

    public String getWtime() {
        return wtime;
    }

    public void setWtime(String wtime) {
        this.wtime = wtime;
    }

    public Waybill( String wnumber, String wstate, String wtime) {
        this.wnumber = wnumber;
        this.wstate = wstate;
        this.wtime = wtime;
    }


    public Waybill() {
    }

    @Override
    public String toString() {
        return "Waybill{" +
                ", wnumber='" + wnumber + '\'' +
                ", wstate='" + wstate + '\'' +
                ", wtime='" + wtime + '\'' +
                '}';
    }
}