package com.dao;

import java.util.List;

import com.dto.Student;

/**
 * 学生业务逻辑接口
 * @author brimstone@126.com
 * @version 1.0
 * @since 2012年11月13日
 */
public interface IStudentDAO {

	/**
	 * 方法说明：添加学生
	 * @param student	参数：学生实例
	 * @return			返回值：添加成功返回true；添加失败返回false
	 * @throws Exception
	 */
	public boolean save(Student student) throws Exception;
	
	/**
	 * 方法说明：根据学号获取学生实例
	 * @param num	参数：学号
	 * @return		返回值：存在则返回学生实例，不存在则返回null
	 * @throws Exception
	 */
	public Student get(String num) throws Exception;
	
	/**
	 * 方法说明：根据学号删除学生实例
	 * @param num	参数：学号
	 * @return		返回值：删除成功返回true；删除失败返回false
	 * @throws Exception
	 */
	public boolean delete(String num) throws Exception;
	
	/**
	 * 方法说明：更新学生实例
	 * @param student	参数：学生实例
	 * @return			返回值：更新成功返回true；更新失败返回false
	 * @throws Exception
	 */
	public boolean update(Student student) throws Exception;
	
	/**
	 * 方法说明：学生列表排序
	 * @param type	参数：1，按照学号排序；2，按照姓名排序
	 * @return		返回值：返回排序后的学生列表
	 * @throws Exception
	 */
	public List<Student> list(int type) throws Exception;
	
	/**
	 * @param keyString 	参数：查询关键字
	 * @param type			参数：查询类型，1，按照学号查询；2，按照姓名查询
	 * @return				返回值：查询到的学生列表
	 * @throws Exception
	 */
	public List<Student> find(String keyString , int type) throws Exception;
}
