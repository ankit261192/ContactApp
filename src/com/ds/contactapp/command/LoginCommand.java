package com.ds.contactapp.command;

public class LoginCommand {
/**
 * moves data between controller and view
 * controller to view-->on edit operation
 * view to controller-->when any data is submitted from form
 */
	
	private String LoginName;
	private String password;
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
