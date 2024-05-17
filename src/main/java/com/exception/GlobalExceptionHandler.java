package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	/*private final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
    private final HttpStatus notFound = HttpStatus.NOT_FOUND;
    private final HttpStatus unauthorized = HttpStatus.UNAUTHORIZED;
    HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;*/
    
    @ExceptionHandler(ExcelIOException.class)
    public ResponseEntity<?> handleExcelIOException(ExcelIOException ex) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(InvalidExcelFormatException.class)
    public ResponseEntity<?> handleInvalidExcelFormatException(InvalidExcelFormatException ex) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    

}
