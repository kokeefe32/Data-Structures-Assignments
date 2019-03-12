

import java.util.Comparator;
import java.util.ArrayList;

/**
 * This class represents a collision object based on entries of data.
 * . 
 * @author Kayli O'Keefe
 * @version 10/02/15
 *
 */
public class Collision implements Comparator<Collision> {

	private String date;
	private String time;
	private String borough;
	public int zipCode;
	private String latitude;
	private String longitude;
	private String streetName;
	private String crossStreetName;
	private int personsKilled;
	private int personsInjured;
	private int pedestriansKilled;
	private int pedestriansInjured;
	private int cyclistsKilled;
	private int cyclistsInjured;
	private int motoristsKilled;
	private int motoristsInjured;
	private String contributingFactorVehicleOne;
	private String contributingFactorVehicleTwo;
	private String uniqueKey;
	private String vehicleTypeCodeOne;
	private String vehicleTypeCodeTwo;

	/**
	 * Default constructor for Collision object.
	 */
	public Collision(){

	}


	/**
	 * This constructor creates a collision object by taking in an ArrayList 
	 * of entries for a single collision, and assigns each entry to its corresponding 
	 * parameter.
	 * 
	 * @param collision ArrayList of entries for one collision
	 * 
	 * @throws IllegalArgumentException if there is an entry that doesn't 
	 * meet the criteria for its specified parameter. No collision object is 
	 * created in this case.
	 */
	public Collision(ArrayList<String> collision) throws IllegalArgumentException {
		this.date = collision.get(0);
		this.time = collision.get(1);
		this.borough = collision.get(2);
		this.zipCode = Integer.parseInt(collision.get(3));
		this.latitude = collision.get(4);
		this.longitude = collision.get(5);
		this.streetName = collision.get(6);
		this.crossStreetName = collision.get(7);
		this.personsInjured = Integer.parseInt(collision.get(8));
		this.personsKilled = Integer.parseInt(collision.get(9));
		this.pedestriansKilled = Integer.parseInt(collision.get(10));
		this.pedestriansInjured = Integer.parseInt(collision.get(11));
		this.cyclistsKilled = Integer.parseInt(collision.get(12));
		this.cyclistsInjured = Integer.parseInt(collision.get(13));
		this.motoristsKilled = Integer.parseInt(collision.get(14));
		this.motoristsInjured = Integer.parseInt(collision.get(15));
		this.contributingFactorVehicleOne = collision.get(16);
		this.contributingFactorVehicleTwo = collision.get(17);
		this.uniqueKey = collision.get(18);
		this.vehicleTypeCodeOne = collision.get(19);
		this.vehicleTypeCodeTwo = collision.get(20);

	}


	/**
	 * Returns the date that the collision occurred.
	 * @return date the date that the collision occurred
	 */
	public String getDate() {
		return date;
	}

	
	/**
	 * Returns the time of day that the collision occurred.
	 * @return time time that the collision occurred
	 */
	public String getTime() {
		return time;
	}

	
	/**
	 * Returns the borough where collision occurred. 
	 * @return borough the borough where the collision occurred
	 */
	public String getBorough() {
		return borough;
	}

	
	/**
	 * Returns the ZIP code where the collision occurred. 
	 * @return zip code the ZIP code where the collisions occurred
	 */
	public int getZipCode() {
		return zipCode;
	}

	
	/**
	 * Returns the latitude of the location in which the collision occurred. 
	 * @return latitude the latitude of where the collision occurred
	 */
	public String getLatitude() {
		return latitude;
	}

	
	/**
	 * Returns the longitude of the location in which the collision occurred.
	 * @return longitude the longitude of where the collision occurred
	 */
	public String getLongitude() {
		return longitude;
	}

	
	/**
	 * Returns the name of the street on which the collision occurred.
	 * @return street name the street name where the collision occurred
	 */
	public String getStreetName() {
		return streetName;
	}

	
	/**
	 * Returns the name of the cross street where the collision occurred. 
	 * @return cross street name the cross street name where the collision occurred
	 */
	public String getCrossStreetName() {
		return crossStreetName;
	}

	
	/**
	 * Returns the number of people killed in the collision. 
	 * @return number of people killed
	 */
	public int getPersonsKilled() {
		return personsKilled;
	}

	
	/**
	 * Returns the number of people injured in the collision.
	 * @return number of people injured
	 */
	public int getPersonsInjured() {
		return personsInjured;
	}

	
	/**
	 * Returns the number of pedestrians killed in the collision.
	 * @return number of pedestrians killed
	 */
	public int getPedestriansKilled() {
		return pedestriansKilled;
	}

	
	/**
	 * Returns the number of pedestrians injured in the collision.
	 * @return number of pedestrians injured
	 */
	public int getPedestriansInjured() {
		return pedestriansInjured;
	}

	
	/**
	 * Returns the number of cyclists killed in the collision.
	 * @return number of cyclists killed
	 */
	public int getCyclistsKilled() {
		return cyclistsKilled;
	}

	
	/**
	 * Returns the number of cyclists injured in the collision.
	 * @return number of cyclists injured
	 */
	public int getCyclistsInjured() {
		return cyclistsInjured;
	}

	
	/**
	 * Returns the number of motorists killed in the collision.
	 * @return number of motorists killed
	 */
	public int getMotoristsKilled() {
		return motoristsKilled;
	}

	
	/**
	 * Returns the number of motorists injured in the collision.
	 * @return number of motorists injured
	 */
	public int getMotoristsInjured() {
		return motoristsInjured;
	}

	
	/**
	 * Returns the contributing factor of vehicle one for the collision. 
	 * @return contributing factor for vehicle one
	 */
	public String getContributingFactorVehicleOne() {
		return contributingFactorVehicleOne;
	}

	
	/**
	 * Returns the contributing factor of vehicle two for the collision. 
	 * @return contributing factor for vehicle two
	 */
	public String getContributingFactorVehicleTwo() {
		return contributingFactorVehicleTwo;
	}

	
	/**
	 * Returns the unique key that has been assigned to the collision.
	 * @return identifying key for collision
	 */
	public String getUniqueKey() {
		return uniqueKey;
	}

	
	/**
	 * Returns the type code for vehicle one.
	 * @return vehicle one type code
	 */
	public String getVehicleTypeCodeOne() {
		return vehicleTypeCodeOne;
	}

	
	/**
	 * Returns the type code for vehicle two.
	 * @return vehicle two type code
	 */
	public String getVehicleTypeCodeTwo() {
		return vehicleTypeCodeTwo;
	}


	/**
	 * This method compares two collision objects for ordering
	 * purposes. 
	 * 
	 * @param o1 the first collision to be compared
	 * @param o2 the second collision to be compared
	 * 
	 * @return a negative integer if first collision is less
	 * than the second, 0 if the collisions are equal, and 1
	 * if the first collision is greater than the second
	 */
	@Override
	public int compare(Collision o1, Collision o2) {
		return o1.getZipCode() < o2.getZipCode() ? -1 
				: o1.getZipCode() == o2.getZipCode() ? 0 : 1;
	}

}
