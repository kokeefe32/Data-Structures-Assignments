
/**
 * This class defines a generic linked list node which stores
 * a token of type E and a reference to the next token.
 *  
 * @author Kayli O'Keefe
 * @version November 18, 2015
 *
 * @param <E> any valid reference type
 */
public class Node<E>{
	
		public Node<E> next;
		public E token;
		
		/**
		 * Default constructor creates an empty node
		 */
		public Node(){
			token = null;
			next = null;
		}
		
		/**
		 * Creates a node with a specified token
		 * @param token item to be stored in the node
		 */
		public Node(E token){
			this.token = token;
		}
		
		/**
		 * Creates a node with a specified token
		 * and a reference to the next
		 * 
		 * @param token stored in the node
		 * @param next reference to the next node
		 */
		public Node(E token, Node<E> next){
			if(token != null)
				this.token = token;
			if(next != null)
				this.next = next;
		}
		
		/**
		 * This method returns the token stored in the node
		 * @return token stored in the node
		 */
		public E getToken(){
			return token;
		}
		
		/**
		 * This method returns the next token stored in the node.
		 * 
		 * @return next token
		 */
		public Node<E> getNext(){
			return next;
		}
		
		/**
		 * This method sets the token.
		 * 
		 * @param newToken sets token to this token
		 */
		public void setToken(E newToken){
			token = newToken;
		}
		
		/**
		 * This method sets the next token.
		 * 
		 * @param next the next token to set
		 */
		public void setNextToken(Node<E> next){
			this.next=next;
		}
		
		/**
		 * This method returns the Node to a string
		 */
		public String toString(){
			return token.toString();
		}
		
		
	}