package com.fdmgroup.model;

import javax.persistence.*;

@Entity
@Table(name = "Theatre")
@SequenceGenerator(name="seq_theatreid", initialValue=1, allocationSize=100)
@NamedQueries({

	// find all
	@NamedQuery(name = "th.findAll", query = "SELECT v FROM Theatre v"),
	// find by Id
	@NamedQuery(name = "th.findById", query = "SELECT v FROM Theatre v WHERE v.theatre_id = :id")

})
public class Theatre implements IStorable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_theatreid")
	@Column(name = "theatre_id")
	private int theatre_id;
	
	@Column(name = "theatre_name")
	private String theatre_name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "ca_state")
	private String ca_state;
	
	@Column(name = "contact_num")
	private String contact_num;

	public int getId() {
		return theatre_id;
	}

	public Theatre setId(int id) {
		this.theatre_id = id;
		return this;
	}

	public String getName() {
		return theatre_name;
	}

	public Theatre setName(String name) {
		this.theatre_name = name;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Theatre setAddress(String location) {
		this.address = location;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Theatre setCity(String city) {
		this.city = city;
		return this;
	}

	public String getState() {
		return ca_state;
	}

	public Theatre setState(String state) {
		this.ca_state = state;
		return this;
	}

	public String getContactNumber() {
		return contact_num;
	}

	public Theatre setContactNumber(String contactNumber) {
		this.contact_num = contactNumber;
		return this;
	}

	@Override
	public String toString() {
		return "Theatre [theatre_id=" + theatre_id + ", theatre_name=" + theatre_name + ", address=" + address
				+ ", city=" + city + ", ca_state=" + ca_state + ", contact_num=" + contact_num + "]";
	}

}
