package com.javaweb.controllerAdvice;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.model.ErrorResponseDTO;

import customException.FieldRequiredException;

@ControllerAdvice
public class controllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleArithmericException(ArithmeticException ex, WebRequest request) {
		ErrorResponseDTO error = new ErrorResponseDTO();
		error.setError(ex.getMessage());
		ArrayList<String> detail = new ArrayList<>();
		detail.add("sô khác không làm sao chia được cho 0??");
		error.setDetail(detail);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(FieldRequiredException.class)
	public ResponseEntity<Object> handleFieldRequiredException(FieldRequiredException ex, WebRequest request) {
		ErrorResponseDTO error = new ErrorResponseDTO();
		error.setError(ex.getMessage());
		ArrayList<String> detail = new ArrayList<>();
		detail.add("check lại dữ liệu");
		error.setDetail(detail);
		return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY);
	}
}
