
public class Farm {

	public static void main(String[] args) {
		
		Cat tango = new Cat("tango", 2.0, 1.0, 3);
		System.out.println(tango);
		
		System.out.println(tango.makeSound());
		
		Horse rosko = new Horse(3);
		//rosco.setName("Rosko");
		System.out.println(rosko.makeSound());

	}
	
	
}
