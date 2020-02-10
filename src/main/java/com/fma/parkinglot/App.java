package com.fma.parkinglot;

import java.util.Scanner;

import com.fma.parkinglot.constants.VehicleSize;
import com.fma.parkinglot.constants.VehicleType;
import com.fma.parkinglot.dal.ParkingLot;
import com.fma.parkinglot.pojos.Vehicle;
import com.fma.parkinglot.pojos.Vehicle.VehicleBuilder;
import com.fma.parkinglot.services.ParkingService;
import com.fma.parkinglot.services.ParkingServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
        ParkingService ps = new ParkingServiceImpl();
        
        ps.addSlots(4, VehicleType.Car);
        ps.addSlots(4, VehicleType.Bus);
           
        ps.allotSlotToVehicle(VehicleType.Car, new Vehicle.VehicleBuilder().setColor("Red")
        											.setRegistrationNumber("KA01-9999")
        											.setVehicleSize(VehicleSize.Small).build());
        
        ps.allotSlotToVehicle(VehicleType.Car, new Vehicle.VehicleBuilder().setColor("White")
				.setRegistrationNumber("KA01-3273")
				.setVehicleSize(VehicleSize.Small).build());
        
        ps.allotSlotToVehicle(VehicleType.Car, new Vehicle.VehicleBuilder().setColor("Yellow")
				.setRegistrationNumber("KA01-3272")
				.setVehicleSize(VehicleSize.Small).build());
        
        ps.allotSlotToVehicle(VehicleType.Car, new Vehicle.VehicleBuilder().setColor("Black")
				.setRegistrationNumber("KA01-3232")
				.setVehicleSize(VehicleSize.Small).build());
        
        ps.allotSlotToVehicle(VehicleType.Car, new Vehicle.VehicleBuilder().setColor("White")
				.setRegistrationNumber("KA01-3232")
				.setVehicleSize(VehicleSize.Small).build());
        
        ps.allotSlotToVehicle(VehicleType.Car, new Vehicle.VehicleBuilder().setColor("White")
				.setRegistrationNumber("KA01-3222")
				.setVehicleSize(VehicleSize.Small).build());
        
        ps.releaseSlot(3);
        
        System.out.println("\nAvailable Slots :: "+ParkingLot.availableSlots);
        System.out.println("\nAlloted Slots :: "+ParkingLot.allotedSlots);
        
        ps.allotSlotToVehicle(VehicleType.Car, new Vehicle.VehicleBuilder().setColor("White")
				.setRegistrationNumber("KA01-3532")
				.setVehicleSize(VehicleSize.Small).build());
        
        ps.allotSlotToVehicle(VehicleType.Car, new Vehicle.VehicleBuilder().setColor("White")
				.setRegistrationNumber("KA01-3622")
				.setVehicleSize(VehicleSize.Small).build());
        
        ps.parkingLotStatus();
    }
}
