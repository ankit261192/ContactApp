package com.ds.contactapp.domain;

public class User {
private Integer userid;
private String name;
private String phone;
private String email;
private String address;
private String loginname;
private String password;
private Integer role;
private Integer loginstatus;
public User() {
	// TODO Auto-generated constructor stub
}

public User(Integer userid, String name, String phone, String email, String address, String loginname, String password,
		Integer role, Integer loginstatus) {
	super();
	this.userid = userid;
	this.name = name;
	this.phone = phone;
	this.email = email;
	this.address = address;
	this.loginname = loginname;
	this.password = password;
	this.role = role;
	this.loginstatus = loginstatus;
}

public Integer getUserid() {
	return userid;
}
public void setUserid(Integer userid) {
	this.userid = userid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getLoginname() {
	return loginname;
}
public void setLoginname(String loginname) {
	this.loginname = loginname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Integer getRole() {
	return role;
}
public void setRole(Integer role) {
	this.role = role;
}
public Integer getLoginstatus() {
	return loginstatus;
}
public void setLoginstatus(Integer loginstatus) {
	this.loginstatus = loginstatus;
}

}
