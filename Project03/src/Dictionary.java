import java.util.ArrayList;

/**
 * The class represent a dictionary of words. 
 * It provides a way of searching through the dictionary.
 * It also can produce a dictionary in which the words are limited
 * to a particular length. 
 * 
 * @author Kayli O'Keefe
 * @version 12/02/15
 *
 */
public class Dictionary extends BST<String> implements DictionaryInterface{
	//actual storage for the words
	
	ArrayList<String> listOfWords = new ArrayList<String>();
	
	
	/**
	 * Creates an empty Dictionary object (no words).
	 */
	public Dictionary ( ) {
	
	}
	
	/**
	 * Creates a Dictionary object containing all words from the 
	 * listOfWords passed as a parameter.
	 * 
	 * @param listOfWords the list of words to be stored in the newly created 
	 * Dictionary object
	 */
	public Dictionary ( ArrayList<String> listOfWords ) {			
		populateBinarySearchTree(listOfWords, 0, listOfWords.size()-1);
	}
	
	
	/**
	 * Creates a binary search tree from an ArrayList of words
	 * 
	 * @param listOfWords words in the dictionary file
	 * @param low start
	 * @param high end
	 */
	public void populateBinarySearchTree(ArrayList<String> listOfWords, int low, int high){
		if(low <= high){
			int mid = (low+high) / 2;
			insert(listOfWords.get(mid));	
			populateBinarySearchTree(listOfWords, low, mid-1);
			populateBinarySearchTree(listOfWords, mid+1, high);
			
		}	
	}
		
			
	
	

	 
	/**
	 * Performs (binary) search in this Dictionary object for a given word.
	 * @param word  the word to look for in this Dictionary object. 
	 * @return true if the word is in this Dictionary object, false otherwise
	 */
	public boolean findWord ( String word ) {
		// call contains
		return contains( word );
	}
	
	
	
	/**
	 * Performs (binary) search in this Dictionary object for a given prefix.
	 * @param prefix  the prefix to look for in this Dictionary object. 
	 * @return true if at least one word with the specified prefix exists 
	 * in this Dictionary object, false otherwise
	 */
	public boolean findPrefix (String prefix ) {
		return containsPrefixRec (prefix, root );
	}

	/*
	 * The actual method providing recursive implementation of the binary search
	 * for the prefix. 
	 * @param prefix the prefix to look for in this Dictionary object.
	 * @param begin start of the range for the current iteration
	 * @param end end of the range for the current iteration
	 * @return true if at least one word with the specified prefix exists 
	 * in this Dictionary object, false otherwise
	 */
	private boolean containsPrefixRec(String prefix, BSTNode<String> tree){
		if(tree == null)
			return false;	// element is not found
		else if (prefix.compareTo(tree.getData()) < 0){
			if(tree.getData().startsWith(prefix))
				return true;
			return containsPrefixRec(prefix, tree.getLeft());	// Search left subtree

		}
		else if (prefix.compareTo(tree.getData()) > 0){
			if(tree.getData().startsWith(prefix))
				return true;
			return containsPrefixRec(prefix, tree.getRight());	// Search right subtree
		}
		else
			return true;
	}
	
	
}
