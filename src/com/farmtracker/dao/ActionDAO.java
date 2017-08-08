package com.farmtracker.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmtracker.model.Action;
import com.farmtracker.model.Farm;
import com.farmtracker.util.Util;

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
	
	@SuppressWarnings("unchecked")
	public List<Action> getActions(Farm farm,String searchValue,Integer page){
		Query query;
			if(searchValue!=null) {
				query=sessionFactory.getCurrentSession().createQuery("from Action a where a.farm.farmKey=:key and upper(a.name) like :name order by a.name asc")
						.setParameter("key",farm.getKey())
						.setParameter("name",searchValue.toUpperCase());
			}
			else query=sessionFactory.getCurrentSession().createQuery("from Action a where a.farm.farmKey=:key order by a.name asc")
					.setParameter("key",farm.getKey());
		
		
		query.setMaxResults(Util.MAX_RESULTS);
		query.setFirstResult(page*Util.MAX_RESULTS);
		return query.list();
	}
	
	public long getCountActions(Farm farm,String searchValue){
		Query query;
			if(searchValue!=null) {
				query=sessionFactory.getCurrentSession().createQuery("select count(a.actionKey) from Action a where a.farm.farmKey=:key and upper(a.name) like :name")
						.setParameter("key",farm.getKey())
						.setParameter("name",searchValue.toUpperCase());
			}
			else query=sessionFactory.getCurrentSession().createQuery("select count(a.actionKey) from Action a where a.farm.farmKey=:key")
					.setParameter("key",farm.getKey());

		return (Long)query.uniqueResult();
	}
}
