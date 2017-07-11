package Object;

public class Exam {
	private int codeExam;
	private String nameExam;
	private int codeCourse;
	private int codeTask;
	
	public Exam(String nameExam, int codeCourse) {
		super();
		this.nameExam = nameExam;
		this.codeCourse = codeCourse;
	}
	public int getCodeExam() {
		return codeExam;
	}
	public void setCodeExam(int codeExam) {
		this.codeExam = codeExam;
	}
	public String getNameExam() {
		return nameExam;
	}
	public void setNameExam(String nameExam) {
		this.nameExam = nameExam;
	}
	public int getCodeCourse() {
		return codeCourse;
	}
	public void setCodeCourse(int codeCourse) {
		this.codeCourse = codeCourse;
	}
	public int getCodeTask() {
		return codeTask;
	}
	public void setCodeTask(int codeTask) {
		this.codeTask = codeTask;
	}
	
	
}
