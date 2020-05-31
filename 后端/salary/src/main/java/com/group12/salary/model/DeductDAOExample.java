package com.group12.salary.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DeductDAOExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public DeductDAOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
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

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(String value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(String value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(String value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(String value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(String value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLike(String value) {
			addCriterion("user_id like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotLike(String value) {
			addCriterion("user_id not like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<String> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<String> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(String value1, String value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(String value1, String value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andRoomIsNull() {
			addCriterion("room is null");
			return (Criteria) this;
		}

		public Criteria andRoomIsNotNull() {
			addCriterion("room is not null");
			return (Criteria) this;
		}

		public Criteria andRoomEqualTo(BigDecimal value) {
			addCriterion("room =", value, "room");
			return (Criteria) this;
		}

		public Criteria andRoomNotEqualTo(BigDecimal value) {
			addCriterion("room <>", value, "room");
			return (Criteria) this;
		}

		public Criteria andRoomGreaterThan(BigDecimal value) {
			addCriterion("room >", value, "room");
			return (Criteria) this;
		}

		public Criteria andRoomGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("room >=", value, "room");
			return (Criteria) this;
		}

		public Criteria andRoomLessThan(BigDecimal value) {
			addCriterion("room <", value, "room");
			return (Criteria) this;
		}

		public Criteria andRoomLessThanOrEqualTo(BigDecimal value) {
			addCriterion("room <=", value, "room");
			return (Criteria) this;
		}

		public Criteria andRoomIn(List<BigDecimal> values) {
			addCriterion("room in", values, "room");
			return (Criteria) this;
		}

		public Criteria andRoomNotIn(List<BigDecimal> values) {
			addCriterion("room not in", values, "room");
			return (Criteria) this;
		}

		public Criteria andRoomBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("room between", value1, value2, "room");
			return (Criteria) this;
		}

		public Criteria andRoomNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("room not between", value1, value2, "room");
			return (Criteria) this;
		}

		public Criteria andWaterElectricIsNull() {
			addCriterion("water_electric is null");
			return (Criteria) this;
		}

		public Criteria andWaterElectricIsNotNull() {
			addCriterion("water_electric is not null");
			return (Criteria) this;
		}

		public Criteria andWaterElectricEqualTo(BigDecimal value) {
			addCriterion("water_electric =", value, "waterElectric");
			return (Criteria) this;
		}

		public Criteria andWaterElectricNotEqualTo(BigDecimal value) {
			addCriterion("water_electric <>", value, "waterElectric");
			return (Criteria) this;
		}

		public Criteria andWaterElectricGreaterThan(BigDecimal value) {
			addCriterion("water_electric >", value, "waterElectric");
			return (Criteria) this;
		}

		public Criteria andWaterElectricGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("water_electric >=", value, "waterElectric");
			return (Criteria) this;
		}

		public Criteria andWaterElectricLessThan(BigDecimal value) {
			addCriterion("water_electric <", value, "waterElectric");
			return (Criteria) this;
		}

		public Criteria andWaterElectricLessThanOrEqualTo(BigDecimal value) {
			addCriterion("water_electric <=", value, "waterElectric");
			return (Criteria) this;
		}

		public Criteria andWaterElectricIn(List<BigDecimal> values) {
			addCriterion("water_electric in", values, "waterElectric");
			return (Criteria) this;
		}

		public Criteria andWaterElectricNotIn(List<BigDecimal> values) {
			addCriterion("water_electric not in", values, "waterElectric");
			return (Criteria) this;
		}

		public Criteria andWaterElectricBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("water_electric between", value1, value2, "waterElectric");
			return (Criteria) this;
		}

		public Criteria andWaterElectricNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("water_electric not between", value1, value2, "waterElectric");
			return (Criteria) this;
		}

		public Criteria andChildrenIsNull() {
			addCriterion("children is null");
			return (Criteria) this;
		}

		public Criteria andChildrenIsNotNull() {
			addCriterion("children is not null");
			return (Criteria) this;
		}

		public Criteria andChildrenEqualTo(BigDecimal value) {
			addCriterion("children =", value, "children");
			return (Criteria) this;
		}

		public Criteria andChildrenNotEqualTo(BigDecimal value) {
			addCriterion("children <>", value, "children");
			return (Criteria) this;
		}

		public Criteria andChildrenGreaterThan(BigDecimal value) {
			addCriterion("children >", value, "children");
			return (Criteria) this;
		}

		public Criteria andChildrenGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("children >=", value, "children");
			return (Criteria) this;
		}

		public Criteria andChildrenLessThan(BigDecimal value) {
			addCriterion("children <", value, "children");
			return (Criteria) this;
		}

		public Criteria andChildrenLessThanOrEqualTo(BigDecimal value) {
			addCriterion("children <=", value, "children");
			return (Criteria) this;
		}

		public Criteria andChildrenIn(List<BigDecimal> values) {
			addCriterion("children in", values, "children");
			return (Criteria) this;
		}

		public Criteria andChildrenNotIn(List<BigDecimal> values) {
			addCriterion("children not in", values, "children");
			return (Criteria) this;
		}

		public Criteria andChildrenBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("children between", value1, value2, "children");
			return (Criteria) this;
		}

		public Criteria andChildrenNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("children not between", value1, value2, "children");
			return (Criteria) this;
		}

		public Criteria andAdvanceIsNull() {
			addCriterion("advance is null");
			return (Criteria) this;
		}

		public Criteria andAdvanceIsNotNull() {
			addCriterion("advance is not null");
			return (Criteria) this;
		}

		public Criteria andAdvanceEqualTo(BigDecimal value) {
			addCriterion("advance =", value, "advance");
			return (Criteria) this;
		}

		public Criteria andAdvanceNotEqualTo(BigDecimal value) {
			addCriterion("advance <>", value, "advance");
			return (Criteria) this;
		}

		public Criteria andAdvanceGreaterThan(BigDecimal value) {
			addCriterion("advance >", value, "advance");
			return (Criteria) this;
		}

		public Criteria andAdvanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("advance >=", value, "advance");
			return (Criteria) this;
		}

		public Criteria andAdvanceLessThan(BigDecimal value) {
			addCriterion("advance <", value, "advance");
			return (Criteria) this;
		}

		public Criteria andAdvanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("advance <=", value, "advance");
			return (Criteria) this;
		}

		public Criteria andAdvanceIn(List<BigDecimal> values) {
			addCriterion("advance in", values, "advance");
			return (Criteria) this;
		}

		public Criteria andAdvanceNotIn(List<BigDecimal> values) {
			addCriterion("advance not in", values, "advance");
			return (Criteria) this;
		}

		public Criteria andAdvanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("advance between", value1, value2, "advance");
			return (Criteria) this;
		}

		public Criteria andAdvanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("advance not between", value1, value2, "advance");
			return (Criteria) this;
		}

		public Criteria andOtherIsNull() {
			addCriterion("other is null");
			return (Criteria) this;
		}

		public Criteria andOtherIsNotNull() {
			addCriterion("other is not null");
			return (Criteria) this;
		}

		public Criteria andOtherEqualTo(BigDecimal value) {
			addCriterion("other =", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherNotEqualTo(BigDecimal value) {
			addCriterion("other <>", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherGreaterThan(BigDecimal value) {
			addCriterion("other >", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("other >=", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherLessThan(BigDecimal value) {
			addCriterion("other <", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherLessThanOrEqualTo(BigDecimal value) {
			addCriterion("other <=", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherIn(List<BigDecimal> values) {
			addCriterion("other in", values, "other");
			return (Criteria) this;
		}

		public Criteria andOtherNotIn(List<BigDecimal> values) {
			addCriterion("other not in", values, "other");
			return (Criteria) this;
		}

		public Criteria andOtherBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("other between", value1, value2, "other");
			return (Criteria) this;
		}

		public Criteria andOtherNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("other not between", value1, value2, "other");
			return (Criteria) this;
		}

		public Criteria andDeductTotalIsNull() {
			addCriterion("deduct_total is null");
			return (Criteria) this;
		}

		public Criteria andDeductTotalIsNotNull() {
			addCriterion("deduct_total is not null");
			return (Criteria) this;
		}

		public Criteria andDeductTotalEqualTo(BigDecimal value) {
			addCriterion("deduct_total =", value, "deductTotal");
			return (Criteria) this;
		}

		public Criteria andDeductTotalNotEqualTo(BigDecimal value) {
			addCriterion("deduct_total <>", value, "deductTotal");
			return (Criteria) this;
		}

		public Criteria andDeductTotalGreaterThan(BigDecimal value) {
			addCriterion("deduct_total >", value, "deductTotal");
			return (Criteria) this;
		}

		public Criteria andDeductTotalGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("deduct_total >=", value, "deductTotal");
			return (Criteria) this;
		}

		public Criteria andDeductTotalLessThan(BigDecimal value) {
			addCriterion("deduct_total <", value, "deductTotal");
			return (Criteria) this;
		}

		public Criteria andDeductTotalLessThanOrEqualTo(BigDecimal value) {
			addCriterion("deduct_total <=", value, "deductTotal");
			return (Criteria) this;
		}

		public Criteria andDeductTotalIn(List<BigDecimal> values) {
			addCriterion("deduct_total in", values, "deductTotal");
			return (Criteria) this;
		}

		public Criteria andDeductTotalNotIn(List<BigDecimal> values) {
			addCriterion("deduct_total not in", values, "deductTotal");
			return (Criteria) this;
		}

		public Criteria andDeductTotalBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("deduct_total between", value1, value2, "deductTotal");
			return (Criteria) this;
		}

		public Criteria andDeductTotalNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("deduct_total not between", value1, value2, "deductTotal");
			return (Criteria) this;
		}

		public Criteria andSubmitUserIdIsNull() {
			addCriterion("submit_user_id is null");
			return (Criteria) this;
		}

		public Criteria andSubmitUserIdIsNotNull() {
			addCriterion("submit_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andSubmitUserIdEqualTo(String value) {
			addCriterion("submit_user_id =", value, "submitUserId");
			return (Criteria) this;
		}

		public Criteria andSubmitUserIdNotEqualTo(String value) {
			addCriterion("submit_user_id <>", value, "submitUserId");
			return (Criteria) this;
		}

		public Criteria andSubmitUserIdGreaterThan(String value) {
			addCriterion("submit_user_id >", value, "submitUserId");
			return (Criteria) this;
		}

		public Criteria andSubmitUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("submit_user_id >=", value, "submitUserId");
			return (Criteria) this;
		}

		public Criteria andSubmitUserIdLessThan(String value) {
			addCriterion("submit_user_id <", value, "submitUserId");
			return (Criteria) this;
		}

		public Criteria andSubmitUserIdLessThanOrEqualTo(String value) {
			addCriterion("submit_user_id <=", value, "submitUserId");
			return (Criteria) this;
		}

		public Criteria andSubmitUserIdLike(String value) {
			addCriterion("submit_user_id like", value, "submitUserId");
			return (Criteria) this;
		}

		public Criteria andSubmitUserIdNotLike(String value) {
			addCriterion("submit_user_id not like", value, "submitUserId");
			return (Criteria) this;
		}

		public Criteria andSubmitUserIdIn(List<String> values) {
			addCriterion("submit_user_id in", values, "submitUserId");
			return (Criteria) this;
		}

		public Criteria andSubmitUserIdNotIn(List<String> values) {
			addCriterion("submit_user_id not in", values, "submitUserId");
			return (Criteria) this;
		}

		public Criteria andSubmitUserIdBetween(String value1, String value2) {
			addCriterion("submit_user_id between", value1, value2, "submitUserId");
			return (Criteria) this;
		}

		public Criteria andSubmitUserIdNotBetween(String value1, String value2) {
			addCriterion("submit_user_id not between", value1, value2, "submitUserId");
			return (Criteria) this;
		}

		public Criteria andSubmitDateIsNull() {
			addCriterion("submit_date is null");
			return (Criteria) this;
		}

		public Criteria andSubmitDateIsNotNull() {
			addCriterion("submit_date is not null");
			return (Criteria) this;
		}

		public Criteria andSubmitDateEqualTo(Date value) {
			addCriterionForJDBCDate("submit_date =", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("submit_date <>", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateGreaterThan(Date value) {
			addCriterionForJDBCDate("submit_date >", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("submit_date >=", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateLessThan(Date value) {
			addCriterionForJDBCDate("submit_date <", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("submit_date <=", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateIn(List<Date> values) {
			addCriterionForJDBCDate("submit_date in", values, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("submit_date not in", values, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("submit_date between", value1, value2, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("submit_date not between", value1, value2, "submitDate");
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

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_deduct
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_deduct
     *
     * @mbg.generated do_not_delete_during_merge Sat May 30 15:49:06 GMT+08:00 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}