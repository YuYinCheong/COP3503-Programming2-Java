//Name: Yu Yin, Cheong
//UNF N number: N 01576808
//Date of submission: Mar 24, 2025

import java.io.*;
import java.util.*;

public class Cheong_Project2 {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		//initialize an ArrayList with the Constructor
		ArrayList<Catch> catchList = new ArrayList<Catch>();
		
		//set up the ArrayList with data provided
		catchList = dataFile(scn);

		while (true) {
			//print the menu and let the user choose the function
			printMenu();
			
			//scan the user choice 
			int menuChoice = scn.nextInt();
			
			/*based on user choice, provide the corresponding functionality
			 * if choose 1, record the data to the Constructor and add to the ArrayList
			 * if choose 2, print out the best catches, which is the heavies fish for each species
			 * if choose 3, print out all of the data to the screen
			 * if choose 4, print the data to a file and quit from the while loop*/
			if (menuChoice == 1) {
				Catch newCatch = recordNewCatch(scn);
				catchList.add(newCatch);
			}
			else if (menuChoice == 2) {
				heaviest(catchList);
			}
			else if (menuChoice == 3) {
				printAllData(catchList);
			}
			else if (menuChoice == 4) {
				printToFile(scn, catchList);
				break;
			}
		}
	}
	
	
	
	
	
	/**
	 * Read data from file.
	 *
	 * @param Scanner the scn to read input from the user
	 * @return ArrayList the catchList
	 */
	public static ArrayList<Catch> dataFile(Scanner scn){
		
		//initialize an ArrayList with the Constructor
		ArrayList<Catch> catchList = new ArrayList<Catch>();
		
		while (true) {
			//ask the user for their file name, scan, and create file 
			System.out.println("What is the name of the data file?");
			String filename = scn.next();
			File file = new File(filename);
			
			try {
				//create Scanner to read from file
				Scanner in = new Scanner(file);
				
				//read the header
				String header = in.nextLine();
				
				//while there has next line in the file
				while(in.hasNextLine()) {
					
					//read the line and split by ","
					String line = in.nextLine();
					String[] data = line.split(",");
					
					//set each variables with the corresponding data obtained
					String license = data[0];
					String name = data[1];
					float weight = Float.valueOf(data[2]);
					int length = Integer.valueOf(data[3]);
					int catchYear = Integer.valueOf(data[4]);
					int catchMonth = Integer.valueOf(data[5]);
					int catchDay = Integer.valueOf(data[6]);
					
					//use the data and add it to the ArrayList with a Catch
					catchList.add(new Catch(license, name, weight, length, catchDay, catchMonth, catchYear));
				}
				break;
				
			} catch (FileNotFoundException e) {
				/*if the file is not found
				 * print the statement and scan for user choice
				 * if choice is "Y" then quit the loop */
				System.out.println("File not found. Start new file? (Y/N)");
				String choice = scn.next();
				if (choice.equalsIgnoreCase("Y")) {
					break;
				}
			}
		}
		
		//return the ArrayList, if no file is found, the ArrayList will be empty 
		return catchList;
	}
	
	
	/**
	 * Print the menu for the user to choose.
	 */
	public static void printMenu() {
		System.out.println("What would you like to do?");
		System.out.println("1 = Record New Catch");
		System.out.println("2 = Determine Fish Records");
		System.out.println("3 = Print All Data to Screen");
		System.out.println("4 = Save and Quit");
	}
	
	
	/**
	 * Record a new catch from the user.
	 *
	 * @param Scanner the scn to read input from the user
	 * @return Catch the catch
	 */
	public static Catch recordNewCatch(Scanner scn) {
		
		//initialize the variables
		Catch fish = new Catch();
		String license = "";
		String name = "";
		float weight = 0;
		int length = 0;
		int catchDay = 0;
		int catchMonth = 0;
		int catchYear = 0;
		
		//ask the user for their license and scan for the data
		System.out.println("Which angler caught the fish? Enter their license.");
		license = scn.next();
		
		//ask the user for their fish species and scan for the data
		System.out.println("What was the fish species?");
		name = scn.next();
		
		/*ask the user for their fish's weight and scan for the data
		 * use exception handling if the user input is not float*/
		while (true) {
			try {
				System.out.println("What was the weight?");
				weight = scn.nextFloat();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Please enter a float.");
				scn.next();
			}
		}
		
		/*ask the user for their fish's length and scan for the data
		 * use exception handling if the user input is not integer*/
		while (true) {	
			try {
				System.out.println("What was the length?");
				length = scn.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Please enter an integer.");
				scn.next();
			}
		}
		
		//ask the user for the year they have caught the fish and scan for the data
		System.out.println("What was the year?");
		catchYear = scn.nextInt();
		
		//ask the user for the month they have caught the fish and scan for the data
		System.out.println("What was the month (number)?");
		catchMonth = scn.nextInt();
		
		//ask the user for the day they have caught the fish and scan for the data
		System.out.println("What was the day (number)?");
		catchDay = scn.nextInt();
		
		//set the Catch with corresponding data
		fish = new Catch(license, name, weight, length, catchDay, catchMonth, catchYear);
		
		//return Catch with data
		return fish;
	}
	
	
	/**
	 * Print out the best catches. Heaviest.
	 *
	 * @param ArrayList the catch list
	 */
	public static void heaviest(ArrayList<Catch> catchList) {
		
		//initialize an ArrayList with the Constructor
		ArrayList<Catch> heaviest = new ArrayList<Catch>();
		
		for (Catch c: catchList) {
			boolean found = false;
			
			for (int i = 0; i < heaviest.size(); i++) {
				Catch heavy = heaviest.get(i);
				
				//check if the fish species are the same
				if (c.getName().equalsIgnoreCase(heavy.getName())) {
					found = true;
					
					/*check if the fish's weight are the same
					 * if not, set the corresponding data to the heaviest ArrayList
					 * if yes, check for date and pick the one that was caught first*/
					if (c.getWeight() > heavy.getWeight()) {
						heaviest.set(i, c);
					}
					else if (c.getWeight() == heavy.getWeight()) {
						if (c.getCatchYear() < heavy.getCatchYear()) {
							heaviest.set(i, c);
						}
						else if (c.getCatchYear() == heavy.getCatchYear()) {
							if (c.getCatchMonth() < heavy.getCatchMonth()) {
								heaviest.set(i, c);
							}
							else if (c.getCatchMonth() == heavy.getCatchMonth()) {
								if (c.getCatchDay() < heavy.getCatchDay()) {
									heaviest.set(i, c);
								}
							}
						}
					}
					break;
				}
			}
			
			//if the fish species are not the same, add the corresponding data to the heaviest ArrayList
			if (!found)
				heaviest.add(c);
		}
		
		//print the data that correspond to the heaviest fish
		for (Catch h: heaviest) {
			System.out.println("Biggest " + h.getName().toLowerCase() + " had weight " + h.getWeight() + " and length " + h.getLength() +  " and was caught by " + h.getLicense() + " on " + h.getCatchYear() + "/" + h.getCatchMonth() + "/" + h.getCatchDay());
		}
	}
	
	
	/**
	 * Print out all of the data to the screen.
	 *
	 * @param ArrayList the catch list
	 */
	public static void printAllData(ArrayList<Catch> catchList) {
		for (Catch c: catchList) {
			System.out.println(c.toString());
		}
	}
	
	
	/**
	 * Print the data to a file.
	 *
	 * @param Scanner the scn to read input from the user
	 * @param ArrayList the catch list
	 */
	public static void printToFile(Scanner scn, ArrayList<Catch> catchList) {
		
		//ask user to specify the name of the file and scan
		System.out.println("Enter the file name to store data.");
		String filename = scn.next();
		
		try {
			//create PrintWriter to write data in the specific file
			PrintWriter pw = new PrintWriter(filename);
			
			//write the header of the file
			pw.println("License,Species,Weight,Length,Year,Month,Day");
			
			//write the data that are provided by the user
			for (Catch c: catchList) {
				pw.println(c.getLicense() + "," + c.getName() + "," + c.getWeight() + "," + c.getLength() + "," + c.getCatchYear() + "," + c.getCatchMonth() + "," + c.getCatchDay());
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