//Name: Yu Yin, Cheong
//UNF N number: N 01576808
//Date of submission: Apr 27, 2025

import java.io.*;
import java.util.*;

public class FileHandler {
	
	/**
	 * Load vehicle data from the given file.
	 *
	 * @param String the file name
	 * @return the array list
	 */
	public static ArrayList<Vehicle> loadVehicleData(String fileName) {
		ArrayList<Vehicle> v = new ArrayList<Vehicle>();
		
		File file = new File(fileName);
		
		try {
			/* create Scanner to read from file
			 * read the header */
			Scanner in = new Scanner(file);
			String header = in.nextLine();
			
			//while there has next line in the file
			while (in.hasNextLine()) {
				//read the line and split by ","
				String line = in.nextLine();
				String[] data = line.split(",");
				
				//set each variables with the corresponding data obtained
				String description = data[0];
				int seats = Integer.valueOf(data[1]);
				boolean isLuxury = Boolean.valueOf(data[2]);
				
				//use the data and add it to the ArrayList
				v.add(new Vehicle(seats, isLuxury, description));
			}
		in.close();
		} catch (FileNotFoundException e) {
			//print if the file cannot be created or opened
			System.out.println("File not found.");
		}
		
		return v;	
	}
	
	/**
	 * Load driver data from the given file.
	 *
	 * @param String the file name
	 * @return the queue
	 */
	public static Queue<Driver> loadDriverData(String fileName) {
		Queue<Driver> d = new LinkedList<Driver>();
		
		File file = new File(fileName);
		
		try {
			/* create Scanner to read from file
			 * read the header */
			Scanner in = new Scanner(file);
			String header = in.nextLine();
			
			//while there has next line in the file
			while (in.hasNextLine()) {
				//read the line and split by ","
				String line = in.nextLine();
				String[] data = line.split(",");
				
				//set each variables with the corresponding data obtained
				String name = data[0];
				String email = data[1];
				int age = Integer.valueOf(data[2]);
				String license = data[3];
				
				//use the data and add it to the Queue
				d.add(new Driver(name, email, age, license));
			}
		in.close();
		} catch (FileNotFoundException e) {
			//print if the file cannot be created or opened
			System.out.println("File not found.");
		}

		return d;
	}
	
	/**
	 * Load customer data from the given file.
	 *
	 * @param String the file name
	 * @return the queue
	 */
	public static Queue<Customer> loadCustomerData(String fileName) {
		Queue<Customer> c = new LinkedList<Customer>();
		
		File file = new File(fileName);
		
		try {
			/* create Scanner to read from file
			 * read the header */
			Scanner in = new Scanner(file);
			String header = in.nextLine();
			
			//while there has next line in the file
			while (in.hasNextLine()) {
				//read the line and split by ","
				String line = in.nextLine();
				String[] data = line.split(",");
				
				//set each variables with the corresponding data obtained
				String name = data[0];
				String email = data[1];
				int age = Integer.valueOf(data[2]);
				int partySize = Integer.valueOf(data[3]);
				int points = Integer.valueOf(data[4]);
				
				if(points == -1)
					c.add(new Customer(name, email, age, partySize));
				else
					c.add(new VIPCustomer(name, email, age, partySize, points));
			}
		in.close();
		} catch (FileNotFoundException e) {
			//print if the file cannot be created or opened
			System.out.println("File not found.");
		}

		return c;
	}
	
	/**
	 * Write schedule to file.
	 *
	 * @param String the file name
	 * @param ArrayList the schedule
	 */
	public static void writeScheduleToFile(String fileName, ArrayList<ScheduledTransportation> schedule) {
		try {
			//create PrintWriter to write data in the specific file
			PrintWriter pw = new PrintWriter(fileName);
			
			//write the header of the file
			pw.println("CustomerName,CustomerAge,CustomerEmail,CustomerPartySize,CustomerPoints,DriverName,DriverAge,DriverEmail,DriverLicense,VehicleDescription,VehicleSeats,VehicleIsLuxury");
			
			//write the data that are provided
			for(ScheduledTransportation s: schedule) {
				pw.println(s.toCSV());
			}
			
			//save, flush, and close the PrintWriter
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			//print if the file cannot be created or opened
			System.out.println("File not found.");
		} 
	}
}
