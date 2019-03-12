
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This is a program that computes some information about the data posted by
 * OpenNYC regarding the collision records on the streets of NYC.  
 * 
 * @author Joanna K.
 * @author Kayli O'Keefe
 *
 */
public class CollisionInfo {

	/**
	 * The main method that starts the program. It is responsible for opening and reading the
	 * input file, creating the CollisionList object and using it compute the 
	 * predetermined results. 
	 * @param args the array should contain the name of the input file as the first element, 
	 * all other elements are ignored 
	 * @throws FileNotFoundException if the input file is corrupted or vanishes during the 
	 * execution of this program 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		final int NUM_OF_RUNS = 30;
		final int NUM_OF_ENTRIES = 21; 
		long startTimer, elapsedTime1, elapsedTime2; 
		long averageReadAndStoreTime = 0;
		long averageComputationTime = 0;
		long totalReadingStoringDataTime = 0;
		long totalComputationTime = 0;
		long totalRunTime = 0; 
		long averageRunTime = 0;
		Scanner fin;

		for(int i = 0; i < NUM_OF_RUNS; i++){



			startTimer = System.nanoTime();


			if (args.length < 1) {
				System.err.println("File name missing");
				System.exit(0);
			}

			File fileName = new File(args[0]);

			if (!fileName.canRead()) {
				System.err.printf("Cannot read from file %s\n.", fileName.getAbsolutePath());
				System.exit(0);
			}

			fin = new Scanner(fileName);

			CollisionList list = new CollisionList();

			while ( fin.hasNextLine() ) {

				String textLine = fin.nextLine(); 
				LinkedList<String> words = split(textLine);
				//ArrayList <String> words = split (textLine ) ;

				if (words.size() != NUM_OF_ENTRIES) {
					continue; //skip lines that are not complete
				}
				list.add(words);
			}
			elapsedTime1 = System.nanoTime() - startTimer; 

			totalReadingStoringDataTime += elapsedTime1;

			
			
			startTimer = System.nanoTime();
			//task 1 
			System.out.println("ZIP codes with the largest number of collisions:");
			System.out.println( list.getZipCodesWithMostCollisions( 3 ) );

			//task2
			System.out.println("ZIP codes with the fewest number of collisions:");
			System.out.println( list.getZipCodesWithLeastCollisions( 3 ) ); 

			//task 3
			System.out.println("ZIP codes with the most injuries and fatalities (combined):");
			System.out.println( list.getZipCodesWithMostPersonIncidents( 3 ) );

			//task 4
			System.out.println("ZIP codes with the most cyclist injuries and fatalities:");
			System.out.println( list.getZipCodesWithMostCyclistIncidents( 3 ) );

			//task5:
			System.out.println("Percentage of collisions involving certain vehicle type:");
			System.out.println(list.getVehicleTypeStats());

			//task6:
			System.out.println("Fraction of collisions by hour:");
			System.out.println(list.getHourlyStats());

			elapsedTime2 =  System.nanoTime() - startTimer; 
			totalComputationTime += elapsedTime2;

			fin.close();
		}

		totalRunTime = totalReadingStoringDataTime + totalComputationTime;
		averageReadAndStoreTime = totalReadingStoringDataTime / NUM_OF_RUNS;
		averageComputationTime = totalComputationTime / NUM_OF_RUNS;
		
		averageRunTime = totalRunTime / NUM_OF_RUNS;
		
		System.out.println("\n\n============================================\n");
		System.out.printf("Average time reading and storing data: %,15d nanoseconds\n", averageReadAndStoreTime);
		System.out.printf("Average time for computation of results  : %,15d nanoseconds\n", averageComputationTime);
		System.out.printf("Average time for total program completion: %,15d nanoseconds\n", averageRunTime);

	}


	/**
	 * Splits a given line according to commas (commas within entries are ignored) 
	 * @param textLine line of text to be parsed 
	 * @return an ArrayList object containing all individual entries/tokens
	 * found on the line. 
	 */
	public static LinkedList<String> split (String textLine ) {
		LinkedList<String> entries = new LinkedList<String>();
		int lineLength = textLine.length();
		StringBuffer nextWord = new StringBuffer(); 
		char nextChar;
		boolean insideQuotes = false;

		for(int i = 0; i < lineLength; i++ ) {
			nextChar = textLine.charAt(i); 
			//add character to the current entry 
			if ( nextChar != ',' && nextChar != '"' ) {
				nextWord.append( nextChar );
			}
			//double quote found, decide if it is opening or closing one
			else if (nextChar == '"' ) {
				if ( insideQuotes ) {
					insideQuotes = false;
				}
				else {
					insideQuotes = true;
				}
			}
			//found comma inside double quotes, just add it to the string
			else if (nextChar == ',' && insideQuotes) {
				nextWord.append( nextChar );
			}
			//end of the current entry reached, add it to the list of entries
			//and reset the nextWord to empty string
			else if (nextChar == ',' && !insideQuotes) {
				//trim the white space before adding to the list
				entries.add( nextWord.toString().trim() );

				nextWord = new StringBuffer();
			}

			else {
				System.err.println("This should never be printed.\n");
			}
		}
		//add the last word
		//trim the white space before adding to the list
		entries.add( nextWord.toString().trim() );

		return entries; 
	}


}
