package com.alten.dto;

public class VehicleDetailDTO{
	
	private String vehicleID;
	private String customerName;
	private String customerAddress;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	private String reg_nr;
	private String vehicleStatus;
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
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
	public void setVehicle_status(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	
	
	
}