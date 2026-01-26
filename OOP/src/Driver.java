
public class Driver {

	public static void main(String[] args) {

		Car myCar = new Car("Pink");
		myCar.drive(10);
		myCar.getRadio().setVolume(6);
		System.out.println("Number of Cars: "+ myCar.getCount());
		
		Wheel[] wheels = myCar.getWheels();
		System.out.println("Radius of Wheel: "+ wheels[1].getRadius());
		
		Car car1 = new Car();
		System.out.println("Is car clean?" + car1.isClean());
		car1.selfCleanCar();
		System.out.println("Car cleaned " + car1.isClean());
		
		
		System.out.println("Number of Cars: "+ car1.getCount());
		System.out.println("ID of car: "+ car1.getId());

//		Car car2 = new Car("Blue", 2.0);
//		car2.setGroundClearance(12);
//		System.out.println(car2.toString());
//		car2.drive(8);
	}

}
