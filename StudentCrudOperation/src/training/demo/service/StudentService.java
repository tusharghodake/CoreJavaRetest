package training.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import training.demo.dao.StudentDao;
import training.demo.model.Student;

public class StudentService {

	private StudentDao dao;

	public StudentService(StudentDao dao) {
		super();
		this.dao = dao;
	}

	public Student createStudent() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student Data:");
		System.out.println("Enter Student Id:");
		int sid=sc.nextInt();
		
		System.out.println("Enter Student Name:");
		String sname=sc.next();
		
		System.out.println("Enter Student Marks:");
		int marks=sc.nextInt();
		
		return new Student(sid,sname,marks);
	}

	public int insertStudent(Student s) {
		
		return dao.insertStudent(s);
	}

	public ArrayList<Student> displayAllStudent() throws SQLException {
		ArrayList<Student> slist=new ArrayList<Student>();
		ResultSet rs=dao.getStudents();
		while(rs.next())
		{
			Student s=new Student(rs.getInt(1),rs.getString(2),rs.getInt(3));
			slist.add(s);
		}
		return slist;
	}

	public Student getById(int sid) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs= dao.getById(sid);
		while(rs.next())
		{
			Student s=new Student(rs.getInt(1),rs.getString(2),rs.getInt(3));
			return s;
		}
		return null;
	}

	public int deleteById(Student s) throws SQLException {
		// TODO Auto-generated method stub
		return dao.deleteById(s);
	}

	public int updateStudent(Student s) throws SQLException {
		// TODO Auto-generated method stub
		return dao.updateStudent(s);
	}

	

}
