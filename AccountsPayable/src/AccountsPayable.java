import java.util.Scanner;

public class AccountsPayable {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Employees[] payableEmployees = new Employees[6];

		for (int i = 0; i < payableEmployees.length; i++) {
            System.out.println("\nEmployee #" + (i + 1) + " Entry:");
            System.out.println("1: Salaried | 2: Commission | 3: Hourly | 4: BasePlus");
            System.out.print("Select type: ");
            int type = input.nextInt();

            System.out.print("First Name: ");
            String first = input.nextLine();
            System.out.print("Last Name: ");
            String last = input.nextLine();
            System.out.print("SSN: ");
            String ssn = input.nextLine();
			
			 if (type == 1) {
	                System.out.print("Weekly Salary: ");
	                payableEmployees[i] = new SalariedEmployee(first, last, ssn, input.nextDouble());
	            } 
	            else if (type == 2) {
	                System.out.print("Gross Sales: ");
	                double sales = input.nextDouble();
	                System.out.print("Commission Rate: ");
	                payableEmployees[i] = new CommisionEmployee(first, last, ssn, sales, input.nextDouble());
	            } 
	            else if (type == 3) {
	                System.out.print("Hourly Wage: ");
	                double wage = input.nextDouble();
	                System.out.print("Hours: ");
	                payableEmployees[i] = new HourlyEmployee(first, last, ssn, wage, input.nextDouble());
	            } 
	            else if (type == 4) {
	                System.out.print("Gross Sales: ");
	                double sales = input.nextDouble();
	                System.out.print("Commission Rate: ");
	                double rate = input.nextDouble();
	                System.out.print("Base Salary: ");
	                payableEmployees[i] = new BasePlusCommisionEmployee(first, last, ssn, sales, rate, input.nextDouble());
	            } 
		}
		
		 for (Employees e : payableEmployees) {
	            if (e instanceof BasePlusCommisionEmployee) {
	                BasePlusCommisionEmployee bp = (BasePlusCommisionEmployee) e;
	                double currentBase = bp.getBasePay();
	                bp.setBasePay(currentBase * 1.10);
	            }
	            
	            for (Employees e1 : payableEmployees) {
	                System.out.printf("%s %s: $%.2f%n", e1.getFirst(), e1.getLast(), e1.getPaymentAmount());
	            }
	        }
	  
	}
}
