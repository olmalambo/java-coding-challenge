package com.mooveit.cars.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "model")
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private  String name;
	@Column(name = "frommodel")
	private String from;
	@Column(name = "tomodel")
	private String to;
	@Column(name = "type")
	private String type;
	
	@OneToOne
    @JoinColumn(name = "idwheel")
    private Wheels wheels;
	@OneToOne
    @JoinColumn(name = "idengine")
	private Engines engines;
	@OneToMany(mappedBy="parentmodel",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Model> subModels;
	@ManyToOne
	 @JoinColumn(name="parentmodel")
	private Model parentmodel;
	
	public Set<Model> getSubModels() {
		return subModels;
	}
	
	public Model getParentModel() {
		return parentmodel;
	}
	public void setParentModel(Model parentmodel) {
		this.parentmodel = parentmodel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Wheels getWheels() {
		return wheels;
	}
	public void setWheels(Wheels wheels) {
		this.wheels = wheels;
	}
	public Engines getEngines() {
		return engines;
	}
	public void setEngines(Engines engines) {
		this.engines = engines;
	}
	
	
	
	
	

}
