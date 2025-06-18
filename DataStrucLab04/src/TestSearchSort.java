import java.util.Scanner;

/**
 * Driver class which runs code and gets user input
 * Student Name: Andrei Cojocaru
 * Student Number: 041032238
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 */
public class TestSearchSort {

    /**
     * Main method to execute code
     * @param args scanner input
     */
    public static void main(String[] args) {
        // declare and init starter variables
        Scanner sc = new Scanner(System.in);
        int[] randArr = new int[1000];
        int[] sortedArr = new int[1000];
        // checkers for if array has been filled, sorted, and if user wants to exit
        boolean isFilled = false;
        boolean keepGoing = true;
        boolean isSorted = false;

        while (keepGoing) {
            System.out.println("""
                    \n
                    Select your option in the menu below:
                    1. Init and populate array of 1000 random integers
                    2. Perform binary search
                    3. Perform linear search
                    4. Sort array
                    5. Quit
                    """);
            int option = -1;
            // get option from user
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid option!");
            }

            switch (option) {
                // fill array
                case 1 -> {
                    long nanoTime = System.nanoTime();
                    Sorts.populate(randArr);
                    nanoTime = System.nanoTime() - nanoTime;
                    // has been filled, but is not sorted
                    isSorted = false;
                    isFilled = true;
                    // inform user of completion
                    System.out.println("Populated array");
                    System.out.println("This operation took " + nanoTime + " nanoseconds, and " + nanoTime / 1000000 + " milliseconds");
                    System.out.println("Array length is: " + randArr.length);
                }
                // perform binary search
                case 2 -> {
                    // if is not filled, inform user
                    if (!isFilled) {System.out.println("Please fill your array!");break;}
                    // only do binary if array has been sorted
                    if (isSorted) {
                        // get element from user
                        System.out.print("Which element would you like to find? ");
                        int elem = -1;
                        try {
                            elem = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            System.out.println("\nPlease enter a valid number!");
                        }
                        // perform search and inform user of result
                        System.out.println("Searching for: " + elem);
                        long nanoTime = System.nanoTime();
                        int i = Searches.binarySearch(sortedArr, elem, 0, sortedArr.length - 1);
                        nanoTime = nanoTime - System.nanoTime();
                        if (i > 0) System.out.println(elem + " was found at index: " + i);
                        else System.out.println(elem + " was not found");
                        System.out.println("This operation took " + nanoTime + " nanoseconds, and " + nanoTime / 1000000 + " milliseconds");
                    }
                    // if has not been sorted inform user
                    else System.out.println("Array is not sorted!");
                }
                // perform linear search
                case 3 -> {
                    // if has not been filled inform user
                    if (!isFilled) {System.out.println("Please fill your array!");break;}
                    // get element from user
                    System.out.print("Which element would you like to find? ");
                    int elem = -1;
                    try {
                        elem = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("\nPlease enter a valid number!");
                    }
                    // perform search and inform user of result
                    System.out.println("Searching for: " + elem);
                    long nanoTime = System.nanoTime();
                    int i = Searches.linearSearch(sortedArr, elem, 0);
                    nanoTime = nanoTime - System.nanoTime();
                    if (i > 0) System.out.println(elem + " was found at index: " + i);
                    else System.out.println(elem + " was not found");
                    System.out.println("This operation took " + nanoTime + " nanoseconds, and " + nanoTime / 1000000 + " milliseconds");
                }
                case 4 -> {
                    // if has not been filled inform user
                    if (!isFilled) {System.out.println("Please fill your array!");break;}
                    // present sub menu
                    System.out.println("""
                            \n
                            Which sort would you like to use?
                            B. Bubble Sort      - simple, (O(n^2) complexity)
                            I. Insertion Sort   - simple, (O(n^2) complexity)
                            S. Selection Sort   - simple, (O(n^2) complexity)
                            M. Merge Sort       - simple, (O(log(n)) complexity)
                            Q. Quick Sort       - simple, (O(log(n)) complexity)
                            D. Do all
                            """);
                    isSorted = true;
                    String temp = sc.nextLine();
                    if (temp.length() > 1) {System.out.println("Please enter a valid option!");break;}
                    char input = temp.charAt(0);
                    switch (input) {
                        // bulbasaur
                        case 'B' -> {
                            // perform bulbasaur and inform user of results
                            long nanoTime = System.nanoTime();
                            sortedArr = Sorts.bulbaSaur(randArr);
                            nanoTime = System.nanoTime() - nanoTime;
                            System.out.println("This operation took " + nanoTime + " nanoseconds, and " + nanoTime / 1000000 + " milliseconds");
                        }
                        // insertion sort
                        case 'I' -> {
                            // perform insertion sort and inform user of results
                            long nanoTime = System.nanoTime();
                            sortedArr = Sorts.insertionSort(randArr);
                            nanoTime = System.nanoTime() - nanoTime;
                            System.out.println("This operation took " + nanoTime + " nanoseconds, and " + nanoTime / 1000000 + " milliseconds");
                        }
                        // selection sort
                        case 'S' -> {
                            // perform selection sort and inform user of results
                            long nanoTime = System.nanoTime();
                            sortedArr = Sorts.selectionSort(randArr);
                            nanoTime = System.nanoTime() - nanoTime;
                            System.out.println("This operation took " + nanoTime + " nanoseconds, and " + nanoTime / 1000000 + " milliseconds");
                        }
                        // merge sort
                        case 'M' -> {
                            // perform merge sort and inform user of results
                            long nanoTime = System.nanoTime();
                            sortedArr = Sorts.mergeSort(randArr);
                            nanoTime = System.nanoTime() - nanoTime;
                            System.out.println("This operation took " + nanoTime + " nanoseconds, and " + nanoTime / 1000000 + " milliseconds");
                        }
                        // quick sort
                        case 'Q' -> {
                            // perform quick sort and inform user of results
                            long nanoTime = System.nanoTime();
                            sortedArr = Sorts.quickSort(randArr, randArr.length);
                            nanoTime = System.nanoTime() - nanoTime;
                            System.out.println("This operation took " + nanoTime + " nanoseconds, and " + nanoTime / 1000000 + " milliseconds");
                        }
                        // do all
                        case 'D' -> {
                            // perform bulbasaur and record time
                            long nanoBulba = System.nanoTime();
                            sortedArr = Sorts.bulbaSaur(randArr);
                            nanoBulba = System.nanoTime() - nanoBulba;

                            // perform insertion and record time
                            long nanoInsertion = System.nanoTime();
                            sortedArr = Sorts.insertionSort(randArr);
                            nanoInsertion = System.nanoTime() - nanoInsertion;

                            // perform selection and record time
                            long nanoSelection = System.nanoTime();
                            sortedArr = Sorts.selectionSort(randArr);
                            nanoSelection = System.nanoTime() - nanoSelection;

                            // perform merge and record time
                            long nanoMerge = System.nanoTime();
                            sortedArr = Sorts.mergeSort(randArr);
                            nanoMerge = System.nanoTime() - nanoMerge;

                            // perform quick and record time
                            long nanoQuick = System.nanoTime();
                            sortedArr = Sorts.quickSort(randArr, randArr.length);
                            nanoQuick = System.nanoTime() - nanoQuick;

                            // inform user of results
                            System.out.println("Let's see how long each sort took!");
                            System.out.println("Bubble sort took: " + nanoBulba + " nanoseconds, or " + nanoBulba / 1000000 + " milliseconds");
                            System.out.println("Insertion sort took: " + nanoInsertion + " nanoseconds, or " + nanoInsertion / 1000000 + " milliseconds");
                            System.out.println("Selection sort took: " + nanoSelection + " nanoseconds, or " + nanoSelection / 1000000 + " milliseconds");
                            System.out.println("Merge sort took: " + nanoMerge + " nanoseconds, or " + nanoMerge / 1000000 + " milliseconds");
                            System.out.println("Quick sort took: " + nanoQuick + " nanoseconds, or " + nanoQuick / 1000000 + " milliseconds");
                        }
                        // inform user if bad input
                        default -> System.out.println("Please enter a valid input!");
                    }
                }
                // exit program
                case 5 -> keepGoing = false;
                // inform user if bad input
                default -> System.out.println("Please enter a valid option!");
            }
        }
        System.out.println("Thank you for using this program! have a good day");
    }
}
