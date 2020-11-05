package com.qbert.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbert.model.Contacts;
import com.qbert.model.User;

@Controller
public class indexController {
	
	@RequestMapping("/new")
	public String userFormPage(Model model) {
		User u1=new User();
		model.addAttribute("userDetail", u1);
		return "userRegisterForm";
	}
	@RequestMapping("/old")
	public String userLoginPage() {
		return "userLoginForm";
	}
	
	@RequestMapping("/addCon")
	public String addContactForm(Model model,HttpSession session){
//		Contacts c1=new Contacts();
//		model.addAttribute("contactDetail", c1);
		return "addContactForm";
	}
}
