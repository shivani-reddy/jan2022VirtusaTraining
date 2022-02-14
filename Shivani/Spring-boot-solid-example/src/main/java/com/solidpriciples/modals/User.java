package com.solidpriciples.modals;

public class User {

	 private Long id;
	 private String email;
	 private String password;
     private String firstName;
     private String lastName;
     
   //constructor, getters and setters
   // methods that directly relate to the user details
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
     
     
    //public void searchUser(){
	// logic to search user details
	//}
	//we cannot have this method as it violates the Single Responsibility principle.
	//we need create one more class to perform this
    
}
