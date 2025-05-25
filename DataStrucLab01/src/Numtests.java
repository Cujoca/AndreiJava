/**
 * This class contains the dynamically allocated array, and its processing
 * Student Name: Andrei Cojocaru
 * Student Number: 041032238
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 *
 */

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

public class Numtests {


    @Test
    void addValue() {
        Numbers numTest = new Numbers();
        // add value
        numTest.addValue(4f);
        // set as new array with size 2
        numTest = new Numbers(2);
        // test numbers limit
        numTest.addValue(4f);
        numTest.addValue(3f);
        numTest.addValue(5f); // should see array too small here
    }

    @Test
    void maxModMinAvg () {
        Numbers numTest = new Numbers();
        // populate array
        for (int i = 0; i < 10; i++) numTest.addValue((float) i);
        // test result holder
        Float[] avgTest = new Float[4];
        Float[] temp = numTest.maxMinMod();
        // get results, copy into test holder
        for (int i = 0; i < 3; i++) avgTest[i] = temp[i];
        // put result of average into test holder
        avgTest[4] = numTest.calcAverage();
    }

    @Test
    void maxFacTest () {
        Numbers numTest = new Numbers();
        // populate array
        for (int i = 0; i < 10; i++) numTest.addValue((float) i);
        Float max = numTest.maxFac();
    }

    @Test
    void writeFile() throws IOException {
        Numbers numTest = new Numbers();
        // populate array
        for (int i = 0; i < 10; i++) numTest.addValue((float) i);
        // write to file
        numTest.writeFile("thingo.txt");
    }


    void readFile() {
        Numbers numTest = new Numbers();
        // populate array
        for (int i = 0; i < 10; i++) numTest.addValue((float) i);
        // read from file
        numTest.readFile("thingo.txt");
    }
}
