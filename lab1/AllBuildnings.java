package labOne;
import java.util.ArrayList;

public class AllBuildnings {
	
	private ArrayList<Building> theBuildnings; 
	
	public AllBuildnings() { // new arraylist 
		theBuildnings = new ArrayList<Building>(); 
	}
	
	public Building getBuilding(String arg1, int arg2) { // komplicerard, streetname, house number, retunerar om det finns en s�dan byggnad, om det inte finns skapar den en ny med husnumret ect 
		Building b = new Building(arg1, arg2); 
		
		for (int j=0; j< theBuildnings.size(); j++) {
			if(theBuildnings.get(j) == b) {
				System.out.println("Building already existing.\n");
				return null; 
			}
			else {
				theBuildnings.add(b);
			}
		}
		
		return b;
	}
	
	public String getNumberOfBuildings() { // L�gger en string och med theBuildnings.size()
		return "Number of buildings: " + theBuildnings.size();
	}
	
	public void cleanUp() { // om en byggnad �r tom s� tar vi bort den fr�n listan, g�r igenom arrayn och kollar om det finns n�gon tom byggnad, kallar p� getNumber om = 0, ta bort , .remove(j
		
		for (int j = 0; j < theBuildnings.size(); j++) {
			if(theBuildnings.get(j).residents() == 0) {
				theBuildnings.remove(j);
			}
		}
	}
	
	public String toString() { // "List of buildings: "
		String result = new String();
		
		for (int j = 0; j < theBuildnings.size(); j++) {
			result = result + theBuildnings.get(j) + "\n";	
		} 
		
	return "List of buildings\n ------------------\n" + result; 
		
	}
}
