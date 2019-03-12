/**
 * This generic class provides a reference based implementation of a
 * stack. 
 * 
 * @author Kayli O'Keefe
 * 
 * @version November 18, 2015
 *
 * @param <E> any valid reference type
 */
public class MyStack<E>{
	
	protected Node<E> header;
	
	/**
	 * Default constructor creates an empty stack
	 */
	public MyStack(){
		header = null;
	}
	
	
	/**
	 * This method tests to see if the stack is empty.
	 * 
	 * @return true if stack is empty, false otherwise
	 */
	public boolean empty() {
		if(header == null) return true;	
		return false;
	}

	
	/**
	 * This method removes the object at the top of this stack
	 * and returns that object as the value of this function.
	 * 
	 * @return object at the top of this stack
	 * @throws PostFixException if stack is empty
	 */
	public E pop() throws PostFixException{
		if(empty())
			throw new PostFixException("Invalid");
		E temp = header.getToken();
		header = header.getNext();
		return temp;
	}

	/**
	 * This method looks at the object at the top of this
	 * stack without removing it from the stack.
	 * 
	 * @return object at the top of this stack
	 * @throws PostFixException if stack is empty
	 */
	public E peek() throws PostFixException {
		if(empty())
			throw new PostFixException("Invalid");
		return header.token;
	}

	/**
	 * This method pushes an item onto the top of this
	 * stack. 
	 * 
	 * @param token the item that is pushed onto the top
	 * of this stack
	 */
	public void push(E token) {
		Node<E> temp = new Node<E>(token, header);
		header = temp;
	}

	/**
	 * This method returns the 1-based position where an
	 * object is on this stack.
	 * 
	 * @param o the object being searched for
	 * 
	 * @return the 1-based position where this object
	 * is on this stack, or -1 if the object is not on 
	 * this stack
	 */
	public int search(Object o) {
		int count = 1;
		if(empty()){
			return -1;
		}
		Node<E> temp = header;
		while(temp != null){
			if(temp.equals(o))
				return count;
			count++;
			temp = temp.getNext();
		}
		return -1;
		
	}
	
	/**
	 * This method returns a string representation of the stack.
	 */
	public String toString(){
		if(empty())
			return "{}";
		
		StringBuffer output = new StringBuffer("[");
		Node<E> temp = header;
		while(temp != null){
			output.append(temp.token + " ");
			temp = temp.next;
		}
		output.append("]");
		return output.toString();
	}
	
	

	
	
	
}


