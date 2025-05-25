import java.io.*;
import java.util.Scanner;

/**
 * This class contains the dynamically allocated array, and its processing
 * Student Name: Andrei Cojocaru
 * Student Number: 041032238
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD. 
 * 
 */
public class Numbers {
	/**
	 * Stores Float values.
	 */
	private Float [] numbers;
	
	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems = 0;

	/**
	 * Default Constructor
	 */
	public Numbers() {
		// use default size of 10
		// have zero elements in array so size is 0
		this.numbers = new Float[10];
	}

	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		// initialize float array with specified length
		// we still have 0 elements
		this.numbers = new Float[size];
	}

	/**
	 * Checks how many spaces are not used in the array
	 * @return number of unused spaces
	 */
	public int spacesLeft () {
		return numbers.length-numItems;
	}
	
	/**
	 * gets value from user to add into array
	 * @param keyboard - Scanner object to use for input
	 */
	public void getValue(Scanner keyboard) {
		// if our array is full, inform user
		if (numItems == numbers.length) {
			System.out.println("oops!, your array is full.");
			return;
		}
		// while loop to get valid input
		Float temp = getFloat(keyboard);
		// if user is inputting value, then double
		this.addValue(temp*2);
		// finally place new float into array

	}

	/**
	 * Add value into array
	 * @param value to add into array
	 */
	public void addValue(Float value) {
		// check if array is full
		if (numItems == numbers.length) {
			System.out.println("oops!, your array is full.");
			return;
		}
		// add value
		numbers[numItems] = value;
		numItems++;
	}
	
	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		// holder variable for returned value
		float out = 0;
		// iterate through array and add all values to the holder variable
		for (float i : numbers) {out += i;}
		// divide total by size to get average
		return out/numItems;
	}

	/**
	 * Method to get max, min, and max%min of array
	 * @return results inside array
	 */
	public Float[] maxMinMod() {
		// check if array is empty
		if (numItems == 0) {return null;}
		// max and min holder variables
		Float max = numbers[0];
		Float min = numbers[0];
		// iterate through array and allocate appropriate values
		for (int i = 1; i < numItems; i++) {
			if (numbers[i] > max) {max = numbers[i];}
			if (numbers[i] < min) {min = numbers[i];}
		}
		// create temp variable for max%min
		Float temp = (float)(Math.floor(max)%Math.floor(min));
		// return out array
		return (new Float[] {max,min,temp});

	}

	/**
	 * Get the factorial of the maximum value
	 * @return max!
	 */
	public float maxFac () {
		float max = this.maxMinMod()[0];
		int maxInt = (int)Math.floor(max);
		if (max > 12 || max < 0) return -1;
		return (float) facHelper(maxInt);
	}

	/**
	 * recursive mini method for use inside factorial
	 * @param x the number being factorialed
	 * @return the output
	 */
	private int facHelper (int x) {
		// if x is 0, return default value of one and cascade back upwards
		if (x == 0) return 1;
		// recursively call method
		else return x*facHelper(x-1);
	}

	/**
	 * Return elements of float array into readable string format
	 */
	@Override
	public String toString() {
		// check if array has values first
		if (numItems == 0) return "Your array is empty.";
		// initialize returned string
		String out = "";
		// iterate through array and add numbers to out string
		// stop before last value as to not add comma at the end
		for (int i = 0; i < numItems - 1; i++) {out += numbers[i] + ", ";}
		// add in last number without comma at end
		out += numbers[numItems - 1];
		return out;
	}

	/**
	 * little helper method to get valid float input
	 * @param sc scanner to get input from user
	 * @return valid input from user
	 */
	private float getFloat (Scanner sc ) {
		// try to get input from user
		try {
			return Float.parseFloat(sc.nextLine());
		// if value cannot be parsed to float, inform user and rerun recursively
		} catch (NumberFormatException e) {
			System.out.println("Oops! invalid value");
			return getFloat(sc);
		}
	}

	/**
	 * Reads from a file to place numbers from file into array
	 * @param fileName file to read from
	 */
	public void readFile(String fileName) {
		File read = new File(fileName);
		Scanner sc;
		try {
			sc = new Scanner(read);
		} catch (FileNotFoundException e) {
			System.out.println("Oops! File not found");
			return;
		}
		if (Float.parseFloat(sc.nextLine()) > this.spacesLeft()) {
			System.out.println("Oops! File too large.");
			return;
		}
		while (sc.hasNextLine()) {
			this.addValue(Float.parseFloat(sc.nextLine()));
		}
	}

	/**
	 * writes contents of array into file.
	 * creates new file if does not exist
	 * @param fileName name of file to write to or create
	 * @throws IOException if doesn't work for some reason
	 */
	public void writeFile(String fileName) throws IOException {
		File write = new File(fileName);
		// tries to create file, nothing happens if already exists
		write.createNewFile();
		// create filewriter
		FileWriter fw = new FileWriter(write);
		// first line is number of elements
		fw.write(this.numItems + "\n");
		// insert each element as new line
		for (int i = 0; i < numItems; i++) {fw.write(numbers[i] + "\n");}
		fw.close();
	}
}
