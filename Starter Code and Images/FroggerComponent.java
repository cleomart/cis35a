// FroggerComponent.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

/*
 The main class for Frogger. Stores the state of the world,
 draws it, handles the tick() and key() logic.
*/
public class FroggerComponent extends JComponent  {
	// Size of the game grid
	public static final int WIDTH = 20;
	public static final int HEIGHT = 7;
	
	// Initial pixel size for each grid square
	public static final int PIXELS = 50;


	// Image filenames for car, lily, and frog
	public static final String[] IMAGES = new String[] { "car.png", "lily.png" , "frog.png", };
	
	// Colors for ROAD, WATER, and DIRT
	public static final Color[] COLORS = new Color[] { Color.BLACK, Color.BLUE, Color.GRAY } ;
	
	// Codes to store what is in each square in the grid
	public static final int EMPTY = 0;
	public static final int CAR = 1;
	public static final int LILY = 2;
	


	/*
	 Provided utility method to read in an Image object.
	 If the image cannot load, prints error output and returns null.
	 Uses Java standard ImageIO.read() method.
	*/
	private Image readImage(String filename) {
		Image image = null;
		try {
			image = ImageIO.read(new File(filename));
		}
		catch (IOException e) {
			System.out.println("Failed to load image '" + filename + "'");
			e.printStackTrace();
		}
		return(image);
	}
	
}


