package com.goeuro.utils;

/**
 * @author moosman
 *
 */

public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ApplicationException() {
		
	}
	
	public ApplicationException(String message) {
		super(message);
	}
	
	public ApplicationException(String message, Throwable throwable) {
		super(message, throwable);
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
	

}
