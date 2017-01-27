package com.hackerproject.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="challange")
public class Challange {
	@Id
	@Column(name="challange_id")
	private int Challange_id;
	
	@Column(name="challange_desc")
	private String Challange_desc;
	
	public Challange(int challange_id, String challange_company , String  challange_desc, int challange_ctc,
			Date challange_date) {
		super();
		Challange_id = challange_id;
		Challange_desc = challange_desc;
		Challange_company = challange_company;
		Challange_ctc = challange_ctc;
		this.challange_date = challange_date;
	}
	@Column(name="challange_company")
	private String Challange_company;
	
	@Column(name="challange_ctc")
	private int Challange_ctc;
	
	@Column(name="challange_date")
	private Date challange_date;
	public int getChallange_id() {
		return Challange_id;
	}
	public void setChallange_id(int challange_id) {
		Challange_id = challange_id;
	}
	public String getChallange_desc() {
		return Challange_desc;
	}
	public void setChallange_desc(String challange_desc) {
		Challange_desc = challange_desc;
	}
	public String getChallange_company() {
		return Challange_company;
	}
	public void setChallange_company(String challange_company) {
		Challange_company = challange_company;
	}
	public int getChallange_ctc() {
		return Challange_ctc;
	}
	public void setChallange_ctc(int challange_ctc) {
		Challange_ctc = challange_ctc;
	}
	public Date getChallange_date() {
		return challange_date;
	}
	public void setChallange_date(Date challange_date) {
		this.challange_date = challange_date;
	}
	public Challange()
	{
		
	}

}
