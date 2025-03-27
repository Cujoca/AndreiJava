/*
 * Andrei Cojocaru
 * Prof James Mwangi
 * 8132 Object-Oriented Programming
 * Section 311
 */

import java.io.IOException;
import java.util.Scanner;

/**
 * Main class to execute code
 */
public class NFLManager {
    public static void main (String[] args) throws IOException {

        // Scanner to read user input
        Scanner sc = new Scanner(System.in);
        // read relevant files and fill relevant collections
        TeamManager.readTeam();
        GameManager.readGames();
        PlayerManager.readPlayers();
        TeamManager.fillTeams();


        // looper variable
        boolean keepgoing = true;

        // loop where user inputted code is executed, will loop until user says otherwise
        while (keepgoing) {
            System.out.println("\nNFL Management Operations System");
            // show user their choices
            System.out.println("""
                    1. Display Teams
                    2. Display Players
                    3. Display Scheduled Games
                    4. Add Team
                    5. Add Player to Team
                    6. Find Team
                    7. Exit""");
            System.out.print("Please enter your choice: ");
            // take user input
            int choice = NumberReader.readInt(sc);

            // depending on choice, execute relevant code
            switch (choice) {
                case 1:
                    // print out all teams
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.printf("%-15s%-15s%-25s%-15s", "Team Name", "City", "Coach", "Players");
                    System.out.println("\n------------------------------------------------------------------------------");
                    for (Team t : TeamManager.teams) {System.out.println(t.toString());}
                    break;
                case 2:
                    // print out all players
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.printf("%-5s%-25s%-15s%-25s%-15s", "ID", "Name", "Age", "Team", "Position");
                    System.out.println("\n------------------------------------------------------------------------------");
                    for (Player p : PlayerManager.players) {System.out.println(p.toString());}
                    break;
                case 3:
                    // print out all games
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.printf("%-15s%-15s%-12s%-15s%-7s", "Home Team", "Away Team", "Date", "Location", "Score");
                    System.out.println("\n------------------------------------------------------------------------------");
                    for (Game g : GameManager.games) {System.out.println(g.toString());}
                    break;
                case 4:
                    // take in team info
                    System.out.print("Enter Team Name: ");
                    String teamName = sc.nextLine();
                    System.out.print("\nEnter City: ");
                    String city = sc.nextLine();
                    System.out.print("\nEnter Coach: ");
                    String coach = sc.nextLine();
                    System.out.print("\nEnter Coach Years of Experience: ");
                    String coachYears = sc.nextLine();

                    if (teamName.equals("") || city.equals("") || coach.equals("") || coachYears.equals("")) {
                        System.out.println("Oops, you entered in an invalid value, Please try again.");
                    }

                    // add new team to TeamManager holder set
                    // has a try catch in case the coach years is not a valid int
                    try {
                        TeamManager.teams.add(new Team(teamName, city, coach, String.valueOf(coachYears)));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Oops, you entered in an invalid value, please try again");
                    }
                    break;
                case 5:
                    // take in player info
                    System.out.print("Enter Player ID: ");
                    String playerID = sc.nextLine();
                    System.out.print("\nEnter Player Name: ");
                    String playerName = sc.nextLine();
                    System.out.print("\nEnter Player Age: ");
                    String playerAge = sc.nextLine();
                    System.out.print("\nEnter Team Name: ");
                    String playerTeamName = sc.nextLine();
                    System.out.print("\nEnter Player Position: ");
                    String playerPosition = sc.nextLine();
                    // add player to PlayerManager holder set
                    // try catch in case user inputs invalid int for age
                    if (playerID.equals("") || playerName.equals("") ||
                            playerTeamName.equals("") || playerPosition.equals("")) {
                        System.out.println("Oops, you entered an invalid value, Please try again.");
                    }
                    try {
                        PlayerManager.players.add(
                                new Player(playerName, playerID, Integer.parseInt(playerAge),
                                        playerTeamName, playerPosition));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Oops, you entered an invalid value, please try again");
                    }
                    // add the new player to the relevant team
                    // if team does not exist, inform player and restart loop
                    try {
                        TeamManager.findTeam(playerTeamName).players.add
                                (new Player(playerName, playerID, Integer.parseInt(playerAge),
                                        playerTeamName, playerPosition));
                    } catch (NullPointerException e) {
                        System.out.println("Oops, that team doesn't exist. Please try again");
                    }
                    break;
                case 6:
                    // find team inputted by user
                    System.out.print("Enter Team Name: ");
                    String find = sc.nextLine();
                    if (TeamManager.findTeam(find) == null) {
                        System.out.println("Oops, that team doesn't exist. Please try again");
                    } else System.out.println(TeamManager.findTeam(find).toString());
                    break;
                case 7:
                    // if user wants to exit, set control boolean to false
                    keepgoing = false;
                    break;
            }
        }
        System.out.println("Thank you for using NFL Management Operations System by Andrei Cojocaru. Please have a nice day");
    }



}
