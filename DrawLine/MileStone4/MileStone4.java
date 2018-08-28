/*****************************************************************
*
*  Leomart Crisostomo
*
*  This class uses drawLine method to create lines from the
*  the top-left sided and ends one step right on the bottom edge
*  as well as the other three sides.
*    
*****************************************************************/
// MileStone4.java

import java.awt.Graphics;
import javax.swing.JPanel;

public class MileStone4 extends JPanel
{
   private int NUM_STEPS; //number of steps

   //set the number of steps
   public void setNumSteps(int a)
   {
      NUM_STEPS = a;
   } //end method setNumSteps
   
   //draws a line from the corners of the panel
   public void paintComponent ( Graphics g)
   {
      //call paintComponent to ensure the panel displays correctly
      super.paintComponent(g);
      
      int width = getWidth(); //total width
      int height = getHeight(); //total height
      
      int startY = 0;
      int endX = 0;
  
      for (int i = 0; i < NUM_STEPS; i++)
      {
         startY= i * height/NUM_STEPS;
         endX = ++i * width/NUM_STEPS;

         //draw a line from the top-left corner and ends one step right on the bottom edge
         g.drawLine(0,startY, endX, height);

         //draw a line from the bottom-right corner and ends one step left on the top edge
         g.drawLine(width, height - startY , width -endX, 0);
  
         //draw a line from the top-right corner and ends one step left on the bottom edge
         g.drawLine(width, 0 + startY, width-endX, height); 

         //draw a line from the bottom-left corner and ends one step right on the top edge
         g.drawLine(0, height - startY, 0 + endX,0); 
        
      } //end for loop

   } //end method paintComponent
} //end class MileStone4