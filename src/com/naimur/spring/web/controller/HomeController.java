package com.naimur.spring.web.controller;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naimur.spring.web.dao.Notice;
import com.naimur.spring.web.service.NoticesService;

@Controller
public class HomeController {

	private static Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private NoticesService noticeService;

	@RequestMapping("/")
	public String showHome(Model model, Principal principal) {
		System.out.println("Home visited");
		logger.debug("Showing Home...");
		List<Notice> notice = noticeService.getCurrent();
		model.addAttribute("notice", notice);
        
		boolean hasNotice =false;
		
		if(principal!=null)
		{
			hasNotice = noticeService.hasNotice(principal.getName());
		}
		
		model.addAttribute("hasNotice", hasNotice);
		return "home";
	}

}
