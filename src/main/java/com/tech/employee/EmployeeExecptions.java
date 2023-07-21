package com.tech.employee;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class EmployeeExecptions {
	@ExceptionHandler(NameNotException.class)
	public ResponseEntity<Object> noNameExecptionHandling(NameNotException n) {
		return new ResponseEntity<>(n.getMessage(), HttpStatus.NOT_ACCEPTABLE);

	}
	@ExceptionHandler(AgeNotException.class)
	public ResponseEntity<Object> noAgeExecptionHandling(AgeNotException a) {
		return new ResponseEntity<>(a.getMessage(), HttpStatus.NOT_ACCEPTABLE);

	}
	@ExceptionHandler(GenderNotException.class)
	public ResponseEntity<Object> noGenderExecptionHandling(GenderNotException a) {
		return new ResponseEntity<>(a.getMessage(), HttpStatus.NOT_ACCEPTABLE);

	}
	@ExceptionHandler(SalaryNotException.class)
	public ResponseEntity<Object> noSalaryExecptionHandling(SalaryNotException a) {
		return new ResponseEntity<>(a.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}
	


}
