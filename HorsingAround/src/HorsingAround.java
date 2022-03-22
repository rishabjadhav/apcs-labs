import java.util.*;

public class HorsingAround
{
    public static int totalWidth(ArrayList<Animal> animals)
    {
    	int total = 0;
    	for (int i = 0; i < animals.size(); i++) {
    		total += animals.get(i).getWidth();
    	}
        return total;
    }

    public static Animal tallestAnimal(ArrayList<Animal> animals)
    {
    	int tallest = 0;
    	Animal tall = new Animal();
    	for (int i = 0; i < animals.size(); i++) {
    		if (animals.get(i).getHeight() > tallest) {
    			tallest = animals.get(i).getHeight();
    			tall = animals.get(i);
    		}
    	}
    	return tall;
    }

    public static int countYourChickens(ArrayList<Animal> animals)
    {
    	int chickens = 0;
    	for (int i = 0; i < animals.size(); i++) {
    		if (animals.get(i).getName().equals("chicken")) {
    			chickens++;
    		}
    	}
    	return chickens;
    }

    public static ArrayList<String> inventory(ArrayList<Animal> animals)
    {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < animals.size(); i++) {
    		names.add(animals.get(i).getName());
    	}
        return names;
    }

    public static void pestControl(ArrayList<Animal> animals)
    {
    	for (int i = 0; i < animals.size(); i++) {
    		if (animals.get(i).getName().equals("mouse")) {
    			animals.remove(i);
    			i--;
    		}
    	}
    }
    
    //7. Friday

    public static void horsingAround(ArrayList<Animal> animals)
    {
    	Animal horse = new Animal("Horse");
    	for (int i = 0; i < animals.size(); i++) {
    		if (i == 0) {
    			animals.add(i, horse);
    		}
    		else if (i % 2 == 0) {
    			animals.add(i, horse);
    		}
    	}
    }

    public static void feelingSheepish(ArrayList<Animal> animals)
    {
    	Animal sheep = new Animal("Sheep");
    	for (int i = 0; i < animals.size(); i++) {
    		if ((animals.get(i).getName().contains("Sheep")) && (i > 0) && (i < animals.size() - 1)) {
    			animals.add(i--, sheep);
    			animals.add(i++, sheep);
    		}
    	}
    }
}