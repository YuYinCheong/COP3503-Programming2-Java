//Name: Yu Yin, Cheong
//UNF N number: N 01576808
//Date of submission: Mar 24, 2025

public class Catch {
	
	/** The license. */
	private String license;
	
	/** The name. */
	private String name;
	
	/** The weight. */
	private float weight;
	
	/** The length. */
	private int length;
	
	/** The catch day. */
	private int catchDay;
	
	/** The catch month. */
	private int catchMonth;
	
	/** The catch year. */
	private int catchYear;
	
	/**
	 * Constructor of a new catch.
	 */
	public Catch() {
		license = "";
		name = "";
		weight = 0;
		length = 0;
		catchDay = 0;
		catchMonth = 0;
		catchYear = 0;
	}
	
	/**
	 * Constructor of an initialize new catch.
	 *
	 * @param String the license
	 * @param String the name
	 * @param float the weight
	 * @param integer the length
	 * @param integer the catch day
	 * @param integer the catch month
	 * @param integer the catch year
	 */
	public Catch(String license, String name, float weight, int length, int catchDay, int catchMonth, int catchYear) {
		this.license = license;
		this.name = name;
		this.weight = weight;
		this.length = length;
		this.catchDay = catchDay;
		this.catchMonth = catchMonth;
		this.catchYear = catchYear;
	}

	/**
	 * Gets the license.
	 *
	 * @return String the license
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * Sets the license.
	 *
	 * @param String the new license
	 */
	public void setLicense(String license) {
		this.license = license;
	}

	/**
	 * Gets the name.
	 *
	 * @return String the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param String the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the weight.
	 *
	 * @return float the weight
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 *
	 * @param float the new weight
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * Gets the length.
	 *
	 * @return integer the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Sets the length.
	 *
	 * @param integer the new length
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Gets the catch day.
	 *
	 * @return integer the catch day
	 */
	public int getCatchDay() {
		return catchDay;
	}

	/**
	 * Sets the catch day.
	 *
	 * @param integer the new catch day
	 */
	public void setCatchDay(int catchDay) {
		this.catchDay = catchDay;
	}

	/**
	 * Gets the catch month.
	 *
	 * @return integer the catch month
	 */
	public int getCatchMonth() {
		return catchMonth;
	}

	/**
	 * Sets the catch month.
	 *
	 * @param integer the new catch month
	 */
	public void setCatchMonth(int catchMonth) {
		this.catchMonth = catchMonth;
	}

	/**
	 * Gets the catch year.
	 *
	 * @return integer the catch year
	 */
	public int getCatchYear() {
		return catchYear;
	}

	/**
	 * Sets the catch year.
	 *
	 * @param integer the new catch year
	 */
	public void setCatchYear(int catchYear) {
		this.catchYear = catchYear;
	}
	
	 
	/**
	 * All data to string.
	 *
	 * @return the string
	 */
	public String toString() {	
		return "Angler" + " " + license + " caught a " + name + ": " + weight + "lbs, " + length + "inches, on " + catchYear + "/" + catchMonth + "/" + catchDay; 
	}

}
