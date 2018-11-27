/**
 * importing files.
 */
import java.util.NoSuchElementException;
/**
 * digraph class.
 */
public class Digraph {
	private static final String NEWLINE = System.getProperty("line.separator");

	private final int vert;           // number of vertices in this digraph
	private int edg;                 // number of edges in this digraph
	private Bag<Integer>[] adj;     // adj[v] = adjacency list for vertex v
	private int size = 0;
	private int[] indegree;        // indegree[v] = indegree of vertex v

	/**
	 * Initializes an empty digraph with <em>V</em> vertices.
	 *
	 * @param  vert1 the number of vertices
	 * @throws IllegalArgumentException if {@code V < 0}
	 */
	public Digraph(int vert1) {
		if (vert1 < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.vert = vert1;
		this.edg = 0;
		indegree = new int[vert];
		size = 0;
		adj = (Bag<Integer>[]) new Bag[vert];
		for (int v = 0; v < vert; v++) {
			adj[v] = new Bag<Integer>();
		}
	}
	/**
	 * vertices.
	 * time complexity is 1.
	 * @return int [description]
	 */
	public int vert() {
		return vert;
	}
	/**
	 * edges.
	 * time complexity is 1.
	 * @return int [description]
	 */
	public int edg() {
		return edg;
	}

	// /**
	//  * Initializes a digraph from the specified input stream.
	//  * The format is the number of vertices <em>V</em>,
	//  * followed by the number of edges <em>E</em>,
	//  * followed by <em>E</em> pairs of vertices, with each entry separated by whitespace.
	//  *
	//  * @param  in the input stream
	//  * @throws IllegalArgumentException if the endpoints of any edge are not in prescribed range
	//  * @throws IllegalArgumentException if the number of vertices or edges is negative
	//  * @throws IllegalArgumentException if the input stream is in the wrong format
	//  */
	// public Digraph(Scanner in) {
	//     try {
	//         this.V = in.readInt();
	//         if (V < 0) throw new IllegalArgumentException("number of vertices in a Digraph must be nonnegative");
	//         indegree = new int[V];
	//         adj = (Bag<Integer>[]) new Bag[V];
	//         for (int v = 0; v < V; v++) {
	//             adj[v] = new Bag<Integer>();
	//         }
	//         int E = in.readInt();
	//         if (E < 0) throw new IllegalArgumentException("number of edges in a Digraph must be nonnegative");
	//         for (int i = 0; i < E; i++) {
	//             int v = in.readInt();
	//             int w = in.readInt();
	//             addEdge(v, w);
	//         }
	//     }
	//     catch (NoSuchElementException e) {
	//         throw new IllegalArgumentException("invalid input format in Digraph constructor", e);
	//     }
	// }

	// /**
	//  * Initializes a new digraph that is a deep copy of the specified digraph.
	//  *
	//  * @param  G the digraph to copy
	//  */
	// public Digraph(Digraph G) {
	//     this(G.V());
	//     this.E = G.E();
	//     for (int v = 0; v < V; v++)
	//         this.indegree[v] = G.indegree(v);
	//     for (int v = 0; v < G.V(); v++) {
	//         // reverse so that adjacency list is in same order as original
	//         Stack<Integer> reverse = new Stack<Integer>();
	//         for (int w : G.adj[v]) {
	//             reverse.push(w);
	//         }
	//         for (int w : reverse) {
	//             adj[v].add(w);
	//         }
	//     }
	// }

	// throw an IllegalArgumentException unless {@code 0 <= v < V}
	/**
	 * /**
	 * vertices.
	 * time complexity is 1.
	 * @return int [description]
	 *  @param v [description]
	 */
	private void validateVertex(int v) {
		if (v < 0 || v >= vert)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (vert - 1));
	}
	/**
	 * has edge method.
	 * Time complexity is O(E).
	 * E is the number of Edges.
	 * @param v vertex.
	 * @param w vertex.
	 *
	 * @return bool val.
	 */
	public boolean hasEdge (final int v, final int w) {
		for (int i : adj[w]) {
			if (i == w) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds the directed edge v→w to this digraph.
	 * time complexity is O(1).
	 * @param  v the tail vertex
	 * @param  w the head vertex
	 * @throws IllegalArgumentException
	 * unless both {@code 0 <= v < V} and {@code 0 <= w < V}
	 */
	public void addEdge(final int v, final int w) {
		validateVertex(v);
		validateVertex(w);
		adj[v].add(w);
		indegree[w]++;
		edg++;
	}

	/**
	 * Returns the vertices adjacent
	 * from vertex {@code v} in this digraph.
	 * time complexity is O(1).
	 * @param  v the vertex
	 * @return the vertices adjacent from vertex
	 * {@code v} in this digraph, as an iterable
	 * @throws IllegalArgumentException unless
	 * {@code 0 <= v < V}
	 */
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}

	/**
	 * Returns the number of directed edges incident from vertex {@code v}.
	 * This is known as the <em>outdegree</em> of vertex {@code v}.
	 * time complexity is O(1).
	 * @param  v the vertex
	 * @return the outdegree of vertex {@code v}
	 * @throws IllegalArgumentException unless {@code 0 <= v < V}
	 */
	public int outdegree(int v) {
		validateVertex(v);
		return adj[v].size();
	}

	/**
	 * Returns the number of directed edges incident to vertex {@code v}.
	 * This is known as the <em>indegree</em> of vertex {@code v}.
	 *  time complexity is O(1).
	 * @param  v the vertex
	 * @return the indegree of vertex {@code v}
	 * @throws IllegalArgumentException unless {@code 0 <= v < V}
	 */
	public int indegree(int v) {
		validateVertex(v);
		return indegree[v];
	}

	// /**
	//  * Returns the reverse of the digraph.
	//  *
	//  * @return the reverse of the digraph
	//  */
	// public Digraph reverse() {
	//     Digraph reverse = new Digraph(V);
	//     for (int v = 0; v < V; v++) {
	//         for (int w : adj(v)) {
	//             reverse.addEdge(w, v);
	//         }
	//     }
	//     return reverse;
	// }

	// /**
	//  * Returns a string representation of the graph.
	//  *
	//  * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
	//  *         followed by the <em>V</em> adjacency lists
	//  */
	// public String toString() {
	//     StringBuilder s = new StringBuilder();
	//     s.append(V + " vertices, " + E + " edges " + NEWLINE);
	//     for (int v = 0; v < V; v++) {
	//         s.append(String.format("%d: ", v));
	//         for (int w : adj[v]) {
	//             s.append(String.format("%d ", w));
	//         }
	//         s.append(NEWLINE);
	//     }
	//     return s.toString();
	// }

	// /**
	//  * Unit tests the {@code Digraph} data type.
	//  *
	//  * @param args the command-line arguments
	//  */
	// public static void main(String[] args) {
	//     Scanner in = new Scanner(args[0]);
	//     Digraph G = new Digraph(in);
	//     System.out.println(G);
	// }

}
