package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	protected Connection conn;
	
	public void openConnection() throws ClassNotFoundException, SQLException{
		String url = "jdbc:sqlserver://localhost; databaseName=Quizz";
		String username = "sa";
		String password = "123456";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,username, password);
	}
	public void closeConnection() throws SQLException{
		if(conn != null && !conn.isClosed()){
			conn.close();
		}
	}
}
