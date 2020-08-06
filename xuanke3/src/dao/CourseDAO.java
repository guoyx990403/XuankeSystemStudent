package dao;

import java.util.List;

import po.Course;
import po.Student;

public interface CourseDAO {
	public int saveCourse(Course course);
	public int updateCourse(Course course);
	public int deleteCourse(int courseId);
	public Course courseById(int courseId);
	public List<Course> listCourseAll();
	public List<Student> listCourse_student(int courseId);
}
