package com.fdmgroup.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fdmgroup.daoImpl.MovieDaoImpl;
import com.fdmgroup.model.Movie;
import com.google.gson.Gson;

public class SearchMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchMovieServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		List<Movie> movieList = null;
		String searchInput = request.getParameter("searchItem").trim();
		MovieDaoImpl movieDao = new MovieDaoImpl();
		if(searchInput.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("/");
			rd.forward(request, response);
		} else {
			movieList = movieDao.searchMovieByNameOrGenre(searchInput);
		}
		Gson gson = new Gson();
		String jsonMovies = gson.toJson(movieList);
		
		response.setContentType("application/json");
		out.print(jsonMovies);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
