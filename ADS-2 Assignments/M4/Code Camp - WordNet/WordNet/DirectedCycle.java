/**
 * direceted cycle class.
 */
public class DirectedCycle {
    /**
     * marked[v] = has vertex v been marked?
     * the above will be stored.
     */
    private boolean[] marked;
    /**
     * edgeTo[v] = previous vertex on path to v.
     */
    private int[] edgeTo;
    /**
     * onStack[v] = is vertex on the stack?
     */
    private boolean[] onStack;
    /**
     * directed cycle (or null if no such cycle)
     */
    private Stack<Integer> cycle;

    /**
     * Determines whether the digraph
     * {@code G} has a directed cycle and, if so,
     * finds such a cycle.
     * @param G the digraph
     */
    public DirectedCycle(Digraph g) {
        marked  = new boolean[g.V()];
        onStack = new boolean[g.V()];
        edgeTo  = new int[g.V()];
        for (int v = 0; v < g.V(); v++)
            if (!marked[v] && cycle == null) dfs(g, v);
    }

    // check that algorithm computes
    //either the topological order or finds a directed cycle
    /**
     * Time complexity is O(E).
     * E is number of Edges.
     * @param g object of digraph.
     * @param v vertices.
     */
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
     * Time complexity is O(1).
     * Does the digraph have a directed cycle?
     * @return {@code true} if the digraph
     * has a directed cycle, {@code false} otherwise
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    /**
     * Time complexity is O(1).
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
