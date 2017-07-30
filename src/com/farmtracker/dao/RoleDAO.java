package com.farmtracker.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmtracker.model.Role;

@Repository
public class RoleDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	public Role getRole(int key){
		return (Role)sessionFactory.getCurrentSession().load(Role.class,key);
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> getRoles(){
		return sessionFactory.getCurrentSession().createQuery("from Role").list();
	}
}
