import java.util.Scanner;
import java.lang.Math;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BinarySearchST<Integer, Integer>  binTable = new BinarySearchST<Integer, Integer>();
		SequentialSearchST<Integer,Integer> seqTable = new SequentialSearchST<Integer,Integer>();
		for (int i = 0; i < 15000; i++) {
			binTable.put(i, i);
			seqTable.put(i,i);
			//keys[i] = i;
        long seqStart = System.nanoTime();
        int worstCase = 99999;
            seqTable.get(worstCase);
        long seqRunTime = System.nanoTime() - seqStart;
        long binStart = System.nanoTime();
        binTable.get(worstCase);
        long binRunTime = System.nanoTime() - binStart;

        if (Math.floor(seqRunTime / binRunTime) == 10.0) {
                System.out.println("Size of ST at which search is 10x " + i);
            }
        if (Math.floor(seqRunTime / binRunTime ) ==  100.0) {
                System.out.println("Size of ST at which search is 100x " + i);

            }
        if (Math.floor(seqRunTime / binRunTime ) ==  1000.0){
                System.out.println("Size of ST at which search is 1000x " + i);
            }
        }
}

}
