import java.util.ArrayList;
import java.util.HashMap;

public class BoggleSolver {

	private TrieST<Integer> dict;

	private BoggleBoard board;

	private HashMap<String, Integer> map;

	private ArrayList<String> list;

	public BoggleSolver(String[] dictionary) {
		dict = new TrieST<>();
		for (int i = 0; i < dictionary.length; i++) {
			dict.put(dictionary[i], getScore(dictionary[i]));
		}
	}

	public Iterable<String> getAllValidWords(BoggleBoard board) {
		this.board = board;
		this.map = new HashMap<>();
		this.list = new ArrayList<>();
		boolean[][] marked = new boolean[board.rows()][board.cols()];
		for (int i = 0; i < board.rows(); i++) {
			for (int j = 0; j < board.cols(); j++) {
				validate(marked, "", i, j, 0);
			}
		}
		return list;
	}

	private void validate(boolean[][] matrix, String prefix,
        int i, int j,int count) {
        char c = board.getLetter(i, j);
        if (c == 'Q') {
            prefix += "QU";
            count += 2;
        }
        else {
            prefix += c;
            count += 1;
        }
        matrix[i][j] = true;
        boolean temp = false;
        if (dict.contains(prefix)) {
            temp = true;
            if (count >= 3 && !map.containsKey(prefix)) {
                map.put(prefix, getScore(prefix));
                list.add(prefix);
            }
        }
            if (temp || dict.contains1(prefix)) {
            if (j - 1 >= 0 && !matrix[i][j - 1])
                validate(matrix, prefix, i, j - 1, count);
            if (j + 1 < board.cols() && !matrix[i][j + 1])
                validate(matrix, prefix, i, j + 1, count);
            if (i - 1 >= 0) {
                if (j - 1 >= 0 && !matrix[i - 1][j - 1])
                    validate(matrix, prefix, i - 1, j - 1, count);
                if (!matrix[i - 1][j])
                    validate(matrix, prefix, i - 1, j, count);
                if (j + 1 < board.cols() && !matrix[i - 1][j + 1])
                    validate(matrix, prefix, i - 1, j + 1, count);
            }
        }
        matrix[i][j] = false;
    }


	private int getScore(String word) {
			int len = word.length();
			if (len <= 2)
				return 0;
			if (len == 3)
				return 1;
			else if (len == 4)
				return 1;
			else if (len == 5)
				return 2;
			else if (len == 6)
				return 3;
			else if (len == 7)
				return 5;
			else if (len >= 8)
				return 11;
			else return 0;
		}

		public int scoreOf(String word) {
			if (dict.contains(word))
				return dict.get(word);
			return 0;
		}
	}