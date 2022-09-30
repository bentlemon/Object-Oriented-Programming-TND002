package labThree;
import java.util.ArrayList; 

public class Bank {
	private ArrayList<Customer> customerList;
	private ArrayList<Account> accountList;
	private int accountNumber;
	
	public Bank() {
		customerList = new ArrayList<Customer>();
		accountList = new ArrayList<Account>();
		accountNumber = 1000; 
	}
	
	public String addCustomer(String arg1, double arg2) { // !!!!
		Customer dummy = findCustomer(arg1);
		String result = new String();
		
		if(dummy == null) {
			customerList.add(new Customer(arg1));
			accountList.add(new Current(customerList.get(customerList.size()-1), accountNumber++, arg2));
			Current dummyCurrent = (Current) accountList.get(accountList.size()-1);
			accountList.add(new Savings(accountNumber++, dummyCurrent));
			customerList.get(accountList.size()-1).addAccount(dummyCurrent, (Savings)accountList.get(accountList.size()-1));
			result =  "Customer added";
		} else {
			result = "Customer already exist";
		}
		return result;
	 
	}
	
	public Customer findCustomer(String arg) {
		
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getName().equals(arg)) {
				return customerList.get(i);
			}
		}
		
		return null;
	}
	
	public void transfer(String arg1, double arg2) {
		Customer p2 = findCustomer(arg1);
		
		System.out.println(p2);
		
		if (p2 != null) {
			p2.getCurrentAccount().transfer(arg2);;
		} 
		
	}
	
	public void transfer(String arg1, String arg2, double arg3) {
	 // från en person till en annan 
		Customer pFrom = findCustomer(arg1);
		
		Customer pTo = findCustomer(arg2);
		
		pFrom.getCurrentAccount().transfer(pTo.getCurrentAccount(), arg3);
	}
	
	public String checkAccount(int arg) { 
		for (int i = 0; i < accountList.size(); i++) {
			if(accountList.get(i).getNumber() == arg) {
				return accountList.get(i).toString();
			}
		}
		return "Not a current account.";
	}
	
	public void annualChange() {
		for (int i = 0; i < accountList.size(); i++) {
			accountList.get(i).annualChange();
		}
	}
	
	public String toString() {
		String ret = "Bank statistics\n =========================\n";
		final String formater = "%10s %12d\n";
		ret += String.format(formater,  "Customers: ", customerList.size());
		
		double money = 0;
		
		for (int i = 0; i < accountList.size(); i++) {
			money += accountList.get(i).getBalance();
		}
		ret += String.format(formater, "Money", money);
		return ret;
	}
	
}
