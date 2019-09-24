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
	 * ����˵���������������
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			println("\t\t\t\t��ӭʹ��ѧ���ɼ�����ϵͳ");
			println("*******************************************************************************");
			Scanner scan = new Scanner(System.in);
			boolean runFlag = true;
			while (runFlag) {
				println("��ǰλ��>>>���˵�\t���������ѡ���û����Ͳ��س�");
				println("1:��ʦ\t2:ѧ��\t0:�˳�");
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
					println(">>>ϵͳ�˳�");
					println("*******************************************************************************");
					break;
				default:
					println("������0-2֮��Ĳ�����ʾ");
					break;
				}
			}
		} catch (Exception e) {
			println("�����쳣,ϵͳ���������˵���");
			System.out.print("�쳣˵����");
			println(e.toString());			
			main(args);
		}

	}
	
	/**
	 *  ����˵��������̨�������
	 * @param object
	 */
	public static void println(Object object) {
		System.out.println(object);
	}

}
