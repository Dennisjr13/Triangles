package triangles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

import triangles.controller.ExitController;
import triangles.model.Edge;
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
		
		// create nodes, with dynamic spacing based on JPanel size
		Dimension panelSize = trianglesApp.getPuzzlePanel().getSize();
		puzzle.addNode(new Node(nodeSize, // Node0
				4*(panelSize.width/8) - (nodeSize/2), 
				1*(panelSize.height/5) - (nodeSize/2)));
		
		puzzle.addNode(new Node(nodeSize, // Node1
				3*(panelSize.width/8) - (nodeSize/2), 
				2*(panelSize.height/5) - (nodeSize/2)));
		
		puzzle.addNode(new Node(nodeSize, // Node2
				5*(panelSize.width/8) - (nodeSize/2), 
				2*(panelSize.height/5) - (nodeSize/2)));
		
		puzzle.addNode(new Node(nodeSize, // Node3
				2*(panelSize.width/8) - (nodeSize/2), 
				3*(panelSize.height/5) - (nodeSize/2)));
		
		puzzle.addNode(new Node(nodeSize, // Node4
				4*(panelSize.width/8) - (nodeSize/2), 
				3*(panelSize.height/5) - (nodeSize/2)));
		
		puzzle.addNode(new Node(nodeSize, // Node5
				6*(panelSize.width/8) - (nodeSize/2),
				3*(panelSize.height/5) - (nodeSize/2)));

		puzzle.addNode(new Node(nodeSize, // Node6
				1*(panelSize.width/8) - (nodeSize/2), 
				4*(panelSize.height/5) - (nodeSize/2)));
		
		puzzle.addNode(new Node(nodeSize, // Node7
				3*(panelSize.width/8) - (nodeSize/2), 
				4*(panelSize.height/5) - (nodeSize/2)));
		
		puzzle.addNode(new Node(nodeSize, // Node8
				5*(panelSize.width/8) - (nodeSize/2),
				4*(panelSize.height/5) - (nodeSize/2)));
	
		puzzle.addNode(new Node(nodeSize, // Node9
				7*(panelSize.width/8) - (nodeSize/2),
				4*(panelSize.height/5) - (nodeSize/2)));
		
		//  set adjNodes
		puzzle.getNodes().get(0).addAdjNode(puzzle.getNodes().get(1));
		puzzle.getNodes().get(0).addAdjNode(puzzle.getNodes().get(2));
		
		puzzle.getNodes().get(1).addAdjNode(puzzle.getNodes().get(0));
		puzzle.getNodes().get(1).addAdjNode(puzzle.getNodes().get(2));
		puzzle.getNodes().get(1).addAdjNode(puzzle.getNodes().get(3));
		puzzle.getNodes().get(1).addAdjNode(puzzle.getNodes().get(4));
		
		puzzle.getNodes().get(2).addAdjNode(puzzle.getNodes().get(0));
		puzzle.getNodes().get(2).addAdjNode(puzzle.getNodes().get(1));
		puzzle.getNodes().get(2).addAdjNode(puzzle.getNodes().get(4));
		puzzle.getNodes().get(2).addAdjNode(puzzle.getNodes().get(5));
		
		puzzle.getNodes().get(3).addAdjNode(puzzle.getNodes().get(1));
		puzzle.getNodes().get(3).addAdjNode(puzzle.getNodes().get(4));
		puzzle.getNodes().get(3).addAdjNode(puzzle.getNodes().get(6));
		puzzle.getNodes().get(3).addAdjNode(puzzle.getNodes().get(7));
		
		puzzle.getNodes().get(4).addAdjNode(puzzle.getNodes().get(1));
		puzzle.getNodes().get(4).addAdjNode(puzzle.getNodes().get(2));
		puzzle.getNodes().get(4).addAdjNode(puzzle.getNodes().get(3));
		puzzle.getNodes().get(4).addAdjNode(puzzle.getNodes().get(5));
		puzzle.getNodes().get(4).addAdjNode(puzzle.getNodes().get(7));
		puzzle.getNodes().get(4).addAdjNode(puzzle.getNodes().get(8));
		
		puzzle.getNodes().get(5).addAdjNode(puzzle.getNodes().get(2));
		puzzle.getNodes().get(5).addAdjNode(puzzle.getNodes().get(4));
		puzzle.getNodes().get(5).addAdjNode(puzzle.getNodes().get(8));
		puzzle.getNodes().get(5).addAdjNode(puzzle.getNodes().get(9));
		
		puzzle.getNodes().get(6).addAdjNode(puzzle.getNodes().get(3));
		puzzle.getNodes().get(6).addAdjNode(puzzle.getNodes().get(7));
		
		puzzle.getNodes().get(7).addAdjNode(puzzle.getNodes().get(3));
		puzzle.getNodes().get(7).addAdjNode(puzzle.getNodes().get(4));
		puzzle.getNodes().get(7).addAdjNode(puzzle.getNodes().get(6));
		puzzle.getNodes().get(7).addAdjNode(puzzle.getNodes().get(8));
		
		puzzle.getNodes().get(8).addAdjNode(puzzle.getNodes().get(4));
		puzzle.getNodes().get(8).addAdjNode(puzzle.getNodes().get(5));
		puzzle.getNodes().get(8).addAdjNode(puzzle.getNodes().get(7));
		puzzle.getNodes().get(8).addAdjNode(puzzle.getNodes().get(9));
		
		puzzle.getNodes().get(9).addAdjNode(puzzle.getNodes().get(5));
		puzzle.getNodes().get(9).addAdjNode(puzzle.getNodes().get(8));
		
		// create edges
		puzzle.addEdge(new Edge(Color.RED, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(6), 
						puzzle.getNodes().get(3)))));

		puzzle.addEdge(new Edge(Color.RED, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(3), 
						puzzle.getNodes().get(1)))));
		
		puzzle.addEdge(new Edge(Color.RED, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(1), 
						puzzle.getNodes().get(0)))));
		
		puzzle.addEdge(new Edge(Color.RED, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(0), 
						puzzle.getNodes().get(2)))));
		
		puzzle.addEdge(new Edge(Color.RED, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(2), 
						puzzle.getNodes().get(5)))));
		
		puzzle.addEdge(new Edge(Color.RED, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(5), 
						puzzle.getNodes().get(9)))));
		
		puzzle.addEdge(new Edge(Color.GREEN, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(6), 
						puzzle.getNodes().get(7)))));
		
		puzzle.addEdge(new Edge(Color.GREEN, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(7), 
						puzzle.getNodes().get(8)))));
		
		puzzle.addEdge(new Edge(Color.GREEN, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(8), 
						puzzle.getNodes().get(9)))));
		
		puzzle.addEdge(new Edge(Color.GREEN, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(3), 
						puzzle.getNodes().get(4)))));
		
		puzzle.addEdge(new Edge(Color.GREEN, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(4), 
						puzzle.getNodes().get(5)))));
		
		puzzle.addEdge(new Edge(Color.GREEN, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(1), 
						puzzle.getNodes().get(2)))));
		
		puzzle.addEdge(new Edge(Color.BLUE, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(3), 
						puzzle.getNodes().get(7)))));
		
		puzzle.addEdge(new Edge(Color.BLUE, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(7), 
						puzzle.getNodes().get(4)))));
		
		puzzle.addEdge(new Edge(Color.BLUE, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(4), 
						puzzle.getNodes().get(8)))));
		
		puzzle.addEdge(new Edge(Color.BLUE, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(8), 
						puzzle.getNodes().get(5)))));
		
		puzzle.addEdge(new Edge(Color.BLUE, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(1), 
						puzzle.getNodes().get(4)))));
		
		puzzle.addEdge(new Edge(Color.BLUE, 
				new ArrayList<>(Arrays.asList(
						puzzle.getNodes().get(4), 
						puzzle.getNodes().get(2)))));
		
		trianglesApp.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				new ExitController(trianglesApp).exit();
			}
		});
	}
}
