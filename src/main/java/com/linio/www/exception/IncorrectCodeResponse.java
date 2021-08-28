package com.linio.www.exception;

@SuppressWarnings("serial")
public class IncorrectCodeResponse extends AssertionError{

	public static final String MESSAGE="The service response code is not as expected";
	public IncorrectCodeResponse(String message, Throwable cause) {
		super(message, cause);
	}

}
