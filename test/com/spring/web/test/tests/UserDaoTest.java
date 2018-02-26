package com.spring.web.test.tests;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.web.dao.User;
import com.spring.web.dao.UsersDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("dev")
@ContextConfiguration(locations={
		"classpath:com/spring/web/config/dao-context.xml",
		"classpath:com/spring/web/config/security-context.xml",
		"classpath:com/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
	
	@Autowired
	private UsersDAO usersDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);			
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}

	
	@Test
	public void createUser() {
		User user = new User("UserName", "name@gmail.com", "Name", "1", true, "Offers");	
		boolean result = usersDao.create(user);
		List<User> users = usersDao.getAllUsers();
		assertTrue("User creation should return true", result);
		assertEquals(1, users.size());
	}
}
