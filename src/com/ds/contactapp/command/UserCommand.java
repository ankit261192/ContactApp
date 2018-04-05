package com.ds.contactapp.command;

import com.ds.contactapp.domain.User;

public class UserCommand {
	//TODO:add more fields if required .also you can add check box(fields not in db)
private User user;

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

}
