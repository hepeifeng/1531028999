package com.dao;

import java.util.List;

import com.dto.Teacher;
/**
 * ��ʦҵ���߼��ӿ�
 * @author brimstone@126.com
 * @version 1.0
 * @since 2012��11��13��
 */
public interface ITeacherDAO {

	/**
	 * ����˵������ӽ�ʦ
	 * @param teacher	��������ʦʵ��
	 * @return			����ֵ����ӳɹ�����true�����ʧ�ܷ���false
	 * @throws Exception
	 */
	public boolean save(Teacher teacher) throws Exception;
	
	/**
	 * ����˵�������ݽ̹���Ż�ȡ��ʦʵ��
	 * @param teacherCode	�������̹����
	 * @return		����ֵ�������򷵻ؽ�ʦʵ�����������򷵻�null
	 * @throws Exception
	 */
	public Teacher get(String teacherCode) throws Exception;
	
	/**
	 * ����˵�������ݽ̹����ɾ����ʦʵ��
	 * @param teacherCode	�������̹����
	 * @return		����ֵ��ɾ���ɹ�����true��ɾ��ʧ�ܷ���false
	 * @throws Exception
	 */
	public boolean delete(String teacherCode) throws Exception;
	
	/**
	 * ����˵�������½�ʦʵ��
	 * @param teacher	��������ʦʵ��
	 * @return			����ֵ�����³ɹ�����true������ʧ�ܷ���false
	 * @throws Exception
	 */
	public boolean update(Teacher teacher) throws Exception;
	
	/**
	 * ����˵������ʦ��¼
	 * @param teacherCode	�������̹�����
	 * @param password		����������
	 * @return				����ֵ����¼�ɹ����ؽ�ʦʵ������¼ʧ�ܷ���null
	 * @throws Exception
	 */
	public Teacher login(String teacherCode ,String password) throws Exception;
	/**
	 * ����˵������ʦ�б�����
	 * @return		����ֵ�����ظ��ݽ̹���������Ľ�ʦ�б�
	 * @throws Exception
	 */
	public List<Teacher> list() throws Exception;
}
