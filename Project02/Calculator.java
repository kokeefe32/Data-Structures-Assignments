import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * This class is the runnable program containing the main() method.
 * This class is responsible for all input and output operations.
 * This input file is read by this class, and this class
 * writes the results to the output file.
 * 
 *  @author Kayli O'Keefe
 *  @version November 18, 2015
 */
public class Calculator {

	public static void main(String[] args) throws FileNotFoundException, IOException, PostFixException{
		File inputFile = null;
		File outputFile = null;

		//Check if 2 command line arguments were given. If not
		// print an error message and exit the program.
		if (args.length == 0){
			System.err.println("Error: missing name of the input file");
			System.exit(0);
		}
		else if(args.length < 2){
			System.err.println("Error: missing name of the output file");
			System.exit(0);
		}

		else if(args.length == 2){
			// Initialize input file
			inputFile = new File(args[0]);

			// Initialize output file
			outputFile = new File(args[1]);
		}

		System.out.println(inputFile);
		System.out.println(outputFile);

		// Check if inputFile exists. If not, print an error message
		// and exit the program
		if(!inputFile.exists()){
			System.err.print(args[0].toString() + " does not exist");
			System.exit(0);
		}

		// Check if file is readable. If not, print 
		// an error message and exit the program.
		if (!inputFile.canRead()){
			System.err.printf("Error: Cannot read from the file %s\n.",inputFile.getAbsolutePath());
			System.exit(0);
		}

		// Create or overwrite output file
		FileWriter fWriter = new FileWriter(outputFile);
		PrintWriter pWriter = new PrintWriter(fWriter);

		// Check to see if output file can be written to.
		// If not, print an error message and exit the program.
		if(!outputFile.canWrite()){
			System.err.println("Error: file " + args[1].toString() + " could not be created.");
		}

		Scanner readFile = new Scanner(inputFile);
		String textLine = null; // Infix string which goes to postfix
		String postFix = null; // Postfix string to be evaluated
		int result; // result of the evaluation
		do{
			// Get next expression to be processed.
			textLine = readFile.nextLine();
			
			// Obtain and output the result of expression evaluation. 
			try{
					// Convert infix to postfix string.
					postFix = ExpressionTools.infixToPostfix(textLine);
					// Evaluate postfix 
					result = ExpressionTools.evaluate(postFix);
					// Write result to output file.
					pWriter.println(result);
				

			}catch(PostFixException e){
				pWriter.println("INVALID");
				
			}catch(ArithmeticException e){
				pWriter.println("INVALID");
			}
			
	
		}while(readFile.hasNextLine());

		pWriter.close();
		readFile.close();

	}
}











