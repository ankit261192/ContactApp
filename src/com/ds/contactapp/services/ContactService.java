package com.ds.contactapp.services;

import java.util.List;

import com.ds.contactapp.domain.Contact;

/**
 * specifies all operations for contact entity
 * @author Ankit
 *
 */
public interface ContactService {

	public void save(Contact c);
	public void update(Contact c);
	
	//single record delete
	public void delete(Integer contactId);
	
	//bulk delete
	public void delete(Integer[] contactId);
	
	public Contact findById(Integer contactId);
	/**
	 * shows list of contacts of currently logged in user(userid)
	 * @param userid-->user who is logged in
	 * @return
	 */
	
	public List<Contact> findUserContact(Integer userid);
	
	/**
	 * shows list of contacts of currently logged in userusing free text criteria (txt)
	 * @param userid-->user who is logged in
	 * @param txt-->free text entered to search user
	 * @return
	 */
	// 
	public List<Contact> findUserContact(Integer userid,String txt);
	

}
