import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Path
{
	private Point[] points;
	private double  minX, minY; //min X and Y values, for setting canvas scale
	private double  maxX, maxY; //maxes

	/** construct a path from a given file */
	public Path(String fileName)
	{
		File file = new File(fileName);
  	  	int i = 0;
  	  	
		try {
		      Scanner console = new Scanner(file);
		      points = new Point[console.nextInt()];
		      console.nextLine();
		      System.out.println();
		      while (console.hasNextLine()) {
		    	  String line = console.nextLine();
		    	  line = line.trim();
		    	  String[] coordinates = line.split("\\s+");
		    	  String XStr = coordinates[0];
		    	  String YStr = coordinates[1];
		    	  XStr.trim();
		    	  YStr.trim();
		    	  double xVal = Double.parseDouble(XStr);
		    	  double yVal = Double.parseDouble(YStr);
		  		  Point p = new Point(xVal, yVal);
		  		  points[i] = p;
		  		  i++;
		      }
		      console.close();
		    } 
		
		catch (FileNotFoundException error) {
		      System.out.println("An error occurred.");
		      error.printStackTrace();
		}
		
		double xMin = Integer.MAX_VALUE;
		double xMax = Integer.MIN_VALUE;
		
		double yMin = Integer.MAX_VALUE;
		double yMax = Integer.MIN_VALUE;
		
		for (int a = 0; a < points.length; a++) {
			if (points[a].getX() < xMin) {
				xMin = points[a].getX();
			}
			if (points[a].getX() > xMax) {
				xMax = points[a].getX();
			}
			
			if (points[a].getY() < yMin) {
				yMin = points[a].getY();
			}
			if (points[a].getY() > yMax) {
				yMax = points[a].getY();
			}
		}
		
		this.maxX = xMax;
		this.minX = xMin;
		this.maxY = yMax;
		this.minY = yMin;
	}

	/** returns the distance traveled going point to point, in order given in file */
	public double getDistance()
	{
		double sum = 0;
		
		for (int i = 0; i < points.length - 1; i++) {
			sum += points[i].getDistance(points[i + 1]);
			points[i].setVisited(true); //Alternatively, visited can be set in DrawPath
		}
		return sum;
	}

	@Override
	public String toString()
	{
		return "This path's distance is " + getDistance();
	}
	
	public double getMinX() {
		return minX;
	}

	public double getMinY() {
		return minY;
	}

	public double getMaxX() {
		return maxX;
	}

	public double getMaxY() {
		return maxY;
	}
	
	public int getNumPoints() {
		return points.length;
	}
	
	public Point getPoint(int index) {
		return points[index];
	}
	
	public Point[] getPoints() {
		return this.points;
	}
}
