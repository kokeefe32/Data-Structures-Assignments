



/**
 * This class represents ZIP Codes based on the number
 * of collisions that occurred within a given ZIP code. 
 * 
 * @author Kayli O'Keefe
 * @version 10/03/15
 *
 */
public class ZipCode implements Comparable<ZipCode> {
	private int count;
	public int zipCode;


	/**
	 * Default constructor for ZipCode object
	 */
	public ZipCode(){	

	}


	/**
	 * This constructor creates a ZipCode object. 
	 * @param zipCode ZIP code of a collision
	 */
	public ZipCode(int zipCode){
		count = 1;
		this.zipCode = zipCode;
	}


	/**
	 * Gets the count for number of collisions that occurred
	 * within a specific ZipCode object.
	 * 
	 * @return number of collisions
	 */
	public int getCount() {
		return count;
	}


	/**
	 * Returns the ZIP code of a given ZipCode object.
	 * @return zip code
	 */
	public int getZipCode() {
		return zipCode;
	}


	/**
	 * This method increments the count for the
	 * number of collisions that have occurred within
	 * a certain ZipCode object. 
	 * 
	 * @param count number of collisions in a given ZIP code
	 */
	public void increment(int count){
		this.count++;
	}


	/**
	 * This method compares a ZipCode object to another
	 * to another ZipCode object, in order to sort
	 * these object by the number of collisions that have
	 * occurred within their respective ZIP codes. 
	 * 
	 * @param T the object to compare to
	 * 
	 * @return -1, 0, or 1 if the object we are comparing to T has 
	 * more collisions, the same number of collisions, or fewer
	 * collisions.
	 */
	public int compareTo(ZipCode T) {
		if(this.count>T.count){
			return -1;
		}
		if(this.count==T.count){
			return 0;
		}
		return 1;
	}

}



