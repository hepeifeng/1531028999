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
 * ��ʦ�û�������
 * @author brimstone@126.com
 * @version 1.0
 * @since 2012��12��8��
 */
public class TeacherUI {
	
	private static ITeacherDAO teacherDAOImpl=new TeacherDAOMysqlImpl();
	private static ICourseDAO courseDAOImpl=new CourseDAOMysqlImpl();
	private static IStudentDAO studentDAOImpl=new StudentDAOMysqlImpl();
	private static IScoreDAO scoreDAOImpl = new ScoreDAOMysqlImpl();

	private static Teacher teacher;
	/**
	 * ��ʦ�������˵�
	 */
	public static void TeacherMenu() {
		if (!login())
			return;
		try {
			Scanner scan = new Scanner(System.in);
			boolean runFlag = true;
			while (runFlag) {
				println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				println("��ǰλ��>>>���˵�>>>��ʦ�˵�");
				println("1:�γ̹���\t2:ѧ������\t3:�ɼ�����\t4:�ɼ�ͳ��\t5:ϵͳ����\t0:�������˵�");
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
					println(">>>ϵͳ�˳�");
					break;
				default:
					println(">>>������0-2֮��Ĳ�����ʾ");
					break;
				}
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}

	}

	/**
	 * ����̨�������
	 * @param object
	 */
	public static void println(Object object) {
		System.out.println(object);
	}

	/**
	 * ��ʦ��¼
	 * @return ����ֵ:��¼�ɹ�����true,��¼ʧ�ܷ���false;
	 */
	public static boolean login() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>�������ʦ���");
			String teacherCode = scan.next();
			println(">>>�������¼����");
			String password = scan.next();
			teacher = teacherDAOImpl.login(teacherCode, password);
			if (teacher != null) {
				println(">>>��ӭ��:" + teacher.getName());
				return true;
			} else {
				println(">>>��ʦ��Ų����ڻ��������,������");
				return false;
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
		return false;
	}

