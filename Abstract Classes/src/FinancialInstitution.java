
public abstract class FinancialInstitution 
implements Comparable<FinancialInstitution>, Cloneable{

	private String fiName;
	private long fiID;
	private long routingNumber;
	private address address;
	
	public FinancialInstitution(String name) {
		fiName = name;
	}

	public String getFiName() {
		return fiName;
	}

	public void setFiName(String fiName) {
		this.fiName = fiName;
	}

	public long getFiID() {
		return fiID;
	}

	public void setFiID(long fiID) {
		this.fiID = fiID;
	}

	public long getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(long routingNumber) {
		this.routingNumber = routingNumber;
	}

	

	
	public address getAddress() {
		return address;
	}

	public void setAddress(address address) {
		this.address = address;
	}

	public abstract double getIntrestRate();
	
	@Override
	public int compareTo(FinancialInstitution o) {
		if(this.fiID < o.fiID) {
			return -4;
		}
		else if (this.fiID > o.fiID) {
			return 4;
		}
		return 0;
	}
	
	
	
	
	@Override
	public FinancialInstitution clone() throws CloneNotSupportedException {
		FinancialInstitution clone = (FinancialInstitution) super.clone();
		clone.address = clone.getAddress();
		return clone;
	}
	
	
	@Override
	public String toString() {
		return "FinancialInstitution [fiName=" + fiName + ", fiID=" + fiID + ", routingNumber=" + routingNumber + "]";
	}
	
	
	
}
