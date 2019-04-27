package com.bridgelabz.webPrograms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		PreparedStatement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		String query = "select * from info where name= ? and password= ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("class loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sai", "root", "password");
			System.out.println("connected...");
			stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, password);

			rs = stmt.executeQuery();
			if (rs.next()) {
				String user = rs.getString(5);
				System.out.println("UserId: " + user);
				
				/*
				 * Cookie cookieForUser = new Cookie("user",name); Cookie cookieForPassword =
				 * new Cookie("password",password); response.addCookie(cookieForUser);
				 * response.addCookie(cookieForPassword);
				 */
				 HttpSession oldSession = request.getSession(false);
		            if (oldSession != null) {
		                oldSession.invalidate();
		            }
		            //generate a new session
		            HttpSession newSession = request.getSession(true);
		            request.getSession().setAttribute("user", name);
		            newSession.setMaxInactiveInterval(10);
		           response.sendRedirect("Welcome.jsp");
		            Cookie message = new Cookie("message", "Welcome");
		response.addCookie(message);
				
				out.println("Welcome   " + user);
				out.println("cookie value is "+ message.hashCode());
				out.println("session value is  " + newSession.getAttribute("user"));
				/*
				 * Cookie ck[]=request.getCookies(); for(int i=0;i<ck.length;i++){
				 * out.println(ck[i].getName()+" "+ck[i].getValue()+" "+ck[i].hashCode() ); }
				 */
			} else {
				System.out.println("invalid user");
				out.println("Invalid User Do new Registration");
				RequestDispatcher rqst = request.getRequestDispatcher("/Registration.jsp");
				rqst.forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}
