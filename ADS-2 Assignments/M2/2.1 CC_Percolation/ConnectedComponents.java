/**.
 * Few methods have been removed.
 * Class for connected component.
 */
class ConnectedComponent {
    /**
     * boolean[].
     */
    private boolean[] marked;
    /**
     * int[].
     */
    private int[] id;
    /**
     * int[].
     */
    private int[] size;
    /**
     * int.
     */
    private int count;
    /**
     * connected components of the
     * undirected graph {@code G}.
     *
     * @param g the undirected graph
     */
    public ConnectedComponent(final GraphList g) {
        marked = new boolean[g.vert()];
        id = new int[g.vert()];
        size = new int[g.vert()];
        for (int v = 0; v < g.vert(); v++) {
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }
    }

    /**.
     * time complexity is O(N).
     * method on depth first traversal
     * @param  g the undirected graph
     * @param  v the vertex
     */
    private void dfs(final GraphList g, final int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    /**.
     * time complexity in average case is 1.
     * @param  v the vertex
     * @return the component id of the connected
     * component containing vertex {@code v}
     */
    public int id(final int v) {
        return id[v];
    }

    /**.
     * time complexity in average case is 1.
     * @param  v the vertex
     * @return the number of vertices in the connected
     * component containing vertex {@code v}
     */
    public int size(final int v) {
        return size[id[v]];
    }

    /**
     * time complexity in average case is 1.
     * Returns the number of connected components
     * in the graph {@code G}.
     *
     * @return the number of connected components
     * in the graph {@code G}
     */
    public int count() {
        return count;
    }

    /**
     * time complexity in average case is 1.
     *
     * @param  v one vertex
     * @param  w the other vertex
     * @return the true or false
     */
    public boolean connected(final int v, final int w) {
        return id(v) == id(w);
    }

    /**
     * time complexity is 1.
     * @param  v one vertex
     * @param  w the other vertex
     * @return the true or false
     */
    public boolean areConnected(final int v, final int w) {
        return id(v) == id(w);
    }
}