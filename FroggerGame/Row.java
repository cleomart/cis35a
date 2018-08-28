
// Row.java
/*
  Encapsulates the overall information 
  for a single Frogger row.
 */

import java.util.StringTokenizer; //splitting the line, breaks into tokens, whtiespace and nonspace

public class Row
{
	// Row types, returned by getType()
	public static final int ROAD = 	0;
	public static final int WATER = 1;
	public static final int DIRT = 2;

	private int type; // type of row
	private int strike; // rate at which cars or lilies in a row move
	private double density; // chance that a new thing is introduced at the far left
	
	public Row(String arguments)
	{
		int numArgs = 3;
		String [] tokens = new String[numArgs];
		StringTokenizer str = new StringTokenizer(arguments);
		int count = 0;
		
		while((count < numArgs) && str.hasMoreTokens())
		{
			tokens[count] =	str.nextToken();
			count++;
		}
		
		if( tokens[0].compareToIgnoreCase("dirt") == 0 )
			type = DIRT;
		else if( tokens[0].compareToIgnoreCase("water") == 0 )
			type = WATER;
		else
			type = ROAD;
		
		if ( type != DIRT )
		{
			strike = Integer.parseInt(tokens[1]);
			density = Double.parseDouble(tokens[2]);
		}
	} // Rowconstructor
	
	public int getType()
	{
		return type;
	}
	
	//if the things in the row move in the given number
	public boolean isTurn(int round)
	{
		return ( (type != DIRT) && (round % strike == 0) );
	}
	
	
	public boolean isAdd()
	{
		double rand = Math.random();
		return ( (type != DIRT) && (rand < density));
	}
}
// class Row
