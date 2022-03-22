import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CircleAnimations
{
	private ArrayList<Circle> circles; //the circles to animate
	private int               size;    //canvas width and height (will be square)
	private Random            rng;     //use to make random numbers
	private final int RADIUS = 49;

	/** create a drawing pane of a particular size */
	public CircleAnimations(int s) {
		circles = new ArrayList<>();
		size    = s;
		rng     = new Random();

		//don't mess with this
		StdDraw.setCanvasSize(size, size); //set up drawing canvas
		StdDraw.setXscale(0, size);        //<0, 0> is bottom left.  <size-1, size-1> is top right
		StdDraw.setYscale(0, size);

		
	}
	public void addCircles() {
		for(int i = 0; i < 3; i++) {
			Color color1 = new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255));
			Circle circle1 = new Circle(rng.nextInt(size) + 1, rng.nextInt(size) + 1, rng.nextInt(RADIUS) + 1, color1, rng.nextInt(5) + 1, rng.nextInt(5) + 1);
			circles.add(circle1);
		}
	}
	
	public void addCircles(int number) {
		for(int i = 0; i < number; i++) {
			Color color1 = new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255));
			Circle circle1 = new Circle(rng.nextInt(size) + 1, rng.nextInt(size) + 1, rng.nextInt(RADIUS) + 1, color1, rng.nextInt(5) + 1, rng.nextInt(5) + 1);
			circles.add(circle1);
		}
	}
	
	public void noOverlapping(int number) {
		int i = 0;
		while (i < number) {
			int xTemp = rng.nextInt(size) + 1;
			int yTemp = rng.nextInt(size) + 1;
			int radiusTemp = rng.nextInt(RADIUS) + 1;
			
			if (yTemp - radiusTemp <= 0) {
				yTemp += radiusTemp;
			}
			
			if (xTemp - radiusTemp <= 0) {
				xTemp += radiusTemp;
			}
			
			if (yTemp + radiusTemp >= size) {
				yTemp -= radiusTemp;
			}
			
			if (xTemp + radiusTemp >= size) {
				xTemp -= radiusTemp;
			}
			
			Color color = new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255));
			Circle circle = new Circle(xTemp, yTemp, radiusTemp, color, rng.nextInt(5) + 1, rng.nextInt(5) + 1);
			
			if (overlapList(circle) == false) {
					circles.add(circle);
					i++;
			}
		}
	}
	
	public boolean overlapList(Circle circle) {
		for (int i = 0; i < circles.size(); i++) {
			if (circles.get(i).overlaps(circle) == true) {
				return true;
			}
		}
		return false;
	}
	
	public void movingCircles() {
		noOverlapping(20);
		while (true) {
			for (int i = 0; i < circles.size(); i++) {
				circles.get(i).update();
			}

			removeClicked();
			drawCircles();
			StdDraw.show(30);
			StdDraw.clear();
		}
	}
	
	public void drawCircles() {
		for (int i = 0; i < circles.size(); i++) {
			circles.get(i).draw();
		}
	}
	
	public void removeClicked() {
		if (StdDraw.isMousePressed()) {
			int xMouseClicked = (int) StdDraw.mouseX();
			int yMouseClicked = (int) StdDraw.mouseY();
			
			Circle mouseClickCircle = new Circle(xMouseClicked, yMouseClicked, 1, Color.white);
			for(int i = 0; i < circles.size(); i++) {
				if (circles.get(i).overlaps(mouseClickCircle) == true) {
					circles.remove(i);
					i--;
				}
			}
		}
	}
}
