// GradeBookTest.java – Creating and manipulating a GradeBook object.
import java.util.Scanner; // program uses Scanner

public class GradeBookTest
{
   // main method begins program execution
   public static void main ( String[] args )
   {
      // create a Scanner object to obtain input from command window
      Scanner input = new Scanner ( System.in );
     
      // ask user to input the name of the course and instructor
      System.out.println( "Please enter the course name:" );      String nameOfCourse = input.nextLine(); // read a line of text      System.out.println("Please enter the name of the instructor:" ); 
      String nameOfInstructor = input.nextLine(); // read a line of text

      
      // create GradeBook object
      GradeBook gradeBook1 = new GradeBook ( nameOfCourse , nameOfInstructor );
   
      // display initial value of courseName and instructorName for gradeBook1 
      gradeBook1.displayMessage();

    } // end main
} // end class GradeBookTest


