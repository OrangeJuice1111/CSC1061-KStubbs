
public abstract class Vehicle implements Feedable{
	
	private String Color;
	private int id;
	public Vehicle(String color, int id) {
		super();
		Color = color;
		this.id = id;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Vehicle [Color=" + Color + ", id=" + id + "]";
	}
	
	

}
