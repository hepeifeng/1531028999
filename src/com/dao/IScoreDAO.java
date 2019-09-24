package com.dao;

import java.util.List;

import com.dto.Course;
import com.dto.Score;
import com.dto.Student;

/**
 * �ɼ�ҵ���߼��ӿ�
 * @author brimstone@126.com
 * @version 1.0
 * @since 2012��11��13��
 */
public interface IScoreDAO {
	
	/**
	 * ����˵������ӳɼ�
	 * @param score		�������ɼ�ʵ��
	 * @return			����ֵ����ӳɹ�����true��ʧ�ܷ���false
	 * @throws Exception
	 */
	public boolean save(Score score) throws Exception;
	
	/**
	 * ����˵����ɾ���ɼ�
	 * @param score		������Ҫɾ���ĳɼ�ʵ����Ӧ��ʼ��ѧ�����Լ��γ����ԣ�
	 * @return			����ֵ��ɾ���ɹ�����true��ɾ��ʧ�ܷ���false
	 * @throws Exception
	 */
	public boolean delete(Score score) throws Exception;
	 
	/**
	 * ����˵�������³ɼ�
	 * @param score		���������º�ĳɼ�ʵ��
	 * @return			����ֵ�����³ɹ�����true������ʧ�ܷ���false
	 * @throws Exception
	 */
	public boolean update(Score score) throws Exception;
	
	/**
	 * ����˵��������ѧ�����γ̻�ȡ�ɼ�ʵ��
	 * @param student	������Ҫ��ȡ�ɼ���ѧ��
	 * @param course	������Ҫ��ȡ�ɼ��Ŀγ�
	 * @return			����ֵ����ȡ�ɹ����سɼ�ʵ����ʧ�ܷ���null
	 * @throws Exception
	 */
	public Score get(Student student,Course course) throws Exception;
		
	/**
	 * ����˵������ȡĳλѧ���ĳɼ�
	 * @param student	������ѧ��ʵ��
	 * @return			����ֵ����ѧ�����гɼ�List
	 * @throws Exception
	 */
	public List<Score> getScoreByStudent(Student student) throws Exception;
	
	/**
	 * ����˵������ȡĳ�ſγ̵����гɼ�
	 * @param course	�������γ�ʵ��
	 * @return			����ֵ���ÿγ����гɼ�List
	 * @throws Exception
	 */
	public List<Score> getScoreByCourse(Course course) throws Exception;
	
	/**
	 * ����˵����ɾ��ĳ�ſγ����гɼ�
	 * @param course	�������γ�ʵ��
	 * @return			����ֵ��ɾ���ɹ�����true��ɾ��ʧ�ܷ���false
	 * @throws Exception
	 */
	public boolean deleteByCourse(Course course) throws Exception;
	
	/**
	 * ����˵����ɾ��ĳѧ�����гɼ�
	 * @param student	������ѧ��ʵ��
	 * @return			����ֵ��ɾ���ɹ�����true��ɾ��ʧ�ܷ���false
	 * @throws Exception
	 */
	public boolean deleteByStudent(Student student) throws Exception;
	
}
