/**
 * A marble object class written by Stephen DiCerce.
 */

import java.math.BigDecimal;
import java.util.ArrayList;

public class Marble implements Comparable<Marble>{
    /*
     * To answer the questions not answered in the comments and documention
     * below this section has been added as a reference.
     *
     * The time and space complexity of the quick sort algorithm implemented
     * below is answered in the method's documentation before the method itself
     *
     * Deployment Strategy: My deployment strategy would be to set up a RESTful
     * service that would take in a JSON payload containing the marble information
     * to be sorted. Depending on the size of the marble collection, more than one 
     * payload may be needed. If the marble collection is too large to adequately
     * send in one JSON payload, the collection would need to be split into
     * multiple payloads to be retrieved server side once completed to be sorted
     * all together.
     *
     * Technologies: Based on my previous experience I would wrap this functionality
     * in one of the Java based frameworks I am most familiar with - Grails, or Struts 2.
     * Both are probably overkill for the implementation but I can at least be confident
     * That in the case that the functionality would need to be scaled up, these could handle
     * the uptick.
     *
     * Automation Strategies: I do have admittedly a lack of experience in this area, but
     * with what I do have I would set up unit tests as well as regression tests for all
     * integral components of the solution as well as utilize an automation testing tool
     * depending on the budget for the project. Better testing and automation strategies
     * are areas I'm looking forward to gaining more experience in.
     *
     * Large scale Collection: If Bob had an extremely large collection of marbles, I would
     * alter my algorithm to become an external sorting algorithm. Dynamically loading and
     * writing the iterations to/from temporary files that could be loaded into memory for sorting.
     * Depending on the amount of processing power I would be able to utilize, I would also consider
     * sorting partions in parallel to decrease the amount of time needed.
     */


    //giving value to the colors for camparative reasons
    public static final int COLOR_RED = 1;
    public static final int COLOR_ORANGE = 2;
    public static final int COLOR_YELLOW = 3;
    public static final int COLOR_GREEN = 4;
    public static final int COLOR_BLUE = 5;
    public static final int COLOR_INDIGO = 6;
    public static final int COLOR_VIOLET = 7;
   
    //defining our variables
    private int marbleId;
    private int color;
    private String name = null;
    private BigDecimal weight = null;
    
    private String colorString = null;


    /**
     * A constructor that takes in all of the marble parameters
     *
     * @param marbleId the Id of the marble being created.
     * @param color the color of the marble being created.
     * @param name the name of the marble being created.
     * @param weight a BigDecimal representing the marble's weight.
     */
    public Marble(int marbleId, String color, String name, BigDecimal weight) {
	this.marbleId = marbleId;
	this.setColor(color);
	this.name = name;
	this.weight = weight;
    }

    /**
     * Getter method for the marbleId property.
     *
     * @return the marbleId
     */
    public int getMarbleId() {
	return this.marbleId;
    }

    /**
     * Setter method for the marbleId property.
     *
     * @param marbleId an int representing the marbleId to be set.
     */
    public void setMarbleId(int marbleId) {
	this.marbleId = marbleId;
    }

    /**
     * Getter method for the color parameter.
     *
     * @return An int representing the marble's color
     */
    public int getColor() {
	return this.color;
    }

    /**
     * Getter method to return the marble's color in String form.
     *
     * @return a string representation of the marble's color.
     */
    public String getColorString() {
	if(this.colorString == null) {
	    String colorString;
	    switch(this.getColor()) {
	    case Marble.COLOR_RED:
		colorString = "red";
		break;
	    case Marble.COLOR_ORANGE:
		colorString = "orange";
		break;
	    case Marble.COLOR_YELLOW:
		colorString = "yellow";
		break;
	    case Marble.COLOR_GREEN:
		colorString = "green";
		break;
	    case Marble.COLOR_BLUE:
		colorString = "blue";
		break;
	    case Marble.COLOR_INDIGO:
		colorString = "indigo";
		break;
	    case Marble.COLOR_VIOLET:
		colorString = "violet";
		break;
	    default:
		colorString = "-";
	    }
	    
	    return colorString;
	} else {
	    return this.colorString;
	}
    }

    /**
     * Setter method for the marble's name parameter using the color's int value.
     *
     * @param color an int representing the marble's color to be set.
     */
    public void setColor(int color) {
	this.color = color;
    }

    /**
     * Setter method for the marble's color parameter using a String value.
     *
     * @param color a String value representing the Marbles color.
     */
    public void setColor(String colorString) {
	this.colorString = colorString;
	
	switch(colorString.toLowerCase()) {
	case "red":
	    this.color = Marble.COLOR_RED;
	    break;
	case "orange":
	    this.color = Marble.COLOR_ORANGE;
	    break;
	case "yellow":
	    this.color = Marble.COLOR_YELLOW;
	    break;
	case "green":
	    this.color = Marble.COLOR_GREEN;
	    break;
	case "blue":
	    this.color = Marble.COLOR_BLUE;
	    break;
	case "indigo":
	    this.color = Marble.COLOR_INDIGO;
	    break;
	case "violet":
	    this.color = Marble.COLOR_VIOLET;
	    break;
	default:
	    this.color = -1;
	    break;
	    
	}
    }	

    /**
     * Getter method for the marble's name parameter.
     *
     * @return a String representing the marble's name.
     */
    public String getName() {
	return this.name;
    }

    /**
     * Setter method for the marble's name parameter.
     *
     * @param name The name of the marble to be set.
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Getter method for the marbles weight parameter.
     *
     * @return the weight of the marble as a Big Decimal for precision
     */
    public BigDecimal getWeight() {
	return this.weight;
    }

