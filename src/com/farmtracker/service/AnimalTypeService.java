package com.farmtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmtracker.dao.AnimalTypeDAO;
import com.farmtracker.model.AnimalType;
import com.farmtracker.model.Farm;

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
	public void updateAnimalType(AnimalType type) {
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
	public List<AnimalType> getAnimalTypes(Farm farm){
		return animalTypeDAO.getAnimalTypes(farm);
	}
	
	@Transactional
	public List<AnimalType> getAnimalTypes(Farm farm, String searchValue, Integer page){
		return animalTypeDAO.getAnimalTypes(farm,searchValue,page);
	}
	
	@Transactional
	public Long getCountAnimalTypes(Farm farm, String searchValue){
		return animalTypeDAO.getCountAnimalTypes(farm,searchValue);
	}
	
	public void setAnimalTypeDAO(AnimalTypeDAO animalTypeDAO) {
        this.animalTypeDAO=animalTypeDAO;
    }
}
