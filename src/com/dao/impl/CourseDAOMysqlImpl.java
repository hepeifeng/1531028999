package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.ICourseDAO;
import com.db.DataBase;
import com.dto.Course;

public class CourseDAOMysqlImpl implements ICourseDAO {

	@Override
	public boolean delete(int code) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection =DataBase.getConn();
			ps = connection.prepareStatement("delete from corse where code=?");
			ps.setInt(1, code);
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
	public Course get(int code) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		Course course=null;		
		try {
			connection = DataBase.getConn();
			ps = connection.prepareStatement("select * from course where code= ?");
			ps.setInt(1, code);
			rs=ps.executeQuery();
			if(rs.next()){
				course=new Course();
				course.setCode(rs.getInt("code"));
				course.setName(rs.getString("name"));
			}
		} catch (Exception sqle) {
			throw sqle;
		} finally {
			rs.close();
			ps.close();
			connection.close();
		}
		return course;
	}

	@Override
	public List<Course> list() throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		ArrayList<Course> result=null;
		try {
			connection =DataBase.getConn();
			ps = connection.prepareStatement("select * from course");
			rs=ps.executeQuery();
			result=new ArrayList<Course>();
			while(rs.next()){
				Course course =new Course();
				course.setCode(rs.getInt("code"));
				course.setName(rs.getString("name"));
				result.add(course);
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
	public boolean save(Course course) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBase.getConn();
			ps = connection
					.prepareStatement("insert into course(code,name) values (?,?)");
			ps.setInt(1, course.getCode());
			ps.setString(2, course.getName());
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
	public boolean update(Course course) throws Exception {
		Connection connection = DataBase.getConn();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("update course set name=? where code=?");
			ps.setString(1, course.getName());
			ps.setInt(2, course.getCode());			
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
