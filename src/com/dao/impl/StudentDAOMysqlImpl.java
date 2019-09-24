package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.IStudentDAO;
import com.db.DataBase;
import com.dto.Student;

public class StudentDAOMysqlImpl implements IStudentDAO {

	@Override
	public boolean delete(String num) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBase.getConn();
			ps = connection.prepareStatement("delete from student where num=?");
			ps.setString(1, num);
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
	public List<Student> find(String keyString, int type) throws Exception {
//		1，按照学号查询；2，按照姓名查询
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<Student> foundStudentList=null;		
		try {
			connection = DataBase.getConn();
			switch (type) {
			case 1:
				ps = connection.prepareStatement("select * from student where num like ?" );
				break;
			case 2:
				ps = connection.prepareStatement("select * from student where name like ?");
				break;			
			}
			ps.setString(1, "%"+keyString+"%");
			rs=ps.executeQuery();
			foundStudentList=new ArrayList<Student>();
			while(rs.next()){
				Student student=new Student();
				student.setAge(rs.getInt("age"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setNum(rs.getString("num"));
				student.setDepartment(rs.getString("department"));
				student.setNativePlace(rs.getString("nativePlace"));
				student.setPhone(rs.getString("phone"));
				foundStudentList.add(student);
			}
		} catch (Exception sqle) {
			throw sqle;
		} finally {
			ps.close();
			connection.close();
		}
		return foundStudentList;
	}

	@Override
	public Student get(String num) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		Student student=null;		
		try {
			connection = DataBase.getConn();
			ps = connection.prepareStatement("select * from student where num= ?");
			ps.setString(1, num);
			rs=ps.executeQuery();
			if(rs.next()){
				student=new Student();
				student.setAge(rs.getInt("age"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setNum(rs.getString("num"));
				student.setDepartment(rs.getString("department"));
				student.setNativePlace(rs.getString("nativePlace"));
				student.setPhone(rs.getString("phone"));
			}
		} catch (Exception sqle) {
			throw sqle;
		} finally {
			rs.close();
			ps.close();
			connection.close();
		}
		return student;
	}

	@Override
	public List<Student> list(int type) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		ArrayList<Student> result=null;
		String orderBy="num";
		if(type==2)
			orderBy="name";
		try {
			connection = DataBase.getConn();
			ps = connection.prepareStatement("select * from student order by "+orderBy);
			rs=ps.executeQuery();
			result=new ArrayList<Student>();
			while(rs.next()){
				Student student=new Student();
				student.setAge(rs.getInt("age"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setNum(rs.getString("num"));
				student.setDepartment(rs.getString("department"));
				student.setNativePlace(rs.getString("nativePlace"));
				student.setPhone(rs.getString("phone"));
				result.add(student);
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
	public boolean save(Student student) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBase.getConn();
			ps = connection
					.prepareStatement("insert into student(num,name,sex,age,nativePlace,department,phone) values (?,?,?,?,?,?,?)");
			ps.setString(1, student.getNum());
			ps.setString(2, student.getName());
			ps.setString(3, student.getSex());
			ps.setInt(4, student.getAge());
			ps.setString(5, student.getNativePlace());
			ps.setString(6, student.getDepartment());
			ps.setString(7, student.getPhone());
			
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
	public boolean update(Student student) throws Exception {
		Connection connection =DataBase.getConn();
		PreparedStatement ps = null;
		try {
			ps = connection
					.prepareStatement("update student set sex=?,age=?,nativePlace=?,department=?,phone=? where num=?");			
			ps.setString(1, student.getSex());
			ps.setInt(2, student.getAge());
			ps.setString(3, student.getNativePlace());
			ps.setString(4, student.getDepartment());
			ps.setString(5, student.getPhone());
			ps.setString(6, student.getNum());
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
