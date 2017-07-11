package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Object.Admin;
import Object.Student;

public class AdminManager extends DBConnection {
	public ArrayList<Admin> getList() {
		String sql = "select * from Admin";
		Statement stm;
		ArrayList<Admin> lstAdmin = new ArrayList<Admin>();

		try {
			stm = conn.createStatement();
			ResultSet data = stm.executeQuery(sql);

			while (data.next()) {
				String code = data.getString(1);
				String pass = data.getString(2);

				Admin a = new Admin(code, pass);
				lstAdmin.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lstAdmin;

	}
	public boolean validate(String u, String p)
	{
		for(Admin a:this.getList())
		{
			if(a.getIDAdmin().equals(u) && a.getPassword().equals(p))
			{
				return true;
			}
		}
		return false;
	}
	public Admin getAdminbyID(String u)
	{
		Admin ad= null;
		for(Admin a:this.getList())
		{
			if(a.getIDAdmin().equals(u))
			{
				ad = a;
				break;
			}
		}
		return ad;
	}

}
