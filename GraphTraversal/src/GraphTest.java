import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {
	final private String LOC = "./Graphs/input.txt";		//file name
	private	Graph test = new Graph(LOC);
	
	@Test
	public void testTitle() {
		test.buildGraph();
		final String TITLE = "Test_Tree_01";
		assertEquals(TITLE,test.getTitle());
	}
	
	@Test
	public void testSize() {
		test.buildGraph();
		final int SIZE = 11;
		assertEquals(SIZE, test.getSize());
	}
	
	@Test 
	public void testNodes() {
		test.buildGraph();

		//nodes that should be loaded in
		Node n1 = new Node("Node_01",1);
		Node n2 = new Node("Node_02",1);
		Node n3 = new Node("Node_03",1);
		Node n4 = new Node("Node_04",1);
		Node n5 = new Node("Node_05",1);
		Node n6 = new Node("Node_06",1);
		Node n7 = new Node("Node_07",1);
		Node n8 = new Node("Node_08",1);
		Node n9 = new Node("Node_09",1);
		Node n10 = new Node("Node_10",1);
		Node n11 = new Node("Node_11",1);
				
		//adds neighbors to nodes
		n1.addNeighbor(n2);
		n1.addNeighbor(n3);
		n2.addNeighbor(n4);
		n3.addNeighbor(n7);
		n3.addNeighbor(n8);
		n4.addNeighbor(n5);
		n4.addNeighbor(n6);
		n7.addNeighbor(n9);
		n8.addNeighbor(n10);
		n8.addNeighbor(n11);
		
		//checks nodes
		assertEquals(n1,test.getNode(0));
		assertEquals(n2,test.getNode(1));
		assertEquals(n3,test.getNode(2));
		assertEquals(n4,test.getNode(3));
		assertEquals(n5,test.getNode(4));
		assertEquals(n6,test.getNode(5));
		assertEquals(n7,test.getNode(6));
		assertEquals(n8,test.getNode(7));
		assertEquals(n9,test.getNode(8));
		assertEquals(n10,test.getNode(9));
		assertEquals(n11,test.getNode(10));
	}
		
	@Test
	public void testStart() {
		final Node s = new Node("Node_01",1);
		test.buildGraph();

		//checks start node
		assertEquals(s,test.getNode(0));
	}
	
	@Test
	public void testEnd() {
		final Node e = new Node("Node_11",1);
		test.buildGraph();

		//checks end node
		assertEquals(e,test.getNode(10));
	}
}
