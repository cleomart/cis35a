/*****************************************************************
*
*  Leomart Crisostomo
*
*  This class uses drawLine method to create lines from the
*  corners of the panel.
*  
*****************************************************************/


// MileStone2.java
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MileStone2 extends JPanel
{
   
  // private int NUM_STEPS; //number of steps

   //set the number of steps
   /*public void setNumSteps(int a)
   {
      NUM_STEPS = a; 
   }*/
    //end method setNumSteps

   //draws an X from the corners of the panel
   public void paintComponent ( Graphics g)
   {
      //call paintComponent to ensure the panel displays correctly
      super.paintComponent(g);
      
      int width = getWidth(); //total width
      int height = getHeight(); //total height
     
     
      int endX = 0;
      int endY = 0;
      
      	int squareWidth = getWidth() / 7;
      	int squareHeight = getHeight() / 20;
      
      //	g.drawImage(frogImage, x, y, squareWidth, squareHeight, null);
      	
      	for ( int i = 0; i < 7 ; i++)
      		for ( int j = 0; j < 20; j++)
      		{
      			   g.setColor(Color.BLUE);
      			   g.fillRect(squareWidth * i, squareHeight * j, squareWidth, squareHeight);
      			}
  
      /*for (int i = 0; i < NUM_STEPS; i++)
      {
         endX = i*width/NUM_STEPS;
         endY = height - i*height/NUM_STEPS;

         //draw a line from the upper-left corner to the lower-right
         g.drawLine(0,0, endX, endY);

         //draw a line from the lower-left to the upper-right corner
         g.drawLine(width - endX, endY, width, 0);
    
         //draw a line from the upper right to the lower-left corner
         g.drawLine(endX, height - endY, 0, height);

         //draw a line from upper-right to the lower-right corner
         g.drawLine(endX, endY, width, height);
      } //end for loop*/
      
   } //end method paintComponent
    
} //end class MileStone2