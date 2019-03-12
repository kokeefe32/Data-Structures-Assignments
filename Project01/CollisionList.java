
import java.util.ArrayList;
import java.util.Collections;


/**
 * This class represents all of the Collision objects in a single
 * container. It stores an ArrayList of collisions, and provides the
 * methods that return the results required by each task. 
 *  
 * @author Kayli O'Keefe
 * @version 10/02/15
 *
 */
public class CollisionList {
	
	// ArrayList of all Collision objects
	protected ArrayList<Collision> collisionsList = new ArrayList<Collision>();
	
	
	/**
	 * This method adds a collision object to an ArrayList of collisions.
	 * 
	 * @param o Collision object
	 */
	public void add(Collision o){
		collisionsList.add(o);
	}
	
	/**
	 * This method creates a list of ZipCode objects, where
	 * each ZipCode object contains the number of collisions
	 * that occurred in a specific ZIP code. After sorting the
	 * list by number of collisions, it returns a string containing
	 * the ZIP codes with the largest number of collisions, and
	 * the ZIP codes with the fewest number of collisions.
	 * 
	 * @return String consisting of the three ZIP codes with the largest number
	 * of collisions, and the three zip codes with the smallest number of
	 * collisions. If there is a tie, both ZIP codes will be returned. 
	 */
	public String taskOneAndTwo(){
		// ArrayList of ZipCode objects
		ArrayList<ZipCode> zipCodesList = new ArrayList<ZipCode>();
		
		// For each collision object, if the ZIP code for the collision
		// is already a in the list of ZipCode objects, the count of collisions
		// pertaining to that ZipCode object is incremented. Otherwise, a new
		// ZipCode object is created, with count (collisions) initialized to one. 
		for(Collision e: collisionsList){
			boolean found = false;
			for(ZipCode x: zipCodesList){
				if (equals(e.getZipCode(), x.getZipCode())){
					found = true;
					x.increment(x.getCount());
					continue;
				}
			}
			if(!found){
				zipCodesList.add(new ZipCode(e.getZipCode()));
			}
		}
		
		
		// Sort zipCodesList by number of collisions
		Collections.sort(zipCodesList);
		
		int min = 0;
		int max = 0;
		int indexMin = zipCodesList.size()-1;
		int indexMax = 0;
		int counterMax = 0;
		int counterMin = 0;
		StringBuffer maxCollisions = new StringBuffer();
		StringBuffer minCollisions = new StringBuffer();
		
		maxCollisions.append("ZIP codes with the largest number of collisions:\n");
		minCollisions.append("ZIP codes with the fewest number of collisions:\n");
		
		// Find the three ZipCode objects with the greatest number of Collisions
		while(counterMax < 3){
			max = zipCodesList.get(indexMax).getCount();
			while(indexMax!=zipCodesList.size()-1 && max == zipCodesList.get(indexMax).getCount()){
				maxCollisions.append("\t" + zipCodesList.get(indexMax).zipCode + "\t\t" + max + " Collisions\n");
				indexMax++;
			}
			counterMax++;
		}
		
		// Find the three ZipCode objects with the smallest number of collisions
		while(counterMin < 3){
			min = zipCodesList.get(indexMin).getCount();
			while(indexMin != 0 && min == zipCodesList.get(indexMin).getCount()){
				minCollisions.append("\t" + zipCodesList.get(indexMin).zipCode +"\t\t" + min + " Collisions\n");
				indexMin--;
			}
			counterMin++;
		}

		// Return as a String
		return maxCollisions.toString() + "\n" + minCollisions.toString();

	}
	
	
	/**
	 * This method checks whether two integers are
	 * equal. 
	 * 
	 * @param z1 integer one
	 * @param z2 integer two
	 * @return true if the integers are the same, false otherwise
	 */
	public boolean equals(int z1, int z2){
		return z1 == z2;
	}
	
	
	/**
	 * This method creates a list of ZipCodeInjuriesAndFatalities objects, where
	 * each  object contains the sum of all injuries and fatalities
	 * that occurred in a specific ZIP code. After sorting the
	 * list by number of injuries and fatalities, it returns a string containing
	 * the ZIP codes with the most injuries and fatalities.
	 * 
	 * @return String consisting of the three ZIP codes with the largest number
	 * of injuries and fatalities. If there is a tie, both ZIP codes will be returned. 
	 */
	public String taskThree(){
		// ArrayList of ZipCodeInjuriesAndFatalities objects
		ArrayList<ZipCodeInjuriesAndFatalities> zipCodesList = new ArrayList<ZipCodeInjuriesAndFatalities>();
		
		// For each collision object, if the ZIP code for the collision
		// is already a in the list of ZipCodeInjuriesAndFatalities objects, 
		// the sum of injuries and fatalities for that ZIP code is added to the 
		// injuries and fatalities of the ZipCodeInjuriesAndFatalitiesObject.
		// Otherwise, a new ZipCodeInjuriesAndFatalities object is created, with the
		// injuriesAndFatalities initialized to the sum of injuries and fatalities for
		// the collision object.
		for(Collision e: collisionsList){
			boolean found = false;
			int sum = e.getPersonsInjured() + e.getPersonsKilled();
			for(ZipCodeInjuriesAndFatalities x: zipCodesList){
				if (equals(e.getZipCode(), x.getZipCode())){
					found = true;
					x.setInjuriesAndFatalities(x.getInjuriesAndFatalities() + sum);
					continue;
				}
			}
			if(!found){
				zipCodesList.add(new ZipCodeInjuriesAndFatalities(sum, e.getZipCode()));
			}
			
		}
	
		// Sort zipCodesList by number of injuries and fatalities
		Collections.sort(zipCodesList);
		
		
		
		int max = 0;
		int indexMax = 0;
		int counterMax = 0;
		StringBuffer maxInjuriesAndFatalities = new StringBuffer();
		
		maxInjuriesAndFatalities.append("ZIP codes with the most injuries and fatalities (combined):\n");
		
		// Find the three ZIP codes with the most injuries and fatalities
		while(counterMax < 3){
			max = zipCodesList.get(indexMax).getInjuriesAndFatalities();
			while(indexMax!=zipCodesList.size()-1 && max == zipCodesList.get(indexMax).getInjuriesAndFatalities()){
				maxInjuriesAndFatalities.append("\t" + zipCodesList.get(indexMax).zipCode + "\t\t" + max + " injuries and fatalities\n");
				indexMax++;
			}
			counterMax++;
		}
		
		// Return the three ZIP codes with the most injuries and fatalities as a String
		return maxInjuriesAndFatalities.toString() + "\n";

	}
	

