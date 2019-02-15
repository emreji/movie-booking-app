package com.fdmgroup.enums;

public enum Genre {
	COMEDY ("COMEDY"), 
	DRAMA ("DRAMA"), 
	THRILLER ("THRILLER"), 
	HORROR ("HORROR"), 
	ACTION ("ACTION"), 
	ADVENTURE ("ADVENTURE"), 
	ANIMATION ("ANIMATION"), 
	SCI_FI ("SCIENCE FICTION"), 
	FANTASY ("FANTASY");
	
	private final String genreText;
	
	Genre(final String genreText) {
		this.genreText = genreText;
	}
	
	public String getGenreString() {
		return genreText;
	}
}
