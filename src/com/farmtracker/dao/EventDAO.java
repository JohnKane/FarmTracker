package com.farmtracker.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmtracker.model.Event;
import com.farmtracker.model.Farm;
import com.farmtracker.uibeans.EventSearch.SearchType;
import com.farmtracker.util.Util;

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
	
	public Long getCountEvents(Farm farm, Integer searchBy, String searchValue){
		Query query;
			if(searchBy!=null && searchValue!=null) {
				if(searchBy.equals(SearchType.ACTION.getKey())) {
					query=sessionFactory.getCurrentSession().createQuery("select count(e.eventKey) from Event e where e.action.farm.farmKey=:key and upper(e.action.name) like :action")
							.setParameter("key",farm.getKey())
							.setParameter("action",searchValue.toUpperCase());
				}
				else if(searchBy.equals(SearchType.NAME.getKey())) {
					query=sessionFactory.getCurrentSession().createQuery("select count(e.eventKey) from Event e where e.action.farm.farmKey=:key and upper(e.animal.name) like :name")
							.setParameter("key",farm.getKey())
							.setParameter("name",searchValue.toUpperCase());
				}
				else if(searchBy.equals(SearchType.ID.getKey())) {
					query=sessionFactory.getCurrentSession().createQuery("select count(e.eventKey) from Event e where e.action.farm.farmKey=:key and upper(e.animal.id) like :id")
							.setParameter("key",farm.getKey())
							.setParameter("id",searchValue.toUpperCase());
				}
				else query=sessionFactory.getCurrentSession().createQuery("select count(e.eventKey) from Event e where e.action.farm.farmKey=:key")
						.setParameter("key",farm.getKey());;
			}
			else query=sessionFactory.getCurrentSession().createQuery("select count(e.eventKey) from Event e where e.action.farm.farmKey=:key")
				.setParameter("key",farm.getKey());
			
		return (Long)query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> getEvents(Farm farm, Integer searchBy, String searchValue, Integer page){
		Query query;
			if(searchBy!=null && searchValue!=null) {
				if(searchBy.equals(SearchType.ACTION.getKey())) {
					query=sessionFactory.getCurrentSession().createQuery("from Event e where e.action.farm.farmKey=:key and upper(e.action.name) like :action order by e.eventDate desc")
							.setParameter("key",farm.getKey())
							.setParameter("action",searchValue.toUpperCase());
				}
				else if(searchBy.equals(SearchType.NAME.getKey())) {
					query=sessionFactory.getCurrentSession().createQuery("from Event e where e.action.farm.farmKey=:key and upper(e.animal.name) like :name order by e.eventDate desc")
							.setParameter("key",farm.getKey())
							.setParameter("name",searchValue.toUpperCase());
				}
				else if(searchBy.equals(SearchType.ID.getKey())) {
					query=sessionFactory.getCurrentSession().createQuery("from Event e where e.action.farm.farmKey=:key and upper(e.animal.id) like :id order by e.eventDate desc")
							.setParameter("key",farm.getKey())
							.setParameter("id",searchValue.toUpperCase());
				}
				else query=sessionFactory.getCurrentSession().createQuery("from Event e where e.action.farm.farmKey=:key order by e.eventDate desc")
						.setParameter("key",farm.getKey());;
			}
			else query=sessionFactory.getCurrentSession().createQuery("from Event e where e.action.farm.farmKey=:key order by e.eventDate desc")
				.setParameter("key",farm.getKey());
			
		query.setMaxResults(Util.MAX_RESULTS);
		query.setFirstResult(page*Util.MAX_RESULTS);
		return query.list();
	}

}
