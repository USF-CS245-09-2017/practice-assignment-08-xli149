/* This is a class include binary search tree and inner class for binary search node.
 * @author chris Li
 */
public class BST<T>{
	public BSTNode root;
	/** Reccursive function for ind node in the tree.
	 * @param value: the node to be found
	 */
	public boolean find(Comparable value){
		return find(root, value);
	}
	// Override find
	private boolean find(BSTNode node, Comparable value){
		if(node == null){
			return false;
		}
		if(node.data.compareTo(value) == 0){
			return true;
		}
		else if(node.data.compareTo(value) < 0){
			return find(node.right, value);
		}
		else {
			return find(node.left, value);
		}
	}
	/** Recurrsivly find the position to insert a node to the tree
	 * @param value: the node to be inserted
	 */
	public void insert(Comparable value){
		root = insert(root, value);
	}
	// override methods for insert.
	private BSTNode insert(BSTNode node, Comparable value){
		if(node == null){
			BSTNode newNode = new BSTNode(value);
			return newNode;
		}
		else if(node.data.compareTo(value) < 0){
			node.right = insert(node.right, value);
		}
		else if(node.data.compareTo(value) > 0){
			node.left = insert(node.left, value);
		}
		return node;
	}
	// Recurssively function for printing the node
	public void print() {
		print(root);
	}
	// override method for print
	private void print(BSTNode node){
		if(node != null){
			print(node.left);
			System.out.println(node.data);
			print(node.right);
		}
	}

	/** Recurrsive function for finding the node and delete it
	 * @param data: the node that contains the data to be deleted
	 */
	public void delete(Comparable data) {
		root = delete(root, data);

	}
	// override method for delete function 
	private BSTNode delete(BSTNode node, Comparable value){
		if(node == null){
			return null;
		}
		if(node.data.compareTo(value) == 0){
			if(node.left == null){
				return node.right;
			}
		
			else if(node.right == null){
				return node.left;
			}
			else if(node.right.left == null){
				node.data = node.right.data;
				node.right = node.right.right;
				return node;
			}
			else{
				node.data = removeSmallest(node.right);
				return node;
			}
		}
		else if(node.data.compareTo(value) > 0){
			node.right = delete(node.left, value);
		}
		else{
			delete(node.right, value);
		}
		return node;
	}
	/** Function for finding the node that have the smallest value
	 * @param node: the node that contains data
	 */
	Comparable removeSmallest(BSTNode node){
		if(node.left.left == null){
			Comparable smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		else{
			return removeSmallest(node.left);
		}
	}
}














