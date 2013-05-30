package com.realitylabs.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.realitylabs.event.dao.DAO;
import com.realitylabs.event.entity.User;

@Service
@Transactional
public class UserServiceImpl implements EventService<User> {

	@Autowired
	private DAO<User> userDAO;
	
	@Override
	@Transactional
	public User get(int id) {
		return userDAO.get(id);
	}
	
	@Override
	@Transactional
	public List<User> list() {
		return userDAO.list();
	}

	@Override
	@Transactional
	public User update(User entity) {
		userDAO.update(entity);
		return entity;
	}

	@Override
	@Transactional
	public User create(User entity) {
		userDAO.create(entity);
		return entity;
	}

	@Override
	@Transactional
	public void delete(User entity) {
		userDAO.delete(entity);
	}

	@Override
	public void deleteById(int entityID) {
		userDAO.deleteById(entityID);
	}
	
}
