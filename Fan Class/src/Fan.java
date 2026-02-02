
public class Fan {
	private int Slow = 1;
	private int Medium = 2;
	private int Fast = 3;
	private int speed;
	private boolean on = false;
	private double radius;
	String color = "blue";
	private static int nextId = 0;
	private int id = 0;
	String Fan = "Fan";
	
	
	
public Fan(int speed, boolean on, int radius, String color) {
		super();
		this.speed = speed;
		this.on = on;
		this.radius = radius;
		this.color = color;
		this.id = id ++;
	}
	
	
	private void Fan() {
		this.id = nextId++;
		System.out.println(id);
		
	}


	@Override
	public String toString() {
		return "Fan [speed=" + speed + ", fan is on " + on + ", radius=" + radius + ", color=" + color + ", id=" + id + "]";
	}
	
	
	
}
