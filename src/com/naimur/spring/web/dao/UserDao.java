package com.naimur.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("userdao")
public class UserDao {

	private NamedParameterJdbcTemplate jdbc;
	
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SessionFactory sessionFactory;
	public Session session()
	{
		return sessionFactory.getCurrentSession();
	}

	public UserDao() {
		System.out.println("Creating UserDao");
	}
	

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Transactional
	public void create(User user) {
		
		//Hibernate uses
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
		
		// BeanPropertySqlParameterSource params = new
		// BeanPropertySqlParameterSource(user);
		/*
		 * MapSqlParameterSource params = new MapSqlParameterSource();
		 * 
		 * params.addValue("username", user.getUsername()); params.addValue("password",
		 * passwordEncoder.encode(user.getPassword())); params.addValue("email",
		 * user.getEmail()); params.addValue("name", user.getName());
		 * params.addValue("enabled", user.isEnabled()); params.addValue("authority",
		 * user.getAuthority());
		 * 
		 * return jdbc.update(
		 * "insert into users(username, password, name, email, authority, enabled) values(:username, :password, :name, :email, :authority, :enabled)"
		 * , params)==1;
		 */
		//return jdbc.update("insert into authorities(username, authority) values(:username, :authority)", params) == 1;
	}

	public boolean exists(String username) {
		/*
		 * return
		 * jdbc.queryForObject("select count(*) from users where username = :username",
		 * new MapSqlParameterSource("username", username), Integer.class) > 0;
		 */
	      Criteria crit = session().createCriteria(User.class);
	      crit.add(Restrictions.eq("username",username));
	      crit.add(Restrictions.idEq(username));
	      User user = (User) crit.uniqueResult();
	      return user!=null;
	}
 
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		
		return session().createQuery("from User").list();
		/*
		 * System.out.println(jdbc.query("select * from users",BeanPropertyRowMapper.
		 * newInstance(User.class))); return jdbc.query("select * from users",
		 * BeanPropertyRowMapper.newInstance(User.class));
		 */
	}

}
