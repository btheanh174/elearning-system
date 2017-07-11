package Object;

import java.util.ArrayList;

public class Registration {
	private int codeRegis;	
	private int codeStunent;
	private int codeExam;
	private boolean status;
	private ArrayList<Task> lstTask;
	
	public Registration(int codeStunent,int codeExam, boolean status) {
		super();
		this.codeStunent = codeStunent;
		this.codeExam = codeExam;
		this.status = status;
	}
	public int getCodeRegis() {
		return codeRegis;
	}
	public void setCodeRegis(int codeRegis) {
		this.codeRegis = codeRegis;
	}
	public int getCodeStunent() {
		return codeStunent;
	}
	public void setCodeStunent(int codeStunent) {
		this.codeStunent = codeStunent;
	}
	public int getCodeExam() {
		return codeExam;
	}
	public void setCodeExam(int codeExam) {
		this.codeExam = codeExam;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public ArrayList<Task> getLstTask() {
		return lstTask;
	}
	public void setLstTask(ArrayList<Task> lstTask) {
		this.lstTask = lstTask;
	}
	
	
}

