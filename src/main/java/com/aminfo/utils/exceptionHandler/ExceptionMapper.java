package com.aminfo.utils.exceptionHandler;

public class ExceptionMapper {
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ExceptionMapper [error=" + error + "]";
	}
}
