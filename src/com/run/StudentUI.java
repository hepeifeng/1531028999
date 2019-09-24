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
			println(">>>������ѧ�ţ�");
			String num=scan.next();
			student=studentDAOImpl.get(num);
			if(student==null){
				println("û��ѧ��Ϊ"+num+"��ѧ����������");
				return;
			}
			println("��ӭ�㣺"+student.getName());
			
			boolean runFlag = true;
			while (runFlag) {
				println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				println("��ǰλ��>>>���˵�>>>ѧ���˵�\t 1:������Ϣ\t2:�ɼ���\t3:���¸�����Ϣ\t0:�������˵�");
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
					println(">>>ϵͳ�˳�");
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
	 * ����̨�������
	 * @param object
	 */
	public static void println(Object object) {
		System.out.println(object);
	}
	
	/**
	 *����˵��:��ǰѧ����Ϣ
	 */
	public static void showStudent() {		
		try {
			println(student);
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			println(e.toString());
		}
	}
	
	/**
	 *����˵��:��ʾ��ǰѧ���ɼ��б� 
	 */
	public static void gradebook() {
		try {
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
	 * ����˵��������ѧ����Ϣ
	 */
	public static void updateStudent() {
		Scanner scan = new Scanner(System.in);
		try {
			println(">>>�밴��Ҫ������Ҫ�޸ĵ�ѧ��ѧ����Ϣ��ѧ�ţ����������޸ģ�");
			println(">>>ԭ��ϢΪ��" + student);
			
			println(">>>����������,�������޸�������n��");
			String info = scan.next();
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
}
