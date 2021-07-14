import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class NodeTest {
	final String TITLE = "Test_Title";		//Title
	final int COST = 10;					//Cost
	final ArrayList<Node> NEIGHBORS = new ArrayList<Node>();	//empty array list of neighbors
	final boolean VISITED = false;			//if the node has been visited
	
	//initialize a node
	Node test = new Node(TITLE,COST);

	@Test
	public void testTitle() {
		assertEquals(test.getName(),TITLE);		//tests title
	}
	
	@Test
	public void testCost() {
		assertEquals(test.getCost(),COST);		//tests cost
	}
	
	@Test
	public void testNeighbors() {
		assertEquals(test.getNeighbors(),NEIGHBORS);		//tests neighbors
	}
	
	@Test
	public void testVisited() {
		assertEquals(test.getVisited(),VISITED);			//tests visited
	}
	
	@Test
	public void testAddNeighbor() {
		Node n1 = new Node("n1",1);
		Node n2 = new Node("n2",1);
		Node n3 = new Node("n3",1);
		
		//all stages when adding a node
		final ArrayList<Node> N1 = new ArrayList<Node>(Arrays.asList(n1));
		final ArrayList<Node> N2 = new ArrayList<Node>(Arrays.asList(n1,n2));
		final ArrayList<Node> N3 = new ArrayList<Node>(Arrays.asList(n1,n2,n3));
		
		//tests adding neighbors
		Node test = new Node("test",0);
		
		test.addNeighbor(n1);
		assertEquals(N1,test.getNeighbors());
		
		test.addNeighbor(n2);
		assertEquals(N2,test.getNeighbors());
		
		test.addNeighbor(n3);
		assertEquals(N3,test.getNeighbors());
	}
	
	@Test
	public void testEquals() {
		Node n1 = new Node("n1",1);
		Node n2 = new Node("n2",1);
		Node n3 = new Node("n3",1);
		
		Node m1 = new Node("n1",1);
		Node m2 = new Node("n2",1);
		Node m3 = new Node("n3",1);
		
		assertEquals(n1,m1);
		assertEquals(n2,m2);
		assertEquals(n3,m3);
		
	}

}
