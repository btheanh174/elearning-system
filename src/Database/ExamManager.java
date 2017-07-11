package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Object.Exam;
import Object.Question;



public class ExamManager extends DBConnection implements DBOperator<Exam> {

	@Override
	public List<Exam> getList() {
		String sql = "select * from Exam";
		Statement stm;
		ArrayList<Exam> lstExam = new ArrayList<Exam>();

		try {
			stm = conn.createStatement();
			ResultSet data = stm.executeQuery(sql);

			while (data.next()) {
				int codec = data.getInt(2);
				String nameExam = data.getString(4);
				Exam e = new Exam(nameExam, codec);
				
				e.setCodeExam(data.getInt(1));
				int codeTask = data.getInt(3);
				if(data.wasNull() == false)
				{
					e.setCodeTask(codeTask);
				}
				
				lstExam.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lstExam;
	}

	@Override
	public boolean add(Exam ex) {
		String sql = "insert into EXAM(CODECOURSE, NAMEEXAM) values(?,?)";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, ex.getCodeCourse());
			stm.setString(2, ex.getNameExam());
			
			
			int rows = stm.executeUpdate();
			
			stm.close();
			
			return rows == 1;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(Exam ex) {
		String sql = "update Exam set CODECOURSE = ?, NAMEEXAM = ? where CODEEXAM = ?";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);

			stm.setInt(3, ex.getCodeExam());
			stm.setInt(1, ex.getCodeCourse());
			stm.setString(2, ex.getNameExam());
				
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
		String sql = "delete from Exam where CODEEXAM = ?";
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
	public Exam getbyID(int id) {
		ArrayList<Exam> lstExam = new ArrayList<Exam>(this.getList());
		Exam ex= null;
		for(Exam e : lstExam)
		{
			if(e.getCodeExam() == id)
			{
				ex=e;
				break;
			}
		}
		return ex;
	}
	
	public List<Exam> getlistExambyCourse(int id)
	{
		ArrayList<Exam> lstExam = new ArrayList<Exam>(this.getList());
		ArrayList<Exam> resuilt = new ArrayList<Exam>();
		for(Exam e:lstExam)
		{
			if(e.getCodeCourse() == id)
			{
				resuilt.add(e);
			}
		}
		
		return resuilt;

	}

}
