package labTwo;
import java.io.*;

public class Lab2 {
	
	private static BufferedReader consoleReader;
	private static BufferedReader fileReader;
	private static BufferedWriter fileWriter; 

	public static void main(String[] args) {
		
		consoleReader = new BufferedReader(new InputStreamReader(System.in));
		Dictionary wordList = new Dictionary();
		boolean run = true; 
		
		while(run) {
			String input = consoleInput("Select option: ");
			switch(input) {
				case "1":
					System.out.println("Load from file");
					input = consoleInput("Filename: ");
					try {
						fileReader = new BufferedReader(new FileReader(input));
						String content = fileReader.readLine();
						
						while(content != null) {
							wordList.addWords(content);
							content = fileReader.readLine();
						}
						fileReader.close();
					}
					catch(FileNotFoundException arg) {
						System.out.println("File doeas not exist.");
					}
					catch(IOException arg) {
						System.out.println("IO error.");
					}
				break;
				
				case "2":
					System.out.println("List content");
					input = consoleInput("Output format (0 or 1): ");
					try {
						Word.changeOutputFormat(Integer.parseInt(input));
						System.out.println(wordList.toString());
					}
					catch(NumberFormatException arg) {
						System.out.println("IO error.");
					}
				break;
				
				case "3":
					System.out.println("Remove doubles and sort by number of occurences.");
					wordList.removeDuplicates();
					wordList.sortDictionaryByCounts();	
				break;
				
				case "4":
					System.out.println("Count occurances.");
					wordList.countOccurences();
				break;
				
				case "5":
					System.out.println("Save to file.");
					input = consoleInput("Filename: ");
					try {
						fileWriter = new BufferedWriter(new FileWriter(input));
						fileWriter.write(wordList.toString());
						fileWriter.close();
					}
					catch(IOException arg) {
						System.out.println("IO error.");
					}
				break;
				
				case "end":
					System.out.println("Bye.");
					run = false;
				break;
				
				default:
				System.out.println("Try again.");
				break;
			}
		}
	}
	
	public static String consoleInput(String arg) {
		System.out.println(arg);
		try{
			return consoleReader.readLine();
		}
		catch(IOException e) {
			return " ";
		}
	}
}


