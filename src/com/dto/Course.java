package com.dto;

/**
 * 课程类
 * @author brimstone@126.com
 * @version 1.0
 * @since 2012年12月8日
 */
public class Course {

	private String name;	//课程名称
	private int code;		//课程编号
	
	/**
	 * 空构造函数
	 */
	public Course(){
	}
	
	/**
	 * 带参数构造函数
	 * @param code	课程编码
	 */
	public Course(int code){
		this.code=code;
	}	
	
	/**
	 * 带参数构造函数
	 * @param name	课程名称
	 * @param code	课程编码
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
		return "课程编号:" + this.code
			+ "\t课程名:" + this.name;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Course))
			return false;
		else {
			Course course = (Course) obj;
			//以课程编号为依据判断两个课程对象是否相同
			return this.code==course.getCode();
		}
	}

	@Override
	public int hashCode() {
		return this.code;
	}
}
