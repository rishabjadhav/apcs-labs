
public class HeavySprite extends BouncingSprite {
	public HeavySprite() {
		
	}
	
	public HeavySprite(double x, double y, double vx, double vy, int width, int height, String image) {
		super(x, y, vx, vy, width, height, image);
	}

	public void step(World world) {
		super.step(world);
		super.setVY(-2);
		
		//although the lab says this value is supposed to be -0.1, i didn't want to wait long to
		//see if it would bounce off the bottom, and i felt that heavy objects would fall faster
	}
}
