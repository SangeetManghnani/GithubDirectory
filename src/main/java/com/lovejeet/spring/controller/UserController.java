package com.lovejeet.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lovejeet.spring.dto.form.Employee;


@Controller
@RequestMapping("/")
public class UserController {
	
	//private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String showForm(Model model, @ModelAttribute("employee") Employee employee) {
		return "welcome";
    }
 
	
	@InitBinder("employee")
	public void webDataBinder(WebDataBinder binder){
		/*binder.registerCustomEditor(Date.class,"leaveStartDate", new DatePropertyEditor());*/
	}
}
