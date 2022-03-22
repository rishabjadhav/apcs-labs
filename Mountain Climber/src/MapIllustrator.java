import java.io.File;
import java.util.Random;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MapIllustrator
{
	private int[][] grid;
	private int     rows;
	private int     cols;

	public MapIllustrator(String filename)
	{
		try {
			File file = new File(filename);
			Scanner console = new Scanner(file, StandardCharsets.UTF_8.name());
			String content;
			rows = console.nextInt();
			cols = console.nextInt();
			System.out.println("rows : " + rows + "// cols : " + cols);
			grid = new int [rows][cols];
			System.out.println("rows : " + grid.length + "// cols : " + grid[rows - 1].length);
			for (int r = 0; r < grid.length; r++) {
				for (int c = 0; c < grid[r].length; c++) {
					grid[r][c] = console.nextInt();
				}
			}
			console.close();
		}
		catch (IOException e) {
			System.out.println("ohh... somthing went wrong with reading the file...");
			System.out.println("Exception: " + e);
		}
		
		

		initCanvas(); //don't move, should be last line of constructor, initialize drawing window
	}
	
	/** initialize the drawing window */
	private void initCanvas() {
		StdDraw.setCanvasSize(cols, rows);
		StdDraw.setXscale(0, cols);
		StdDraw.setYscale(0, rows);
		StdDraw.enableDoubleBuffering();
	}
	
	public int getRows () {
		return rows;
	}
	
	public int getCols () {
		return cols;
	}

	/** @return the min value in the entire grid */
	public int findMin()
	{
		int minElevation = 0;
		int r = 0, c = 0;
		if (grid[r][c] > grid[r + 1][c + 1]) {
			minElevation = grid[r + 1][c + 1];
		}
		else {
			minElevation = grid[r][c];
		}
		for (r = 0; r < grid.length; r++) {
			for (c = 0; c < grid[r].length; c++) {
				if (grid[r][c] < minElevation) {
					minElevation = grid[r][c];
				}
			}
		}

		return minElevation;
	}
	
	/** @return the max value in the entire grid */
	public int findMax()
	{
		int maxElevation = 0;
		
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] > maxElevation) {
					maxElevation = grid[r][c];
				}
			}
		}

		
		return maxElevation;
	}

	/**
	 * Draws the grid (map)
	 * Colors should be grayscale values 0-255, scaled based on min/max values in grid
	 */
	public void drawMap()
	{
		int shade = 0;
		int max = findMax();
		int min = findMin();
		
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				shade = 0;
				shade = ((grid[r][c] - min) * 255) / (max - min);
				
				StdDraw.setPenColor(shade, shade, shade);
				StdDraw.filledSquare(c, (grid.length - 1) - r, 0.5);
				//StdDraw.filledRectangle(c, (grid.length - 1) - r, 0.5, 0.5);
			}
		}
	}
			

	/**
	 * Find/draw a greedy path from West-to-East, starting at given row.
	 * Choose a forward step out of 3 possible forward locations, using greedy method described in assignment.
	 * @return the total change in elevation traveled from West-to-East
	 * 
	 * Continue when INdexOutOfBounds
	 * use greedy algorithm
	 * 
	 */
	public int drawPath(int row)
	{
		int r = row;
		int totalChange = 0;
		int nextU = 0, nextD = 0, nextF = 0;
		int endCol = 0;
		for (int c = 2; c < grid[0].length; c++) {
			endCol = c;
			if (r - 1 <= 0 || r + 1 >= grid.length || c - 1 <= 0 || c + 1 >= grid[0].length) {
				break;
			}
			
			nextU = Math.abs((grid[r + 1][c + 1]) - grid[r][c]);
			nextD = Math.abs((grid[r - 1][c + 1]) - grid[r][c]);
			nextF = Math.abs((grid[r][c + 1]) - grid[r][c]);
			
			if (nextU <= nextD && nextU <= nextF) {
				if (nextU == nextF) {
					//override forward
					StdDraw.filledRectangle(c, (grid.length - 1) - r, 0.5, 0.5);
				}
				else if (nextU == nextD) {
					//randomize up or down
					Random rng = new Random();
					int rand = rng.nextInt(2);
					if (rand == 0) {
						//go down
						StdDraw.filledRectangle(c, (grid.length - 1) - (r - 1), 0.5, 0.5);
						r--;
						if (r - 1 <= 0 || r + 1 >= grid.length) {
							continue;
						}
						totalChange += nextD;
						
					}
					else {
						//go up
						StdDraw.filledRectangle(c, (grid.length - 1) - (r + 1), 0.5, 0.5);
						r++;
						if (r - 1 <= 0 || r + 1 >= grid.length) {
							continue;
						}
						totalChange += nextU;
					}
				}
				else {
					//go up
					StdDraw.filledRectangle(c, (grid.length - 1) - (r + 1), 0.5, 0.5);
					r++;
					if (r - 1 <= 0 || r + 1 >= grid.length) {
						continue;
					}
					totalChange += nextU;
					
				}
				
			}
			else if (nextF <= nextD && nextF <= nextU) {
				if (nextF == nextD || nextF == nextU) {
					//override forward
					StdDraw.filledRectangle(c, (grid.length - 1) - r, 0.5, 0.5);
				}
				else {
					//go forward
					StdDraw.filledRectangle(c, (grid.length - 1) - r, 0.5, 0.5);
				}
				
			} 
			else if (nextD <= nextF || nextD <= nextU) {
				if (nextU == nextF) {
					//override forward
					StdDraw.filledRectangle(c, (grid.length - 1) - r, 0.5, 0.5);
				}
				else if (nextD == nextU) {
					Random rng = new Random();
					int rand = rng.nextInt(2);
					if (rand == 0) {
						//go down
						StdDraw.filledRectangle(c, (grid.length - 1) - (r - 1), 0.5, 0.5);
						r--;
						if (r - 1 <= 0 || r + 1 >= grid.length) {
							continue;
						}
						totalChange += nextD;
					}
					else {
						//go up
						StdDraw.filledRectangle(c, (grid.length - 1) - (r + 1), 0.5, 0.5);
						r++;
						if (r - 1 <= 0 || r + 1 >= grid.length) {
							continue;
						}
						totalChange += nextU;
					}
				}
				else {
					//go down
					StdDraw.filledRectangle(c, (grid.length - 1) - (r - 1), 0.5, 0.5);
					totalChange += nextD;
					r--;
					if (r - 1 <= 0 || r + 1 >= grid.length) {
						continue;
					}
				}
			}
		}
		
		if(endCol != grid[0].length - 1) { return -1; }
		
		return totalChange;
	}

	/** @return the index of the starting row for the lowest-elevation-change path in the entire grid. */
	public int getIndexOfLowestPath()
	{	
		int minVal = Integer.MAX_VALUE;
		int minIndex = 0;
		for (int r = 0; r < grid.length; r++) {
			 int totalChange = drawPath(r);
			 if(totalChange > 0) {
			 	if (totalChange < minVal) {
				 minVal = totalChange;
				 minIndex = r;
			 	}
				 
			 }
		}
		return minIndex;
	}
}