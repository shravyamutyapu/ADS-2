/**
 * importing files.
 */
import java.util.Scanner;
import java.lang.Math;
/**
 * Solution class.
 */
class Solution {
	/**
	 * main method.
	 * @param args args.
	 */
	public static void main(final String[] args) {
		/**
		 * sequential search symbol table.
		 */
          SequentialSearchST seqTable = new SequentialSearchST<Integer, Integer>();
          /**
		 * binary search symbol table.
		 */
          BinarySearchST binTable = new BinarySearchST<Integer, Integer>();
            //int[] keys = new int[15000];
          /**
           * loop iterates 15,000 times.
           */
            for (int i = 0; i < 15000; i++) {
            	//we are putting values in order.
                binTable.put(i, i);
                seqTable.put(i, i);
                //keys[i] = i;
                //trying to search for 99999.
                binTable.get(99999);
                seqTable.get(99999);
                //whenever search iterates its count increases by 1.
                if (Math.floor(seqTable.count/binTable.count) ==  10.0) {
                    System.out.println("10 times faster at size " + i);
                }
                if (Math.floor(seqTable.count/binTable.count) ==  100.0) {
                    System.out.println("100 times faster at size " + i);
                }
                if (Math.floor(seqTable.count/binTable.count) ==  1000.0) {
                    System.out.println("1000 times faster at size " + i);
                    break;
                }
            }
        }

}
