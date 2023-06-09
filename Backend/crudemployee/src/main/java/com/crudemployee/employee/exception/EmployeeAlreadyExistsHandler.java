package com.crudemployee.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Component
@ControllerAdvice
public class EmployeeAlreadyExistsHandler {
	@ExceptionHandler(EmployeAlreadyExists.class)
	public ResponseEntity<String> employeeAlreadyExistsException(){
		return new ResponseEntity<String>("Employee is already registered",HttpStatus.NOT_ACCEPTABLE);
	}

}
