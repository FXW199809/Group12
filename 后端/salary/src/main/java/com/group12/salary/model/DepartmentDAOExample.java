package com.group12.salary.model;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public DepartmentDAOExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
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

		public Criteria andDepartmentNameIsNull() {
			addCriterion("department_name is null");
			return (Criteria) this;
		}

		public Criteria andDepartmentNameIsNotNull() {
			addCriterion("department_name is not null");
			return (Criteria) this;
		}

		public Criteria andDepartmentNameEqualTo(String value) {
			addCriterion("department_name =", value, "departmentName");
			return (Criteria) this;
		}

		public Criteria andDepartmentNameNotEqualTo(String value) {
			addCriterion("department_name <>", value, "departmentName");
			return (Criteria) this;
		}

		public Criteria andDepartmentNameGreaterThan(String value) {
			addCriterion("department_name >", value, "departmentName");
			return (Criteria) this;
		}

		public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
			addCriterion("department_name >=", value, "departmentName");
			return (Criteria) this;
		}

		public Criteria andDepartmentNameLessThan(String value) {
			addCriterion("department_name <", value, "departmentName");
			return (Criteria) this;
		}

		public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
			addCriterion("department_name <=", value, "departmentName");
			return (Criteria) this;
		}

		public Criteria andDepartmentNameLike(String value) {
			addCriterion("department_name like", value, "departmentName");
			return (Criteria) this;
		}

		public Criteria andDepartmentNameNotLike(String value) {
			addCriterion("department_name not like", value, "departmentName");
			return (Criteria) this;
		}

		public Criteria andDepartmentNameIn(List<String> values) {
			addCriterion("department_name in", values, "departmentName");
			return (Criteria) this;
		}

		public Criteria andDepartmentNameNotIn(List<String> values) {
			addCriterion("department_name not in", values, "departmentName");
			return (Criteria) this;
		}

		public Criteria andDepartmentNameBetween(String value1, String value2) {
			addCriterion("department_name between", value1, value2, "departmentName");
			return (Criteria) this;
		}

		public Criteria andDepartmentNameNotBetween(String value1, String value2) {
			addCriterion("department_name not between", value1, value2, "departmentName");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_department
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
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
     * This class corresponds to the database table t_department
     *
     * @mbg.generated do_not_delete_during_merge Tue Apr 21 18:01:03 GMT+08:00 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}