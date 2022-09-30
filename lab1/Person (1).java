package labOne;

public class Person {
	private int age; 
	private String firstName, secondName; 
	private Building adress; 
	private boolean theFormat = true; 
	public boolean WITHAGE, NOAGE;  // har value true från början
	
	
	public Person(String arg1, String arg2, int arg3) {
		firstName = arg1; 
		secondName = arg2;
		age = arg3; 
		
	}
	
	public void setAdress(Building arg) { 
		adress = arg;
	}
	
	public Building getAdress() {
		return adress; 
	}
	
	public boolean isPerson(String arg1, String arg2, int arg3) { // kollar om personer finns 
			boolean exist = false; 
		
			if (arg1.equals(firstName)&&arg2.equals(secondName)&& (arg3 == age)) { 
				exist  = true; 
			} 
			
			return exist; 
	}
	
	public void changeFormat(boolean arg) { // vill skicka in class vari som är true eller false 
		theFormat = arg; 
	}
	
	public String toString() {
		String result = new String(); 
		
		if(theFormat) { // with age
			result = String.format("%s-7s%-10s", firstName, secondName,", age: ", age); 
		} else { // no age
			result = String.format("%s-7s%-10s", firstName, secondName); 
		}
		
		return result;  
	}
	
	
	
	
	
	
}
