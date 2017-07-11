package Object;

public class Admin{
	private String IDAdmin;
	private String password;
	public Admin(String iDAdmin, String password) {
		this.IDAdmin = iDAdmin;
		this.password = password;
	}
	public String getIDAdmin() {
		return IDAdmin;
	}
	public void setIDAdmin(String iDAdmin) {
		this.IDAdmin = iDAdmin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
