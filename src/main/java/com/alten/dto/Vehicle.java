package com.alten.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="VEHICLE")
public class Vehicle{
	public Vehicle() {
		super();
	}
	
	@Id
	@Column(name="Vehicle_ID")
	private String vehicleID;
	@Column(name="Customer_ID")
	private int customerID;
	@Column(name="reg_nr")
	private String reg_nr;
	@Column(name="status")
	private String vehicleStatus;
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerName(int customerID) {
		this.customerID = customerID;
	}
	
	public String getReg_nr() {
		return reg_nr;
	}
	public void setReg_nr(String reg_nr) {
		this.reg_nr = reg_nr;
	}
	public String getVehicleStatus() {
		return vehicleStatus;
	}
	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	public Vehicle(String vehicleID,int customerID, String reg_nr, String vehicleStatus) {
		this.vehicleID=vehicleID;
		this.customerID=customerID;
		this.reg_nr=reg_nr;
		this.vehicleStatus=vehicleStatus;
	}
}