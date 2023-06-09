package com.crudemployee.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class UnableToDeleteHandler {
	
	@ExceptionHandler(UnableToDelete.class)
	public ResponseEntity<String> unableToDeleteException(){
		return new ResponseEntity<String>("ID Not Found/Unable to Delete employee ",HttpStatus.NOT_ACCEPTABLE);
	}
}
