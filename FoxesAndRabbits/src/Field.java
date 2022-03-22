import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field
{    
	private int height, width;
	private Animal[][] field;

	/**
	 * Represent a field of the given dimensions.
	 * @param height The height of the field.
	 * @param width The width of the field.
	 */
	public Field(int height, int width)
	{
		this.height = height;
		this.width = width;
		field = new Animal[height][width];
	}

	/** Empty the field */
	public void clear()
	{
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				this.field[i][j] = null;
			}
		}
	}

	/**
	 * Place an animal at the given location.
	 * If there is already an animal at the location it will
	 * be lost.
	 * @param animal The animal to be placed.
	 * @param row Row coordinate of the location.
	 * @param col Column coordinate of the location.
	 */
	public void place(Animal animal, int row, int col)
	{
		this.field[row][col] = animal;
	}

	/**
	 * Place an animal at the given location.
	 * If there is already an animal at the location it will
	 * be lost.
	 * @param animal The animal to be placed.
	 * @param location Where to place the animal.
	 */
	public void place(Animal animal, Location location)
	{
		this.place(animal, location.getRow(), location.getCol());
	}
	
	/**
	 * Move an Object from one location in the field to another
	 * @param oldLocation Object's old location
	 * @param newLocation Object's new location
	 */
	public void move(Location oldLocation, Location newLocation)
	{
		this.place(this.getObjectAt(oldLocation), newLocation);
		this.remove(oldLocation);
	}
	
	/**
	 * Remove an Object from a particular location
	 * @param location
	 */
	public void remove(Location location)
	{
		this.field[location.getRow()][location.getCol()] = null;
	}
	
	/**
	 * Return the animal at the given location, if any.
	 * @param location Where in the field.
	 * @return The animal at the given location, or null if there is none.
	 */
	public Animal getObjectAt(Location location)
	{
		return this.getObjectAt(location.getRow(), location.getCol());
	}

	/**
	 * Return the animal at the given location, if any.
	 * @param row The desired row.
	 * @param col The desired column.
	 * @return The animal at the given location, or null if there is none.
	 */
	public Animal getObjectAt(int row, int col)
	{
		Animal obj = field[row][col];
		return obj;
	}
	
	
	//I added this method myself for the sake of simplicity when checking boundary conditions
	public boolean inBounds(Location l) {
		if ((l.getRow() < height && l.getCol() < width) && (l.getRow() >= 0 && l.getCol() >= 0)) {
				return true;
		}
		return false;
	}

	/**
	 * Generate a shuffled List of locations adjacent to the given one - will 
	 * not include the location itself. All locations will lie within the grid.
	 * @param location The location from which to generate adjacencies.
	 * @return A randomized list of locations adjacent to that given.
	 */
	public List<Location> adjacentLocations(Location location)
	{
		List<Location> adjLoc = new ArrayList<Location>();
		
		for (int row = -1; row < 2; row++) {
			for (int col = -1; col < 2; col++) {
				if (row == 0 && col == 0) {
					continue;
				}
				
				Location l = new Location(location.getRow() + row, location.getCol() + col);
				if (inBounds(l) == true) {
					adjLoc.add(l);
				}
				
			}
		}
		
		Collections.shuffle(adjLoc);
		return adjLoc;
	}

	/**
	 * Try to find a free location that is adjacent to the given location. 
	 * If there is none, return null. The returned location will be within 
	 * the valid bounds of the field.
	 * @param location The location from which to generate an adjacency.
	 * @return A valid free location within the grid area, or null if all
	 *         locations around are full.
	 */
	public Location freeAdjacentLocation(Location location)
	{
		List<Location> freeLocs = adjacentLocations(location);
		
		for (int i = 0; i < freeLocs.size(); i++) {
			if (getObjectAt(freeLocs.get(i)) != null) {
				continue;
			}
			else {return freeLocs.get(i);}
		}
		return null;
	}

	@Override
	public String toString() //quick picture of the state of the field, for debugging
	{
		String result = "";
		
		for (int r = 0; r < this.height; r++)
		{
			for (int c = 0; c < this.width; c++)
			{
				Animal obj = this.field[r][c];
				
				if (obj instanceof Rabbit)
					result += "R\t";
				else if (obj instanceof Fox)
					result += "F\t";
				else
					result += "x\t";
			}
			result += "\n";
		}
		
		return result;
	}
	
	public int getHeight() { return this.height; }
	
	public int getWidth() { return this.width; }
}
