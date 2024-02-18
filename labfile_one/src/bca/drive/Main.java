package bca.drive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import bca.model.teacher;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InputMismatchException {
		// TODO Auto-generated method stub
		//1. load and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2
		String url = "jdbc:mysql://localhost:3306/teachers";
		String username = "root";
		String pwd = "Mysql@2024";
		Connection con = DriverManager.getConnection(url, username, pwd);
		Scanner sc = new Scanner(System.in);
		teacher s = new teacher();
		//insert 
		//s.addTeacher(con, sc);
		while(true) {
			
			menu();
			int choice = sc.nextInt();
			switch(choice) {
			case 1: s.addTeacher(con, sc);
				break;
				
			case 2: s.displayTeachers(con);
				break;
				
			case 3: s.updateTeacherName(con, sc);
				break;
				
			case 4: s.deleteTeacher(con, sc);
				break;
				
			case 5:
				System.out.println("Bye Bye ...");
				System.exit(0);
			
			default:
				System.out.println("Wrong Choice...");
			}
			 
		}
		}
		
	
	public static void menu() {
		System.out.println("------------Menu-----------");
		System.out.println("1. Add New teacher");
		System.out.println("2. Display All Teachers");
		System.out.println("3. Update Name of teacher");
		System.out.println("4. Delete a teacher");
		System.out.println("5. Exit");
		System.out.println("Your Choice...");
	}

}