/**
 * 
 * Program: Computer Engineering Technology - Computing Science [Academic Level: 2 ]
 * Course: CST8132 Object Oriented Programming 
 * Student Name: Andrei Cojocaru
 * Student Number: 041032238
 * Section #: 310
 * Professor: Dr. James Mwangi
 * L2
 */

//Application of multidimensional arrays 
public class NFLGamesData {
	
	public static void main(String[] args) {
		System.out.println("\n");

		// Step 1: Initialize the two-dimensional array with NFL game scores (2 points)

		int[][] scores = new int[4][3];

		scores[0][0] = 22;
		scores[0][1] = 30;
		scores[0][2] = 25;
		scores[1][0] = 18;
		scores[1][1] = 24;
		scores[1][2] = 16;
		scores[2][0] = 27;
		scores[2][1] = 21;
		scores[2][2] = 22;
		scores[3][0] = 17;
		scores[3][1] = 28;
		scores[3][2] = 19;

		
		//Initialize one-dimensional array to store players 
		
		String[] players = new String[4];
		players[0] = "Marlon";
		players[1] = "Miles";
		players[2] = "Nick";
		players[3] = "Tyler";


		// Step 2: Calculate total points for each player (2 points)
				//print sub-heading
				//write code here

		System.out.println("NFL Game statistics for Baltimore Ravens Players");

		int totalTemp = 0;
		int j = 0;
		int[] totalScores = new int[4];
		for (int[] cur : scores) {
			for (int i : cur) {
				totalTemp += i;
			}
			totalScores[j] = totalTemp;
			j++;
			totalTemp = 0;
		}
		j = 0;
		System.out.println("\nTotal points for each player: ");
		for (String player : players) {
			System.out.println(player + ": " + totalScores[j]);
			j++;
		}
		
		
		// Step 3: Calculate average points per game for each player (2 points)
				//print sub-heading
				//write code here

		double[] avgScores = new double[4];
		j = 0;
		for (int i : totalScores) {
			avgScores[j] = i/3.0;
			j++;
		}

		j = 0;
		System.out.println("\nAverage points for each player: ");
		for (String player : players) {
			System.out.print(player + ": ");
			System.out.printf("%.2f\n" ,avgScores[j]);
			j++;
		}


		// Step 4: Calculate total points for each NFL game (2 points)
				//print sub-heading
				//write code here

		int[] totalGamePoints = new int[3];
		j = 0;

		for (int i = 0; i < scores[0].length; i++) {
			int output = 0;
			for (int[] cur : scores ) {
				output += cur[i];
			}
			totalGamePoints[i] = output;
		}
		System.out.println("\nTotal points for each game: ");
		System.out.println("Game 1: " + totalGamePoints[0]);
		System.out.println("Game 2: " + totalGamePoints[1]);
		System.out.println("Game 3: " + totalGamePoints[2]);

		// Step 5: Identify and print the player with the lowest total score (2 points)
			
			//part of the required code for this task is given provide.
			//write missing code here. Hint: use loops

		int lowestScore = 10000;
		String player = "";
		for (int i = 0; i < totalScores.length; i++) {
			if (lowestScore > totalScores[i])  {
				lowestScore = totalScores[i];
				player = players[i];
			}
		}

		//print highest scorer
		System.out.println("\nPlayer with the lowest score: " + player + " with " + lowestScore);
	}
}
