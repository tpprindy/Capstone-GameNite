package com.capstone.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.persistence.Table;


@Entity
@Table(name = "events")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "title")
	private String title;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "post_date")
	private Date postedDate;

	@Column(name = "poster")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "qualifications")
	private String qualifications;

	@Column(name = "location_Street")
	private String locationStreet;

	@Column(name = "location_City")
	private String locationCity;

	@Column(name = "location_State")
	private String locationState;

	@Column(name = "location_Zip")
	private String locationZip;
	
	@Column(name ="numberOfPlayers")
	private int numberOfPlayers;
	
	@Column(name ="time")
	private String time;
	
	@OneToOne
	private User eventUser;

	public Event() {

	}

	public Event(String title, Date startDate, Date postedDate, String username, String email, String qualifications,
			String locationStreet, String locationCity, String locationState, String locationZip, int numberOfPlayers , String time, User eventUser) {
		
		this.title=title;
		this.startDate=startDate;
		this.postedDate=postedDate;
		this.username=username;
		this.email=email;
		this.qualifications=qualifications;
		this.locationStreet=locationStreet;
		this.locationCity=locationCity;
		this.locationState=locationState;
		this.locationZip=locationZip;
		this.eventUser=eventUser;
		this.numberOfPlayers=numberOfPlayers;
		this.time=time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public String getLocationStreet() {
		return locationStreet;
	}

	public void setLocationStreet(String locationStreet) {
		this.locationStreet = locationStreet;
	}

	public String getLocationCity() {
		return locationCity;
	}

	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}

	public String getLocationState() {
		return locationState;
	}

	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}

	public String getLocationZip() {
		return locationZip;
	}

	public void setLocationZip(String locationZip) {
		this.locationZip = locationZip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public User getEventUser() {
		return eventUser;
	}

	public void setEventUser(User eventUser) {
		this.eventUser = eventUser;
	}
	
	
	
	

}
