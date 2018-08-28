/*****************************************************************
*
*  Leomart Crisostomo
*
*  This programs prompts the user to enter the number of steps 
*  that will create and display lines from 4 corners of the draw 
*  panel towards the middle.
*  
*****************************************************************/

// MileStone2Test.java
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class MileStone2Test
{
   public static void main( String[] args)
   {
      //create a panel the contains the drawing 
      MileStone2 panel = new MileStone2();
      
      //prompt the user to enter the number of steps to be created using a dialog box
      //int steps  = Integer.parseInt(JOptionPane.showInputDialog( "Please enter the number of steps from 2 to 50 inclusive: " ));

      //keep prompting the user until valid input is entered
      /*while ( steps < 2 || steps > 50)
      {
 
         steps = Integer.parseInt(JOptionPane.showInputDialog( "Invalid Input! \nPlease enter a number from 2 to 50 inclusive: " ));

      } //end while loop
      */
      
      //set the number of steps
     // panel.setNumSteps(steps);

      //create a new frame to hold the panel 
      JFrame application = new JFrame();

      //set the frame to exit when it is closed
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      application.add( panel); //add the panel to the frame 
      
      application.setSize(250, 250); //set the size of the frame
      
      application.setVisible(true); //make the frame visible
  } //end main
} //end class MileStone2Test
