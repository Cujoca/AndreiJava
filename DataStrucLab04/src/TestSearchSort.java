import java.util.Scanner;

/**
 * Driver class which runs code and gets user input
 * Student Name: Andrei Cojocaru
 * Student Number: 041032238
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 *
 * @author/Professor James Mwangi PhD.
 */
public class TestSearchSort {

  /**
   * Main method to execute code
   *
   * @param args scanner input
   */
  public static void main(String[] args) {
    // declare and init starter variables
    Scanner sc = new Scanner(System.in);
    int[] randArr = new int[1000];
    int[] sortedArr = new int[1000];
    // boolean controls for user input loops
    boolean keepGoing = true;
    boolean keepSorting = true;

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
          SortingAlgorithms.populate(randArr);
          nanoTime = System.nanoTime() - nanoTime;
          printArr(randArr);
          // has been filled, but is not sorted
          // inform user of completion
          System.out.println("Populated array");
          System.out.println("This operation took " + nanoTime + " nanoseconds, " + nanoTime / 1000000 + " milliseconds");
          System.out.println("Array length is: " + randArr.length);
        }
        // perform binary search
        case 2 -> {
          if (randArr[0] == 0) SortingAlgorithms.populate(randArr);
          if (sortedArr[0] == 0) sortedArr = SortingAlgorithms.mergeSort(randArr);
          printArr(sortedArr);
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
          int i = Searching.binarySearch(sortedArr, elem, 0, sortedArr.length - 1);
          nanoTime = System.nanoTime() - nanoTime;
          if (i >= 0)
            System.out.println(elem + " was found at index: " + i);
          else
            System.out.println(elem + " was not found");
          System.out.println(
                  "This operation took " + nanoTime + " nanoseconds, " + nanoTime / 1000000 + " milliseconds");
        }
        // perform linear search
        case 3 -> {
          if (randArr[0] == 0) SortingAlgorithms.populate(randArr);
          printArr(randArr);
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
          int i = Searching.linearSearch(randArr, elem, 0);
          nanoTime = System.nanoTime() - nanoTime;
          if (i >= 0)
            System.out.println(elem + " was found at index: " + i);
          else
            System.out.println(elem + " was not found");
          System.out
                  .println("This operation took " + nanoTime + " nanoseconds, " + nanoTime / 1000000 + " milliseconds");
        }
        case 4 -> {
          keepSorting = true;
          if (randArr[0] == 0) SortingAlgorithms.populate(randArr);
          while (keepSorting) {
            // present sub menu
            System.out.println("""
                    \n
                    Which sort would you like to use?
                    B. Bubble Sort      - simple in-place, (O(n^2) complexity)
                    I. Insertion Sort   - simple in-place, (O(n^2) complexity)
                    S. Selection Sort   - simple in-place, (O(n^2) complexity)
                    M. Merge Sort       - recursive divide and conquer, (O(log(n)) complexity)
                    Q. Quick Sort       - recursive divide and conquer, (O(log(n)) complexity)
                    D. Do all
                    R. Return to main menu
                    """);
            String temp = sc.nextLine();
            if (temp.length() > 1) {
              System.out.println("Please enter a valid option!");
              break;
            }
            char input = temp.charAt(0);
            switch (input) {
              // bulbasaur
              case 'B' -> {
                printArr(randArr);
                // perform bulbasaur and inform user of results
                long nanoTime = System.nanoTime();
                sortedArr = SortingAlgorithms.bulbaSaur(randArr);
                nanoTime = System.nanoTime() - nanoTime;
                printArr(sortedArr);
                System.out.println(
                        "This operation took " + nanoTime + " nanoseconds, " + nanoTime / 1000000 + " milliseconds");
              }
              // insertion sort
              case 'I' -> {
                printArr(randArr);
                // perform insertion sort and inform user of results
                long nanoTime = System.nanoTime();
                sortedArr = SortingAlgorithms.insertionSort(randArr);
                nanoTime = System.nanoTime() - nanoTime;
                printArr(sortedArr);
                System.out.println(
                        "This operation took " + nanoTime + " nanoseconds, " + nanoTime / 1000000 + " milliseconds");
              }
              // selection sort
              case 'S' -> {
                printArr(randArr);
                // perform selection sort and inform user of results
                long nanoTime = System.nanoTime();
                sortedArr = SortingAlgorithms.selectionSort(randArr);
                nanoTime = System.nanoTime() - nanoTime;
                printArr(sortedArr);
                System.out.println(
                        "This operation took " + nanoTime + " nanoseconds, " + nanoTime / 1000000 + " milliseconds");
              }
              // merge sort
              case 'M' -> {
                printArr(randArr);
                // perform merge sort and inform user of results
                long nanoTime = System.nanoTime();
                sortedArr = SortingAlgorithms.mergeSort(randArr);
                nanoTime = System.nanoTime() - nanoTime;
                printArr(sortedArr);
                System.out.println(
                        "This operation took " + nanoTime + " nanoseconds, " + nanoTime / 1000000 + " milliseconds");
              }
              // quick sort
              case 'Q' -> {
                printArr(randArr);
                // perform quick sort and inform user of results
                long nanoTime = System.nanoTime();
                sortedArr = SortingAlgorithms.quickSort(randArr, randArr.length);
                nanoTime = System.nanoTime() - nanoTime;
                printArr(sortedArr);
                System.out.println(
                        "This operation took " + nanoTime + " nanoseconds, " + nanoTime / 1000000 + " milliseconds");
              }
              // do all
              case 'D' -> {
                System.out.println("Random array: ");
                printArr(randArr);
                // perform bulbasaur and record time
                long nanoBulba = System.nanoTime();
                sortedArr = SortingAlgorithms.bulbaSaur(randArr);
                nanoBulba = System.nanoTime() - nanoBulba;

                // perform insertion and record time
                long nanoInsertion = System.nanoTime();
                sortedArr = SortingAlgorithms.insertionSort(randArr);
                nanoInsertion = System.nanoTime() - nanoInsertion;

                // perform selection and record time
                long nanoSelection = System.nanoTime();
                sortedArr = SortingAlgorithms.selectionSort(randArr);
                nanoSelection = System.nanoTime() - nanoSelection;

                // perform merge and record time
                long nanoMerge = System.nanoTime();
                sortedArr = SortingAlgorithms.mergeSort(randArr);
                nanoMerge = System.nanoTime() - nanoMerge;

                // perform quick and record time
                long nanoQuick = System.nanoTime();
                sortedArr = SortingAlgorithms.quickSort(randArr, randArr.length);
                nanoQuick = System.nanoTime() - nanoQuick;

                System.out.println("Sorted array: ");
                printArr(sortedArr);

                // inform user of results
                System.out.println("Let's see how long each sort took!");
                System.out.println(
                        "Bubble sort took: " + nanoBulba + " nanoseconds, " + nanoBulba / 1000000 + " milliseconds");
                System.out.println("Insertion sort took: " + nanoInsertion + " nanoseconds, " + nanoInsertion / 1000000
                        + " milliseconds");
                System.out.println("Selection sort took: " + nanoSelection + " nanoseconds, " + nanoSelection / 1000000
                        + " milliseconds");
                System.out.println(
                        "Merge sort took: " + nanoMerge + " nanoseconds, " + nanoMerge / 1000000 + " milliseconds");
                System.out.println(
                        "Quick sort took: " + nanoQuick + " nanoseconds, " + nanoQuick / 1000000 + " milliseconds");
              }
              // just return user to main by not doing anything
              case 'R' -> keepSorting = false;
              // inform user if bad input
              default -> System.out.println("Please enter a valid input!");
            }
          }
        }
        // exit program
        case 5 -> keepGoing = false;
        // inform user if bad input
        default -> System.out.println("Please enter a valid option!");
      }
    }
    sc.close();
    System.out.println("Thank you for using this program! have a good day");
  }

  /**
   * Quick helper method to print the int array in a formatted way
   *
   * @param arr to be printed
   */
  private static void printArr(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) System.out.print("[" + arr[i] + ", ");
      else if (i == arr.length - 1) System.out.println(arr[i] + "]");
      else if (i % 20 == 0) System.out.println(arr[i] + ", ");
      else System.out.print(arr[i] + ", ");
    }
  }
}
