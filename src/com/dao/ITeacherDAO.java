package com.dao;

import java.util.List;

import com.dto.Teacher;
/**
 * 教师业务逻辑接口
 * @author brimstone@126.com
 * @version 1.0
 * @since 2012年11月13日
 */
public interface ITeacherDAO {

	/**
	 * 方法说明：添加教师
	 * @param teacher	参数：教师实例
	 * @return			返回值：添加成功返回true；添加失败返回false
	 * @throws Exception
	 */
	public boolean save(Teacher teacher) throws Exception;
	
	/**
	 * 方法说明：根据教工编号获取教师实例
	 * @param teacherCode	参数：教工编号
	 * @return		返回值：存在则返回教师实例，不存在则返回null
	 * @throws Exception
	 */
	public Teacher get(String teacherCode) throws Exception;
	
	/**
	 * 方法说明：根据教工编号删除教师实例
	 * @param teacherCode	参数：教工编号
	 * @return		返回值：删除成功返回true；删除失败返回false
	 * @throws Exception
	 */
	public boolean delete(String teacherCode) throws Exception;
	
	/**
	 * 方法说明：更新教师实例
	 * @param teacher	参数：教师实例
	 * @return			返回值：更新成功返回true；更新失败返回false
	 * @throws Exception
	 */
	public boolean update(Teacher teacher) throws Exception;
	
	/**
	 * 方法说明：教师登录
	 * @param teacherCode	参数：教工编码
	 * @param password		参数：密码
	 * @return				返回值：登录成功返回教师实例、登录失败返回null
	 * @throws Exception
	 */
	public Teacher login(String teacherCode ,String password) throws Exception;
	/**
	 * 方法说明：教师列表排序
	 * @return		返回值：返回根据教工编号排序后的教师列表
	 * @throws Exception
	 */
	public List<Teacher> list() throws Exception;
}
