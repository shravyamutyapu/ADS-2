public class BoggleSolver {
	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
	public BoggleSolver(String[] dictionary) {

	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable.
	public Iterable<String> getAllValidWords(BoggleBoard board) {
		return new Bag<String>();
	}

	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A through Z.)
	public int scoreOf(String word) {
		int len = word.length();
		if (len > 0 && len <= 2) {
			return 0;
		} else if (len >=3 && len <= 4) {
			return 1;
		} else if (len == 5) {
			return 2;
		} else if (len == 6) {
			return 3;
		} else if (len == 7) {
			return 5;
		} else if (len >= 8) {
			return 11;
		}
		return 0;
		}

}