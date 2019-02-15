package com.fdmgroup.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fdmgroup.daoImpl.MovieDaoImpl;
import com.fdmgroup.model.Movie;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		
		MovieDaoImpl movieDao = new MovieDaoImpl();
		List<Movie> movieList = movieDao.readAll();
		request.setAttribute("movies", movieList);
		if(request.getSession().getAttribute("movieBooked") != null) {
			request.getSession().removeAttribute("movieBooked");
		}
		
		if(request.getSession().getAttribute("registerSuccess") != null) {
			request.getSession().removeAttribute("registerSuccess");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
