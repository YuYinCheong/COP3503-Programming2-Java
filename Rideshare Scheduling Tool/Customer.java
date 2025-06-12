//Name: Yu Yin, Cheong
//UNF N number: N 01576808
//Date of submission: Apr 27, 2025

public class Customer extends Person {
	
	// private variable 
	private int partySize;

	/**
	 * Instantiates a new customer.
	 *
	 * @param String the name
	 * @param String the email
	 * @param int the age
	 * @param int the party size
	 */
	public Customer(String name, String email, int age, int partySize) {
		super(name, email, age);
		this.setPartySize(partySize);
	}

	/**
	 * Gets the party size.
	 *
	 * @return the party size
	 */
	public int getPartySize() {
		return partySize;
	}

	/**
	 * Sets the party size.
	 *
	 * @param partySize the new party size
	 */
	public void setPartySize(int partySize) {
		this.partySize = partySize;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return getName() + "," + getAge() + "," + getEmail() + "," + getPartySize() + ",-1";
	}
	
	/**
	 * To CSV.
	 *
	 * @return the string
	 */
	@Override 
	public String toCSV() {
		return getName() + "," + getAge() + "," + getEmail() + "," + getPartySize() + ",-1";
	}
}
