package bca.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class teacher {

	public teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void addTeacher(Connection con, Scanner sc) throws SQLException {
		//create statement
		Statement st = con.createStatement();
		
		//read teacher details
		System.out.println("Enter teacher Id: ");
		int id = sc.nextInt();
		
		System.out.println("Enter teacher Name: ");
		String name = sc.next();
		
		System.out.println("Enter teacher Age: ");
		int age = sc.nextInt();
		
		System.out.println("Enter teacher Gender: ");
		String gender = sc.next();
		
		//create sql squery string
		String query = String.format("Insert Into Teacher_info values(%d, '%s', %d, '%s') ", id, name, age, gender);
		
		//execute sql query
		int rows = st.executeUpdate(query);
		
		System.out.println(rows + " record inserted!!!");
		
	}
	
	public void displayTeachers(Connection con) throws SQLException {
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from Teacher_info");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+ "\t"+rs.getString(2)+ "\t"+ rs.getInt(3)+"\t"+rs.getString(4));
		}
	}
    
	public void updateTeacherName(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter teacher ID: ");
		int id = sc.nextInt();
		System.out.println("Enter teacher New Name: ");
		String name = sc.next(); 
		
		String query = String.format("update Teacher_info set name='%s' where id = %d", name, id);
		int rowsAffected = st.executeUpdate(query);
		System.out.println(rowsAffected+" recored updated!!!");
	
	}   
	
	public void deleteTeacher(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter teacher ID: ");
		int id = sc.nextInt();
		
		int rowAffected = st.executeUpdate("delete from Teacher_info where id = "+id);
		System.out.println(rowAffected + " recored deleted!!!");
	}
}