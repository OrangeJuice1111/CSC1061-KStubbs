
public class Employees {
	private String First;
	private String Last;
	private int SSN;
	double getPaymentAmount() {
		return 0;
	}
	public Employees() {
		
	}
	public Employees(String first, String last, int sSN) {
		super();
		First = first;
		Last = last;
		SSN = sSN;
	}
	public String getFirst() {
		return First;
	}
	public void setFirst(String first) {
		First = first;
	}
	public String getLast() {
		return Last;
	}
	public void setLast(String last) {
		Last = last;
	}
	public int getSSN() {
		return SSN;
	}
	public void setSSN(int sSN) {
		SSN = sSN;
	}
	@Override
	public String toString() {
		return "Employees [First=" + First + ", \nLast=" + Last + ", \nSSN=" + SSN + "]";
	}
	
	
}
