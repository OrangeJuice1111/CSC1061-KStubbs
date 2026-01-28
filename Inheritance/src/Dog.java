
public class Dog extends Animal{
	private int barkVolume;
	
	public Dog(int barkVolume) {
		super();
		this.barkVolume = barkVolume;
	}
	public Dog(String name, double weight, double height, int barkVolume) {
		super(name,weight,height);
		barkVolume = bV;
	}
	
	@Override
	public String makeSound() {
		return "Bow Wow";
	}
	@Override
	public String toString() {
		return "Dog [barkVolume=" + barkVolume + ", makeSound()=" + makeSound() + ", getName()=" + getName()
				+ ", getWeight()=" + getWeight() + ", getHeight()=" + getHeight() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
