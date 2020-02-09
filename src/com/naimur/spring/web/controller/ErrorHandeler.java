package com.naimur.spring.web.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandeler {

	  @ExceptionHandler(DataAccessException.class) 
	  public String handleDatabaseException(DataAccessException ex) {
	  
	  return "error";
	  
	  }
	  @ExceptionHandler(AccessDeniedException.class) 
	  public String handleAcessDeniedException(AccessDeniedException ex) {
	  System.out.println("DeniedExeption Handeller Controler!");
	  return "denied";
	  
	  }
}
