package com.farmtracker.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
    public String redirectHome(HttpServletRequest request) throws IOException {
        return "redirect:/home";
    }
	
	@RequestMapping(value = "/home")
    public String home(HttpServletRequest request) throws IOException {
        return "home";
    }
	
}
