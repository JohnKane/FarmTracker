package com.farmtracker.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmtracker.model.Action;
import com.farmtracker.model.Farm;

@Repository
public class ActionDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	public void createAction(Action action) {
		sessionFactory.getCurrentSession().saveOrUpdate(action);
	}
	
	public void updateAction(Action action) {
		sessionFactory.getCurrentSession().update(action);
	}
	
	public void deleteAction(Action action) {
		sessionFactory.getCurrentSession().delete(action);
	}
	
	public Action getAction(int key){
		return (Action)sessionFactory.getCurrentSession().load(Action.class,key);
	}
	
	@SuppressWarnings("unchecked")
	public List<Action> getActions(Farm farm){
		return sessionFactory.getCurrentSession().createQuery("from Action a where a.farm.farmKey=:key")
			.setParameter("key",farm.getKey())
				.list();
	}
}
