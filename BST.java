
public class BST {
	private Node root; // The root node of the tree.
	public static void main(String[] args) {
		BST tree = new BST();
		tree.insert(17, 0);
		tree.insert(4, 0);
		tree.insert(2, 0);
		tree.insert(-1, 0);
		tree.insert(8, 0);
		tree.insert(12, 0);
		tree.insert(6, 0);
		tree.insert(11, 0);
		tree.insert(15, 0);
		tree.insert(20, 0);
		tree.insert(25, 0);
		tree.insert(21, 0);
		tree.insert(23, 0);
		print(tree.root);
		System.out.println();
		System.out.print(tree.succ(3));
	}
	public BST() {
		root = null;
	}

	/**
		Inserts a time, along with the req_id. The tree is keyed on time, while req_id provides a pointer to the request.
		This is a public wrapper function that calls the recursive insert method.
		Note that the insert method should return the root node of the subtree in which we insert the key (and its value).
	**/
	public void insert(int time, int req_index) {
		// TODO: Code for insert here.
		Node in = root;
		if(root == null) {
			root = new Node(time, req_index);
			in = root;
		}
		insert2(in, time, req_index);
		
	}
	private Node insert2(Node in, int time, int req_index) {   
		if(root == null) {									
			root = new Node(time, req_index);	
		}
		if(in.getTime() == time) {
			return in;
		}

		if(in.getTime() > time && in.getLeft()==null) {
			Node child = new Node(time, req_index);
			in.setLeft(child);
			return in;
		}
		if(in.getTime() > time) {
			in = in.getLeft();
			return insert2(in, time, req_index);
		}
		if(in.getTime() < time && in.getRight()==null) {
			Node child = new Node(time, req_index);
			in.setRight(child);
			return in;
		}
		if(in.getTime() < time) {
			in = in.getRight();
			return insert2(in, time, req_index);
		}
		return null;
	}
	/**
		Returns a pointer to the Node that is the predecessor of time. The predecessor element is the largest
		element within the tree that is smaller or equal to time. This is the deepest ancestor with this property.
		Please return the predecessor element. You may return null if time does not have a predecessor.
	**/
	public Node pred(int time) {
		// TODO: code for pred here.
		Node find = root;
		Node find2 = find;
	
		if(find == null) {
			return null;
		}

		if(root.getLeft() == null && root.getTime() > time) {
			return root;
		}
		if(root.getLeft()==null && root.getTime() < time) {
			return null;
		}
		/////////////////////////////////////////////////////////
		
		while((find.getTime() != time) ) {
				
			if(find.getTime() > time) {
				find = find.getLeft();
			}
			else {
				find = find.getRight();
			}
			if(find.getRight() == null && find.getLeft()== null) {
				break;
			}
		}
		if(find.getLeft() != null) {
			find = find.getLeft();
		
			while(find.getRight() != null) {
			find = find.getRight();
			
		}
		return find;
		}
		
		// pre cursor finder
		Node low = find2;
		while(find2.getLeft() != find && find2.getRight() != find) {
			
			if(find2.getTime() == time) {
				if(find2.getLeft() != null) {
					find2 = find2.getLeft();
				}
				while(find2.getLeft() != null) {
					find2 = find2.getLeft();
					
				}
				return find2;
			}
				
			if(find2.getTime() > time) {
				find2 = find2.getLeft();
			}
			else {
				find2 = find2.getRight();
			}
			if(low.getTime() > find2.getTime()) {
				low = find2;
			}
		}
		//edge cases
		
		if(find2 == find) {
			return(pred(time - 1));
		}
		if(find2.getRight() == find) {
			return find2;
		}
		if(find2.getTime() > find.getTime()) {
			return null;
		}
	
		
		return low; // Replace this line with returning the actual predecessor.
	}

	/**
		Returns a pointer to the Node that is the successor of time. The successor element is the largest
		element within the tree that is larger or equal to time. This is the deepest ancestor with this property.
		Please return the successor element. You may return null if time does not have a successor.
	**/
	public Node succ(int time) {
		// TODO: code for succ here.
		Node find = root;
		Node find2 = root;
		
		if(find == null) {
			return null;
		}
		if(find.getTime() == time) {
			find = find.getRight();
			while(find.getLeft() != null) {
				find = find.getLeft();
			}
			return find;
		}
		//
		

		////////////////////////////////////////////////////
		while((find.getTime() != time) ) {
			
			if(find.getTime() > time) {
				find = find.getLeft();
			}
			else {
				find = find.getRight();
			}
			if(find.getRight() == null && find.getLeft()== null) {
				
				break;
			}
		}
		if(find.getRight() != null) {
			find = find.getRight();
		
			while(find.getLeft() != null) {
			find = find.getLeft();
			}
		return find;
			
		}
		///////////////////////////////////////////////////////
		Node low = find2;
		while(find2 != find) {
			
			if(find2.getTime() == time) {
				if(find2.getLeft() != null) {
					find2 = find2.getLeft();
				}
				while(find2.getLeft() != null) {
					find2 = find2.getLeft();
					
				}
				return find2;
			}
			if(find2.getTime() > time) {
				find2 = find2.getLeft();
			}
			else {
				find2 = find2.getRight();
			}
			if(time < root.getTime()) {
				
			
			if(low.getTime() > find2.getTime()) {
				if(find2.getTime() > time)
				low = find2;
			}
		}else {
			if(find2.getTime() > time)
				low = find2;
			}
		}
		if(this.max().getTime() == time) {
			return null;
		}
		return low;
		
		 // Replace this line with returning the actual successor.
	}

	/**
		Returns the minimum element in the binary search tree or null if the tree is empty.
	**/
	public Node min() {
		// TODO: Code for min here.
		Node min = root;
		while(min.getLeft() != null) {
			min = min.getLeft();
		}
		return min; // Replace this line with returning the actual minimum.
	}

	/**
		Returns the maximum element in the binary search tree or null if the tree is empty.
	**/
	public Node max() {
		// TODO: Code for max here.
		Node max = root;
		while(max.getRight() != null) {
			max = max.getRight();
		}
		return max; // Replace this line with returning the actual maximum.
	}

	/**
		Remove the node that contains this time. If this time is not present in the structure, this method does nothing.
	**/
	public void delete(int time) {
		// TODO: Code for delete here.
		Node find = root;
		Node find2 = root;
		if(find == null) {
			System.out.print("Nothing here");
			return;
		}
		if(root.getTime() == time) {
			if(root.getLeft() == null && root.getRight() == null) {
				root = null;
				return;
			}
			Node a = pred(root.getTime());
			delete(a.getTime());
			root.setTime(a.getTime());
		}
	while(find.getTime() != time) {
			
			
		if(find.getTime() > time) {
			find = find.getLeft();
		}
		else {
			find = find.getRight();
		}
		}
	while(find2.getLeft() != find && find2.getRight() != find) {
		
		
		if(find2.getTime() > time) {
			find2 = find2.getLeft();
		}
		else {
			find2 = find2.getRight();
		}
	}
		if(find.getLeft() == null && find.getRight() == null) {
			if(find2.getLeft() == find) {
				find2.setLeft(null);
			}
			else {
				find2.setRight(null);
			}
		}
	}

	/**
		Prints the contents of the tree in sorted order.
	**/
	public static void print(Node root) {
		// TODO: Code for print here.
		if(root == null)
			return;
		print(root.getLeft());
		System.out.print(root.getTime() + " ");
		print(root.getRight());
	}


}
