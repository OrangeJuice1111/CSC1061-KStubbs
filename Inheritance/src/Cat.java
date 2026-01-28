
public class Cat extends Animal{
	private int lengthOfWhiskers;
	
	public Cat(int lengthOfWiskers) {
		//super("Catty", 2.0, 1.0);//calls the constructor of animal()
		super();
		this.setName("Catty");
		this.lengthOfWhiskers = lengthOfWhiskers;
	}

	public Cat(String name, double weight, double height, int wLength) {
		super(name,weight,height);
		lengthOfWhiskers = wLength;
	}

	@Override
	public String makeSound() {
		return "Meow";
	}
	
	@Override
	public String toString() {
		return super.toString() + "Whiskers =" + lengthOfWhiskers;
	}

	
}
