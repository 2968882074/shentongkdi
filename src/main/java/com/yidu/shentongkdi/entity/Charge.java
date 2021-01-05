package com.yidu.shentongkdi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Charge)实体类
 *
 * @author makejava
 * @since 2021-01-04 15:37:33
 */
@Component
public class Charge implements Serializable {
    private static final long serialVersionUID = 805728301987666096L;
    
    private Integer chid;
    
    private String chargename;
    
    private String weight;
    
    private String distanc;
    
    private String operationstaff;
    
    private String unit;
    
    private String chargetime;

    public Charge() {
    }

    public Charge(Integer chid, String chargename, String weight, String distanc, String operationstaff, String unit, String chargetime) {
        this.chid = chid;
        this.chargename = chargename;
        this.weight = weight;
        this.distanc = distanc;
        this.operationstaff = operationstaff;
        this.unit = unit;
        this.chargetime = chargetime;
    }

    public Integer getChid() {
        return chid;
    }

    public void setChid(Integer chid) {
        this.chid = chid;
    }

    public String getChargename() {
        return chargename;
    }

    public void setChargename(String chargename) {
        this.chargename = chargename;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDistanc() {
        return distanc;
    }

    public void setDistanc(String distanc) {
        this.distanc = distanc;
    }

    public String getOperationstaff() {
        return operationstaff;
    }

    public void setOperationstaff(String operationstaff) {
        this.operationstaff = operationstaff;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getChargetime() {
        return chargetime;
    }

    public void setChargetime(String chargetime) {
        this.chargetime = chargetime;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "chid=" + chid +
                ", chargename='" + chargename + '\'' +
                ", weight='" + weight + '\'' +
                ", distanc='" + distanc + '\'' +
                ", operationstaff='" + operationstaff + '\'' +
                ", unit='" + unit + '\'' +
                ", chargetime='" + chargetime + '\'' +
                '}';
    }


}