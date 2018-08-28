// FroggerComponent.java
/*
  Program description: The main class for Frogger. 
  Stores the state of the world, draws it, 
  handles the tick() and key() logic. 
 */ 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;


public class FroggerComponent extends JComponent  {
	// Size of the game grid
	public static final int WIDTH = 20; //the grid is 1000 pixels and 350 pixels
	public static final int HEIGHT = 7;

	// Initial pixel size for each grid square
	public static final int PIXELS = 50;

	// Image filenames for car, lily, and frog
	public static final String[] IMAGES = new String[] { "frog.png", "car-purple.png", "lily.png"};
	private Image frogImage;
	private Image carImage;
	private Image lilyImage;

	// Colors for ROAD, WATER, and DIRT
	public static final Color[] COLORS = new Color[] {Color.BLACK, Color.BLUE, Color.GRAY };

	// Codes to store what is in each square in the grid
	public static final int EMPTY = 0;
	public static final int CAR = 1;
	public static final int LILY = 2;

	private int [][] grid =new int[WIDTH][HEIGHT]; //keeps track of the car and lilies in the world
	Row [] rows =  new Row [7]; //rows of the rectangular world
	private int x = 3; // initial position of the frog
	private int y = 6; //initial position of the frog
	private boolean dead;

	/*
     Provided utility method to read in an Image object.
     If the image cannot load, prints  error output and returns null.
     Uses Java standard ImageIO.read() method.
	 */
	private Image readImage(String filename)
	{
		Image image = null;
		try
		{
			image = ImageIO.read(new File(filename));
		}
		catch (IOException e)
		{
			System.out.println("Failed to load image '" + filename + "'");
			e.printStackTrace();
		}
		return(image);
	}

	
	// read the content of a file and store it to an array of Row
	private void readRow(String file) 
	{
		try { 
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();


			int count = 1;
			while ((line!=null)	&& (!line.equals("\n")) && (!line.equals("\r")))
			{
				Row r = new Row(line); //construct a row
				rows [count] = r;
				line = br.readLine();
				count++;

			}
			Row firstRow = new Row("dirt");
			rows[0] = firstRow;
			rows[6] = firstRow;

		} catch (IOException ex) 
		{
			System.out.println("File not found!"); 
		}

	}

	//constructor of FroggerComponent
	public FroggerComponent(String filename){

		setPreferredSize(new Dimension(WIDTH*PIXELS,HEIGHT*PIXELS)); // set the rectangular world

		readRow(filename); //read the file

		// read the images
		frogImage = readImage(IMAGES[0]); 
		carImage = readImage(IMAGES[1]);
		lilyImage = readImage(IMAGES[2]);

	}

	//reset the rectangular world
	public void reset()
	{
		for (int x = 0; x < grid.length; x++)
			for (int y = 0; y < grid[x].length; y++)
				grid[x][y] = EMPTY;

		dead = false;
		x=3;
		y = 6;
		repaint();

	}

	// move the position of the frog
	private void moveBy(int dx, int dy)
	{
		if (   (x + dx >= 0 && x + dx < WIDTH)
				&& (y + dy >= 0 && y + dy < HEIGHT) )
		{
			x += dx;
			y += dy;
		}
	}

	//check if the player wins
	public boolean isWin()
	{
		return (y == 0);
	}

	// implements the input of the player: up, down, left or right
	public void key(int code)
	{
		int position; //stores the corresponding grid[][] value of the position of the car
		
		if(code == KeyEvent.VK_UP)
		{
			moveBy(0,-1); //move the position into a new position
			position = grid[x][y];

			if (position == CAR)
				dead = true;
			else {
				if ( (y>0) && (y<6) ) {
					if ( (rows[y].getType() == Row.WATER) && (position != LILY) ){
						dead = true;	}
				}
			}
		}
		else if (code == KeyEvent.VK_DOWN)
		{
			moveBy(0,1); //move the position into a new position
			position = grid[x][y];

			if (position == CAR)
				dead = true;
			else  {
				if ( (y>0) && (y<6) ) {
					if ( (rows[y].getType() == Row.WATER) && (position != LILY)){
						dead = true;	}
				}
			}
		}
		else if (code == KeyEvent.VK_LEFT)
		{
			moveBy(-1,0); //move the position into a new position
			position = grid[x][y];

			if (position == CAR)
				dead = true;
			else {
				if ( (y>0) && (y<6) ) {
					if ( (rows[y].getType() == Row.WATER) && (position != LILY) ){
						dead = true;}
				}
			}
		}
		else if (code == KeyEvent.VK_RIGHT)
		{
			moveBy(1,0); //move the position into a new position
			position = grid[x][y];

			if (position == CAR)
				dead = true;
			else  {
				if ( (y>0) && (y<6) ) {
					if ( (rows[y].getType() == Row.WATER) && (position != LILY) ){
						dead = true;	}
				}
			}
		}
		
		repaint();
	}


