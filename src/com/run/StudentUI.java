package com.run;

import java.util.List;
import java.util.Scanner;

import com.dao.IScoreDAO;
import com.dao.IStudentDAO;
import com.dao.impl.*;
import com.dto.Score;
import com.dto.Student;

public class StudentUI {

	private static IStudentDAO studentDAOImpl=new StudentDAOMysqlImpl();
	private static IScoreDAO scoreDAOImpl = new ScoreDAOMysqlImpl();
	
	private static Student student;
	
	public static void StudentMenu() {		
		try {
			Scanner scan = new Scanner(System.in);
			println(">>>请输入学号：");
			String num=scan.next();
			student=studentDAOImpl.get(num);
			if(student==null){
				println("没有学号为"+num+"的学生，请重试");
				return;
			}
			println("欢迎你："+student.getName());
			
			boolean runFlag = true;
			while (runFlag) {
				println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				println("当前位置>>>主菜单>>>学生菜单\t 1:个人信息\t2:成绩单\t3:更新个人信息\t0:返回主菜单");
				int operateIndex = scan.nextInt();
				switch (operateIndex) {
				case 1:
					showStudent();
					break;
				case 2:
					gradebook();
					break;
				case 3:
					updateStudent();
					break;
				case 0:
					runFlag = false;
					println(">>>系统退出");
					break;
				default:
					println(">>>请输入0-3之间的操作提示");
					break;
				}
			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
		
	}
	
	/**
	 * 控制台换行输出
	 * @param object
	 */
	public static void println(Object object) {
		System.out.println(object);
	}
	
	/**
	 *方法说明:当前学生信息
	 */
	public static void showStudent() {		
		try {
			println(student);
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}
	
	/**
	 *方法说明:显示当前学生成绩列表 
	 */
	public static void gradebook() {
		try {
			List<Score> scoreList = scoreDAOImpl.getScoreByStudent(student);
			int passing = 0; // 及格课程数
			int fail = 0; // 不及格课程数
			double total = 0; // 总分
			for (int i = 0; i < scoreList.size(); i++) {
				Score score = scoreList.get(i);
				println(score);
				total += score.getScore();
				if (score.getScore() >= 60)
					passing += 1;
				else
					fail += 1;
			}
			println("课程门数："+scoreList.size()+"总分"+total+"\t"+passing+"门课及格\t"+fail+"门课不及格");
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}
	
	/**
	 * 方法说明：更新学生信息
	 */
	public static void updateStudent() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>请按照要求输入要修改的学生学籍信息（学号，姓名不能修改）");
			println(">>>原信息为：" + student);
			
			println(">>>请输入年龄,如无需修改请输入n：");
			String info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				student.setAge(Integer.parseInt(info));
			println(">>>请输入性别,如无需修改请输入n：");
			info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				student.setSex(info);
			println(">>>请输入系部,如无需修改请输入n：");
			info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				student.setDepartment(info);
			println(">>>请输入籍贯,如无需修改请输入n：");
			info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				student.setNativePlace(info);
			println(">>>请输入电话,如无需修改请输入n：");
			info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				student.setPhone(info);

			if (studentDAOImpl.update(student)) {
				println(">>>更新成功");
			} else {
				println(">>>更新操作失败，请重试");
			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}
}
