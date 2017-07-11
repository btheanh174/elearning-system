package test;

import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;



import Database.AdminManager;
import Database.ExamManager;
import Database.QuestionManager;
import Database.RegistrationManager;
import Database.StudentManager;
import Object.Admin;
import Object.Question;
import Object.Registration;
import Object.Student;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StudentManager a = new StudentManager();
		QuestionManager b = new QuestionManager();
		ExamManager c = new ExamManager();
//		
		a.openConnection();
		b.openConnection();
		c.openConnection();
//		
//		System.out.println("Hoc Sinh: " + a.getList().size());
//		System.out.println("CauHoi: " + b.getList().size());
//		System.out.println("KiemTra: " + c.getList().size());
//		
//		Question q = new Question(1,"Thế Anh","Thế Anh","fsfsd","fsfsdfsf","fsfsff","A");
//		q.setCodeQuest(46);
//		b.update(q);
//		
		RegistrationManager rM = new RegistrationManager();
		rM.openConnection();
		Student s = a.getbyID(1);
		List<Question> lstQuestion = b.getListbyExam(8);
//		System.out.println(s.getNameStudent());
//		System.out.println(lstQuestion.size());
		System.out.println(rM.getList().get(0).getCodeRegis());
		Registration ra = rM.getbyID(8);
		System.out.println(ra);
	}

}
