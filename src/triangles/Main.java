package triangles;

import java.awt.Dimension;

import triangles.model.Model;
import triangles.model.Node;
import triangles.model.TrianglePuzzle;
import triangles.view.TrianglesApp;

public class Main {
	
	public static void main(String[] args) {
		final int nodeSize = 20;
		
		Model model = new Model();
		
		TrianglePuzzle puzzle = new TrianglePuzzle();
		
		model.setPuzzle(puzzle);
		
		TrianglesApp trianglesApp = new TrianglesApp(model);
		trianglesApp.setVisible(true);
		
		/**
		 *         0() 	
		 *      1()   2()
		 *    3()  4()  5()
		 *  6()  7()  8()  9()
		 * 
		 */
		// create all nodes here, dynamic spacing based on JPanel size
		Dimension panelSize = trianglesApp.getPuzzlePanel().getSize();
		puzzle.addNode(new Node(nodeSize), // Node0
				4*(panelSize.width/8) - (nodeSize/2), 
				1*(panelSize.height/5) - (nodeSize/2));
		
		puzzle.addNode(new Node(nodeSize), // Node1
				3*(panelSize.width/8) - (nodeSize/2), 
				2*(panelSize.height/5) - (nodeSize/2));
		
		puzzle.addNode(new Node(nodeSize), // Node2
				5*(panelSize.width/8) - (nodeSize/2), 
				2*(panelSize.height/5) - (nodeSize/2));
		
		puzzle.addNode(new Node(nodeSize), // Node3
				2*(panelSize.width/8) - (nodeSize/2), 
				3*(panelSize.height/5) - (nodeSize/2));
		
		puzzle.addNode(new Node(nodeSize), // Node4
				4*(panelSize.width/8) - (nodeSize/2), 
				3*(panelSize.height/5) - (nodeSize/2));
		
		puzzle.addNode(new Node(nodeSize), // Node5
				6*(panelSize.width/8) - (nodeSize/2),
				3*(panelSize.height/5) - (nodeSize/2));

		puzzle.addNode(new Node(nodeSize), // Node6
				1*(panelSize.width/8) - (nodeSize/2), 
				4*(panelSize.height/5) - (nodeSize/2));
		
		puzzle.addNode(new Node(nodeSize), // Node7
				3*(panelSize.width/8) - (nodeSize/2), 
				4*(panelSize.height/5) - (nodeSize/2));
		
		puzzle.addNode(new Node(nodeSize), // Node8
				5*(panelSize.width/8) - (nodeSize/2),
				4*(panelSize.height/5) - (nodeSize/2));
	
		puzzle.addNode(new Node(nodeSize), // Node9
				7*(panelSize.width/8) - (nodeSize/2),
				4*(panelSize.height/5) - (nodeSize/2));
		
		// TODO: set adjNodes here
	}
}
