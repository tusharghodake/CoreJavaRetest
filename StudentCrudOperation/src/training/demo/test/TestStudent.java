package training.demo.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import training.demo.dao.StudentDao;
import training.demo.model.Student;
import training.demo.service.StudentService;

public class TestStudent {

	public static void main(String[] args) {
		
		StudentDao dao=new StudentDao();
		StudentService service=new StudentService(dao);
		Scanner sc=new Scanner(System.in);
		
		int ch = 0;
		do
		{
			System.out.println("1.Insert Student");
			System.out.println("2.Delete Student");
			
			System.out.println("3.Update Student");
			System.out.println("4.Display Student");
			System.out.println("5.Display Student By Id");
			System.out.println("6.Exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				Student s=service.createStudent();
				int n=service.insertStudent(s);
				if(n>0)
				{
					System.out.println("Record Inserted");
				}
				else
				{
					System.out.println("Record  not Inserted");
				}
				break;
				
			case 2:
				System.out.println("Enter student id for delete:");
				int sid=sc.nextInt();
				try {
					s=service.getById(sid);
					if(s!=null)
					{
					System.out.println(s);
					System.out.println("delete(y/n)?");
					String ans=sc.next();
					if(ans.equals("y"))
					{
						 n=service.deleteById(s);
						 if(n>0)
						 {
							 System.out.println("Record Deleted");
						 }
						 else
						 {
							 System.out.println("Error");
						 }
					}
				}
					else
					{
						System.out.println("Id not found");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				break;
				
			case 3:
				System.out.println("Enter student id for Update:");
				 sid=sc.nextInt();
				 try {
					s=service.getById(sid);
					if(s!=null)
					{
						System.out.println(s);
						System.out.println("Enter Data:");
						System.out.println("Enter Student Name:");
						String sname=sc.next();
						System.out.println("Enter Marks:");
						int marks=sc.nextInt();
						s=new Student(sid,sname,marks);
						n=service.updateStudent(s);
						if(n>0) {
							System.out.println("Record Updated");
						}
						else
						{
							System.out.println("Record Not Updated");
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				break;
				
			case 4:
				ArrayList<Student> slist;
				try {
					slist=service.displayAllStudent();
					slist.forEach((s1)->{System.out.println(s1);});
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case 5:
				System.out.println("Enter student id Display:");
				 sid=sc.nextInt();
				 try {
					s=service.getById(sid);
					System.out.println(s);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 6:
				System.exit(0);
				break;
				
			}
		}while(ch!=6);
	}

}
