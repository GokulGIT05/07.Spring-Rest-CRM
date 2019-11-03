package com.luv2code.springdemo.rest.exception;

public class CustomerErrorResponse {
	
	int errorCode;
	
	String Message;
	
	long currentTimeInMilliSecs;
	

	public CustomerErrorResponse() {
		
	}


	public CustomerErrorResponse(int errorCode, String message, long currentTimeInMilliSecs) {
		super();
		this.errorCode = errorCode;
		Message = message;
		this.currentTimeInMilliSecs = currentTimeInMilliSecs;
	}


	public int getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}


	public String getMessage() {
		return Message;
	}


	public void setMessage(String message) {
		Message = message;
	}


	public long getCurrentTimeInMilliSecs() {
		return currentTimeInMilliSecs;
	}


	public void setCurrentTimeInMilliSecs(long currentTimeInMilliSecs) {
		this.currentTimeInMilliSecs = currentTimeInMilliSecs;
	}
	
	
}
