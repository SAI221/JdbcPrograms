package com.bridgelabz.webPrograms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistrationPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection con = null;
		PreparedStatement pstmt;
		String query = "insert into info values(?,?,?,?,?);";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("class loaded in post");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sai", "root", "password");
			System.out.println("connection done in post");
			pstmt = con.prepareStatement(query);
			String name = request.getParameter("name");
			String mobileNo = request.getParameter("mobileNo");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println(request.getParameter("userid"));
			String userId = request.getParameter("userid");
			pstmt.setString(1, name);
			System.out.println("inserted");
			pstmt.setString(2, mobileNo);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.setString(5, userId);
			pstmt.executeUpdate();
			PrintWriter out = response.getWriter();
			out.println("<html><body bgcolor='cyan'>" + "<h2>Registered Successfully!!!<h2>" + "</body></html>");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		
	}

}
