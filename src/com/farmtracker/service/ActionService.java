package com.farmtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmtracker.dao.ActionDAO;
import com.farmtracker.model.Action;
import com.farmtracker.model.Farm;

@Service
@Transactional
public class ActionService {

	@Autowired
    private ActionDAO actionDAO;
	
	@Transactional
    public void addAction(Action action) {
		actionDAO.createAction(action);
    }
	
	@Transactional
	public void updateAction(Action action) {
		actionDAO.updateAction(action);
	}
	
	@Transactional
	public void deleteAction(Action action) {
		actionDAO.deleteAction(action);
	}
	
	@Transactional
	public Action getAction(Integer key) {
		return actionDAO.getAction(key);
	}
	
	@Transactional
	public List<Action> getActions(Farm farm){
		return actionDAO.getActions(farm);
	}
	
	public void setActionDAO(ActionDAO actionDAO) {
        this.actionDAO=actionDAO;
    }
}
