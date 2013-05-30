package com.realitylabs.event.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND )
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2739767655413855370L;
	
	public ResourceNotFoundException() {
        super();
    }
	
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

}
