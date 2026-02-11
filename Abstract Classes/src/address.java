
public class address implements Cloneable{
	public String street;
	public String city;
	public String state;
	public long zip;
	
	public address clone() throws CloneNotSupportedException{
		address clone = (address) super.clone();
		clone.Address = Address.clone();
		return clone;
	}
}
