package com.fdmgroup.model;

import com.fdmgroup.enums.Genre;
import javax.persistence.*;

@Entity
@Table(name= "Movie")
@SequenceGenerator(name="seq_movieid", initialValue=1, allocationSize=100)
@NamedQueries({

	// find all
	@NamedQuery(name = "mov.findAll", query = "SELECT v FROM Movie v"),
	// find by Id
	@NamedQuery(name = "mov.findById", query = "SELECT v FROM Movie v WHERE v.movie_id = :id"),
	// find by Name
	@NamedQuery(name = "mov.findByName", query = "SELECT v FROM Movie v WHERE v.name = :name"),
	// search by Name
	@NamedQuery(name = "mov.searchByNameOrGenre", query = "SELECT v FROM Movie v WHERE upper(v.name) LIKE :name OR upper(v.genre) LIKE :name")

})
public class Movie implements IStorable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_movieid")
	@Column(name= "movie_id")
	private int movie_id;
	
	@Column(name= "movie_name")
	private String name;
	
	@Column(name= "synopsis")
	private String synopsis;
	
	@Column(name= "movie_cast")
	private String cast;
	
	@Column(name= "directors")
	private String directors;
	
	@Column(name= "producers")
	private String producers;
	
	@Column(name= "release_date")
	private String release_date;
	
	@Column(name= "movie_duration")
	private String duration;
	
	@Column(name= "genre")
	private String genre;
	
	@Column(name= "image_url")
	private String image_url;
	
	public int getId() {
		return movie_id;
	}

	public Movie setId(int id) {
		this.movie_id = id;

		return this;
	}

	public String getName() {
		return name;
	}

	public Movie setName(String name) {
		this.name = name;
		return this;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public Movie setSynopsis(String synopsis) {
		this.synopsis = synopsis;
		return this;
	}

	public String getCast() {
		return cast;
	}

	public Movie setCast(String cast) {
		this.cast = cast;
		return this;
	}

	public String getDirectors() {
		return directors;
	}

	public Movie setDirectors(String directors) {
		this.directors = directors;
		return this;
	}

	public String getProducers() {
		return producers;
	}

	public Movie setProducers(String producers) {
		this.producers = producers;
		return this;
	}

	public String getRelease_date() {
		return release_date;
	}

	public Movie setRelease_date(String release_date) {
		this.release_date = release_date;
		return this;
	}

	public String getDuration() {
		return duration;
	}

	public Movie setDuration(String duration) {
		this.duration = duration;
		return this;
	}

	public String getGenre() {
		return genre;
	}

	public Movie setGenre(String genre) {
		genre = genre.toUpperCase();
		this.genre = Genre.valueOf(genre).getGenreString();
		return this;
	}

	public String getImage_url() {
		return image_url;
	}

	public Movie setImage_url(String image_url) {
		this.image_url = image_url;
		return this;
	}

	@Override
	public String toString() {
		return "Movie [id=" + movie_id + ", name=" + name + ", cast=" + cast + ", directors=" + directors + ", genre=" + genre
				+ "]";
	}
}
