/**************************************************************************
 *
 *  Leomart Crisostomo
 *
 *  This Craps class simulates the dice game craps a million times.
 *  Then prints out the number of games won and lost on the ith roll,
 *  the chance of winning, and the average length of a game of craps.
 *  
 ***************************************************************************/
import java.util.Random;

public class Craps
{
	// create random number generator for use in method rollDice
	private static final Random randomNumbers = new Random();
	// enumeration with constants that represent the game status
	private enum Status { CONTINUE, WON, LOST };

	// constants that represent common rolls of the dice
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;

	//number of game of craps to be played
	private static final long GAMES = 1000000;
	//size of the win and lose array
	private static final int ROLLS = 1000;
	//array of winning the craps on the ith roll
	private static int[] win = new int[ROLLS];
	//array of losing the craps on the ith roll
	private static int[] lose = new int[ROLLS];


	// plays a million game of craps
	public static void main( String[] args )
	{		
		//for loop that repeats the game a million times
		for (int i = 0; i < GAMES; i++)
		{
			int numRolls= 0; //hold the number of rolls
			int myPoint = 0; // point if no win or loss on first roll
			Status gameStatus; // can contain CONTINUE, WON or LOST

			int sumOfDice = rollDice(); // first roll of the dice
			numRolls++; //increment numRolls

			// determine game status and point based on first roll
			switch ( sumOfDice )
			{
			case SEVEN: // win with 7 on first roll
			case YO_LEVEN: // win with 11 on first roll
				gameStatus = Status.WON;
				win[numRolls]++; //increment the win array on the numRolls index
				break;

			case SNAKE_EYES: // lose with 2 on first roll
			case TREY: // lose with 3 on first roll
			case BOX_CARS: // lose with 12 on first roll
				gameStatus = Status.LOST;
				lose[numRolls]++; //increment the lose array on the numRolls index
				break;

			default: // did not win or lose, so remember point
				gameStatus = Status.CONTINUE; // game is not over
				myPoint = sumOfDice; // remember the point
				//System.out.printf( "Point is %d\n", myPoint );
				break; // optional at end of switch
			} // end switch

			// while game is not complete
			while ( gameStatus == Status.CONTINUE ) // not WON or LOST
			{
				sumOfDice = rollDice(); // roll dice again
				numRolls++; //increment numRolls

				// determine game status
				if ( sumOfDice == myPoint ) // win by making point
				{	
					win[numRolls]++; //increment the win array on the numRolls index
					gameStatus = Status.WON;	
				}

				else if ( sumOfDice == SEVEN ) // lose by rolling 7 before point
				{
					lose[numRolls]++; //increment the lose array on the numRolls index
					gameStatus = Status.LOST;	
				}
			}
		} // end while
		// display won or lost message


		//Prints out the results
		System.out.println("The following are the results of running a Game of Craps a million times:");
		System.out.println(); //prints a line
		printWin(); // prints the win array
		System.out.println(); //prints a line
		printLose(); //prints the lose array
		System.out.println(); //prints a line
		System.out.print("The chance of winning Craps is: ");
		System.out.println(chanceOfWinning()); //prints the chances of winning
		System.out.println(); //prints a line
		System.out.print("The average length of a game of craps is: ");
		System.out.println(averageLength()); //prints the average length of a game of craps

	} // end main

	// roll dice, calculate sum and display results
	public static int rollDice()
	{
		// pick random die values
		int die1 = 1 + randomNumbers.nextInt( 6 ); // first die roll
		int die2 = 1 + randomNumbers.nextInt( 6 ); // second die roll
		int sum = die1 + die2; // sum of die values
		// display results of this roll
		//System.out.printf( "Player rolled %d + %d = %d\n", die1, die2, sum );
		return sum; // return sum of dice
	} // end method rollDice

	//calculate the average length of a game of craps then return the average
	public static double averageLength()
	{
		double total = 0; //holds the total
		double average;
		for (int i = 0; i < ROLLS; i++)
		{
			total +=  i * win[i]; //multply index and it's corresponding win array value, then add to total
			total += i * lose[i]; //multply index and it's corresponding lose array value, then add to total
		}
		average = total / GAMES; //average is total divided by the number of games played
		return average; //return the average length
	}

	//caculcate the chance of winning in a game of craps then return the chance of winning
	public static double chanceOfWinning()
	{
		double chance; //holds the chance
		double totalWin = 0; //holds the total number of wins

		for (int wins : win)
		{
			totalWin += wins; //adds the total number of wins
		}
		chance = totalWin / GAMES; //calculates the chance of winning
		return chance; //return the chance of winning
	}


	//print the array of win
	public static void printWin()
	{
		long overTwenty = 0; //hold the total number of wins after the 20th roll
		System.out.println("The number of games won on the ith roll are: ");

		for (int i = 1; i <= 20 ; i++)
		{
			System.out.printf("%d: %d", i, win[i]); //prints the ith roll and number of wins
			System.out.println(); //prints a line
		}
		for (int i = 21; i < ROLLS; i++)
		{
			overTwenty += win[i]; //adds up the total winnings after the 20th roll
		}

		System.out.printf("After 20th roll: %d", overTwenty); //print the after 20th roll and total number of winning
		System.out.println(); //prints a line
	}

	//print the array of lose
	public static void printLose()
	{
		long overTwenty = 0; //hold the total number of loses after the 20th roll
		System.out.println("The number of games lost on the ith roll are: ");

		for (int i = 1; i <= 20 ; i++)
		{
			System.out.printf("%d: %d", i, lose[i]); //prints the ith roll and number of loses
			System.out.println(); //prints a line
		}
		for (int i = 21; i < ROLLS; i++)
		{
			overTwenty += lose[i]; //adds up the total lose after the 20th roll
		}

		System.out.printf("After 20th roll: %d", overTwenty); //print the after 20th roll and total number of loses
		System.out.println(); //prints a line
	}
} // end class Craps











