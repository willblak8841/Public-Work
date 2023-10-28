import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;





public class CandyCollector {
static Scanner sk;
static int size;
static Node[] list;
	static class Node {

		double x;
		double y;
		Node next;


		Node(double keyx, Node nextx){
            x = keyx;
            next = nextx;
           
		}
    
		public boolean hasNext()
		{
			if(this.next == null) {
				return false;
			}
			return true;
		}
	}

	
	public static void main(String [] args) {
   		
 	   File f = new File("candycollector.in1");
 	    
 	    try {
 	      sk = new Scanner(f);
 	      int types = sk.nextInt();
 	      size = sk.nextInt();
 	      list = new Node[size];
 	      while(sk.hasNext()) {
 	    	  insert(sk.nextInt());
 	    	  
 	      }
 	     
 	      counter(types, size);
 	      
 	    }	catch (FileNotFoundException e) {
	        System.out.println("Cannot open file " + f.getAbsolutePath());
	        System.out.println(e);
	      } 
	}
	public static void insert(int keyx) {
    	
		int b = hash(keyx);
		
		list[b] = new Node(keyx, list[b]);  
		
	
	}
	public static boolean find(int key) {
		int bob = hash(key);
		Node sam = list[bob];
		if(sam != null) {
			while(sam != null) {
				if(list[bob].x == key) {
					return true;
				}
				sam = sam.next;
			}
		}
		return false;
		
	}
	public static void counter(int types, int size) {
		boolean flag = true;
		int miss = 0;
		for(int i = 1; i <= types; i++) {
			if(!find(i)) {
				flag = false;
				miss +=1;
			}
		}
			if(flag == true) {
				System.out.println("Yay! all " + types +
						" type(s) of candies collected.");
			}
			else {
				System.out.println("Missing "+miss+" type(s) of candy.");
			}
		
		
		
	}
	
	public static int hash(int key) {
		int hash = 0;
		hash = (hash * 67 + key) % size;
		return hash;
	}
}