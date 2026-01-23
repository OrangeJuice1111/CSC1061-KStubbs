
public class Car {
	//data members
	private String color;
	private double amountOfGas;
	private int milage;
	private int groundClearanceFt;
	private int groundClearanceInches;
	//Constructors
	public Car(String rcolor){ // constructor has to be public
		color = rcolor;
		amountOfGas = 1.0;
		milage = 5;
	}
	
	public Car() {
		
	}
	
	public Car(String color, double gas) {
		this.color = color;
		amountOfGas = gas;
		milage = 0;
	}
	
	//Getters and Setters (accessors or mutators)
	//all getters and setters should be private
	public String getColor() {
		return color;
	}
	
	
	public void setColor(String color) {
		this.color = color;
	}

	public double getAmountOfGas() {
		return amountOfGas;
	}

	public void setAmountOfGas(double amountOfGas) {
		this.amountOfGas = amountOfGas;
	}

	public int getMilage() {
		return milage;
	}

//	public int getGroundClearance() {
//		return groundClearance;
//	}

	public void setGroundClearance(int groundClearance) {
		this.groundClearanceFt = groundClearance/12;
		this.groundClearanceInches = groundClearance % 12;
	}
	
	//Methods
	public void drive(int numMiles) {
		for (int i = 0; i < numMiles; i++)
		{
			System.out.print("+");
		
		}
		amountOfGas -= numMiles;
		milage = milage + numMiles;
		System.out.println();
	}
	
	
	
	
	//toString();
	@Override
	public String toString() {
		return "Car: Color: " + color + "\nAmount of Gas: "
				+ amountOfGas + "\nMilage: " + milage;
	}
	
	

}
