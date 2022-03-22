
public class BouncingSprite extends MobileSprite {
	
	public BouncingSprite() {
		
	}
	
	public BouncingSprite(double x, double y, double vx, double vy, int width, int height, String image) {
		super(x, y, vx, vy, width, height, image);
	}
	
	public void step(World world) {
		super.step(world);
		bounce();
	}
	
	public void bounce() {
		if (super.getX() + (super.getWidth()/2) > 600) {
			super.setVX(super.getVX() * -1);
		}
		
		if (super.getY() + (super.getHeight()/2) > 600) {
			super.setVY(super.getVY() * -1);
		}
		
		if (super.getX() - super.getWidth()/2 <= 0) {
			super.setVX(super.getVX() * -1);
		}
		
		if (super.getY() - super.getHeight()/2 <= 0) {
			super.setVY(super.getVY() * -1);
			super.setY(getY() + 2);
		}
	}
}
