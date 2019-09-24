package com.dto;

/**
 * �γ���
 * @author brimstone@126.com
 * @version 1.0
 * @since 2012��12��8��
 */
public class Course {

	private String name;	//�γ�����
	private int code;		//�γ̱��
	
	/**
	 * �չ��캯��
	 */
	public Course(){
	}
	
	/**
	 * ���������캯��
	 * @param code	�γ̱���
	 */
	public Course(int code){
		this.code=code;
	}	
	
	/**
	 * ���������캯��
	 * @param name	�γ�����
	 * @param code	�γ̱���
	 */
	public Course(int code, String name) {
		super();
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "�γ̱��:" + this.code
			+ "\t�γ���:" + this.name;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Course))
			return false;
		else {
			Course course = (Course) obj;
			//�Կγ̱��Ϊ�����ж������γ̶����Ƿ���ͬ
			return this.code==course.getCode();
		}
	}

	@Override
	public int hashCode() {
		return this.code;
	}
}
