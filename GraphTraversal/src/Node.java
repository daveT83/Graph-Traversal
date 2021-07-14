import java.util.ArrayList;

public class Node {
	private ArrayList<Node> neighbors;		//list of neighbors
	private int cost;						//cost of the node
	private String name;					//name of the node
	private boolean visited;				//if the node has been visited
	
	//initializes the class
	public Node(String title, int tCost) {
		neighbors = new ArrayList<Node>();
		name = title;
		cost = tCost;
		visited = false;
	}
	
	//adds a neighbor
	public void addNeighbor(Node node) {
		neighbors.add(node);
	}

	//returns all neighbors
	public ArrayList<Node> getNeighbors() {
		return neighbors;
	}
	
	//returns visited
	public boolean getVisited() {
		return visited;
	}

	//returns the cost
	public int getCost() {
		return cost;
	}

	//returns the name of the node
	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object n) {
		boolean isNeighbors = false;
		int count = 0;
		
		if(((Node)n).getNeighbors().size() == neighbors.size()) {
			for(int i = 0; i < neighbors.size(); i++) {		//checks the neighbors of two nodes
				if(neighbors.get(i).equals(((Node)n).getNeighbors().get(i))) {
					count++;
				}
			}
		}
		if(count == neighbors.size()) {		//if the neighbors are identical
			isNeighbors = true;
		}
		
		if(((Node) n).getName().equals(name) && ((Node)n).getCost() == cost && isNeighbors) {		//if the nodes are identical
			return true;
		}
		else {
			return false;
		}
	}
}
