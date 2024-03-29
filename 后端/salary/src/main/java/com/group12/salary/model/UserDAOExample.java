package com.group12.salary.model;

import java.util.ArrayList;
import java.util.List;

public class UserDAOExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_user
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_user
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_user
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public UserDAOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_user
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

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
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

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andTelephoneIsNull() {
			addCriterion("telephone is null");
			return (Criteria) this;
		}

		public Criteria andTelephoneIsNotNull() {
			addCriterion("telephone is not null");
			return (Criteria) this;
		}

		public Criteria andTelephoneEqualTo(String value) {
			addCriterion("telephone =", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneNotEqualTo(String value) {
			addCriterion("telephone <>", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneGreaterThan(String value) {
			addCriterion("telephone >", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
			addCriterion("telephone >=", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneLessThan(String value) {
			addCriterion("telephone <", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneLessThanOrEqualTo(String value) {
			addCriterion("telephone <=", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneLike(String value) {
			addCriterion("telephone like", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneNotLike(String value) {
			addCriterion("telephone not like", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneIn(List<String> values) {
			addCriterion("telephone in", values, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneNotIn(List<String> values) {
			addCriterion("telephone not in", values, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneBetween(String value1, String value2) {
			addCriterion("telephone between", value1, value2, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneNotBetween(String value1, String value2) {
			addCriterion("telephone not between", value1, value2, "telephone");
			return (Criteria) this;
		}

		public Criteria andBankCardIsNull() {
			addCriterion("bank_card is null");
			return (Criteria) this;
		}

		public Criteria andBankCardIsNotNull() {
			addCriterion("bank_card is not null");
			return (Criteria) this;
		}

		public Criteria andBankCardEqualTo(String value) {
			addCriterion("bank_card =", value, "bankCard");
			return (Criteria) this;
		}

		public Criteria andBankCardNotEqualTo(String value) {
			addCriterion("bank_card <>", value, "bankCard");
			return (Criteria) this;
		}

		public Criteria andBankCardGreaterThan(String value) {
			addCriterion("bank_card >", value, "bankCard");
			return (Criteria) this;
		}

		public Criteria andBankCardGreaterThanOrEqualTo(String value) {
			addCriterion("bank_card >=", value, "bankCard");
			return (Criteria) this;
		}

		public Criteria andBankCardLessThan(String value) {
			addCriterion("bank_card <", value, "bankCard");
			return (Criteria) this;
		}

		public Criteria andBankCardLessThanOrEqualTo(String value) {
			addCriterion("bank_card <=", value, "bankCard");
			return (Criteria) this;
		}

		public Criteria andBankCardLike(String value) {
			addCriterion("bank_card like", value, "bankCard");
			return (Criteria) this;
		}

		public Criteria andBankCardNotLike(String value) {
			addCriterion("bank_card not like", value, "bankCard");
			return (Criteria) this;
		}

		public Criteria andBankCardIn(List<String> values) {
			addCriterion("bank_card in", values, "bankCard");
			return (Criteria) this;
		}

		public Criteria andBankCardNotIn(List<String> values) {
			addCriterion("bank_card not in", values, "bankCard");
			return (Criteria) this;
		}

		public Criteria andBankCardBetween(String value1, String value2) {
			addCriterion("bank_card between", value1, value2, "bankCard");
			return (Criteria) this;
		}

		public Criteria andBankCardNotBetween(String value1, String value2) {
			addCriterion("bank_card not between", value1, value2, "bankCard");
			return (Criteria) this;
		}

		public Criteria andDepartmentIdIsNull() {
			addCriterion("department_id is null");
			return (Criteria) this;
		}

		public Criteria andDepartmentIdIsNotNull() {
			addCriterion("department_id is not null");
			return (Criteria) this;
		}

		public Criteria andDepartmentIdEqualTo(String value) {
			addCriterion("department_id =", value, "departmentId");
			return (Criteria) this;
		}

		public Criteria andDepartmentIdNotEqualTo(String value) {
			addCriterion("department_id <>", value, "departmentId");
			return (Criteria) this;
		}

		public Criteria andDepartmentIdGreaterThan(String value) {
			addCriterion("department_id >", value, "departmentId");
			return (Criteria) this;
		}

		public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
			addCriterion("department_id >=", value, "departmentId");
			return (Criteria) this;
		}

		public Criteria andDepartmentIdLessThan(String value) {
			addCriterion("department_id <", value, "departmentId");
			return (Criteria) this;
		}

		public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
			addCriterion("department_id <=", value, "departmentId");
			return (Criteria) this;
		}

		public Criteria andDepartmentIdLike(String value) {
			addCriterion("department_id like", value, "departmentId");
			return (Criteria) this;
		}

		public Criteria andDepartmentIdNotLike(String value) {
			addCriterion("department_id not like", value, "departmentId");
			return (Criteria) this;
		}

		public Criteria andDepartmentIdIn(List<String> values) {
			addCriterion("department_id in", values, "departmentId");
			return (Criteria) this;
		}

		public Criteria andDepartmentIdNotIn(List<String> values) {
			addCriterion("department_id not in", values, "departmentId");
			return (Criteria) this;
		}

		public Criteria andDepartmentIdBetween(String value1, String value2) {
			addCriterion("department_id between", value1, value2, "departmentId");
			return (Criteria) this;
		}

		public Criteria andDepartmentIdNotBetween(String value1, String value2) {
			addCriterion("department_id not between", value1, value2, "departmentId");
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

		public Criteria andWorkingAgeIsNull() {
			addCriterion("working_age is null");
			return (Criteria) this;
		}

		public Criteria andWorkingAgeIsNotNull() {
			addCriterion("working_age is not null");
			return (Criteria) this;
		}

		public Criteria andWorkingAgeEqualTo(Integer value) {
			addCriterion("working_age =", value, "workingAge");
			return (Criteria) this;
		}

		public Criteria andWorkingAgeNotEqualTo(Integer value) {
			addCriterion("working_age <>", value, "workingAge");
			return (Criteria) this;
		}

		public Criteria andWorkingAgeGreaterThan(Integer value) {
			addCriterion("working_age >", value, "workingAge");
			return (Criteria) this;
		}

		public Criteria andWorkingAgeGreaterThanOrEqualTo(Integer value) {
			addCriterion("working_age >=", value, "workingAge");
			return (Criteria) this;
		}

		public Criteria andWorkingAgeLessThan(Integer value) {
			addCriterion("working_age <", value, "workingAge");
			return (Criteria) this;
		}

		public Criteria andWorkingAgeLessThanOrEqualTo(Integer value) {
			addCriterion("working_age <=", value, "workingAge");
			return (Criteria) this;
		}

		public Criteria andWorkingAgeIn(List<Integer> values) {
			addCriterion("working_age in", values, "workingAge");
			return (Criteria) this;
		}

		public Criteria andWorkingAgeNotIn(List<Integer> values) {
			addCriterion("working_age not in", values, "workingAge");
			return (Criteria) this;
		}

		public Criteria andWorkingAgeBetween(Integer value1, Integer value2) {
			addCriterion("working_age between", value1, value2, "workingAge");
			return (Criteria) this;
		}

		public Criteria andWorkingAgeNotBetween(Integer value1, Integer value2) {
			addCriterion("working_age not between", value1, value2, "workingAge");
			return (Criteria) this;
		}

		public Criteria andDegreeIsNull() {
			addCriterion("degree is null");
			return (Criteria) this;
		}

		public Criteria andDegreeIsNotNull() {
			addCriterion("degree is not null");
			return (Criteria) this;
		}

		public Criteria andDegreeEqualTo(String value) {
			addCriterion("degree =", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeNotEqualTo(String value) {
			addCriterion("degree <>", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeGreaterThan(String value) {
			addCriterion("degree >", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeGreaterThanOrEqualTo(String value) {
			addCriterion("degree >=", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeLessThan(String value) {
			addCriterion("degree <", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeLessThanOrEqualTo(String value) {
			addCriterion("degree <=", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeLike(String value) {
			addCriterion("degree like", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeNotLike(String value) {
			addCriterion("degree not like", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeIn(List<String> values) {
			addCriterion("degree in", values, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeNotIn(List<String> values) {
			addCriterion("degree not in", values, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeBetween(String value1, String value2) {
			addCriterion("degree between", value1, value2, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeNotBetween(String value1, String value2) {
			addCriterion("degree not between", value1, value2, "degree");
			return (Criteria) this;
		}

		public Criteria andNationIsNull() {
			addCriterion("nation is null");
			return (Criteria) this;
		}

		public Criteria andNationIsNotNull() {
			addCriterion("nation is not null");
			return (Criteria) this;
		}

		public Criteria andNationEqualTo(String value) {
			addCriterion("nation =", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotEqualTo(String value) {
			addCriterion("nation <>", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationGreaterThan(String value) {
			addCriterion("nation >", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationGreaterThanOrEqualTo(String value) {
			addCriterion("nation >=", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationLessThan(String value) {
			addCriterion("nation <", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationLessThanOrEqualTo(String value) {
			addCriterion("nation <=", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationLike(String value) {
			addCriterion("nation like", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotLike(String value) {
			addCriterion("nation not like", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationIn(List<String> values) {
			addCriterion("nation in", values, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotIn(List<String> values) {
			addCriterion("nation not in", values, "nation");
			return (Criteria) this;
		}

		public Criteria andNationBetween(String value1, String value2) {
			addCriterion("nation between", value1, value2, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotBetween(String value1, String value2) {
			addCriterion("nation not between", value1, value2, "nation");
			return (Criteria) this;
		}

		public Criteria andOriginIsNull() {
			addCriterion("origin is null");
			return (Criteria) this;
		}

		public Criteria andOriginIsNotNull() {
			addCriterion("origin is not null");
			return (Criteria) this;
		}

		public Criteria andOriginEqualTo(String value) {
			addCriterion("origin =", value, "origin");
			return (Criteria) this;
		}

		public Criteria andOriginNotEqualTo(String value) {
			addCriterion("origin <>", value, "origin");
			return (Criteria) this;
		}

		public Criteria andOriginGreaterThan(String value) {
			addCriterion("origin >", value, "origin");
			return (Criteria) this;
		}

		public Criteria andOriginGreaterThanOrEqualTo(String value) {
			addCriterion("origin >=", value, "origin");
			return (Criteria) this;
		}

		public Criteria andOriginLessThan(String value) {
			addCriterion("origin <", value, "origin");
			return (Criteria) this;
		}

		public Criteria andOriginLessThanOrEqualTo(String value) {
			addCriterion("origin <=", value, "origin");
			return (Criteria) this;
		}

		public Criteria andOriginLike(String value) {
			addCriterion("origin like", value, "origin");
			return (Criteria) this;
		}

		public Criteria andOriginNotLike(String value) {
			addCriterion("origin not like", value, "origin");
			return (Criteria) this;
		}

		public Criteria andOriginIn(List<String> values) {
			addCriterion("origin in", values, "origin");
			return (Criteria) this;
		}

		public Criteria andOriginNotIn(List<String> values) {
			addCriterion("origin not in", values, "origin");
			return (Criteria) this;
		}

		public Criteria andOriginBetween(String value1, String value2) {
			addCriterion("origin between", value1, value2, "origin");
			return (Criteria) this;
		}

		public Criteria andOriginNotBetween(String value1, String value2) {
			addCriterion("origin not between", value1, value2, "origin");
			return (Criteria) this;
		}

		public Criteria andIdCardIsNull() {
			addCriterion("id_card is null");
			return (Criteria) this;
		}

		public Criteria andIdCardIsNotNull() {
			addCriterion("id_card is not null");
			return (Criteria) this;
		}

		public Criteria andIdCardEqualTo(String value) {
			addCriterion("id_card =", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotEqualTo(String value) {
			addCriterion("id_card <>", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardGreaterThan(String value) {
			addCriterion("id_card >", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardGreaterThanOrEqualTo(String value) {
			addCriterion("id_card >=", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLessThan(String value) {
			addCriterion("id_card <", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLessThanOrEqualTo(String value) {
			addCriterion("id_card <=", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLike(String value) {
			addCriterion("id_card like", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotLike(String value) {
			addCriterion("id_card not like", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardIn(List<String> values) {
			addCriterion("id_card in", values, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotIn(List<String> values) {
			addCriterion("id_card not in", values, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardBetween(String value1, String value2) {
			addCriterion("id_card between", value1, value2, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotBetween(String value1, String value2) {
			addCriterion("id_card not between", value1, value2, "idCard");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_user
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
     * This class corresponds to the database table t_user
     *
     * @mbg.generated do_not_delete_during_merge Sat May 30 15:49:06 GMT+08:00 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}