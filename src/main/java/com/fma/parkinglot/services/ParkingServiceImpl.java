package com.fma.parkinglot.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

import com.fma.parkinglot.constants.VehicleType;
import com.fma.parkinglot.dal.ParkingLot;
import com.fma.parkinglot.pojos.Slot;
import com.fma.parkinglot.pojos.Vehicle;

public class ParkingServiceImpl implements ParkingService{

	public synchronized void addSlots(int size, VehicleType type)
	{
		TreeSet<Slot> slots =  new TreeSet<Slot>();
		for(int i=1;i<=size;i++)
		{
			slots.add(new Slot(i+ParkingLot.totalSlots,type,(i+ParkingLot.totalSlots)));
		}
		System.out.println(slots);
		if(ParkingLot.availableSlots.containsKey(type)) 
			slots.addAll(ParkingLot.availableSlots.get(type));
		ParkingLot.availableSlots.put(type,slots);
		if(ParkingLot.totalSlots==0)
			System.out.println("Created parking lot with "+size+" size");
		else
			System.out.println("Added "+size+" more slots to parking lot");
		ParkingLot.totalSlots = ParkingLot.totalSlots+size;
	}

	public synchronized int allotSlotToVehicle(VehicleType type, Vehicle vehicle )
	{
		if(ParkingLot.availableSlots.size()>0 && ParkingLot.availableSlots.containsKey(type) && ParkingLot.availableSlots.get(type).size()>0) {
			Slot slot = ParkingLot.availableSlots.get(type).pollFirst();
			slot.setVehicle(vehicle);
			ParkingLot.allotedSlots.put(slot.getId(),slot);
			if(ParkingLot.allotedVehicleColor.containsKey(vehicle.getColor()))
				ParkingLot.allotedVehicleColor.get(vehicle.getColor()).add(slot.getId());
			else {
				HashSet<Integer> slots = new HashSet<Integer>();
				slots.add(slot.getId());
				ParkingLot.allotedVehicleColor.put(vehicle.getColor(),slots);
			}
			ParkingLot.allotedVehicleToSlotMap.put(vehicle.getRegistrationNumber(), slot.getId());
			System.out.println("Allocated slot number: "+slot.getId());	
			return slot.getId();
		}
		System.out.println("Sorry, parking lot is full");
		return -1;
	}

	public boolean releaseSlot(int slotId) 
	{
		if(ParkingLot.allotedSlots!=null && ParkingLot.allotedSlots.containsKey(slotId)) {
			Slot slot =  ParkingLot.allotedSlots.remove(slotId);
			ParkingLot.allotedVehicleColor.get(slot.getVehicle().getColor()).remove(slot.getId());
			ParkingLot.allotedVehicleToSlotMap.remove(slot.getVehicle().getRegistrationNumber());
			slot.setVehicle(null);
			ParkingLot.availableSlots.get(slot.getVehicleType()).add(slot);
			System.out.println("Slot number "+slotId+" is free");
			return true;
		}
		return false;
	}

	public void parkingLotStatus()
	{
		TreeMap<Integer,Slot> allotedSlots = ParkingLot.allotedSlots;
		Iterator<Integer> itr=allotedSlots.keySet().iterator();   
		System.out.println("Slot No\tRegistration No\tColor");
		while(itr.hasNext())    
		{    
			int key=(Integer)itr.next();
			System.out.println(allotedSlots.get(key).getId()+"\t"+allotedSlots.get(key).getVehicle().getRegistrationNumber()+"\t"+allotedSlots.get(key).getVehicle().getColor());  
		}    
	}

}