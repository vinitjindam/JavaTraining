package com.crudemployee.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class EmployeeNotFoundHandler {
	
	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<String> employeeNotFoundException(){
		return new ResponseEntity<String>("Employee not found/exception check",HttpStatus.NOT_ACCEPTABLE);
	}

}
