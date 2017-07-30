package com.farmtracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_key")
    private Integer roleKey;
	
	@Column(nullable=false)
    private String name;
	
	public Integer getKey() {return roleKey;}
	public String getName(){return name;}
	
	public void setKey(Integer key) {this.roleKey=key;}
	public void setName(String name){this.name=name;}
}
