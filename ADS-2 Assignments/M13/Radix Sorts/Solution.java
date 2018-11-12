/**
 * importing files.
 */
import java.util.Scanner;
/**
 * solution class.
 */
final class Solution {
    /**
     * default constructor.
     */
    public Solution() {
        //unused.
    }
    /**
     * main method.
     * @param args String.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        LSD lsd = new LSD();
        int n = Integer.parseInt(sc.nextLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        int len = arr[1].length();

        lsd.sort(arr, len);
        System.out.println(lsd);
    }
}

