package com.farmtracker.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmtracker.model.Event;
import com.farmtracker.model.Farm;

@Repository
public class EventDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	public void createEvent(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);
	}
	
	public void updateEvent(Event event) {
		sessionFactory.getCurrentSession().update(event);
	}
	
	public void deleteEvent(Event event) {
		sessionFactory.getCurrentSession().delete(event);
	}
	
	public Event getEvent(int key){
		return (Event)sessionFactory.getCurrentSession().load(Event.class,key);
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> getEvents(Farm farm){
		return sessionFactory.getCurrentSession().createQuery("from Event e where e.action.farm.farmKey=:key")
			.setParameter("key",farm.getKey())
				.list();
	}

}
