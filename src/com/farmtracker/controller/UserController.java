package com.farmtracker.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.farmtracker.model.Farm;
import com.farmtracker.model.Role;
import com.farmtracker.model.User;
import com.farmtracker.service.EmailService;
import com.farmtracker.service.FarmService;
import com.farmtracker.service.RoleService;
import com.farmtracker.service.UserService;

@Controller
public class UserController {

	private static final Logger LOG = Logger.getLogger(UserController.class.getName());

	@Autowired
	private UserService userService;
	
	@Autowired
	private FarmService farmService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value = "/users")
    public ModelAndView listUsers(ModelAndView model) throws IOException {
        List<User> users=userService.getUsers();
        model.addObject("users",users);
        model.setViewName("users");
        return model;
    }
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public ModelAndView newUser(ModelAndView model) {
        User user=new User();
        model.addObject("user",user);
        model.addObject("farms",getFarms());
        model.addObject("roles",getRoles());
        model.setViewName("user_form");
        return model;
    }
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute User user,HttpServletRequest request) {
        if(user.getKey() == null) {
        	user.setDateCreated(new Date());
        	userService.addUser(user);
        	emailService.send(
        		user.getEmail(),
        		"noreply@farmerslittlehelper.com",
        		"Welcome To Farmers Little Helper",
        		"hello world"
        	);
        }
         
        else userService.updateUser(user);
        

        return new ModelAndView("redirect:/users");
    }
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {
        int key=Integer.parseInt(request.getParameter("key"));
        userService.deleteUser(userService.getUser(key));	
        return new ModelAndView("redirect:/users");
    }
	
	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser(HttpServletRequest request) {
        int key = Integer.parseInt(request.getParameter("key"));
        User user=userService.getUser(key);
        ModelAndView model = new ModelAndView("user_form");
        model.addObject("user", user);
        model.addObject("farms",getFarms());
        model.addObject("roles",getRoles());
        return model;
    }
	
	private List<Farm> getFarms(){
		return farmService.getFarms();
	}
	
	private List<Role> getRoles(){
		return roleService.getRoles();	
	}
}
