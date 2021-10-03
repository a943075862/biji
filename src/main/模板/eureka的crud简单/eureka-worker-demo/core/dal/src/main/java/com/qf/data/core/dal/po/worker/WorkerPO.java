package com.qf.data.core.dal.po.worker;

import java.util.Date;

public class WorkerPO {
    private Long id;

    private String name;

    private Boolean gender;

    private Integer age;

    private Boolean workType;

    private Boolean status;

    private Boolean flag;

    private Date gmtModified;

    private Date gmtCreated;

    private Boolean isDeleted;

    private Integer depId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getWorkType() {
        return workType;
    }

    public void setWorkType(Boolean workType) {
        this.workType = workType;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", workType=" + workType +
                ", status=" + status +
                ", flag=" + flag +
                ", gmtModified=" + gmtModified +
                ", gmtCreated=" + gmtCreated +
                ", isDeleted=" + isDeleted +
                ", depId=" + depId +
                '}';
    }
}