    /**
     * Setter method for the marbles weight property.
     *
     * @param weight A BigDecimal representing the marble's weight
     */
    public void setWeight(BigDecimal weight) {
	this.weight = weight;
    }

    /**
     * A method to get the name of the marble with all spaces and punctuation removed.
     * 
     * @return a boolean representing whether or not the name of the marble is a palindrome
     */
    public boolean isPalindrome() {
	String marbleName = this.getName().replaceAll("\\s|[^A-Za-z]+", "").toLowerCase(); //removing all whitespace, punctuation, and capitalization
	String marbleNameReversed = "";

	for(int i=0; i<marbleName.length(); i++) { //reversing the name string to compare to the original
	    marbleNameReversed = marbleName.charAt(i) + marbleNameReversed;
	}

	return marbleName.equals(marbleNameReversed); // true if the marble name is a palindrome, false if not
    }

    /**
     * A method to determine whether of not a marble is too light to be kept in the collection
     *
     * @param targetWeight the weight to compare the current marble to.
     * 
     * @return true if the marble should be kept, false if the marble should be discarded.
     */
    public boolean isHeavyEnough(BigDecimal targetWeight) {
	return (this.getWeight().compareTo(targetWeight) >= 0); 
    }

    /**
     * An implementation of the quickSort algorithm using the last element as the pivot element.
     * This algoithm has a average time complexity of O(n log n) although given this implemtation,
     * which was chosen for time estimates can drop to the worst case scenario O(n^2) if the elements
     * are already in sorted order. Due to this algorithm's recursive nature the space complexity of
     * this algorithm is O(n).
     *
     * @param marbles        An ArrayList containing all of the marbles to be sorted.
     * @param startingIndex  The lowest index of the section of the ArrayList that is to be sorted
     * @param endingIndex    The highest index of the section of the ArrayList that is to be sorted
     */
    public static void quickSort(ArrayList<Marble> marbles, int startingIndex, int endingIndex) {
	if(startingIndex < endingIndex) {
	    int partitionIndex = Marble.partition(marbles, startingIndex, endingIndex); // find the index to partition on
	    Marble.quickSort(marbles, startingIndex, partitionIndex - 1); // sort the smaller indices
	    Marble.quickSort(marbles, partitionIndex + 1, endingIndex); // sort the larger indices
	}
    }

    /**
     * An implementation of the Lomuto Partition to be used in conjunction with the quickSort method.
     * This method will place the pivot element into its sorted position. It will place all marbles
     * that should be displayed before the pivot marble in ROYGBIV order, into indices less than that
     * of the pivot marble and, all marbles that should be displayed after the pivot marble in ROYGBIV
     * order into indices higher than the pivot marble. It should be noted that this does not place
     * any marble into its correct position intentionally other than the pivot marble itself.
     *
     * @param marbles        An ArrayList containing the marbles in the collection
     * @param startingIndex  The index of the marble to begin with
     * @param endingIndex    The index of the marble to pivot on.
     *
     * @return  The index of the now swaped pivot Marble
     */
    private static int partition(ArrayList<Marble> marbles, int startingIndex, int endingIndex) {
	Marble pivot = marbles.get(endingIndex); //pivot on the end index
	int i = startingIndex - 1;

	for(int j=startingIndex; j<=endingIndex-1; j++) {
	    //if the target marble is smaller than the pivot marble increment the smaller index, then swap with the target
	    if(marbles.get(j).compareTo(pivot) < 0) { 
		Marble swap = marbles.get(++i);
		marbles.set(i, marbles.get(j));
		marbles.set(j,swap);
	    }
	}

	// move the pivot marble to its sorted index
	Marble swap = marbles.get(i+1);
	marbles.set(i+1, marbles.get(endingIndex));
	marbles.set(endingIndex, swap);
	
	return i+1;
    }

    /**
     * A method that gathers all the filtering and sorting methods into one.
     *
     * @param marbleCollection  An ArrayList containing all the marbles in the collection
     * @param targetWeight      A BigDecimal representation of the weight to check the marble collection against.
     *
     * @return the sorted and filtered ArrayList of marbles.
     */
    public static ArrayList<Marble> sortMarbleCollection(ArrayList<Marble> marbleCollection, BigDecimal targetWeight) {

	// first check to see if the which marbles are acceptable for sorting. check for palindrome and min weight
	for(int i=0; i<marbleCollection.size(); i++) { 
	    if(!marbleCollection.get(i).isPalindrome() || !marbleCollection.get(i).isHeavyEnough(targetWeight)) {
		marbleCollection.remove(i);
		i--; // decrease the index by one to account for the removal.
	    }
	}

	if(marbleCollection.size() < 1) {
	    System.out.println("No Marbles to Sort.");
	    return null; // no further processing if no marbles meet the sorting requirements
	}

	//sort the remaining marbles
	Marble.quickSort(marbleCollection, 0, marbleCollection.size()-1);

	return marbleCollection;
    }

    /**
     * A method to compare the colors of the marbles in order to allow them to be sortable.
     *
     * @param target the marble object for which to compare the current marble with.
     */
    @Override
    public int compareTo(Marble target) {
	if(this.getColor() < target.getColor()) {
	    return -1;
	} else if(this.getColor() > target.getColor()) {
	    return 1;
	} else {
	    return 0;
	}
    }

    /**
     * A method to translate the Marble object to a String representation
     *
     * @return the String representation of the marble object.
     */
    public String toString() {
	return "id: " + this.getMarbleId() + ", color: \"" + this.getColorString()
	    + "\", name: \"" + this.getName() + "\", weight: " + String.valueOf(this.getWeight());
    }
}
