package circularlist;

/**
 * Class to test the circularlist package
 */
public class TestList {

	public static void main(String[] args) {
		// Create a CircularList of Strings
		CircularList<String> cl = new CircularListArrayBased<String>();
		CircularList<String> cl2 = new CircularListReferenceBased<String>();

		// Add elements
		cl.add("A");
		cl.add("B");
		cl.add("C");
		cl.add("D");
		cl.add("E");
		
		cl2.add("F");
		cl2.add("G");
		cl2.add("H");
		cl2.add("I");
		cl2.add("J");

		// Use the foreach loop to print out elements from the iterator
		System.out.println("Testing CircularListArrayBased:");
		System.out.print("{ ");
		int i = 1;
		for (String s : cl) {
			System.out.print(s + " ");
			if (i++ > 25)
				break;
		}
		System.out.println("}");

		System.out.println("\nTesting CircularListReferenceBased:");
		System.out.print("{ ");
		int j = 1;
		for (String s : cl2) {
			System.out.print(s + " ");
			if (j++ > 25)
				break;
		}
		System.out.println("}");
		
		// Test deletion of items
		
		// remove last Element from array based circular list
		String itmToRemove = cl.remove(cl.size() - 1);
		
		// reprint the data
		System.out.println(" \n\nTesting CircularListArrayBased for deletion of: " + itmToRemove );
		System.out.print("{ ");
		int k = 1;
		for (String s : cl) {
			System.out.print(s + " ");
			if (k++ > 25)
				break;
		}
		System.out.println("}");
		
		// remove last element from reference based circular list
		String itmToRemove2 = cl2.remove(cl2.size() - 1);
		
		System.out.println("\nTesting CircularListReferenceBased for deletion of: " + itmToRemove2);
		System.out.print("{ ");
		int l = 1;
		for (String s : cl2) {
			System.out.print(s + " ");
			if (l++ > 25)
				break;
		}
		System.out.println("}");
		
	}

}
