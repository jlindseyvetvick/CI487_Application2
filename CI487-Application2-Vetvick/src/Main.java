import java.util.Scanner;

class Main {

	public static void main(String[] args) {

		Dictionary dict = new Dictionary("dict.csv");

		while (true) {

			// ask user for a word
			System.out.println("Welcome to Lindsey's Happy Little Dictionary!");
			System.out.println("Please type a word to look up: ");
			Scanner scan = new Scanner(System.in);
			String entryWord = scan.nextLine().toLowerCase();

			// use the lookupWord method from the dict to lookup that word and store the
			// result
			DictEntry result = dict.lookupWord(entryWord);

			// if the results weren't null print the word & definition entry
			if (result != null) {
				System.out.println(dict.lookupWord(entryWord).toString());
			}

			// if the results are null the word was not found (1) ask the user if they would
			// like to add the word and (2)
			else if (result == null) {
				System.out.println("");
				System.out.println("This word was not found in Lindsey's Happy Little Dictionary!");
				System.out.println("Would you like to add this word to the dictionary? Type YES or NO.");
				String userResponse = scan.nextLine().toUpperCase();

				if (userResponse.equals("YES")) {
					System.out.println("What is the definition of " + entryWord + "?");
					String userDefinition = scan.nextLine();
					dict.addWord(entryWord, userDefinition);
					System.out.println("The word " + entryWord + " has been added.");
					System.out.println("");

				} else {
					System.out.println("Maybe next time then, aye?");
					System.out.println("");
				}
			}
		}
	}
}
