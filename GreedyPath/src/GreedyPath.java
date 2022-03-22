import java.util.Arrays;

public class GreedyPath extends Path {
	
	private Point[] greedyPoints;
	private Point[] originalPoints;
	
	public GreedyPath(String fileName) {
		super(fileName);
		originalPoints = super.getPoints();
		greedyPoints = new Point[originalPoints.length];
		
		greedyPoints[0] = originalPoints[0];
		originalPoints[0].setVisited(true);
		
		for (int i = 1; i < originalPoints.length; i++) {
			greedyPoints[i] = originalPoints[findClosestPoint(i - 1)];
		}
	}
	 
	private int findClosestPoint(int index) {
		double distance = Integer.MAX_VALUE;
		int closest = 0;
		for (int i = 0; i < originalPoints.length; i++) {
			double tempDistance = greedyPoints[index].getDistance(originalPoints[i]);
			
			if (tempDistance < distance && (originalPoints[i].isVisited() == false)) {
				distance = tempDistance;
				closest = i;
			}
		}
		originalPoints[closest].setVisited(true);
		return closest;
		
	}
	
	@Override
	public double getDistance()
	{
		double sum = 0;
		
		for (int i = 0; i < greedyPoints.length - 1; i++) {
			sum += greedyPoints[i].getDistance(greedyPoints[i + 1]);
			greedyPoints[i].setVisited(true);
		}
		return sum;
	}
	
	@Override
	public String toString()
	{
		return "This Greedy Path's distance is " + getDistance();
	}
	
	public Point getPoint(int index) {
		return greedyPoints[index];
	}

}
