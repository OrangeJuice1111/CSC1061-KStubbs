
public class SalariedEmployee extends Employees{
	private double weeklySalary;

	public SalariedEmployee(String first, String last, String ssn, double weeklySalary) {
		super();
		this.weeklySalary = weeklySalary;
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	@Override
	double getPaymentAmount(){
		return weeklySalary;
	}

	@Override
	public String toString() {
		return "SalariedEmployee [Payment Amount=" + getPaymentAmount() + ", getFirst()=" + getFirst() + ", getLast()="
				+ getLast() + ", getSSN()=" + getSSN() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
