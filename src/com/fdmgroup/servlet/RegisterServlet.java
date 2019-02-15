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

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// // TODO Auto-generated method stub
	// response.getWriter().append("Served at: ").append(request.getContextPath());
	// }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		MBUser newUser = new MBUser().setFirstname(firstname).setLastname(lastname).setEmail(email)
				.setUsername(username).setPwd(password);

		UserDaoImpl userDao = new UserDaoImpl();
		MBUser foundUser = userDao.readByUsername(username);
		System.out.println(foundUser);
		
		if (foundUser == null && password.equals(confirmPassword)) {
			userDao.create(newUser);
			HttpSession session = request.getSession();
			session.setAttribute("registerSuccess", true);
		} else {
			System.out.println("Please use a different username!");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/");
		rd.forward(request, response);
	}

}
