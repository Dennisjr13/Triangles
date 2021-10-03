package triangles.model;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;

public class Model {
	final int nodeSize = 20;
	TrianglePuzzle puzzle;
	boolean gameOver = false;
	int numMoves = 0;
	int score = 0;
	
	/**
	 *         0() 	
	 *      1()   2()
	 *    3()  4()  5()
	 *  6()  7()  8()  9()
	 * 
	 */
	public Model() {
		
	}
	
	public void setPuzzle(TrianglePuzzle puzzle) {
		this.puzzle = puzzle;
	}
	
	public TrianglePuzzle getPuzzle() {
		return puzzle;
	}
	
	public int getNumMoves() { return numMoves; }
	public void setNumMoves(int numMoves) { this.numMoves = numMoves; }
	
	public int getScore() { return score; }
	public void setScore(int score) { this.score = score; }
	
	public boolean isGameOver() { return gameOver; }
	public void setGameOver(boolean flag) { gameOver = flag; }
	
	public void createNodes(Dimension panelSize) {
		// create nodes, with dynamic spacing based on JPanel size
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
	}
	
	public void createEdges() {
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
	}
	
	public boolean trySwap() {
		if (isGameOver()) { 
			System.out.println("ERROR: Invalid swap. "
					+ "You've already won the game, try resetting first..");
			return false; 
		}
		
		ArrayList<Node> nodesSelected = new ArrayList<Node>();
		for (Node node : puzzle.getNodes()) {
			if (node.isSelected()) {
				nodesSelected.add(node);
			}
		}
		
		if (nodesSelected.size() != 3) {
			System.out.println("ERROR: Invalid swap. " + nodesSelected.size() + 
					" nodes selected, but must be exactly 3.");
			return false;
		}
		
		ArrayList<Edge> edgesToSwap = new ArrayList<Edge>();
		for (Edge edge : puzzle.getEdges()) {
			if (nodesSelected.containsAll(edge.getNodes())) {
				edgesToSwap.add(edge);
			}
		}
		
		if (edgesToSwap.size() == 2) {
			// 2 edge swap
			Color firstEdgeColor = edgesToSwap.get(0).getColor();
			edgesToSwap.get(0).setColor(edgesToSwap.get(1).getColor());
			edgesToSwap.get(1).setColor(firstEdgeColor);
		} else if (edgesToSwap.size() == 3) {
			// 3 edge swap, special case (rotate clockwise)
			
			// first, identify the flat edge
			Edge flatEdge = null;
			for (Edge edge : edgesToSwap) {
				if (edge.getNodes().get(0).getY() == edge.getNodes().get(1).getY()) {
					// found the flat/parallel edge
					flatEdge = edge;
				}
			}
			edgesToSwap.remove(flatEdge);
			
			// next, identify middle Node ("tip") to determine triangle orientation
			Node middleNode;
			if (flatEdge.getNodes().contains(edgesToSwap.get(0).getNodes().get(0))) {
				middleNode = edgesToSwap.get(0).getNodes().get(1);
			} else {
				middleNode = edgesToSwap.get(0).getNodes().get(0);
			}
			
			// next, identify the left/right edges 
			// (the flat edge was already removed from edgesToSwap)
			Edge leftEdge;
			Edge rightEdge;
			if (edgesToSwap.get(0).getNodes().get(0).equals(middleNode)) {
				// oops, grabbed the middle node (which both slanted edges share),
				// use the other node
				if (edgesToSwap.get(0).getNodes().get(1).getX() < middleNode.getX()) {
					leftEdge = edgesToSwap.get(0);
					rightEdge = edgesToSwap.get(1);
				} else {
					leftEdge = edgesToSwap.get(1);
					rightEdge = edgesToSwap.get(0);
				}
			} else if (edgesToSwap.get(0).getNodes().get(0).getX() < middleNode.getX()) {
				leftEdge = edgesToSwap.get(0);
				rightEdge = edgesToSwap.get(1);
			} else {
				leftEdge = edgesToSwap.get(1);
				rightEdge = edgesToSwap.get(0);
			}

			// finally, we have all the edges and can determine orientation
			// (time to swap)
			Color leftEdgeColor = leftEdge.getColor();
			Color rightEdgeColor = rightEdge.getColor();
			Color flatEdgeColor = flatEdge.getColor();
			if (middleNode.getY() > flatEdge.getNodes().get(0).getY()) {
				// upward triangle
				flatEdge.setColor(leftEdgeColor);
				rightEdge.setColor(flatEdgeColor);
				leftEdge.setColor(rightEdgeColor);
			} else {
				// downward triangle
				rightEdge.setColor(leftEdgeColor);
				flatEdge.setColor(rightEdgeColor);
				leftEdge.setColor(flatEdgeColor);
			}
		} else {
			System.out.println("ERROR: Invalid swap. " + edgesToSwap.size() +
					" common edges found, must be 2 or 3.");
			return false;
		}
		
		// swap successful
		return true;
	}
	
	public int calculateScore() {
		int calcScore = 0;

		Color t1Color = triangleColor(new int[]{0, 1, 2}); // T1
		Color t2Color = triangleColor(new int[]{1, 3, 4}); // T2
		Color t3Color = triangleColor(new int[]{2, 4, 5}); // T3
		Color t4Color = triangleColor(new int[]{3, 6, 7}); // T4
		Color t5Color = triangleColor(new int[]{4, 7, 8}); // T5
		Color t6Color = triangleColor(new int[]{5, 8, 9}); // T6
		
		ArrayList<Color> triangleColors =  new ArrayList<Color>(
				Arrays.asList(t1Color, t2Color, t3Color, t4Color, t5Color, t6Color));
		
		for (Color color : triangleColors) {
			if (color != Color.BLACK) {
				calcScore += 10;
			}
		}
		
		if (t1Color == Color.RED &&
			t2Color == Color.BLUE &&
			t3Color == Color.GREEN &&
			t4Color == Color.GREEN &&
			t5Color == Color.RED &&
			t6Color == Color.BLUE) {
			setGameOver(true);
		}

		return calcScore;
	}
	
	private Color triangleColor(int[] nodeNum) {
		ArrayList<Node> nodes = new ArrayList<Node>(Arrays.asList(
				puzzle.getNodes().get(nodeNum[0]),
			    puzzle.getNodes().get(nodeNum[1]),
			    puzzle.getNodes().get(nodeNum[2])));
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for (Edge edge : puzzle.getEdges()) {
			if (nodes.containsAll(edge.getNodes())) {
				edges.add(edge);
			}
		}
		if (edges.get(0).getColor() == edges.get(1).getColor() && 
				edges.get(1).getColor() == edges.get(2).getColor()) {
			return edges.get(0).getColor();
		}
		
		// default when triangle isn't all of [red/green/blue]
		return Color.BLACK;
	}
}
