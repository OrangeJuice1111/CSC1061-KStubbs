
public class BasePlusCommisionEmployee extends CommisionEmployee{
	public BasePlusCommisionEmployee(double grossSales, double commisionRate) {
		super(grossSales, commisionRate);
		
	}
	private double basePay;
	
	public BasePlusCommisionEmployee(String first, String last, String ssn, double grossSales, double commisionRate, double basePay) {
		super(ssn, ssn, ssn, grossSales, commisionRate);
		this.basePay = basePay;
	}
	
	public double getBasePay() {
		return basePay;
	}
	public void setBasePay(double basePay) {
		this.basePay = basePay;
	}
	
	@Override
	double getPaymentMethod() {
		return basePay + commisionRate;
	}

	@Override
	public String toString() {
		return "BasePlusCommisionEmployee ["
				+ "getPaymentAmount()=" + getPaymentAmount() + ", toString()=" + super.toString() + ", getFirst()="
				+ getFirst() + ", getLast()=" + getLast() + ", getSSN()=" + getSSN() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
}
