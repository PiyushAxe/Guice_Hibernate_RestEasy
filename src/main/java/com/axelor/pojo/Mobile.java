package com.axelor.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Mobile")
public class Mobile {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mid;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Cname cname ;
	
	@Column(name="Mobile")
	private int mNumber;
	
	public int getmNumber() {
		return mNumber;
	}
	
	public void setmNumber(int mNumber) {
		this.mNumber = mNumber;
	}
	
	
	
	public int getMid() {
		return mid;
	}
	
	
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	
	public Cname getCname() {
		return cname;
	}
	
	public void setCname(Cname cname) {
		this.cname = cname;
	}


	
}
