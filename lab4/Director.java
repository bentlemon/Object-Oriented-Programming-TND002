package lab4;
import java.util.ArrayList;

/** 
 * @author Emil Wallberg, Rebecka Sahlin
 * @version 1.0
 * @since 2020-02-18
 */

public class Director extends Employee{
	private ArrayList<Worker> subordinates;
	
	/**
	 * Constructor initializes variables
	 * @param arg1 First name
	 * @param arg2 Last name
	 * @param arg3 Employee id/number
	 * @param arg4 Salary
	 */
	
	public Director(String arg1, String arg2, int arg3, double arg4) {
		super(arg1, arg2, arg3, arg4);
		subordinates = new ArrayList<Worker>();
	}
	
	/**
	 * @param arg Worker to add as a subordinates to this
	 */
	public void addEmployee(Worker arg) {
		subordinates.add(arg);
	}
	
	/**
	 * @return The bonus earned by this as a [double]
	 */
	public double computeBonus() {
		final double BONUSPROCENT = 0.1;
		double cumulativeSalary = 0;
		for(int i = 0; i < subordinates.size(); i++) {
			cumulativeSalary += subordinates.get(i).getSalary();
		}
		return BONUSPROCENT*cumulativeSalary;
	}
	
	/**
	 * @return The TAX payed by this as a [double]
	 */
	public double computeTaxes() {
		final double TAX = 0.25;
		return TAX*(salary + computeBonus());
	}
}
