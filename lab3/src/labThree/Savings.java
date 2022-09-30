package labThree;

public class Savings extends Account {

	public Savings(int arg1, Current arg2) {
		super(arg1, arg2);
		balance = 0.0;
	}
	
	public void changeBalance(double arg) {
		balance+=arg;  
	}
	
	public double getBalance() {return balance;}
	
}
