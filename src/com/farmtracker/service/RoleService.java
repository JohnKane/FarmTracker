package com.farmtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmtracker.dao.RoleDAO;
import com.farmtracker.model.Role;

@Service
@Transactional
public class RoleService {

	@Autowired
    private RoleDAO roleDAO;
	
	@Transactional
	public Role getRole(Integer key) {
		return roleDAO.getRole(key);
	}
	
	@Transactional
	public List<Role> getRoles(){
		return roleDAO.getRoles();
	}
	
	public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO=roleDAO;
    }
}
