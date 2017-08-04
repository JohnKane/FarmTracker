package com.farmtracker.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="action")
public class Action {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="action_key")
    private Integer actionKey;
	
	@ManyToOne(optional=false,cascade={CascadeType.PERSIST,CascadeType.MERGE}) 
    @JoinColumn(name="farm_key", referencedColumnName="farm_key", nullable=false)
	private Farm farm;
	
	@Column(nullable=false)
    private String name;
	
	@Column
	private String description;
	
	public Integer getKey() {return actionKey;}
	public Farm getFarm() {return farm;}
	public String getName() {return name;}
	public String getDescription() {return description;}
	
	public void setKey(Integer key) {this.actionKey=key;}
	public void setFarm(Farm farm) {this.farm=farm;}
	public void setName(String name) {this.name=name;}
	public void setDescription(String description) {this.description=description;}
}
