package com.estoque.estoque.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.estoque.estoque.service.exceptions.DuplicateObjectException;
import com.estoque.estoque.service.exceptions.EntityHasDependenciesException;
import com.estoque.estoque.service.exceptions.ObjectnotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ObjectnotFoundException.class)
	public ResponseEntity<StandardError> handlerException(Exception e, HttpServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				"Objeto não encontrado", e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DuplicateObjectException.class)
	public ResponseEntity<StandardError> duplicateObjectException(Exception e, HttpServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.CONFLICT.value(),
				"Objeto já cadastrado", e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

	@ExceptionHandler(EntityHasDependenciesException.class)
	public ResponseEntity<StandardError> entityHasDependenciesException(Exception e, HttpServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.CONFLICT.value(),
				"Objeto possui dependências", e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
}
