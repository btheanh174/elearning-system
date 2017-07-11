
package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Object.Course;
import Object.Exam;

public class CourseManager extends DBConnection implements DBOperator<Course> {

	@Override
	public List<Course> getList() {
		String sql = "select * from Course";
		Statement stm;
		ArrayList<Course> lstCourse = new ArrayList<Course>();

		try {
			stm = conn.createStatement();
			ResultSet data = stm.executeQuery(sql);

			while (data.next()) {
				int codec = data.getInt(1);
				String nameCourse = data.getString(2);
				String contentCourse = data.getString(3);
				Course c = new Course(nameCourse, contentCourse);

				c.setIdCourse(codec);

				lstCourse.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lstCourse;
	}

	@Override
	public boolean add(Course c) {
		String sql = "insert into COURSE(NAMECOURSE, CONTENTCOURSE) values(?,?)";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, c.getNameCourse());
			stm.setString(2, c.getContent());

			int rows = stm.executeUpdate();

			stm.close();

			return rows == 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean update(Course c) {
		String sql = "update COURSE set NAMECOURSE = ?, CONTENTCOURSE = ? where CODECOURSE = ?";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);

			stm.setInt(3, c.getIdCourse());
			stm.setString(1, c.getNameCourse());
			stm.setString(2, c.getContent());

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
		String sql = "delete from COURSE where CODECOURSE = ?";
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
	public Course getbyID(int id) {
		ArrayList<Course> lstCourse = new ArrayList<Course>(this.getList());
		Course co= null;
		for(Course c : lstCourse)
		{
			if(c.getIdCourse() == id)
			{
				co=c;
				break;
			}
		}
		return co;
	}

}
