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
@Table(name="animal_type")
public class AnimalType {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="animal_type_key")
    private Integer animalTypeKey;
	
	@ManyToOne(optional=false,cascade={CascadeType.PERSIST,CascadeType.MERGE}) 
    @JoinColumn(name="farm_key", referencedColumnName="farm_key", nullable=false)
	private Farm farm;
	
	@Column(nullable=false)
    private String name;
	
	public Integer getKey() {return animalTypeKey;}
	public Farm getFarm() {return farm;}
	public String getName() {return name;}
	
	public void setKey(Integer key) {this.animalTypeKey=key;}
	public void setFarm(Farm farm) {this.farm=farm;}
	public void setName(String name) {this.name=name;}
	
}
