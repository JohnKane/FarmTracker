package com.farmtracker.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmtracker.model.AnimalType;
import com.farmtracker.model.Farm;
import com.farmtracker.util.Util;

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
	
	@SuppressWarnings("unchecked")
	public List<AnimalType> getAnimalTypes(Farm farm, String searchValue, Integer page){
		Query query;
			if(searchValue!=null) {
				query=sessionFactory.getCurrentSession().createQuery("from AnimalType at where at.farm.farmKey=:key and upper(at.name) like :name order by at.name asc")
						.setParameter("key",farm.getKey())
						.setParameter("name",searchValue.toUpperCase());
			}
			else query=sessionFactory.getCurrentSession().createQuery("from AnimalType at where at.farm.farmKey=:key order by at.name asc")
					.setParameter("key",farm.getKey());
		
		
		query.setMaxResults(Util.MAX_RESULTS);
		query.setFirstResult(page*Util.MAX_RESULTS);
		return query.list();
	}
	
	public Long getCountAnimalTypes(Farm farm, String searchValue){
		Query query;
			if(searchValue!=null) {
				query=sessionFactory.getCurrentSession().createQuery("select count(at.animalTypeKey) from AnimalType at where at.farm.farmKey=:key and upper(at.name) like :name")
						.setParameter("key",farm.getKey())
						.setParameter("name",searchValue.toUpperCase());
			}
			else query=sessionFactory.getCurrentSession().createQuery("select count(at.animalTypeKey) from AnimalType at where at.farm.farmKey=:key")
					.setParameter("key",farm.getKey());
		
		
		return (Long)query.uniqueResult();
	}
}
