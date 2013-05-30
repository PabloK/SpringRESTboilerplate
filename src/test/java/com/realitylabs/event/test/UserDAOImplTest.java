package com.realitylabs.event.test;

import junit.framework.Assert;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;

import com.realitylabs.event.dao.UserDAOImpl;
import com.realitylabs.event.entity.User;

public class UserDAOImplTest {
	
	private UserDAOImpl userDAO;
	private SessionFactory sessionFactory;
	
	@BeforeClass
	public static void beforeClass() {
	}
	
	@AfterClass
	public static void afterClass() {
	}
	
	@Before
	public void setUp() {
		userDAO = new UserDAOImpl();
		sessionFactory = mock(SessionFactory.class);
		userDAO.sessionFactory = sessionFactory;
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void testUpdateCalled() {
		Session sessionObj = mock(Session.class);
		User userOne = new User();
		userOne.setName("pablo");
		when(sessionFactory.getCurrentSession()).thenReturn(sessionObj);
		doNothing().when(sessionObj).update(any(User.class));
		userDAO.update(userOne);
		verify(sessionObj).update(any(User.class));
	}
}
