package com.striker.DTO;



public class UsersListDTO {
	private int id;
	private String fname;
	private String lname;
	private String email;
	private long mobile;
	private String role;
	private String city;
	private String state;
	private String country;
	private String date;
	
	
	public UsersListDTO() {
		
	}
	public UsersListDTO(String fname, String email, long mobile, String role, String city, String state, String country) {
		super();
		this.fname = fname;
		this.email = email;
		this.mobile = mobile;
		this.role = role;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "UsersList [fname=" + fname + ", email=" + email + ", mobile=" + mobile + ", role=" + role + ", city="
				+ city + ", state=" + state + ", country=" + country + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	
	
}
