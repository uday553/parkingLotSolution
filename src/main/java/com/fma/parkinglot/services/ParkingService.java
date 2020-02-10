package com.fma.parkinglot.services;

import com.fma.parkinglot.constants.VehicleType;
import com.fma.parkinglot.pojos.Vehicle;

public interface ParkingService {
	public void addSlots(int size,VehicleType type);
	public int allotSlotToVehicle(VehicleType type, Vehicle vehicle );
	public boolean releaseSlot(int slotId) ;
	public void parkingLotStatus();
}
