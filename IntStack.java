
public class IntStack {
	// May create private data here.
	Node head;
        static class Node {

                int data;
                Node next;


                Node(int d){
                        data = d;
                        next = null;
                }

}

		// TODO: Code to initialize your stack.
	
	public IntStack(){		
			
	}
	public void push(int x) {
		// TODO: Code to push an item x onto the stack. The stack wlil never contain more than 100 elements.
		Node m = new Node(x);
		if(head != null){
		m.next = head;
		}
		head = m;
	}

	public int pop() {
		// TODO: Code to pop and retrun an item from the top of the stack. If the stack is empty, return -1.
		if(head == null){
			return -1;
		}		
		 int a = head.data;
		head = head.next;
		return a;
	}
	public int peek(){
			
		int pe = this.pop();
		if(pe == -1){
			return pe;
		}
		this.push(pe);
		return pe;
	}
}
