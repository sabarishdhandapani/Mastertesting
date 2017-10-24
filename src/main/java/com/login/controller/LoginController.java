package com.login.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.login.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String login(){
		return "redirect:pages/login.jsp";
	}

	@RequestMapping(value="pages/userCheck", method = RequestMethod.POST)
	public String userCheck(ModelMap model, HttpServletRequest request) {
		String name =request.getParameter("name");
		String pwd =request.getParameter("pwd");

		boolean bool = loginService.validateLoginCredentials(name, pwd);
		
		if(bool)
		{
			model.addAttribute("message", "Successfully logged in.");
		    return "redirect:success.jsp";
		}
		else{
			model.addAttribute("message", "Username or password is wrong.");
			return "redirect:failure.jsp";
		}
		
		
	}
}