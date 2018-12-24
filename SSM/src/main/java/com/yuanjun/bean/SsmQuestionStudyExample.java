package com.yuanjun.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SsmQuestionStudyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SsmQuestionStudyExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andCategorypidIsNull() {
            addCriterion("categorypid is null");
            return (Criteria) this;
        }

        public Criteria andCategorypidIsNotNull() {
            addCriterion("categorypid is not null");
            return (Criteria) this;
        }

        public Criteria andCategorypidEqualTo(Byte value) {
            addCriterion("categorypid =", value, "categorypid");
            return (Criteria) this;
        }

        public Criteria andCategorypidNotEqualTo(Byte value) {
            addCriterion("categorypid <>", value, "categorypid");
            return (Criteria) this;
        }

        public Criteria andCategorypidGreaterThan(Byte value) {
            addCriterion("categorypid >", value, "categorypid");
            return (Criteria) this;
        }

        public Criteria andCategorypidGreaterThanOrEqualTo(Byte value) {
            addCriterion("categorypid >=", value, "categorypid");
            return (Criteria) this;
        }

        public Criteria andCategorypidLessThan(Byte value) {
            addCriterion("categorypid <", value, "categorypid");
            return (Criteria) this;
        }

        public Criteria andCategorypidLessThanOrEqualTo(Byte value) {
            addCriterion("categorypid <=", value, "categorypid");
            return (Criteria) this;
        }

        public Criteria andCategorypidIn(List<Byte> values) {
            addCriterion("categorypid in", values, "categorypid");
            return (Criteria) this;
        }

        public Criteria andCategorypidNotIn(List<Byte> values) {
            addCriterion("categorypid not in", values, "categorypid");
            return (Criteria) this;
        }

        public Criteria andCategorypidBetween(Byte value1, Byte value2) {
            addCriterion("categorypid between", value1, value2, "categorypid");
            return (Criteria) this;
        }

        public Criteria andCategorypidNotBetween(Byte value1, Byte value2) {
            addCriterion("categorypid not between", value1, value2, "categorypid");
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

        public Criteria andMyanserIsNull() {
            addCriterion("myanser is null");
            return (Criteria) this;
        }

        public Criteria andMyanserIsNotNull() {
            addCriterion("myanser is not null");
            return (Criteria) this;
        }

        public Criteria andMyanserEqualTo(String value) {
            addCriterion("myanser =", value, "myanser");
            return (Criteria) this;
        }

        public Criteria andMyanserNotEqualTo(String value) {
            addCriterion("myanser <>", value, "myanser");
            return (Criteria) this;
        }

        public Criteria andMyanserGreaterThan(String value) {
            addCriterion("myanser >", value, "myanser");
            return (Criteria) this;
        }

        public Criteria andMyanserGreaterThanOrEqualTo(String value) {
            addCriterion("myanser >=", value, "myanser");
            return (Criteria) this;
        }

        public Criteria andMyanserLessThan(String value) {
            addCriterion("myanser <", value, "myanser");
            return (Criteria) this;
        }

        public Criteria andMyanserLessThanOrEqualTo(String value) {
            addCriterion("myanser <=", value, "myanser");
            return (Criteria) this;
        }

        public Criteria andMyanserLike(String value) {
            addCriterion("myanser like", value, "myanser");
            return (Criteria) this;
        }

        public Criteria andMyanserNotLike(String value) {
            addCriterion("myanser not like", value, "myanser");
            return (Criteria) this;
        }

        public Criteria andMyanserIn(List<String> values) {
            addCriterion("myanser in", values, "myanser");
            return (Criteria) this;
        }

        public Criteria andMyanserNotIn(List<String> values) {
            addCriterion("myanser not in", values, "myanser");
            return (Criteria) this;
        }

        public Criteria andMyanserBetween(String value1, String value2) {
            addCriterion("myanser between", value1, value2, "myanser");
            return (Criteria) this;
        }

        public Criteria andMyanserNotBetween(String value1, String value2) {
            addCriterion("myanser not between", value1, value2, "myanser");
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