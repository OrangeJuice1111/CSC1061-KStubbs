import java.time.LocalDate;

public class CheckingAccount extends Account{

	private double overdraftLimit = 200;

	public CheckingAccount(String string, int id, double balance, double monthlyInterestRate, double d) {
		super(id, balance, monthlyInterestRate);
		
	}

	@Override
	public String toString() {
		return "CheckingAccount [id=" + id + ", Date Created=" + dateCreated +", balance=" + balance +", Overdraft Limit=" + overdraftLimit + ", annualIntrestRate=" + annualIntrestRate + "]";
	}

	
	
}
