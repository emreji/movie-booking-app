package com.fdmgroup.model;

import javax.persistence.*;

@Entity
@Table(name = "MBUser")
@SequenceGenerator(name="seq_userid", initialValue=1, allocationSize=100)
@NamedQueries({
	@NamedQuery(name = "user.findAll", query = "SELECT u FROM MBUser u"),
	@NamedQuery(name = "user.findByUsername", query = "SELECT u FROM MBUser u WHERE u.username = :username"),
	@NamedQuery(name = "user.findByFirstname", query = "SELECT u FROM MBUser u WHERE u.firstname LIKE :fname")
})
public class MBUser implements IStorable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_userid")
	@Column(name= "user_id")
	private int user_id;
	
	@Column(name= "username")
	private String username;

	@Column(name= "pwd")
	private String pwd;
	
	@Column(name= "email")
	private String email;
	
	@Column(name= "firstname")
	private String firstname;
	
	@Column(name= "lastname")
	private String lastname;

	public int getId() {
		return user_id;
	}

	public MBUser setId(int id) {
		this.user_id = id;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public MBUser setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPwd() {
		return pwd;
	}

	public MBUser setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public MBUser setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public MBUser setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public MBUser setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	@Override
	public String toString() {
		return "User [id=" + user_id + ", username=" + username + ", password=" + pwd + ", email=" + email
				+ ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	
}
