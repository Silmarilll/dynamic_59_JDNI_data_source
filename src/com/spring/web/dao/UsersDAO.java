package com.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Transactional
@Component("usersDao")
public class UsersDAO {

	private NamedParameterJdbcTemplate jdbc;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private SessionFactory sessionFactory;
	

	public NamedParameterJdbcTemplate getJdbc() {
		return jdbc;
	}
	
	public Session session() {
		return sessionFactory.getCurrentSession();
	}


	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	
	@Transactional
	public boolean create(User user) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("email", user.getEmail());
		params.addValue("name", user.getName());
		params.addValue("enabled", user.isEnabled());
		params.addValue("authority", user.getAuthority());
		return jdbc.update("insert into users (username, name, authority, password, email, enabled) values(:username, :name, :authority, :password, :email,:enabled)", params) == 1;
				
	}


	public boolean exists(String username) {
		return jdbc.queryForObject("select count(*) from users where username=:username", 
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}


	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return session().createQuery("from User", User.class).list();
	}


}
