package com.dao;

import java.util.List;

import com.dto.Student;

/**
 * ѧ��ҵ���߼��ӿ�
 * @author brimstone@126.com
 * @version 1.0
 * @since 2012��11��13��
 */
public interface IStudentDAO {

	/**
	 * ����˵�������ѧ��
	 * @param student	������ѧ��ʵ��
	 * @return			����ֵ����ӳɹ�����true�����ʧ�ܷ���false
	 * @throws Exception
	 */
	public boolean save(Student student) throws Exception;
	
	/**
	 * ����˵��������ѧ�Ż�ȡѧ��ʵ��
	 * @param num	������ѧ��
	 * @return		����ֵ�������򷵻�ѧ��ʵ�����������򷵻�null
	 * @throws Exception
	 */
	public Student get(String num) throws Exception;
	
	/**
	 * ����˵��������ѧ��ɾ��ѧ��ʵ��
	 * @param num	������ѧ��
	 * @return		����ֵ��ɾ���ɹ�����true��ɾ��ʧ�ܷ���false
	 * @throws Exception
	 */
	public boolean delete(String num) throws Exception;
	
	/**
	 * ����˵��������ѧ��ʵ��
	 * @param student	������ѧ��ʵ��
	 * @return			����ֵ�����³ɹ�����true������ʧ�ܷ���false
	 * @throws Exception
	 */
	public boolean update(Student student) throws Exception;
	
	/**
	 * ����˵����ѧ���б�����
	 * @param type	������1������ѧ������2��������������
	 * @return		����ֵ������������ѧ���б�
	 * @throws Exception
	 */
	public List<Student> list(int type) throws Exception;
	
	/**
	 * @param keyString 	��������ѯ�ؼ���
	 * @param type			��������ѯ���ͣ�1������ѧ�Ų�ѯ��2������������ѯ
	 * @return				����ֵ����ѯ����ѧ���б�
	 * @throws Exception
	 */
	public List<Student> find(String keyString , int type) throws Exception;
}
