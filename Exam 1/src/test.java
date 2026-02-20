import java.lang.reflect.Array;

public class test {


	public static void main(String[] args) {
		CheckingAccount check = new CheckingAccount("", 1111, 2000, 200, 0.5);
		System.out.println(check);
		check.withdraw(2100);
		System.out.println(check);
		check.deposit(3000);
		System.out.println(check);
		
		
		SavingsAccount save = new SavingsAccount(1100, 500, 200, 1.0);
		System.out.println(save);
		check.withdraw(300);
		System.out.println(save);
		
		
		CheckingAccount check1 = new CheckingAccount("George", 2222, 1000, 200, 1.5 );
		System.out.println(check1);
		check1.deposit(30);
		check1.deposit(40);
		check1.deposit(50);
		check1.withdraw(5);
		check1.withdraw(4);
		check1.withdraw(2);
		check1.printTransactions();
	}
}
