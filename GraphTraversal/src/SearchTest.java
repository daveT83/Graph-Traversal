import static org.junit.Assert.*;
import org.junit.Test;

public class SearchTest {
	String fileName = "./Graphs/input.txt";
	Search test;
	Graph tree;

	//Initializes the search
	private void initSearch() {
		tree = new Graph(fileName);
		tree.buildGraph();
		test = new Search(tree,tree.getStart(),tree.getEnd());
	}
	
	@Test
	public void testInit() {
		initSearch();
		final boolean isSearch = true;		//whether the tree can be traversed
		
		assertEquals(tree,test.getTree());
		assertEquals(tree.getStart(),test.getStart());
		assertEquals(tree.getEnd(),test.getGoal());
		assertEquals(isSearch,test.isCanSearch());
		assertEquals(test.getFrontier(),tree.getNode(0).getNeighbors());
		assertEquals(test.getCurNode(),tree.getStart());
	}
	
	@Test
	public void testSetSearch() {
		initSearch();
		
		assertEquals(Search.BREADTH, test.getCurSearch());		//default 
		test.setSearch(Search.DEPTH);
		assertEquals(Search.DEPTH, test.getCurSearch());		//change to depth first search
		test.setSearch(Search.BREADTH);
		assertEquals(Search.BREADTH, test.getCurSearch());		//change to breadth first search
	}
	
	@Test 
	public void testReset() {
		initSearch();
		
		test.search();		//increment the values
		test.reset();		//resets all necessary variables
		
		assertEquals(test.getCurNode(),tree.getStart());
		assertEquals(test.getStart(),tree.getStart());
		assertEquals(test.getGoal(), tree.getEnd());
		assertEquals(test.getNumSteps(),0);
		assertEquals(test.getFrontier(),tree.getNode(0).getNeighbors());
	}
	
	@Test
	public void testSearch() {
		initSearch();
		
		assertEquals(test.search(),0);
	}
	
	@Test
	public void testEnd_StartSearch() {
		//changes the file to a case where the start node is after the goal node
		fileName = "./Graphs/end_start";
		initSearch();
		
		assertEquals(test.search(),-1);
	}
	
	@Test
	public void TestSameNodeSearch() {
		//changes the file to a case where the start and end nodes are the same
		fileName = "./Graphs/sameNode";
		initSearch();
		
		assertEquals(test.search(),0);
	}
	
	@Test
	public void testNoStartSearch() {	
		//changes the file to have a start node that doesn't exist
		fileName = "./Graphs/noStart";
		initSearch();
		
		assertEquals(test.search(),-1);
	}
	
	@Test
	public void testNoEndSearch() {
		//changes the file to have an end node that doesnt exist
		fileName = "./Graphs/noEnd";
		initSearch();
		
		assertEquals(test.search(),-1);
	}
	

}
