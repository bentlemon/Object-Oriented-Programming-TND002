package labThree;
import java.util.ArrayList;

public class Current extends Account { 
	private Customer theCustomer;
	private ArrayList<Transation> theTransations;
	
	public Current(Customer arg1, int arg2, double arg3) {
		super(arg2);
		theTransations = new ArrayList<Transation>();
		theCustomer = arg1; 
		balance = arg3;
	}
	
	public Customer getCustomer() { return theCustomer;}
	
	public void transfer(double arg) {
		   if(arg > 0) {
	            if(arg != 0 && balance >= arg) {
	                balance -= arg;
	                theTransations.add(new Transation("To", otherAccount.accountNumber, arg));
	            } else {
	                double temp = arg - (balance - arg);
	                balance -= temp;
	                theTransations.add(new Transation("To", otherAccount.accountNumber, arg));
	            } 
	        }
	        else if (arg < 0) {
	                double transfer = -arg;
	        if (balance >= transfer) {
	                otherAccount.balance -= transfer;
	                balance -= transfer;
	                theTransations.add(new Transation("From", otherAccount.accountNumber, arg));
	     } else if (balance < transfer) {
	            double temp = arg - (balance-arg);
	            otherAccount.balance -= temp;
	            balance -= temp;
	            theTransations.add(new Transation("From", otherAccount.accountNumber, arg));
	        }
	      }
	    }
	
	public void deposit(Current arg1, double arg2) {
	     if (arg2 != 0.0) {
	    	 balance += arg2;
	         theTransations.add(new Transation("from", arg1.accountNumber, arg2));
	      }
	}
	
	public void transfer(Current arg1, double arg2) {
		 if(arg2 > 0) {
	            double money = arg2 > balance ? balance : arg2;
	            arg1.deposit(this, money);
	            balance -= money;
	            theTransations.add(new Transation("To", arg1.getNumber(), money));
		 }
	}
	
	public String toString() {
		  String f = "%20s %15s\n";
	        String ret = String.format(f, "Customer", theCustomer.getName());
	        ret += String.format(f, "Account number", accountNumber);
	        ret += String.format(f, "Balance", balance);
	        ret += String.format(f, "Savings", otherAccount.getBalance());
	        ret += "List of transactions\n";
	        for(int i = 0; i < theTransations.size(); i++) {
	            ret += theTransations.get(i).toString() + "\n";
	        }
	        return ret;
	}	
}
