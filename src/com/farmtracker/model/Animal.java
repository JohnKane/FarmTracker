package com.farmtracker.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="animal")
public class Animal {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="animal_key")
    private Integer animalKey;
	
	@ManyToOne(optional=false,cascade={CascadeType.PERSIST,CascadeType.MERGE}) 
    @JoinColumn(name="animal_type_key", referencedColumnName="animal_type_key", nullable=false)
	private AnimalType animalType;
	
	@Column
    private String name;
	
	@Column
    private String id;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deathdate;
	
	@Column
	private String notes;
	
	@ManyToMany
	@JoinTable(
		name="child",
	    joinColumns=@JoinColumn(name="parent_key", referencedColumnName="animal_key"),
	    inverseJoinColumns=@JoinColumn(name="child_key", referencedColumnName="animal_key")
    )
	private List<Animal> children;
	
	@Transient
	private List<Integer> childKeys=new ArrayList<Integer>();
	
	public Integer getKey() {return animalKey;}
	public AnimalType getAnimalType() {return animalType;}
	public String getName() {return name;}
	public String getId() {return id;}
	public Date getBirthdate() {return birthdate;}
	public Date getDeathdate() {return deathdate;}
	public String getNotes() {return notes;}
	public List<Animal> getChildren(){return children;}
	public List<Integer> getChildKeys(){
		List<Integer> keys=new ArrayList<Integer>();
			if(children!=null)
				for(Animal child:children)
					keys.add(child.getKey());
			
		return keys;
	}
	public List<Integer> getPopulatedChildKeys(){return childKeys;}
	
	public void setKey(Integer key) {this.animalKey=key;}
	public void setAnimalType(AnimalType animalType) {this.animalType=animalType;}
	public void setName(String name) {this.name=name;}
	public void setId(String id) {this.id=id;}
	public void setBirthdate(Date birthdate) {this.birthdate=birthdate;}
	public void setDeathdate(Date deathdate) {this.deathdate=deathdate;}
	public void setNotes(String notes) {this.notes=notes;}
	public void setChildren(List<Animal> children) {this.children=children;}
	public void setChildKeys(List<Integer> keys) {
		this.childKeys=keys;
	}
	
}
