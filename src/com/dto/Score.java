package com.dto;

/**
 * 成绩类
 * @author brimstone@126.com
 * @version 1.0
 * @since 2016年4月8日
 */
public class Score {

	private Course course;		//课程	
	private Student student;	//学生
	private double score;		//分数
		
	/**
	 * 空构造函数
	 */
	public Score(){		
	}	
	
	
	/**
	 * 带参数的构造函数
	 * @param course	课程
	 * @param student	学生
	 * @param score		分数
	 */
	public Score(Course course, Student student, double score) {
		super();
		this.course = course;
		this.student = student;
		this.score = score;
	}
	
	/**
	 * 带参数的构造函数
	 * @param course	课程
	 * @param student	学生
	 */
	public Score(Course course, Student student) {
		super();
		this.course = course;
		this.student = student;
	}


	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Override
	public String toString() {
		return "学号:" + this.student.getNum()
			+ "\t姓名:" + this.student.getName()
			+ "\t课程名:" + this.course.getName()
			+ "\t成绩:" + this.score;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Score))
			return false;
		else {
			Score score = (Score) obj;
			//以学生学号及课程编号判断两个成绩对象是否相同
			return this.student.getNum().equals(score.student.getNum()) && this.course.getCode()==score.course.getCode();
		}
	}
	
	@Override
	public int hashCode() {
		return this.student.hashCode()+this.course.hashCode();
	}
}
