import java.util.Scanner;
class PageRank {
   Digraph dg;
   int vertex;
   double[] pageRankvals;
   int[] outCount;
   PageRank(Digraph dg1, int vt, double[] pageRankvals){
   	this.dg = dg1;
   	this.vertex = vt;
   	pageRankvals = new double[vt];
   	outCount = new int[vt];
   }
}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
        Scanner sc = new Scanner(System.in);

        int vertexCount = Integer.parseInt(sc.nextLine());
        Digraph digraph = new Digraph(vertexCount);

        String[] incomingvertices = new String[vertexCount];
        for(int i = 0;i<vertexCount;i++){
          String[] tokens = sc.nextLine().split(" ");
          int key = Integer.parseInt(tokens[0]);
          for(int j = 1; j<tokens.length; j++) {
                digraph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[i]));

         }

        }
        System.out.println(digraph);
		// iterate count of vertices times
		// to read the adjacency list from std input
		// and build the graph


		// Create page rank object and pass the graph object to the constructor

		// print the page rank object

		// This part is only for the final test case

		// File path to the web content
		String file = "WebContent.txt";

		// instantiate web search object
		// and pass the page rank object and the file path to the constructor

		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky

	}
}
