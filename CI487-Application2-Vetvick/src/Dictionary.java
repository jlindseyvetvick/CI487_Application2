import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {

	private AVL<DictEntry> dictionary = new AVL<>();

	Dictionary(String fp) {
		/* Implement your file reader and populate dictionary here */

		File infile = new File(fp);
		Scanner fileReader;

		try {
			fileReader = new Scanner(infile);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}

		while (fileReader.hasNextLine()) {
			String line = fileReader.nextLine().toLowerCase();
			String[] elements = line.split(",");
			dictionary.insert(new DictEntry(elements[0], elements[1]));
		}

	}

	/* Implement the lookupWord and addWord methods below */
	public DictEntry lookupWord(String word) {
		DictEntry tmpDictEntry = new DictEntry(word, null);
		return (dictionary.search(tmpDictEntry));
	}

	public void addWord(String word, String definition) {
		dictionary.insert(new DictEntry(word, definition));
	}
	
}
