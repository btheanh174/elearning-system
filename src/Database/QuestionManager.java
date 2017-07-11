package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Object.Question;


public class QuestionManager extends DBConnection implements DBOperator<Question> {

	@Override
	public List<Question> getList() {
		String sql = "select * from Question";
		Statement stm;
		ArrayList<Question> lstQuestion = new ArrayList<Question>();

		try {
			stm = conn.createStatement();
			ResultSet data = stm.executeQuery(sql);

			while (data.next()) {
			
				int codee = data.getInt(2);
				String question = data.getString(8);
				String qA = data.getString(3);
				String qB = data.getString(4);
				String qC = data.getString(5);
				String qD = data.getString(6);
				String answer = data.getString(7);
				
				Question a = new Question(codee, question, qA, qB, qC, qD, answer);
				a.setCodeQuest(data.getInt(1));
				lstQuestion.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lstQuestion;
	}

	@Override
	public boolean add(Question q) {
		String sql = "insert into question values(?,?,?,?,?,?,?)";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, q.getCodeExam());
			stm.setString(7, q.getQuest());
			stm.setString(2, q.getQA());
			stm.setString(3, q.getQB());
			stm.setString(4, q.getQC());
			stm.setString(5, q.getQD());
			stm.setString(6, q.getAnswer());
			
			int rows = stm.executeUpdate();
			
			stm.close();
			
			return rows == 1;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;	
	}

	@Override
	public boolean update(Question q) {
		String sql = "update question set CODEEXAM = ?, QUESTION = ?, QA = ?, QB= ?,QC = ?, QD = ?, ANSWER = ? where CODEQUES = ?";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);

			stm.setInt(8, q.getCodeQuest());
			stm.setInt(1, q.getCodeExam());
			stm.setString(2, q.getQuest());
			stm.setString(3, q.getQA());
			stm.setString(4, q.getQB());
			stm.setString(5, q.getQC());
			stm.setString(6, q.getQD());
			stm.setString(7, q.getAnswer());
				
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
		String sql = "delete from QUESTION where CODEQUES = ?";
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
	public List<Question> getListbyExam(int idexam)
	{
		ArrayList<Question> lstQuestion = new ArrayList<Question>(this.getList());
		ArrayList<Question> lstResult = new ArrayList<Question>();
		
		for(Question q : lstQuestion)
		{
			if(q.getCodeExam() == idexam)
			{
				lstResult.add(q);
			}
		}
		return lstResult;
	}

	@Override
	public Question getbyID(int id) {
		ArrayList<Question> lstQuestion = new ArrayList<Question>(this.getList());
		Question qu= null;
		for(Question q : lstQuestion)
		{
			if(q.getCodeQuest() == id)
			{
				qu =q;
				break;
			}
		}
		return qu;
	}
}
