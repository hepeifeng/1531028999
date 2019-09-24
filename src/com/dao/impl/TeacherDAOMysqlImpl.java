package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.ITeacherDAO;
import com.db.DataBase;
import com.dto.Teacher;

public class TeacherDAOMysqlImpl implements ITeacherDAO {

	@Override
	public boolean delete(String teacherCode) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBase.getConn();
			ps = connection.prepareStatement("delete from teacher where teacherCode=?");
			ps.setString(1, teacherCode);
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
	public Teacher get(String teacherCode) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		Teacher teacher=null;		
		try {
			connection = DataBase.getConn();
			ps = connection.prepareStatement("select * from teacher where teacherCode= ?");
			ps.setString(1, teacherCode);
			rs=ps.executeQuery();
			if(rs.next()){
				teacher=new Teacher();
				teacher.setAge(rs.getInt("age"));
				teacher.setName(rs.getString("name"));
				teacher.setPassword(rs.getString("password"));
				teacher.setSex(rs.getString("sex"));
				teacher.setTeacherCode(rs.getString("teacherCode"));
			}
		} catch (Exception sqle) {
			throw sqle;
		} finally {
			rs.close();
			ps.close();
			connection.close();
		}
		return teacher;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dao.ITeacherDAO#list()
	 * @author Tom
	 * @return List集合
	 */
	@Override
	public List<Teacher> list() throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		ArrayList<Teacher> result=null;
		try {
			connection = DataBase.getConn();
			ps = connection.prepareStatement("select * from teacher");
			rs=ps.executeQuery();
			result=new ArrayList<Teacher>();
			while(rs.next()){
				Teacher teacher =new Teacher();
				teacher.setAge(rs.getInt("age"));
				teacher.setName(rs.getString("name"));
				teacher.setPassword(rs.getString("password"));
				teacher.setSex(rs.getString("sex"));
				teacher.setTeacherCode(rs.getString("teacherCode"));
				result.add(teacher);
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

	/*
	 * (non-Javadoc)
	 * @see com.dao.ITeacherDAO#login(java.lang.String, java.lang.String)
	 * @param   String teacherCode  String password
	 * 
	 */
	@Override
	public Teacher login(String teacherCode, String password) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		Statement statementTeacher=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		Teacher teacher=null;	
		/*
		 * 连接字符串
		 */
		//String sql="select * from teacher where teacherCode= '"+teacherCode+"' and password= '"+password+"'";
		String sql="select * from teacher where teacherCode=? and password=?";
		try {
			connection = DataBase.getConn();
			
			/*
			 * Statement实现
			 */
//			statementTeacher=connection.createStatement();
//			rs=statementTeacher.executeQuery(sql);
			/*
			 
			ps = connection.prepareStatement("select * from teacher where teacherCode= ? and password= ?");
			ps.setString(1, teacherCode);
			ps.setString(2, password);
			rs=ps.executeQuery();
			
			
		   */
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,teacherCode);
			preparedStatement.setString(2, password);
			
			rs=preparedStatement.executeQuery();
			
			if(rs.next()){
				teacher=new Teacher();
				teacher.setAge(rs.getInt("age"));
				teacher.setName(rs.getString("name"));
				teacher.setPassword(rs.getString("password"));
				teacher.setSex(rs.getString("sex"));
				teacher.setTeacherCode(rs.getString("teacherCode"));
			}
		} catch (Exception sqle) {
			throw sqle;
		} finally {
			//rs.close();
			//ps.close();
			connection.close();
		}
		return teacher;
	}

	@Override
	public boolean save(Teacher teacher) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBase.getConn();
			ps = connection
					.prepareStatement("insert into teacher(teacherCode,password,name,sex,age) values (?,?,?,?,?)");
			ps.setString(1, teacher.getTeacherCode());
			ps.setString(2, teacher.getPassword());
			ps.setString(3, teacher.getName());
			ps.setString(4, teacher.getSex());
			ps.setInt(5, teacher.getAge());
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
	public boolean update(Teacher teacher) throws Exception {
		Connection connection = DataBase.getConn();
		PreparedStatement ps = null;
		try {
			ps = connection
					.prepareStatement("update teacher set password=?,sex=?,age=? where teacherCode=?");			
			ps.setString(1, teacher.getPassword());
			ps.setString(2, teacher.getSex());
			ps.setInt(3, teacher.getAge());		
			ps.setString(4, teacher.getTeacherCode());
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
