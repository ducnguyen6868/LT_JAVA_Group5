package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
	public String getStudentsAsString() {
	    StringBuilder studentsString = new StringBuilder();
	    String url = "jdbc:mysql://localhost:3306/QLTN";
	    String uname = "root";
	    String password = "Mysql@@2k3";
	    String query = "SELECT * FROM Students";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        return "Error: Could not load JDBC driver";
	    }
	    try (Connection con = DriverManager.getConnection(url, uname, password);
	         Statement statement = con.createStatement();
	         ResultSet result = statement.executeQuery(query)) {

	        while (result.next()) {
	            String student = "";
	            for (int i = 1; i < 6; i++) {
	                student += result.getString(i) + " ";
	            }
	            studentsString.append(student).append("\n");
	        }
	        return studentsString.toString();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return "Error: Could not retrieve students from database";
	    }
	}

	public static void main(String[] args) {

	// TODO Auto-generated method stub
		jdbc students = new jdbc();
		System.out.println(students.getStudentsAsString());
	}

}
