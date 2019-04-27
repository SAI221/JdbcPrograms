package com.bridgelabz.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/jsp");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("userName");
		out.println("Welcome  " + name);

		Cookie cookie = new Cookie("url", name);
		// Cookie cookie = new Cookie("url","");
		System.out.println("Cookie Created");
		cookie.setMaxAge(60);
		response.addCookie(cookie);
		Cookie ck[] = request.getCookies();
		for (Cookie obj : ck) {
			out.print("Hello " + obj.getValue());
		}

	}

}
