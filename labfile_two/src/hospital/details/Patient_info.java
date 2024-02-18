package hospital.details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Patient_info {

	public Patient_info() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void addPatient_info(Connection con, Scanner sc) throws SQLException 
	{
		Statement st = con.createStatement();
		
		//read Patient details
		System.out.println("Enter Patient Id: ");
		int id = sc.nextInt();
		
		System.out.println("Enter Patient Name: ");
		String name = sc.next();
		
		System.out.println("Enter Patient Age: ");
		int age = sc.nextInt();
		
		System.out.println("Enter Patient Gender: ");
		String gender = sc.next();
		
		System.out.println("Enter Patient Date of Birth (DOB) in format YYYY/MM/DD: ");
        String dob = sc.next();
        
        System.out.println("Enter Patient City: ");
        String city = sc.next();

		
		//create sql squery string
		String query = String.format("Insert Into patient_info values(%d, '%s', %d, '%s', '%s', '%s') ", id, name, age, gender, dob, city);
		
		//execute sql query
		int rows = st.executeUpdate(query);
		
		System.out.println(rows + " record inserted!!!");
	}
	
	public void displayPatient_info(Connection con) throws SQLException 
	{
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from patient_info");
		System.out.println("Displaying all patient info");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+ "\t"+rs.getString(2)+ "\t"+ rs.getInt(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
		}
	}
	
	public void updatePatient_name(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter Patient ID: ");
		int id = sc.nextInt();
		System.out.println("Enter Patient New Name: ");
		String name = sc.next(); 
		
		String query = String.format("update patient_info set name='%s' where id = %d", name, id);
		int rowsAffected = st.executeUpdate(query);
		System.out.println(rowsAffected+" recored updated!!!");
	
	}
	
	public void updatePatient_city(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter Patient ID: ");
		int id = sc.nextInt();
		System.out.println("Enter Patient New City name: ");
		String city = sc.next(); 
		
		String query = String.format("update patient_info set city='%s' where id = %d", city, id);
		int rowsAffected = st.executeUpdate(query);
		System.out.println(rowsAffected+" recored updated!!!");
	
	}
	
	
	public void deletePatient_info(Connection con, Scanner sc) throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter Patient ID: ");
		int id = sc.nextInt();
		
		int rowAffected = st.executeUpdate("delete from patient_info where id = "+id);
		System.out.println(rowAffected + " recored deleted!!!");
	}
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/hospital";
		String username = "root";
		String pwd = "Mysql@2024";
		Connection con = DriverManager.getConnection(url, username, pwd);
		
		Scanner sc = new Scanner(System.in);
		
		Patient_info pi = new Patient_info();
		
	while(true) {
			
			menu();
			int choice = sc.nextInt();
			switch(choice) {
			case 1: pi.addPatient_info(con, sc);
				break;
				
			case 2: pi.displayPatient_info(con);
				break;
				
			case 3: pi.updatePatient_name(con, sc);
				break;
			case 4:
				pi.updatePatient_city(con, sc);
				break;
				
			case 5: pi.deletePatient_info(con, sc);
				break;
				
			case 6:
				System.out.println("Bye Bye ...");
				System.exit(0);
			
			default:
				System.out.println("Wrong Choice...");
			}
			 
		}
		}
		
	
	public static void menu() {
		System.out.println("------------Menu-----------");
		System.out.println("1. Add New Patient");
		System.out.println("2. Display All Patients");
		System.out.println("3. Update Name of Patient");
		System.out.println("4. Update City of Patient");
		System.out.println("5. Delete a Patient details");
		System.out.println("6. Exit");
		System.out.println("Your Choice...");
	}
		
	}


