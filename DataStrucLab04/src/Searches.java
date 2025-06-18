/**
 * Utility class containing search methods for an integer array
 * Student Name: Andrei Cojocaru
 * Student Number: 041032238
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 */
public abstract class Searches {

    /**
     * Simple recursive binary search algo
     * @param arr to be searched
     * @param target to be found
     * @param left bound of the search area
     * @param right bound of the search area
     * @return index of requested element, -1 if not found
     */
    public static int binarySearch (int[] arr, int target, int left, int right) {
        // if left is larger than right, then elem does not exist
        if (left > right) return -1;
        // get mid elem
        int mid = (left + right) / 2;
        if (arr[mid] == target) return mid;
        // if mid is smaller than target, remove upper half of search area
        // if mid is larger than target, remove lower half of search area
        if (arr[mid] < target) return binarySearch(arr, target, left, mid - 1);
        else return binarySearch(arr, target, mid + 1, right);
    }

    /**
     * Simple recursive linear search algo
     * @param arr to be searched
     * @param target to be found
     * @param cur location in array
     * @return index of requested element, -1 if not found
     */
    public static int linearSearch (int[] arr, int target, int cur) {
        // if our cur has reached the end of array, then does not exist
        if (cur > arr.length - 1) return -1;
        // if we have found target, return index
        if (arr[cur] == target) return cur;
        // call search again
        return linearSearch(arr, target, cur + 1);
    }
}
