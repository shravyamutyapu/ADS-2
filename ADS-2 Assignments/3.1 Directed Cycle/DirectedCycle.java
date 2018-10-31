public class DirectedCycle {
    private boolean[] marked;        // marked[v] = has vertex v been marked?
    private int[] edgeTo;            // edgeTo[v] = previous vertex on path to v
    private boolean[] onStack;       // onStack[v] = is vertex on the stack?
    private Stack<Integer> cycle;    // directed cycle (or null if no such cycle)

    /**
     * Determines whether the digraph
     * {@code G} has a directed cycle and, if so,
     * finds such a cycle.
     * @param G the digraph
     */
    public DirectedCycle(Digraph g) {
        marked  = new boolean[g.vert()];
        onStack = new boolean[g.vert()];
        edgeTo  = new int[g.vert()];
        for (int v = 0; v < g.vert(); v++)
            if (!marked[v] && cycle == null) dfs(g, v);
    }

    // check that algorithm computes
    //either the topological order or finds a directed cycle
    private void dfs(Digraph g, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : g.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) return;

            // found new vertex, so recur
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }

            // trace back directed cycle
            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                // assert check();
            }
        }
        onStack[v] = false;
    }

    /**
     * Does the digraph have a directed cycle?
     * @return {@code true} if the digraph
     * has a directed cycle, {@code false} otherwise
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    /**
     * Returns a directed cycle if the digraph has a
     * directed cycle, and {@code null} otherwise.
     * @return a directed cycle (as an iterable) if
     * the digraph has a directed cycle,
     *    and {@code null} otherwise
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }


    // certify that digraph has a directed cycle
    //if it reports one
    // private boolean check() {

    //     if (hasCycle()) {
    //         // verify cycle
    //         int first = -1, last = -1;
    //         for (int v : cycle()) {
    //             if (first == -1) first = v;
    //             last = v;
    //         }
    //         if (first != last) {
    //             System.err.printf("cycle begins with %d and ends with %d\n", first, last);
    //             return false;
    //         }
    //     }


    //     return true;
    // }

    // /**
    //  * Unit tests the {@code DirectedCycle} data type.
    //  *
    //  * @param args the command-line arguments
    //  */
    // public static void main(String[] args) {
    //     In in = new In(args[0]);
    //     Digraph G = new Digraph(in);

    //     DirectedCycle finder = new DirectedCycle(G);
    //     if (finder.hasCycle()) {
    //         StdOut.print("Directed cycle: ");
    //         for (int v : finder.cycle()) {
    //             StdOut.print(v + " ");
    //         }
    //         StdOut.println();
    //     }

    //     else {
    //         StdOut.println("No directed cycle");
    //     }
    //     StdOut.println();
    // }

}
