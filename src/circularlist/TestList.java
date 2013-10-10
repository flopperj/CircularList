package circularlist;

/**
 * Class to test the circularlist package
 */
public class TestList {

    public static void main(String [] args)
    {
	// Create a CircularList of Strings
	CircularList<String> cl = new CircularListArrayBased<String>();
	
	// Add elements
	cl.add("A"); cl.add("B"); cl.add("C"); cl.add("D"); cl.add("E"); 
	
	// Use the foreach loop to print out elements from the iterator
	System.out.print("{ ");
	int i = 1;
	for(String s : cl) {
	    System.out.print(s + " ");
	    if(i++ > 25)
		break;
	}
	System.out.println("}");	
    }
	
}
