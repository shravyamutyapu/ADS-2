/**.
 * Interface for graph.
 */
interface Graph {
    /**
     * .
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
     * @param v vertice.
     * @param w w.
     */
    void addEdge(int v, int w);
    /**.
     * { function_description }
     *
     * @param v v.
     *
     * @return Iterable.
     */
    Iterable<Integer> adj(int v);
    /**.
     * Determines if it has edge.
     *
     * @param v vertex.
     * @param w w.
     *
     * @return True/False.
     */
    boolean hasEdge(int v, int w);
}
/**.
 * List of graphs.
 */
class GraphList implements Graph {
    /**.
     * vertex.
     */
    private int ver;
    /**.
     * edge.
     */
    private int edg;
    /**.
     * bag of integers.
     */
    private Bag<Integer>[] adj;
    /**.
     * vertices.
     */
    private String[] vert;
    /**.
     * size.
     */
    private int size = 0;
    /**
     * Initializes an empty graph with V vertices and 0 edges.
     * param V the number of vertices
     *
     * @param  vt number of vertices
     */
    GraphList(final int vt) {
        this.ver = vt;
        this.edg = 0;
        vert = new String[ver];
        size = 0;
        adj = (Bag<Integer>[]) new Bag[ver];
        for (int v = 0; v < ver; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    /**
     * Returns the number of vertices in this graph.
     * time complexity is 1 in avg case
     * @return the number of vertices in this graph
     */
    public int vert() {
        return ver;
    }

    /**
     * Returns the number of edges in this graph.
     * time complexity is 1 in avg case
     * @return the number of edges in this graph
     */
    public int edge() {
        return edg;
    }
    /**.
     * Adds a vertex.
     * time complexity is 1
     * @param v vertex.
     */
    public void addVertex(final String v) {
        vert[size] = v;
        size++;
    }
    /**.
     * Determines if it has edge.
     * time complexity is O(N).
     * @param v vert.
     * @param w  w.
     * @return True/False.
     */
    public boolean hasEdge(final int v, final int w) {
        for (int i : adj[w]) {
            if (i == w) {
                return true;
            }
        }
        return false;
    }
    /**
     * Adds the undirected edge v-w to this graph.
     * time complexity is 1 in avg case
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     */
    public void addEdge(final int v, final int w) {
        if (v == w) {
            System.out.println(ver + " vertices, " + edg + " edges");
            System.out.println("No edges");
            return;
        }
        if (!hasEdge(v, w)) {
            edg++;
        }
        adj[v].add(w);
        adj[w].add(v);
    }
    /**
     * Returns the vertices adjacent to vertex {@code v}.
     * time complexity is 1 in avg case
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degree(final int v) {
        return adj[v].size();
    }

    /**
     * Returns a string representation of this graph.
     * time complexity is O(N^2).
     * @return the number of vertices <em>V</em>, followed by
     * the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        String str = "";
        str += ver + " vertices, " + edg + " edges" + '\n';
        for (int v = 0; v < ver; v++) {
            str += vert[v] + ": ";
            for (int w : adj[v]) {
                str += vert[w] + " ";
            }
            str += '\n';
        }
        return str;
    }

}