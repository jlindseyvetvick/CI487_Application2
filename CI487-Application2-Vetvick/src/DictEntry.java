import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class DictEntry implements Comparable<DictEntry>{

	private final String word;
	private final String definition;	
	
	
	//Method 1: DictEntry Constructor used to set the word & definition attributes when a new instance of the class is created
	DictEntry(String word, String definition){
		this.word = word;
        this.definition = definition;
	}
	
	//Method 2: Getter for each attribute
	public String getWord() {
		return word;
	}
	
	public String getDefinition() {
		return definition;
	}
	
	//Method 3: compareTo Method which overrides the compareTo method in order to allow for two DictEntry classes to be compared
	@Override
    public int compareTo(DictEntry other){
        return word.compareTo(other.word);
    }
	
	//Method 4: toString Method which returns a string containing the word and its definition
	@Override
	   public String toString(){
	   return String.format("The word %s is defined as %s%n", word, definition);
	   }
	
}
