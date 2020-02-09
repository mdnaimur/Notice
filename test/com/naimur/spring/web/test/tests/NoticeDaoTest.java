package com.naimur.spring.web.test.tests;

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
public class NoticeDaoTest {

	@Autowired
	private UserDao userDao;
	@Autowired
	private DataSource datasource;
	@Autowired
	private NoticeDao noticeDao;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(datasource);

		jdbc.execute("delete from notice");
		jdbc.execute("delete from users");
	}

	@Test
	public void testNotices() {
		User user = new User("mas65ullolm", "Masum Billa", "dalim", "dalim@gmail.com", true, "ROLE_USER");
		//assertTrue("User Create should return true", userDao.create(user));

		Notice notice = new Notice(user, "This is a test notice This is a test notice This is a test notice");
		noticeDao.saveOrUpdate(notice);
		List<Notice> notices = noticeDao.getNotice();
	
		 try {
				assertEquals("Shoulde be on offer in database", 1, notices.size());
		assertEquals("Retrived notice should match created notice", notice, notices.get(0));

		
		throw new RuntimeException("Should have failed");
		    } catch (AssertionError ex) {
		    System.out.println(ex.getMessage().contains("Value not in the expected collection: " + 3));
		    }
		 
		notice = notices.get(0);
		notice.setText("Update offer test");
		 noticeDao.saveOrUpdate(notice);
		// Notice updated = noticeDao.getNotice(notice.getId());
		Notice updated = noticeDao.getNoticeWithId(notice.getId());
		assertEquals("Updated notice should amthc retrieved update notice", notice, updated);
		
		Notice notice2 = new Notice(user,"This is test notice form test notice Monday");
		noticeDao.saveOrUpdate(notice2);
		List<Notice> usernotice = noticeDao.getNotice(user.getUsername());
		
		noticeDao.delete(notice.getId());
		/*
		 * assertEquals("should return two for two notice", 2, usernotice.size());
		 * noticeDao.delete(notice.getId()); List<Notice> empty = noticeDao.getNotice();
		 * //assertEquals("Notice lists should be empty", 0, empty.size());
		 */	}

}
