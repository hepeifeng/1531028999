package com.dto;

/**
 * 教师类
 * @author brimstone@126.com
 * @version 1.0
 * @since 2012年12月8日
 */
public class Teacher extends Person {

	private String teacherCode; // 教工编号
	private String password; // 密码

	/**
	 * 空构造函数
	 */
	public Teacher() {
	}

	/**
	 * 带参数构造函数
	 * @param teacherCode	教工编码
	 */
	public Teacher(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	/**
	 * 带参数构造函数
	 * @param name	姓名
	 * @param sex	性别
	 * @param age	年龄
	 * @param teacherCode	教工编码
	 * @param password		密码
	 */
	public Teacher(String name, String sex, int age, String teacherCode,
			String password) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.teacherCode = teacherCode;
		this.password = password;
	}

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "姓名:" + this.name + "\t教工编号:" + this.teacherCode + "\t性别:"
				+ this.sex + "\t年龄:" + this.age;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Teacher))
			return false;
		else {
			Teacher teacher = (Teacher) obj;
			//以教师编码为依据判断两个教师对象是否相同
			return this.teacherCode.equals(teacher.getTeacherCode());
		}
	}

	@Override
	public int hashCode() {
		Long teacherCode = Long.parseLong(this.teacherCode.replace("-", ""));
		return (int) teacherCode.intValue();
	}
}
