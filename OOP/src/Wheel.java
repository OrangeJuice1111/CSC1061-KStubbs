
public class Wheel {
	private String material;
	private int radius;
	
	

	public Wheel(String material, int radius) {
		super();
		this.material = material;
		this.radius = radius;
	}
	
	public String getMaterial() {
		return material;
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public String toString() {
		return "Wheel [material=" + material + ", radius=" + radius + "]";
	}

	
}
