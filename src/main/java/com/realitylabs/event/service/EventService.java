package com.realitylabs.event.service;

import java.util.List;

public interface EventService<T> {

	public T get(int id);
	
	public List<T> list();
	
	public T update(T entity);

	public T create(T entity);

	public void delete(T entity);
	public void deleteById(int entityID);

}