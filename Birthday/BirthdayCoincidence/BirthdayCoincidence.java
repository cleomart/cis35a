/*****************************************************************
*
*  Leomart Crisostomo
*  
*  This program counts how many people will have to enter in an 
*  empty room until a pair had matching birthdays. Then prints 
*  that number of people.
*
*****************************************************************/
public class BirthdayCoincidence {

	public static void main(String[] args) {
		int counter = 0; //counts the number of people going in to the room
		int DAYS = 366;
		boolean [] found = new boolean[DAYS];//array of the days of the year 0-365, but do not use 0
		
		int val = 0; //stores the random number
		do {
			val = (int) (Math.random() * 365) + 1; //random number generator from 1-365
			counter++; //increments number of people
			if(!found[val])
			{
				found[val] = true; //set current element to true if false
			}
			else
				found[val] = false; //set false if true
		} while (found[val]); //stop the experiment if the current element is set back to false; otherwise continue
		
		//prints out the number of people it takes to have a pair having the same birthday
		System.out.printf("It takes %d people until a pair share the same birthday.",counter);
		
		
	}

}
