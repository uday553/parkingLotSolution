package com.fma.parkinglot.exceptions;


public class VehicleNotFoundException extends Exception {
	public VehicleNotFoundException(String message, Throwable t) {
		super(message, t);
	}
}
