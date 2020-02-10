package com.fma.parkinglot.pojos;

import com.fma.parkinglot.constants.ParkingStatus;
import com.fma.parkinglot.constants.VehicleType;

public class Slot implements Comparable<Slot> {
	
	private int id;
	private int distanceFromEntrance;
	private ParkingStatus status;
	private Vehicle vehicle;
	private VehicleType vehicleType;

	public Slot()
	{
		
	}
	public Slot(int distanceFromEntrance,VehicleType vehicleType,int id)
	{
		this.distanceFromEntrance= distanceFromEntrance;
		this.vehicleType=vehicleType;
		this.id=id;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDistanceFromEntrance() {
		return distanceFromEntrance;
	}
	public void setDistanceFromEntrance(int distanceFromEntrance) {
		this.distanceFromEntrance = distanceFromEntrance;
	}
	public ParkingStatus getStatus() {
		return status;
	}
	public void setStatus(ParkingStatus status) {
		this.status = status;
	}


	@Override
	public boolean equals(Object obj)
	{ 
		if(this == obj)
			return true;
		if(obj == null || obj.getClass()!= this.getClass())
			return false;
		Slot slot = (Slot) obj;
		return (slot.id == this.id); 
	} 

	@Override
	public int hashCode() 
	{ 
		return id;
	}

	public int compareTo(Slot o) {
		if (distanceFromEntrance < o.distanceFromEntrance ) {
			return -1;
		}
		return distanceFromEntrance == o.distanceFromEntrance? 0 : 1;
	}

	@Override
	public String toString() {
		return "(slot id: " + id+", distanceFromEntrance: "+distanceFromEntrance +", status: "+status+", "+vehicleType+","+vehicle+")";
	}

}
