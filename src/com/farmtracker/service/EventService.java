package com.farmtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmtracker.dao.EventDAO;
import com.farmtracker.model.Event;
import com.farmtracker.model.Farm;

@Service
@Transactional
public class EventService {

	@Autowired
    private EventDAO eventDAO;
	
	@Transactional
    public void addEvent(Event event) {
		eventDAO.createEvent(event);
    }
	
	@Transactional
	public void updateEvent(Event event) {
		eventDAO.updateEvent(event);
	}
	
	@Transactional
	public void deleteEvent(Event event) {
		eventDAO.deleteEvent(event);
	}
	
	@Transactional
	public Event getEvent(Integer key) {
		return eventDAO.getEvent(key);
	}
	
	@Transactional
	public List<Event> getEvents(Farm farm){
		return eventDAO.getEvents(farm);
	}
	
	@Transactional
	public List<Event> getEvents(Farm farm, Integer searchBy, String searchValue){
		return eventDAO.getEvents(farm, searchBy, searchValue);
	}
	
	public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO=eventDAO;
    }
	
}
