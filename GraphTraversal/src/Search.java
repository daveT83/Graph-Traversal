import java.util.ArrayList;

public class Search {
	public final static int BREADTH = 0;		//Breadth first search (FIFO)
	public final static int DEPTH = 1;			//Depth first search (LIFO)
	
	private int curSearch;				//the current search to perform
	private Graph tree;					//tree to be searched
	private Node start;					//start node
	private Node goal;					//end node
	private Node curNode;				// current node
	private boolean canSearch;			//if the start and goal nodes exist
	private ArrayList<Node> frontier;	//the next nodes to visit
	private int numSteps;				//number of steps to reach the goal
	
	//initializes BreadthFirstSearch
	public Search(Graph t,Node s,Node g) {
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
		curSearch = BREADTH;
		
		
		//checks if the start and goal nodes are in the tree
		for(int i = 0; i < tree.getSize(); i++) {
			if(tree.getNode(i).equals(start)) {			//if start node is valid
				isStart = true;
			}
			if(tree.getNode(i).equals(goal)) {			//if goal node is valid
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
		int found = 0;		//return value 0-solution was found -1-solution was not found
		
		if(canSearch){		//if the search can be performed			
			System.out.println("The current node being explored is: "+curNode.getName());		//prints node being explored

			//if the goal is not reached
			if(!curNode.equals(goal) && frontier.size() > 0) {
				System.out.print("The frontier contains:");
				for(int i = 0; i < frontier.size(); i++) {	//prints the frontier
					System.out.print(" "+frontier.get(i).getName());
				}
				System.out.println("\n\n");		//adds buffer
				
				curNode = frontier.get(0);		//updates current node
				rem();		//removes the correct node in the frontier
				
				for(int i = 0; i < curNode.getNeighbors().size(); i ++) {		//adds neighbors to the frontier
					add(curNode.getNeighbors().get(i));
				}
				
				numSteps++;
				search();		//search again
			}
			else if(!curNode.equals(goal) && frontier.size() == 0){		//if there's no more elements in the frontier 
				found =  -1;											//and the goal wasn't reached
			}
			else {	//if the goal was found
				System.out.println("The goal was found in "+numSteps+" steps");
			}
		}
		else {
			found = -1;
		}
		
		return found;		//if either the start of the goal node isn't in the tree
	}
	
	//adds a node to the frontier
	private void add(Node n) {
		frontier.add(n);
	}
	
	//removes the first node in the frontier
	private void rem() {
		frontier.remove(0);
	}
	
	//sets the current search algorithm
	public void setSearch(int x) {
		curSearch = x;
	}
	
	//resets the search
	public void reset() {
		curNode = start;
		numSteps = 0;
		frontier = new ArrayList<Node>();
		for(int i = 0; i < curNode.getNeighbors().size(); i ++) {		//adds neighbors to the frontier
			add(curNode.getNeighbors().get(i));
		}
	}

	//returns the current search
	public int getCurSearch() {
		return curSearch;
	}

	//returns the tree
	public Graph getTree() {
		return tree;
	}

	//returns the start node
	public Node getStart() {
		return start;
	}

	//returns goal node
	public Node getGoal() {
		return goal;
	}

	//returns current node
	public Node getCurNode() {
		return curNode;
	}

	//return if the start and end nodes are in the tree
	public boolean isCanSearch() {
		return canSearch;
	}

	//return the frontier
	public ArrayList<Node> getFrontier() {
		return frontier;
	}

	//returns the number of steps taken to get to a given node
	public int getNumSteps() {
		return numSteps;
	}
}
