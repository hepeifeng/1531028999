package com.dao;

import java.util.List;

import com.dto.Course;
import com.dto.Score;
import com.dto.Student;

/**
 * 成绩业务逻辑接口
 * @author brimstone@126.com
 * @version 1.0
 * @since 2012年11月13日
 */
public interface IScoreDAO {
	
	/**
	 * 方法说明：添加成绩
	 * @param score		参数：成绩实例
	 * @return			返回值：添加成功返回true，失败返回false
	 * @throws Exception
	 */
	public boolean save(Score score) throws Exception;
	
	/**
	 * 方法说明：删除成绩
	 * @param score		参数：要删除的成绩实例（应初始化学生属性及课程属性）
	 * @return			返回值：删除成功返回true，删除失败返回false
	 * @throws Exception
	 */
	public boolean delete(Score score) throws Exception;
	 
	/**
	 * 方法说明：更新成绩
	 * @param score		参数：更新后的成绩实例
	 * @return			返回值：更新成功返回true，更新失败返回false
	 * @throws Exception
	 */
	public boolean update(Score score) throws Exception;
	
	/**
	 * 方法说明：根据学生及课程获取成绩实例
	 * @param student	参数：要获取成绩的学生
	 * @param course	参数：要获取成绩的课程
	 * @return			返回值：获取成功返回成绩实例，失败返回null
	 * @throws Exception
	 */
	public Score get(Student student,Course course) throws Exception;
		
	/**
	 * 方法说明：获取某位学生的成绩
	 * @param student	参数：学生实例
	 * @return			返回值：该学生所有成绩List
	 * @throws Exception
	 */
	public List<Score> getScoreByStudent(Student student) throws Exception;
	
	/**
	 * 方法说明：获取某门课程的所有成绩
	 * @param course	参数：课程实例
	 * @return			返回值：该课程所有成绩List
	 * @throws Exception
	 */
	public List<Score> getScoreByCourse(Course course) throws Exception;
	
	/**
	 * 方法说明：删除某门课程所有成绩
	 * @param course	参数：课程实例
	 * @return			返回值：删除成功返回true，删除失败返回false
	 * @throws Exception
	 */
	public boolean deleteByCourse(Course course) throws Exception;
	
	/**
	 * 方法说明：删除某学生所有成绩
	 * @param student	参数：学生实例
	 * @return			返回值：删除成功返回true，删除失败返回false
	 * @throws Exception
	 */
	public boolean deleteByStudent(Student student) throws Exception;
	
}
