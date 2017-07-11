package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Object.Registration;


public class RegistrationManager extends DBConnection implements DBOperator<Registration> {

	@Override
	public List<Registration> getList() {
		String sql = "select * from Registration";
		ArrayList<Registration> lstRegistration = new ArrayList<Registration>();

		try {
			Statement stm = conn.createStatement();
			ResultSet data = stm.executeQuery(sql);

			while (data.next()) {

				int codeStudent = data.getInt(2);
				int codeExam = data.getInt(3);
				boolean status = data.getBoolean(4);
				Registration r = new Registration(codeStudent,codeExam, status);
				r.setCodeRegis(data.getInt(1));
				lstRegistration.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lstRegistration;

	}

	@Override
	public boolean add(Registration r) {
		String sql = "Insert into Registration values(?,?,?)";
		PreparedStatement statement;

		try {
			statement = this.conn.prepareStatement(sql);
			statement.setInt(1, r.getCodeStunent());
			statement.setInt(2, r.getCodeExam());
			statement.setBoolean(3, r.isStatus());
			int row = statement.executeUpdate();

			return row == 1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(Registration r) {
		String sql = "update Registration set STUDENTID = ?,CODEEXAM = ?,STATUS = ? where CODEREGIS = ?";
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
			
			statement.setInt(5, r.getCodeRegis());
			statement.setInt(1, r.getCodeStunent());
			statement.setInt(2, r.getCodeExam());
			statement.setBoolean(3, r.isStatus());

			int rows = statement.executeUpdate();

			statement.close();

			return rows == 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean delete(int id) {

		String sql = "delete from Registration where CODEREGIS = ?";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, id);
			int rows = stm.executeUpdate();

			stm.close();

			return rows == 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;

	}

	
	
	public List<Registration> getListbyStudent(int idstudent) {
		ArrayList<Registration> lstRegistration = new ArrayList<Registration>();
		for(Registration re: this.getList())
		{
			if(re.getCodeStunent() == idstudent)
			{
				lstRegistration.add(re);
			}
		}
		return lstRegistration;
	}

	public Registration getID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Registration getbyID(int id) {
		ArrayList<Registration> lstRegistration = new ArrayList<Registration>(this.getList());
		Registration qu= null;
		for(Registration r : lstRegistration)
		{
			if(r.getCodeRegis() == id)
			{
				qu =r;
				break;
			}
		}
		return qu;
	}

}
