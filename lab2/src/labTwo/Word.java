package labTwo;

public class Word {
	private String theWord;
	private int counts;
	private static int outputFormat;
	
	public Word(String arg) {
		theWord = arg; 
		counts = 1;
	}
	
	public String getWord() {
		return theWord; 
	}
	
	public int getCounts() {
		return counts;
	}
	
	public void increaseCounts() {
		counts++; 
	}
	
	public static void changeOutputFormat(int arg) {
		if (arg == 0) outputFormat = 0; 
		
		if (arg != 0) outputFormat = 1; 
		
	}
	
	public String toString() {
		String result = new String(); 
		String arg1 = theWord; 
		int arg2 = counts; 
		
		if (outputFormat == 0) {
			result = "The word" + arg1 + "has occured" + arg2 + "times.";  
		} else {
			result = "The word is: " + arg1; 
		}
		
		return result;
	}
}