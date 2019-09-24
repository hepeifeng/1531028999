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
	 * 创建数据库连接
	 * @return	返回值：数据库连接对象
	 * @throws Exception
	 */
	    public static Connection getConn() throws Exception {
		String url = "jdbc:mysql://localhost:3306/score?useUnicode=true&characterEncoding=UTF-8"; // 数据库连接字串
		String userName = "root"; // 数据库用户名称
		String driver = "com.mysql.jdbc.Driver"; // 数据库驱动名称
		String pwd = "root"; // 数据库用户登陆密码
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
