package com.farmtracker.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="farm")
public class Farm{

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="farm_key")
    private Integer farmKey;
	
	@Column(nullable=false)
    private String name;
	
	@OneToMany(mappedBy="farm",orphanRemoval=true,cascade=CascadeType.REMOVE)
	private List<User> users;
	
	public Integer getKey() {return farmKey;}
	public String getName(){return name;}
	public List<User> getUsers(){return users;}
	
	public void setKey(Integer key) {this.farmKey=key;}
	public void setName(String name){this.name=name;}
	public void setUsers(List<User> users){this.users=users;}
}
