package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TeacherDAO;
import po.Student;
import po.Teacher;
import util.BaseDAO;

public class TeacherDAOimpl extends BaseDAO implements TeacherDAO {
	
	public List<Teacher> listTeacherAll(){
		String sql = "select teacherId ,teacherName,technology from teacher ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Teacher> tlist = new ArrayList<Teacher>();
		try {
			pstmt = getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Teacher t = new Teacher();
				t.setTeacherId(rs.getInt("teacherId"));
				t.setTeacherName(rs.getString("teacherName"));
				t.setTechnology(rs.getString("technology"));
				tlist.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, rs);
		}
		return tlist;
	}
	
	public int saveTeacher(Teacher teacher){
		String sql = "insert into teacher (teacherName,technology) values(?,?) ";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, teacher.getTeacherName());
			pstmt.setString(2, teacher.getTechnology());
			count = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
		return count;
	}
	
	
	public Teacher teacherById(int teacherId){
		String sql = "select teacherId ,teacherName,technology from teacher where teacherId = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Teacher t = null;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, teacherId);;
			rs = pstmt.executeQuery();
			if(rs.next()){
				t = new Teacher();
				t.setTeacherId(rs.getInt("teacherId"));
				t.setTeacherName(rs.getString("teacherName"));
				t.setTechnology(rs.getString("technology"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, rs);
		}
		return t;
	}
	
	public int updateteacher(Teacher teacher){
		String sql = "update teacher set teacherName = ?,technology = ? where teacherId = ? ";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, teacher.getTeacherName());
			pstmt.setString(2, teacher.getTechnology());
			pstmt.setInt(3, teacher.getTeacherId());
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, pstmt, null);
		}
		return count;
	}
	
	//数据库事务(设计三张表)
	public int deleteTeacher(int teacherId){
		String sql1 = "delete from stucou where CourseId in (select courseId from course where TeacherId = ?)";
		String sql2 = "delete from course where TeacherId = ?";
		String sql3 = "delete from teacher where teacherId = ? ";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			getConn().setAutoCommit(false);
			pstmt = getConn().prepareStatement(sql1);
			pstmt.setInt(1, teacherId);
			count = pstmt.executeUpdate();
			
			pstmt = getConn().prepareStatement(sql2);
			pstmt.setInt(1, teacherId);
			count = pstmt.executeUpdate();
			
			pstmt = getConn().prepareStatement(sql3);
			pstmt.setInt(1, teacherId);
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
	
	public List<Student> listTeacher_student(int teacherId){
		String sql = "select distinct s.studentId ,s.studentName,s.studentClass from student s,stucou sc,course c,teacher t "
				+ "where t.teacherId = c.TeacherId and c.courseId = sc.CourseId and sc.StudentId = s.studentId and t.teacherId = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Student> slist = new ArrayList<Student>();
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, teacherId);
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
