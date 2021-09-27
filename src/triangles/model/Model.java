package triangles.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Model {
	TrianglePuzzle puzzle;
	boolean gameOver;
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
	
	public int calculateScore() {
		boolean allCorrectColors = true;
		int calcScore = 0;

		Color t1Color = triangleColor(new int[]{0, 1, 2}); // T1
		if (t1Color != Color.BLACK) {
			calcScore += 10;
			if (t1Color != Color.RED) {
				allCorrectColors = false;
			}
		}
		
		Color t2Color = triangleColor(new int[]{1, 3, 4}); // T2
		if (t2Color != Color.BLACK) {
			calcScore += 10;
			if (t2Color != Color.BLUE) {
				allCorrectColors = false;
			}
		}
		
		Color t3Color = triangleColor(new int[]{2, 4, 5}); // T3
		if (t3Color != Color.BLACK) {
			calcScore += 10;
			if (t3Color != Color.GREEN) {
				allCorrectColors = false;
			}
		}
		
		Color t4Color = triangleColor(new int[]{3, 6, 7}); // T4
		if (t4Color != Color.BLACK) {
			calcScore += 10;
			if (t4Color != Color.GREEN) {
				allCorrectColors = false;
			}
		}
		
		Color t5Color = triangleColor(new int[]{4, 7, 8}); // T5
		if (t5Color != Color.BLACK) {
			calcScore += 10;
			if (t5Color != Color.RED) {
				allCorrectColors = false;
			}
		}
		
		Color t6Color = triangleColor(new int[]{5, 8, 9}); // T6
		if (t6Color != Color.BLACK) {
			calcScore += 10;
			if (t6Color != Color.BLUE) {
				allCorrectColors = false;
			}
		}
		
		if (allCorrectColors) {
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
