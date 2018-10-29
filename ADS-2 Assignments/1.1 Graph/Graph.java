public class Graph {
    private final int vt;
    private int ed;
    private Bag<Integer>[] adj;
    private int size = 0;
     private String[] vertexes;

    /**
     * Initializes an empty graph with {@code V} vertices and 0 edges.
     * param V the number of vertices
     *
     * @param  ver number of vertices
     */
    public Graph(final int ver) {
        this.vt = ver;
        this.ed = 0;
        adj = (Bag<Integer>[]) new Bag[ver];
        for (int v = 0; v < ver; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    public void addVertex(final String v) {
        vertexes[size] = v;
        size++;
    }
    // public Graph(In in) {
    //     try {
    //         this.V = in.readInt();
    //         if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
    //         adj = (Bag<Integer>[]) new Bag[V];
    //         for (int v = 0; v < V; v++) {
    //             adj[v] = new Bag<Integer>();
    //         }
    //         int E = in.readInt();
    //         if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
    //         for (int i = 0; i < E; i++) {
    //             int v = in.readInt();
    //             int w = in.readInt();
    //             validateVertex(v);
    //             validateVertex(w);
    //             addEdge(v, w);
    //         }
    //     }
    //     catch (NoSuchElementException e) {
    //         throw new IllegalArgumentException("invalid input format in Graph constructor", e);
    //     }
    // }

    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int vertex() {
        return vt;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int edges() {
        return ed;
    }

    /**
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     */
    public void addEdge(final int v, final int w) {
        ed++;
        adj[v].add(w);
        adj[w].add(v);
    }


    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
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
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vt + " vertices, " + ed + " edges " + '\n');
        for (int v = 0; v < vt; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append('\n');
        }
        return s.toString();
    }
}

