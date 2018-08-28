/*****************************************************************
*
*  Leomart Crisostomo
*
*  Compilation:  javac IsaSpringDay.java
*  Execution:    java IsaSpringDay month day
*  
*  Prints true if the given month and day fall between
*  March 20 (inclusive) and June 20 (inclusive).
*
*  Sample Executions:
* 
*  % java IsaSpringDay 3 20
*  true
*
*  % java IsaSpringDay 6 20
*  true
*
*  % java IsaSpringDay 4 15
*  true
*
*  % java IsaSpringDay 9 11
*  false
*
*****************************************************************/

public class IsaSpringDay
{ 
   public static void main(String[] args) { 
      
      int a = Integer.parseInt(args[0]); //reads the first argument and convert to int
      int b = Integer.parseInt(args[1]); //reads the second argument and convert to int
      
      if ( a == 3  && (b >= 20 && b <= 31) ) // prints true if month is 3 (March) AND day is from 20-31
      {			
         System.out.println("true");
      }
      else if ( a == 4 && (b >= 1 && b <= 30) ) //prints true if month is 4 (April) AND day is from 1-30

      {
         System.out.println("true");
      }
      else if ( a == 5 && (b >= 1 && b <= 31) ) //prints true if month is 5 (May) AND day is from 1-31

      {
         System.out.println("true");
      }
      else if ( a == 6 && (b >= 1 && b <= 20) ) //prints true if month is 6 (June) AND day is from 1-20

      {
         System.out.println("true");
      }
      else //prints false if not 
      {
          System.out.println("false");
      }
   }
}




