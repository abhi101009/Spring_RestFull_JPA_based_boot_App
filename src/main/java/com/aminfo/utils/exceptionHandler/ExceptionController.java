package com.aminfo.utils.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/*
 * @ControllerAdvice, In version 3.2, where can create a Controller Advice class in our
 * application, which would be capable of handling all the global exception
 * scenarios.
 */
@ControllerAdvice

/*
 * Spring 4.0 introduced @RestController, a specialized version of the
 * controller which is a convenience annotation that does nothing more than add
 * the @Controller and @ResponseBody annotations
 */
@RestController
public class ExceptionController {
	
	@ExceptionHandler(GenericException.class)
	public ResponseEntity<ExceptionMapper> exceptionHandler(Exception ex) {
		ExceptionMapper error = new ExceptionMapper();
		error.setError(ex.getMessage());
		return new ResponseEntity<ExceptionMapper>(error, HttpStatus.OK);
	}
	
	
}
