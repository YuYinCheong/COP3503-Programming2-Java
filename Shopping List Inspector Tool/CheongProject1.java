//Name: Yu Yin, Cheong
//UNF N number: N 01576808
//Date of submission: Feb 25, 2025

import java.util.ArrayList;
import java.util.Scanner;

public class CheongProject1 {
	
	
	/**
	 * Count the number of times the word "candy" appears.
	 *
	 * @param list the array given by user
	 * @return the integer that tells the number of times the word “candy” appears in the list of food items
	 */
	public static int countCandy(String[] list) {
		
		//initialize the count
		int count = 0;
		
		//for each item in list, change each item to lower case letter
		for (int i = 0; i < list.length; i++) {
			list[i] = list[i].toLowerCase();
			
			//if the item contains the word "candy", add 1 to count
			if (list[i].contains("candy"))
				count++;
		}
		
		//print the count of candy
		System.out.println("Number of Candy: " + count);
		
		//return the count of candy
		return count;
	}
	
	
	/**
	 * Gets all of the one word food items.
	 * Food items without spaces.
	 *
	 * @param list the array given by user
	 * @return arrayList all of the one word food items from the list
	 */
	public static ArrayList<String> getOneWordFoodItems(String[] list) {
		
		//initialize arrayList to store one word foods items
		ArrayList<String> foods = new ArrayList<String>();
		
		/*for each item in list
		 * if the item does not contain a space, add the item to arrayList*/
		for (int i = 0; i < list.length; i++) {
			if (!list[i].contains(" "))
				foods.add(list[i]);
		}
		
		//print all of the one word food items
		for (int i = 0; i < foods.size(); i++) {
			System.out.println(foods.get(i));
		}
		
		//return all of the one word food items
		return foods;
	}
	
	
	/**
	 * Gets all of the multiple word food items.
	 * Food items with spaces.
	 *
	 * @param list the array given by user
	 * @return arrayList all of the multiple word food items from the list
	 */
	public static ArrayList<String> getMultiWordFoodItems(String[] list) {
	
		//initialize arrayList to store multiple word foods items 
		ArrayList<String> foods = new ArrayList<String>();
		
		/*for each item in list
		 * if the item does contain a space, add the item to arrayList*/
		for (int i = 0; i < list.length; i++) {
			if (list[i].contains(" "))
				foods.add(list[i]);
		}
		
		//print all of the multiple word food items
		for (int i = 0; i < foods.size(); i++) {
			System.out.println(foods.get(i));
		}
		
		//return all of the multiple word food items
		return foods;
	}
	
	
	/**
	 * Gets all of the unique food items.
	 * Food items that do not repeat. 
	 *
	 * @param list the array given by user
	 * @return arrayList all of the unique food items from the list
	 */
	public static ArrayList<String> getUniqueFoodItems(String[] list) {
		
		//initialize arrayList to store unique foods items
		ArrayList<String> unique = new ArrayList<String>();
		
		//create array to track the count of each item
		int[] count = new int[list.length];
		
		/*for each item in list 
		 * change each item to lower case letter, and initialize each corresponding count*/
		for(int i = 0; i < list.length; i++) { 
			list[i] = list[i].toLowerCase(); 
			count[i] = 1;
			
			/*check if the item is already in the list
			 * if the item is already in the list, add 1 to count*/
			for(int j = 0; j < i; j++) {
				if (list[j].equals(list[i])) {
					count[j]++;
					count[i] = count[j];
				  }
			  } 
		  }
		
		//for each item, if the count is 1, add to the arrayList 
		for(int i = 0; i < list.length; i++) {
			if(count[i] == 1) 
				unique.add(list[i]);
		}
		
		//print all of the unique food items
		for(int i = 0; i < unique.size(); i++) {
			System.out.println(unique.get(i));
		}
		
		//return all of the unique food items
		return unique;
	}
	
	
	/**
	 * Gets all of the non unique food items.
	 * Food items that do repeat. 
	 *
	 * @param list the array given by user
	 * @return arrayList all of the non unique food items from the list
	 */
	public static ArrayList<String> getNonUniqueFoodItems(String[] list) {
		
		//initialize arrayList to store non unique foods items
		ArrayList<String> nonUnique = new ArrayList<String>();
		
		//create array to track the count of each item
		int[] count = new int[list.length];
		
		/*for each item in list
		 * change each item to lower case letter, and initialize each corresponding count*/
		for(int i = 0; i < list.length; i++) {
			  list[i] = list[i].toLowerCase();
			  count[i] = 1;
			  
			/*check if the item is already in the list
			 * if the item is already in the list, add 1 to count*/
			  for(int j = 0; j < i; j++) {
				  if (list[j].equals(list[i])) {
					  count[j]++;
					  count[i] = count[j];
				  }
			  } 
		  }
		
		/*for each item
		 * if the count is not 1, and the item matches
		 * add to the arrayList*/
		for(int i = 0; i < list.length; i++) {
			for(int j = 0; j < i; j++) {
				  if (count[i] != 1 && list[j].equals(list[i])) 
					  nonUnique.add(list[i]);
			  }
		}
		
		//print all of the non unique food items
		for(int i = 0; i < nonUnique.size(); i++) {
			System.out.println(nonUnique.get(i));
		}
		
		//return all of the non unique food items
		return nonUnique;
	}
	
