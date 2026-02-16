
public class HourlyEmployee extends Employees{
	private double hourlyRate;
	private double hours;
	public HourlyEmployee(double hourlyRate, double hours) {
		super();
		this.hourlyRate = hourlyRate;
		this.hours = hours;
	}
	public HourlyEmployee(String first, String last, String ssn, double wage, double nextDouble) {
		// TODO Auto-generated constructor stub
	}
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}
	
	@Override
	double getPaymentAmount() {
		return hourlyRate * hours;
	}
	@Override
	public String toString() {
		return "HourlyEmployee [Payment Amount=" + getPaymentAmount() + ", getFirst()=" + getFirst()
				+ ", getLast()=" + getLast() + ", getSSN()=" + getSSN() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
}
