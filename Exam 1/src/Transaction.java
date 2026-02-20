import java.time.LocalDate;
import java.util.ArrayList;

public class Transaction {

	protected LocalDate dateCreated = java.time.LocalDate.now();
	
	
	private String name;
	private int id;
	private double balance;

	public Transaction(String name, int id, double balance) {
		super();
		this.name = name;
		this.id = id;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transaction [dateCreated=" + dateCreated + ", name=" + name + ", id=" + id + ", balance=" + balance
				+ "]";
	}
	
	
}
