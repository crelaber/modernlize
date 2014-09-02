package com.uwen.ur.model.pojo.sys;

public class UrFaqFileRelKey {
    private String faqId;

    private String fileId;

    public String getFaqId() {
        return faqId;
    }

    public void setFaqId(String faqId) {
        this.faqId = faqId == null ? null : faqId.trim();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }
}