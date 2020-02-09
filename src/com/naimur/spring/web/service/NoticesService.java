package com.naimur.spring.web.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naimur.spring.web.dao.Notice;
import com.naimur.spring.web.dao.NoticeDao;

@Service("noticeService")
public class NoticesService {

	private NoticeDao noticeDao;

	@Autowired
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public List<Notice> getCurrent() {
		return noticeDao.getNotice();
	}

	public void create(@Valid Notice notice) {
		noticeDao.saveOrUpdate(notice);

	}

	public void throwTestException() {
		noticeDao.getNoticeWithId(656);

	}

	public boolean hasNotice(String name) {
		if (name == null)
			return false;
		List<Notice> notices = noticeDao.getNotice(name);

		if (notices.size() == 0)
			return false;

		return true;
	}

	public Notice getNotice(String username) {
		if (username == null)
			return null;
		List<Notice> notice = noticeDao.getNotice(username);
		if (notice.size() == 0)
			return null;

		return notice.get(0);
	}

	public void saveAndUpdate(@Valid Notice notice) {
		if(notice.getId()!=0)
		{
			noticeDao.saveOrUpdate(notice);
		}
		else
		{
			noticeDao.saveOrUpdate(notice);
		}
		
	}

	public void delete(int id) {
		noticeDao.delete(id);
		
	}

}
