

/**
 * This class represents ZIP codes based on how many cyclist
 * injuries and fatalities occurred within a given ZIP code. 
 * 
 * @author Kayli O'Keefe
 * @version 10/03/15
 *
 */
public class ZipCodeCyclists implements Comparable<ZipCodeCyclists>{
	public int zipCode;
	private int injuriesAndFatalities;


	/**
	 * Default constructor for ZipCodeCyclists object.
	 */
	public ZipCodeCyclists(){

	}


	/**
	 * This constructor creates a ZipCodeCyclists object
	 * based on how many injuries and fatalities involving
	 * cyclists occurred within a given ZIP code. 
	 * 
	 * @param injuriesAndFatalities the sum of injuries and fatalities involving cyclists
	 * @param zipCode the ZIP code where the injuries and fatalities occurred
	 */
	public ZipCodeCyclists(int injuriesAndFatalities, int zipCode){
		this.injuriesAndFatalities = injuriesAndFatalities;
		this.zipCode = zipCode;
	}


	/**
	 * This method returns the number of injuries and fatalities
	 * involving cyclists that occurred with a given ZIP code.
	 * 
	 * @return injuries and fatalities involving cyclists
	 */
	public int getInjuriesAndFatalities() {
		return injuriesAndFatalities;
	}


	/**
	 * This method sets the sum of injuries and fatalities involving
	 * cyclists for collisions occurring within in a given ZIP code.
	 * 
	 * @param injuriesAndFatalities the number of injuries and fatalities 
	 * involving cyclists
	 */
	public void setInjuriesAndFatalities(int injuriesAndFatalities) {
		this.injuriesAndFatalities = injuriesAndFatalities;
	}


	/**
	 * Returns ZIP code in which collisions occurred.
	 * @return ZIP code
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * This overridden method compares a ZipCodeCyclists object to another
	 * to another ZipCodeCyclists object, in order to sort
	 * these object by the number of injuries and fatalities involving 
	 * cyclists that have occurred within their respective ZIP codes. 
	 * 
	 * @param T the object to compare to
	 * 
	 * @return -1, 0, or 1 if the object we are comparing to T has 
	 * more injuries and fatalities, the same number of injuries and
	 * fatalities, or fewer injuries and fatalities
	 */
	@Override
	public int compareTo(ZipCodeCyclists T) {
		if(this.injuriesAndFatalities>T.injuriesAndFatalities){
			return -1;
		}
		if(this.injuriesAndFatalities==T.injuriesAndFatalities){
			return 0;
		}
		return 1;
	}

}
