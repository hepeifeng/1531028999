package com.dao;

import java.util.List;

import com.dto.Course;

/**
 * 课程业务逻辑接口
 * @author brimstone@126.com
 * @version 1.0
 * @since 2016年4月10日
 */
public interface ICourseDAO {

	/**
	 * 方法说明：添加课程
	 * @param course	参数：课程实例
	 * @return			返回值：添加成功返回true；添加失败返回false
	 * @throws Exception
	 */
	public boolean save(Course course) throws Exception;
	
	/**
	 * 方法说明：根据课程编号获取课程实例
	 * @param code	参数：课程编号
	 * @return		返回值：存在则返回课程实例，不存在则返回null
	 * @throws Exception
	 */
	public Course get(int code) throws Exception;
	
	/**
	 * 方法说明：根据课程编号删除课程实例
	 * @param code	参数：课程编号
	 * @return		返回值：删除成功返回true；删除失败返回false
	 * @throws Exception
	 */
	public boolean delete(int code) throws Exception;
	
	/**
	 * 方法说明：更新课程实例
	 * @param course	参数：课程实例
	 * @return			返回值：更新成功返回true；更新失败返回false
	 * @throws Exception
	 */
	public boolean update(Course course) throws Exception;
	
	/**
	 * 方法说明：课程列表
	 * @return		返回值：返回按照课程编号排序的课程列表
	 * @throws Exception
	 */
	public List<Course> list() throws Exception;
}
