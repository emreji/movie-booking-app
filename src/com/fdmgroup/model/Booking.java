package com.fdmgroup.model;

import javax.persistence.*;

@Entity
@Table(name = "Booking")
@SequenceGenerator(name="seq_bookingid", initialValue=1, allocationSize=100)
@NamedQueries({

	// find by Id
	@NamedQuery(name = "book.findById", query = "SELECT v FROM Booking v WHERE v.booking_id = :id")

})
public class Booking implements IStorable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_bookingid")
	@Column(name= "booking_id")
	private int booking_id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private MBUser user;
	
	@ManyToOne
	@JoinColumn(name="screen_id")
	private Screen screen;
	
	@Column(name= "num_of_tickets")
	private int numberOfTickets;

	public int getId() {
		return booking_id;
	}

	public Booking setId(int id) {
		this.booking_id = id;
		return this;
	}

	public MBUser getUser() {
		return user;
	}

	public Booking setUser(MBUser user) {
		this.user = user;
		return this;
	}

	public Screen getScreen() {
		return screen;
	}

	public Booking setScreen(Screen screen) {
		this.screen = screen;
		return this;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public Booking setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
		return this;
	}

	@Override
	public String toString() {
		return "Booking [id=" + booking_id + ", user=" + user + ", screen=" + screen + ", numberOfTickets=" + numberOfTickets
				+ "]";
	}

}
