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
 * Singleton class which intakes and formats information regarding Teams
 */
public class TeamManager {


    // need to surround the reader in a try catch in case the requested file does not exist
    static BufferedReader teamReader;

    static {
        try {
            teamReader = new BufferedReader(new FileReader("/Users/andrei/IdeaProjects/AndreiSchool/Andrei_Cojocaru_Assign02/resources/teams.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Team> teams = new ArrayList<>();

    private TeamManager() throws FileNotFoundException {}

    /**
     * Intake values from the teams.csv file and place into teams array
     * @throws IOException Will throw exception if the file is not found
     */
    public static void readTeam() throws IOException {
        // temp string holder to format data from csv file
        String[] tempArray;
        // while there is another line to take, read line,
        // split based on commas and add the data as a new team
        while (teamReader.ready()) {
            tempArray = teamReader.readLine().split(",");
            teams.add(new Team(tempArray[0], tempArray[1], tempArray[2], tempArray[3]));
        }
    }

    /**
     * Method to take all info from the PlayerManager holder collection and insert into relevant teams
     */
    public static void fillTeams() {
        PlayerManager.players.forEach(player -> {
            TeamManager.teams.forEach(team -> {
                if (player.teamName.equalsIgnoreCase(team.teamName)) {team.players.add(player);}
            });
        });
    }

    /**
     * Method to find a given team by the name
     * @param inName name of the team to find
     * @return the team with the name, or null if team does not exist
     */
    public static Team findTeam(String inName) {
        for (Team team : teams) {
            if (team.teamName.equalsIgnoreCase(inName)) {return team;}
        }
        return null;
    }
}