	/**
	 * ����˵�����γ̹���˵�
	 */
	public static void courseManage() {
		try {
			Scanner scan = new Scanner(System.in);
			boolean runFlag = true;
			while (runFlag) {
				println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				println("��ǰλ��>>>���˵�>>>��ʦ�˵�>>>�γ̹���\t�����������Ų��س�");
				println("1:��ӿγ�\t2:�γ��б�\t3:ɾ���γ�\t4:�޸Ŀγ�\t0:���ؽ�ʦ�˵�");
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
					println(">>>������0-4֮��Ĳ�����ʾ");
					break;
				}
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵����ѧ������˵�
	 */
	public static void studentManage() {
		try {
			Scanner scan = new Scanner(System.in);
			boolean runFlag = true;
			while (runFlag) {
				println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				println("��ǰλ��>>>���˵�>>>��ʦ�˵�>>>ѧ������\t�����������Ų��س�");
				println("1:���ѧ��\t2:ѧ���б�\t3:ɾ��ѧ��\t4:����ѧ��\t5����ѧ��\t0:���ؽ�ʦ�˵�");
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
					println(">>>������0-5֮��Ĳ�����ʾ");
					break;
				}
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵�����ɼ�����˵�
	 */
	public static void scoreManage() {
		try {
			Scanner scan = new Scanner(System.in);
			boolean runFlag = true;
			while (runFlag) {
				println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				println("��ǰλ��>>>���˵�>>>��ʦ�˵�>>>�ɼ�����\t�����������Ų��س�");
				println("1:��ӳɼ�\t2:ɾ���ɼ�\t3:���³ɼ�\t0:���ؽ�ʦ�˵�");
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
					println(">>>������0-3֮��Ĳ�����ʾ");
					break;
				}
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵����ͳ�Ʋ˵�
	 */
	public static void statistics() {
		try {
			Scanner scan = new Scanner(System.in);
			boolean runFlag = true;
			while (runFlag) {
				println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				println("��ǰλ��>>>���˵�>>>��ʦ�˵�>>>�ɼ�ͳ��\t�����������Ų��س�");
				println("1:�ɼ���\t2:�γ�ƽ����\t3:��ѯ���Ƴɼ�\t4:��ѯѧ���ɼ�\t0:���ؽ�ʦ�˵�");
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
					println(">>>������0-4֮��Ĳ�����ʾ");
					break;
				}
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}
	
	/**
	 * ����˵��:ϵͳ����
	 */
	public static void setup() {
		try {
			Scanner scan = new Scanner(System.in);
			boolean runFlag = true;
			while (runFlag) {
				println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				println("��ǰλ��>>>���˵�>>>��ʦ�˵�>>>ϵͳ����\t�����������Ų��س�");
				println("1:������Ϣ\t2:�޸�����\t3:�޸ĸ�����Ϣ\t4:��ӽ�ʦ\t5:ɾ����ʦ\t6:��ʦ�б�\t0:���ؽ�ʦ�˵�");
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
					println(">>>������0-6֮��Ĳ�����ʾ");
					break;
				}
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵������ӿγ�
	 */
	public static void saveCourse() {
		Scanner scan = new Scanner(System.in);
		try {
			Course course = new Course();
			println(">>>������γ̱��");
			course.setCode(scan.nextInt());
			println(">>>������γ�����");
			course.setName(scan.next());
			if (courseDAOImpl.save(course))
				println(">>>" + course.toString() + "��ӳɹ�");
			else
				println(">>>��ӿγ̲���ʧ�ܣ�������");
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵����ɾ���γ�
	 */
	public static void deleteCourse() {
		Scanner scan = new Scanner(System.in);
		try {
			int code;
			println(">>>������Ҫɾ���Ŀγ̱��");
			code = scan.nextInt();
			Course course = courseDAOImpl.get(code);
			if (course == null) {
				println(">>>û�б��Ϊ��" + code + "�Ŀγ̣�������");
				return;
			}

			if (courseDAOImpl.delete(code)
					&& scoreDAOImpl.deleteByCourse(course))
				println(">>>ɾ���ɹ�");
			else
				println(">>>ɾ������ʧ�ܣ�������");
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵�������¿γ�
	 */
	public static void updateCourse() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>������Ҫ���µĿγ̱��");
			int code = scan.nextInt();
			Course course = courseDAOImpl.get(code);
			if (course == null) {
				println(">>>û�б��Ϊ��" + code + "�Ŀγ̣�������");
			} else {
				println(">>>ԭ�γ�����Ϊ:" + course.getName() + "���������¿γ�����");
				course.setName(scan.next());
				if (courseDAOImpl.update(course))
					println(">>>�γ̸���Ϊ��" + course.toString());
				else
					println(">>>���²���ʧ�ܣ�������");
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵�����γ��б�
	 */
	public static void listCourse() {
		try {
			List<Course> courseList = courseDAOImpl.list();
			for (int i = 0; i < courseList.size(); i++) {
				println(courseList.get(i));
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵�������ѧ��
	 */
	public static void saveStudent() {
		Scanner scan = new Scanner(System.in);
		println(">>>�밴��Ҫ������ѧ��ѧ����Ϣ��");
		Student student = new Student();
		try {
			println(">>>������ѧ�ţ�");
			student.setNum(scan.next());
			println(">>>������������");
			student.setName(scan.next());
			println(">>>���������䣺");
			student.setAge(scan.nextInt());
			println(">>>�������Ա�");
			student.setSex(scan.next());
			println(">>>������ϵ����");
			student.setDepartment(scan.next());
			println(">>>�����뼮�᣺");
			student.setNativePlace(scan.next());
			println(">>>������绰��");
			student.setPhone(scan.next());

			if (studentDAOImpl.save(student)) {
				println(">>>" + student + "��ӳɹ�");
			} else {
				println(">>>��Ӳ���ʧ�ܣ�������");
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵����ɾ��ѧ��
	 */
	public static void deleteStudent() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>������Ҫɾ����ѧ��ѧ�š�");
			String num = scan.next();
			Student student = studentDAOImpl.get(num);
			if (student == null) {
				println(">>>û��ѧ��Ϊ��" + num + "��ѧ��,������");
				return;
			}
			if (studentDAOImpl.delete(num)
					&& scoreDAOImpl.deleteByStudent(student)) {
				println(">>>ɾ���ɹ�");
			} else {
				println(">>>ɾ������ʧ�ܣ�������");
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵��������ѧ����Ϣ
	 */
	public static void updateStudent() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>�밴��Ҫ������Ҫ�޸ĵ�ѧ��ѧ����Ϣ��");
			Student student = new Student();
			println(">>>������Ҫ�޸ĵ�ѧ��ѧ�ţ�");
			String num = scan.next();
			student = studentDAOImpl.get(num);
			if (student == null) {
				println(">>>û��ѧ��Ϊ��" + num + "��ѧ��,������");
				return;
			}
			println(">>>Ҫ�޸ĵ�ѧ��ԭ��ϢΪ��" + student);

			println(">>>����������,�������޸�������n��");
			String info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				student.setName(info);

			println(">>>����������,�������޸�������n��");
			info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				student.setAge(Integer.parseInt(info));
			println(">>>�������Ա�,�������޸�������n��");
			info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				student.setSex(info);
			println(">>>������ϵ��,�������޸�������n��");
			info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				student.setDepartment(info);
			println(">>>�����뼮��,�������޸�������n��");
			info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				student.setNativePlace(info);
			println(">>>������绰,�������޸�������n��");
			info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				student.setPhone(info);

			if (studentDAOImpl.update(student)) {
				println(">>>���³ɹ�");
			} else {
				println(">>>���²���ʧ�ܣ�������");
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵������ѯѧ��
	 */
	public static void findStudent() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>�������ѯ��ʽ,1:����ѧ�Ų�ѯ��2������������ѯ");
			int type = scan.nextInt();
			println(">>>�������ѯ�ؼ��֡�");
			String keyString = scan.next();

			List<Student> studentList = studentDAOImpl.find(keyString, type);
			for (int i = 0; i < studentList.size(); i++) {
				Student student = studentList.get(i);
				println(student);
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵����ѧ���б�
	 */
	public static void listStudent() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>1:����ѧ������,2:������������");
			List<Student> studentList = studentDAOImpl.list(scan.nextInt());
			for (int i = 0; i < studentList.size(); i++) {
				Student student = (Student) studentList.get(i);
				println(student);
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵������ӳɼ�
	 */
	public static void saveScore() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>������Ҫ¼��ɼ��Ŀγ̱�ţ�");
			int code = scan.nextInt();
			Course course = courseDAOImpl.get(code);
			if (course == null) {
				println(">>>û�б��Ϊ��" + code + "�Ŀγ̣�������");
				return;
			}
			println(">>>��¼��ɼ��Ŀγ�Ϊ��" + course.toString());

			List<Student> studentList = studentDAOImpl.list(1);
			for (int i = 0; i < studentList.size(); i++) {
				Student student = studentList.get(i);
				Score score = scoreDAOImpl.get(student, course);
				if (score == null) {
					println(">>>������<" + student.getNum() + "|"
							+ student.getName() + ">�ĳɼ�");
					double scoreDobule = scan.nextDouble();
					score = new Score(course, student, scoreDobule);
					scoreDAOImpl.save(score);
				} else {
					println("<" + student.getNum() + "|" + student.getName()
							+ ">�ĳɼ��Ѵ��ڣ�" + score.getScore());
				}

			}
		} catch (Exception e) {
			System.out.print("�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵����ɾ���ɼ�
	 */
	public static void deleteScore() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>������Ҫɾ���ɼ��Ŀγ̱�ţ�");
			int code = scan.nextInt();
			Course course = new Course(code);
			println(">>>������Ҫɾ���ɼ���ѧ��ѧ�ţ�");
			String num = scan.next();
			Student student = new Student(num);
			Score score = scoreDAOImpl.get(student, course);
			if (score == null) {
				println(">>>û��ѧ��Ϊ" + num + "���γ̱��Ϊ" + code + "�ĳɼ���Ϣ�������ԡ�");
				return;
			}
			if (scoreDAOImpl.delete(score))
				println(">>>�ɼ�ɾ���ɹ�");
			else
				println(">>>�ɼ�ɾ��ʧ�ܣ�������");
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵��:���³ɼ�
	 */
	public static void updateScore() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>������Ҫ�޸ĳɼ��Ŀγ̱�ţ�");
			int code = scan.nextInt();
			Course course = courseDAOImpl.get(code);
			if(course==null){
				println(">>>û�б��Ϊ"+code+"�Ŀγ̣�������");
				return;
			}
			println(">>>������Ҫ�޸ĳɼ���ѧ��ѧ�ţ�");
			String num = scan.next();
			Student student = studentDAOImpl.get(num);
			if(student==null){
				println(">>>û��ѧ��Ϊ"+code+"��ѧ����������");
				return;
			}
			Score score = scoreDAOImpl.get(student, course);
			if (score == null) {
				println(">>>û��ѧ��Ϊ" + num + "���γ̱��Ϊ" + code + "�ĳɼ���Ϣ�������ԡ�");
				return;
			}
			println(">>>ԭ�ɼ���Ϣ��" + score);
			println(">>>�������³ɼ���");
			score.setScore(scan.nextDouble());
			if (scoreDAOImpl.update(score))
				println(">>>�ɼ��޸ĳɹ�");
			else
				println(">>>�ɼ��޸�ʧ�ܣ�������");
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵��:���ݿγ���ʾ�ɼ��б�
	 */
	public static void listScoreByCourse() {
		Scanner scan = new Scanner(System.in);
		try {

			println(">>>������γ̱��");
			int code = scan.nextInt();
			Course course = courseDAOImpl.get(code);
			if(course==null){
				println(">>>û�пγ̱��Ϊ"+code+"�Ŀγ�");
				return;
			}
			List<Score> scoreList = scoreDAOImpl.getScoreByCourse(course);
			int passing = 0; // ����ѧ����
			int fail = 0; // ������ѧ����
			double total = 0; // �ܷ�
			for (int i = 0; i < scoreList.size(); i++) {
				Score score = scoreList.get(i);
				println(score);
				total += score.getScore();
				if (score.getScore() >= 60)
					passing += 1;
				else
					fail += 1;
			}
			println("��������"+scoreList.size()+"��\tƽ����"+total/scoreList.size()+"\t"+passing+"�˼���\t"+fail+"�˲�����");
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 *����˵��:����ѧ����ʾ�ɼ��б� 
	 */
	public static void listScoreByStudent() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>������ѧ��ѧ��");
			String num = scan.next();
			Student student = studentDAOImpl.get(num);
			if(student==null){
				println(">>>û��ѧ��Ϊ"+num+"��ѧ��");
				return;
			}
			List<Score> scoreList = scoreDAOImpl.getScoreByStudent(student);
			int passing = 0; // ����γ���
			int fail = 0; // ������γ���
			double total = 0; // �ܷ�
			for (int i = 0; i < scoreList.size(); i++) {
				Score score = scoreList.get(i);
				println(score);
				total += score.getScore();
				if (score.getScore() >= 60)
					passing += 1;
				else
					fail += 1;
			}
			println("�γ�������"+scoreList.size()+"�ܷ�"+total+"\t"+passing+"�ſμ���\t"+fail+"�ſβ�����");
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}

	/**
	 * ����˵��:�ɼ���
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
			println("�ܷ�");
			
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
			System.out.print(">>>�쳣˵����");
			println(e.toString());
			e.printStackTrace();
		}
	}

	
	/**
	 * ����˵��:�γ�ƽ�����б�
	 */
	public static void average() {
		try {
			List<Course> courseList = courseDAOImpl.list();
			for (int i = 0; i < courseList.size(); i++) {
				Course course = courseList.get(i);
				System.out.print("<" + course.getCode() + "|"
						+ course.getName() + ">ƽ����Ϊ��");
				double total = 0;
				List<Score> scoreList = scoreDAOImpl.getScoreByCourse(course);
				for (int j = 0; j < scoreList.size(); j++) {
					Score score = scoreList.get(j);
					total += score.getScore();
				}
				System.out.print(total / scoreList.size() + "����������"
						+ scoreList.size() + ")");
				println("");
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}


	/**
	 * ����˵������ʾ��¼��ʦ������Ϣ
	 */
	public static void showTeacher(){
		println(teacher);
	}
	
	/**
	 * ����˵������������
	 */
	public static void changePassword(){
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>������ԭ����");
			String oldPassword = scan.next();
			if(!oldPassword.equals(teacher.getPassword())){
				println(">>>�������������");
				return;
			}
			println(">>>������������");
			String newPassword = scan.next();
			println(">>>���ٴ�����������");
			String confirmPassword = scan.next();
			if(!newPassword.equals(confirmPassword)){
				println(">>>������������벻��ͬ��������");
				return;
			}
			teacher.setPassword(newPassword);
			if(teacherDAOImpl.update(teacher))
				println(">>>�����޸ĳɹ�");
			else
				println(">>>�����޸�ʧ�ܣ�������");					
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}
	
	/**
	 * ����˵��:�޸ĵ�ǰ��¼��ʦ������Ϣ
	 */
	public static void updateTeacher(){
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>�밴��Ҫ�������ʦ��Ϣ���̹���ţ����������޸ģ�");
			println(">>>ԭ��ϢΪ��" + teacher);
			
			println(">>>����������,�������޸�������n��");
			String info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				teacher.setAge(Integer.parseInt(info));
			println(">>>�������Ա�,�������޸�������n��");
			info = scan.next();
			if (!info.equalsIgnoreCase("n"))
				teacher.setSex(info);

			if(teacherDAOImpl.update(teacher))
				println(">>>��ʦ������Ϣ�޸ĳɹ�");
			else
				println(">>>��ʦ������Ϣ�޸�ʧ�ܣ�������");					
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}
	
	
	/**
	 * ����˵��:��ӽ�ʦ
	 */
	public static void saveTeacher() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>�밴��Ҫ�������ʦ��Ϣ���̹���ţ�������������޸ģ�");
			Teacher teacher=new Teacher();
			println(">>>������̹���ţ�");
			teacher.setTeacherCode(scan.next());
			println(">>>����������");
			teacher.setName(scan.next());
			println(">>>�������¼����");
			teacher.setPassword(scan.next());
			println(">>>���������䣺");
			teacher.setAge(scan.nextInt());
			println(">>>�������Ա�");
			teacher.setSex(scan.next());

			if (teacherDAOImpl.save(teacher))
				println(">>>��ʦ��ӳɹ�");
			else
				println(">>>��ʦ���ʧ�ܣ�������");
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}
	
	public static void deleteTeacher(){
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>������Ҫɾ���Ľ�ʦ�̹����");
			String teacherCode=scan.next();
			if(teacherCode.equals(teacher.getTeacherCode())){
				println(">>>����ɾ���Լ�");
				return;
			}
			
			if(teacherDAOImpl.get(teacherCode)==null){
				println("û�б��Ϊ:"+teacherCode+"�Ľ�ʦ��������");
				return;
			}
			
			if (teacherDAOImpl.delete(teacherCode))
				println(">>>��ʦɾ���ɹ�");
			else
				println(">>>��ʦɾ��ʧ�ܣ�������");
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}
	
	/**
	 * ����˵��:��ʦ�б�
	 */
	public static void listTeacher(){
		try {
			List<Teacher> teacherList=teacherDAOImpl.list();
			for (int i = 0; i < teacherList.size(); i++) {
				Teacher teacher=teacherList.get(i);
				println(teacher);
			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}
}
