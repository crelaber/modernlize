package com.uwen.ur.model.pojo.sys;

import java.util.Date;

public class UrFaq {
    private String id;

    private String faqCode;

    private String question;

    private String answer;

    private Integer answerType;

    private String picturePathLast;

    private String picturePathAny;

    private String faqFileUrlAny;

    private String createUserId;

    private String createUserName;

    private String faqTypeId;

    private Long clickNum;

    private Long praiseNum;

    private Long debaseNum;

    private Long favNum;

    private Date addDatetime;

    private Date updateDatetime;

    private Date effectDatetime;

    private Date invalidDatetime;

    private Date lastUpdateDatetime;

    private String updateUserId;

    private String updateUserName;

    private Integer enable;

    private Integer sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFaqCode() {
        return faqCode;
    }

    public void setFaqCode(String faqCode) {
        this.faqCode = faqCode == null ? null : faqCode.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getAnswerType() {
        return answerType;
    }

    public void setAnswerType(Integer answerType) {
        this.answerType = answerType;
    }

    public String getPicturePathLast() {
        return picturePathLast;
    }

    public void setPicturePathLast(String picturePathLast) {
        this.picturePathLast = picturePathLast == null ? null : picturePathLast.trim();
    }

    public String getPicturePathAny() {
        return picturePathAny;
    }

    public void setPicturePathAny(String picturePathAny) {
        this.picturePathAny = picturePathAny == null ? null : picturePathAny.trim();
    }

    public String getFaqFileUrlAny() {
        return faqFileUrlAny;
    }

    public void setFaqFileUrlAny(String faqFileUrlAny) {
        this.faqFileUrlAny = faqFileUrlAny == null ? null : faqFileUrlAny.trim();
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

    public String getFaqTypeId() {
        return faqTypeId;
    }

    public void setFaqTypeId(String faqTypeId) {
        this.faqTypeId = faqTypeId == null ? null : faqTypeId.trim();
    }

    public Long getClickNum() {
        return clickNum;
    }

    public void setClickNum(Long clickNum) {
        this.clickNum = clickNum;
    }

    public Long getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Long praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Long getDebaseNum() {
        return debaseNum;
    }

    public void setDebaseNum(Long debaseNum) {
        this.debaseNum = debaseNum;
    }

    public Long getFavNum() {
        return favNum;
    }

    public void setFavNum(Long favNum) {
        this.favNum = favNum;
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

    public Date getEffectDatetime() {
        return effectDatetime;
    }

    public void setEffectDatetime(Date effectDatetime) {
        this.effectDatetime = effectDatetime;
    }

    public Date getInvalidDatetime() {
        return invalidDatetime;
    }

    public void setInvalidDatetime(Date invalidDatetime) {
        this.invalidDatetime = invalidDatetime;
    }

    public Date getLastUpdateDatetime() {
        return lastUpdateDatetime;
    }

    public void setLastUpdateDatetime(Date lastUpdateDatetime) {
        this.lastUpdateDatetime = lastUpdateDatetime;
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