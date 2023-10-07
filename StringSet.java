/**
 * This is a string set data structure, that is implemented as a Hash Table. 
 * This data structure supports operations insert, find and print - that insert a new 
 * String, finds a String key and prints the contents of the data structure resp.
 */
public class StringSet {

  StringNode [] table;	// Hash table - collisions resolved through chaining.
  int numelements;	// Number of elements actually stored in the structure.
  int size;					// Allocated memory (size of the hash table).

  /** 
   * Constructur: initilaizes numelements, size and initial table size.
   */
  public StringSet() {
    numelements = 0;
    size = 100;
    table = new StringNode[size];
  }

  /*
   * inserts a new key into the set. Inserts it at the head of the linked list given by its hash value.
   */
  public void insert(String key) {

    if (numelements == size) {
      //TODO: need to expand the hash table and rehash its contents. 
     size = size *2;
    StringNode[] table2 = new StringNode[size];
	for(int i = 0; i < table.length; i++){
		table2[i] = table[i];
	} 
	table = table2;
    }
    //TODO: Code for actual insert.
    if(!find(key)){
		
		int a = hash(key);
		table[a] = new StringNode(key, table[a]);
		numelements +=1;
	}
  }

  /*
   * finds if a String key is present in the data structure. Returns true if found, else false.
   */
  public boolean find(String key) {
    boolean flag = false;
    int l = hash(key);
	if(table[l] != null){
		StringNode check = table[l];
		while(!(check.getKey().equals(key))){
			if(check.getNext() == null){
				return flag;
			}
			check = check.getNext();
		}
		flag = true;
	}
    return flag;
	
  }

  /*
   * Prints the contents of the hash table.
   */
  public void print() {
    // TODO:
    for(int i = 0; i < size; i++){
	StringNode walk = table[i];
	while(walk.getNext() != null){
		System.out.print(walk.getKey());
		walk = walk.getNext();
	}		
		
	}
  }

  /*
   * The hash function that returns the index into the hash table for a string k.
   */
  private int hash(String k) {
    int h = 0;
    // TODO: Compute a polynomial hash function for the String k. Make sure that the hash value h returned is a proper index 
    // in the hash table, ie. in the range [0...capacity-1]. 
	char[] s = k.toCharArray();    	
	int n = s.length;
	for(int i=0;i < n; i++){
	
		h =( h * 67 + s[i]) % size;
	} 	
	return h;
  }

}
