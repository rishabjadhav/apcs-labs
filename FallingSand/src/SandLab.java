import java.awt.*;
import java.util.*;

public class SandLab
{
	//add constants for particle types here
	public static final int EMPTY = 0;
	public static final int METAL = 1;
	public static final int SAND = 2;

	//do not add any more fields!
	private int[][] grid;
	private SandDisplay display; //SandDisplay is the GUI class

	public SandLab(int numRows, int numCols)
	{
		String[] names = new String[3];

		names[EMPTY] = "Empty";
		names[METAL] = "Metal";
		names[SAND] = "Sand";

		display = new SandDisplay("Falling Sand", numRows, numCols, names);
		grid = new int[numRows][numCols];
	}

	/** called when the user clicks on a location using the given tool */
	private void locationClicked(int row, int col, int tool)
	{
		grid[row][col] = tool;
	}

	/** copies each element of grid into the display */
	public void updateDisplay()
	{
		Color sand = new Color(200, 170, 100);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == METAL) {
					display.setColor(i, j, Color.GRAY);
				}
				else if (grid[i][j] == EMPTY) {
					display.setColor(i, j, Color.BLACK);
				}
				else if (grid[i][j] == SAND) {
					display.setColor(i, j, sand);
				}
			}
		}
			
	}
	
	public boolean inBounds(int row, int tool) {
		if (tool == METAL) {
			if (row > 0) {
				return true;
			}
			return false;
		}
		else if (tool == SAND) {
			if (row > 0) {
				return true;
			}
			return false;
		}
		return false;
	}

	/** called repeatedly, causes one random particle to maybe do something */
	public void step()
	{
		Random rng = new Random();
		int randRow = rng.nextInt(display.getNumRows());
		int randCol = rng.nextInt(display.getNumCols());
		if (grid[randRow][randCol] == SAND) {
			if (randRow > 98) {
				
			}
			else {
				grid[randRow + 1][randCol] = SAND;
			
			if (grid[randRow][randCol] == METAL || grid[randRow][randCol] == SAND) {
				grid[randRow][randCol] = SAND;
			}
			else {
				grid[randRow][randCol] = EMPTY;
			}
			}
		}
	}

	//do not modify!
	public void run()
	{
		while (true)
		{
			for (int i = 0; i < display.getSpeed(); i++)
				step();

			updateDisplay();

			display.repaint();

			display.pause(1);  //wait for redrawing and for mouse

			int[] mouseLoc = display.getMouseLocation();

			if (mouseLoc != null)  //test if mouse clicked
				locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
		}
	}
}
