package dao;

import java.util.List;

import po.Student;
import po.Teacher;

public interface TeacherDAO {
	public List<Teacher> listTeacherAll();
	
	public int saveTeacher(Teacher teacher);
	
	public Teacher teacherById(int teacherId);
	
	public int updateteacher(Teacher teacher);
	
	public int deleteTeacher(int teacherId);
	
	public List<Student> listTeacher_student(int teacherId);
	
}
