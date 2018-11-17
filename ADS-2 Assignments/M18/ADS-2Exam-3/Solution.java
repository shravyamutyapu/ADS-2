/**
 * importing files.
 */
import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashMap;
/**
 * Solution class.
 */
public class Solution {

	// Don't modify this method.
	/**
	 * main method.
	 * time complexity is O(N).
	 * @param args [description]
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cases = scan.nextLine();

		switch (cases) {
		case "loadDictionary":
			// input000.txt and output000.txt
			BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
			while (scan.hasNextLine()) {
				String key = scan.nextLine();
				System.out.println(hash.get(key));
			}
			break;

		case "getAllPrefixes":
			// input001.txt and output001.txt
			T9 t9 = new T9(loadDictionary("/Files/t9.csv"));

			while (scan.hasNextLine()) {
				String prefix = scan.nextLine();
				for (String each : t9.getAllWords(prefix)) {
					System.out.println(each);
				}
			}
			break;

		case "potentialWords":
			// input002.txt and output002.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			int count = 0;
			while (scan.hasNextLine()) {
				String t9Signature = scan.nextLine();
				for (String each : t9.potentialWords(t9Signature)) {
					count++;
					System.out.println(each);
				}
			}
			if (count == 0) {
				System.out.println("No valid words found.");
			}
			break;

		case "topK":
			// input003.txt and output003.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			Bag<String> bag = new Bag<String>();
			int k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				bag.add(line);
			}
			for (String each : t9.getSuggestions(bag, k)) {
				System.out.println(each);
			}

			break;

		case "t9Signature":
			// input004.txt and output004.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			bag = new Bag<String>();
			k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (String each : t9.t9(line, k)) {
					System.out.println(each);
				}
			}
			break;

		default:
			break;

		}
	}

	// Don't modify this method.
	/**
	 * helper.
	 * Time complexity is O(1).
	 * @param file [description]
	 * @return String[]
	 */
	public static String[] toReadFile(String file) {
		In in = new In(file);
		return in.readAllStrings();
	}
    /**
     * Time complexity is O(N).
     * @param file [description]
     * @return BinarySearchST[description]
     */
	public static BinarySearchST<String, Integer> loadDictionary(String file) {
		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
		// your code goes here
        for (String word : toReadFile(file)) {
			word = word.toLowerCase();
			if (st.contains(word)) {
				st.put(word, st.get(word)+1);
			}else {
				st.put(word, 1);
			}
		}
		return st;
	}

}
/**
 * T9 class.
 */
class T9 {
    TST<Integer> tstObj = new TST<Integer>();
    /**
     * constructor.
     * @param st symbol table.
     */
	public T9(BinarySearchST<String, Integer> st) {
		// your code goes here
		for(String word: st.keys()) {
			tstObj.put(word, st.get(word));
		}

	}

	/**
	 * get all the prefixes.
	 * that match with given prefix.
	 * @param prefix String.
	 */
	public Iterable<String> getAllWords(String prefix) {
		// your code goes here

		return tstObj.keysWithPrefix(prefix);
	}
    /**
     * guessed words.
     * @param t9Signature String.
     * @return.
     */
	public Iterable<String> potentialWords(String t9Signature) {
		// your code goes here
		HashMap<Integer,String> hash = new HashMap<Integer,String> ();
		hash.put(2, "abc");
        hash.put(3, "def");
        hash.put(4, "ghi");
        hash.put(5, "jkl");
        hash.put(6, "mno");
        hash.put(7, "pqrs");
        hash.put(8, "tuv");
        hash.put(9, "wxyz");

		return null;
	}

	/**
	 * Time complexity is O(N).
	 * return all possibilities(words),
	 * find top k with highest frequency.
	 * @param words [description]
	 * @param k [description]
	 *
	 * @return [description]
	 */
	public Iterable<String> getSuggestions(Iterable<String> words, int k) {
		// your code goes here
		MaxPQ<Integer> pqObj = new MaxPQ<Integer>();
		for (String each : words) {
			pqObj.insert(tstObj.get(each));
		}
		TreeSet<String> treeObj = new TreeSet<String>();
		for (int i = 0; i < k; i++) {
			int value = pqObj.delMax();
			for (String word : words) {
				if (value == tstObj.get(word)) {
					treeObj.add(word);
				}
			}
		}
		return treeObj;
	}

	// final output
	// Don't modify this method.
	public Iterable<String> t9(String t9Signature, int k) {
		return getSuggestions(potentialWords(t9Signature), k);
	}
}
