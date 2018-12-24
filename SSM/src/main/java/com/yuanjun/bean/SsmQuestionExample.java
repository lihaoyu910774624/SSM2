package com.yuanjun.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SsmQuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SsmQuestionExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andQuestionidIsNull() {
            addCriterion("questionid is null");
            return (Criteria) this;
        }

        public Criteria andQuestionidIsNotNull() {
            addCriterion("questionid is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionidEqualTo(String value) {
            addCriterion("questionid =", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotEqualTo(String value) {
            addCriterion("questionid <>", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThan(String value) {
            addCriterion("questionid >", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThanOrEqualTo(String value) {
            addCriterion("questionid >=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThan(String value) {
            addCriterion("questionid <", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThanOrEqualTo(String value) {
            addCriterion("questionid <=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLike(String value) {
            addCriterion("questionid like", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotLike(String value) {
            addCriterion("questionid not like", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidIn(List<String> values) {
            addCriterion("questionid in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotIn(List<String> values) {
            addCriterion("questionid not in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidBetween(String value1, String value2) {
            addCriterion("questionid between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotBetween(String value1, String value2) {
            addCriterion("questionid not between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andFractionIsNull() {
            addCriterion("fraction is null");
            return (Criteria) this;
        }

        public Criteria andFractionIsNotNull() {
            addCriterion("fraction is not null");
            return (Criteria) this;
        }

        public Criteria andFractionEqualTo(Integer value) {
            addCriterion("fraction =", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotEqualTo(Integer value) {
            addCriterion("fraction <>", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionGreaterThan(Integer value) {
            addCriterion("fraction >", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionGreaterThanOrEqualTo(Integer value) {
            addCriterion("fraction >=", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionLessThan(Integer value) {
            addCriterion("fraction <", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionLessThanOrEqualTo(Integer value) {
            addCriterion("fraction <=", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionIn(List<Integer> values) {
            addCriterion("fraction in", values, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotIn(List<Integer> values) {
            addCriterion("fraction not in", values, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionBetween(Integer value1, Integer value2) {
            addCriterion("fraction between", value1, value2, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotBetween(Integer value1, Integer value2) {
            addCriterion("fraction not between", value1, value2, "fraction");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerIsNull() {
            addCriterion("correctanswer is null");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerIsNotNull() {
            addCriterion("correctanswer is not null");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerEqualTo(String value) {
            addCriterion("correctanswer =", value, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerNotEqualTo(String value) {
            addCriterion("correctanswer <>", value, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerGreaterThan(String value) {
            addCriterion("correctanswer >", value, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerGreaterThanOrEqualTo(String value) {
            addCriterion("correctanswer >=", value, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerLessThan(String value) {
            addCriterion("correctanswer <", value, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerLessThanOrEqualTo(String value) {
            addCriterion("correctanswer <=", value, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerLike(String value) {
            addCriterion("correctanswer like", value, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerNotLike(String value) {
            addCriterion("correctanswer not like", value, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerIn(List<String> values) {
            addCriterion("correctanswer in", values, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerNotIn(List<String> values) {
            addCriterion("correctanswer not in", values, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerBetween(String value1, String value2) {
            addCriterion("correctanswer between", value1, value2, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCorrectanswerNotBetween(String value1, String value2) {
            addCriterion("correctanswer not between", value1, value2, "correctanswer");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNull() {
            addCriterion("categoryid is null");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNotNull() {
            addCriterion("categoryid is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryidEqualTo(Byte value) {
            addCriterion("categoryid =", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotEqualTo(Byte value) {
            addCriterion("categoryid <>", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThan(Byte value) {
            addCriterion("categoryid >", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThanOrEqualTo(Byte value) {
            addCriterion("categoryid >=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThan(Byte value) {
            addCriterion("categoryid <", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThanOrEqualTo(Byte value) {
            addCriterion("categoryid <=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidIn(List<Byte> values) {
            addCriterion("categoryid in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotIn(List<Byte> values) {
            addCriterion("categoryid not in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidBetween(Byte value1, Byte value2) {
            addCriterion("categoryid between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotBetween(Byte value1, Byte value2) {
            addCriterion("categoryid not between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andSubjectidIsNull() {
            addCriterion("subjectid is null");
            return (Criteria) this;
        }

        public Criteria andSubjectidIsNotNull() {
            addCriterion("subjectid is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectidEqualTo(Byte value) {
            addCriterion("subjectid =", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidNotEqualTo(Byte value) {
            addCriterion("subjectid <>", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidGreaterThan(Byte value) {
            addCriterion("subjectid >", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidGreaterThanOrEqualTo(Byte value) {
            addCriterion("subjectid >=", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidLessThan(Byte value) {
            addCriterion("subjectid <", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidLessThanOrEqualTo(Byte value) {
            addCriterion("subjectid <=", value, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidIn(List<Byte> values) {
            addCriterion("subjectid in", values, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidNotIn(List<Byte> values) {
            addCriterion("subjectid not in", values, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidBetween(Byte value1, Byte value2) {
            addCriterion("subjectid between", value1, value2, "subjectid");
            return (Criteria) this;
        }

        public Criteria andSubjectidNotBetween(Byte value1, Byte value2) {
            addCriterion("subjectid not between", value1, value2, "subjectid");
            return (Criteria) this;
        }

        public Criteria andChapteridIsNull() {
            addCriterion("chapterid is null");
            return (Criteria) this;
        }

        public Criteria andChapteridIsNotNull() {
            addCriterion("chapterid is not null");
            return (Criteria) this;
        }

        public Criteria andChapteridEqualTo(String value) {
            addCriterion("chapterid =", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridNotEqualTo(String value) {
            addCriterion("chapterid <>", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridGreaterThan(String value) {
            addCriterion("chapterid >", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridGreaterThanOrEqualTo(String value) {
            addCriterion("chapterid >=", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridLessThan(String value) {
            addCriterion("chapterid <", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridLessThanOrEqualTo(String value) {
            addCriterion("chapterid <=", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridLike(String value) {
            addCriterion("chapterid like", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridNotLike(String value) {
            addCriterion("chapterid not like", value, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridIn(List<String> values) {
            addCriterion("chapterid in", values, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridNotIn(List<String> values) {
            addCriterion("chapterid not in", values, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridBetween(String value1, String value2) {
            addCriterion("chapterid between", value1, value2, "chapterid");
            return (Criteria) this;
        }

        public Criteria andChapteridNotBetween(String value1, String value2) {
            addCriterion("chapterid not between", value1, value2, "chapterid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addtime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andBrowseIsNull() {
            addCriterion("browse is null");
            return (Criteria) this;
        }

        public Criteria andBrowseIsNotNull() {
            addCriterion("browse is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseEqualTo(Integer value) {
            addCriterion("browse =", value, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseNotEqualTo(Integer value) {
            addCriterion("browse <>", value, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseGreaterThan(Integer value) {
            addCriterion("browse >", value, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseGreaterThanOrEqualTo(Integer value) {
            addCriterion("browse >=", value, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseLessThan(Integer value) {
            addCriterion("browse <", value, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseLessThanOrEqualTo(Integer value) {
            addCriterion("browse <=", value, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseIn(List<Integer> values) {
            addCriterion("browse in", values, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseNotIn(List<Integer> values) {
            addCriterion("browse not in", values, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseBetween(Integer value1, Integer value2) {
            addCriterion("browse between", value1, value2, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseNotBetween(Integer value1, Integer value2) {
            addCriterion("browse not between", value1, value2, "browse");
            return (Criteria) this;
        }

        public Criteria andSortNoIsNull() {
            addCriterion("sort_no is null");
            return (Criteria) this;
        }

        public Criteria andSortNoIsNotNull() {
            addCriterion("sort_no is not null");
            return (Criteria) this;
        }

        public Criteria andSortNoEqualTo(Short value) {
            addCriterion("sort_no =", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoNotEqualTo(Short value) {
            addCriterion("sort_no <>", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoGreaterThan(Short value) {
            addCriterion("sort_no >", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoGreaterThanOrEqualTo(Short value) {
            addCriterion("sort_no >=", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoLessThan(Short value) {
            addCriterion("sort_no <", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoLessThanOrEqualTo(Short value) {
            addCriterion("sort_no <=", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoIn(List<Short> values) {
            addCriterion("sort_no in", values, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoNotIn(List<Short> values) {
            addCriterion("sort_no not in", values, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoBetween(Short value1, Short value2) {
            addCriterion("sort_no between", value1, value2, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoNotBetween(Short value1, Short value2) {
            addCriterion("sort_no not between", value1, value2, "sortNo");
            return (Criteria) this;
        }

        public Criteria andKindIsNull() {
            addCriterion("kind is null");
            return (Criteria) this;
        }

        public Criteria andKindIsNotNull() {
            addCriterion("kind is not null");
            return (Criteria) this;
        }

        public Criteria andKindEqualTo(Byte value) {
            addCriterion("kind =", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotEqualTo(Byte value) {
            addCriterion("kind <>", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThan(Byte value) {
            addCriterion("kind >", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThanOrEqualTo(Byte value) {
            addCriterion("kind >=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThan(Byte value) {
            addCriterion("kind <", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThanOrEqualTo(Byte value) {
            addCriterion("kind <=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindIn(List<Byte> values) {
            addCriterion("kind in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotIn(List<Byte> values) {
            addCriterion("kind not in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindBetween(Byte value1, Byte value2) {
            addCriterion("kind between", value1, value2, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotBetween(Byte value1, Byte value2) {
            addCriterion("kind not between", value1, value2, "kind");
            return (Criteria) this;
        }

        public Criteria andAnalysisIsNull() {
            addCriterion("analysis is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisIsNotNull() {
            addCriterion("analysis is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisEqualTo(String value) {
            addCriterion("analysis =", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotEqualTo(String value) {
            addCriterion("analysis <>", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisGreaterThan(String value) {
            addCriterion("analysis >", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("analysis >=", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLessThan(String value) {
            addCriterion("analysis <", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLessThanOrEqualTo(String value) {
            addCriterion("analysis <=", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisLike(String value) {
            addCriterion("analysis like", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotLike(String value) {
            addCriterion("analysis not like", value, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisIn(List<String> values) {
            addCriterion("analysis in", values, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotIn(List<String> values) {
            addCriterion("analysis not in", values, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisBetween(String value1, String value2) {
            addCriterion("analysis between", value1, value2, "analysis");
            return (Criteria) this;
        }

        public Criteria andAnalysisNotBetween(String value1, String value2) {
            addCriterion("analysis not between", value1, value2, "analysis");
            return (Criteria) this;
        }

        public Criteria andBriefIsNull() {
            addCriterion("brief is null");
            return (Criteria) this;
        }

        public Criteria andBriefIsNotNull() {
            addCriterion("brief is not null");
            return (Criteria) this;
        }

        public Criteria andBriefEqualTo(String value) {
            addCriterion("brief =", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotEqualTo(String value) {
            addCriterion("brief <>", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThan(String value) {
            addCriterion("brief >", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThanOrEqualTo(String value) {
            addCriterion("brief >=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThan(String value) {
            addCriterion("brief <", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThanOrEqualTo(String value) {
            addCriterion("brief <=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLike(String value) {
            addCriterion("brief like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotLike(String value) {
            addCriterion("brief not like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefIn(List<String> values) {
            addCriterion("brief in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotIn(List<String> values) {
            addCriterion("brief not in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefBetween(String value1, String value2) {
            addCriterion("brief between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotBetween(String value1, String value2) {
            addCriterion("brief not between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Byte value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Byte value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Byte value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Byte value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Byte value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Byte> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Byte> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Byte value1, Byte value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("flag not between", value1, value2, "flag");
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