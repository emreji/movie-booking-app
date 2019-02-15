package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Screen;
import com.fdmgroup.model.Theatre;

public interface IScreenDao extends ICreatable<Screen>, IReadable<Screen>, IDeletable<Screen>, IUpdatable<Screen> {
	List<Theatre> findTheatresByMovieId(int movieId);
	Screen findScreenByMovieId(int movieId, int theatreId);
}
