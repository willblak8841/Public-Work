import java.lang.Integer;

public class Prog {

	public static void main(String [] args) {
		
		if (args.length != 2) {
			System.out.println("Please execute: java Prog <n> <p>");
			System.out.println("n is the input size, and p is the program number.");
			System.exit(0);
		}

		int n = Integer.parseInt(args[0]);
		int p = Integer.parseInt(args[1]);

		switch(p) {
			case 1: prog1(n);
							break;
			case 2: prog2(n);
							break;
			case 3: prog3(n);
							break;
			case 4: prog4(n);
							break;
			default: System.out.println("Invalid program number. Only 1-4.");
		}
	}

	private static  void prog1(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash1.	
		for(int v = 0; v < 100; v++){
			
			System.out.println(0 + v*n);
		}	
	}

	private static void prog3(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash2.	
		HashFunctions hash = new HashFunctions(n);
		int count = 0;
		int total = 0;
				

			
			int b = hash.hash3(0);
			
			for(int j = 0; j < n*n; j++){
				int e = hash.hash3(j);	
					if(b == e){
				
						System.out.println(j);
						total +=1;
					}
				if(total == n){
					break;
				}
			}
		
	}
	private static void prog2(int n) 
	{
		// TODO: Code to generate n keys that all get hashed to the same index using hash3.	
		for(int v = 0; v < n; v++){
			System.out.println(v);
		
		}
	}

	private static void prog4(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash4.
		HashFunctions hash = new HashFunctions(n);
		int count = 0;
		int total = 0;
			
		
			int b = hash.hash4(3);
			for(int j = 0; j < n*n; j++){
				int e = hash.hash4(j);
				if(b == e){
				
					System.out.println(j);
					total+= 1;
				}
				if(total == n){
				
				break;
				}
				
					
			}
		
				
	}

			
}

