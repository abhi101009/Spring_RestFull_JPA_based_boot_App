package com.aminfo.utils.exceptionHandler;

public class GenericException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
	public GenericException() {
		super();
	}
	
	public GenericException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
