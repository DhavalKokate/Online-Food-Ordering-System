package com.app.custom_exceptions;

@SuppressWarnings("serial")
public class UserHandlingException extends RuntimeException {


	public UserHandlingException(String mesg)
      {
    	  super(mesg);
      }
}
