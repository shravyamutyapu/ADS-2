import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
		int cities = Integer.parseInt(sc.nextLine());
		int roads = Integer.parseInt(sc.nextLine());

        EdgeWeightedGraph graphObj = new EdgeWeightedGraph(cities);
           for (int i = 0; i < roads; i++) {
            String way = sc.nextLine();
            String[] tokens = way.split(" ");
            graphObj.addEdge(new Edge(Integer.parseInt(tokens[0]),
             Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2])));
        }

		String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
		    System.out.println(graphObj);
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the path[1].
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
		    String[] path = sc.nextLine().split(" ");
			DijkstraUndirectedSP pathObj = new DijkstraUndirectedSP(graphObj, Integer.parseInt(path[0]));
			if(pathObj.hasPathTo(Integer.parseInt(path[1]))) {
				System.out.println(pathObj.distTo(Integer.parseInt(path[1])));
			}

			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the path[1].
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}