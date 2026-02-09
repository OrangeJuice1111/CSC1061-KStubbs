
public abstract class FinancialInstitution {

	private String fiName;
	private long fiID;
	private long routingNumber;
	//private Address address;
	
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

	

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
	public abstract double getIntrestRate();
	
	@Override
	public String toString() {
		return "FinancialInstitution [fiName=" + fiName + ", fiID=" + fiID + ", routingNumber=" + routingNumber + "]";
	}
	
	
	
}
