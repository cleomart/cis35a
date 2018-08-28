/*****************************************************************
*
*  Leomart Crisostomo
*
*  Compilation:  javac WhichDayOfWeek.java
*  Execution:    java WhichDayOfWeek m d y
*
*  Read in the month (m), day (d), and year (y) and print out what
*  day of the week it falls on according to the Gregoriancalendar.
*  For M use 1 for January, 2 for February, and so forth. Outputs
*  0 for Sunday, 1 for Monday, and so forth.
*
*        y0 = y -(14 -m) / 12
*        x = y0 + y0/4 -y0/100 + y0/400
*        m0 = m + 12 * ((14 -m) / 12) -2
*        d = (d + x + (31*m0)/12) mod 7
*
*
*  % java WhichDayOfWeek 8 2 1953 // August 2, 1953
*  0                              // Sunday
*
*  % java WhichDayOfWeek1 1 2000 // January 1, 2000
*  6                              // Saturday
*
*****************************************************************/

public class WhichDayOfWeek {
   public static void main(String[] args) { 
      int m = Integer.parseInt(args[0]);
      int d = Integer.parseInt(args[1]);
      int y = Integer.parseInt(args[2]);
      int x = 0;
      y = y -(14 -m) / 12;
      x = y + y/4 -y/100 + y/400;
      m = m + 12 * ((14 -m) / 12) -2;
      d = (d + x + (31*m)/12) % 7;
      
      System.out.println(d);
   }
}



