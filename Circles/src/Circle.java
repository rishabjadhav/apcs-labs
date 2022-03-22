import java.awt.Color;

public class Circle {
	private int x;
	private int y;
	private int dx;
	private int dy;
	private int radius;
	private Color color;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRadius() {
		return radius;
	}

	public Color getColor() {
		return color;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Circle() {
	}
	
	public Circle(int xCoord, int yCoord, int circleRadius, Color circleColor) {
		x = xCoord;
		y = yCoord;
		radius = circleRadius;
		color = circleColor;
	}
	
	public Circle(int xCoord, int yCoord, int circleRadius, Color circleColor, int dxCircle, int dyCircle) {
		x = xCoord;
		y = yCoord;
		radius = circleRadius;
		color = circleColor;
		dx = dxCircle;
		dy = dyCircle;
	}

	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x, y, radius);
	}
	
	public boolean overlaps(Circle other) {
		double distanceOverlap = 0;
		distanceOverlap = Math.sqrt(Math.pow((other.getX() - x), 2) + Math.pow((other.getY() - y), 2));
		if (distanceOverlap < (other.getRadius() + radius)) {
			return true;
		}
		else { return false; }
	}
	
	public void update() {
		bounce();
		x += dx;
		y += dy;
	}
	
	public void bounce() {

		if (x + radius > 600) {
			dx *= -1;
		}
		
		if (y + radius > 600) {
			dy *= -1;
		}
		
		if (y - radius <= 0) {
			dy *= -1;
		}
		
		if (x - radius <= 0) {
			dx *= -1;
		}
	}
}
