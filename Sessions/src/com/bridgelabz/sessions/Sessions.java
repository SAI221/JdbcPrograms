package com.bridgelabz.sessions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Sessions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int clickCount = 0;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		clickCount++;
		
		response.getOutputStream().println("<h1>You clicked the button " + clickCount + " times.</h1>");
		response.getOutputStream().println("<p>Click <a href=\"/NewFile.html\">here</a> to go back to the button.</p>");
	}	
	
}
