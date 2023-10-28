/*
 * This class maintains a set of ints. 
 */
public class IntSet {
	private int [] set;		// An array to represernt the set. This is always maintained in sorted order.
	private int capacity;	// The maximum allocated memory for the set.// The number of elements currently stored in the set.
	private int size;		// The number of elements currently stored in the set.
	 Node head;

        static class Node {

                int data;
                Node next;


                Node(int d){
                        data = d;
                        next = null;
                }

}

        public  boolean find(int key) {

                boolean flag = false;
	if(head != null){
                Node finder = head;
                while(finder.next != null){
                        if(finder.data == key){
                                return  true;
                        }
                        finder = finder.next;

                }
	}
         return false;
}


        public  IntSet insert1( int data){

                if(!find(data)){
                        Node new_node = new Node(data);
                        new_node.next = null;

                        if(head==null){
                            head = new_node;

                        }else{
				
				
                               Node trav = head;
			       Node hold = head;
                               while(trav.next != null){
					if(trav.data > data){
					
					
                                        trav = trav.next;
					}else{
						while(hold.next!=trav){
							hold = hold.next;
						}
						new_node.next = trav;
						hold.next = new_node;
					}
                                }
                               
                        }
      		}
         return this;
}

	
	public IntSet() {
		size = 0;
		capacity = 10;
	}
	
	/* Find if a key is present in the set. Returns true if the key is present, otehrwise false.*/
	
	/* Insert a key into the set. */
	public void insert(int key) {
	insert1( key);	
}
	
	/* Remove a key from the set. */
	public void remove(int key) {
		if(find(key)){
			if(head.data == key && head.next != null){

				head = head.next;
				return;
			}
			if(head.data == key && head.next == null){
				
				head = null;
				return;
			}
		Node finder = head;
		Node holder = head;
			while(finder.data != key){
			finder = finder.next;
		
			}
		
			while(holder.next != finder){
			holder = holder.next;
		}	
	holder.next = finder.next;
	}
}

	/* Print the contents of the set in sorted order. */
	public void print() {
		
		Node printer = head;
		while(printer.next != null){
			System.out.print(printer.data + " ");
			printer = printer.next;
		}	
	}
}
