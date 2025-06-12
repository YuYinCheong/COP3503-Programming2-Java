//Name: Yu Yin, Cheong
//UNF N number: N 01576808
//Date of submission: Apr 27, 2025

public class Vehicle implements Printable {

	// private variables 
	private int seats;
	private boolean isLuxury;
	private String description;
	
	/**
	 * Instantiates a new vehicle.
	 *
	 * @param int the seats
	 * @param boolean the is luxury
	 * @param String the description
	 */
	public Vehicle(int seats, boolean isLuxury, String description) {
		this.setSeats(seats);
		this.setLuxury(isLuxury);
		this.setDescription(description);
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Checks if is luxury.
	 *
	 * @return true, if is luxury
	 */
	public boolean isLuxury() {
		return isLuxury;
	}

	/**
	 * Sets the luxury.
	 *
	 * @param isLuxury the new luxury
	 */
	public void setLuxury(boolean isLuxury) {
		this.isLuxury = isLuxury;
	}

	/**
	 * Gets the seats.
	 *
	 * @return the seats
	 */
	public int getSeats() {
		return seats;
	}

	/**
	 * Sets the seats.
	 *
	 * @param seats the new seats
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return getDescription() + "," + getSeats()  + "," + isLuxury();
	}
	
	/**
	 * To CSV.
	 *
	 * @return the string
	 */
	@Override
	public String toCSV() {
		return getDescription() + "," + getSeats()  + "," + isLuxury();
	}
}
