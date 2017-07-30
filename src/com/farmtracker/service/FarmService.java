package com.farmtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmtracker.dao.FarmDAO;
import com.farmtracker.model.Farm;

@Service
@Transactional
public class FarmService {

	@Autowired
    private FarmDAO farmDAO;
	
	@Transactional
    public void addFarm(Farm farm) {
        farmDAO.createFarm(farm);
    }
	
	@Transactional
	public void updateFarm(Farm farm) {
		farmDAO.updateFarm(farm);
	}
	
	@Transactional
	public void deleteFarm(Farm farm) {
		farmDAO.deleteFarm(farm);
	}
	
	@Transactional
	public Farm getFarm(Integer key) {
		return farmDAO.getFarm(key);
	}
	
	@Transactional
	public List<Farm> getFarms(){
		return farmDAO.getFarms();
	}
	
	public void setFarmDAO(FarmDAO farmDAO) {
        this.farmDAO=farmDAO;
    }
}
