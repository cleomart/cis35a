/*****************************************************************
*
*  Leomart Crisostomo
*
*  Compilation:  javac BirthdayCoincidenceAverage.java
*  Execution:    java BirthdayCoincidenceAverage N
*  
*  This program reads in one command line input, N, that repeats 
*  the experiment on how many people will have to enter in an empty 
*  room until a pair had matching birthdays. Then prints the average 
*  number of people it takes to share the same birthday.
*
*****************************************************************/
public class BirthdayCoincidenceAverage {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]); //reads in a command line input and convert into int
		int total = 0; // stores the total summation of all the experiment
		int average; //average number of people
		int counter = 0; //counts the number of people it takes to have the same birthday
		int val = 0; //stores the random number
		int DAYS = 366; //size of the array
		int[] trials = new int[N]; //array of experiments performed
		boolean [] found = new boolean[DAYS]; //days of the year from 0-365, but do not use 0
		for (int i = 0; i < N; i++)
		{
			counter = 0; //initialize to 0 before starting a new experiment
			val = 0;//initialize to 0 before starting a new experiment
			found = new boolean[DAYS];
			
		do {
			
			val = (int) (Math.random() * 365) + 1; //random number generator
			counter++; //increment number of people
			if(!found[val])
			{
				found[val] = true; //set current element to true if false
			}
			else
				found[val] = false; //set false if true
		
		} while (found[val]); //stop the experiment if the current element is set back to false; otherwise continue
		
		trials[i] = counter; //store the number of people to corresponding trial#
	
		}
		
		for (int num: trials)
		{
			total += num; //calculate the total sum
		}
		
		average = total/N; //calculate the average
		
		//prints out the average number
		System.out.printf("The average number of people that were added until a birthday match occured is %d.", average);
	}

}
