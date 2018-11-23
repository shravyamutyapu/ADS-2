/**.
 * importing files.
 */
import java.util.Scanner;
/**.
 * solution class.
 */
public final class Solution {
    /**.
     * constructor.
     */
    private Solution() {
        //unused.
    }
    /**.
     * time complexity for the main method is N.
     * @param args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        int n =  sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        switch (word) {
            case"List":
                if (n == 0 && m == 0) {
                    System.out.println(n + " vertices, " + m + " edges");
                    System.out.println("No edges");
                    break;
                }
                String ver1 = sc.nextLine();
                String[] tokens1 = ver1.split(",");
                GraphList graphlist = new GraphList(n);
                for (int i = 0; i < n; i++) {
                    graphlist.addVertex(tokens1[i]);
                }
                String line1;
                String[] tokens2 = new String[m];
                for (int i = 0; i < m; i++) {
                    line1 = sc.nextLine();
                    tokens2 = line1.split(" ");
                        graphlist.addEdge(Integer.parseInt(tokens2[0]),
                         Integer.parseInt(tokens2[1]));
                }
                if (Integer.parseInt(tokens2[0])
                 == Integer.parseInt(tokens2[1])) {
                    break;
                } else {
                    System.out.println(graphlist.toString());
                }
                break;
            case"Matrix":
                if (n == 0 && m == 0) {
                    System.out.println(n + " vertices, " + m + " edges");
                    System.out.println("No edges");
                    break;
                }
                String vtxes = sc.nextLine();
                String[] tokens3 = vtxes.split(",");
                GraphMatrix graphmat = new GraphMatrix(n);
                for (int i = 0; i < n; i++) {
                    graphmat.addVertex(tokens3[i]);
                }
                String line;
                String[] tokens = new String[m];
                for (int i = 0; i < m; i++) {
                    line = sc.nextLine();
                    tokens = line.split(" ");
                    graphmat.addEdge(Integer.parseInt(tokens[0]),
                     Integer.parseInt(tokens[1]));
                }
                if (Integer.parseInt(tokens[0])
                 == Integer.parseInt(tokens[1])) {
                    break;
                } else {
                    System.out.println(graphmat.toString());
                }
                break;
            default:
            break;
        }
    }
}


