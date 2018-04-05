package com.ds.contactapp.dao;

import java.util.List;

import com.ds.contactapp.domain.User;

public interface UserDao {

	public void save(User u);
	public void update(User u);
	public void delete(User u);
	public void delete(Integer userid);
	public User findById(Integer userid);
	public List<User> findAll();
	public List<User> findByProperty(String propName,Object propValue);
}
