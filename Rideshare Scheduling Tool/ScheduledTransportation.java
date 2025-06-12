//Name: Yu Yin, Cheong
//UNF N number: N 01576808
//Date of submission: Apr 27, 2025

public class ScheduledTransportation implements Printable {

	// private variables 
	private Customer customer;
	private Driver driver;
	private Vehicle vehicle;
	
	/**
	 * Instantiates a new scheduled transportation.
	 *
	 * @param Customer the c
	 * @param Vehicle the v
	 * @param Driver the d
	 */
	public ScheduledTransportation(Customer c, Vehicle v, Driver d) {
		this.setCustomer(c);
		this.setVehicle(v);
		this.setDriver(d);
	}
	
	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}


	/**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public Driver getDriver() {
		return driver;
	}


	/**
	 * Sets the driver.
	 *
	 * @param driver the new driver
	 */
	public void setDriver(Driver driver) {
		this.driver = driver;
	}


	/**
	 * Gets the vehicle.
	 *
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}


	/**
	 * Sets the vehicle.
	 *
	 * @param vehicle the new vehicle
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return getCustomer() + "," + getVehicle() + "," + getDriver();
	}
	
	/**
	 * To CSV.
	 *
	 * @return the string
	 */
	@Override
	public String toCSV() {
		return getCustomer().toCSV() + "," + getDriver().toCSV()+ "," + getVehicle().toCSV() ;
	}
}
