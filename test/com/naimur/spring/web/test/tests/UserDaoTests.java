package com.naimur.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.naimur.spring.web.dao.Notice;
import com.naimur.spring.web.dao.NoticeDao;
import com.naimur.spring.web.dao.User;
import com.naimur.spring.web.dao.UserDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:com/naimur/spring/web/config/dao-contex.xml",
		"classpath:com/naimur/spring/web/config/security-context.xml",
		"classpath:com/naimur/spring/web/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {

	@Autowired
	private UserDao userDao;
	@Autowired
	private DataSource datasource;
	@Autowired
	private NoticeDao noticeDao;

	private User user1 = new User("kawsar", "kawsar hossain tuhin", "kawsar12345", "kaswar@gmail.com", true,
			"ROLE_USER");

	private User user2 = new User("kawsar1", "kawsar hossain tuhin", "kawsar12345", "kaswar@gmail.com", true,
			"ROLE_ADMIN");

	private User user3 = new User("kawsar2", "kawsar hossain tuhin", "kawsar12345", "kaswar@gmail.com", true,
			"ROLE_USER");

	private User user4 = new User("kawsar3", "kawsar hossain tuhin", "kawsar12345", "kaswar@gmail.com", false, "user");

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(datasource);

		jdbc.execute("delete from notice");
		jdbc.execute("delete from users");
	}

	@Test
	public void testCreateRetrive() {
		userDao.create(user1);
		List<User> user1 = userDao.getAllUser();
		assertEquals("One user should have created and retrive!!! ", 1, user1.size());

		// assertEquals("Inserted user should match retrived", user1, user1.get(0));

		userDao.create(user2);
		userDao.create(user3);
		userDao.create(user4);
		List<User> user2 = userDao.getAllUser();
		assertEquals("Four user should have created and retrive", 4, user2.size());
		// assertEquals("Inserted user should match retrived",user1,user1.get(0));
	}

	@Test
	public void testExists() {

		userDao.create(user1);
		userDao.create(user2);
		userDao.create(user3);
		userDao.create(user4);
		assertTrue("User should exist", userDao.exists(user1.getUsername()));
		assertFalse("User should not exist", userDao.exists("naan"));
	}

	@Test
	public void testCreateUser() {
		User user = new User("mas65um", "Masum Billa", "dalim123456", "dalim@gmail.com", true, "ROLE_USER");
		userDao.create(user);
		List<User> users = userDao.getAllUser();
		assertEquals("Number should be 1", 1, users.size());
		assertTrue("User should exist", userDao.exists(user.getUsername()));
		assertFalse("User should not exist", userDao.exists("naan"));
		// assertEquals("Create User should be identical to retrived
		// user",user,users.get(0));

	}

}
