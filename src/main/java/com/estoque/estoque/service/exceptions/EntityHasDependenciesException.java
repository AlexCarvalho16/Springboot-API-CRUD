package com.estoque.estoque.service.exceptions;

public class EntityHasDependenciesException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EntityHasDependenciesException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EntityHasDependenciesException(String message) {
		super(message);
	}
}
