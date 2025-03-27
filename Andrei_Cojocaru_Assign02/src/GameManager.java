/*
 * Andrei Cojocaru
 * Prof James Mwangi
 * 8132 Object-Oriented Programming
 * Section 311
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Singleton class that intakes and formats information regarding Games
 */
public class GameManager {

    static BufferedReader teamReader;


    // need to surround the reader in a try catch in case the requested file does not exist
    static {
        try {
            teamReader = new BufferedReader(new FileReader("/Users/andrei/IdeaProjects/AndreiSchool/Andrei_Cojocaru_Assign02/resources/games.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Game> games = new ArrayList<>();

    private GameManager() throws FileNotFoundException {}

    /**
     * Intake values from the games.csv file and place into games array
     * @throws IOException Will throw exception if the file is not found
     */
    public static void readGames() throws IOException {
        // temp string holder to format data from csv file
        String[] tempArray;
        // while there is another line to take, read line,
        // split based on commas and add the data as a new team
        while (teamReader.ready()) {
            tempArray = teamReader.readLine().split(",");
            games.add(new Game(tempArray[0], tempArray[1], tempArray[2], tempArray[3], tempArray[4]));
        }
    }
}
