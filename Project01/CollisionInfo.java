
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * This class is the runnable program containing the main() method.
 * This class is responsible for parsing the command line argument, 
 * reading the input file, created the CollisionList object based
 * on the input file, calling all the methods of the CollisionList
 * object needed for completion of each task, and writing to the
 * output file. 
 * 
 * @author Kayli O'Keefe
 * @version 10/02/15
 *
 */
public class CollisionInfo {
	
	/**
	 * This is the main method, which reads the input file,
	 * calls on the methods to execute each task, and writes
	 * to the output file
	 * 
	 * @param args command line argument
	 * 
	 * @throws FileNotFoundException if the input file cannot be found
	 * @throws IOException if the output file cannt be written to
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException{
		// Initialize input file
		File inputFile = new File(args[0]);
		
		// Initialize the name of the output file, based on the input file. 
		String outputFileName = args[0].replaceFirst("csv", "out");
		
		// Check to see if command line argument was given. If not,
		// print an error message and exit the program. 
		if (args.length < 1){
			System.err.println("Error: File name missing.");
			System.exit(0);
		}

		// Check to see if file is readable. If not, print
		// an error message and exit the program.
		if (!inputFile.canRead()){
			System.err.printf("Error: Cannot read from the file %s\n.",inputFile.getAbsolutePath());
			System.exit(0);
		}
		
		// Read the file.
		Scanner readFile = new Scanner(inputFile);
		readFile.nextLine();

		// Skip line if not all entries are valid
		boolean skipLine;
		
		// Create CollisionList object
		CollisionList collisions = new CollisionList();
		
		// Parse the input file, and create a Collision object based
		// on the entries in each line of the file. 
		while(readFile.hasNextLine()) {
			skipLine = false;
			String textLine = readFile.nextLine();
			ArrayList<String> list = split(textLine);

			if(list.size() == 21){
				for(String e: list){
					if(e.length() == 0)
						skipLine = true;
				}
				if(skipLine)
					continue;

				try{
					collisions.add(new Collision(list));

				} catch(IllegalArgumentException ex){
					continue;
				}
			}
		}
		
		// Call the methods for each task
		String taskOneAndTwo = collisions.taskOneAndTwo() + "\n";
		String taskThree = collisions.taskThree() + "\n";
		String taskFour = collisions.taskFour() + "\n";
		String taskFive = collisions.taskFive() + "\n";
		String taskSix = collisions.taskSix();
		
		// Create output file
		File outFile = new File(outputFileName);
		FileWriter fWriter = new FileWriter(outFile);
		PrintWriter pWriter = new PrintWriter(fWriter);
		
		// Check to see if the output file can be written to. 
		// If not, print and error message and exit the program.
		if(!outFile.canWrite()){
			System.err.println("Error: cannot create file " + outputFileName);
			System.exit(0);
		}
		
		// Write to the output file
		pWriter.print(taskOneAndTwo);
		pWriter.print(taskThree);
		pWriter.print(taskFour);
		pWriter.print(taskFive);
		pWriter.print(taskSix);
		
		// Close the input file
		readFile.close();
		
		// Close the output file
		fWriter.close();
		
		System.exit(0);


	}
	
	
	/**
	 * This method splits a given line according to commas 
	 * (commas within entries are ignored).
	 * 
	 * @param textLine line of text to be parsed
	 * @return an ArrayList object containing all individual entries/tokens
	 * found on the line.
	 */
	public static ArrayList<String> split(String textLine){
		ArrayList<String> entries = new ArrayList<String>();
		int lineLength = textLine.length();
		StringBuffer nextWord = new StringBuffer();
		char nextChar;
		boolean insideQuotes = false;
		
		for (int i = 0; i < lineLength; i++) {
			nextChar = textLine.charAt(i);
			//add character to the current entry
			if(nextChar != ',' && nextChar != '"')
				nextWord.append(nextChar);
			else if(nextChar == '"'){
				if(insideQuotes)
					insideQuotes = false;
				else
					insideQuotes = true;
			}
			
			// found comma inside double quotes, just add it to the string
			else if(nextChar == ',' && insideQuotes){
				nextWord.append(nextChar);
			}
			//trim the white space before adding to the list
				
			else if(nextChar == ',' && !insideQuotes){
			entries.add(nextWord.toString().trim());
			nextWord = new StringBuffer();
			}
		}
		// add the last word
		// trim the white space before adding to the list
		entries.add(nextWord.toString().trim());
			
		return entries;
	}
	
}
