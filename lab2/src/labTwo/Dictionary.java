package labTwo;
import java.util.ArrayList;

public class Dictionary {
	private ArrayList<Word> theDictionary;
	
	public Dictionary() {
		theDictionary = new ArrayList<Word>();
	}
	
	public void addWords(String arg) {
		
		String[] strArray = arg.split(" +"); 
		
		for(int j = 0; j < strArray.length ;j++ ) {	
			System.out.println(strArray[j]); 
			
			theDictionary.add(new Word(strArray[j])); 
		} 
	}
	
	public int numberOfWords() {
		return theDictionary.size();
	}
	
	public void removeDuplicates() {
		
		Word p;
		
		for(int j = 0; j < theDictionary.size()-1; j++) {
			p = theDictionary.get(j); 
			
			for(int i = j+1; i < theDictionary.size(); i++) {
				if (p.getWord().equals(theDictionary.get(i).getWord())) { // jämför orden 
					for (int k = 0; k < theDictionary.get(i).getCounts(); k++) {
						theDictionary.get(i).increaseCounts();
					}
						theDictionary.remove(i);
						i = i-1; // ta ett steg tillbaka för att inte hoppa över en plats 
				}
			}
		}	
	}
	
	public void sortDictionaryByCounts() {
		for (int i = 0; i < theDictionary.size(); i++) {
            for (int j = i+1; j < theDictionary.size(); j++) {
               Word tempWord2 = theDictionary.get(j);
               Word tempWord = theDictionary.get(i);
                
                if (tempWord2.getCounts() > tempWord.getCounts()) {
                    theDictionary.set(i, tempWord2);
                    theDictionary.set(j, tempWord);
                }
            }
        }
	}
	
	public void countOccurences() {
		removeDuplicates();
		sortDictionaryByCounts();
		if(!theDictionary.isEmpty()) {
			int occur = theDictionary.get(0).getCounts();
			int words = 1;
			
		for (int i = 0; i < theDictionary.size(); i++) {
			if (occur == theDictionary.get(i).getCounts()) {
				words++;
			}else {
				System.out.println(String.format("%3d words occured %3d times", words, occur));
				words = 1;
				occur = theDictionary.get(i).getCounts();
			}
				if(i++ >= theDictionary.size()) {
					System.out.println(String.format("%3d words occured %3d times", words, occur));
				}
			}
		}
	}
	
	public String toString() {
		String result = " ";
		for (Word word : theDictionary) {
			result += word.toString() + "\n";	// är här problemet??	
		}
		return result;
	}
}
