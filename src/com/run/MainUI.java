package com.run;

import java.util.Scanner;

import com.dao.ICourseDAO;
import com.dao.IScoreDAO;
import com.dao.IStudentDAO;
import com.dao.ITeacherDAO;
import com.dao.impl.*;
import com.dto.Course;
import com.dto.Score;
import com.dto.Student;
import com.dto.Teacher;

public class MainUI {


	
	private static ITeacherDAO teacherDAOImpl=new TeacherDAOMysqlImpl();
	private static ICourseDAO courseDAOImpl=new CourseDAOMysqlImpl();
	private static IStudentDAO studentDAOImpl=new StudentDAOMysqlImpl();
	private static IScoreDAO scoreDAOImpl = new ScoreDAOMysqlImpl();
	
	/**
	 * 方法说明：程序运行入口
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			println("\t\t\t\t欢迎使用学生成绩管理系统");
			println("*******************************************************************************");
			Scanner scan = new Scanner(System.in);
			boolean runFlag = true;
			while (runFlag) {
				println("当前位置>>>主菜单\t请输入序号选择用户类型并回车");
				println("1:教师\t2:学生\t0:退出");
				int operateIndex = scan.nextInt();
				switch (operateIndex) {
				case 1:
					TeacherUI.TeacherMenu();
					break;
				case 2:
					StudentUI.StudentMenu();
					break;
				case 0:
					runFlag = false;
					println(">>>系统退出");
					println("*******************************************************************************");
					break;
				default:
					println("请输入0-2之间的操作提示");
					break;
				}
			}
		} catch (Exception e) {
			println("操作异常,系统将返回主菜单。");
			System.out.print("异常说明：");
			println(e.toString());			
			main(args);
		}

	}
	
	/**
	 *  方法说明：控制台换行输出
	 * @param object
	 */
	public static void println(Object object) {
		System.out.println(object);
	}

}
