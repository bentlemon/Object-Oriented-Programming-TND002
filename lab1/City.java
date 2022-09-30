package labOne;

public class City { // class som har koll på hela staden 

	private AllBuildnings infrastructure;
	private Inhabitants people;
	
	public City() {
		
		infrastructure = new AllBuildnings();
		people = new Inhabitants();
	}
	
	public void addPerson(String arg1, String arg2, int arg3, String arg4, int arg5) { //city har acess till allt, 
		Person p = new Person(arg1, arg2, arg3);
		
		if (people.addPerson(arg1, arg2, arg3) == null) {
			infrastructure.getBuilding(arg4, arg5).addPerson(p);
			System.out.println("Person added");
			
		}else {	
		System.out.println("Person already exist");
			}
		}
	
	public void movePerson(String arg1, String arg2, int arg3, String arg4, int arg5) {
		
		Building y = new Building(arg4, arg5);
		
		if (people.searchPerson(arg1, arg2, arg3) == null) {
			System.out.println("Person does not exist");
			
		} else {
			
		}
		
			
	} 
	
	public String listBuilding() { // to string av infrastructure
		
	}
	
	public String listPeople() { // to string av people
		
	}
	
	public String toString() { // kallar på både allbuildings och inhabitants 
		
	}
	
	
}
