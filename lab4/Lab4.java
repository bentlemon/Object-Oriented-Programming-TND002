package lab4;
import javax.swing.*; import java.awt.*; import java.awt.event.*;

public class Lab4 extends JFrame {
	private JTextArea output;
	
	    /*public Lab4(String text) {
	        setTitle("Message");
	        this.setSize(300,400); setVisible(true);
	        output = new JTextArea(text);
	        output.setFont(new Font("Serif",Font.PLAIN,16));
	        Container c = getContentPane(); c.add(output);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }/*

	/** 
	 * @author Emil Wallberg, Rebecka Sahiln
	 * @version 1.0
	 * @since 2020-02-18
	 */
	public static void main(String[] args) {
		
		Company theCompany = new Company();
				
		/* Directors are created as objects with an own reference variable because they are added to 
                 * Workers. The entries in the constructor are the first name, surname, employee number and salary. */
		
		Director director1 = new Director("John", "Smith", 1, 700000.0);
		Director director2 = new Director("Elaine", "Garret", 2, 670000.0);
		
		// We add the directors to the company
		
		theCompany.addEmployee(director1);theCompany.addEmployee(director2);
		
		// We add workers to the company and assign them to a director. 
		
		theCompany.addEmployee(new Worker("Paul", "Johnson", 3, 400000.0),director1);
		theCompany.addEmployee(new Worker("Sarah", "Davidson", 4, 420000.0),director1);
		theCompany.addEmployee(new Worker("Doris","McClure", 5, 470000.0),director1);
		theCompany.addEmployee(new Worker("James", "Adams", 6, 340000.0),director1);
		theCompany.addEmployee(new Worker("Sam", "Cooper", 7, 460000.0),director2);
		theCompany.addEmployee(new Worker("Andrea","Lester", 8, 460000.0),director2);
		theCompany.addEmployee(new Worker("Olga", "Gibbs", 9, 420000.0),director2);
		
		//Here we change the sorting criterium using the class constants of Employee: 
		//BYNAME = 0, BYSALARY = 1, BYTAXES = 2.
		
		//This is the code for part B.
		Employee.changeCriterion(Employee.BYTAXES);
		System.out.println(theCompany);
		String question = "You want to sort by Surname (1), Salary (2) or paid Taxes (3)?";
		String input = "";
		int inParse = -1;
		while(!(inParse == 1 || inParse == 2 || inParse == 3) && input != null) {
			System.out.println(input);
			input = JOptionPane.showInputDialog(question);
			question = "You want to sort by Surname (1), Salary (2) or paid Taxes (3)?\nTry again";
			try {
				inParse = Integer.parseInt(input);
			}
			catch(Exception e){
				
			}
		}
		if(inParse > 0) {
			switch(inParse) {
			case 1:
				Employee.changeCriterion(Employee.BYNAME);
				break;
			case 2:
				Employee.changeCriterion(Employee.BYSALARY);
				break;
			case 3:
				Employee.changeCriterion(Employee.BYTAXES);
				break;
			}
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, theCompany.toString());
		}
	}
}
