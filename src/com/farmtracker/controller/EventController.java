package com.farmtracker.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.farmtracker.model.Action;
import com.farmtracker.model.Animal;
import com.farmtracker.model.Event;
import com.farmtracker.model.Farm;
import com.farmtracker.model.User;
import com.farmtracker.service.ActionService;
import com.farmtracker.service.AnimalService;
import com.farmtracker.service.EventService;
import com.farmtracker.uibeans.EventSearch;
import com.farmtracker.util.Util;

@Controller
public class EventController {

	private static final Logger LOG = Logger.getLogger(EventController.class.getName());
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private ActionService actionService;
	
	@Autowired
	private AnimalService animalService;
	
	@RequestMapping(value = "/events")
    public ModelAndView listEvents(ModelAndView model,HttpServletRequest request){
		Farm farm=((User)request.getSession().getAttribute(Util.LOGGED_IN_USER)).getFarm();
		Integer searchBy=(Integer)request.getSession().getAttribute(Util.EVENT_SEARCH_BY);
		String searchValue=(String)request.getSession().getAttribute(Util.EVENT_SEARCH_VALUE);
		
        List<Event> events=(searchBy==null || searchValue==null) ? 
        		eventService.getEvents(farm) : 
        		eventService.getEvents(farm,searchBy,"%"+searchValue+"%");
        EventSearch search=new EventSearch();
        search.setSearchType(searchBy);
        search.setSearchValue(searchValue);
        model.addObject("events",events);
        model.addObject("eventSearch",search);
        model.setViewName("events");
        return model;
    }
	
	@RequestMapping(value = "/searchEvents", method = RequestMethod.POST)
    public ModelAndView eventSearch(@ModelAttribute EventSearch eventSearch,HttpServletRequest request,@RequestParam String action) {
        if(action.equals("reset")) {
        	request.getSession().removeAttribute(Util.EVENT_SEARCH_BY);
            request.getSession().removeAttribute(Util.EVENT_SEARCH_VALUE);
        }
        else {
        	request.getSession().setAttribute(Util.EVENT_SEARCH_BY,(Integer)eventSearch.getSearchType());
        	request.getSession().setAttribute(Util.EVENT_SEARCH_VALUE,eventSearch.getSearchValue());
        }
        return new ModelAndView("redirect:/events");
    }
	
	@RequestMapping(value = "/newEvent", method = RequestMethod.GET)
    public ModelAndView newEvent(ModelAndView model,HttpServletRequest request) {
        Event event=new Event();
        model.addObject("event",event);
        model.addObject("actions",getActions(((User)request.getSession().getAttribute(Util.LOGGED_IN_USER)).getFarm()));
        model.addObject("animals",getAnimals(((User)request.getSession().getAttribute(Util.LOGGED_IN_USER)).getFarm()));
        model.setViewName("event_form");
        return model;
    }
	
	@RequestMapping(value = "/saveEvent", method = RequestMethod.POST)
    public ModelAndView saveEvent(@ModelAttribute Event event,HttpServletRequest request) {
			if(event.getKey() == null) {
	            eventService.addEvent(event);
	        }
	        else eventService.updateEvent(event);

        return new ModelAndView("redirect:/events");
    }
	
	@RequestMapping(value = "/deleteEvent", method = RequestMethod.GET)
    public ModelAndView deleteEvent(HttpServletRequest request) {
        int key=Integer.parseInt(request.getParameter("key"));
        eventService.deleteEvent(eventService.getEvent(key));	
        return new ModelAndView("redirect:/events");
    }
	
	@RequestMapping(value = "/editEvent", method = RequestMethod.GET)
    public ModelAndView editEvent(HttpServletRequest request) {
        int key = Integer.parseInt(request.getParameter("key"));
        Event event=eventService.getEvent(key);
        ModelAndView model = new ModelAndView("event_form");
        model.addObject("event",event);
        model.addObject("actions",getActions(((User)request.getSession().getAttribute(Util.LOGGED_IN_USER)).getFarm()));
        model.addObject("animals",getAnimals(((User)request.getSession().getAttribute(Util.LOGGED_IN_USER)).getFarm()));
        return model;
    }
	
	private List<Action> getActions(Farm farm){
		return actionService.getActions(farm);
	}
	
	private List<Animal> getAnimals(Farm farm){
		return animalService.getAnimals(farm);
	}
	
}
