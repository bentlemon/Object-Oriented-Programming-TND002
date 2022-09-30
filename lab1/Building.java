package labOne;
import java.util.ArrayList;

public class Building {
	private ArrayList<Person> residents; 
	private int number;
	private String streetName; 
	
	public Building(String arg1, int arg2) {
		streetName = arg1;
		number = arg2;
	}
	
	public boolean addPerson(Person arg) { // >:(
		boolean exist = false; 
		
		for(int j = 0; j < residents.size();  j++) {
			if(arg == residents.get(j))  { 
				exist = true ; 
			}
		} 
		if(exist == false) {
			residents.add(arg); 
		}
		
		return exist; // !
	}
	
	
	public void removePerson(Person arg) {
		residents.remove(arg); 
	}
	
	public int getNumber() {
		return number; 
	}
	
	public String getStreet() {
		return streetName; 
	}
	
	public int residents() { // hur många som bor i denna byggnaden , kolla size() och skicka tilllbaka värdet (int)
		return residents.size();
	}
	
	public String toString() {
		return streetName +" "+ number+ "number of residents: " + residents(); 	
	}
	
}
