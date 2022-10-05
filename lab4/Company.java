package lab4;
import java.util.ArrayList;
import java.util.Collections;

/** 
 * @author Emil Wallberg, Rebecka Sahlin
 * @version 1.0
 * @since 2020-02-18
 */

public class Company {
	private ArrayList<Employee> employees;
	
	/**
	 * No-argument constructor initializes instance variables
	 */
	
	public Company() {
		employees = new ArrayList<Employee>();
	}
	
	/**
	 * @param arg is the Director to add to the employees
	 * @see com.labs.lab4.Director#Director(String, String, int, double)
	 */
	public void addEmployee(Director arg) {
		employees.add(arg);
	}
	
	
	/**
	 * Adds a Worker arg1 to the employees and assign him/her to a Director arg2
	 * @param arg1 is a Worker()
	 * @param arg is a Director()
	 * @see com.labs.lab4.Worker#Worker(String, String, int, double)
	 * @see com.labs.lab4.Director#Director(String, String, int, double)
	 */
	public void addEmployee(Worker arg1, Director arg2) {
		employees.add(arg1);
		arg2.addEmployee((Worker)employees.get(employees.size()-1));
	}
	
	
	/**
	 * Gets a sorted list of employees
	 * @return a  String 
	 * The list is sorted dependent on the criterion
	 * @see com.labs.lab4.Employee#criterion
	 * Witch can be change by 
	 * @see com.labs.lab4.Employee#changeCriterion(arg)
	 */
	public String toString() {
		for(int i = 0; i < employees.size(); i++) {
			for(int j = i+1; j < employees.size(); j++) {
				if(employees.get(i).compareTo(employees.get(j)) > -1) {
					Employee temp = employees.get(i);
	                employees.set(i, employees.get(j));
	                employees.set(j, temp);
				}
			}
		}
		String ret = "List of Employees\n-----------------\n";
		int c = Employee.getCriterion();
		ret += String.format("%-12s %-12s %-8s","First name", "Surname", "Number");
		switch(c) {
		case 0:
			ret += "\n";
			for(int i = 0; i < employees.size(); i++) {
				ret += employees.get(i).toString() + "\n";
			}
			break;
		case 2:
			ret += "Taxes\n";
			for(int i = 0; i < employees.size(); i++) {
				ret += employees.get(i).toString() + String.format("%6.6f", employees.get(i).computeTaxes()) + "\n";
			}
			break;
		case 1:
		default:
			ret += "Salary\n";
			for(int i = 0; i < employees.size(); i++) {
				ret += employees.get(i).toString() + String.format("%6.6f", employees.get(i).getSalary()) + "\n";
			}
			break;
		}
		return ret;
	}
}
