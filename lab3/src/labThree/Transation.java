package labThree;

public class Transation {
	private int theAccount;
	private double theAmount;
	private String tofrom;
	
	public Transation(String towhere, int accnumb, double amount) {
		theAccount = accnumb;
		theAmount = amount;
		tofrom = towhere; 
	}
	
	public String toString() {
		String result = new String();
		result = String.format("Money transfer %5s", tofrom,
				" account %4d", theAccount, ":%6.2f ", theAmount);
		
		return result; 
	}
}
