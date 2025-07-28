package Test;

import Logic.PostalCodeEntry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Starter file for Assigment3 for CST8130
 * @auther James, Georger
 */

public class PostalCodeSearchTest {

	/**
	 * main() which opens and read CSV file of Canadian postal codes
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {

		String filename = "./DataStrucAss03/Resources/postal_codes_ottawa.csv";
		File file = new File(filename);
		HashMap<String, PostalCodeEntry> stuff = new HashMap<>();

		try (BufferedReader input = new BufferedReader(new FileReader(file))) {
			String line = null;
			while ((line = input.readLine()) != null) {
				String[] data = line.split(",");
				PostalCodeEntry postalCodeEntry = new PostalCodeEntry(data);
				stuff.put(postalCodeEntry.getPrefix(), postalCodeEntry);
			}//while
		}
		catch (IOException ioException) {
			System.err.println("Error opening file");
			ioException.printStackTrace();

		} 
		// no need to close input. Used try-with-resources above

		for (int i = 0; i < 10; i++) {
			String temp = PostalCodeEntry.getRandomPrefix();
			System.out.println("retrieving: " + temp);
			if (stuff.containsKey(temp)) {System.out.println(stuff.get(temp));}
			else {System.out.println("NOT found");}
		}
	}// main()

}// class
