/**.
 * importing scanner.
 */
import java.util.Scanner;
/**.
 * solution class.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**.
     *
     * @param args The arguments
     */
    // time complexity for the main method is O(N).
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Percolation p = new Percolation(n);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            p.open(Integer.parseInt(tokens[0]) - 1,
                         Integer.parseInt(tokens[1]) - 1);
        }
        System.out.println(p.percolates());
    }
}