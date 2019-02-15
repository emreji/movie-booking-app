package com.fdmgroup.dao;

import java.util.List;
import com.fdmgroup.model.Movie;

public interface IMovieDao extends ICreatable<Movie>, IReadable<Movie>, IDeletable<Movie>, IUpdatable<Movie> {
	public Movie findMovieByName(String movieName);
	public List<Movie> searchMovieByNameOrGenre(String searchInput);
	public List<Movie> findMoviesByGenre(String genre);
}
