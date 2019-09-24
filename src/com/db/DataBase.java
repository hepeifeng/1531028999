package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashSet;
import java.util.Set;

import com.dto.Course;
import com.dto.Student;
import com.dto.Score;
import com.dto.Teacher;

public class DataBase {
	/**
	 * �������ݿ�����
	 * @return	����ֵ�����ݿ����Ӷ���
	 * @throws Exception
	 */
	    public static Connection getConn() throws Exception {
		String url = "jdbc:mysql://localhost:3306/score?useUnicode=true&characterEncoding=UTF-8"; // ���ݿ������ִ�
		String userName = "root"; // ���ݿ��û�����
		String driver = "com.mysql.jdbc.Driver"; // ���ݿ���������
		String pwd = "root"; // ���ݿ��û���½����
		try {
			Connection con;
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, pwd);
			return con;
		} catch (Exception e) {
			throw e;			
		}
	}
}
