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
		System.out.println("|\t\t\tѧ��ѡ�κ�̨����ϵͳ\t\t\t|");
		System.out.println("---------------------------------------------------------");
		int num = 0;
		while(num!=3){
			System.out.println("-------------1.�γ̹���  2.��ʦ����  3.�˳�ϵͳ-------------");
			num = sc.nextInt();
			switch (num) {
				case 1:
					courseManage();
					break;
				case 2:
					teacherManage();			
					break;
				case 3:
					System.out.println("��ӭ�ٴ�ʹ�ñ�ϵͳ");
					break;
		
				default:
					break;
			}
		}
	}

	public void courseManage(){
		int num = 0;
		while(num != 6){
			System.out.println("--------------------(�γ̹���)1.��ӿγ���Ϣ  2.�޸Ŀγ���Ϣ  3.ɾ���γ���Ϣ  4.��ѯ�γ���Ϣ  5.��ѯ�γ��µ�ѧ����Ϣ 6.������һ��--------------------");
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
			System.out.println("--------------------(��ʦ����)1.��ӽ�ʦ��Ϣ  2.�޸Ľ�ʦ��Ϣ  3.ɾ����ʦ��Ϣ  4.��ѯ��ʦ��Ϣ  5.��ѯ��ʦ������ѧ����Ϣ 6.������һ��--------------------");
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
