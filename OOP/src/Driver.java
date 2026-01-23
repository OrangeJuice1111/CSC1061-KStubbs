
public class Driver {

	public static void main(String[] args) {

		Car myCar = new Car("Pink");
		
		Car car2 = new Car("Blue", 2.0);
		car2.setGroundClearance(12);
		System.out.println(car2.toString());
		car2.drive(8);
	}

}