	/**
	 * Gets the most frequent food item.
	 *
	 * @param list the array given by user
	 * @return String the most frequent food item from the list
	 */
	public static String getMostFrequentFoodItem(String[] list) {
		
		//initialize String to store the most frequent food item 
		String mostFrequent = "";
		
		//create array to track the count of each item
		int[] count = new int[list.length];
		
		//initialize the highest frequency
		int max = 0;
		
		/*for each item in list
		 * change each item to lower case letter, and initialize each corresponding count*/
		for(int i = 0; i < list.length; i++) {
			  list[i] = list[i].toLowerCase();
			  count[i] = 1;
			  
			/*check if the item is already in the list
			 * if the item is already in the list, add 1 to count*/
			  for(int j = 0; j < i; j++) {
				  if (list[j].equals(list[i])) {
					  count[j]++;
					  count[i] = count[j];
				  }
			  } 
		  }
		
		//for each item, if the max is less than the count, set max equals to the count
		for(int i = 0; i < list.length; i++) {
			  if (max < count[i]) 
				  max = count[i]; 
		}
		
		/*for the food item that appears latest in the list 
		 * if the count is same as the max
		 * set mostFrequent to the corresponding list item and break from the loop*/
		for(int i = list.length - 1; i >= 0 ; i--) {
			  if (count[i] == max) { 
				  mostFrequent = list[i];
				  break;
			  }
		}
	
		//print the most frequent food item
		System.out.println(mostFrequent);
		
		//return the most frequent food item
		return mostFrequent;
	}
	
	/**
	 * Gets the least frequent food item.
	 *
	 * @param list the array given by user
	 * @return String the least frequent food item from the list
	 */
	public static String getLeastFrequentFoodItem(String[] list) {
		
		//initialize String to store the least frequent food item
		String leastFrequent = "";
		
		//create array to track the count of each item
		int[] count = new int[list.length];
		
		//initialize the highest frequency
		int max = 0;
		
		/*for each item in list
		 * change each item to lower case letter, and initialize each corresponding count */
		for(int i = 0; i < list.length; i++) {
			  list[i] = list[i].toLowerCase();
			  count[i] = 1;
			  
			/*check if the item is already in the list
			 * if the item is already in the list, add 1 to count*/
			  for(int j = 0; j < i; j++) {
				  if (list[j].equals(list[i])) {
					  count[j]++;
					  count[i] = count[j];
				  }
			  } 
		  }
		
		//for each item, if the max is less than the count, set max equals to the count
		for(int i = 0; i < list.length; i++) {
			  if (max < count[i]) 
				  max = count[i]; 
		}
		
		/*for the food item that appears first in the list 
		 * if the count is not the same as the max
		 * set leastFrequent to the corresponding list item and break from the loop*/
		for(int i =  0; i < list.length ; i++) {
			  if (count[i] != max) { 
				  leastFrequent = list[i];
				  break;
			  }
		}

		//print the least frequent food item
		System.out.println(leastFrequent);
		
		//return the least frequent food item
		return leastFrequent;
	}
	
