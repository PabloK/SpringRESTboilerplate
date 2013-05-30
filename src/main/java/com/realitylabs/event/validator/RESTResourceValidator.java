package com.realitylabs.event.validator;

import com.realitylabs.event.exception.BadRequestException;
import com.realitylabs.event.exception.ResourceNotFoundException;

public final class RESTResourceValidator {
	
	public static <T> T checkNotNull(T entity) {
		if(entity == null) {
			throw new ResourceNotFoundException("Entity not found");
		}
		return entity;
	}
	
	public static <T> T checkRequestResourceNotNull(T entity) {
		if(entity == null) {
			throw new BadRequestException("Bad request");
		}
		return entity;
	}
	
}
