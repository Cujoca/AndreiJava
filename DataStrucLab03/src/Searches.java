import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Logic class which contains searching, printing, and randomization methods
 * Student Name: Andrei Cojocaru
 * Student Number: 041032238
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 *
 */
public class Searches {

    private char[] array;



    /**
     * Iterative implementation of binary search, will return the
     * index of the requested target number
     * @param target the number to look for
     * @return index of the target number, or -1 if is not found
     */
    public int binaryImperative (char target) {
        // set holder variables for lower
        // and upper bounds of search area
        int left = 0;
        int right = array.length - 1;

        // loop to perform search, continue while
        // bound area is not 0 (left == right)
        while (left <= right) {
            // print section of array being searched
            System.out.println("now searching: ");
            printSection(left, right);
            System.out.println();
            // get mid location
            int mid = left + (right - left) / 2;
            // return mid if is index of target
            if (array[mid] == target) return mid;
            // if not target then set mid as one of the bounds if
            // mid is larger, then set as upper bound
            if (array[mid] > target) right = mid - 1;
            // mid is smaller, then set as lower bound
            else if (array[mid] < target) left = mid + 1;
        }
        // if value is not present in array
        return -1;
    }

    /**
     * Recursive implementation of binary search, will return
     * the index of the requested target number
     * @param target the number to look for
     * @param left left side of search area
     * @param right right side of search area
     * @return index of target or -1 if doesn't exist
     */
    public int binaryRecursive (char target, int left, int right) {
        // print section of array being searched
        System.out.println("now searching: ");
        printSection(left, right);
        System.out.println();

        // if search area is invalid, target does not exist
        if (left > right) return -1;
        // set mid
        int mid = (left + right) / 2;
        // if mid is target then return mid
        if (array[mid] == target) return mid;
        // if mid is larger than target, then call again with mid as upper bound
        if (array[mid] > target) return binaryRecursive(target, left, mid - 1);
        // if mid is smaller than target, call again with mid as lower bound

        else return binaryRecursive(target, mid + 1, right);
    }

    /**
     * Imperative implementation of a linear search
     * @param target the number to look for
     * @return index of target or -1 if doesn't exist
     */
    public int linearImperative (char target) {
        // iterate through all elements of search array
        for (int i = 0; i < array.length; i++) {
            // return current index if is target
            if (array[i] == target) return i;
        }
        // if target does not exist in array
        return -1;
    }

    /**
     * Recursive implementation of linear search
     * @param target number to look for
     * @param i current index within array
     * @return target number index
     *          -1 if target number not found
     */
    public int linearRecursive (char target, int i) {
        // if we have reached end of array, return invalid
        if (i >= array.length) return -1;
        // if i is index of target, return i
        if (array[i] == target) return i;

        // recursively call
        return linearRecursive(target, i + 1);
    }

    /**
     * Method to print section of array, used in binary search
     * @param left lower bound of section
     * @param right upper bound of section
     */
    public void printSection (int left, int right) {
        // iterate through section of array and print each element
        for (int i = left; i <= right; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    /**
     * Method to generate unique randomized character array with specified size
     * seed contains both large case and small case characters
     */
    public void generateArray () {
        // create out array
        char[] array = new char[32];
        // create random generator and the seed it will pull from
        SecureRandom random = new SecureRandom();
        String seed = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        HashSet<Character> used = new HashSet<>();

        // index variable
        int i = 0;
        // fill the char array with unique characters from seed
        while (i < 32) {
            // take random character
            char temp = seed.charAt(random.nextInt(seed.length()));

            // if has not been used yet, then insert into array
            // set array at index to new character
            // add character to seen, and increment index
            if (!used.contains(temp)) {
                array[i] = temp;
                used.add(temp);
                i++;
            }
        }
        // set array
        this.array = array;
        // print out unsorted array
        System.out.println("Raw array: " + Arrays.toString(array));
        // sort, then print again
        Arrays.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    /**
     * Getter method to return array length for checks in main
     * @return length of array
     */
    public int arrLength () {
        // null check if user tries to search without initializing first
        if (array == null) return -1;
        return array.length;
    }
}
