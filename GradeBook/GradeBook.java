// GradeBook class that contains a courseName and instructorName instance variables
// and methods to set and get their values


public class GradeBook
{
   private String courseName;
   // course name for this GradeBook

   private String instructorName;
   // name of the instructor  for this GradeBook

   
   // constructor initializes courseName and instructorName with String arguments
   // constructor name is class name
   public GradeBook ( String name1, String name2 )
   {
      courseName = name1;
      instructorName = name2;
      // initializes courseName and instructorName

   }

   // method to set the course name
   public void setCourseName ( String name)
   {
      courseName = name;
      // store the course name
   } // end method setCourseName

    // method to set the instructor name
   public void setInstructorName (String name)
   {
      instructorName = name;
      // store the instructor name
   } // end method setInstructorName

   // method to retrieve the course name
   public String getCourseName()
   {
      return courseName;
   } // end method getCourseName
   
   // method to retrieve the instructor name
   public String getInstructorName()
   {
      return instructorName;
   } // end method getInstructorName
   
   //display the courseName and instructorName
   public void displayMessage()
   {
      System.out.printf( "Welcome to the grade book for %s!\n", getCourseName());
      System.out.printf( "This course is presented by %s.\n" , getInstructorName());
   } // end method displayMessage

} // end class GradeBook