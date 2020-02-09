package com.naimur.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naimur.spring.web.dao.FormValidationGroup;
import com.naimur.spring.web.dao.User;
import com.naimur.spring.web.service.UserService;

@Controller
public class LoginController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		System.out.println("Login visited");
		return "login";
	}
	@RequestMapping("/denied")
	public String showDenied() {
		System.out.println("denied visited");
		return "denied";
	}
	@RequestMapping("/loggedout")
	public String showLogout() {
		System.out.println("loggedout visited");
		return "loggedout";
	}
	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		
		
		try {

			List<User> user = userService.getAllUser();
			model.addAttribute("users",user);

		} catch (Exception ex) {
			ex.printStackTrace();
			ex.getMessage();
			
		}
		
	return "admin";
	}

	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		model.addAttribute("user", new User());
		System.out.println("NewAccount visited");
		return "newaccount";
	}

	/*
	 * @RequestMapping("/createaccount") public String showCreateAccount() {
	 * 
	 * System.out.println("createaccount visited"); return "accountcreated"; }
	 */
	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String doCreate(@Validated(FormValidationGroup.class) User user, BindingResult result) {
		if (result.hasErrors()) {

			return "newaccount";
		}
		user.setAuthority("user");
		user.setEnabled(true);
		if(userService.exists(user.getUsername()))
		{
			result.rejectValue("username", "Dublicatekey.user.username", "This name has been already exist");
			return "newaccount";
			
		}
		
		try {

			userService.create(user);

		} catch (Exception ex) {
			ex.getMessage();
		}

		return "accountcreated";
	}
}
