package Object;

import java.util.ArrayList;

public class Course {
	private int idCourse;
	private String nameCourse;
	private String content;
	public Course(String nameCourse, String content) {
		super();
		this.nameCourse = nameCourse;
		this.content = content;
	}
	public int getIdCourse() {
		return idCourse;
	}
	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}
	public String getNameCourse() {
		return nameCourse;
	}
	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}

