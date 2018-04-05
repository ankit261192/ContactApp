package com.ds.contactapp.exception;

public class UserBlockedException extends Exception {

	/**
	 * creates user object without error description
	 */
	public UserBlockedException() {
		
	}
	/**
	 * created user object with error description
	 * @param errdescription
	 */
	public UserBlockedException(String errdescription) {
		super(errdescription);
		}
}
