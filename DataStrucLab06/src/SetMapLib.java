import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Logic class for handling of data
 *
 * Author: Andrei Cojocaru, 041032238
 * Professor: James Mwangi
 * Course: CST8130 Data Structures
 * Section: 301
 */
public class SetMapLib {

    /**
     * Creates a treemap with the data from customers.txt
     *
     * @return filled tree map
     * @throws FileNotFoundException if file does not exist for some reason
     */
    public static TreeMap<Integer, String> fillMap () throws FileNotFoundException {
        // init variables
        TreeMap<Integer, String> out = new TreeMap<>();
        File file = new File("./DataStrucLab06/resources/customers.txt");
        Scanner scanner = new Scanner(file);

        // get all data from text file into map
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            String[] tempArr = temp.split(",");
            out.put(Integer.parseInt(tempArr[1].trim()), tempArr[0]);
        }

        // inform user and exit
        System.out.println("Map has been filled");
        return out;
    }

    /**
     * gets the value from the map with the given key
     * returns null if key does not exist
     *
     * @param map  map to grab value from
     * @param key key to grab value of
     * @return value or null
     */
    public static String getVal (TreeMap<Integer, String> map, int key) {
        // if is in map get
        if (map.containsKey(key)) {
            return map.get(key);
        }

        // only reachable if map does not contain
        System.out.printf("Error, key %d not found\n", key);
        return null;
    }

    /**
     * Prints out all keys and then all values in ascending order
     *
     * @param map map to grab values from
     */
    public static void printMap (TreeMap<Integer, String> map) {

        // print keys
        System.out.print("Keys in Ascending Order: ");
        for (Integer key : map.keySet()) {System.out.print(key + " ");}

        // print vals
        System.out.print("\nValues in Ascending Order: ");
        for (String key : map.values()) {System.out.print(key + ", ");}


    }

    /**
     * Prints out all values in descending order
     *
     * @param map to get values from
     */
    public static void printValuesDes (TreeMap<Integer, String> map) {
        // put vals into arraylist
        List<String> valsDes = new ArrayList<>(map.values());


        // reverse arraylist and print
        Collections.sort(valsDes, new Comparator<String>() {
            @Override
            // sort in reverse by creating comparator implicitly and that smaller is to right
            public int compare(String str1, String str2) {return str2.compareTo(str1);}
        });
        System.out.print("Keys in Descending Order:");
        for (String val : valsDes) {System.out.print(", " + val);}
    }


    /**
     * puts values and keys into their own respective sets and then prints
     *
     * @param map to get data from
     */
    public static void getIntoSets (TreeMap<Integer, String> map) {
        // create holder collections
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        TreeSet<Integer> keys = new TreeSet<>();
        TreeSet<String> vals = new TreeSet<>();

        // put all keys into keyset and values into valset
        for (Map.Entry<Integer, String> entry : set) {
            keys.add(entry.getKey());
            if (vals.contains(entry.getValue())) continue;
            vals.add(entry.getValue());
        }
        // print out
        System.out.print("Keys: ");
        for (Integer key : keys) System.out.print(key + ", ");

        System.out.print("\nValues: ");
        for (String val : vals) System.out.print(val + ", ");

    }






}
