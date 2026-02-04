import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Database {

	private File outFile = new File("Database.csv");
	// csv = comma seperated values
	PrintWriter printer;
	Scanner reader;

	public Database() {
		try {
			if (!outFile.exists())
				;
			outFile.createNewFile();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Could not find database");
			System.exit(-1);

		}

		try {
			printer = new PrintWriter(outFile.getName());
			reader = new Scanner(outFile);

		}

		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("Database could not be created");
			System.exit(-1);
		}
	}

	public void write(GeometricObject shape) {
		printer.print(shape.getClass().getName());
		printer.print(", " + shape.getColor());
		printer.print(", " + shape.isFilled());
		if (shape instanceof Circle) {
			printer.print(", " + ((Circle) shape).getRadius());
		}
		if (shape instanceof Rectangle) {
			Rectangle rect = (Rectangle)shape;
			printer.print(", " + rect.getHeight());
			printer.print(", " + rect.getPerimiter());
		}
		printer.println();
		printer.flush();
	}
	
	public GeometricObject readObject() {//from the file
		String line;
		if(reader.hasNextLine()) {
			line = reader.nextLine();
					
		}
		else {
			return null;
		}
		
		String[] token = line.split(", ");
		GeometricObject obj = null;
		
		if(token[0].equals("Circle")) {
			obj = new Circle(token[1].trim(), 
					Boolean.parseBoolean(token[2]), 
					Double.parseDouble(token[3]));
		}
		return obj;
	}
}
