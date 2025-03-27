/*
 * Andrei Cojocaru
 * Prof James Mwangi
 * 8132 Object-Oriented Programming
 * Section 311
 */

/**
 * Holds important information about games between 2 teams
 */
public class Game {

    // fields
    String team1;
    String team2;
    String date;
    String location;
    String score;

    /**
     * Standard constructor for the Game class
     * @param team1 the home team
     * @param team2 the away team
     * @param date the date which the game occurred
     * @param location where the game took place
     * @param score the final score of the game
     */
    public Game(String team1, String team2, String date, String location, String score) {
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.location = location;
        this.score = score;
    }

    /**
     * Method to return the Game object in a readable String
     * @return the formatted game represented as a String
     */
    public String toString() {
        return String.format("%-15s%-15s%-12s%-15s%-7s", team1, team2, date, location, score);
    }




}
