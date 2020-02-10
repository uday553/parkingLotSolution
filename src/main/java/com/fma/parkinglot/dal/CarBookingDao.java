package com.fma.parkinglot.dal;

import java.util.List;

import com.fma.parkinglot.pojos.Car;
import com.fma.parkinglot.pojos.Slot;

public class CarBookingDao implements BookingOperations< Car, Slot> {

	public void add(List<Slot> s) {
		
	}

	public int allot(Car v) {
		
		return -1;
	}

	public void release(Slot s) {
		
	}

}
