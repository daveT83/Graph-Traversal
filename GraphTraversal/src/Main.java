
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String fileName = "./Graphs/input.txt";
		
		Graph tree = new Graph(fileName);
		Search search;
		
		tree.buildGraph();			//build the graph
		search = new Search(tree,tree.getStart(),tree.getEnd());
		
		//breadth first search
		System.out.println("Breadth First Search");
		
		//prints the header for the tree
		tree.printNodesNumNeighbors();
		tree.printNodesNeighbors();
		tree.printNodesCost();
		
		//performs the search
		search.setSearch(Search.BREADTH);
		if(search.search() == -1) {
			System.out.println("The goal wasn't reached.");
		}
		
		//depth first search
		System.out.println();
		System.out.println("Depth First Search");
		
		//prints the header for the tree
		tree.printNodesNumNeighbors();
		tree.printNodesNeighbors();
		tree.printNodesCost();
		
		//performs the search
		search.reset();
		search.setSearch(Search.DEPTH);
		if(search.search() == -1) {
			System.out.println("The goal wasn't reached.");
		}	}

}
