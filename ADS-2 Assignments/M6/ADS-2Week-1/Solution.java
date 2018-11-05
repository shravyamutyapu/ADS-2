import java.util.Scanner;
/**.
 * class to find the pagerank
 */
class PageRank {
    /**.
     * graph as g
     */
    private Digraph g;
    /**.
     * reverse of the given graph as revG
     */
    private Digraph revG;
    /**.
     * variable for vertices
     */
    private int vertices;
    /**.
     * array to store the pageRanks
     */
    private Double[] pgRank;

    /**.
     * constructor
     *
     * @param gr The graph
     */
    PageRank(final Digraph gr) {
        //this.revMap = revMap;
        this.g = gr;
        this.revG = g.reverse();
        this.vertices = g.V();
        pgRank = new Double[vertices];
        int ver = g.V();
        for (int i = 0; i < vertices; i++) {
            //System.out.println("Vertex: "+ i);
            pgRank[i] = 1.0 / ver;
        }
        calcPageRank();
    }
    /**.
     * method to calculate the page Rank
     */
    public void calcPageRank() {
        for (int i = 0; i < vertices; i++) {
            if (g.outdegree(i) == 0) {
                for (int j = 0; j < vertices; j++) {
                    if (i != j) {
                        g.addEdge(i, j);
                    }
                }
            }
        }

        final int thou = 1000;
        for (int k = 1; k < thou; k++) {
            Double[] tempPR = new Double[vertices];
            for (int i = 0; i < vertices; i++) {
                Double sum = 0.0;

                for (int each : g.reverse().adj(i)) {
                    sum = sum
                    + pgRank[each] / g.outdegree(each);
                }
                tempPR[i] = sum;
                //System.out.println("for i: "
                //+i+"-- sum: "+sum);
                //pgRank[i] = sum;
            }
            //System.out.println("PGRANk: "
            //+Arrays.toString(pgRank));
            //System.out.println("tempPR: "
            //+Arrays.toString(tempPR));

            pgRank = tempPR;

        }
    }
    /**.
     * method to get the page rank for the given page rank
     *
     * @param      v     { vertices of type int }
     *
     * @return     The page rank.
     */
    public Double getPageRank(final int v) {
        return pgRank[v];
    }
    /**.
     * method to printer
     */
    public void printer() {
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " - " + pgRank[i]);
        }
    }
}
/**.
 * class to for web search
 */
class WebSearch {
//Websearch ckass
}

/**.
 * solution class
 */
final class Solution {
    /**.
     * constructor
     */
    private Solution() {
        //Constructor
    }
    /**.
     * main method to handle the input testcases
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**.
         * Scanner object
         */
        Scanner s = new Scanner(System.in);
        // read the first line of the
        // input to get the number of vertices
        //ArrayList<Bag<Integer>> list =
        //new ArrayList<Bag<Integer>>();

        int vertexCount = Integer.parseInt(s.nextLine());
        Digraph g = new Digraph(vertexCount);
        //int count=0;
        for (int i = 0; i < vertexCount; i++) {
            String[] tokens = s.nextLine().split(" ");
            //Bag<Integer> bag = new Bag<Integer>();
            for (int j = 1; j < tokens.length; j++) {
                int id = Integer.parseInt(tokens[0]);
                int child = Integer.parseInt(tokens[j]);

                g.addEdge(id, child);
                //count++;
                //bag.add(j);
            }
            //list.add(bag);

        }
        // iterate count of vertices times
        // to read the adjacency list from std input
        // and build the graph

        //System.out.println(
        //vertexCount+" vertices, "+count+" edges");
        //System.out.println("ITs done");
        System.out.println(g.toString());
        //System.out.println("ITs done");

        PageRank pageRankObj = new PageRank(g);


        // Create page rank object to
        //pass the graph object to the constructor
        pageRankObj.printer();

        // print the page rank object

        // This part is only for the final test case

        // File path to the web content
        String file = "WebContent.txt";

        // instantiate web search object
        // and pass the page rank object
        // and the file path to the constructor

        // read the search queries from std in
        // remove the q= prefix and extract the search word
        // pass the word to iAmFeelingLucky method of web search
        // print the return value of iAmFeelingLucky

    }
}