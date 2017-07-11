
package Object;

import java.util.ArrayList;

public class Student {
	private int IDStudent;
	private String username;
	private String nameStudent;
	private String password;
	private int age;
	private String adress;
	private String email;
	private ArrayList<Registration> lstRegistration;
	public Student(String username, String nameStudent, String password, int age, String adress, String email) {
		super();
		this.username = username;
		this.nameStudent = nameStudent;
		this.password = password;
		this.age = age;
		this.adress = adress;
		this.email = email;
	}
	public int getIDStudent() {
		return IDStudent;
	}
	public void setIDStudent(int iDStudent) {
		IDStudent = iDStudent;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNameStudent() {
		return nameStudent;
	}
	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Registration> getLstRegistration() {
		return lstRegistration;
	}
	public void setLstRegistration(ArrayList<Registration> lstRegistration) {
		this.lstRegistration = lstRegistration;
	}
	
	
	
}
