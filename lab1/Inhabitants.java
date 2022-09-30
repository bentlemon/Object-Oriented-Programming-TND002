package labOne;
import java.util.ArrayList;

public class Inhabitants { // information om varje person som bor här 
	
	private ArrayList<Person> thePeople;
	
	
	public Inhabitants() { // new command, empty array  
		
		thePeople = new ArrayList<Person>();
	}
	
	public Person addPerson(String arg1, String arg2, int arg3) { // skickar tillbaka ram-adressen, skapar en person och lägegr det i arrayn, om den inte kan lägga till ska skicka tillbaka null
		Person p = new Person(arg1, arg2, arg3); 
		
		for (int j=0; j< thePeople.size(); j++) {
			if(thePeople.get(j) == p) {
				System.out.println("Person already existing.\n");
				return null; 
			}
			else {
				thePeople.add(p);
			}
		}
		return p;
	}
	
	public Person searchPerson(String arg1, String arg2, int arg3) { // metod som låter en söka en specifik person, skickar tillbaka adressen
		Person p = new Person(arg1, arg2, arg3); 
		for (int j=0; j< thePeople.size(); j++) {
				Person i = thePeople.get(j); 
			if (i == p) {
				return p;
			}
		}
			
		return p;
	}
	
	public String getNumberOfPeople() { // ska skicka tillbaka en string med thePeople.size() 
		return "Number of people: " + thePeople.size();
	}
	
	public String toString() { 
		String result = new String();
		
		for (int j = 0; j < thePeople.size(); j++) {
			result = result + thePeople.get(j) + "\n";
		
	} 
		
	return "List of inhabitants\n ------------------\n" + result; 
	
	}
}
