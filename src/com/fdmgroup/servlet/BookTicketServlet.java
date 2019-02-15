package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fdmgroup.daoImpl.BookingDaoImpl;
import com.fdmgroup.daoImpl.ScreenDaoImpl;
import com.fdmgroup.model.Booking;
import com.fdmgroup.model.MBUser;
import com.fdmgroup.model.Screen;

public class BookTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookTicketServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MBUser loggedInUser = (MBUser)session.getAttribute("loggedInUser");
		
		BookingDaoImpl bookDao = new BookingDaoImpl();
		ScreenDaoImpl screenDao = new ScreenDaoImpl();
		
		int theatreId = Integer.parseInt(request.getParameter("theatre"));
		int movieBookedId = Integer.parseInt(request.getParameter("movieBookedId"));
		int numOfTickets = Integer.parseInt(request.getParameter("numOfTickets"));
		Screen screenBooked = screenDao.findScreenByMovieId(movieBookedId, theatreId);
		Booking booking = new Booking().setNumberOfTickets(numOfTickets).setUser(loggedInUser).setScreen(screenBooked);
		bookDao.create(booking);
		
		session.setAttribute("movieBooked", true);
		
		RequestDispatcher rd = request.getRequestDispatcher("showtimes");
		rd.forward(request, response);
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
