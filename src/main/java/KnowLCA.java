/* A JAVA application to input a DOT file from the user and two vertices and output their LCA.
 * If multiple ancestors are present then it should return all of them.
 * The output should be written to standard output.
 */

import java.io.*;
import java.util.*;
import org.jgrapht.alg.*;
import org.jgrapht.graph.*;
import org.jgrapht.io.*;

public class KnowLCA {

	public static void main(String[] args) throws FileNotFoundException {
		
		VertexProvider<String> V = (a, b) -> a;
	    EdgeProvider<String, DefaultEdge> E = (x, y, z, a) -> new DefaultEdge();
	    GraphImporter<String, DefaultEdge> importer = new DOTImporter<String, DefaultEdge>(V, E);
	    DirectedPseudograph<String, DefaultEdge> graph = new DirectedPseudograph<String, DefaultEdge>(DefaultEdge.class);
	    //importing the file and converting into graph
	    try {
	    	File file = new File(args[0]);
			importer.importGraph(graph, file);
		} 
	    catch (ImportException e) {
			e.printStackTrace();
		}
	    //checking if the vertices are present in the graph or not
	    if((!graph.containsVertex(args[1]))||(!graph.containsVertex(args[2])))
	    {
	    	System.out.println("The provided vertex is not present in the graph.");
	    	return;
	    }
	    //checking for cycles in the graph as LCAs work for DAGs only	    
	    CycleDetector<String, DefaultEdge> graphFinder = new CycleDetector<String, DefaultEdge>(graph);
	    if(graphFinder.detectCycles())
	    {
	    	System.out.println("The graph contains of cycles.");
	    	return;
	    }
	    //finding the LCAs and displaying them on the standard output	
	    NaiveLcaFinder<String, DefaultEdge> graphFind = new NaiveLcaFinder<String, DefaultEdge>(graph);
        Set<String> ve=graphFind.findLcas(args[1],args[2]);
	    Iterator<String> iter = ve.iterator();
	    while (iter.hasNext()) {
	       System.out.println(iter.next());
	    }
	}
}
