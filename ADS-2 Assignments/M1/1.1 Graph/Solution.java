/**.
 * importing scanner;
 */
import java.util.Scanner;
/**.
 * solution class.
 */
public final class Solution {
    /**.
     * private default constructor.
     */
    private Solution() {
        //unused.
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    // time complexity for the main method is N
    // Because there is one while loop.
    // while loop iterates until it has next line i.e N times.
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        int vertexCount =  sc.nextInt();
        int edgeCount = sc.nextInt();
        switch (word) {
            case"List":
                if (vertexCount == 0 && edgeCount == 0) {
                    System.out.println(vertexCount + " vertices, " + edgeCount + " edges");
                    System.out.println("No edges");
                    break;
                }
                String vert = sc.nextLine();
                String[] tokens1 = vert.split(",");
                GraphList obj1 = new GraphList(vertexCount);
                for (int i = 0; i < vertexCount; i++) {
                    obj1.addVertex(tokens1[i]);
                }
                String line1;
                String[] tokens2 = new String[edgeCount];
                for (int i = 0; i < edgeCount ; i++) {
                    line1 = sc.nextLine();
                    tokens2 = line1.split(" ");
                        obj1.addEdge(Integer.parseInt(tokens2[0]),
                         Integer.parseInt(tokens2[1]));
                }
                if (Integer.parseInt(tokens2[0])
                 == Integer.parseInt(tokens2[1])) {
                    break;
                } else {
                    System.out.println(obj1.toString());
                }
                break;
            case"Matrix":
                if (vertexCount == 0 && edgeCount == 0) {
                    System.out.println(vertexCount + " vertices, " + edgeCount + " edges");
                    System.out.println("No edges");
                    break;
                }
                String vtxes = sc.nextLine();
                String[] tkens = vtxes.split(",");
                GraphList object = new GraphList(vertexCount);
                for (int i = 0; i < vertexCount; i++) {
                    object.addVertex(tkens[i]);
                }
                String line;
                String[] tokens = new String[edgeCount];
                for (int i = 0; i < edgeCount; i++) {
                    line = sc.nextLine();
                    tokens = line.split(" ");
                    object.addEdge(Integer.parseInt(tokens[0]),
                     Integer.parseInt(tokens[1]));
                }
                if (Integer.parseInt(tokens[0])
                 == Integer.parseInt(tokens[1])) {
                    break;
                } else {
                    System.out.println(object.toString());
                }
                break;
            default:
            break;
        }
    }
}