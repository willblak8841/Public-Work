import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class HorrorPlaylist {

static int[] playlist;
	
	
	public static void main(String [] args) {
   		
    	   File f = new File("horrorplaylist.in1");
    	    
    	    try {
    	      Scanner sk = new Scanner(f);
    	      int size = sk.nextInt();
    	      
    	      playlist = new int[size];
    	      int types = sk.nextInt();
    	      
    	      	for(int i = 0; i < size; i++) {
    	    	  	int add = sk.nextInt();
    	    	  	playlist[i] = add;
    	    	  	
    	    	  	
    	      	}
    	      	
    	      String order = "";
    	      for(int j = 0; j < types; j++) {
    	    	  order += Integer.toString(sk.nextInt());
    	      }
    	     
    	      int h = clicks(size, types, order);
    	      System.out.print(h);	
    	    } catch (FileNotFoundException e) {
    	        System.out.println("Cannot open file " + f.getAbsolutePath());
    	        System.out.println(e);
    	      } 
    }
	public static int clicks(int n, int k, String order) {
		int h = 0;
		int e = order.length();
		for(int j = 0; j < e; j++) {
			int current = order.charAt(j) - 48;
			boolean ntc = true;
			for(int i = 0; i < playlist.length; i ++) {
				
				if(playlist[i] != 0) {
					if(playlist[i] == (int)current) {
						playlist[i] = 0;
						if(ntc) {
							h += 1;
							ntc = false;
						}
					}
					if(playlist[i] != current && playlist[i] != 0) {
						ntc = true;
					}
				
				}
			}
		}
		
		return h;
	}
}
