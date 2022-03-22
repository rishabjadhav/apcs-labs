
public class MobileSprite extends Sprite {
	private double vx, vy;
	
	public MobileSprite() {
		super();
	}
	
	public MobileSprite(double x, double y, double vx, double vy, int width, int height, String image) {
		super(x, y, width, height, image);
		this.vx = vx;
		this.vy = vy;
	}
	
	public void step(World world) {
		super.setX(getX() + vx);
		super.setY(getY() + vy);
	}

	public double getVX() {
		return vx;
	}

	public void setVX(double vx) {
		this.vx = vx;
	}

	public double getVY() {
		return vy;
	}

	public void setVY(double vy) {
		this.vy = vy;
	}
}
