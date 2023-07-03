import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class FiniteStateMachine {
 private final static int[][] STATE_TABLE = {
		 { 3, 1, 4 },//0
		 { 0, 2, 4 },//1
		 { 1, 3, 4 },//2
		 { 2, 0, 4 },//3
		 { 4, 4, 4 },//trap
 	};
 private BufferedReader in;
 public FiniteStateMachine() {
	 in = new BufferedReader(
	new InputStreamReader(System.in));
 	}
 public void run() throws IOException {
	 char ch;
	 int state;
	 for (;;) {
		 System.out.print("Enter your string: ");
		 
		 ch = (char) in.read();
 // set state to start state
		 state = 0;
		 
		 while (ch != '\n') {
			 state = STATE_TABLE[state][charToColumn(ch)];
			 System.out.print(state);
			 ch = (char) in.read();
			
		 }
 // determine whether to accept or reject
		 if ( state == 0 ) {
			 System.out.println("Accept\n");
		 					}
		 else {
			 System.out.println("Reject\n");
		 		}
	 	}
	 
 	}
 	public int charToColumn(char ch) {
 // column 2 is for some unexpected character
 			int column = 2;
 			switch( ch ) {
 			case 'a':
 				column = 0;
 				break;
 			case 'b':
 				column = 1;
 				break;
 		}
 		return column;
 }
 public static void main(String[] args) {
	 try {
		 FiniteStateMachine fsm = new FiniteStateMachine();
		 fsm.run();
 } catch (IOException ex) {
	 ex.printStackTrace();
	 System.exit(1);
 }
 }
}
