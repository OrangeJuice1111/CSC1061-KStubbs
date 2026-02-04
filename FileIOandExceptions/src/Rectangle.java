
public class Rectangle extends GeometricObject{

	private double width;
	private double height;
	
	public Rectangle() {
		this.width = 1.0;
		this.height = 1.0;
	}
	
	public Rectangle(String color, boolean isFilled, double width, double height) {
		super(color, isFilled);
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getArea(double height, double width) {
		return height * width;
		
	}
	
	public double getPerimiter() {
		return (2 * height) + (2 * width);
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", getWidth()=" + getWidth() + ", getHeight()="
				+ getHeight() + "]";
	}
	
	
}
