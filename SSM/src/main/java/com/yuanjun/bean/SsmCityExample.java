package com.yuanjun.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SsmCityExample
{
  protected String orderByClause;
  protected boolean distinct;
  protected List<Criteria> oredCriteria;

  public SsmCityExample()
  {
    this.oredCriteria = new ArrayList();
  }

  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  public String getOrderByClause() {
    return this.orderByClause;
  }

  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  public boolean isDistinct() {
    return this.distinct;
  }

  public List<Criteria> getOredCriteria() {
    return this.oredCriteria;
  }

  public void or(Criteria criteria) {
    this.oredCriteria.add(criteria);
  }

  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    this.oredCriteria.add(criteria);
    return criteria;
  }

  public Criteria createCriteria() {
    Criteria criteria = createCriteriaInternal();
    if (this.oredCriteria.size() == 0) {
      this.oredCriteria.add(criteria);
    }
    return criteria;
  }

  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  public void clear() {
    this.oredCriteria.clear();
    this.orderByClause = null;
    this.distinct = false;
  }

  public static class Criterion
  {
    private String condition;
    private Object value;
    private Object secondValue;
    private boolean noValue;
    private boolean singleValue;
    private boolean betweenValue;
    private boolean listValue;
    private String typeHandler;

    public String getCondition()
    {
      return this.condition;
    }

    public Object getValue() {
      return this.value;
    }

    public Object getSecondValue() {
      return this.secondValue;
    }

    public boolean isNoValue() {
      return this.noValue;
    }

    public boolean isSingleValue() {
      return this.singleValue;
    }

    public boolean isBetweenValue() {
      return this.betweenValue;
    }

    public boolean isListValue() {
      return this.listValue;
    }

    public String getTypeHandler() {
      return this.typeHandler;
    }

    protected Criterion(String condition)
    {
      this.condition = condition;
      this.typeHandler = null;
      this.noValue = true;
    }

    protected Criterion(String condition, Object value, String typeHandler)
    {
      this.condition = condition;
      this.value = value;
      this.typeHandler = typeHandler;
      if ((value instanceof List))
        this.listValue = true;
      else
        this.singleValue = true;
    }

    protected Criterion(String condition, Object value)
    {
      this(condition, value, null);
    }

    protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
    {
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

  public static class Criteria extends SsmCityExample.GeneratedCriteria
  {
  }

  protected static abstract class GeneratedCriteria
  {
    protected List<SsmCityExample.Criterion> criteria;

    protected GeneratedCriteria()
    {
      this.criteria = new ArrayList();
    }

    public boolean isValid() {
      return this.criteria.size() > 0;
    }

    public List<SsmCityExample.Criterion> getAllCriteria() {
      return this.criteria;
    }

    public List<SsmCityExample.Criterion> getCriteria() {
      return this.criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      this.criteria.add(new SsmCityExample.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      this.criteria.add(new SsmCityExample.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if ((value1 == null) || (value2 == null)) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      this.criteria.add(new SsmCityExample.Criterion(condition, value1, value2));
    }

    public SsmCityExample.Criteria andIdIsNull() {
      addCriterion("id is null");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andIdEqualTo(Short value) {
      addCriterion("id =", value, "id");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andIdNotEqualTo(Short value) {
      addCriterion("id <>", value, "id");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andIdGreaterThan(Short value) {
      addCriterion("id >", value, "id");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andIdGreaterThanOrEqualTo(Short value) {
      addCriterion("id >=", value, "id");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andIdLessThan(Short value) {
      addCriterion("id <", value, "id");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andIdLessThanOrEqualTo(Short value) {
      addCriterion("id <=", value, "id");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andIdIn(List<Short> values) {
      addCriterion("id in", values, "id");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andIdNotIn(List<Short> values) {
      addCriterion("id not in", values, "id");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andIdBetween(Short value1, Short value2) {
      addCriterion("id between", value1, value2, "id");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andIdNotBetween(Short value1, Short value2) {
      addCriterion("id not between", value1, value2, "id");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andTitleIsNull() {
      addCriterion("title is null");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andTitleIsNotNull() {
      addCriterion("title is not null");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andTitleEqualTo(String value) {
      addCriterion("title =", value, "title");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andTitleNotEqualTo(String value) {
      addCriterion("title <>", value, "title");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andTitleGreaterThan(String value) {
      addCriterion("title >", value, "title");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
      addCriterion("title >=", value, "title");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andTitleLessThan(String value) {
      addCriterion("title <", value, "title");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andTitleLessThanOrEqualTo(String value) {
      addCriterion("title <=", value, "title");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andTitleLike(String value) {
      addCriterion("title like", value, "title");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andTitleNotLike(String value) {
      addCriterion("title not like", value, "title");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andTitleIn(List<String> values) {
      addCriterion("title in", values, "title");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andTitleNotIn(List<String> values) {
      addCriterion("title not in", values, "title");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andTitleBetween(String value1, String value2) {
      addCriterion("title between", value1, value2, "title");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andTitleNotBetween(String value1, String value2) {
      addCriterion("title not between", value1, value2, "title");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andAddtimeIsNull() {
      addCriterion("addtime is null");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andAddtimeIsNotNull() {
      addCriterion("addtime is not null");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andAddtimeEqualTo(Date value) {
      addCriterion("addtime =", value, "addtime");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andAddtimeNotEqualTo(Date value) {
      addCriterion("addtime <>", value, "addtime");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andAddtimeGreaterThan(Date value) {
      addCriterion("addtime >", value, "addtime");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
      addCriterion("addtime >=", value, "addtime");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andAddtimeLessThan(Date value) {
      addCriterion("addtime <", value, "addtime");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andAddtimeLessThanOrEqualTo(Date value) {
      addCriterion("addtime <=", value, "addtime");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andAddtimeIn(List<Date> values) {
      addCriterion("addtime in", values, "addtime");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andAddtimeNotIn(List<Date> values) {
      addCriterion("addtime not in", values, "addtime");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andAddtimeBetween(Date value1, Date value2) {
      addCriterion("addtime between", value1, value2, "addtime");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andAddtimeNotBetween(Date value1, Date value2) {
      addCriterion("addtime not between", value1, value2, "addtime");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andFlagIsNull() {
      addCriterion("flag is null");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andFlagIsNotNull() {
      addCriterion("flag is not null");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andFlagEqualTo(Byte value) {
      addCriterion("flag =", value, "flag");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andFlagNotEqualTo(Byte value) {
      addCriterion("flag <>", value, "flag");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andFlagGreaterThan(Byte value) {
      addCriterion("flag >", value, "flag");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andFlagGreaterThanOrEqualTo(Byte value) {
      addCriterion("flag >=", value, "flag");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andFlagLessThan(Byte value) {
      addCriterion("flag <", value, "flag");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andFlagLessThanOrEqualTo(Byte value) {
      addCriterion("flag <=", value, "flag");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andFlagIn(List<Byte> values) {
      addCriterion("flag in", values, "flag");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andFlagNotIn(List<Byte> values) {
      addCriterion("flag not in", values, "flag");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andFlagBetween(Byte value1, Byte value2) {
      addCriterion("flag between", value1, value2, "flag");
      return (SsmCityExample.Criteria)this;
    }

    public SsmCityExample.Criteria andFlagNotBetween(Byte value1, Byte value2) {
      addCriterion("flag not between", value1, value2, "flag");
      return (SsmCityExample.Criteria)this;
    }
  }
}