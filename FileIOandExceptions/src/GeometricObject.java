import java.util.Date;

public class GeometricObject {
	private String color= "white";
	private boolean isFilled = false;//named this way to fit into an if statement
	private Date dateCreated;
	
	//constructors
	public GeometricObject(String color, boolean isFilled) {
		this.color = color;
		this.isFilled = isFilled;
		dateCreated = new Date();
	}

	public GeometricObject() {//no arg constructor
		dateCreated = new Date();
		
	}
	
	//getters and setters
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	//toString
	@Override
	public String toString() {
		return "GeometricObject [color=" + color + ", isFilled=" + isFilled + ", dateCreated=" + dateCreated + "]";
	}

	
	
	
	
	
	
}
