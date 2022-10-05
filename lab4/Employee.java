package lab4;

/** 
 * @author Emil Wallberg, Rebecka Sahlin
 * @version 1.0
 * @since 2020-02-18
 */

public abstract class Employee implements Comparable<Employee>{
	protected String firstName, lastName;
	protected int id;
	protected double salary;
	public static final int BYNAME = 0, BYSALARY = 1, BYTAXES = 2;
	private static int criterion = BYNAME;
	
	/**
	 * Constructor initializes variables to the values given to the constructor 
	 * @param arg1 First name
	 * @param arg2 Last name
	 * @param arg3 Employee id/number
	 * @param arg4 Salary
	 */
	
	public Employee(String arg1, String arg2, int arg3, double arg4) {
		firstName = arg1; lastName = arg2; id = arg3; salary = arg4;
	}
	
	/**
	 * @return The Employee id/number
	 */
	public int getNumber() {
		return id;
	}
	
	/**
	 * @return The last name
	 */
	public String getName() {
		return lastName;
	}
	
	/**
	 * @return The salary
	 */
	public double getSalary() {
		return salary;
	}
	
	/**
	 * Changes the Criterion to
	 * @param arg The value to change criterion to
	 */
	
	public static void changeCriterion(int arg) {
		criterion = arg;
	}
	
	
	/**
	 * @return a double with a calculated TAX 
	 */
	public abstract double computeTaxes();
	
	/** 
	 * @return a string containing the first-,lastname and id of Employee
	 */
	public String toString() {
		return String.format("%-12s %-12s %-8d", firstName, lastName, id);
	}
	
	/**
	 * @return a int describing the criterion
	 */
	public static int getCriterion() {
		return criterion;
	}
	
	/**
	 * Compares this Employee to @param arg Employee
	 * Depending on @see #criterion
	 */
	public int compareTo(Employee arg) {
		switch(criterion) {
			case BYNAME:
				return lastName.compareTo(arg.getName());
			case BYTAXES:
				if(computeTaxes() > arg.computeTaxes()) {
					return -1;
				} else if(computeTaxes() == arg.computeTaxes()) {
					return 0;
				} else {
					return 1;
				}
			case BYSALARY:
			default:
				if(salary > arg.getSalary()) {
					return -1;
				} else if( salary == arg.getSalary()) {
					return 0;
				} else {
					return 1;
				}
		}
	}
}
