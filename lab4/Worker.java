package lab4;

/** 
 * @author Emil Wallberg, Rebecka Sahlin
 * @version 1.0
 * @since 2020-02-18
 */

public class Worker extends Employee{
	
	/**
	 * Constructor initializes variables to the values given to the constructor
	 * @param arg1 First name
	 * @param arg2 Last name
	 * @param arg3 Employee id/number
	 * @param arg4 Salary
	 */
	public Worker(String arg1, String arg2, int arg3, double arg4) {
		super(arg1, arg2, arg3, arg4);
	}
	
	/**
	 * @return The TAX payed by this as a [double]
	 */
	public double computeTaxes() {
		final double TAX = 0.25;
		return TAX*salary;
	}
}
