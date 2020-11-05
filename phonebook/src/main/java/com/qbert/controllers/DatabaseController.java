package com.qbert.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.qbert.dataAccess.DbOperations;
import com.qbert.model.Contacts;
import com.qbert.model.User;

@Controller
public class DatabaseController {
	
	@RequestMapping("/usersave")
	public String savingUser(@ModelAttribute("userDetail") User u2,Model model) {
		int j=0;
		j=DbOperations.saveUser(u2);
		model.addAttribute("count", j);
		return "registrationStatus";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/userLoginCred")
	public String LoggingUser(HttpServletRequest req,Model model,HttpSession session) {
		if(session.getAttribute("UserObj")!=null) {
			//System.out.println(session.getAttribute("UserObj"));
			return "userDashboard";		
		}
		String email=req.getParameter("user_email");
		String password=req.getParameter("user_password");
		User u;
		if((u=DbOperations.checkCredential(email, password))!=null) {
			session.setAttribute("UserObj",u);
			return "userDashboard";
		}else {
			model.addAttribute("loginFail", "Please enter correct login credentials");
			return "userLoginForm";
		}
	}
	@RequestMapping("userLogout")
	public String LoggingOut(HttpSession session) {
		session.removeAttribute("UserObj");
		//System.out.println(session.getAttribute("UserObj"));
		return "userLoginForm";
	}
	@RequestMapping("showContact")
	public String displayContact(HttpSession session,Model model) {
		User ses=(User) session.getAttribute("UserObj");
		//System.out.println("user is"+ses);
		if(ses==null) {
			return "userLoginForm";
		}
		System.out.println("user id is "+ses.getUser_id());
		int fk=ses.getUser_id();
		List<Contacts> list=DbOperations.getUserContacts(fk);
		if(list!=null) {
		model.addAttribute("ConList", list);
		}
		return "userContactLists";
	}
	@RequestMapping(value = "/contactsave")
	public ModelAndView saveContact(@RequestParam("name") String name,@RequestParam("number") String number,@RequestParam("address") String address,@RequestParam("image")CommonsMultipartFile cmf,HttpSession session) {
		int j=0;
		Contacts c2=new Contacts();
		c2.setFuser((User)session.getAttribute("UserObj"));
		c2.setName(name);
		c2.setAddress(address);
		c2.setNumber(number);
		c2.setImage(cmf.getBytes());
//		System.out.println("this is fuser "+c2);
//		String path=session.getServletContext().getRealPath("/");  
	    String filename=cmf.getOriginalFilename();  
	    System.out.println("file name is = "+filename);
//		try {
//			byte []brr=cmf.getBytes();
//			BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(path+"/"+filename));
//			bout.write(brr);
//			bout.flush();
//			bout.close();
//		}catch(Exception e) {
//			System.out.println(e);
//		}
		j=DbOperations.saveContact(c2);
		ModelAndView mv=new ModelAndView("redirect:/showContact");
		mv.addObject("count", j);
		return mv;
	}
	
}
