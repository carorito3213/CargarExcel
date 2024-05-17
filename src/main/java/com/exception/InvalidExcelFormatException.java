package com.exception;

public class InvalidExcelFormatException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidExcelFormatException(String string) {
        super(string);
    }

}