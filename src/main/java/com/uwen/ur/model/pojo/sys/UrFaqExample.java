package com.uwen.ur.model.pojo.sys;

import com.uwen.ur.util.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UrFaqExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public UrFaqExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFaqCodeIsNull() {
            addCriterion("FAQ_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFaqCodeIsNotNull() {
            addCriterion("FAQ_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFaqCodeEqualTo(String value) {
            addCriterion("FAQ_CODE =", value, "faqCode");
            return (Criteria) this;
        }

        public Criteria andFaqCodeNotEqualTo(String value) {
            addCriterion("FAQ_CODE <>", value, "faqCode");
            return (Criteria) this;
        }

        public Criteria andFaqCodeGreaterThan(String value) {
            addCriterion("FAQ_CODE >", value, "faqCode");
            return (Criteria) this;
        }

        public Criteria andFaqCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FAQ_CODE >=", value, "faqCode");
            return (Criteria) this;
        }

        public Criteria andFaqCodeLessThan(String value) {
            addCriterion("FAQ_CODE <", value, "faqCode");
            return (Criteria) this;
        }

        public Criteria andFaqCodeLessThanOrEqualTo(String value) {
            addCriterion("FAQ_CODE <=", value, "faqCode");
            return (Criteria) this;
        }

        public Criteria andFaqCodeLike(String value) {
            addCriterion("FAQ_CODE like", value, "faqCode");
            return (Criteria) this;
        }

        public Criteria andFaqCodeNotLike(String value) {
            addCriterion("FAQ_CODE not like", value, "faqCode");
            return (Criteria) this;
        }

        public Criteria andFaqCodeIn(List<String> values) {
            addCriterion("FAQ_CODE in", values, "faqCode");
            return (Criteria) this;
        }

        public Criteria andFaqCodeNotIn(List<String> values) {
            addCriterion("FAQ_CODE not in", values, "faqCode");
            return (Criteria) this;
        }

        public Criteria andFaqCodeBetween(String value1, String value2) {
            addCriterion("FAQ_CODE between", value1, value2, "faqCode");
            return (Criteria) this;
        }

        public Criteria andFaqCodeNotBetween(String value1, String value2) {
            addCriterion("FAQ_CODE not between", value1, value2, "faqCode");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNull() {
            addCriterion("QUESTION is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNotNull() {
            addCriterion("QUESTION is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionEqualTo(String value) {
            addCriterion("QUESTION =", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotEqualTo(String value) {
            addCriterion("QUESTION <>", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThan(String value) {
            addCriterion("QUESTION >", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION >=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThan(String value) {
            addCriterion("QUESTION <", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThanOrEqualTo(String value) {
            addCriterion("QUESTION <=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLike(String value) {
            addCriterion("QUESTION like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotLike(String value) {
            addCriterion("QUESTION not like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionIn(List<String> values) {
            addCriterion("QUESTION in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotIn(List<String> values) {
            addCriterion("QUESTION not in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionBetween(String value1, String value2) {
            addCriterion("QUESTION between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotBetween(String value1, String value2) {
            addCriterion("QUESTION not between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("ANSWER is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("ANSWER is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("ANSWER =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("ANSWER <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("ANSWER >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("ANSWER >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("ANSWER <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("ANSWER <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("ANSWER like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("ANSWER not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("ANSWER in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("ANSWER not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("ANSWER between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("ANSWER not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeIsNull() {
            addCriterion("ANSWER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeIsNotNull() {
            addCriterion("ANSWER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeEqualTo(Integer value) {
            addCriterion("ANSWER_TYPE =", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeNotEqualTo(Integer value) {
            addCriterion("ANSWER_TYPE <>", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeGreaterThan(Integer value) {
            addCriterion("ANSWER_TYPE >", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ANSWER_TYPE >=", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeLessThan(Integer value) {
            addCriterion("ANSWER_TYPE <", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ANSWER_TYPE <=", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeIn(List<Integer> values) {
            addCriterion("ANSWER_TYPE in", values, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeNotIn(List<Integer> values) {
            addCriterion("ANSWER_TYPE not in", values, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeBetween(Integer value1, Integer value2) {
            addCriterion("ANSWER_TYPE between", value1, value2, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ANSWER_TYPE not between", value1, value2, "answerType");
            return (Criteria) this;
        }

        public Criteria andPicturePathLastIsNull() {
            addCriterion("PICTURE_PATH_LAST is null");
            return (Criteria) this;
        }

        public Criteria andPicturePathLastIsNotNull() {
            addCriterion("PICTURE_PATH_LAST is not null");
            return (Criteria) this;
        }

        public Criteria andPicturePathLastEqualTo(String value) {
            addCriterion("PICTURE_PATH_LAST =", value, "picturePathLast");
            return (Criteria) this;
        }

        public Criteria andPicturePathLastNotEqualTo(String value) {
            addCriterion("PICTURE_PATH_LAST <>", value, "picturePathLast");
            return (Criteria) this;
        }

        public Criteria andPicturePathLastGreaterThan(String value) {
            addCriterion("PICTURE_PATH_LAST >", value, "picturePathLast");
            return (Criteria) this;
        }

        public Criteria andPicturePathLastGreaterThanOrEqualTo(String value) {
            addCriterion("PICTURE_PATH_LAST >=", value, "picturePathLast");
            return (Criteria) this;
        }

        public Criteria andPicturePathLastLessThan(String value) {
            addCriterion("PICTURE_PATH_LAST <", value, "picturePathLast");
            return (Criteria) this;
        }

        public Criteria andPicturePathLastLessThanOrEqualTo(String value) {
            addCriterion("PICTURE_PATH_LAST <=", value, "picturePathLast");
            return (Criteria) this;
        }

        public Criteria andPicturePathLastLike(String value) {
            addCriterion("PICTURE_PATH_LAST like", value, "picturePathLast");
            return (Criteria) this;
        }

        public Criteria andPicturePathLastNotLike(String value) {
            addCriterion("PICTURE_PATH_LAST not like", value, "picturePathLast");
            return (Criteria) this;
        }

        public Criteria andPicturePathLastIn(List<String> values) {
            addCriterion("PICTURE_PATH_LAST in", values, "picturePathLast");
            return (Criteria) this;
        }

        public Criteria andPicturePathLastNotIn(List<String> values) {
            addCriterion("PICTURE_PATH_LAST not in", values, "picturePathLast");
            return (Criteria) this;
        }

        public Criteria andPicturePathLastBetween(String value1, String value2) {
            addCriterion("PICTURE_PATH_LAST between", value1, value2, "picturePathLast");
            return (Criteria) this;
        }

        public Criteria andPicturePathLastNotBetween(String value1, String value2) {
            addCriterion("PICTURE_PATH_LAST not between", value1, value2, "picturePathLast");
            return (Criteria) this;
        }

        public Criteria andPicturePathAnyIsNull() {
            addCriterion("PICTURE_PATH_ANY is null");
            return (Criteria) this;
        }

        public Criteria andPicturePathAnyIsNotNull() {
            addCriterion("PICTURE_PATH_ANY is not null");
            return (Criteria) this;
        }

        public Criteria andPicturePathAnyEqualTo(String value) {
            addCriterion("PICTURE_PATH_ANY =", value, "picturePathAny");
            return (Criteria) this;
        }

        public Criteria andPicturePathAnyNotEqualTo(String value) {
            addCriterion("PICTURE_PATH_ANY <>", value, "picturePathAny");
            return (Criteria) this;
        }

        public Criteria andPicturePathAnyGreaterThan(String value) {
            addCriterion("PICTURE_PATH_ANY >", value, "picturePathAny");
            return (Criteria) this;
        }

        public Criteria andPicturePathAnyGreaterThanOrEqualTo(String value) {
            addCriterion("PICTURE_PATH_ANY >=", value, "picturePathAny");
            return (Criteria) this;
        }

        public Criteria andPicturePathAnyLessThan(String value) {
            addCriterion("PICTURE_PATH_ANY <", value, "picturePathAny");
            return (Criteria) this;
        }

        public Criteria andPicturePathAnyLessThanOrEqualTo(String value) {
            addCriterion("PICTURE_PATH_ANY <=", value, "picturePathAny");
            return (Criteria) this;
        }

        public Criteria andPicturePathAnyLike(String value) {
            addCriterion("PICTURE_PATH_ANY like", value, "picturePathAny");
            return (Criteria) this;
        }

        public Criteria andPicturePathAnyNotLike(String value) {
            addCriterion("PICTURE_PATH_ANY not like", value, "picturePathAny");
            return (Criteria) this;
        }

        public Criteria andPicturePathAnyIn(List<String> values) {
            addCriterion("PICTURE_PATH_ANY in", values, "picturePathAny");
            return (Criteria) this;
        }

        public Criteria andPicturePathAnyNotIn(List<String> values) {
            addCriterion("PICTURE_PATH_ANY not in", values, "picturePathAny");
            return (Criteria) this;
        }

        public Criteria andPicturePathAnyBetween(String value1, String value2) {
            addCriterion("PICTURE_PATH_ANY between", value1, value2, "picturePathAny");
            return (Criteria) this;
        }

        public Criteria andPicturePathAnyNotBetween(String value1, String value2) {
            addCriterion("PICTURE_PATH_ANY not between", value1, value2, "picturePathAny");
            return (Criteria) this;
        }

        public Criteria andFaqFileUrlAnyIsNull() {
            addCriterion("FAQ_FILE_URL_ANY is null");
            return (Criteria) this;
        }

        public Criteria andFaqFileUrlAnyIsNotNull() {
            addCriterion("FAQ_FILE_URL_ANY is not null");
            return (Criteria) this;
        }

        public Criteria andFaqFileUrlAnyEqualTo(String value) {
            addCriterion("FAQ_FILE_URL_ANY =", value, "faqFileUrlAny");
            return (Criteria) this;
        }

        public Criteria andFaqFileUrlAnyNotEqualTo(String value) {
            addCriterion("FAQ_FILE_URL_ANY <>", value, "faqFileUrlAny");
            return (Criteria) this;
        }

        public Criteria andFaqFileUrlAnyGreaterThan(String value) {
            addCriterion("FAQ_FILE_URL_ANY >", value, "faqFileUrlAny");
            return (Criteria) this;
        }

        public Criteria andFaqFileUrlAnyGreaterThanOrEqualTo(String value) {
            addCriterion("FAQ_FILE_URL_ANY >=", value, "faqFileUrlAny");
            return (Criteria) this;
        }

        public Criteria andFaqFileUrlAnyLessThan(String value) {
            addCriterion("FAQ_FILE_URL_ANY <", value, "faqFileUrlAny");
            return (Criteria) this;
        }

        public Criteria andFaqFileUrlAnyLessThanOrEqualTo(String value) {
            addCriterion("FAQ_FILE_URL_ANY <=", value, "faqFileUrlAny");
            return (Criteria) this;
        }

        public Criteria andFaqFileUrlAnyLike(String value) {
            addCriterion("FAQ_FILE_URL_ANY like", value, "faqFileUrlAny");
            return (Criteria) this;
        }

        public Criteria andFaqFileUrlAnyNotLike(String value) {
            addCriterion("FAQ_FILE_URL_ANY not like", value, "faqFileUrlAny");
            return (Criteria) this;
        }

        public Criteria andFaqFileUrlAnyIn(List<String> values) {
            addCriterion("FAQ_FILE_URL_ANY in", values, "faqFileUrlAny");
            return (Criteria) this;
        }

        public Criteria andFaqFileUrlAnyNotIn(List<String> values) {
            addCriterion("FAQ_FILE_URL_ANY not in", values, "faqFileUrlAny");
            return (Criteria) this;
        }

        public Criteria andFaqFileUrlAnyBetween(String value1, String value2) {
            addCriterion("FAQ_FILE_URL_ANY between", value1, value2, "faqFileUrlAny");
            return (Criteria) this;
        }

        public Criteria andFaqFileUrlAnyNotBetween(String value1, String value2) {
            addCriterion("FAQ_FILE_URL_ANY not between", value1, value2, "faqFileUrlAny");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("CREATE_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("CREATE_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("CREATE_USER_ID =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("CREATE_USER_ID <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("CREATE_USER_ID >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_ID >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("CREATE_USER_ID <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_ID <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("CREATE_USER_ID like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("CREATE_USER_ID not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("CREATE_USER_ID in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("CREATE_USER_ID not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("CREATE_USER_ID between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER_ID not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNull() {
            addCriterion("CREATE_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("CREATE_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("CREATE_USER_NAME =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("CREATE_USER_NAME <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("CREATE_USER_NAME >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_NAME >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("CREATE_USER_NAME <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_NAME <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("CREATE_USER_NAME like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("CREATE_USER_NAME not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(List<String> values) {
            addCriterion("CREATE_USER_NAME in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(List<String> values) {
            addCriterion("CREATE_USER_NAME not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("CREATE_USER_NAME between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER_NAME not between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIdIsNull() {
            addCriterion("FAQ_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIdIsNotNull() {
            addCriterion("FAQ_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIdEqualTo(String value) {
            addCriterion("FAQ_TYPE_ID =", value, "faqTypeId");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIdNotEqualTo(String value) {
            addCriterion("FAQ_TYPE_ID <>", value, "faqTypeId");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIdGreaterThan(String value) {
            addCriterion("FAQ_TYPE_ID >", value, "faqTypeId");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("FAQ_TYPE_ID >=", value, "faqTypeId");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIdLessThan(String value) {
            addCriterion("FAQ_TYPE_ID <", value, "faqTypeId");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIdLessThanOrEqualTo(String value) {
            addCriterion("FAQ_TYPE_ID <=", value, "faqTypeId");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIdLike(String value) {
            addCriterion("FAQ_TYPE_ID like", value, "faqTypeId");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIdNotLike(String value) {
            addCriterion("FAQ_TYPE_ID not like", value, "faqTypeId");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIdIn(List<String> values) {
            addCriterion("FAQ_TYPE_ID in", values, "faqTypeId");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIdNotIn(List<String> values) {
            addCriterion("FAQ_TYPE_ID not in", values, "faqTypeId");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIdBetween(String value1, String value2) {
            addCriterion("FAQ_TYPE_ID between", value1, value2, "faqTypeId");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIdNotBetween(String value1, String value2) {
            addCriterion("FAQ_TYPE_ID not between", value1, value2, "faqTypeId");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNull() {
            addCriterion("CLICK_NUM is null");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNotNull() {
            addCriterion("CLICK_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andClickNumEqualTo(Long value) {
            addCriterion("CLICK_NUM =", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotEqualTo(Long value) {
            addCriterion("CLICK_NUM <>", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThan(Long value) {
            addCriterion("CLICK_NUM >", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThanOrEqualTo(Long value) {
            addCriterion("CLICK_NUM >=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThan(Long value) {
            addCriterion("CLICK_NUM <", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThanOrEqualTo(Long value) {
            addCriterion("CLICK_NUM <=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumIn(List<Long> values) {
            addCriterion("CLICK_NUM in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotIn(List<Long> values) {
            addCriterion("CLICK_NUM not in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumBetween(Long value1, Long value2) {
            addCriterion("CLICK_NUM between", value1, value2, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotBetween(Long value1, Long value2) {
            addCriterion("CLICK_NUM not between", value1, value2, "clickNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumIsNull() {
            addCriterion("PRAISE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andPraiseNumIsNotNull() {
            addCriterion("PRAISE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseNumEqualTo(Long value) {
            addCriterion("PRAISE_NUM =", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumNotEqualTo(Long value) {
            addCriterion("PRAISE_NUM <>", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumGreaterThan(Long value) {
            addCriterion("PRAISE_NUM >", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumGreaterThanOrEqualTo(Long value) {
            addCriterion("PRAISE_NUM >=", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumLessThan(Long value) {
            addCriterion("PRAISE_NUM <", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumLessThanOrEqualTo(Long value) {
            addCriterion("PRAISE_NUM <=", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumIn(List<Long> values) {
            addCriterion("PRAISE_NUM in", values, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumNotIn(List<Long> values) {
            addCriterion("PRAISE_NUM not in", values, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumBetween(Long value1, Long value2) {
            addCriterion("PRAISE_NUM between", value1, value2, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumNotBetween(Long value1, Long value2) {
            addCriterion("PRAISE_NUM not between", value1, value2, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andDebaseNumIsNull() {
            addCriterion("DEBASE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andDebaseNumIsNotNull() {
            addCriterion("DEBASE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andDebaseNumEqualTo(Long value) {
            addCriterion("DEBASE_NUM =", value, "debaseNum");
            return (Criteria) this;
        }

        public Criteria andDebaseNumNotEqualTo(Long value) {
            addCriterion("DEBASE_NUM <>", value, "debaseNum");
            return (Criteria) this;
        }

        public Criteria andDebaseNumGreaterThan(Long value) {
            addCriterion("DEBASE_NUM >", value, "debaseNum");
            return (Criteria) this;
        }

        public Criteria andDebaseNumGreaterThanOrEqualTo(Long value) {
            addCriterion("DEBASE_NUM >=", value, "debaseNum");
            return (Criteria) this;
        }

        public Criteria andDebaseNumLessThan(Long value) {
            addCriterion("DEBASE_NUM <", value, "debaseNum");
            return (Criteria) this;
        }

        public Criteria andDebaseNumLessThanOrEqualTo(Long value) {
            addCriterion("DEBASE_NUM <=", value, "debaseNum");
            return (Criteria) this;
        }

        public Criteria andDebaseNumIn(List<Long> values) {
            addCriterion("DEBASE_NUM in", values, "debaseNum");
            return (Criteria) this;
        }

        public Criteria andDebaseNumNotIn(List<Long> values) {
            addCriterion("DEBASE_NUM not in", values, "debaseNum");
            return (Criteria) this;
        }

        public Criteria andDebaseNumBetween(Long value1, Long value2) {
            addCriterion("DEBASE_NUM between", value1, value2, "debaseNum");
            return (Criteria) this;
        }

        public Criteria andDebaseNumNotBetween(Long value1, Long value2) {
            addCriterion("DEBASE_NUM not between", value1, value2, "debaseNum");
            return (Criteria) this;
        }

        public Criteria andFavNumIsNull() {
            addCriterion("FAV_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFavNumIsNotNull() {
            addCriterion("FAV_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFavNumEqualTo(Long value) {
            addCriterion("FAV_NUM =", value, "favNum");
            return (Criteria) this;
        }

        public Criteria andFavNumNotEqualTo(Long value) {
            addCriterion("FAV_NUM <>", value, "favNum");
            return (Criteria) this;
        }

        public Criteria andFavNumGreaterThan(Long value) {
            addCriterion("FAV_NUM >", value, "favNum");
            return (Criteria) this;
        }

        public Criteria andFavNumGreaterThanOrEqualTo(Long value) {
            addCriterion("FAV_NUM >=", value, "favNum");
            return (Criteria) this;
        }

        public Criteria andFavNumLessThan(Long value) {
            addCriterion("FAV_NUM <", value, "favNum");
            return (Criteria) this;
        }

        public Criteria andFavNumLessThanOrEqualTo(Long value) {
            addCriterion("FAV_NUM <=", value, "favNum");
            return (Criteria) this;
        }

        public Criteria andFavNumIn(List<Long> values) {
            addCriterion("FAV_NUM in", values, "favNum");
            return (Criteria) this;
        }

        public Criteria andFavNumNotIn(List<Long> values) {
            addCriterion("FAV_NUM not in", values, "favNum");
            return (Criteria) this;
        }

        public Criteria andFavNumBetween(Long value1, Long value2) {
            addCriterion("FAV_NUM between", value1, value2, "favNum");
            return (Criteria) this;
        }

        public Criteria andFavNumNotBetween(Long value1, Long value2) {
            addCriterion("FAV_NUM not between", value1, value2, "favNum");
            return (Criteria) this;
        }

        public Criteria andAddDatetimeIsNull() {
            addCriterion("ADD_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andAddDatetimeIsNotNull() {
            addCriterion("ADD_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andAddDatetimeEqualTo(Date value) {
            addCriterion("ADD_DATETIME =", value, "addDatetime");
            return (Criteria) this;
        }

        public Criteria andAddDatetimeNotEqualTo(Date value) {
            addCriterion("ADD_DATETIME <>", value, "addDatetime");
            return (Criteria) this;
        }

        public Criteria andAddDatetimeGreaterThan(Date value) {
            addCriterion("ADD_DATETIME >", value, "addDatetime");
            return (Criteria) this;
        }

        public Criteria andAddDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ADD_DATETIME >=", value, "addDatetime");
            return (Criteria) this;
        }

        public Criteria andAddDatetimeLessThan(Date value) {
            addCriterion("ADD_DATETIME <", value, "addDatetime");
            return (Criteria) this;
        }

        public Criteria andAddDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("ADD_DATETIME <=", value, "addDatetime");
            return (Criteria) this;
        }

        public Criteria andAddDatetimeIn(List<Date> values) {
            addCriterion("ADD_DATETIME in", values, "addDatetime");
            return (Criteria) this;
        }

        public Criteria andAddDatetimeNotIn(List<Date> values) {
            addCriterion("ADD_DATETIME not in", values, "addDatetime");
            return (Criteria) this;
        }

        public Criteria andAddDatetimeBetween(Date value1, Date value2) {
            addCriterion("ADD_DATETIME between", value1, value2, "addDatetime");
            return (Criteria) this;
        }

        public Criteria andAddDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("ADD_DATETIME not between", value1, value2, "addDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNull() {
            addCriterion("UPDATE_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNotNull() {
            addCriterion("UPDATE_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME =", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME <>", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThan(Date value) {
            addCriterion("UPDATE_DATETIME >", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME >=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThan(Date value) {
            addCriterion("UPDATE_DATETIME <", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME <=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIn(List<Date> values) {
            addCriterion("UPDATE_DATETIME in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotIn(List<Date> values) {
            addCriterion("UPDATE_DATETIME not in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATETIME between", value1, value2, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATETIME not between", value1, value2, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andEffectDatetimeIsNull() {
            addCriterion("EFFECT_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andEffectDatetimeIsNotNull() {
            addCriterion("EFFECT_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andEffectDatetimeEqualTo(Date value) {
            addCriterion("EFFECT_DATETIME =", value, "effectDatetime");
            return (Criteria) this;
        }

        public Criteria andEffectDatetimeNotEqualTo(Date value) {
            addCriterion("EFFECT_DATETIME <>", value, "effectDatetime");
            return (Criteria) this;
        }

        public Criteria andEffectDatetimeGreaterThan(Date value) {
            addCriterion("EFFECT_DATETIME >", value, "effectDatetime");
            return (Criteria) this;
        }

        public Criteria andEffectDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EFFECT_DATETIME >=", value, "effectDatetime");
            return (Criteria) this;
        }

        public Criteria andEffectDatetimeLessThan(Date value) {
            addCriterion("EFFECT_DATETIME <", value, "effectDatetime");
            return (Criteria) this;
        }

        public Criteria andEffectDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("EFFECT_DATETIME <=", value, "effectDatetime");
            return (Criteria) this;
        }

        public Criteria andEffectDatetimeIn(List<Date> values) {
            addCriterion("EFFECT_DATETIME in", values, "effectDatetime");
            return (Criteria) this;
        }

        public Criteria andEffectDatetimeNotIn(List<Date> values) {
            addCriterion("EFFECT_DATETIME not in", values, "effectDatetime");
            return (Criteria) this;
        }

        public Criteria andEffectDatetimeBetween(Date value1, Date value2) {
            addCriterion("EFFECT_DATETIME between", value1, value2, "effectDatetime");
            return (Criteria) this;
        }

        public Criteria andEffectDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("EFFECT_DATETIME not between", value1, value2, "effectDatetime");
            return (Criteria) this;
        }

        public Criteria andInvalidDatetimeIsNull() {
            addCriterion("INVALID_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andInvalidDatetimeIsNotNull() {
            addCriterion("INVALID_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andInvalidDatetimeEqualTo(Date value) {
            addCriterion("INVALID_DATETIME =", value, "invalidDatetime");
            return (Criteria) this;
        }

        public Criteria andInvalidDatetimeNotEqualTo(Date value) {
            addCriterion("INVALID_DATETIME <>", value, "invalidDatetime");
            return (Criteria) this;
        }

        public Criteria andInvalidDatetimeGreaterThan(Date value) {
            addCriterion("INVALID_DATETIME >", value, "invalidDatetime");
            return (Criteria) this;
        }

        public Criteria andInvalidDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("INVALID_DATETIME >=", value, "invalidDatetime");
            return (Criteria) this;
        }

        public Criteria andInvalidDatetimeLessThan(Date value) {
            addCriterion("INVALID_DATETIME <", value, "invalidDatetime");
            return (Criteria) this;
        }

        public Criteria andInvalidDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("INVALID_DATETIME <=", value, "invalidDatetime");
            return (Criteria) this;
        }

        public Criteria andInvalidDatetimeIn(List<Date> values) {
            addCriterion("INVALID_DATETIME in", values, "invalidDatetime");
            return (Criteria) this;
        }

        public Criteria andInvalidDatetimeNotIn(List<Date> values) {
            addCriterion("INVALID_DATETIME not in", values, "invalidDatetime");
            return (Criteria) this;
        }

        public Criteria andInvalidDatetimeBetween(Date value1, Date value2) {
            addCriterion("INVALID_DATETIME between", value1, value2, "invalidDatetime");
            return (Criteria) this;
        }

        public Criteria andInvalidDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("INVALID_DATETIME not between", value1, value2, "invalidDatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDatetimeIsNull() {
            addCriterion("LAST_UPDATE_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDatetimeIsNotNull() {
            addCriterion("LAST_UPDATE_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDatetimeEqualTo(Date value) {
            addCriterion("LAST_UPDATE_DATETIME =", value, "lastUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDatetimeNotEqualTo(Date value) {
            addCriterion("LAST_UPDATE_DATETIME <>", value, "lastUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDatetimeGreaterThan(Date value) {
            addCriterion("LAST_UPDATE_DATETIME >", value, "lastUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATE_DATETIME >=", value, "lastUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDatetimeLessThan(Date value) {
            addCriterion("LAST_UPDATE_DATETIME <", value, "lastUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATE_DATETIME <=", value, "lastUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDatetimeIn(List<Date> values) {
            addCriterion("LAST_UPDATE_DATETIME in", values, "lastUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDatetimeNotIn(List<Date> values) {
            addCriterion("LAST_UPDATE_DATETIME not in", values, "lastUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDatetimeBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATE_DATETIME between", value1, value2, "lastUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATE_DATETIME not between", value1, value2, "lastUpdateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("UPDATE_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("UPDATE_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(String value) {
            addCriterion("UPDATE_USER_ID =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(String value) {
            addCriterion("UPDATE_USER_ID <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(String value) {
            addCriterion("UPDATE_USER_ID >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER_ID >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(String value) {
            addCriterion("UPDATE_USER_ID <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER_ID <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLike(String value) {
            addCriterion("UPDATE_USER_ID like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotLike(String value) {
            addCriterion("UPDATE_USER_ID not like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<String> values) {
            addCriterion("UPDATE_USER_ID in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<String> values) {
            addCriterion("UPDATE_USER_ID not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(String value1, String value2) {
            addCriterion("UPDATE_USER_ID between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USER_ID not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNull() {
            addCriterion("UPDATE_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNotNull() {
            addCriterion("UPDATE_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameEqualTo(String value) {
            addCriterion("UPDATE_USER_NAME =", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotEqualTo(String value) {
            addCriterion("UPDATE_USER_NAME <>", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThan(String value) {
            addCriterion("UPDATE_USER_NAME >", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER_NAME >=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThan(String value) {
            addCriterion("UPDATE_USER_NAME <", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER_NAME <=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLike(String value) {
            addCriterion("UPDATE_USER_NAME like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotLike(String value) {
            addCriterion("UPDATE_USER_NAME not like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIn(List<String> values) {
            addCriterion("UPDATE_USER_NAME in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotIn(List<String> values) {
            addCriterion("UPDATE_USER_NAME not in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameBetween(String value1, String value2) {
            addCriterion("UPDATE_USER_NAME between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USER_NAME not between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("ENABLE is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("ENABLE is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Integer value) {
            addCriterion("ENABLE =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Integer value) {
            addCriterion("ENABLE <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Integer value) {
            addCriterion("ENABLE >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("ENABLE >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Integer value) {
            addCriterion("ENABLE <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Integer value) {
            addCriterion("ENABLE <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Integer> values) {
            addCriterion("ENABLE in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Integer> values) {
            addCriterion("ENABLE not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Integer value1, Integer value2) {
            addCriterion("ENABLE between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("ENABLE not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("SORT is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("SORT is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("SORT =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("SORT <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("SORT >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("SORT >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("SORT <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("SORT <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("SORT in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("SORT not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("SORT between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("SORT not between", value1, value2, "sort");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}