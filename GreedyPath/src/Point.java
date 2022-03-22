public class Point 
{
	private double  x, y;
	private boolean visited;
	
	public Point() {
		visited = false;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		visited = false;
	}

	public double getDistance(Point other)
	{
		double distance = Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
		return distance;
	}
	
	@Override
	public String toString()
	{
		if (visited == true) {
			return "This point is at (" + this.x + ", " + this.y + "). This point has been visited";
		}
		else {
			return "This point is at (" + this.x + ", " + this.y + "). This point has not been visited";
		}
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
