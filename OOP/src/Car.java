
public class Car {
	
	private static final int MAX_WHEELS = 4;
	//data members
	private String color;
	private double amountOfGas;
	private int milage;
	private int groundClearanceFt;
	private int groundClearanceInches;
	private boolean isClean = false;
	static private int count = 0;
	private int id;
	private Radio radio = new Radio();
	private Wheel[] wheel = new Wheel[MAX_WHEELS]; 
	
	
	//Constructors
	public Car(String rcolor){ // constructor has to be public
		color = rcolor;
		amountOfGas = 1.0;
		milage = 5;
		count++;
		int id = count;
		radio.setVolume(5);
		id = count;
		wheel = new Wheel[3];
		assignWheels();
	}
	
	public Car() {
		count++;
		int id = count;
		assignWheels();

	}
	
	public Car(String color, double gas) {
		this.color = color;
		amountOfGas = gas;
		milage = 0;
		count++;
		int id = count;
		assignWheels();

	}
	private void assignWheels() {
		for(int i = 0; i < wheel.length; i++)
		{
			wheel[i] = new Wheel("Alloy", 16);
		}
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
	
	public int getCount() {
		return count;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isClean() {
		return isClean;
	}
	
	public Radio getRadio() {
		return radio;
	}
	
	public Wheel[] getWheels() {
		return wheel;
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
	
	public void selfCleanCar() {
		isClean = true;
	}
	
//	public static void cleanCar(Car car){
//		boolean isClean = true;
//	}
	
	
	//toString();
	@Override
	public String toString() {
		return "Car: Color: " + color + "\nAmount of Gas: "
				+ amountOfGas + "\nMilage: " + milage;
	}
	
	

}
