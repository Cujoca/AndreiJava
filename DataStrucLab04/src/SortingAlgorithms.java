import java.security.SecureRandom;
import java.util.Random;

/**
 * Utility class containing implementations for various sorting algorithms
 * also includes a method to populate an array with random integers
 * Student Name: Andrei Cojocaru
 * Student Number: 041032238
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 */
public class SortingAlgorithms<T extends Comparable> {

    /**
     * populates our array with 1000 random integers
     * this has side effects since it is populating the array
     * @param array to be filled
     */
    public static void populate (int[] array) {
        Random rand = new SecureRandom();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(120, 1000);
        }
    }

    /**
     * a quicksort implementation using primitive arrays
     * @param array to be sorted
     * @param length of array
     * @return a sorted array (side effect free)
     */
    public static int[] quickSort (int[] array, int length) {
        // if we have reached bottom of recursion tree, start cascade back up
        if (length <= 1) return array;
        // get pivot
        int pivot = array[length / 2];
        /*
         * create left, equal, and right arrays
         * left will have elements smaller than pivot
         * equal will have elements equal to pivot
         * right will have elements larger than pivot
         */
        int[] left = new int[length];
        int leftIndex = 0;
        int[] right = new int[length];
        int rightIndex = 0;
        int[] equal = new int[length];
        int equalIndex = 0;

        // iterate through array and place elements in corresponding array
        for (int i = 0; i < length; i++) {
            if (array[i] < pivot) {left[leftIndex++] = array[i];}
            else if (array[i] > pivot){right[rightIndex++] = array[i];}
            else {equal[equalIndex++] = array[i];}
        }
        // trim all three arrays
        left = trimZeroes(left);
        right = trimZeroes(right);
        equal = trimZeroes(equal);

        // make return array
        int[] result = new int[length];
        int index = 0;
        // iterate through sorted sub arrays and place into return array
        for (int i : quickSort(left, left.length)) {result[index++] = i;}
        for (int i : equal) {result[index++] = i;}
        for (int i : quickSort(right, right.length)) {result[index++] = i;}

        return result;
    }

    /**
     * Little helper method for quicksort to remove random zeroes from array
     * @param array to be trimmed
     * @return reduced array
     */
    private static int[] trimZeroes(int[] array) {
        // get counter
        int nonZero = 0;
        // count number of non zeroes. break when zero encountered to reduce time
        for (int i : array) {
            if (i != 0) nonZero++;
            else break;
        }
        // load all non zero elements into array and return
        int[] result = new int[nonZero];
        for (int i = 0; i < nonZero; i++) {result[i] = array[i];}
        return result;
    }

    /**
     * imperative implementation of bubblesort
     * quadratic complexity, will swap values until reaching right side of array
     * where it will then restart and find the next biggest value and move that to end of array
     * uses a copy of array for no side effects
     * @param array to be sorted
     * @return sorted copy of the array
     */
    public static int[] bulbaSaur (int[] array) {
        // create return array and copy values over
        int[] out = new int[array.length];
        System.arraycopy(array, 0, out, 0, array.length);

        // perform the sort n times
        for (int i = 0; i < out.length; i++) {
            // grab leftmost value, if is larger than next element then swap
            // will swap until finding larger element or reaches end of array
            for (int j = 0; j < out.length-i-1; j++) {
                // perform swap
                if (out[j] < out[j+1]) {
                    int temp = out[j];
                    out[j] = out[j+1];
                    out[j+1] = temp;
                }
            }
        }
    return out;
    }

    /**
     * imperative implementation of selection sort
     * basically the reverse of bubblesort, instead of moving the largest
     * values to the end of the array, will move smallest to the left
     * uses a copy of array for no side effects
     * @param array to be sorted
     * @return copy of sorted array
     */
    public static int[] insertionSort (int[] array) {
        // create out array and copy over contents
        int[] out = new int[array.length];
        System.arraycopy(array, 0, out, 0, array.length);

        // iterate through array from the left
        for (int i = 0; i < out.length; i++) {
            // move current element to the left until we encounter
            // end of array or a smaller number
            for (int j = i; j > 0; j--) {
                // perform swap
                if (out[j] < out[j-1]) {
                    int temp = out[j];
                    out[j] = out[j-1];
                    out[j-1] = temp;
                }
            }
        }
        return out;
    }

    /**
     * Imperative implementation of selection sort
     * will iterate through the array to find the smallest element
     * then move it to the leftmost index. this leftmost index will
     * increment with each swap
     * uses a copy of array for no side effects
     * @param array to be sorted
     * @return a copy of the sorted array
     */
    public static int[] selectionSort (int[] array) {
        // create out array and copy over
        int[] out = new int[array.length];
        System.arraycopy(array, 0, out, 0, array.length);
        // start outer loop
        for (int i = 0; i < out.length; i++) {
            int min = i;
            // iterate through array and find index of smallest remaining number
            for (int j = i; j < out.length; j++) {
                if (out[j] < out[min]) {min = j;}
            }
            // perform swap
            int temp = out[i];
            out[i] = out[min];
            out[min] = temp;
        }
        return out;
    }

    /**
     * Implementation of merge sort, will divide the array down into single element subarrays
     * once finished, will cascade back up and merge left and right into one array in order
     * uses a copy of array for no side effects
     * @param array to be sorted
     * @return copy of sorted array
     */
    public static int[] mergeSort (int[] array) {
        // if length is 1, we have reached the bottom of our recursion tree and will now cascade back up
        if (array.length == 1) return array;
        // otherwise, create relevant variables
        // returned array
        // left side and left index
        int[] left = new int[(array.length+1)/2];
        int leftIndex = 0;
        // right side and right index
        int[] right = new int[array.length-left.length];
        int rightIndex = 0;

        // put left side of array into left
        for (int i = 0; i < (array.length+1)/2; i++) {
            left[leftIndex] = array[i];
            leftIndex++;
        }
        // put right side of array into right
        for (int i = (array.length+1)/2; i < array.length; i++) {
            right[rightIndex] = array[i];
            rightIndex++;
        }
        // recursively sort left and right sides
        left = mergeSort(left);
        right = mergeSort(right);
        // reset indexes to 0 for merging
        leftIndex = 0;
        rightIndex = 0;
        // create index variable for out array
        int i = 0;
        int[] out = new int[array.length];
        // iterate through left and right arrays and add lesser number into out
        // while loop will exit once we have reached the end of either left or right
        while (leftIndex < left.length && rightIndex < right.length) {
            // if left contains smaller number, add into out and increment leftIndex
            if (left[leftIndex] < right[rightIndex]) {
                out[i] = left[leftIndex];
                leftIndex++;
            // if right contains smaller or equal number, add into our and increment rightIndex
            } else {
                out[i] = right[rightIndex];
                rightIndex++;
            }
            // i will always increment
            i++;
        }

        // if left is not finished, then add rest of left into out
        if (leftIndex < left.length) {
            for (int j = leftIndex; j < left.length; j++) {
                out[i] = left[j];
                i++;
            }
        }

        // if right is not finished, then add rest of right into out
        if (rightIndex < right.length) {
            for (int j = rightIndex; j < right.length; j++) {
                out[i] = right[j];
                i++;
            }
        }
        return out;
    }
}