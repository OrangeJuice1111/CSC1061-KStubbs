
public class TestGeometricObject {

	public static void main(String[] args) {
		
		Circle cir1 = new Circle("Green", true, 2.0);
		System.out.println("Area of Circle cir1:" + cir1.getArea(0));
		
		int radius = 5;
		System.out.println("A circle with radius " + radius 
				+ " will have area " + cir1.getArea(5.0));
		

		Rectangle rect1 = new Rectangle("Red", true, 2.0, 3.0);
		System.out.println("Perimiter = " + rect1.getPerimiter());
		
		Database db = new Database();
		db.write(cir1);
		GeometricObject ob = db.readObject();
		System.out.println(ob);
		//db.write(rect1);
	}

}
