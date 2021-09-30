package com.app.exc_handler;

import java.time.LocalDateTime;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.custom_exceptions.UserHandlingException;
import com.app.dto.ErrorResponse;

@ControllerAdvice //mandotory :to tell SC following class contains centralized Exc Handler methods
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
       @ExceptionHandler(RuntimeException.class)
       public ResponseEntity<?> handleRuntimeException(RuntimeException e)
       {
    	   System.out.println("in runtime handler method"+e);
    	   ErrorResponse resp=new ErrorResponse("Adding User failed!!!!!", LocalDateTime.now());
    	   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp); 	   
       }  
       
       @ExceptionHandler(UserHandlingException.class)
       public ResponseEntity<?> handleUserHandlingException(UserHandlingException e)
       {
    	   System.out.println("in runtime handler method"+e);
    	   ErrorResponse resp=new ErrorResponse("Invalid User ID!!!", LocalDateTime.now());
    	   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp); 	   
       }
       
     //if id is not match then this exception occur
       @ExceptionHandler(EmptyResultDataAccessException.class)
       public ResponseEntity<?> handleEmptyResultData(EmptyResultDataAccessException e)
       {
    	   System.out.println("in handler exc"+e);
    	   ErrorResponse resp=new ErrorResponse(e.getMessage(), LocalDateTime.now());
    	   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp); 	   
       }
       
}
