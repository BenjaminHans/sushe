package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin {

    private int Admin_ID ;
    private String Admin_Username ;
    private String Admin_Password ;
    private String Admin_Name ;
    private String Admin_Sex ;
    private String Admin_Tel ;
    
    @Id
    @GeneratedValue
	public int getAdmin_ID() {
		return Admin_ID;
	}
	public void setAdmin_ID(int adminID) {
		Admin_ID = adminID;
	}
	public String getAdmin_Username() {
		return Admin_Username;
	}
	public void setAdmin_Username(String adminUsername) {
		Admin_Username = adminUsername;
	}
	public String getAdmin_Password() {
		return Admin_Password;
	}
	public void setAdmin_Password(String adminPassword) {
		Admin_Password = adminPassword;
	}
	public String getAdmin_Name() {
		return Admin_Name;
	}
	public void setAdmin_Name(String adminName) {
		Admin_Name = adminName;
	}
	public String getAdmin_Sex() {
		return Admin_Sex;
	}
	public void setAdmin_Sex(String adminSex) {
		Admin_Sex = adminSex;
	}
	public String getAdmin_Tel() {
		return Admin_Tel;
	}
	public void setAdmin_Tel(String adminTel) {
		Admin_Tel = adminTel;
	}
    
	
}
