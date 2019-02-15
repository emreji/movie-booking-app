package com.fdmgroup.model;

import javax.persistence.*;

@Entity
@Table(name= "SCREEN")
@SequenceGenerator(name="seq_screenid", initialValue=1, allocationSize=100)
@NamedQueries({

	// find all
	@NamedQuery(name = "screen.findAll", query = "SELECT v FROM Screen v"),
	// find theatres by movie Id
	@NamedQuery(name = "screen.findTheatresByMovieId", query = "SELECT v.theatre FROM Screen v WHERE v.movie.movie_id = :movie_id"),
	// find Screen by movie Id and theatre id
	@NamedQuery(name = "screen.findScreenByMovieIdAndTheatreId", query = "SELECT v FROM Screen v WHERE v.movie.movie_id = :movie_id AND v.theatre.theatre_id = :theatre_id")

})
public class Screen implements IStorable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_screenid")
	@Column(name= "screen_id")
	private int screen_id;
	
	@ManyToOne
	@JoinColumn(name= "movie_id")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name= "theatre_id")
	private Theatre theatre;
	
	@Column(name= "movie_time")
	private String time;
	
	@Column(name= "screen_capacity")
	private int capacity;

	public int getId() {
		return screen_id;
	}

	public Screen setId(int id) {
		this.screen_id = id;
		return this;
	}

	public Movie getMovie() {
		return movie;
	}

	public Screen setMovie(Movie movie) {
		this.movie = movie;
		return this;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public Screen setTheatre(Theatre theatre) {
		this.theatre = theatre;
		return this;
	}

	public String getTime() {
		return time;
	}

	public Screen setTime(String time) {
		this.time = time;
		return this;
	}

	public int getCapacity() {
		return capacity;
	}

	public Screen setCapacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	@Override
	public String toString() {
		return "Screen [id=" + screen_id + ", movie=" + movie + ", theatre=" + theatre + ", capacity=" + capacity + "]";
	}

}
