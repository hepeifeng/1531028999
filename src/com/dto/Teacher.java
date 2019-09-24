package com.dto;

/**
 * ��ʦ��
 * @author brimstone@126.com
 * @version 1.0
 * @since 2012��12��8��
 */
public class Teacher extends Person {

	private String teacherCode; // �̹����
	private String password; // ����

	/**
	 * �չ��캯��
	 */
	public Teacher() {
	}

	/**
	 * ���������캯��
	 * @param teacherCode	�̹�����
	 */
	public Teacher(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	/**
	 * ���������캯��
	 * @param name	����
	 * @param sex	�Ա�
	 * @param age	����
	 * @param teacherCode	�̹�����
	 * @param password		����
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
		return "����:" + this.name + "\t�̹����:" + this.teacherCode + "\t�Ա�:"
				+ this.sex + "\t����:" + this.age;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Teacher))
			return false;
		else {
			Teacher teacher = (Teacher) obj;
			//�Խ�ʦ����Ϊ�����ж�������ʦ�����Ƿ���ͬ
			return this.teacherCode.equals(teacher.getTeacherCode());
		}
	}

	@Override
	public int hashCode() {
		Long teacherCode = Long.parseLong(this.teacherCode.replace("-", ""));
		return (int) teacherCode.intValue();
	}
}
