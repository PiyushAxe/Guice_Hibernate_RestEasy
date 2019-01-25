package com.axelor.pojo;

import java.util.ArrayList;
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
@Table(name="UserLogin")
public class User {
	
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="Name")
	private	String name;
	
	@Column(name="Password")
	private int password;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Cname> cname = new ArrayList<Cname>();
	
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
	
	public int getPassword() {
		return password;
	}
	
	public void setPassword(int password) {
		this.password = password;
	}
	
	public List<Cname> getCname() {
		return cname;
	}
	public void setCname(List<Cname> cname) {
		this.cname = cname;
	}
	
	
}
