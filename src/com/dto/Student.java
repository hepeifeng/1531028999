package com.dto;

/**
 * 学生类
 * @author brimstone@126.com
 * @version 1.0
 * @since 2012年12月8日
 */
public class Student extends Person {

	private String num;// 学号
	private String nativePlace;// 籍贯
	private String department;// 所在系部
	private String phone;// 联系电话
	
	/**
	 *空构造函数 
	 */
	public Student(){		
	}
	
	/**
	 * 带参数构造函数
	 * @param num	学号
	 */
	public Student(String num){	
		this.num=num;
	}	
	
	/**
	 * 带参数构造函数
	 * @param num	学号
	 * @param name	姓名
	 * @param sex	性别
	 * @param age	年龄
	 * @param nativePlace	籍贯
	 * @param department	系部
	 * @param phone			电话
	 */
	public Student(String num, String name, String sex, int age, String nativePlace, String department,
			String phone) {
		super();
		this.num = num;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.nativePlace = nativePlace;
		this.department = department;
		this.phone = phone;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "姓名:" + this.name
			+ "\t学号:" + this.num
			+ "\t性别:" + this.sex
			+ "\t年龄:" + this.age
			+ "\t系部:" + this.department
			+ "\t籍贯:" + this.nativePlace
			+ "\t电话:" + this.phone;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student))
			return false;
		else {
			Student student = (Student) obj;
			//以学生学号为依据判断两个学生对象是否相同
			return this.num.equals(student.getNum());
		}
	}

	@Override
	public int hashCode() {
		Long num=Long.parseLong(this.num.replace("-", ""));
		return (int)num.intValue();
	}

}
