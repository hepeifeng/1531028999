package com.dao;

import java.util.List;

import com.dto.Course;

/**
 * �γ�ҵ���߼��ӿ�
 * @author brimstone@126.com
 * @version 1.0
 * @since 2016��4��10��
 */
public interface ICourseDAO {

	/**
	 * ����˵������ӿγ�
	 * @param course	�������γ�ʵ��
	 * @return			����ֵ����ӳɹ�����true�����ʧ�ܷ���false
	 * @throws Exception
	 */
	public boolean save(Course course) throws Exception;
	
	/**
	 * ����˵�������ݿγ̱�Ż�ȡ�γ�ʵ��
	 * @param code	�������γ̱��
	 * @return		����ֵ�������򷵻ؿγ�ʵ�����������򷵻�null
	 * @throws Exception
	 */
	public Course get(int code) throws Exception;
	
	/**
	 * ����˵�������ݿγ̱��ɾ���γ�ʵ��
	 * @param code	�������γ̱��
	 * @return		����ֵ��ɾ���ɹ�����true��ɾ��ʧ�ܷ���false
	 * @throws Exception
	 */
	public boolean delete(int code) throws Exception;
	
	/**
	 * ����˵�������¿γ�ʵ��
	 * @param course	�������γ�ʵ��
	 * @return			����ֵ�����³ɹ�����true������ʧ�ܷ���false
	 * @throws Exception
	 */
	public boolean update(Course course) throws Exception;
	
	/**
	 * ����˵�����γ��б�
	 * @return		����ֵ�����ذ��տγ̱������Ŀγ��б�
	 * @throws Exception
	 */
	public List<Course> list() throws Exception;
}