	/**
	 * Count distinct mustards in list.
	 *
	 * @param list the array given by user
	 * @return the integer that tells the number of distinct food items containing the word “mustard” 
	 */
	public static int countMustardsInList(String[] list) {
		
		//initialize the number of distinct mustard 
		int mustard = 0;
		
		//initialize arrayList to store the mustard 
		ArrayList<String> typeMustard = new ArrayList<String>();
		
		//create array to track the count of each item
		int[] count = new int[list.length];
		
		/*for each item in list
		 * change each item to lower case letter, and initialize each corresponding count */
		for(int i = 0; i < list.length; i++) {
			  list[i] = list[i].toLowerCase();
			  count[i] = 1;
			  
			/*check if the item is already in the list
			 * if the item is already in the list, add 1 to count*/
			  for(int j = 0; j < i; j++) {
				  if (list[j].equals(list[i])) {
					  count[j]++;
					  count[i] = count[j];
				  }
			  } 
		  }
		
		//handle non unique mustard
		for(int i = 0; i < list.length; i++) {	
			for(int j = 0; j < i; j++) {
				  if (list[i].contains("mustard") && list[j].equals(list[i]))
					  typeMustard.add(list[i]);
			  }	
		}
		
		//handle unique mustard
		for(int i = 0; i < list.length; i++) {	
			if(count[i] == 1 && list[i].contains("mustard")) 
				typeMustard.add(list[i]);
		}
		
		//set mustard to the number of distinct mustard
		mustard = typeMustard.size();
		
		//print the integer that tells the number of distinct food items containing the word “mustard” 
		System.out.println(mustard);
		
		//print the arrayList that has distinct food items containing the word “mustard” 
		for(int i = 0; i < mustard; i++) {
			System.out.println(typeMustard.get(i));
		}
		
		//return the integer that tells the number of distinct food items containing the word “mustard” 
		return mustard;
	}
	
	/**
	 * Gets the new list.
	 *
	 * @param scn the Scanner to read input from the user
	 * @return the new list as an array
	 */
	public static String[] getNewList(Scanner scn) {
		
		//initialize a String
		String foods = "";
		
		/*check if there is another line input
		 * if yes, scan and read the line*/
		if (scn.hasNextLine()) 
			foods = scn.nextLine();
		
		//split the String at comma and space, and turn it into array
		String[] foodList = foods.split(", ");
		
		//return array of food items
		return foodList;
	}
	
	/**
	 * Prints the menu.
	 */
	public static void printMenu() {
		System.out.println("What do you want to do?");
		System.out.println("1 = Count Candy");
		System.out.println("2 = Get One Word Food Items");
		System.out.println("3 = Get Multi-Word Food Items");
		System.out.println("4 = Get Unique Food Items");
		System.out.println("5 = Get Non-Unique Food Items");
		System.out.println("6 = Get Most Frequent Food Item");
		System.out.println("7 = Get Least Frequent Food Item");
		System.out.println("8 = Count Mustards");
		System.out.println("9 = Enter New List");
		System.out.println("0 = Quit");
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		String foodItems[] = getNewList(scn);
		
		
		
		//obtain what the user wants to do
		int option;
		
		//initialize the boolean
		boolean food = true;
		
		/*while it is true
		 * print the menu, get the user choice on what they want to do with the list
		 * scan the list given by the user
		 * based on what the user choice on the list, run the corresponding code*/
		while (food) {
			printMenu();
			option = scn.nextInt();
			scn.nextLine();
			switch (option) {
			case 1: 
				int count = countCandy(foodItems);
				System.out.println("Number of Candy: " + count);
				break;
			case 2: 
				ArrayList<String> word = getOneWordFoodItems(foodItems);
				
				for (int i = 0; i < word.size(); i++) {
					System.out.println(word.get(i));
				}
				break;
			case 3:
				ArrayList<String> words = getMultiWordFoodItems(foodItems);
				
				for (int i = 0; i < words.size(); i++) {
					System.out.println(words.get(i));
				}
				break;
			case 4: 
				ArrayList<String> unique = getUniqueFoodItems(foodItems);
				
				for(int i = 0; i < unique.size(); i++) {
					System.out.println(unique.get(i));
				}
				break;
			case 5:
				ArrayList<String> nonUnique = getNonUniqueFoodItems(foodItems);
				
				for(int i = 0; i < nonUnique.size(); i++) {
					System.out.println(nonUnique.get(i));
				}
				break;
			case 6:
				String mostFrequent = getMostFrequentFoodItem(foodItems);
				System.out.println(mostFrequent);
				break;
			case 7:
				String leastFrequent = getLeastFrequentFoodItem(foodItems);
				System.out.println(leastFrequent);
				break;
			case 8:
				int mustard = countMustardsInList(foodItems);
				System.out.println(mustard);
				break;
			case 9:
				foodItems = getNewList(scn);
				break;
			case 0:
				//if user choose 0, it will quit the while by setting it to false
				food = false;
				break;
			}
		}
		
	}
}