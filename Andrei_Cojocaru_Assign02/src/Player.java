/*
 * Andrei Cojocaru
 * Prof James Mwangi
 * 8132 Object-Oriented Programming
 * Section 311
 */

/**
 * Holds important information about a player which is part of a team
 */
public class Player {

    // fields
    String name;
    String playerID;
    int age;
    String teamName;
    String position;

    /**
     * Standard constructor for the Player class
     * @param name the name of the player
     * @param playerID the ID of the player
     * @param age the age of the player
     * @param teamName the name of the team that the player is part of
     * @param position the position that the player plays
     */
    public Player(String name, String playerID, int age, String teamName, String position){
        this.name = name;
        this.playerID = playerID;
        this.age = age;
        this.teamName = teamName;
        this.position = position;
    }

    // getters
    public String getName(){return name;}
    public String getPlayerID(){return playerID;}
    public int getAge() {return age;}
    public String getPosition() {return position;}
    public String getTeamName() {return teamName;}

    /**
     * Method to return the Player object as a readable String
     * @return the formatted representation of the player
     */
    @Override
    public String toString() {
        return String.format("%-5s%-25s%-15s%-25s%-15s", playerID, name, age, teamName, position);
    }
}
