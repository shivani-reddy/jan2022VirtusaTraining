package com.spring.pojo;

public class Author {

	private String fullname;	
	private String dob;
	private String country;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Author [fullname=" + fullname + ", dateOfBirth=" + dob + ", country=" + country + "]";
	}
}