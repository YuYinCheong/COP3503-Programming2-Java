//Name: Yu Yin, Cheong
//UNF N number: N 01576808
//Date of submission: Apr 27, 2025

import java.util.*;

public class Main {
	
	//constants 
	public static final String VEHICLE_FILE_NAME = "Vehicles.csv";
	public static final String CUSTOMER_FILE_NAME = "Customers.csv";
	public static final String DRIVER_FILE_NAME = "Drivers.csv";
	public static final String LOG_FILE_NAME = "Schedule.csv";

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		ArrayList<Vehicle> vehicles = FileHandler.loadVehicleData(VEHICLE_FILE_NAME);
		Queue<Customer> customers = FileHandler.loadCustomerData(CUSTOMER_FILE_NAME);
		Queue<Driver> drivers = FileHandler.loadDriverData(DRIVER_FILE_NAME);
		
		ArrayList<ScheduledTransportation> s = scheduleAllRides(customers, vehicles, drivers);
		
		FileHandler.writeScheduleToFile(LOG_FILE_NAME, s);
	}
	
	/**
	 * Schedule all rides.
	 *
	 * @param Queue<Customer> the customers
	 * @param ArrayList<Vehicle> the vehicles
	 * @param Queue<Driver> the drivers
	 * @return the array list
	 */
	public static ArrayList<ScheduledTransportation> scheduleAllRides(Queue<Customer> customers, ArrayList<Vehicle> vehicles, Queue<Driver> drivers) {
		
		ArrayList<ScheduledTransportation> s = new ArrayList<ScheduledTransportation>();
		
		//while there are still customers to be scheduled
		while (!customers.isEmpty()) {
			//remove customer from queue
			Customer c = customers.remove();
			
			/* assign a driver to the customer
			 * add the driver back to the end */
			Driver d = drivers.remove();
			drivers.add(d);
			
			ArrayList<Vehicle> vehicle = new ArrayList<Vehicle>();
			
			//check if the vehicles have enough seats
			for (Vehicle v: vehicles) {
				if (v.getSeats() >= c.getPartySize())
					vehicle.add(v);
			}
			
			Vehicle chosenVehicle = null;
			int minSeats = 100;
			
			//choose most appropriate vehicle based on customer type and vehicle type
			for (Vehicle v: vehicle) {
				if ((c instanceof VIPCustomer && v.isLuxury()) || !(c instanceof VIPCustomer && v.isLuxury())) {
					
					//choose vehicle with fewest seats that still fits the party 
					if (v.getSeats() < minSeats) {
						chosenVehicle = v;
						minSeats = v.getSeats();
					}
				}
			}
			
			//schedule transportation with the chosen customer, vehicle, and driver
			s.add(new ScheduledTransportation(c, chosenVehicle, d));
			
			//remove used vehicle from list
			vehicles.remove(chosenVehicle);
		}
		
		return s;
	}
}
