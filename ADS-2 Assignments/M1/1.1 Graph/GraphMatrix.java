/**.
 * Interface for graph.
 */
interface GraphM {
    /**.
     *
     * @return vertices.
     */
    int vert();
    /**.
     *
     * @return edges.
     */
    int edge();
    /**.
     * Adds an edge.
     *
     * @param v vert.
     * @param w w.
     */
    void addEdge(int v, int w);
    /**.
     * .
     * @param v vertex.
     *
     * @return iterable.
     */
    Iterable<Integer> adj(int v);
    // public boolean hasEdge(int v, int w);
}
/**.
 * List of graphs.
 */
public class GraphMatrix {
    /**.
     * vertices.
     */
    private final int ver;
    /**.
     * edge.
     */
    private int edg;
    /**.
     * adjacency.
     */
    private int[][] adj;
    /**.
     *
     */
    private String[] vertices;
    /**.
     * { var_description }
     */
    private int size = 0;
    /**.
     * Constructs the object.
     *
     * @param vt vertices.
     */
    public GraphMatrix(final int vt) {
        this.ver = vt;
        this.edg = 0;
        this.adj = new int[ver][ver];
        vertices = new String[ver];
        size = 0;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int vert() {
        return ver;
    }
    /**.
     * .
     * time complexity is 1.
     * @return int.
     */
    public int edge() {
        return edg;
    }
    /**.
     * Adds a vertex.
     *
     * @param v adding vertex.
     */
    public void addVertex(final String v) {
        vertices[size] = v;
        size++;
    }
    /**
     * time complexity is 1.
     * @param  v vert.
     * @param  w w.
     */
    public void addEdge(final int v, final int w) {
        if (v == w) {
            System.out.println(ver + " vertices, " + edg + " edges");
            System.out.println("No edges");
            return;
        }
        if (adj[v][w] == 0) {
            edg++;
            adj[v][w] = 1;
            adj[w][v] = 1;
        }
    }
    /**.
     * checks if it contains or not.
     * time complexity is 1.
     * @param v v.
     * @param w w.
     * @return int.
     */
    public int contains(final int v, final int w) {
        return adj[v][w];
    }
    /**.
     * Returns a string representation of the object.
     * time complexity is O(v*2).
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(ver + " vertices, " + edg + " edges" + '\n');
        for (int v = 0; v < ver; v++) {
            // s.append(v + ": ");
            for (int w : adj[v]) {
                if (w == 1) {
                    s.append(1 + " ");
                } else {
                    s.append(0 + " ");
                }
            }
            s.append('\n');
        }
        return s.toString();
    }
}