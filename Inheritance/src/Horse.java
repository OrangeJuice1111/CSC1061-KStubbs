
public class Horse extends Animal{
	private int speed;
	
	public Horse(int speed) {
		super();
		this.speed = speed;
	}
	
	
	
	@Override
	public String makeSound() {
		return "Neighh";
	}
}
