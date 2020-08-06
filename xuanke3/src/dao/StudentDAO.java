package dao;

import java.util.List;

import po.Course;
import po.Student;
import po.Teacher;

public interface StudentDAO {
	
	public int saveStudent(Student student);
	
	public Student studentLogin(int studentId,String studentName);
	
	public List<Course> liststudent_course(Student student) ;

	public List<Course> student_course(String courseName,String teacherName) ;
	
	public boolean courseByCidSid(int courseId,int studentId) ;
	
	public int saveStudent_Course(int studentId,int courseId) ;
}
