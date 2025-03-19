package com.springrest.app.entity;

//entity class
public class PinCode {
	
	private String pinCode;
	private String city;
	private String state;
	
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "PinCode [pinCode=" + pinCode + ", city=" + city + ", state=" + state + "]";
	}
	
	
	

}
