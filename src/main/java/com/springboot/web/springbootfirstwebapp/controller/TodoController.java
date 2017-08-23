package com.springboot.web.springbootfirstwebapp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.web.springbootfirstwebapp.service.LoginService;
import com.springboot.web.springbootfirstwebapp.service.TodoService;


@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String showTodosList( ModelMap model){
		String name = (String) model.get("name");
		model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}
	@RequestMapping(value="/todo", method=RequestMethod.GET)
	public String showFormForAdding( ModelMap model){
		return "todo";
	}
	@RequestMapping(value="/todo", method=RequestMethod.POST)
	public String addTodo( ModelMap model, @RequestParam String description){
		service.addTodo((String) model.get("name"), description, new Date(), false);
		return "redirect:/list-todos";
	}
	
	
}
