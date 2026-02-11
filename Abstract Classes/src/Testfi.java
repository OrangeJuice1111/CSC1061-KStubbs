import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Testfi {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Bank b1 = new Bank("My Bank");
		
		System.out.println("MyBank intrest rate: " + b1.getIntrestRate() + "%");
		
		List<FinancialInstitution> fiList = new LinkedList<>();
		fiList.add(b1);
		fiList.add(new CreditUnion("My CU"));
		fiList.add(new NonLender("Useless FI"));
		
		
		fiList.get(0).setFiID(2);
		fiList.get(1).setFiID(3);
		fiList.get(2).setFiID(1);
		
		if(fiList.get(0) instanceof Bank) {
		((Bank)fiList.get(0)).setSavings();
		}
		
		Collections.sort(fiList, Collections.reverseOrder());
		
		
		
		
		b1.setAddress(new address());
		b1.getAddress().street = "555 Merry Way";
		
		FinancialInstitution b2 = null;
		
		if(b1 instanceof Cloneable) {
		b2 = b1.clone();
		}
		
		b2.setFiID(4);
		b2.setFiName("My 4th bank");
		System.out.println(b1 + " " + b1.getAddress().street);
		System.out.println(b2 + " " + b2.getAddress().street);
		b2.getAddress().street = "666 Spooky St.";
		System.out.println("After Spooky");
		System.out.println(b1 + " " + b1.getAddress().street);
		System.out.println(b2 + " " + b2.getAddress().street);
		
		for(FinancialInstitution fi: fiList)
		{
			System.out.println(fi);
		}
		
	}
}