import java.util.Scanner;
import java.io.*;

/*
 * This class implements a spell checker application. 
 * This class requires a proper implementation to the StirngSet class.
 */
public class SpellChecker {

  public static void main(String [] args) {

    File f = new File("dictionary");
    
    try {
      Scanner sk = new Scanner(f);
        
      StringSet x = new StringSet();
    
      // Read in the entire dictionary...
      while (sk.hasNext()) {
        String word = sk.next();
        x.insert(word);      
      }
      System.out.println("Dicitonary loaded...");
     
      sk = new Scanner(System.in);
      
      // Keep suggesting alternatives as long as the user makes an input.
      while (sk.hasNext()) {
        String word = sk.next();
	StringBuilder set = new StringBuilder(word);
        if (x.find(word))
	  			System.out.println(word + " is correct.");
        else {
	  			System.out.println("Suggesting alternatives ...");
				StringBuilder str = new StringBuilder(word);
          // TODO: Code to do the spell checker. Look into the StringSet for all possible alternatives of the input word mis-spelled by one character.
				for(int i =0; i < str.length(); i++){
					str = set;
					for(char j = 'a'; j <= 'z'; j++){
						str.setCharAt(i,j);
						if(x.find(str.toString())){
							System.out.println(str.toString());
						}
					}	
				}		
	}
      }
			
    } catch (FileNotFoundException e) {
      System.out.println("Cannot open file " + f.getAbsolutePath());
      System.out.println(e);
    } 
  } 
}
