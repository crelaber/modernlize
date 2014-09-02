package com.uwen.ur.exception;

public class RuntimeMessageException extends RuntimeException {

	public RuntimeMessageException() {
		super();
	}

	public RuntimeMessageException(String message, Throwable cause) {
		super(message, cause);
	}

	public RuntimeMessageException(String message) {
		super(message);
	}

	public RuntimeMessageException(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5964910336883130789L;

}
