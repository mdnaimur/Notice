package com.naimur.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("noticeDao")
public class NoticeDao {

	private NamedParameterJdbcTemplate jdbc;
	
	public NoticeDao() {
		System.out.println("Creating from Spring  NoticeDao");
	}
	@Autowired
	private SessionFactory sessionFactory;
	public Session session()
	{
		return sessionFactory.getCurrentSession();
	}
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Notice> getNotice() {
		
		Criteria crt = session().createCriteria(Notice.class);
		crt.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
		
		return crt.list();


		//return jdbc.query("select * from notice,users where notice.username = users.username and users.enabled = true", new NoticeRowMapper());

	}
	@SuppressWarnings("unchecked")
	public List<Notice> getNotice(String username) {
		
		Criteria crt = session().createCriteria(Notice.class);
		crt.createAlias("user", "u");
		crt.add(Restrictions.eq("u.enabled", true));
		crt.add(Restrictions.eq("u.username", username));
		
		return crt.list();

		//return jdbc.query("select * from notice,users where notice.username = users.username and users.enabled = true and notice.username=:username", new MapSqlParameterSource("username",username), new NoticeRowMapper());

	}
	
	public boolean delete(int id)
	{
		Query query = session().createQuery("select from notice where id:id");
		query.setLong("id",id);
	   return query.executeUpdate()==1;
		
		/*
		 * MapSqlParameterSource params = new MapSqlParameterSource();
		 * params.addValue("id", id); return
		 * jdbc.update("delete from notice where id = :id", params)==1;
		 */
		
	}
	
	/*
	 * public void update(Notice notice) { session().update(notice);
	 * 
	 * // BeanPropertySqlParameterSource params = new
	 * BeanPropertySqlParameterSource(notice); // // return
	 * jdbc.update("update  notice set text=:text where id = :id", params)==1; }
	 */
	
	@Transactional
	public int[] create(List<Notice> notices)
	{
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(notices.toArray());
		return jdbc.batchUpdate("insert into notice(username, text) values(:username,:text)", params);
	}
	
	public void saveOrUpdate(Notice notice)
	{
		
		session().saveOrUpdate(notice);
//		
//		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);
//		
//		return jdbc.update("insert into notice(username,text) values(:username, :text)", params)==1;
	}
	
	public Notice getNoticeWithId(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idm", id);

		return jdbc.queryForObject("select * from notice, users where notice.username = users.username and users.enabled = true and id = :idm",params, new NoticeRowMapper());

	}

}
