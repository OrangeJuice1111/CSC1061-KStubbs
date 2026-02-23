import java.util.ArrayList;

public class TestSchoolRecords {

	public static void main(String[] args) {
		Database database = new Database();
		
		 Student student1 = new Student(
		            "Alice Smith","123 College Ave", "555-1111", "alice.s@school.edu", "freshman"
		        );

		        Student student2 = new Student(
		            "Bob Johnson", "456 Dormitory Rd","555-2222", "bob.j@school.edu", "junior"
		        );

		        Faculty faculty1 = new Faculty(
		            "Dr. Carol White","789 Faculty Ln", "555-3333", "carol.w@school.edu", "F-101", 85000.00, "2010-08-15","Mon/Wed 10-12", "senior"
		        );

		        Faculty faculty2 = new Faculty(
		            "Dr. David Green", "101 University Dr","555-4444", "david.g@school.edu", "F-205",70000.00,"2022-01-01", "Tue/Thu 1-3", "junior"
		        );

		        Staff staff1 = new Staff(
		            "Eve Black", "202 Admin Bldg", "555-5555", "eve.b@school.edu", "A-100", 45000.00, "2018-03-10", "Administrative Assistant"
		        );

		        Staff staff2 = new Staff(
		            "Frank Brown", "303 Maintenance", "555-6666", "frank.b@school.edu", "M-001", 50000.00, "2015-06-20", "Head Custodian"
		        );
		
		 database.writePerson(student1);
	        database.writePerson(student2);
	        database.writePerson(faculty1);
	        database.writePerson(faculty2);
	        database.writePerson(staff1);
	        database.writePerson(staff2);
	        
	        
	        
	        ArrayList<Person> personsFromFile = database.readDatabase();

	        if (personsFromFile.isEmpty()) {
	            System.out.println("No persons found in the database file.");
	        } else {
	            for (Person p : personsFromFile) { 
	                System.out.println("Class Type: " + p.getClass().getSimpleName()); 
	                System.out.println(p.toString());
	            }
	        }
	}

	
}
