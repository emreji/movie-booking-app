package com.fdmgroup.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fdmgroup.daoImpl.MovieDaoImpl;
import com.fdmgroup.daoImpl.ScreenDaoImpl;
import com.fdmgroup.model.Movie;
import com.fdmgroup.model.Theatre;

public class ShowtimesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowtimesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("movieDetails.jsp");
		String movieName = request.getParameter("movieName");
		MovieDaoImpl movieDao = new MovieDaoImpl();
		Movie movie = movieDao.findMovieByName(movieName);
		
		int movieId = movie.getId();
		ScreenDaoImpl screenDao = new ScreenDaoImpl();
		List<Theatre> theatreList = screenDao.findTheatresByMovieId(movieId);
		
		request.setAttribute("movie", movie);
		request.setAttribute("theatres", theatreList);
		rd.forward(request, response);
	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse
	 response) throws ServletException, IOException {
		 doGet(request, response);
	 }

}
