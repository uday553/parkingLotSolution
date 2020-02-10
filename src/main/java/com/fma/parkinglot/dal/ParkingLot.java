package com.fma.parkinglot.dal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import com.fma.parkinglot.constants.Color;
import com.fma.parkinglot.constants.VehicleType;
import com.fma.parkinglot.pojos.Slot;
import com.fma.parkinglot.pojos.Vehicle;

public class ParkingLot {
	public static Integer totalSlots=0;
	public static Map<VehicleType,TreeSet<Slot>> availableSlots=new HashMap<VehicleType,TreeSet<Slot>>();
	public static TreeMap<Integer,Slot> allotedSlots = new TreeMap<Integer,Slot>();
	public static Map<String,HashSet<Integer>> allotedVehicleColor = new HashMap<String,HashSet<Integer>>();
	public static Map<String,Integer> allotedVehicleToSlotMap= new HashMap<String,Integer>();
}
