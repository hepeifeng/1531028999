package com.dto;

/**
 * ѧ����
 * @author brimstone@126.com
 * @version 1.0
 * @since 2012��12��8��
 */
public class Student extends Person {

	private String num;// ѧ��
	private String nativePlace;// ����
	private String department;// ����ϵ��
	private String phone;// ��ϵ�绰
	
	/**
	 *�չ��캯�� 
	 */
	public Student(){		
	}
	
	/**
	 * ���������캯��
	 * @param num	ѧ��
	 */
	public Student(String num){	
		this.num=num;
	}	
	
	/**
	 * ���������캯��
	 * @param num	ѧ��
	 * @param name	����
	 * @param sex	�Ա�
	 * @param age	����
	 * @param nativePlace	����
	 * @param department	ϵ��
	 * @param phone			�绰
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
		return "����:" + this.name
			+ "\tѧ��:" + this.num
			+ "\t�Ա�:" + this.sex
			+ "\t����:" + this.age
			+ "\tϵ��:" + this.department
			+ "\t����:" + this.nativePlace
			+ "\t�绰:" + this.phone;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student))
			return false;
		else {
			Student student = (Student) obj;
			//��ѧ��ѧ��Ϊ�����ж�����ѧ�������Ƿ���ͬ
			return this.num.equals(student.getNum());
		}
	}

	@Override
	public int hashCode() {
		Long num=Long.parseLong(this.num.replace("-", ""));
		return (int)num.intValue();
	}

}
