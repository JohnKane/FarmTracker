package com.farmtracker.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmtracker.model.Animal;
import com.farmtracker.model.Farm;

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
	public List<Animal> getAnimals(List<Integer> keys){
		return sessionFactory.getCurrentSession().createQuery("from Animal a where a.key in :keys")
			.setParameter("keys",keys)
				.list();
	}
}
