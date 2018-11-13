import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		String[] words = loadWords();
		//Your code goes here...
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		TST tstObj = new TST();
		for(int i=0;i<words.length;i++){
			if(words[i].contains(input))
			System.out.println(words[i]);
		}
	}

	public static String[] loadWords() {
		In in = new In("/Files/dictionary-algs4.txt");
		String[] words = in.readAllStrings();
		return words;
	}
}