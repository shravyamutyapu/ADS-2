import java.util.Scanner;
import java.util.ArrayList;
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
		    int source = Integer.parseInt(path[0]);
		    int destiny = Integer.parseInt(path[1]);
			DijkstraUndirectedSP pathObj = new DijkstraUndirectedSP(graphObj, source);
			if(pathObj.hasPathTo(destiny)) {
				System.out.println(pathObj.distTo(destiny));
			}
			else {
				System.out.println("No Path Found.");
			}

			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the path[1].
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
		    String[] path1 = sc.nextLine().split(" ");
		    int source1 = Integer.parseInt(path1[0]);
		    int via = Integer.parseInt(path1[1]);
		    int destiny1 = Integer.parseInt(path1[2]);

			DijkstraUndirectedSP path1Obj = new DijkstraUndirectedSP(graphObj, source1);
			if(path1Obj.hasPathTo(via)) {

				DijkstraUndirectedSP viaObj = new DijkstraUndirectedSP(graphObj, via);
				if(viaObj.hasPathTo(destiny1)) {
					double dist = path1Obj.distTo(via);
					dist += viaObj.distTo(destiny1);
					System.out.println(dist);

				ArrayList<Integer> arraylist = new ArrayList<Integer>();
					String srcvia = path1Obj.pathTo(via)+""+viaObj.pathTo(destiny1);
					//System.out.println(srcvia);
				 	String[] temp = srcvia.split(" ");
				 	String[] temp1 = temp[0].split("-");
				 	String[] temp2 = temp[2].split("-");
				 	String[] temp3 = temp[4].split("-");
				 	String[] temp4 = temp[6].split("-");
				 	String[] temp5 = temp[8].split("-");

				// 	String[] val = temp[1].split(" ");
				 	arraylist.add(Integer.parseInt(temp1[1]));
					arraylist.add(Integer.parseInt(temp1[0]));
					arraylist.add(Integer.parseInt(temp3[1]));
					arraylist.add(Integer.parseInt(temp3[0]));
					arraylist.add(Integer.parseInt(temp5[1]));
					arraylist.add(Integer.parseInt(temp5[0]));






				System.out.println(arraylist);



					//System.out.println(path1Obj.pathTo(via)+""+viaObj.pathTo(destiny1));
			}


			else {
				System.out.println("No Path Found.");
			}
		}

			break;

		default:
			break;
		}

	}
}