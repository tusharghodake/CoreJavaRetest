package training.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import training.demo.model.Student;

public class StudentDao {

	static Connection con=null;
	static PreparedStatement inspst=null;
	static PreparedStatement pst=null;
	static PreparedStatement idpst=null;
	static PreparedStatement delpst=null;
	static PreparedStatement uppst=null;
	static
	{
		con=DBUtil.getMyConnection();
		try {
			inspst=con.prepareStatement("insert into student values(?,?,?)");
			pst=con.prepareStatement("select * from student");
			idpst=con.prepareStatement("select * from student where sid=?");
			delpst=con.prepareStatement("delete from student where sid=?");
			uppst=con.prepareStatement("update student set sname=?,marks=? where sid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}
	public int insertStudent(Student s) {
		try {
			inspst.setInt(1, s.getSid());
			inspst.setString(2, s.getSname());
			inspst.setInt(3, s.getMarks());
			inspst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public ResultSet getStudents() {
		
		try {
			return pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ResultSet getById(int sid) throws SQLException {
		idpst.setInt(1, sid);
		return idpst.executeQuery();
	}
	public int deleteById(Student s) throws SQLException {
		delpst.setInt(1, s.getSid());
		return delpst.executeUpdate();
	}
	public int updateStudent(Student s) throws SQLException {
		uppst.setString(1, s.getSname());
		uppst.setInt(2, s.getMarks());
		uppst.setInt(3, s.getSid());
		return uppst.executeUpdate();
	}

}
