package com.estoque.estoque.service.exceptions;

public class DuplicateObjectException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicateObjectException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateObjectException(String message) {
		super(message);
	}
}
