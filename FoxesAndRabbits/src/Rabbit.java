import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class Rabbit extends Animal
{
	/* Characteristics shared by all rabbits (static fields). */

	private static final int    BREEDING_AGE = 5;
	private static final int    MAX_AGE = 15;
	private static final double BREEDING_PROBABILITY = 0.22;
	private static final int    MAX_LITTER_SIZE = 6;

	/* Individual characteristics (instance fields). */
 //stores a reference to this Rabbit's current location

	/**
	 * Create a new rabbit. A rabbit is created with age zero (a new born).
	 */
	public Rabbit(Field field, Location location)
	{
		super(field, location);
	}
	
	public int getMaxAge() {
		return MAX_AGE;
	}
	
	public int getBreedingAge() {
		return BREEDING_AGE;
	}

	public double getBreedingProbability() {
		return BREEDING_PROBABILITY;
	}

	public int getMaxLitterSize() {
		return MAX_LITTER_SIZE;
	}

	public Location getLocation() {
		return location;
	}

	/**
	 * This is what the rabbit does most of the time - it runs 
	 * around. Sometimes it will breed or die of old age.
	 */
	public void step()
	{
		incrementAge();
		if (!this.isAlive()) {
			return;
		}
		
		int litterSize = this.breed();
		
		for (int i = 0; i < litterSize; i++) {
			Location l = field.freeAdjacentLocation(this.location);
			if (l != null) {
				Rabbit r = new Rabbit(field, l);
				field.place(r, l);
			}
			else { break; }
		}
		
		Location l = field.freeAdjacentLocation(location);
		if (l == null) {
			this.setDead();
		} else { 
			field.move(location, l);
			location = l;
		}
	}
	
}
