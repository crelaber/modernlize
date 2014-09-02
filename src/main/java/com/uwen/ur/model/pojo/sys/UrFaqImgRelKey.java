package com.uwen.ur.model.pojo.sys;

public class UrFaqImgRelKey {
    private String faqId;

    private String imgId;

    public String getFaqId() {
        return faqId;
    }

    public void setFaqId(String faqId) {
        this.faqId = faqId == null ? null : faqId.trim();
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId == null ? null : imgId.trim();
    }
}