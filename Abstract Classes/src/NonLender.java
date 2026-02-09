
public class NonLender extends FinancialInstitution{

	public NonLender(String name) {
		super(name);
	}

	@Override
	public double getIntrestRate() {
		throw new UnsupportedOperationException("This bank does not lend");
	}
	
	

}
