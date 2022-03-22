import java.util.ArrayList;

import java.util.List;
import java.util.Random;


public abstract class Animal {
	protected int      age;
	protected boolean  alive;
	protected Field    field;
	protected Location location;
	
	public abstract int getMaxAge();
	public abstract int getBreedingAge();
	public abstract double getBreedingProbability();
	public abstract int getMaxLitterSize();
	
	public abstract void step();
	
	public Animal(Field field, Location location) {
		this.age = 0;
		this.alive = true;
		this.field = field;
		this.location = location;
	}

	public void setLocation (Location l) {
		this.location = l;
	}
	
	public boolean isAlive() {
		if (alive == true) {
			return true;
		}
		return false;
	}
	
	/** Method called when a Rabbit becomes deceased */
	public void setDead()
	{
		alive = false;
		field.remove(location);
	}
	
	/**
	 * Increase the Animal's age.
	 * This could result in the animal's death.
	 */
	protected void incrementAge()
	{
		age++;
		if (age > getMaxAge()) {
			this.setDead();
		}
	}
	
	/**
	 * A rabbit can breed if it has reached breeding age.
	 * @return true if the rabbit can breed, false otherwise.
	 */
	protected boolean canBreed()
	{
		if (age >= getBreedingAge()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Generate a number representing the number of births, if it can breed.
	 * @return The number of births (may be zero).
	 */
	protected int breed()
	{
		int litterSize = 0;
		
		if (canBreed()) {
			Random rng = new Random();
			double p = rng.nextDouble();
			
			if (p <= getBreedingProbability()) {
				litterSize = rng.nextInt(getMaxLitterSize() + 1);
			}
		}
		return litterSize;
	}
	
	public String toString() { 
		return "Rabbit, <" + age + "> y/o, at <" + location + ">";
	}
}
