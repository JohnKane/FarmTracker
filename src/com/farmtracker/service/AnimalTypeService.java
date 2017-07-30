package com.farmtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmtracker.dao.AnimalTypeDAO;
import com.farmtracker.model.AnimalType;

@Service
@Transactional
public class AnimalTypeService {
	
	@Autowired
    private AnimalTypeDAO animalTypeDAO;
	
	@Transactional
    public void addAnimalType(AnimalType type) {
		animalTypeDAO.createAnimalType(type);
    }
	
	@Transactional
	public void updateFarm(AnimalType type) {
		animalTypeDAO.updateAnimalType(type);
	}
	
	@Transactional
	public void deleteAnimalType(AnimalType type) {
		animalTypeDAO.deleteAnimalType(type);
	}
	
	@Transactional
	public AnimalType getAnimalType(Integer key) {
		return animalTypeDAO.getAnimalType(key);
	}
	
	@Transactional
	public List<AnimalType> getAnimalTypes(){
		return animalTypeDAO.getAnimalTypes();
	}
	
	public void setAnimalTypeDAO(AnimalTypeDAO animalTypeDAO) {
        this.animalTypeDAO=animalTypeDAO;
    }
}
