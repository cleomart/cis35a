/******************************************************************
*
*  Name: Leomart Crisostomo
*  Compilation:  javac PairOfTwoDice.java
*  Execution:    java PairOfTwoDice
*  
*  Randomly Generate 2 integers between 1 and 6,
*  and print their sum. 
*
*  Examples of Execution:
* 
*  %  java PairOfTwoDice
*  5
*
*  %  java PairOfTwoDice
*  9
*
*  %  java PairOfTwoDice
*  3
*
*  %  java PairOfTwoDice
*  11
*
*  %  java PairOfTwoDice
*  8
*
*  %  java PairOfTwoDice
*  7
*
*****************************************************************/

public class PairOfTwoDice { 

   public static void main(String[] args) {
	int num = (int) (Math.random()* 6) +1; //generates a random number from 1-6
        System.out.println(num); //prints out the generated number
   
   }
}