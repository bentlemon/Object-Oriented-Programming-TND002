package labThree;

public class Customer {
	private String name;
	private Current currentAccount;
	private Savings savingsAccount;
	
	public Customer(String arg) {
		name = arg;
	}
	
	public String getName(){return name;}
	
	public Current getCurrentAccount() { return currentAccount; }
	
	public void addAccount(Current arg1, Savings arg2) {currentAccount = arg1; savingsAccount = arg2;}
	
	public String toString() {
		 final String f = "%15s %16s \n";
	        return String.format(f, "Name of customer", name) 
	                + (currentAccount != null ? String.format(f, "Current acoount", currentAccount.getNumber()) : "")
	                + (savingsAccount != null ? String.format(f, "Savings account", savingsAccount.getNumber()): "");
		
	}
}
