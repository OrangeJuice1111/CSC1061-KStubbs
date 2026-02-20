import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
	protected int id = 0;
	protected double balance = 0.0;
	protected double annualIntrestRate = 0;
	protected LocalDate dateCreated = java.time.LocalDate.now();
	
	private ArrayList <Transaction> transactions = new ArrayList<>();
	protected String name;

	
	
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	public Account(int id, double balance, double monthlyInterestRate) {
		super();
		this.id = id;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualIntrestRate() {
		return annualIntrestRate;
	}
	public void setAnnualIntrestRate(double annualIntrestRate) {
		this.annualIntrestRate = annualIntrestRate;
	}
	public LocalDate getdateCreated() {
		return dateCreated;
	}
	
	
	double getMonthlyInterestRate(double annualInterestRate){
		return annualIntrestRate /12;
	}

	double getMonthlyInterest(double getMonthlyInterestRate){
		return balance * (getMonthlyInterestRate / 100);
	}
	double withdraw( double amount) {
		balance = balance - amount;
		Transaction transaction = new Transaction(this.name, this.id, this.balance);
		transactions.add(transaction);
		return balance;
	}
	
	double deposit( double amount) {
		balance = amount + balance;
		Transaction transaction = new Transaction(this.name, this.id, this.balance);
		transactions.add(transaction);
		return balance;
	}
	public void printTransactions() {
		for(Transaction t: transactions ) {
			System.out.println(t);
		}
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", annualIntrestRate=" + annualIntrestRate
				+ ", dateCreated=" + dateCreated + "]";
	}
	
}
