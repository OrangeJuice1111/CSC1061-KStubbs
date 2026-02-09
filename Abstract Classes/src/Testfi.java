import java.util.LinkedList;
import java.util.List;

public class Testfi {

	public static void main(String[] args) {
		
		Bank b1 = new Bank("My Bank");
		
		System.out.println("MyBank intrest rate: " + b1.getIntrestRate());
		
		List<FinancialInstitution> fiList = new LinkedList<>();
		fiList.add(b1);
		fiList.add(new CreditUnion("My CU"));
		fiList.add(new NonLender("Useless FI"));
		
		
		fiList.get(0).setFiID(2);
		fiList.get(1).setFiID(3);
		fiList.get(2).setFiID(1);
		
		((Bank)fiList.get(0)).setSavings();
		
	}
}
