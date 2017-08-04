package com.farmtracker.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.farmtracker.model.Action;
import com.farmtracker.model.User;
import com.farmtracker.service.ActionService;
import com.farmtracker.util.Util;

@Controller
public class ActionController {
	
	private static final Logger LOG = Logger.getLogger(ActionController.class.getName());
	
	@Autowired
	private ActionService actionService;
	
	@RequestMapping(value = "/actions")
    public ModelAndView listActions(ModelAndView model,HttpServletRequest request) throws IOException {
        List<Action> actions=actionService.getActions(((User)request.getSession().getAttribute(Util.LOGGED_IN_USER)).getFarm());
        model.addObject("actions",actions);
        model.setViewName("actions");
        return model;
    }
	
	@RequestMapping(value = "/newAction", method = RequestMethod.GET)
    public ModelAndView newAction(ModelAndView model,HttpServletRequest request) {
        Action action=new Action();
        action.setFarm(((User)request.getSession().getAttribute(Util.LOGGED_IN_USER)).getFarm());
        model.addObject("action",action);
        model.setViewName("action_form");
        return model;
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST)
    public ModelAndView saveAction(@ModelAttribute Action action,HttpServletRequest request) {
			if(action.getKey() == null) {
	            actionService.addAction(action);
	        }
	        else actionService.updateAction(action);

        return new ModelAndView("redirect:/actions");
    }
	
	@RequestMapping(value = "/deleteAction", method = RequestMethod.GET)
    public ModelAndView deleteAction(HttpServletRequest request) {
        int key=Integer.parseInt(request.getParameter("key"));
        actionService.deleteAction(actionService.getAction(key));	
        return new ModelAndView("redirect:/actions");
    }
	
	@RequestMapping(value = "/editAction", method = RequestMethod.GET)
    public ModelAndView editAction(HttpServletRequest request) {
        int key = Integer.parseInt(request.getParameter("key"));
        Action action=actionService.getAction(key);
        ModelAndView model = new ModelAndView("action_form");
        model.addObject("action",action);
        return model;
    }
	
}
