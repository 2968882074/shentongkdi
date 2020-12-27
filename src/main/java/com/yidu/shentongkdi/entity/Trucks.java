package com.yidu.shentongkdi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Trucks)货车管理表的实体类
 *
 * @author makejava
 * @since 2020-12-27 12:12:12
 */
@Component
public class Trucks implements Serializable {
    private static final long serialVersionUID = 566136011521788160L;
    
    private Integer trid;
    
    private Integer vehiclechoice;
    
    private String license;
    
    private String commoncarrier;
    
    private String vehiclemodel;
    
    private String control;


    public Integer getTrid() {
        return trid;
    }

    public void setTrid(Integer trid) {
        this.trid = trid;
    }

    public Integer getVehiclechoice() {
        return vehiclechoice;
    }

    public void setVehiclechoice(Integer vehiclechoice) {
        this.vehiclechoice = vehiclechoice;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCommoncarrier() {
        return commoncarrier;
    }

    public void setCommoncarrier(String commoncarrier) {
        this.commoncarrier = commoncarrier;
    }

    public String getVehiclemodel() {
        return vehiclemodel;
    }

    public void setVehiclemodel(String vehiclemodel) {
        this.vehiclemodel = vehiclemodel;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    @Override
    public String toString() {
        return "Trucks{" +
                "trid=" + trid +
                ", vehiclechoice=" + vehiclechoice +
                ", license='" + license + '\'' +
                ", commoncarrier='" + commoncarrier + '\'' +
                ", vehiclemodel='" + vehiclemodel + '\'' +
                ", control='" + control + '\'' +
                '}';
    }

    public Trucks() {
    }

    public Trucks(Integer vehiclechoice, String license, String commoncarrier, String vehiclemodel, String control) {
        this.vehiclechoice = vehiclechoice;
        this.license = license;
        this.commoncarrier = commoncarrier;
        this.vehiclemodel = vehiclemodel;
        this.control = control;
    }

    public Trucks(Integer trid, Integer vehiclechoice, String license, String commoncarrier, String vehiclemodel, String control) {
        this.trid = trid;
        this.vehiclechoice = vehiclechoice;
        this.license = license;
        this.commoncarrier = commoncarrier;
        this.vehiclemodel = vehiclemodel;
        this.control = control;
    }
}