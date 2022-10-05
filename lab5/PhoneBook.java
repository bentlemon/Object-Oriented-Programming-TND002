package lab5;
import java.io.*;
import java.util.ArrayList;

public class PhoneBook {
	private ArrayList<Person> listOfNumbers;

	public PhoneBook() {
		listOfNumbers = new ArrayList<Person>();
	}
	
	public String load(String arg) {
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(arg));
			String line;
			while((line = fileReader.readLine()) != null) {
				String[] person = line.split("\\s+");
				listOfNumbers.add(new Person(person[0], person[1], Integer.parseInt(person[2])));
			}
			fileReader.close();
			return "Phone book loaded";
		}
		catch(Exception e) {
			return "Try again";
		}
	}
	
	public ArrayList<Person> search(String arg) {
		ArrayList<Person> list = new ArrayList<Person>();
		try {
			int pn = Integer.parseInt(arg);
			for(int i = 0; i < listOfNumbers.size(); i++) {
				if(pn == listOfNumbers.get(i).getPhoneNumber()) {
					list.add(listOfNumbers.get(i));
					return list;
				}
			}
		}
		catch(NumberFormatException e) {
			for(int i = 0; i < listOfNumbers.size(); i++) {
				if(listOfNumbers.get(i).getSurname().equals(arg)) {
					list.add(listOfNumbers.get(i));
				}
			}
			return list;
		}
		return null;
	}
	
	public String deletePerson(String arg1, int arg2) {
		for(int i = 0; i < listOfNumbers.size(); i++) {
			if(listOfNumbers.get(i).getFullName().equals(arg1) && listOfNumbers.get(i).getPhoneNumber() == arg2) {
				listOfNumbers.remove(i);
				return "Person deleted";
			}
		}
		return "The person/number dose not exist";
	}
	
	public boolean addPerson(String arg1, int arg2) {
		String[] person = arg1.split("\\s+");
		if(person.length == 2 && (search(arg2+"") == null)) {
			listOfNumbers.add(new Person(person[0], person[1], arg2));
			return true;
		} else {
			return false;			
		}
	}
	
	public String save(String savePath) {
		try{
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(savePath));
			for(int i = 0; i < listOfNumbers.size(); i++) {
				fileWriter.write(String.format("%20s %5d" , listOfNumbers.get(i).getFullName(), listOfNumbers.get(i).getPhoneNumber()) + "\n" );
			}
			fileWriter.close();
			return "Savede " + listOfNumbers.size() + " people to the file";
		}
		catch(IOException e) {}
		return "Could not save to the file";
	}
}
