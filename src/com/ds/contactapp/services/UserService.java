package com.ds.contactapp.services;

import java.util.List;

import com.ds.contactapp.domain.User;
import com.ds.contactapp.exception.UserBlockedException;

public interface UserService {
	//constants
	public static final Integer LOGIN_STATUS_ACTIVE=1;
	public static final Integer LOGIN_STATUS_BLOCKED=2;
	public static final Integer ADMIN_ROLE=1;
	public static final Integer USER_ROLE=2;
	
	/**
	 * the method handles user registration task.
	 * the new user detail as user object
	 * @param u
	 */
	public void register(User u);
	/**
	 * method handles authentication operation using given credentials.
	 * it return user object on success and null on failed
	 * when user account is blocked, an exception will be thrown by this method
	 * @param loginname
	 * @param password
	 * @return
	 * @throws com.ds.contactapp.exception.UserBlockedException when user account is blocked
	 */
	public User Login(String loginName,String password) throws UserBlockedException;
	
	/**
	 * call this to get lsit of registerd users
	 * @return
	 */
	public List<User> getUserList();
	
	/**
	 * this will change the login status of user based on details passed as args.
	 * active=1,blocked=2 
	 * @param userid
	 * @param loginstatus
	 */
	public void changeLoginStatus(Integer userid,Integer loginstatus);
	
	/**
	 * to check user name availabilty
	 * @param username
	 * @return
	 */
	public boolean isUsernameExist(String username);
}
