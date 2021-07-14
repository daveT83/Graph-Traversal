import java.util.ArrayList;

public class BreadthFirstSearch {
	private Graph tree;					//tree to be searched
	private Node start;					//start node
	private Node goal;					//end node
	private Node curNode;				// current node
	private boolean canSearch;			//if the start and goal nodes exist
	private ArrayList<Node> frontier;	//the next nodes to visit (FIFO)
	private int numSteps;				//number of steps to reach the goal
	
	//initializes BreadthFirstSearch
	public BreadthFirstSearch(Graph t,Node s,Node g) {
		boolean isStart = false;
		boolean isGoal = false;
		
		tree = t;
		start = s;
		goal = g;
		canSearch = false;
		frontier = new ArrayList<Node>();
		curNode = s;
		for(int i = 0; i < curNode.getNeighbors().size(); i ++) {		//adds neighbors to the frontier
			add(curNode.getNeighbors().get(i));
		}
		numSteps = 0;
		
		
		//checks if the start and goal nodes are in the tree
		for(int i = 0; i < tree.getSize(); i++) {
			if(tree.getNode(i).equals(start)) {			//if start node is valid
				isStart = true;
			}
			else if(tree.getNode(i).equals(goal)) {		//if goal node is valid
				isGoal = true;
			}
			
			if(isStart && isGoal) {
				canSearch = true;
				
				break;
			}			
		}
	}
	
	//performs the search
	public int search() {
		if(canSearch){		//if the search can be performed	
			System.out.println("The current node being explored is: "+curNode.getName());		//prints node being explored

			//if the goal is not reached
			if(!curNode.equals(goal)) {
				System.out.print("The frontier contains:");
				for(int i = 0; i < frontier.size(); i++) {	//prints the frontier
					System.out.print(" "+frontier.get(i).getName());
				}
				System.out.println("\n\n");		//adds buffer
				
				curNode = frontier.get(0);		//updates current node
				rem();		//removes the first node in the frontier
				
				for(int i = 0; i < curNode.getNeighbors().size(); i ++) {		//adds neighbors to the frontier
					add(curNode.getNeighbors().get(i));
				}
				
				numSteps++;
				search();		//search again
			}
			else {
				System.out.println("The goal was found in "+numSteps+" steps");
				return 0;
			}
		}
		
		return -1;		//if either the start of the goal node isn't in the tree
	}
	
	//adds a node to the frontier
	private void add(Node n) {
		frontier.add(n);
	}
	
	//removes the first node in the frontier
	private void rem() {
		frontier.remove(0);
	}
}
