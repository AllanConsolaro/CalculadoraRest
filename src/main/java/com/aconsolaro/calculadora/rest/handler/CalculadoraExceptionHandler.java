package com.aconsolaro.calculadora.rest.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.aconsolaro.calculadora.rest.exception.ResponseException;
import com.aconsolaro.calculadora.rest.exception.UnsuportedMathOperationException;

@ControllerAdvice
public class CalculadoraExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseException> handleAllExceptions(Exception ex, WebRequest request) {
		ResponseException response = new ResponseException(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnsuportedMathOperationException.class)
	public final ResponseEntity<ResponseException> handleUnsuportedMathOperationException(UnsuportedMathOperationException ex, WebRequest request) {
		ResponseException response = new ResponseException(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
