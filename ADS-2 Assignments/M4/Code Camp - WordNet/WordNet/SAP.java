import java.util.*;

public class SAP {
	Digraph digraph;
	int distance;
	int ancestor;
	public SAP(Digraph G){
		digraph = G;
		distance = Integer.MAX_VALUE;
		ancestor = -1;
	}
    /**
     * Time complexity is O(V*w*V).
     * V is the number of vertices.
     * W is length of array list.
     * @param v [description]
     * @param w [description]
     *
     * @return [description]
     */
	public int length(int v, int w){
		ancestor(v, w);
		if(ancestor != -1){
			return distance;
		}return -1;

	}
	/**
	 * Time complexity is O(V).
     * V is the number of vertices.
	 * @param v [description]
	 * @param w [description]
	 *
	 * @return [description]
	 */
	public int ancestor(int v, int w){
		BreadthFirstDirectedPaths bfsv = new
		BreadthFirstDirectedPaths(digraph, v);
		BreadthFirstDirectedPaths bfsw = new
		BreadthFirstDirectedPaths(digraph, w);
		for(int i = 0; i < digraph.V(); i++){
			if(bfsv.hasPathTo(i) && bfsw.hasPathTo(i)) {
		int tempdist = bfsv.distTo(i) + bfsw.distTo(i);
				if(tempdist < distance){
					distance = tempdist;
					ancestor = i;
				}
			}
		}
		return ancestor;
	}
	/**
	 *Time complexity is O(V).
     * V is the number of vertices.
	 * @param v tag.
	 * @param w [description]
	 * @return [description]
	 */
	public int length(Iterable<Integer> v, Iterable<Integer> w){
		ancestor(v, w);
		if(ancestor != -1){
			return distance;
		}return -1;
	}
	/**
	 * Time complexity is O(V).
     * V is the number of vertices.
	 * @param w [description]
	 * @return [description]
	 */
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w){
		for(int i : v){
			for(int j : w){
				ancestor(i, j);
			}
		}
		return ancestor;
	}

}