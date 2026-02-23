import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

	public static final String PERSON_DATABASE = "PersonDatabase";
	
	 public Database() {
	        try {
	            File file = new File(PERSON_DATABASE);
	            if (!file.exists()) {
	                file.createNewFile();
	                System.out.println("Created new file: " + PERSON_DATABASE);
	            } else {
	                System.out.println("file already exists: " + PERSON_DATABASE);
	            }
	        } catch (IOException e) {
	            System.err.println("Error creating the file: " + e.getMessage());
	        }
	    }

	    public void writePerson(Person person) {
	        try (FileWriter writer = new FileWriter(PERSON_DATABASE, true)) { // 'true' for append mode
	            writer.write(person.getClass().getSimpleName() + "\n");
	            writer.write(person.toString() + "\n");
	          	        } catch (IOException e) {
	            System.err.println("Error writing to the  file: " + e.getMessage());
	        }
	    }

	    public ArrayList<Person> readDatabase() {
	        ArrayList<Person> persons = new ArrayList<>();
	        try (Scanner scanner = new Scanner(new File(PERSON_DATABASE))) {
	            while (scanner.hasNextLine()) {
	                String className = scanner.nextLine().trim();
	                if (className.isEmpty()) { 
	                	continue;
	                }
	                StringBuilder personData = new StringBuilder();

	                String line;
	                while (scanner.hasNextLine() && !(line = scanner.nextLine()).equals("-----")) {
	                    personData.append(line).append("\n");
	                }

	                Person person = parsePerson(className, personData.toString());
	                if (person != null) {
	                    persons.add(person);
	                }
	            }
	        } catch (IOException e) {
	            System.err.println("Error reading from the file: " + e.getMessage());
	        }
	        return persons;
	    }

	 private Person parsePerson(String className, String data) {
	        String[] lines = data.split("\n");
	        String name = "", address = "", phone = "", email = "";

	        for (String line : lines) {
	            if (line.startsWith("Name: ")) name = line.substring("Name: ".length()).trim();
	            else if (line.startsWith("Address: ")) address = line.substring("Address: ".length()).trim();
	            else if (line.startsWith("Phone Number: ")) phone = line.substring("Phone Number: ".length()).trim();
	            else if (line.startsWith("Email address: ")) email = line.substring("Email address: ".length()).trim();
	        }

	        switch (className) {
	            case "Student":
	                String status = "";
	                for (String line : lines) {
	                    if (line.startsWith("Status: ")) status = line.substring("Status: ".length()).trim();
	                }
	                return new Student(name, address, phone, email, status);

	            case "Faculty":
	                String officeF = "", dateHiredF = "", officeHours = "", rank = "";
	                double salaryF = 0.0;
	                for (String line : lines) {
	                    if (line.startsWith("Office: ")) officeF = line.substring("Office: ".length()).trim();
	                    else if (line.startsWith("Salary: ")) salaryF = Double.parseDouble(line.substring("Salary: ".length()).trim());
	                    else if (line.startsWith("Date Hired: ")) dateHiredF = line.substring("Date Hired: ".length()).trim();
	                    else if (line.startsWith("Office Hours: ")) officeHours = line.substring("Office Hours: ".length()).trim();
	                    else if (line.startsWith("Rank: ")) rank = line.substring("Rank: ".length()).trim();
	                }
	                return new Faculty(name, address, phone, email, officeF, salaryF, dateHiredF, officeHours, rank);

	            case "Staff":
	                String officeS = "", dateHiredS = "", title = "";
	                double salaryS = 0.0;
	                for (String line : lines) {
	                    if (line.startsWith("Office: ")) officeS = line.substring("Office: ".length()).trim();
	                    else if (line.startsWith("Salary: ")) salaryS = Double.parseDouble(line.substring("Salary: ".length()).trim());
	                    else if (line.startsWith("Date Hired: ")) dateHiredS = line.substring("Date Hired: ".length()).trim();
	                    else if (line.startsWith("Title: ")) title = line.substring("Title: ".length()).trim();
	                }
	                return new Staff(name, address, phone, email, officeS, salaryS, dateHiredS, title);

	            case "Employee": // Should not be directly instantiated if only subclasses are used
	                String officeE = "", dateHiredE = "";
	                double salaryE = 0.0;
	                for (String line : lines) {
	                    if (line.startsWith("Office: ")) officeE = line.substring("Office: ".length()).trim();
	                    else if (line.startsWith("Salary: ")) salaryE = Double.parseDouble(line.substring("Salary: ".length()).trim());
	                    else if (line.startsWith("Date Hired: ")) dateHiredE = line.substring("Date Hired: ".length()).trim();
	                }
	                return new Employee(name, address, phone, email, officeE, salaryE, dateHiredE);

	            case "Person": // Should not be directly instantiated if only subclasses are used
	                return new Person(name, address, phone, email);

	            default:
	                System.err.println("Unknown class type encountered during parsing: " + className);
	                return null;
	        }
	    }
}
