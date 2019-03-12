import java.util.Scanner;


/**
 * This class provides the methods for infix to 
 * postfix conversion and for postfix evaluation.
 * This class provides only tools.
 * 
 * @author Kayli O'Keefe
 * @version November 18, 2015
 *
 */
public class ExpressionTools {

	static MyStack<String> operatorStack = new MyStack<String>();

	/**
	 * This method takes an infix mathematical expression and
	 * converts it to a postfix expression. 
	 * 
	 * @param line infix string
	 * @return postfix expression as a string
	 * @throws PostFixException 
	 */
	public static String infixToPostfix(String line) throws PostFixException{
		StringBuffer postfix = new StringBuffer();

		String[] tokenArray = line.split(" ");
		for(String e: tokenArray){
			if(isNumber(e))
				postfix.append(e + " ");

			else if(e.equals("("))
				operatorStack.push(e);

			else if(isOperator(e)){
				if(!operatorStack.empty()){
					while(!operatorStack.empty() && !operatorStack.peek().equals("(") && lowerPrecedence(e, operatorStack.peek())){
						postfix.append(operatorStack.pop() + " ");
					}
				}
				operatorStack.push(e);
			}
			else if(e.equals(")")){
				while(!operatorStack.empty()){
					if (!operatorStack.peek().equals("("))
						postfix.append(operatorStack.pop() + " ");
					else{
						operatorStack.pop();
						break;
					}
				}
			}
			else{
				throw new PostFixException("Invalid Input.");
			}
		}
		while (!operatorStack.empty()){
			String t = operatorStack.pop();
			
			postfix.append(t+ " ");
		}
		return postfix.toString();
	}	
	

	/**
	 * PostFixEvaluator.java	
	 * Provides a postfix expression evaluation
	 * 
	 * @author Dale/Joyce/Weems
	 * @version PostFixEvaluator.java	Chapter 3
	 * 
	 * @param expression the postfix expression to be evaluated
	 * @return the result of the expressions
	 * @throws PostFixException if there is a stack underflow, stack overflow, or illegal symbol
	 */
	public static int evaluate(String expression) throws PostFixException {
		MyStack<Integer> stack = new MyStack<Integer>();

		int value;
		String operator;

		int operand1;
		int operand2;

		int result = 0;

		Scanner tokenizer = new Scanner(expression);

		while (tokenizer.hasNext()) {
			if (tokenizer.hasNextInt()) {
				// Process operand.
				value = tokenizer.nextInt();

				stack.push(value);
			} else {
				// Process operator.
				operator = tokenizer.next();

				// Obtain second operand from stack.
				if (stack.empty()) {
					tokenizer.close();
					throw new PostFixException(
							"Not enough operands - stack underflow");
				}
				operand2 = stack.peek();
				stack.pop();

				// Obtain first operand from stack.
				if (stack.empty()) {
					tokenizer.close();
					throw new PostFixException(
							"Not enough operands - stack underflow");
				}
				operand1 = stack.peek();
				stack.pop();

				// Perform operation.
				if (operator.equals("/"))
					result = operand1 / operand2;
				else if (operator.equals("*"))
					result = operand1 * operand2;
				else if (operator.equals("+"))
					result = operand1 + operand2;
				else if (operator.equals("-"))
					result = operand1 - operand2;
				else {
					tokenizer.close();
					throw new PostFixException("Illegal symbol: " + operator);
				}

				// Push result of operation onto stack.
				stack.push(result);
			}
		}

		tokenizer.close();

		// Obtain final result from stack.
		if (stack.empty())
			throw new PostFixException("Not enough operands - stack underflow");
		result = stack.peek();
		stack.pop();

		// Stack should now be empty.
		if (!stack.empty())
			throw new PostFixException("Too many operands - operands left over");

		// Return the final.
		return result;
	}







	/**
	 * This method determines whether one mathematical operator has
	 * a lower precedence than another mathematical operator. 
	 * 
	 * @param op1 operator 1
	 * @param op2 operator 2
	 * 
	 * @return true if operator 1 has lower precedence than operator 2,
	 * false if operator 1 has equal to or higher precedence than 
	 * operator 2
	 */
	public static boolean lowerPrecedence(String op1, String op2){
		switch(op1){
		case "+":
		case "-":
			return !(op2 == "+" || op2 == "-");
		case "*":
		case "/":
			return false;//!(op2 == "*" || op2 == "/");

		default:
			return false;
		}
	}


	/**
	 * This method determines whether a given string is a mathematical
	 * operator.
	 * 
	 * @param c string to be checked
	 * @return true if c is a mathematical operator, false otherwise.
	 */
	public static boolean isOperator(String c){
		return c.equals("+") || c.equals("-") || c.equals("*")|| c.equals("/");
	}


	/**
	 * This method determines whether a given string is 
	 * an can be parsed as an integer.
	 * 
	 * @param c string to be parsed
	 * @return true if c is an integer, false otherwise
	 */
	public static boolean isNumber(String c){
		try{
			Integer.parseInt(c);
			return true;
		} catch(Exception e){
			return false;
		}
	}




}
