
public class SavingsAccount extends Account{
	
	public SavingsAccount(int id, double balance, double monthlyInterestRate, double d) {
		super(id, balance, monthlyInterestRate);
	}

	private double minimumBalance = 200;

	@Override
	public String toString() {
		return "SavingsAccount [id=" + id + ", dateCreated=" + dateCreated +",balance=" + balance + ",minimumBalance=" + minimumBalance +", annualIntrestRate="
				+ annualIntrestRate +  "]";
	}

	
	
}
