package com.dto;

/**
 * �˳�����
 * @author brimstone@126.com
 * @version 1.0
 * @since 2016��4��8��
 */
public abstract class Person {

	protected String name;		//����
	protected String sex;		//�Ա�
	protected int age;		//����
	
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
