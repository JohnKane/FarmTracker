package com.farmtracker.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmtracker.model.Farm;

@Repository
public class FarmDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	public void createFarm(Farm farm) {
		sessionFactory.getCurrentSession().saveOrUpdate(farm);
	}
	
	public void updateFarm(Farm farm) {
		sessionFactory.getCurrentSession().update(farm);
	}
	
	public void deleteFarm(Farm farm) {
		sessionFactory.getCurrentSession().delete(farm);
	}
	
	public Farm getFarm(int key){
		return (Farm)sessionFactory.getCurrentSession().load(Farm.class,key);
	}
	
	@SuppressWarnings("unchecked")
	public List<Farm> getFarms(){
		return sessionFactory.getCurrentSession().createQuery("from Farm").list();
	}

}
