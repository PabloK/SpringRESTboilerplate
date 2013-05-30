package com.realitylabs.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.realitylabs.event.entity.User;
import com.realitylabs.event.service.EventService;
import com.realitylabs.event.validator.RESTResourceValidator;

@Controller
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private EventService<User> userService;
	
	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public List<User> getAllUsers() {
		return userService.list();
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.GET )
	@ResponseBody
	public User getUser( @PathVariable("id") int id ) {
		return RESTResourceValidator.checkNotNull( userService.get(id) );
	}
	
	@RequestMapping( method = RequestMethod.POST )
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public User createUser( @RequestBody User entity ) {
		RESTResourceValidator.checkRequestResourceNotNull( entity );
		return userService.create( entity );
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.PUT )
	@ResponseStatus( HttpStatus.OK )
	public void updateUser( @PathVariable("id") int id, @RequestBody User entity ) {
		// TODO: Make sure id and entity.id isEqual, check for proper HttpStatus and implement in RESTResourceValidator		
		RESTResourceValidator.checkRequestResourceNotNull( entity );
		RESTResourceValidator.checkNotNull( userService.get( entity.getId() ) );
		userService.update(entity);
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
	@ResponseStatus( HttpStatus.OK )
	public void deleteUser( @PathVariable("id") int id) {
		userService.deleteById( id );
	}
	
}