	public void paintComponent(Graphics g)
	{
		// get the width and height of the component
		int squareWidth = getWidth() / grid.length;
		int squareHeight = getHeight() / grid[0].length;

		//draw the rectangular world
		for ( int i = 0; i < grid.length ; i++)
			for ( int j = 0; j < grid[i].length; j++)
			{
				if ((rows[j].getType()) == Row.DIRT) {
					g.setColor(COLORS[0]);
					g.fillRect(squareWidth * i, squareHeight * j, squareWidth, squareHeight);
				} else if ((rows[j].getType()) == Row.WATER) {
					g.setColor(COLORS[1]);
					g.fillRect(squareWidth * i, squareHeight * j, squareWidth, squareHeight);

				} else {
					g.setColor(COLORS[2]);
					g.fillRect(squareWidth * i, squareHeight * j, squareWidth, squareHeight);

				}
			}

		//draw the cars and lilies
		for (int i = 0; i < grid.length; i++)
		{
			for ( int j = 0; j < grid[i].length; j++) 
			{
				if ( grid[i][j] == CAR)
					g.drawImage(carImage, i * PIXELS, j * PIXELS, squareWidth, squareHeight, null);
				if ( grid[i][j] == LILY)
					g.drawImage(lilyImage, i * PIXELS, j * PIXELS, squareWidth, squareHeight, null);
			}
		}

		
		// draw the image of the frog
		g.drawImage(frogImage, x * PIXELS, y * PIXELS, squareWidth, squareHeight, null);

		// draw X on the frog if dead is true
		if (dead){
			g.setColor(Color.WHITE);
			g.drawLine(x * PIXELS, y * PIXELS, (x * PIXELS) + PIXELS, (y * PIXELS) + PIXELS);
			g.drawLine( (x * PIXELS) + PIXELS, y * PIXELS, x * PIXELS, (y * PIXELS) + PIXELS);
		
		}

	}


	public void tick(int round)
	{
		if (dead){
		reset();
		}
		
		// move the cars and lilies if round is the same as the strike of a row.
		int position;
		for (int i = (grid.length-1) ; i >= 0 ; i--){
			for (int j = (grid[i].length -1); j >= 0 ; j--){
				if(rows[j].isTurn(round)) {
					if ((grid[i][j] != EMPTY))
					{
						position = grid[i][j];

						//if frog is the same as the position of the car
						if ( (position == CAR))
						{
							// frog is getting hit by the car
							if ( (x == i+1) && (y == j)){
								grid[i+1][j] = position;
								grid[i][j] = EMPTY;
								dead = true;
							} 
							else if (i == 19) // if car is at the far right side of the world, remove it
								grid[i][j] = EMPTY;
							else{
								grid[i+1][j] = position;
							grid[i][j] = EMPTY;
							}
						}



						if ( (position == LILY) ){

							//if frog is on lily
							if ((x==i) && ( y == j)){
								if (i == 19) { //if lily is at the far right of the world
									if (grid[i-1][j] == EMPTY) //if no lily before, nothing will catch the frog
									{
										grid[i][j] = EMPTY;
										dead = true;
									}
								}
								else {
									grid[i+1][j] = position;
									grid[i][j] = EMPTY;
									x++;
								}
							}
							else if (i == 19)
								grid[i][j] = EMPTY; //remove the lily if it is on the far right of the world
							else  {
								grid[i][j] = EMPTY;
								grid[i+1][j] = position;
							}
						}


					}
				}

			}
		}
		
		
		for ( int i= 0; i < rows.length; i++)
		{
			//check if we should add or not
			if ((rows[i].isAdd()) && (rows[i].getType() == Row.WATER)) {
				grid[0][i] = LILY;
			}
			if ((rows[i].isAdd()) && (rows[i].getType() == Row.ROAD)) {
				grid[0][i] = CAR;
			}
		}
		
		repaint();
	}
}