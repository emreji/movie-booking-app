package com.fdmgroup.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fdmgroup.daoImpl.UserDaoImpl;
import com.fdmgroup.model.MBUser;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDaoImpl userDao = new UserDaoImpl();
		MBUser foundUser = userDao.readByUsername(username);
	
		if (foundUser != null && password != null && password.equals(foundUser.getPwd())) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedInUser", foundUser);
		} else {
			System.out.println("User not found!");
		}
		String referrer = request.getHeader("referer");
		if(referrer.equals("http://localhost:8088/MovieBookingWeb/")) {
			RequestDispatcher rd = request.getRequestDispatcher("/");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/showtimes");
			rd.forward(request, response);
		}
		
		
	}

}
