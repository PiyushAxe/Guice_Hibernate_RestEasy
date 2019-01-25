package com.axelor.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cname")
public class Cname {

	@Id
	@Column(name="Cid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	
	@Column(name="Cname")
	private String cname;
//	@ManyToOne
//	private User user = new User();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_mobile_mapping",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="mid"))
	private List<Mobile> mobile = new ArrayList<Mobile>();
	
	public int getCid() {
		return cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public String getCname() {
		return cname;
	}
	
	public void setCname(String cname) {
		this.cname = cname;
	}
	
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	
	public List<Mobile> getMobile() {
		return mobile;
	}
	
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}
	
	
}
