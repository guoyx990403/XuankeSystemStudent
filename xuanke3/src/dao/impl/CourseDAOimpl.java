package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CourseDAO;
import po.Course;
import po.Student;
import po.Teacher;
import util.BaseDAO;

public class CourseDAOimpl extends BaseDAO  implements CourseDAO {
	
	public int saveCourse(Course course){
		String sql = "insert into course (courseName,courseHour,TeacherId) values(?,?,?) ";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, course.getCourseName());
			pstmt.setInt(2, course.getCourseHour());
			pstmt.setInt(3, course.getTeacherId());
			count = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
		return count;
	}
	
	public List<Course>  listCourseAll(){
		String sql = "select courseId ,courseName,courseHour,TeacherId from course ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Course> clist = new ArrayList<Course>();
		try {
			pstmt = getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Course c = new Course();
				c.setCourseHour(rs.getInt("courseHour"));
				c.setCourseId(rs.getInt("courseId"));
				c.setCourseName(rs.getString("courseName"));
				c.setTeacherId(rs.getInt("TeacherId"));
				clist.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, rs);
		}
		return clist;
	}
	
	public Course courseById(int courseId){
		String sql = "select courseId ,courseName,courseHour,TeacherId from course where courseId = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Course c = null;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, courseId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				c = new Course();
				c.setCourseHour(rs.getInt("courseHour"));
				c.setCourseId(rs.getInt("courseId"));
				c.setCourseName(rs.getString("courseName"));
				c.setTeacherId(rs.getInt("TeacherId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, rs);
		}
		return c;
	}

	@Override
	public int updateCourse(Course course) {
		// TODO Auto-generated method stub
		String sql = "update course set courseName= ?,courseHour = ? where courseId = ?";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, course.getCourseName());
			pstmt.setInt(2, course.getCourseHour());
			pstmt.setInt(3, course.getCourseId());
			count = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
		return count;
	}

	@Override
	public int deleteCourse(int courseId) {
		// TODO Auto-generated method stub
		String sql1 = "delete from stucou where CourseId = ? ";
		String sql2 = "delete from course where courseId = ? ";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			getConn().setAutoCommit(false);
			pstmt = getConn().prepareStatement(sql1);
			pstmt.setInt(1, courseId);
			count = pstmt.executeUpdate();
		
			pstmt = getConn().prepareStatement(sql2);
			pstmt.setInt(1, courseId);
			count = pstmt.executeUpdate();
			getConn().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				getConn().rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			close(null, pstmt, null);
		}
		return count;
	}

	@Override
	public List<Student> listCourse_student(int courseId) {
		// TODO Auto-generated method stub
		String sql = "select s.studentId ,s.studentName,s.studentClass from student s,stucou sc" 
					+"where s.studentId = sc.StudentId and sc.CourseId = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Student> slist = new ArrayList<Student>();
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, courseId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Student student = new Student();
				student.setStudentId(rs.getInt("studentId"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentClass(rs.getString("studentClass"));
				slist.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, rs);
		}
		return slist;
	}
}
