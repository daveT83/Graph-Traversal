import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
	private Node start;		//start node
	private Node end;		//goal node
	private File file;		//the file that contains the data about the node
	private int size;		//number of nodes in the graph
	private String title;	//title of the graph
	
	ArrayList<Node> allNodes;		//list of all the nodes in the graph
	
	public Graph(String fileName) {
		allNodes = new ArrayList<Node>();
		file = new File(fileName);
	}
	
	//reads in the node data from the text file
	public void buildGraph() {
		Scanner scanner;
		String[] line;
		int numNeighbors;
		
		try {
			scanner = new Scanner(file);
			
			//reads in the title
			title = scanner.nextLine();
			
			//reads in the number of nodes
			size = scanner.nextInt();
			scanner.nextLine();
			
			//reads in the the node names and their cost
			for(int i = 0; i < size; i++) {
				line = scanner.nextLine().split(" ");
				allNodes.add(new Node(line[0], Integer.parseInt(line[1])));
			}
			
			//reads in the nodes neighbors and adds them to the appropriate place
			for(int i = 0; i < size; i++) {
				line = scanner.nextLine().split(" ");
				numNeighbors = Integer.parseInt(line[1]);		//number of neighbors
				
				//adds the neighbors to the correct node
				for(int j = 0; j < numNeighbors; j++) {
					allNodes.get(i).addNeighbor(findNode(scanner.nextLine()));
				}
			}
			
			//reads in the start node
			start = findNode(scanner.nextLine());
			
			//reads in the end node
			end = findNode(scanner.nextLine());
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//finds a given node based on the title
	private Node findNode(String name) {
		Node result = new Node("",0);
		
		for(int i = 0; i < allNodes.size(); i++) {		//searches for the node
			if(allNodes.get(i).getName().equals(name)) {
				result = allNodes.get(i);
				break;
			}
		}
		return result;
	}
	
	//return the title
	public String getTitle() {
		return title;
	}
	
	//sets the title
	public void setTitle(String t) {
		title = t;
	}
	
	//return the start node
	public Node getStart() {
		return start;
	}
	
	//sets the start node
	public void setStart(Node n) {
		start = n;
	}
	
	//returns the end node
	public Node getEnd() {
		return end;
	}
	
	//sets the end node
	public void setEnd(Node n) {
		end = n;
	}
	
	//returns a given node
	public Node getNode(int i) {
		return allNodes.get(i);
	}
	
	//returns the size
	public int getSize() {
		return size;
	}
	
	//sets the size
	public void setSize(int s) {
		size = s;
	}
	
	//prints all the nodes
	public void printNodesNumNeighbors() {
		System.out.println("The tree "+title+" has the following nodes:");
		for(int i = 0; i < size; i++) {		//prints the nodes and the number of neighbors
			System.out.println(allNodes.get(i).getName()+" has "+Integer.toString(allNodes.get(i).getNeighbors().size())+" neighbors");
		}
		System.out.println("The start node is "+start.getName());		//prints the start node
		System.out.println("The end node is "+end.getName());			//prints the end node
		System.out.println();
	}
	
	//prints the nodes and their neighbors
	public void printNodesNeighbors() {
		System.out.println("Print the nodes and neighbors");
		for(int i = 0; i < size; i++) {		//prints the nodes
			System.out.println(allNodes.get(i).getName()+"'s neighbors are:");
			if(allNodes.get(i).getNeighbors().size() == 0) {		//if there are no neighbors
				System.out.println("empty");
			}
			for(int j = 0; j < allNodes.get(i).getNeighbors().size(); j++) {		//prints the neighbors
				System.out.println(allNodes.get(i).getNeighbors().get(j).getName());
			}
			System.out.println();	//adds buffer
		}
	}
	
	//prints all the nodes and their costs
	public void printNodesCost() {
		System.out.println("The tree "+title+" has the following node costs:");
		for(int i = 0; i < size; i++) {		//prints the nodes and the costs
			System.out.println(allNodes.get(i).getName()+" "+Integer.toString(allNodes.get(i).getCost()));
		}
		System.out.println();
	}
}
