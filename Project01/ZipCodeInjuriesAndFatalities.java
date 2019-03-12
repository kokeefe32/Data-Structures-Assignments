
/**
 * This class represents ZIP Codes based on the number of injuries
 * and fatalities that occurred in collisions within a 
 * given ZIP code. 
 * 
 * @author Kayli O'Keefe
 * @version 10/02/15
 *
 */
public class ZipCodeInjuriesAndFatalities implements Comparable<ZipCodeInjuriesAndFatalities>{
	public int zipCode;
	private int injuriesAndFatalities;
	
	
	
	/**
	 * Default constructor for ZipCodeInjuriesAndFatalities object.
	 */
	public ZipCodeInjuriesAndFatalities(){
		
	}
	
	
	/** 
	 * This constructor creates a ZipCodeInjuriesAndFatalities object based on
	 * the number of injuries and fatalities, and the ZIP code in which they 
	 * occurred. 
	 * 
	 * @param injuriesAndFatalities the sum of all injuries and fatalities occurring within the ZIP code
	 * @param zipCode ZIP code in which injuries and fatalities occurred
	 */
	public ZipCodeInjuriesAndFatalities(int injuriesAndFatalities, int zipCode){
		this.injuriesAndFatalities = injuriesAndFatalities;
		this.zipCode = zipCode;
	}
	
	
	/**
	 * This method returns the sum of all injuries and
	 * fatalities for collisions that occur within in a given ZIP code.
	 * 
	 * @return the sum of injuries and fatalities
	 */
	public int getInjuriesAndFatalities() {
		return injuriesAndFatalities;
	}

	
	/**
	 * This method sets the injuries and fatalities of 
	 * for a given ZIP code.
	 * 
	 * @param injuriesAndFatalities sum of injuries and fatalities occurring
	 * in collisions in a given ZIP code
	 */
	public void setInjuriesAndFatalities(int injuriesAndFatalities) {
		this.injuriesAndFatalities = injuriesAndFatalities;
	}

	
	/**
	 * This method returns the ZIP code where a given
	 * collision occurred.
	 * 
	 * @return ZIP code of collision location
	 */
	public int getZipCode(){
		return zipCode;
	}
	
	
	/**
	 * This overridden method compares a ZipCodeInjuriesAndFatalities object
	 * to another ZipCodeInjuriesAndFatalities object, in order to sort
	 * these object by the number of injuries and fatalities. 
	 * 
	 * @param T the object to compare to
	 * 
	 * @return -1, 0, or 1 if the object we are comparing to T has 
	 * more injuries and fatalities, the same injuries and fatalities,
	 * or fewer injuries and fatalities
	 */
	@Override
	public int compareTo(ZipCodeInjuriesAndFatalities T) {
		if(this.injuriesAndFatalities>T.injuriesAndFatalities){
			return -1;
		}
		if(this.injuriesAndFatalities==T.injuriesAndFatalities){
			return 0;
		}
		return 1;
	}

}







