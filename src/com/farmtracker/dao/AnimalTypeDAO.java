package com.farmtracker.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmtracker.model.AnimalType;
import com.farmtracker.model.Farm;

@Repository
public class AnimalTypeDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	public void createAnimalType(AnimalType type) {
		sessionFactory.getCurrentSession().saveOrUpdate(type);
	}
	
	public void updateAnimalType(AnimalType type) {
		sessionFactory.getCurrentSession().update(type);
	}
	
	public void deleteAnimalType(AnimalType type) {
		sessionFactory.getCurrentSession().delete(type);
	}
	
	public AnimalType getAnimalType(int key){
		return (AnimalType)sessionFactory.getCurrentSession().load(AnimalType.class,key);
	}
	
	@SuppressWarnings("unchecked")
	public List<AnimalType> getAnimalTypes(Farm farm){
		return sessionFactory.getCurrentSession().createQuery("from AnimalType at where at.farm.farmKey=:key")
			.setParameter("key",farm.getKey())
				.list();
	}
}
