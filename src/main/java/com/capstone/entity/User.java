package com.capstone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "age")
	private String age;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "password")
	private String password;

	@Column(name = "password2")
	private String password2;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "role")
	private String role;

	@Column(name = "timePlayed")
	private String timePlayed;

	public User() {
	}

	public User(String firstName, String lastName, String age, String telephone, String email, String password,
			String password2, String username, String role, String timePlayed) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
		this.password2 = password2;
		this.role = role;
		this.timePlayed = timePlayed;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTimePlayed() {
		return timePlayed;
	}

	public void setTimePlayed(String timePlayed) {
		this.timePlayed = timePlayed;
	}

}
