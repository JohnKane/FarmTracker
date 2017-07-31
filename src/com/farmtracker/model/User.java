package com.farmtracker.model;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_key")
    private Integer userKey;
	
	@Column(nullable=false)
    private String email;
	
	@Column(nullable=false)
    private String password;
	
	@Column(name="date_created")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreated;
	
	@ManyToOne(optional=false,cascade={CascadeType.PERSIST,CascadeType.MERGE}) 
    @JoinColumn(name="farm_key", referencedColumnName="farm_key", nullable=false)
	private Farm farm;
	
	@ManyToOne(optional=false,cascade={CascadeType.PERSIST,CascadeType.MERGE}) 
    @JoinColumn(name="role_key", referencedColumnName="role_key", nullable=false)
	private Role role;
	
	public Integer getKey() {return userKey;}
	public String getEmail() {return email;}
	public String getPassword() {return password;}
	public Date getDateCreated() {return dateCreated;}
	public Farm getFarm() {return farm;}
	public Role getRole() {return role;}
	
	public void setKey(Integer key) {this.userKey=key;}
	public void setEmail(String email) {this.email=email;}
	public void setPassword(String password) {this.password=password;}
	public void setDateCreated(Date dateCreated) {this.dateCreated=dateCreated;}
	public void setFarm(Farm farm) {this.farm=farm;}
	public void setRole(Role role) {this.role=role;}
	
}