	/**
	 * This method creates a list of ZipCodeCyclists objects, where
	 * each  object contains the sum of all injuries and fatalities
	 * involving cyclists that occurred in a specific ZIP code. After sorting the
	 * list by number of injuries and fatalities involving cyclists, it returns 
	 * a string containing the ZIP codes with the most injuries and fatalities
	 * involving cyclists.
	 * 
	 * @return String consisting of the three ZIP codes with the largest number
	 * of injuries and fatalities. If there is a tie, both ZIP codes will be returned. 
	 */
	public String taskFour(){
		// ArrayList of ZipCodeCyclists objects
		ArrayList<ZipCodeCyclists> zipCodesList = new ArrayList<ZipCodeCyclists>();
		
		// For each collision object, if the ZIP code for the collision
		// is already a in the list of ZipCodeCyclists objects, 
		// the sum of injuries and fatalities involving cyclists  for that ZIP
		// code is added to the injuries and fatalities involving cyclists of 
		// the ZipCodeCyclists object. Otherwise, a new ZipCodeCyclists object is
		// created, with the injuriesAndFatalities initialized to the sum of injuries 
		// and fatalities for the collision object.
		for(Collision e: collisionsList){
			boolean found = false;
			int sum = e.getCyclistsInjured() + e.getCyclistsKilled();
			for(ZipCodeCyclists x: zipCodesList){
				if (equals(e.getZipCode(), x.getZipCode())){
					found = true;
					x.setInjuriesAndFatalities(x.getInjuriesAndFatalities() + sum);
					continue;
				}
			}
			if(!found){
				zipCodesList.add(new ZipCodeCyclists(sum, e.getZipCode()));
			}
		}
	
		// Sort zipCodesList by number of injuries and fatalitites involving cyclists.
		Collections.sort(zipCodesList);
		
		
		
		int max = 0;
		int indexMax = 0;
		int counterMax = 0;
		StringBuffer maxInjuriesAndFatalities = new StringBuffer();
		
		maxInjuriesAndFatalities.append("ZIP codes with the most cyclist injuries and fatalities (combined):\n");
		
		// Find the three ZIP codes with the most injuries and fatalities involving cyclists
		while(counterMax < 3){
			max = zipCodesList.get(indexMax).getInjuriesAndFatalities();
			while(indexMax!=zipCodesList.size()-1 && max == zipCodesList.get(indexMax).getInjuriesAndFatalities()){
				maxInjuriesAndFatalities.append("\t" + zipCodesList.get(indexMax).zipCode + "\t\t" + max + " cyclists hurt\n");
				indexMax++;
			}
			counterMax++;
		}
		
		// Return the three ZIP codes with the most injuries and fatalities 
		// involving cyclists as a String.
		return maxInjuriesAndFatalities.toString() + "\n";

	}
	
