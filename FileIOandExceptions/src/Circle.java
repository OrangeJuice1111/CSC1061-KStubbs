
public class Circle extends GeometricObject{

	private double radius = 1.0;
	
	public Circle() {
		this.radius = 1.0;
	}
	
	public Circle(String color, boolean isFilled, double radius) {
		super(color, isFilled);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	
//	public static int getArea() {
//		return (int) (Math.PI * radius * radius);
//	}
	
	public double getArea(double radius) {
		return Math.PI * radius * radius;
	}
	
	public double getCirc(double radius) {
		return (2 * Math.PI) * radius;
	}
	
	public double modifyRadius(int modifier) {
		radius = radius * modifier;
		return radius;
	}
	
	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", getColor()=" + getColor() + ", isFilled()="
	+ isFilled() + ", getDateCreated()=" + getDateCreated() + "]";
	}
	
	
	
	
}
