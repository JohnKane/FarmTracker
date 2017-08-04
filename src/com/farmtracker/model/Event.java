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
@Table(name="event")
public class Event {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="event_key")
    private Integer eventKey;
	
	@ManyToOne(optional=false,cascade={CascadeType.PERSIST,CascadeType.MERGE}) 
    @JoinColumn(name="action_key", referencedColumnName="action_key", nullable=false)
	private Action action;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE}) 
    @JoinColumn(name="animal_key", referencedColumnName="animal_key")
	private Animal animal;
	
	@Column(name="event_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;
	
	@Column
	private String notes;
	
	public Integer getKey() {return eventKey;}
	public Action getAction() {return action;}
	public Animal getAnimal() {return animal;}
	public Date getEventDate() {return eventDate;}
	public String getNotes() {return notes;}
	
	public void setKey(Integer key) {this.eventKey=key;}
	public void setAction(Action action) {this.action=action;}
	public void setAnimal(Animal animal) {this.animal=animal;}
	public void setEventDate(Date eventDate) {this.eventDate=eventDate;}
	public void setNotes(String notes) {this.notes=notes;}
}
