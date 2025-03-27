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
 * Singleton class that handles the intake and formatting of information regarding Players
 */
public class PlayerManager {

    static BufferedReader teamReader;

    // need to surround the reader in a try catch in case the requested file does not exist
    static {
        try {
            teamReader = new BufferedReader(new FileReader("/Users/andrei/IdeaProjects/AndreiSchool/Andrei_Cojocaru_Assign02/resources/players.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Player> players = new ArrayList<>();

    private PlayerManager() throws FileNotFoundException {}

    /**
     * Intake values from the teams.csv file and place into teams array
     * @throws IOException Will throw exception if the file is not found
     */
    public static void readPlayers() throws IOException {
        // temp string holder to format data from csv file
        String[] tempArray;
        // while there is another line to take, read line,
        // split based on commas and add the data as a new team
        while (teamReader.ready()) {
            tempArray = teamReader.readLine().split(",");
            players.add(new Player(tempArray[1], tempArray[0], Integer.parseInt(tempArray[2]), tempArray[3], tempArray[4]));
        }
    }
}
