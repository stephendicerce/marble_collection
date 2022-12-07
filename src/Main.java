/**
 * A main class to test the marble sorting algorithm.
 *
 * written by Stephen DiCerce
 */

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
	ArrayList<Marble> marbleList = new ArrayList<>();

	//Simple arraylist to test alorithm
	marbleList.add(new Marble(1, "blue", "Bob", new BigDecimal(0.5)));
	marbleList.add(new Marble(2, "red", "John Smith", new BigDecimal(0.25)));
	marbleList.add(new Marble(3, "violet", "Bob O'Bob", new BigDecimal(0.5)));
	marbleList.add(new Marble(4, "indigo", "Bob Dad-Bob", new BigDecimal(0.75)));
	marbleList.add(new Marble(5, "yellow", "John", new BigDecimal(0.5)));
	marbleList.add(new Marble(6, "orange", "Bob", new BigDecimal(0.25)));
	marbleList.add(new Marble(7, "blue", "Smith", new BigDecimal(0.5)));
	marbleList.add(new Marble(8, "blue", "Bob", new BigDecimal(0.25)));
	marbleList.add(new Marble(9, "green", "Bobb Ob", new BigDecimal(0.75)));
	marbleList.add(new Marble(10, "blue", "Bob", new BigDecimal(0.5)));
	marbleList.add(new Marble(10, "red", "Te sts', Et", new BigDecimal(0.5)));
	
	marbleList = Marble.sortMarbleCollection(marbleList, new BigDecimal(0.5)); // run the algorithm

	// print the sorted results
	if(marbleList != null && marbleList.size() > 0) {
	    for(int i=0; i<marbleList.size(); i++) {
		System.out.println(marbleList.get(i).toString());
	    }
	}
    }
}
