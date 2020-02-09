package com.naimur.spring.web.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.naimur.spring.web.dao.FormValidationGroup;
import com.naimur.spring.web.dao.Notice;
import com.naimur.spring.web.service.NoticesService;

@Controller
public class NoticesController {

	private NoticesService noticeService;

	@Autowired
	public void setNoticeService(NoticesService noticeService) {
		this.noticeService = noticeService;
	}

	/*
	 * @ExceptionHandler(DataAccessException.class) public String
	 * handleDatabaseException(DataAccessException ex) {
	 * 
	 * return "error";
	 * 
	 * }
	 */

	@RequestMapping("/notices")
	public String showNotice(Model model) {

//		 noticeService.throwTestException(); 
		List<Notice> notice = noticeService.getCurrent();
		model.addAttribute("notice", notice);

		return "notices";
	}

	@RequestMapping("/createnotice")
	public String createNotice(Model model, Principal principal) {

		Notice notice = null;
		if (principal != null) {
			String username = principal.getName();
			notice = noticeService.getNotice(username);
		}
		if (notice == null) {
			notice = new Notice();
		}

		model.addAttribute(notice);
		return "createnotice";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Validated(value=FormValidationGroup.class) Notice notice, BindingResult result, Principal principal,
			@RequestParam(value = "delete", required = false) String delete) {
		if (result.hasErrors()) {

			return "createnotice";
		}
		if(delete==null)
		{
			
			String username = principal.getName();
			notice.getUser().setUsername(username);
			noticeService.saveAndUpdate(notice);

			return "noticecreated";
		}
		else
		{
			noticeService.delete(notice.getId());
			return "noticedelete";
		}

	}

}
