package com.realitylabs.event.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.realitylabs.event.entity.User;

@Repository
public class UserDAOImpl implements DAO<User> {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public User get(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}
	
	@Override
	public List<User> list() {
		Query query = sessionFactory.getCurrentSession().createQuery("from User");
		List<User> results = new ArrayList<User>();
		
		for(Object o: query.list()) {
			results.add((User) o);
		}
		
		return results;
	}

	@Override
	public User update(User entity) {
		sessionFactory.getCurrentSession().update(entity);
		return entity;
	}

	@Override
	public User create(User entity) {
		sessionFactory.getCurrentSession().save(entity);
		return entity;
	}

	@Override
	public void delete(User entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public void deleteById(int entityID) {
		User userObject = get(entityID);
		if(userObject != null) {
			sessionFactory.getCurrentSession().delete(userObject);
		}	
	}
	
}
