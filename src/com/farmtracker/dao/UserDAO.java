package com.farmtracker.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmtracker.model.User;

@Repository
public class UserDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	public void createUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}
	
	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}
	
	public User getUser(int key){
		return (User)sessionFactory.getCurrentSession().load(User.class,key);
	}
	
	@SuppressWarnings("unchecked")
	public User getUser(String email, String password) {
		Query query=sessionFactory.getCurrentSession().createQuery("From User u where u.email=:email and u.password=:password")
			.setParameter("email",email)
			.setParameter("password",password);
		List<User> users=query.list();
		return users!=null && users.size()>0 ? users.get(0) : null;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsers(){
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}
	
}
