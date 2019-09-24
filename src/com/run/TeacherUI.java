package com.run;

import java.util.List;
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

/**
 * 教师用户交互类
 * @author brimstone@126.com
 * @version 1.0
 * @since 2012年12月8日
 */
public class TeacherUI {
	
	private static ITeacherDAO teacherDAOImpl=new TeacherDAOMysqlImpl();
	private static ICourseDAO courseDAOImpl=new CourseDAOMysqlImpl();
	private static IStudentDAO studentDAOImpl=new StudentDAOMysqlImpl();
	private static IScoreDAO scoreDAOImpl = new ScoreDAOMysqlImpl();

	private static Teacher teacher;
	/**
	 * 教师操作主菜单
	 */
	public static void TeacherMenu() {
		if (!login())
			return;
		try {
			Scanner scan = new Scanner(System.in);
			boolean runFlag = true;
			while (runFlag) {
				println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				println("当前位置>>>主菜单>>>教师菜单");
				println("1:课程管理\t2:学生管理\t3:成绩管理\t4:成绩统计\t5:系统设置\t0:返回主菜单");
				int operateIndex = scan.nextInt();
				switch (operateIndex) {
				case 1:
					courseManage();
					break;
				case 2:
					studentManage();
					break;
				case 3:
					scoreManage();
					break;
				case 4:
					statistics();
					break;
				case 5:
					setup();
					break;
				case 0:
					runFlag = false;
					println(">>>系统退出");
					break;
				default:
					println(">>>请输入0-2之间的操作提示");
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
	 * 教师登录
	 * @return 返回值:登录成功返回true,登录失败返回false;
	 */
	public static boolean login() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>请输入教师编号");
			String teacherCode = scan.next();
			println(">>>请输入登录密码");
			String password = scan.next();
			teacher = teacherDAOImpl.login(teacherCode, password);
			if (teacher != null) {
				println(">>>欢迎您:" + teacher.getName());
				return true;
			} else {
				println(">>>教师编号不存在或密码错误,请重试");
				return false;
			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
		return false;
	}

	/**
	 * 方法说明：课程管理菜单
	 */
	public static void courseManage() {
		try {
			Scanner scan = new Scanner(System.in);
			boolean runFlag = true;
			while (runFlag) {
				println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				println("当前位置>>>主菜单>>>教师菜单>>>课程管理\t请输入操作序号并回车");
				println("1:添加课程\t2:课程列表\t3:删除课程\t4:修改课程\t0:返回教师菜单");
				int operateIndex = scan.nextInt();
				switch (operateIndex) {
				case 1:
					saveCourse();
					break;
				case 2:
					listCourse();
					break;
				case 3:
					deleteCourse();
					break;
				case 4:
					updateCourse();
					break;
				case 0:
					runFlag = false;
					break;
				default:
					println(">>>请输入0-4之间的操作提示");
					break;
				}
			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}

	/**
	 * 方法说明：学生管理菜单
	 */
	public static void studentManage() {
		try {
			Scanner scan = new Scanner(System.in);
			boolean runFlag = true;
			while (runFlag) {
				println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				println("当前位置>>>主菜单>>>教师菜单>>>学生管理\t请输入操作序号并回车");
				println("1:添加学生\t2:学生列表\t3:删除学生\t4:更新学生\t5查找学生\t0:返回教师菜单");
				int operateIndex = scan.nextInt();
				switch (operateIndex) {
				case 1:
					saveStudent();
					break;
				case 2:
					listStudent();
					break;
				case 3:
					deleteStudent();
					break;
				case 4:
					updateStudent();
					break;
				case 5:
					findStudent();
					break;
				case 0:
					runFlag = false;
					break;
				default:
					println(">>>请输入0-5之间的操作提示");
					break;
				}
			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}

	/**
	 * 方法说明：成绩管理菜单
	 */
	public static void scoreManage() {
		try {
			Scanner scan = new Scanner(System.in);
			boolean runFlag = true;
			while (runFlag) {
				println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				println("当前位置>>>主菜单>>>教师菜单>>>成绩管理\t请输入操作序号并回车");
				println("1:添加成绩\t2:删除成绩\t3:更新成绩\t0:返回教师菜单");
				int operateIndex = scan.nextInt();
				switch (operateIndex) {
				case 1:
					saveScore();
					break;				
				case 2:
					deleteScore();
					break;
				case 3:
					updateScore();
					break;
				case 0:
					runFlag = false;
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
	 * 方法说明：统计菜单
	 */
	public static void statistics() {
		try {
			Scanner scan = new Scanner(System.in);
			boolean runFlag = true;
			while (runFlag) {
				println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				println("当前位置>>>主菜单>>>教师菜单>>>成绩统计\t请输入操作序号并回车");
				println("1:成绩单\t2:课程平均分\t3:查询单科成绩\t4:查询学生成绩\t0:返回教师菜单");
				int operateIndex = scan.nextInt();
				switch (operateIndex) {
				case 1:
					gradebook();
					break;
				case 2:
					average();
					break;
				case 3:
					listScoreByCourse();
					break;
				case 4:
					listScoreByStudent();
					break;
				case 0:
					runFlag = false;
					break;
				default:
					println(">>>请输入0-4之间的操作提示");
					break;
				}
			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}
	
	/**
	 * 方法说明:系统设置
	 */
	public static void setup() {
		try {
			Scanner scan = new Scanner(System.in);
			boolean runFlag = true;
			while (runFlag) {
				println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				println("当前位置>>>主菜单>>>教师菜单>>>系统设置\t请输入操作序号并回车");
				println("1:个人信息\t2:修改密码\t3:修改个人信息\t4:添加教师\t5:删除教师\t6:教师列表\t0:返回教师菜单");
				int operateIndex = scan.nextInt();
				switch (operateIndex) {
				case 1:
					showTeacher();
					break;
				case 2:
					changePassword();
					break;
				case 3:
					updateTeacher();
					break;	
				case 4:
					saveTeacher();
					break;
				case 5:
					deleteTeacher();
					break;
				case 6:
					listTeacher();
					break;	
				case 0:
					runFlag = false;
					break;
				default:
					println(">>>请输入0-6之间的操作提示");
					break;
				}
			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}

	/**
	 * 方法说明：添加课程
	 */
	public static void saveCourse() {
		Scanner scan = new Scanner(System.in);
		try {
			Course course = new Course();
			println(">>>请输入课程编号");
			course.setCode(scan.nextInt());
			println(">>>请输入课程名称");
			course.setName(scan.next());
			if (courseDAOImpl.save(course))
				println(">>>" + course.toString() + "添加成功");
			else
				println(">>>添加课程操作失败，请重试");
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}

	/**
	 * 方法说明：删除课程
	 */
	public static void deleteCourse() {
		Scanner scan = new Scanner(System.in);
		try {
			int code;
			println(">>>请输入要删除的课程编号");
			code = scan.nextInt();
			Course course = courseDAOImpl.get(code);
			if (course == null) {
				println(">>>没有编号为：" + code + "的课程，请重试");
				return;
			}

			if (courseDAOImpl.delete(code)
					&& scoreDAOImpl.deleteByCourse(course))
				println(">>>删除成功");
			else
				println(">>>删除操作失败，请重试");
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}

	/**
	 * 方法说明：更新课程
	 */
	public static void updateCourse() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>请输入要更新的课程编号");
			int code = scan.nextInt();
			Course course = courseDAOImpl.get(code);
			if (course == null) {
				println(">>>没有编号为：" + code + "的课程，请重试");
			} else {
				println(">>>原课程名称为:" + course.getName() + "，请输入新课程名称");
				course.setName(scan.next());
				if (courseDAOImpl.update(course))
					println(">>>课程更新为：" + course.toString());
				else
					println(">>>更新操作失败，请重试");
			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}

	/**
	 * 方法说明：课程列表
	 */
	public static void listCourse() {
		try {
			List<Course> courseList = courseDAOImpl.list();
			for (int i = 0; i < courseList.size(); i++) {
				println(courseList.get(i));
			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}

	/**
	 * 方法说明：添加学生
	 */
	public static void saveStudent() {
		Scanner scan = new Scanner(System.in);
		println(">>>请按照要求输入学生学籍信息。");
		Student student = new Student();
		try {
			println(">>>请输入学号：");
			student.setNum(scan.next());
			println(">>>请输入姓名：");
			student.setName(scan.next());
			println(">>>请输入年龄：");
			student.setAge(scan.nextInt());
			println(">>>请输入性别：");
			student.setSex(scan.next());
			println(">>>请输入系部：");
			student.setDepartment(scan.next());
			println(">>>请输入籍贯：");
			student.setNativePlace(scan.next());
			println(">>>请输入电话：");
			student.setPhone(scan.next());

			if (studentDAOImpl.save(student)) {
				println(">>>" + student + "添加成功");
			} else {
				println(">>>添加操作失败，请重试");
			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}

	/**
	 * 方法说明：删除学生
	 */
	public static void deleteStudent() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>请输入要删除的学生学号。");
			String num = scan.next();
			Student student = studentDAOImpl.get(num);
			if (student == null) {
				println(">>>没有学号为：" + num + "的学生,请重试");
				return;
			}
			if (studentDAOImpl.delete(num)
					&& scoreDAOImpl.deleteByStudent(student)) {
				println(">>>删除成功");
			} else {
				println(">>>删除操作失败，请重试");
			}
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
			println(">>>请按照要求输入要修改的学生学籍信息。");
			Student student = new Student();
			println(">>>请输入要修改的学生学号：");
			String num = scan.next();
			student = studentDAOImpl.get(num);
			if (student == null) {
				println(">>>没有学号为：" + num + "的学生,请重试");
				return;
			}
			println(">>>要修改的学生原信息为：" + student);

			println(">>>请输入姓名,如无需修改请输入n：");
			String info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				student.setName(info);

			println(">>>请输入年龄,如无需修改请输入n：");
			info = scan.next();
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

	/**
	 * 方法说明：查询学生
	 */
	public static void findStudent() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>请输入查询方式,1:按照学号查询；2：按照姓名查询");
			int type = scan.nextInt();
			println(">>>请输入查询关键字。");
			String keyString = scan.next();

			List<Student> studentList = studentDAOImpl.find(keyString, type);
			for (int i = 0; i < studentList.size(); i++) {
				Student student = studentList.get(i);
				println(student);
			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}

	/**
	 * 方法说明：学生列表，
	 */
	public static void listStudent() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>1:按照学号排序,2:按照姓名排序");
			List<Student> studentList = studentDAOImpl.list(scan.nextInt());
			for (int i = 0; i < studentList.size(); i++) {
				Student student = (Student) studentList.get(i);
				println(student);
			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}

	/**
	 * 方法说明：添加成绩
	 */
	public static void saveScore() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>请输入要录入成绩的课程编号：");
			int code = scan.nextInt();
			Course course = courseDAOImpl.get(code);
			if (course == null) {
				println(">>>没有编号为：" + code + "的课程，请重试");
				return;
			}
			println(">>>将录入成绩的课程为：" + course.toString());

			List<Student> studentList = studentDAOImpl.list(1);
			for (int i = 0; i < studentList.size(); i++) {
				Student student = studentList.get(i);
				Score score = scoreDAOImpl.get(student, course);
				if (score == null) {
					println(">>>请输入<" + student.getNum() + "|"
							+ student.getName() + ">的成绩");
					double scoreDobule = scan.nextDouble();
					score = new Score(course, student, scoreDobule);
					scoreDAOImpl.save(score);
				} else {
					println("<" + student.getNum() + "|" + student.getName()
							+ ">的成绩已存在：" + score.getScore());
				}

			}
		} catch (Exception e) {
			System.out.print("异常说明：");
			println(e.toString());
		}
	}

	/**
	 * 方法说明：删除成绩
	 */
	public static void deleteScore() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>请输入要删除成绩的课程编号：");
			int code = scan.nextInt();
			Course course = new Course(code);
			println(">>>请输入要删除成绩的学生学号：");
			String num = scan.next();
			Student student = new Student(num);
			Score score = scoreDAOImpl.get(student, course);
			if (score == null) {
				println(">>>没有学号为" + num + "，课程编号为" + code + "的成绩信息，请重试。");
				return;
			}
			if (scoreDAOImpl.delete(score))
				println(">>>成绩删除成功");
			else
				println(">>>成绩删除失败，请重试");
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}

	/**
	 * 方法说明:更新成绩
	 */
	public static void updateScore() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>请输入要修改成绩的课程编号：");
			int code = scan.nextInt();
			Course course = courseDAOImpl.get(code);
			if(course==null){
				println(">>>没有编号为"+code+"的课程，请重试");
				return;
			}
			println(">>>请输入要修改成绩的学生学号：");
			String num = scan.next();
			Student student = studentDAOImpl.get(num);
			if(student==null){
				println(">>>没有学号为"+code+"的学生，请重试");
				return;
			}
			Score score = scoreDAOImpl.get(student, course);
			if (score == null) {
				println(">>>没有学号为" + num + "，课程编号为" + code + "的成绩信息，请重试。");
				return;
			}
			println(">>>原成绩信息：" + score);
			println(">>>请输入新成绩：");
			score.setScore(scan.nextDouble());
			if (scoreDAOImpl.update(score))
				println(">>>成绩修改成功");
			else
				println(">>>成绩修改失败，请重试");
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}

	/**
	 * 方法说明:根据课程显示成绩列表
	 */
	public static void listScoreByCourse() {
		Scanner scan = new Scanner(System.in);
		try {

			println(">>>请输入课程编号");
			int code = scan.nextInt();
			Course course = courseDAOImpl.get(code);
			if(course==null){
				println(">>>没有课程编号为"+code+"的课程");
				return;
			}
			List<Score> scoreList = scoreDAOImpl.getScoreByCourse(course);
			int passing = 0; // 及格学生数
			int fail = 0; // 不及格学生数
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
			println("总人数："+scoreList.size()+"人\t平均分"+total/scoreList.size()+"\t"+passing+"人及格\t"+fail+"人不及格");
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}

	/**
	 *方法说明:根据学生显示成绩列表 
	 */
	public static void listScoreByStudent() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>请输入学生学号");
			String num = scan.next();
			Student student = studentDAOImpl.get(num);
			if(student==null){
				println(">>>没有学号为"+num+"的学生");
				return;
			}
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
	 * 方法说明:成绩单
	 */
	public static void gradebook() {
		try {
			List<Student> studentList = studentDAOImpl.list(1);
			List<Course> courseList = courseDAOImpl.list();
			System.out.print("\t\t\t");
			for (int i = 0; i < courseList.size(); i++) {
				Course course = courseList.get(i);
				System.out.print(course.getName());
				System.out.print("\t");
			}
			println("总分");
			
			for (int i = 0; i < studentList.size(); i++) {
				Student student = studentList.get(i);
				System.out.print(student.getNum() + "|" + student.getName()
						+ ":\t");
				double total = 0;
				for (int j = 0; j < courseList.size(); j++) {
					Course course = courseList.get(j);
					Score score = scoreDAOImpl.get(student, course);
					if (score == null)
						System.out.print("\t");
					else {
						System.out.print(score.getScore());
						System.out.print("\t");
						total += score.getScore();
					}
				}
				System.out.println(total);
			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
			e.printStackTrace();
		}
	}

	
	/**
	 * 方法说明:课程平均分列表
	 */
	public static void average() {
		try {
			List<Course> courseList = courseDAOImpl.list();
			for (int i = 0; i < courseList.size(); i++) {
				Course course = courseList.get(i);
				System.out.print("<" + course.getCode() + "|"
						+ course.getName() + ">平均分为：");
				double total = 0;
				List<Score> scoreList = scoreDAOImpl.getScoreByCourse(course);
				for (int j = 0; j < scoreList.size(); j++) {
					Score score = scoreList.get(j);
					total += score.getScore();
				}
				System.out.print(total / scoreList.size() + "（总人数："
						+ scoreList.size() + ")");
				println("");
			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}


	/**
	 * 方法说明：显示登录教师个人信息
	 */
	public static void showTeacher(){
		println(teacher);
	}
	
	/**
	 * 方法说明：更改密码
	 */
	public static void changePassword(){
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>请输入原密码");
			String oldPassword = scan.next();
			if(!oldPassword.equals(teacher.getPassword())){
				println(">>>密码错误，请重试");
				return;
			}
			println(">>>请输入新密码");
			String newPassword = scan.next();
			println(">>>请再次输入新密码");
			String confirmPassword = scan.next();
			if(!newPassword.equals(confirmPassword)){
				println(">>>两次输入的密码不相同，请重试");
				return;
			}
			teacher.setPassword(newPassword);
			if(teacherDAOImpl.update(teacher))
				println(">>>密码修改成功");
			else
				println(">>>密码修改失败，请重试");					
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}
	
	/**
	 * 方法说明:修改当前登录教师个人信息
	 */
	public static void updateTeacher(){
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>请按照要求输入教师信息（教工编号，姓名不能修改）");
			println(">>>原信息为：" + teacher);
			
			println(">>>请输入年龄,如无需修改请输入n：");
			String info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				teacher.setAge(Integer.parseInt(info));
			println(">>>请输入性别,如无需修改请输入n：");
			info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				teacher.setSex(info);

			if(teacherDAOImpl.update(teacher))
				println(">>>教师个人信息修改成功");
			else
				println(">>>教师个人信息修改失败，请重试");					
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}
	
	
	/**
	 * 方法说明:添加教师
	 */
	public static void saveTeacher() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>请按照要求输入教师信息（教工编号，姓名输入后不能修改）");
			Teacher teacher=new Teacher();
			println(">>>请输入教工编号：");
			teacher.setTeacherCode(scan.next());
			println(">>>请输入姓名");
			teacher.setName(scan.next());
			println(">>>请输入登录密码");
			teacher.setPassword(scan.next());
			println(">>>请输入年龄：");
			teacher.setAge(scan.nextInt());
			println(">>>请输入性别");
			teacher.setSex(scan.next());

			if (teacherDAOImpl.save(teacher))
				println(">>>教师添加成功");
			else
				println(">>>教师添加失败，请重试");
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}
	
	public static void deleteTeacher(){
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>请输入要删除的教师教工编号");
			String teacherCode=scan.next();
			if(teacherCode.equals(teacher.getTeacherCode())){
				println(">>>不能删除自己");
				return;
			}
			
			if(teacherDAOImpl.get(teacherCode)==null){
				println("没有编号为:"+teacherCode+"的教师，请重试");
				return;
			}
			
			if (teacherDAOImpl.delete(teacherCode))
				println(">>>教师删除成功");
			else
				println(">>>教师删除失败，请重试");
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}
	
	/**
	 * 方法说明:教师列表
	 */
	public static void listTeacher(){
		try {
			List<Teacher> teacherList=teacherDAOImpl.list();
			for (int i = 0; i < teacherList.size(); i++) {
				Teacher teacher=teacherList.get(i);
				println(teacher);
			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			println(e.toString());
		}
	}
}
