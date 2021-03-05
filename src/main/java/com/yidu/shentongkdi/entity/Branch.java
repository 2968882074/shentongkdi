package com.yidu.shentongkdi.entity;

import java.io.Serializable;

/**
 * (Branch)实体类
 *
 * @author makejava
 * @since 2021-03-05 10:15:52
 */
public class Branch implements Serializable {
    private static final long serialVersionUID = 324460613389974177L;
    
    private Integer brid;
    
    private String branchname;
    
    private String brname;
    
    private String brpone;
    
    private String postcode;
    
    private String business;
    
    private String branchtype;
    
    private String idnumber;
    
    private String unusualpone;
    
    private String nextnumber;
    
    private String subordinate;
    
    private String brnumberpone;
    
    private String workaddress;
    
    private String applicationdate;
    
    private String approvaltime;
    
    private String examineresult;
    
    private Integer userid;


    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getBrname() {
        return brname;
    }

    public void setBrname(String brname) {
        this.brname = brname;
    }

    public String getBrpone() {
        return brpone;
    }

    public void setBrpone(String brpone) {
        this.brpone = brpone;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getBranchtype() {
        return branchtype;
    }

    public void setBranchtype(String branchtype) {
        this.branchtype = branchtype;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getUnusualpone() {
        return unusualpone;
    }

    public void setUnusualpone(String unusualpone) {
        this.unusualpone = unusualpone;
    }

    public String getNextnumber() {
        return nextnumber;
    }

    public void setNextnumber(String nextnumber) {
        this.nextnumber = nextnumber;
    }

    public String getSubordinate() {
        return subordinate;
    }

    public void setSubordinate(String subordinate) {
        this.subordinate = subordinate;
    }

    public String getBrnumberpone() {
        return brnumberpone;
    }

    public void setBrnumberpone(String brnumberpone) {
        this.brnumberpone = brnumberpone;
    }

    public String getWorkaddress() {
        return workaddress;
    }

    public void setWorkaddress(String workaddress) {
        this.workaddress = workaddress;
    }

    public String getApplicationdate() {
        return applicationdate;
    }

    public void setApplicationdate(String applicationdate) {
        this.applicationdate = applicationdate;
    }

    public String getApprovaltime() {
        return approvaltime;
    }

    public void setApprovaltime(String approvaltime) {
        this.approvaltime = approvaltime;
    }

    public String getExamineresult() {
        return examineresult;
    }

    public void setExamineresult(String examineresult) {
        this.examineresult = examineresult;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

}