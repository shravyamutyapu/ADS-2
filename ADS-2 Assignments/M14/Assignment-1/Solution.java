import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		String[] words = loadWords();
		//Your code goes here...
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		TST tstObj = new TST();
		int len = words.length;
		for(int i=0;i<len;i++){
			//if(words[i].contains(input))
			//System.out.println(words[i]);
			String[] tokens = new String[len];
			for (int j = 0; j < words[i].length(); j++) {
				tokens[j] = words[i].substring(j, words[i].length());
				tstObj.put(tokens[j], 0);
			}
		}
		System.out.println(tstObj.keysWithPrefix(input));
	}

	public static String[] loadWords() {
		In in = new In("/Files/dictionary-algs4.txt");
		String[] words = in.readAllStrings();
		return words;
	}
}