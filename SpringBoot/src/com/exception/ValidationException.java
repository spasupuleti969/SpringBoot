package com.exception;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValidationException(Exception e) {
		super(e);
	}

	public ValidationException(Exception e, String message) {
		super(e + "" + message);
	}
	public ValidationException(String message) {
		super(message);
	}

	public ValidationException() {
		super("validation exception occured");
	}
}
