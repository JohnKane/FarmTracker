package com.farmtracker.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmtracker.model.Animal;
import com.farmtracker.model.Farm;
import com.farmtracker.uibeans.AnimalSearch.SearchType;
import com.farmtracker.util.Util;

@Repository
public class AnimalDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	public void createAnimal(Animal animal) {
		sessionFactory.getCurrentSession().saveOrUpdate(animal);
	}
	
	public void updateAnimal(Animal animal) {
		sessionFactory.getCurrentSession().update(animal);
	}
	
	public void deleteAnimal(Animal animal) {
		sessionFactory.getCurrentSession().delete(animal);
	}
	
	public Animal getAnimal(int key){
		return (Animal)sessionFactory.getCurrentSession().load(Animal.class,key);
	}
	
	@SuppressWarnings("unchecked")
	public List<Animal> getAnimals(Farm farm){
		return sessionFactory.getCurrentSession().createQuery("from Animal a where a.animalType.farm.farmKey=:key")
			.setParameter("key",farm.getKey())
				.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Animal> getAnimals(Farm farm, Integer searchBy, String searchValue, Integer page){
		Query query;
			if(searchBy!=null && searchValue!=null) {
				if(searchBy.equals(SearchType.ANIMAL_TYPE.getKey())) {
					query=sessionFactory.getCurrentSession().createQuery("from Animal a where a.animalType.farm.farmKey=:key and upper(a.animalType.name) like :type order by a.name asc, a.id asc")
							.setParameter("key",farm.getKey())
							.setParameter("type",searchValue.toUpperCase());
				}
				else if(searchBy.equals(SearchType.NAME.getKey())) {
					query=sessionFactory.getCurrentSession().createQuery("from Animal a where a.animalType.farm.farmKey=:key and upper(a.name) like :name order by a.name asc, a.id asc")
							.setParameter("key",farm.getKey())
							.setParameter("name",searchValue.toUpperCase());
				}
				else if(searchBy.equals(SearchType.ID.getKey())) {
					query=sessionFactory.getCurrentSession().createQuery("from Animal a where a.animalType.farm.farmKey=:key and upper(a.id) like :id order by a.name asc, a.id asc")
							.setParameter("key",farm.getKey())
							.setParameter("id",searchValue.toUpperCase());
				}
				else query=sessionFactory.getCurrentSession().createQuery("from Animal a where a.animalType.farm.farmKey=:key order by a.name asc, a.id asc")
						.setParameter("key",farm.getKey());
			}
			else query=sessionFactory.getCurrentSession().createQuery("from Animal a where a.animalType.farm.farmKey=:key order by a.name asc, a.id asc")
					.setParameter("key",farm.getKey());
			
		query.setMaxResults(Util.MAX_RESULTS);
		query.setFirstResult(page*Util.MAX_RESULTS);
		return query.list();
	}
	
	public Long getCountAnimals(Farm farm, Integer searchBy, String searchValue) {
		Query query;
			if(searchBy!=null && searchValue!=null) {
				if(searchBy.equals(SearchType.ANIMAL_TYPE.getKey())) {
					query=sessionFactory.getCurrentSession().createQuery("select count(a.animalKey) from Animal a where a.animalType.farm.farmKey=:key and upper(a.animalType.name) like :type")
							.setParameter("key",farm.getKey())
							.setParameter("type",searchValue.toUpperCase());
				}
				else if(searchBy.equals(SearchType.NAME.getKey())) {
					query=sessionFactory.getCurrentSession().createQuery("select count(a.animalKey) from Animal a where a.animalType.farm.farmKey=:key and upper(a.name) like :name")
							.setParameter("key",farm.getKey())
							.setParameter("name",searchValue.toUpperCase());
				}
				else if(searchBy.equals(SearchType.ID.getKey())) {
					query=sessionFactory.getCurrentSession().createQuery("select count(a.animalKey) from Animal a where a.animalType.farm.farmKey=:key and upper(a.id) like :id")
							.setParameter("key",farm.getKey())
							.setParameter("id",searchValue.toUpperCase());
				}
				else query=sessionFactory.getCurrentSession().createQuery("select count(a.animalKey) from Animal a where a.animalType.farm.farmKey=:key")
						.setParameter("key",farm.getKey());
			}
			else query=sessionFactory.getCurrentSession().createQuery("select count(a.animalKey) from Animal a where a.animalType.farm.farmKey=:key")
					.setParameter("key",farm.getKey());
		
		return (Long)query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Animal> getAnimals(List<Integer> keys){
		return sessionFactory.getCurrentSession().createQuery("from Animal a where a.animalKey in (:keys)")
			.setParameterList("keys",keys)
				.list();
	}
}
