package com.dto;

/**
 * 人抽象类
 * @author brimstone@126.com
 * @version 1.0
 * @since 2016年4月8日
 */
public abstract class Person {

	protected String name;		//姓名
	protected String sex;		//性别
	protected int age;		//年龄
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
