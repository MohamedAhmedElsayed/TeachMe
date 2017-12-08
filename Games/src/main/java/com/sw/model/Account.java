package com.sw.model;
 
public class Account {

    String userName;
    String Password;
    String Email;
    
    String UserType;

    public Account() {
        this.userName = "";
        this.Password = "";
        this.Email = "";
         this.UserType = "";
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

	public Account(String userName, String Password, String Email, String Type) {
        this.userName = userName;
        this.Password = Password;
        this.Email = Email;
         this.UserType = Type;
    }
} 
