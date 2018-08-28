/*****************************************************************
*
*  Leomart Crisostomo
*
*  Compilation:  javac DivisibleByEight.java
*  Execution:    java DivisibileByEight X Y
*  
*  Reads in two command line inputs X and Y and prints "true”
*  if both are divisible by 8, and false otherwise.
*
*  % java DivisibileByEight 16 24
*  true
*
*  % java DivisibileByEight 32 21
*  false
* 
*  % java DivisibileByEight 100 200
*  false
*
*  a % 8 is the remainder when you divide 8 into a. 
*  If the remainder is 0, then a is divisible by 8.
*
*****************************************************************/

public class DivisibleByEight
{
   public static void main(String[] args) {
   
      int a = Integer.parseInt(args[0]); //reads the first argument and covert to int
      int b = Integer.parseInt(args[0]); //reads the second argument and convert to int
      if (a % 8 == 0 && b % 8 == 0) //if the remainder is 0 when both are divided by 8, return true
      {
          System.out.println("true");

      }
      else //if both numbers are not divisible by 8, return false
      {
          System.out.println("false");
      }
   
   }
}





