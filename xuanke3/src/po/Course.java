package po;

public class Course {
	private Integer courseId;
	private String courseName;
	private Integer courseHour ;
	private Integer TeacherId;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(Integer courseId, String courseName, Integer courseHour, Integer TeacherId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseHour = courseHour;
		this.TeacherId = TeacherId;
	}
	public String toString(){
		return "�γ̱��:"+courseId+"\t�γ�����:"+courseName+"\t�γ̿�ʱ:"+courseHour+"\t���ڽ�ʦ���:"+TeacherId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCourseHour() {
		return courseHour;
	}
	public void setCourseHour(Integer courseHour) {
		this.courseHour = courseHour;
	}
	public Integer getTeacherId() {
		return TeacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.TeacherId = teacherId;
	}
	
}
