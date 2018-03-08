package com.spring.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
@Component("usersDao")
public class UsersDAO {

	private NamedParameterJdbcTemplate jdbc;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	
	@Transactional
	public void create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
						
	}


	public boolean exists(String username) {
		Criteria criteria = session().createCriteria(User.class);
		//criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.idEq(username));
		User user = (User) criteria.uniqueResult();
		return user != null;
	}


	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return session().createQuery("from User", User.class).list();
	}


}
