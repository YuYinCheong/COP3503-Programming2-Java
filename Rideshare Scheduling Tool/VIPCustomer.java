//Name: Yu Yin, Cheong
//UNF N number: N 01576808
//Date of submission: Apr 27, 2025

public class VIPCustomer extends Customer {
	
	// private variable 
	private int points;

	/**
	 * Instantiates a new VIP customer.
	 *
	 * @param String the name
	 * @param String the email
	 * @param int the age
	 * @param int the party size
	 * @param int the points
	 */
	public VIPCustomer(String name, String email, int age, int partySize, int points) {
		super(name, email, age, partySize);
		this.setPoints(points);
	}

	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Sets the points.
	 *
	 * @param points the new points
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return getName() + "," + getAge() + "," + getEmail() + "," + getPartySize() + "," + getPoints();
	}
	
	/**
	 * To CSV.
	 *
	 * @return the string
	 */
	@Override 
	public String toCSV() {
		return getName() + "," + getAge() + "," + getEmail() + "," + getPartySize() + "," + getPoints();
	}
}
