package com.fma.parkinglot.pojos;

import com.fma.parkinglot.constants.VehicleSize;

public class Vehicle {

	protected String registrationNumber;
	protected String color;
	protected VehicleSize size;

	public Vehicle()
	{
		
	}
	private Vehicle(VehicleBuilder builder) {
		this.registrationNumber=builder.registrationNumber;
		this.color=builder.color;
		this.size=builder.size;
	}
	public Vehicle(String registrationNumber, String color, VehicleSize size) {
		this.registrationNumber=registrationNumber;
		this.color=color;
		this.size=size;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public VehicleSize getSize() {
		return size;
	}
	public void setSize(VehicleSize size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	@Override
	public String toString() {
		return "(registrationNumber: " + registrationNumber+", color: "+color +", size: "+size+")";
	}
	
	public static class VehicleBuilder
	{
		protected String registrationNumber;
		protected String color;
		protected VehicleSize size;

		
		public VehicleBuilder() {
		}
		public VehicleBuilder setRegistrationNumber(String registrationNumber) {
			this.registrationNumber=registrationNumber;
			return this;
		}
		public VehicleBuilder setColor(String color) {
			this.color=color;
			return this;
		}
		public VehicleBuilder setVehicleSize(VehicleSize size) {
			this.size=size;
			return this;
		}
		
		public Vehicle build(){
			return new Vehicle(this);
		}
	}
}

	

