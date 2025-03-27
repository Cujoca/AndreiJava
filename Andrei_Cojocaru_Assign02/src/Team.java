/*
 * Andrei Cojocaru
 * Prof James Mwangi
 * 8132 Object-Oriented Programming
 * Section 311
 */

import java.util.ArrayList;

/**
 * Holds important information about a collection of players forming a team
 */
public class Team {

    // fields
    String teamName;
    String city;
    String coachName;
    String coachYears;
    ArrayList<Player> players = new ArrayList<>();

    /**
     * Standard constructor for the Team class
     * @param teamName the name of the team
     * @param city the city in which the team is based in
     * @param coachName the name of the coach of the team
     * @param coachYears the number of years experience that the coach has
     */
    public Team(String teamName, String city, String coachName, String coachYears) {
        this.teamName = teamName;
        this.city = city;
        this.coachName = coachName;
        this.coachYears = coachYears;
    }

    /**
     * Method to return the Team object as a readable String
     * @return the formatted string representation
     */
    @Override
    public String toString() {
        return String.format("%-15s", teamName) +
                String.format("%-15s", city) +
                String.format("%-25s", coachName) +
                String.format("%-15s", String.valueOf(players.size()));
    }

}
