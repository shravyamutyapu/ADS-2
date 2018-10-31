
import java.util.Scanner;

public final class Solution {

    private Solution() {
        //unused
    }
    /**.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertexCount = Integer.parseInt(sc.nextLine());
        int edgeCount = Integer.parseInt(sc.nextLine());
        Digraph obj = new Digraph(vertexCount);
        for(int i=0;i<edgeCount;i++) {
            String[] tokens = sc.nextLine().split(" ");
            obj.addEdge(Integer.parseInt(tokens[0]),
                         Integer.parseInt(tokens[1]));
        }
        DirectedCycle dir = new DirectedCycle(obj);
        if (dir.hasCycle()) {
            System.out.println("Cycle exists");
        }
            System.out.println("Cycle doesn't exists");

    }
}