	/**
	 * This method iterates through each collision object, and finds the
	 * percentage of collisions involving certain vehicle types. 
	 * 
	 * @return percentage of collisions involving certain vehicle types (taxi, bus
	 * bicycle, fire truck, and ambulance). 
	 */
	public String taskFive(){
		StringBuffer vehicleTypes = new StringBuffer();

		// Initialize the number of collisions involving each vehicle type to zero. 
		int taxi = 0;
		int bus = 0;
		int bicycle = 0;
		int fireTruck = 0;
		int ambulance = 0;
		int totalCollisions = collisionsList.size();
		
		// For each Collision object, check the two vehicles involved. And
		// add to the count for collisions involving each vehicle type. 
		for(Collision e: collisionsList){
			String vehicleTypeOne = e.getVehicleTypeCodeOne();
			String vehicleTypeTwo = e.getVehicleTypeCodeTwo();
			if(vehicleTypeOne.equals("TAXI") || vehicleTypeTwo.equals("TAXI"))
				taxi++;
			if(vehicleTypeOne.equals("BUS") || vehicleTypeTwo.equals("BUS"))
				bus++;
			if(vehicleTypeOne.equals("BICYCLE") || vehicleTypeTwo.equals("BICYCLE"))
				bicycle++;
			if(vehicleTypeOne.equals("FIRE TRUCK") || vehicleTypeTwo.equals("FIRE TRUCK"))
				fireTruck++;
			if(vehicleTypeOne.equals("AMBULANCE") || vehicleTypeTwo.equals("AMBULANCE"))
				ambulance++;
			
		}

		vehicleTypes.append("Percentage of collisions involving certain vehicle types:\n");
		
		// Calculate the percent of collisions involving each vehicle type. 
		double taxiPercent = 100.00 * taxi / totalCollisions;
		double busPercent = 100.00 * bus / totalCollisions;
		double bikePercent = 100.00 * bicycle / totalCollisions;
		double fireTruckPercent = 100.00 * fireTruck / totalCollisions;
		double ambulancePercent = 100.00 * ambulance / totalCollisions;
		
		
		// Format the percent to a String
		String taxiString = String.format("%6.2f", taxiPercent);
		String busString =  String.format("%6.2f", busPercent);
		String bikeString =  String.format("%6.2f", bikePercent);
		String fireTruckString =  String.format("%6.2f", fireTruckPercent);
		String ambulanceString =  String.format("%6.2f", ambulancePercent);

		vehicleTypes.append("\ttaxi\t\t" + taxiString + "%\n");
		vehicleTypes.append("\tbus\t\t" + busString + "%\n");
		vehicleTypes.append("\tbicycle\t\t" + bikeString + "%\n");
		vehicleTypes.append("\tfire truck\t" + fireTruckString + "%\n");
		vehicleTypes.append("\tambulance\t" + ambulanceString + "%\n");

		// Return the percentage of collisions involving certain vehicle types 
		// as a String.
		return vehicleTypes.toString();
	
}	
	/**
	 * This method iterates through all of the collision objects and 
	 * calculates the percentage of collisions involving
	 * specific contributing factors for either vehicle involved. 
	 * 
	 * @return percentage of collisions with specific contributing factors
	 * (unspecified cause, driver inattention/distraction, and fatigue/drowsiness)
	 */
	public String taskSix(){
		StringBuffer contributingFactors = new StringBuffer();
		
		// Initialize the specific contributing factors to zero. 
		int unspecifiedCause = 0;
		int distraction = 0;
		int tired = 0;
		int totalCollisions = collisionsList.size();
		
		// For each Collision object, check the contributing factors for the 
		// two vehicles involved, and add to the count for collisions involving
		// each contributing factor.
		for(Collision e: collisionsList){
			String contributingFactorOne = e.getContributingFactorVehicleOne();
			String contributingFactorTwo = e.getContributingFactorVehicleTwo();
			if(contributingFactorOne.equals("Unspecified") || contributingFactorTwo.equals("Unspecified"))
				unspecifiedCause++;
			if(contributingFactorOne.equals("Driver Inattention/Distraction") || contributingFactorTwo.equals("Driver Inattention/Distraction"))
				distraction++;
			if(contributingFactorOne.equals("Fatigued/Drowsy") || contributingFactorTwo.equals("Fatigued/Drowsy"))
				tired++;	
		}
		
		// Calculate the percent of collisions involving certain contributing factors.
		double percentUnspecifiedCause = 100.00 * unspecifiedCause / totalCollisions;
		double percentDistraction = 100.00 * distraction / totalCollisions;
		double percentTired = 100.00 * tired / totalCollisions;
		
		// Format the percent of collisions involving certain contributing factors to a String.
		String unspecifiedString = String.format("%6.2f", percentUnspecifiedCause);
		String distractionString = String.format("%6.2f", percentDistraction);
		String tiredString = String.format("%6.2f", percentTired);
		
		contributingFactors.append("Percentage of collisions involving certain contributing factors for vehicles:\n");
		contributingFactors.append("\tUnspecified\t\t\t\t" + unspecifiedString + "%\n");
		contributingFactors.append("\tDriver Inattention/Distraction\t\t" + distractionString + "%\n");
		contributingFactors.append("\tFatigued/Drowsy\t\t\t\t" + tiredString + "%\n");
		
		// Return the percent of collisions involving certain contributing factors, as a String.
		return contributingFactors.toString();
	}
}		

	
	
	
	









