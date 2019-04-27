package com.bridgelabz.webPrograms;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidationFilter implements Filter {

	private Object context;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * PrintWriter out = response.getWriter(); String mobileNo =
		 * request.getParameter("mobileNo"); if (mobileNo.length() == 10) {
		 * chain.doFilter(request, response); } else {
		 * out.println("Enter valid mobile number");
		 * 
		 * RequestDispatcher rqst = request.getRequestDispatcher("/Registration.jsp");
		 * rqst.forward(request, response);
		 */
		HttpServletRequest request1=(HttpServletRequest) request;
		HttpServletResponse response1=(HttpServletResponse) response;
		HttpSession session=request1.getSession();
		if(session==null||session.getAttribute("user")==null) {
			//PrintWriter out = response.getWriter();
			//((ServletContext)this.context).log("Unauthorized access request"); 
			//out.println("Unauthorized access request");
		    response1.sendRedirect(request1.getContextPath()+"/Login.jsp");	
		}
		else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
