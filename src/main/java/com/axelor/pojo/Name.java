package com.axelor.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Name {
	
	@Id
	@GeneratedValue
	int id;
	
	String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<MobileNum> number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MobileNum> getNumber() {
		return number;
	}

	public void setNumber(List<MobileNum> number) {
		this.number = number;
	}

	
	
	

}