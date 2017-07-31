package com.farmtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmtracker.dao.AnimalDAO;
import com.farmtracker.model.Animal;
import com.farmtracker.model.Farm;

@Service
@Transactional
public class AnimalService {

	@Autowired
    private AnimalDAO animalDAO;
	
	@Transactional
    public void addAnimal(Animal animal) {
		animalDAO.createAnimal(animal);
    }
	
	@Transactional
	public void updateAnimal(Animal animal) {
		animalDAO.updateAnimal(animal);
	}
	
	@Transactional
	public void deleteAnimal(Animal animal) {
		animalDAO.deleteAnimal(animal);
	}
	
	@Transactional
	public Animal getAnimal(Integer key) {
		return animalDAO.getAnimal(key);
	}
	
	@Transactional
	public List<Animal> getAnimals(Farm farm){
		return animalDAO.getAnimals(farm);
	}
	
	@Transactional
	public List<Animal> getAnimals(List<Integer> keys){
		return animalDAO.getAnimals(keys);
	}
	
	public void setAnimalDAO(AnimalDAO animalDAO) {
        this.animalDAO=animalDAO;
    }
}
