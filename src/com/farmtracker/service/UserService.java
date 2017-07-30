package com.farmtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farmtracker.dao.UserDAO;
import com.farmtracker.model.User;

@Service
@Transactional
public class UserService {

	@Autowired
    private UserDAO userDAO;
	
	@Transactional
    public void addUser(User user) {
		userDAO.createUser(user);
    }
	
	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	
	@Transactional
	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}
	
	@Transactional
	public User getUser(Integer key) {
		return userDAO.getUser(key);
	}
	
	@Transactional
	public User getUser(String email, String password) {
		return userDAO.getUser(email,password);
	}
	
	@Transactional
	public List<User> getUsers(){
		return userDAO.getUsers();
	}
	
	public void setUserDAO(UserDAO userDAO) {
        this.userDAO=userDAO;
    }
}
