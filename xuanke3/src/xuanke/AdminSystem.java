package xuanke;

import java.util.Scanner;

import view.CourseView;
import view.TeacherView;
import view.impl.CourseViewimpl;
import view.impl.TeacherViewimpl;

public class AdminSystem {

	 Scanner sc = new Scanner(System.in);
	 TeacherView tview = new TeacherViewimpl();
	 CourseView cview = new CourseViewimpl();

	public void work(){
		System.out.println("---------------------------------------------------------");
		System.out.println("|\t\t\t学生选课后台管理系统\t\t\t|");
		System.out.println("---------------------------------------------------------");
		int num = 0;
		while(num!=3){
			System.out.println("-------------1.课程管理  2.教师管理  3.退出系统-------------");
			num = sc.nextInt();
			switch (num) {
				case 1:
					courseManage();
					break;
				case 2:
					teacherManage();			
					break;
				case 3:
					System.out.println("欢迎再次使用本系统");
					break;
		
				default:
					break;
			}
		}
	}

	public void courseManage(){
		int num = 0;
		while(num != 6){
			System.out.println("--------------------(课程管理)1.添加课程信息  2.修改课程信息  3.删除课程信息  4.查询课程信息  5.查询课程下的学生信息 6.返回上一级--------------------");
			num = sc.nextInt();
			switch (num) {
			case 1:
				cview.saveCourse();
				break;
			case 2:
				cview.updateCourse();			
				break;
			case 3:
				cview.deleteCourse();
				break;
			case 4:
				cview.listCourseAll();
				break;
			case 5:
				cview.listCourse_student();			
				break;
			case 6:
				
				break;

			default:
				break;
			}
		}
	}

	public void teacherManage(){
		int num = 0;
		while(num != 6){
			System.out.println("--------------------(教师管理)1.添加教师信息  2.修改教师信息  3.删除教师信息  4.查询教师信息  5.查询教师所教授学生信息 6.返回上一级--------------------");
			num = sc.nextInt();
			switch (num) {
			case 1:
				tview.saveTeacher();
				break;
			case 2:
				tview.updateTeacher();			
				break;
			case 3:
				tview.deleteTeacher();
				break;
			case 4:
				tview.listTeacherAll();
				break;
			case 5:
				tview.listTeacher_student();			
				break;
			case 6:
				
				break;

			default:
				break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AdminSystem().work();
		
	}

}
