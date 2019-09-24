package com.dto;

/**
 * �ɼ���
 * @author brimstone@126.com
 * @version 1.0
 * @since 2016��4��8��
 */
public class Score {

	private Course course;		//�γ�	
	private Student student;	//ѧ��
	private double score;		//����
		
	/**
	 * �չ��캯��
	 */
	public Score(){		
	}	
	
	
	/**
	 * �������Ĺ��캯��
	 * @param course	�γ�
	 * @param student	ѧ��
	 * @param score		����
	 */
	public Score(Course course, Student student, double score) {
		super();
		this.course = course;
		this.student = student;
		this.score = score;
	}
	
	/**
	 * �������Ĺ��캯��
	 * @param course	�γ�
	 * @param student	ѧ��
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
		return "ѧ��:" + this.student.getNum()
			+ "\t����:" + this.student.getName()
			+ "\t�γ���:" + this.course.getName()
			+ "\t�ɼ�:" + this.score;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Score))
			return false;
		else {
			Score score = (Score) obj;
			//��ѧ��ѧ�ż��γ̱���ж������ɼ������Ƿ���ͬ
			return this.student.getNum().equals(score.student.getNum()) && this.course.getCode()==score.course.getCode();
		}
	}
	
	@Override
	public int hashCode() {
		return this.student.hashCode()+this.course.hashCode();
	}
}
