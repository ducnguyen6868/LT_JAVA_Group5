package Controllers;

import JDBC.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@WebServlet("/login-checking")

public class ServletDemo extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    String username = req.getParameter("username");
	    String password = req.getParameter("pasword");
	    
	    jdbc Students= new jdbc();
	    String StudentInfo= Students.getStudentsAsString();

	    PrintWriter out = res.getWriter();
	    res.sendRedirect("homepage");
	    
	}

	
	
}
