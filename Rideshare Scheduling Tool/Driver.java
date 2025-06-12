//Name: Yu Yin, Cheong
//UNF N number: N 01576808
//Date of submission: Apr 27, 2025

public class Driver extends Person implements Printable {
	
	// private variable 
	private String license;

	/**
	 * Instantiates a new driver.
	 *
	 * @param String the name
	 * @param String the email
	 * @param int the age
	 * @param String the license
	 */
	public Driver(String name, String email, int age, String license) {
		super(name, email, age);
		this.setLicense(license);
	}

	/**
	 * Gets the license.
	 *
	 * @return the license
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * Sets the license.
	 *
	 * @param license the new license
	 */
	public void setLicense(String license) {
		this.license = license;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return getName() + "," + getAge() + "," + getEmail() + "," + getLicense();
	}
	
	/**
	 * To CSV.
	 *
	 * @return the string
	 */
	@Override 
	public String toCSV() {
		return getName() + "," + getAge() + "," + getEmail() + "," + getLicense();
	}
}
