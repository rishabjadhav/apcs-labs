import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class Fox extends Animal
{
	/* Characteristics shared by all foxes (static fields). */

	private static final int    BREEDING_AGE = 10;
	private static final int    MAX_AGE = 20;
	private static final double BREEDING_PROBABILITY = 0.17;
	private static final int    MAX_LITTER_SIZE = 4;
	private static final int    RABBIT_FOOD_VALUE = 8;

	/* Individual characteristics (instance fields). */

	private int      foodLevel;

	/**
	 * Create a fox. A fox is created as a new born (age zero
	 * and not hungry).
	 */
	public Fox(Field field, Location location)
	{		
		super(field, location);
		this.foodLevel = RABBIT_FOOD_VALUE;
	}
	
	@Override
	public int getMaxAge() {
		return MAX_AGE;
	}

	@Override
	public int getBreedingAge() {
		return BREEDING_AGE;
	}
	

	@Override
	public double getBreedingProbability() {
		return BREEDING_PROBABILITY;
	}

	@Override
	public int getMaxLitterSize() {
		return MAX_LITTER_SIZE;
	}

	
	
	/**
	 * This is what the fox does most of the time: it hunts for rabbits. 
	 * In the process, it might breed, die of hunger, or die of old age.
	 */
	public void step()
	{
		incrementAge();
		incrementHunger();
		if (!this.isAlive()) {
			return;
		}
		int litterSize = breed();
		
		for (int i = 0; i < litterSize; i++) {
			Location l = field.freeAdjacentLocation(location);
			if (l != null) {
				Fox f = new Fox(field, l);
				field.place(f, l);
			}
			else {break;}
		}
		
		Location foodloc = findFood();
		if (foodloc != null) {
			field.move(location, foodloc);
			this.location = foodloc;
			return;
		}
		else {
			Location l = field.freeAdjacentLocation(location);
			if (l == null) {
				setDead();
			} else {
				field.move(location, l);
				this.location = l;
			}
		}
		
	}

	/**
	 * Make this fox more hungry. This could result in the fox's death.
	 */
	private void incrementHunger()
	{
		foodLevel--;
		
		if (foodLevel < 0) {
			this.setDead();
		}
	}

	

	/**
	 * Tell the fox to look for rabbits adjacent to its current location.
	 * @return Where food was found, or null if it wasn't.
	 */
	private Location findFood()
	{
		List<Location> adjacentLocations = field.adjacentLocations(this.location);

		for (Location where : adjacentLocations) //look for Rabbits in adjacent locations
		{
			Object animal = field.getObjectAt(where);

			if (animal instanceof Rabbit) { //if this object is a rabbit...
				Rabbit rabbit = (Rabbit) animal;

				rabbit.setDead();

				this.foodLevel = Fox.RABBIT_FOOD_VALUE; //Foxes goes back to full

				return where;
			}
		}
		return null;
	}

	
}
