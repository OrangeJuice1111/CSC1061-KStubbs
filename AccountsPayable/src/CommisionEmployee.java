
public class CommisionEmployee extends Employees{
	private double grossSales;
	protected double commisionRate;
	public CommisionEmployee(double grossSales, double commisionRate) {
		super();
		this.grossSales = grossSales;
		this.commisionRate = commisionRate;
	}
	public double getGrossSales() {
		return grossSales;
	}
	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}
	public double getCommisionRate() {
		return commisionRate;
	}
	public void setCommisionRate(double commisionRate) {
		this.commisionRate = commisionRate;
	}
	
	@Override
	double getPaymentAmount(){
		return grossSales * commisionRate;
	}
	@Override
	public String toString() {
		return "CommisionEmployee [Payment Amount= " + getPaymentAmount() + ", getFirst()="
				+ getFirst() + ", getLast()=" + getLast() + ", getSSN()=" + getSSN() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	double getPaymentMethod() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
