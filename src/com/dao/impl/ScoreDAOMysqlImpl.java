package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.IScoreDAO;
import com.db.DataBase;
import com.dto.Course;
import com.dto.Score;
import com.dto.Student;

public class ScoreDAOMysqlImpl implements IScoreDAO {

	@Override
	public boolean delete(Score score) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBase.getConn();
			ps = connection.prepareStatement("delete from score where studentNum=? and courseCode=?");
			ps.setString(1, score.getStudent().getNum());
			ps.setInt(2, score.getCourse().getCode());
			if (ps.executeUpdate() > 0)
				return true;
			else
				return false;
		} catch (Exception sqle) {
			throw sqle;
		} finally {
			ps.close();
			connection.close();
		}
	}

	@Override
	public boolean deleteByCourse(Course course) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection =DataBase.getConn();
			ps = connection.prepareStatement("delete from score where courseCode=?");
			ps.setInt(1,course.getCode());
			if (ps.executeUpdate() > 0)
				return true;
			else
				return false;
		} catch (Exception sqle) {
			throw sqle;
		} finally {
			ps.close();
			connection.close();
		}
	}

	@Override
	public boolean deleteByStudent(Student student) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBase.getConn();
			ps = connection.prepareStatement("delete from score where studentNum=?");
			ps.setString(1, student.getNum());
			if (ps.executeUpdate() > 0)
				return true;
			else
				return false;
		} catch (Exception sqle) {
			throw sqle;
		} finally {
			ps.close();
			connection.close();
		}
	}

	@Override
	public Score get(Student student, Course course) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		Score score=null;		
		try {
			connection = DataBase.getConn();
			ps = connection.prepareStatement("select * from score where studentNum=? and courseCode=?");
			ps.setString(1, student.getNum());
			ps.setInt(2, course.getCode());
			rs=ps.executeQuery();
			if(rs.next()){
				score=new Score();
				score.setScore(rs.getDouble("score"));
				score.setCourse(course);
				score.setStudent(student);
			}			
		} catch (Exception sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			rs.close();
			ps.close();
			connection.close();
		}
		return score;
	}

	@Override
	public List<Score> getScoreByCourse(Course course) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		ArrayList<Score> result=null;
		try {
			connection = DataBase.getConn();
			ps = connection.prepareStatement("select * from scoreView where courseCode=?");
			ps.setInt(1, course.getCode());
			rs=ps.executeQuery();
			result=new ArrayList<Score>();
			while(rs.next()){
				Score score=new Score();
				score.setScore(rs.getDouble("score"));
				course.setName(rs.getString("courseName"));
				score.setCourse(course);
				//实例化学生并赋值
				Student student=new Student();
				student.setAge(rs.getInt("age"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setNum(rs.getString("studentNum"));
				student.setDepartment(rs.getString("department"));
				student.setNativePlace(rs.getString("nativePlace"));
				student.setPhone(rs.getString("phone"));
				score.setStudent(student);
				result.add(score);
			}
		} catch (Exception sqle) {
			throw sqle;
		} finally {
			rs.close();
			ps.close();
			connection.close();
		}
		return result;
	}

	@Override
	public List<Score> getScoreByStudent(Student student) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		ArrayList<Score> result=null;
		try {
			connection = DataBase.getConn();
			ps = connection.prepareStatement("select * from scoreView where studentNum=?");
			ps.setString(1, student.getNum());
			rs=ps.executeQuery();
			result=new ArrayList<Score>();
			while(rs.next()){
				Score score=new Score();
				score.setScore(rs.getDouble("score"));
				
				student.setAge(rs.getInt("age"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setDepartment(rs.getString("department"));
				student.setNativePlace(rs.getString("nativePlace"));
				student.setPhone(rs.getString("phone"));
				score.setStudent(student);
				
				Course course=new Course();
				course.setCode(rs.getInt("courseCode"));
				course.setName(rs.getString("courseName"));
				score.setCourse(course);
				result.add(score);
			}
		} catch (Exception sqle) {
			throw sqle;
		} finally {
			rs.close();
			ps.close();
			connection.close();
		}
		return result;
	}

	@Override
	public boolean save(Score score) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBase.getConn();
			ps = connection.prepareStatement("insert into score(studentNum,courseCode,score) values (?,?,?)");
			ps.setString(1, score.getStudent().getNum());
			ps.setInt(2, score.getCourse().getCode());
			ps.setDouble(3, score.getScore());			
			
			if (ps.executeUpdate() > 0)
				return true;
			else
				return false;
		} catch (Exception sqle) {
			throw sqle;
		}finally {
			ps.close();
			connection.close();
		}
	}

	@Override
	public boolean update(Score score) throws Exception {
		Connection connection = DataBase.getConn();
		PreparedStatement ps = null;
		try {
			ps = connection
					.prepareStatement("update score set score=? where studentNum=? and courseCode=?");			
			ps.setDouble(1, score.getScore());
			ps.setString(2, score.getStudent().getNum());
			ps.setInt(3, score.getCourse().getCode());			
			if (ps.executeUpdate() > 0)
				return true;
			else
				return false;
		} catch (Exception sqle) {
			throw sqle;
		} finally {
			ps.close();
			connection.close();
		}
	}
	
}
