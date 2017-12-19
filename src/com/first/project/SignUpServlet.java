package com.first.project;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);

	}      
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		System.out.println("in post");
		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmailId(request.getParameter("emailId"));
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		
		SignUpDao dao = new SignUpDaoImpl();
		
		try {
			String usersignUp = dao.signUp(user);
			if(usersignUp.equals("success")){
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			}else {
				
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}