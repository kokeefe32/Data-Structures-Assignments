/**
 * This class implements a generic binary search tree, with 
 * methods implemented recursively. 
 * 
 * @author Dayli/Joyce/Weems
 * @version Chapter 8
 *
 * @param <E> Any valid reference type
 */
public class BST <E extends Comparable<E>> implements BSTInterface<E>{
	protected BSTNode<E> root;
	boolean found;
	
	/**
	 * BST default constructor creates an empty
	 * binary search tree.
	 */
	public BST(){
		root = null;
	}

	
	/**
	 * BST constructor takes a valid reference type as a parameter
	 * and sets it to the root of this binary search tree.
	 * 
	 * @param n Object of valid reference type
	 */
	public BST(E n){
		super();
		BSTNode<E> node = new BSTNode<E>(n);
		this.root = node;
	}
	
	@Override
	public void insert(E item) {
		if(root == null)
			root=new BSTNode<E>(item);
		else
			root.insert(item);
		
	}

	@Override
	public void remove(E item) {
		root = recRemove(item, root);
		
	}
	
	/**
	 * Removes an element from the tree, if it exists.
	 * 
	 * @param item the item to be removed
	 * @param tree the tree from which the item is removed
	 * @return the tree after item is removed
	 */
	private BSTNode<E> recRemove(E item, BSTNode<E> tree){
		if(tree == null)
			found = false;
		else if(item.compareTo(tree.getData()) < 0)
			tree.setLeft(recRemove(item, tree.getLeft()));
		else if(item.compareTo(tree.getData()) > 0)
			tree.setRight(recRemove(item, tree.getRight()));
		else{
			tree = removeNode(tree);
			found = true;
		}
		return tree;
	}
	
	
	/**
	 * Removes a BSTNode from a binary search tree
	 * @param tree tree that BSTNode is removed from
	 * @return tree 
	 */
	private BSTNode<E> removeNode(BSTNode<E> tree){
		E data;
		if(tree.getLeft() == null)
			return tree.getRight();
		else if (tree.getRight() == null)
			return tree.getLeft();
		else{
			data = getPredecessor(tree.getLeft());
			tree.setData(data);
			tree.setLeft(recRemove(data, tree.getLeft()));
			return tree;
		}
	}
	
	/**
	 * Returns the predecessor object
	 * @param tree 
	 * @return data from tree
	 */
	private E getPredecessor(BSTNode<E> tree){
		while(tree.getRight() != null)
			tree = tree.getRight();
		return tree.getData();
	}

	@Override
	public boolean contains(E item) {
		return recContains(item, root);
	}
	
	/**
	 * Private helper method determines if a tree contains an item.
	 * @param item the item that is being checked
	 * @param tree the tree being searched
	 * @return true if tree contains the item, false otherwise
	 */
	private boolean recContains(E item, BSTNode<E> tree){
		if(tree == null)
			return false;	// element is not found
		else if (item.compareTo(tree.getData()) < 0)	
			return recContains(item, tree.getLeft());	// Search left subtree
		else if(item.compareTo(tree.getData()) > 0)
			return recContains(item, tree.getRight());
		else
			return true;
			
	}




	
	/**
	 * Adds element to this BST. The tree retains its BST property
	 * @param item the item to be added
	 */
	public void add(E item){
		root = recAdd(item, root);
	}
	
	/**
	 * Adds element to tree; tree retains its BST property.
	 * @param item the item to be added
	 * @param tree the tree in which the item is added
	 * @return tree after item is added
	 */
	private BSTNode<E> recAdd(E item, BSTNode<E> tree){
		if(tree == null)
			tree = new BSTNode<E>(item);
		else if(item.compareTo(tree.getData()) <= 0)
			tree.setLeft(recAdd(item, tree.getLeft()));
		else
			tree.setRight(recAdd(item, tree.getRight()));
		return tree;
	}
}