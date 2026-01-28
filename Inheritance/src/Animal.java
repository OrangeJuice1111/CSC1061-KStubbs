
public class Animal {
	private String name = "Creature";
	private double weight = 1.0;
	private double height = 1.0;
	
	
	public Animal(String name, double weight, double height) {
		this.name = name;
		this.weight = weight;
		this.height = height;
	}

	public Animal() {
//		name = "Creature";
//		weight = 1.0;
//		height = 1.0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String makeSound() {
		return "blah blah";
	}
	
	
	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", weight=" + weight + ", height=" + height + "]";
	}
	
	
}
