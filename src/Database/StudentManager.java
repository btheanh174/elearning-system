package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Object.Admin;
import Object.Question;
import Object.Student;

public class StudentManager extends DBConnection implements DBOperator<Student> {

	@Override
	public List<Student> getList() {
		String sql = "select * from Student";
		ArrayList<Student> lstStudent = new ArrayList<Student>();

		try {
			Statement stm = conn.createStatement();
			ResultSet data = stm.executeQuery(sql);

			while (data.next()) {

				String name = data.getString(2);
				String username = data.getString(3);
				String pass = data.getString(4);
				int age = data.getInt(5);
				String adress = data.getString(6);
				String email = data.getString(7);

				Student s = new Student(username, name, pass, age, adress, email);
				s.setIDStudent(data.getInt(1));
				lstStudent.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lstStudent;

	}

	@Override
	public boolean add(Student s) {
		String sql = "Insert into Student values(?,?,?,?,?,?)";
		PreparedStatement statement;

		try {
			statement = this.conn.prepareStatement(sql);
			statement.setString(1, s.getNameStudent());
			statement.setString(2, s.getUsername());
			statement.setString(3, s.getPassword());
			statement.setInt(4, s.getAge());
			statement.setString(5, s.getAdress());
			statement.setString(6, s.getEmail());

			int row = statement.executeUpdate();

			return row == 1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(Student s) {
		String sql = "update student set sname = ?, Username = ?, spassword = ?, age = ?, address= ?,email = ? where Studentid = ?";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);

			stm.setInt(7, s.getIDStudent());
			stm.setString(1, s.getNameStudent());
			stm.setString(2, s.getUsername());
			stm.setString(3, s.getPassword());
			stm.setInt(4, s.getAge());
			stm.setString(5, s.getAdress());
			stm.setString(6, s.getEmail());

			int rows = stm.executeUpdate();

			stm.close();

			return rows == 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean delete(int id) {

		String sql = "delete from student where studentid = ?";
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

	@Override
	public Student getbyID(int id) {
		ArrayList<Student> lstStudent = new ArrayList<Student>(this.getList());
		Student st= null;
		for(Student s : lstStudent)
		{
			if(s.getIDStudent() == id)
			{
				st =s;
				break;
			}
		}
		return st;
	}
	
	public boolean validate(String u, String p)
	{
		for(Student s:this.getList())
		{
			if(s.getUsername().equals(u) && s.getPassword().equals(p))
			{
				return true;
			}
		}
		return false;
	}
	public Student getbyUser(String User) {
		ArrayList<Student> lstStudent = new ArrayList<Student>(this.getList());
		Student st= null;
		for(Student s : lstStudent)
		{
			if(s.getUsername().equals(User))
			{
				st =s;
				break;
			}
		}
		return st;
	}

}
