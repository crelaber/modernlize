package com.uwen.ur.model.pojo.sys;

import java.util.Date;

public class UrFaqType {
    private String id;

    private String faqTypeCode;

    private String faqTypeName;

    private String faqTypeDesc;

    private String parentId;

    private String createUserId;

    private String createUserName;

    private String updateUserId;

    private String updateUserName;

    private Date addDatetime;

    private Date updateDatetime;

    private Integer enable;

    private Integer sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFaqTypeCode() {
        return faqTypeCode;
    }

    public void setFaqTypeCode(String faqTypeCode) {
        this.faqTypeCode = faqTypeCode == null ? null : faqTypeCode.trim();
    }

    public String getFaqTypeName() {
        return faqTypeName;
    }

    public void setFaqTypeName(String faqTypeName) {
        this.faqTypeName = faqTypeName == null ? null : faqTypeName.trim();
    }

    public String getFaqTypeDesc() {
        return faqTypeDesc;
    }

    public void setFaqTypeDesc(String faqTypeDesc) {
        this.faqTypeDesc = faqTypeDesc == null ? null : faqTypeDesc.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public Date getAddDatetime() {
        return addDatetime;
    }

    public void setAddDatetime(Date addDatetime) {
        this.addDatetime = addDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}