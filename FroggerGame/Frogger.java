/** Frogger program
  * Built in-class in CIS 110 at the University of Pennsylvania in Fall 2013
  * 
  * This program is built around the SketchFramework code discussed earlier in class.
  */

import java.awt.event.KeyEvent;
import java.awt.Color;
import java.util.ArrayList;

public class Frogger {
    
    // use this main method verbatim
    public static void main(String[] args) {
        // setup the sketch
        setup();
        // drawing and interaction loop
        boolean justPressedMouse = false;
        while(true) {
            draw();
            if (StdDraw.mousePressed()) {
                if (!justPressedMouse) mouseClicked();
                mousePressed();
                justPressedMouse = true;
            } else {
                justPressedMouse = false;
            }
            StdDraw.show(20);
        }
    }
    
    
    ///////////////////////////////////////////////
    //   Objects in game
    ///////////////////////////////////////////////
    static Frog frog = null;
    static Lane[] lanes = null;
    
    
    ///////////////////////////////////////////////
    //   Methods to run game
    ///////////////////////////////////////////////
    
    // setup is called once to initialize everything
    public static void setup() {
        frog = new Frog(0.5, 0);
        lanes = new Lane[9];
        lanes[0] = new Lane(0.1);
        lanes[1] = new Lane(0.2);
        lanes[2] = new Lane(0.3);   
        lanes[3] = new Lane(0.4);
        lanes[4] = new Lane(0.5);
        lanes[5] = new Lane(0.6);   
        lanes[6] = new Lane(0.7);
        lanes[7] = new Lane(0.8);
        lanes[8] = new Lane(0.9);
    }
    
    // draw one frame of animation
    public static void draw() {
        StdDraw.clear(StdDraw.WHITE);
        
        // draw and move the frog based on the pressed key
        frog.draw();
        // handle frog movement
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) { // Left arrow
            frog.move(Frog.LEFT);
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) { // right arrow
            frog.move(Frog.RIGHT);
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) { // up arrow
            frog.move(Frog.UP);
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) { // down arrow
            frog.move(Frog.DOWN);
        }
        
        // draw and step all lanes
        for (int i = 0; i < lanes.length; i++) {
            lanes[i].draw();
            lanes[i].step();
        }
        
        // check for the frog impacting anything in a lane
        for (int i = 0; i < lanes.length; i++) {
            if (lanes[i].detectImpact(frog))
                StdDraw.clear(StdDraw.RED);
        }
    }
    
    // called whenever the mouse is pressed
    public static void mousePressed() {
        // empty
    }
    
    // called once when the mouse is clicked
    public static void mouseClicked() {
        // empty
    }
    
    
}  // end Frogger




class Frog {
    
    // fields
    private double x;
    private double y;
    private double size;
    private double stepSize;
    private int numLives;
    
    // static constants for movement
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    
    // construct a frog at location (x,y)
    public Frog(double x, double y) {
        this.x = x;
        this.y = y;
        size = 0.01;
        stepSize = 0.005;
        numLives = 3;
    }
    
    // getter for x-coordinate
    public double getX() { return x; }
    
    // getter for y-coordinate
    public double getY() { return y; }
    
    // draw the frog
    public void draw() {
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledCircle(x, y, size);
    }
    
    // move the frog
    // direction = up/down/left/right
    public void move(int direction) {
        switch (direction) {
            case LEFT:  
                if (x > 0) x -= stepSize; 
                break;
            case RIGHT: 
                if (x < 1) x += stepSize; 
                break;
            case UP:    
                if (y < 1) y += stepSize; 
                break;
            case DOWN:  
                if (y > 0) y -= stepSize; 
                break;
        }
            
    }
    
    // get the number of lives remaining
    public int getNumLives() { return numLives; }
    
} // end Frog



class Lane {
    
    // fields
    private int direction;  // LEFT or RIGHT
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    
    private ArrayList<Car> cars = new ArrayList<Car>();
    private double yPosition;
    private double width;
    private double speed;
    private boolean generateNewCars;
    
    // construct the lane at the given y-position
    public Lane(double yPosition) {
        this.yPosition = yPosition;
        width = 0.2;
        direction = (int) Math.round(Math.random()); 
        speed = 0.02;
        generateNewCars = true;
    }
    
    // draw the lane, including all cars
    public void draw() {
        // draw all cars in lane
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            c.draw();
        }
    }
    
    // step cars in all lane
    public void step() {
        
        // add new cars with some probability
        if (generateNewCars && Math.random() < 0.05) {
            
            double x = 0, dx = 0;
            if (direction == LEFT) {
                x = 1.2;
                dx = -speed;
            } else {
                x = -0.2;
                dx = speed;
            }
            
            Car c = new Car(x, yPosition, width / 2, dx);
            cars.add(c);
        }
        
        // move all cars
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            c.move();
            if (c.getX() < -0.5 || c.getX() > 1.5) {
                cars.remove(i);
                i--;
            }
        }
       
        // switch lane direction
        if (Math.random() < 0.01) {
            // switch direction
            direction = (direction + 1) % 2;
            generateNewCars = false;  // temporarily disable new cars
        }
        
        // test to see if it is ok to resume car generation
        if (cars.isEmpty()) {
            generateNewCars = true;
        }
    }
    
    // detect impacts with the given frog
    public boolean detectImpact(Frog f) {
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            if (c.detectImpact(f)) return true;
        }
        return false;
    }
        
} // end lane



class Car {
    
    // cars
    private double x;
    private double y;
    private double size;
    private double dx;
    private Color color;
    
    // construct a car at the given location (x,y) with size and velocity
    public Car(double x, double y, double size, double dx) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.dx = dx;
        // choose a random color for the car
        color = new Color((float) Math.random(), 
                          (float) Math.random(), 
                          (float) Math.random());
    }
    
    // getter for x-coordinate
    public double getX() { return x; }
        
    // draw the car
    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledRectangle(x, y, size, size / 3);
    }
    
    // move the car
    public void move() {
        x += dx;
    }
    
    // detect an impact with the frog
    public boolean detectImpact(Frog f) {
        double fx = f.getX();
        double fy = f.getY();
        
        double minX = x - size;
        double maxX = x + size;
        double minY = y - size / 3;
        double maxY = y + size / 3;
        
        return (minX <= fx && fx <= maxX && minY <= fy && fy <= maxY);
    }

} // end Car

