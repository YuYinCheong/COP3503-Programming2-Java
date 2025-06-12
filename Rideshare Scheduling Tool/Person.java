//Name: Yu Yin, Cheong
//UNF N number: N 01576808
//Date of submission: Apr 27, 2025

public class Person implements Printable {
	
	// private variables 
	private String name;
	private String email;
	private int age;
	
	/**
	 * Instantiates a new person.
	 *
	 * @param String the name
	 * @param String the email
	 * @param int the age
	 */
	public Person(String name, String email, int age) {
		this.setName(name);
		this.setEmail(email);
		this.setAge(age);
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return getName() + "," + getEmail() + "," + getAge();
	}
	
	/**
	 * To CSV.
	 *
	 * @return the string
	 */
	@Override
	public String toCSV() {
		return getName() + "," + getEmail() + "," + getAge();
	}

}
