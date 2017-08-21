package com.springboot.web.springbootfirstwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.web.springbootfirstwebapp.service.LoginService;


@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage( ModelMap model){
		//model.put("name", name);
		return "login";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showWelcomePage(@RequestParam String name,@RequestParam String password, ModelMap model){
		
		if(!service.validateUser(name, password)){
			model.put("errorMessage", "Invalid username or password");
			return "login";
		}
		
		model.put("name", name);
		model.put("password",password);
		return "welcome";
	}
}
