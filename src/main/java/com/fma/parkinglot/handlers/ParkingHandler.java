package com.fma.parkinglot.handlers;

import com.fma.parkinglot.constants.VehicleType;
import com.fma.parkinglot.pojos.Vehicle;
import com.fma.parkinglot.services.ParkingServiceImpl;

public class ParkingHandler<T> {
	ParkingServiceImpl parkingService = new ParkingServiceImpl(); 
	
	public void addSlots(int size,VehicleType type)
	{
		parkingService.addSlots(size, type);
	}
	public int allotSlotToVehicle(VehicleType type, Vehicle vehicle )
	{
		return parkingService.allotSlotToVehicle(type, vehicle);
	}
	public boolean releaseSlot(int slotId) 
	{
		return parkingService.releaseSlot(slotId);
	}
	public void parkingLotStatus()
	{
		parkingService.parkingLotStatus();
	}
	
	
}