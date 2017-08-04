package com.farmtracker.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.farmtracker.model.User;
import com.farmtracker.service.UserService;
import com.farmtracker.util.Util;

@Controller
public class LoginController {

	private static final Logger LOG = Logger.getLogger(LoginController.class.getName());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login")
    public ModelAndView getLoginForm(ModelAndView model) throws IOException {
		model.addObject("user",new User());
		model.setViewName("login_form");
        return model;
    }
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute User user, RedirectAttributes redirect, HttpServletRequest request) {
        User loggedInUser=userService.getUser(user.getEmail(),user.getPassword());
        	if(loggedInUser==null) {
        		ModelAndView model=new ModelAndView("redirect:/login");
        		redirect.addFlashAttribute("errorMessage","Invalid Login");
        		return model;
        	}
        request.getSession().setAttribute("LOGGEDIN_USER",loggedInUser);
        return new ModelAndView("redirect:/users");
    }
	
	@RequestMapping(value = "/logout")
    public ModelAndView getLogout(ModelAndView model,HttpServletRequest request) throws IOException {
		request.getSession().removeAttribute(Util.LOGGED_IN_USER);
		model.setViewName("redirect:/login");
        return model;
    }
}
