package triangles.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import triangles.model.Coordinate;
import triangles.model.Edge;
import triangles.model.Model;
import triangles.model.Node;
import triangles.model.TrianglePuzzle;

public class TrianglesDrawer extends JPanel {

	Model model;
	
	/**
	 * Create the panel.
	 */
	public TrianglesDrawer(Model model) {
		this.model = model;
	}
	
	public Dimension getPanelSize() { return getSize(); }
	
	public Coordinate pointToCoordinate(Point point) {
		return new Coordinate(point.x, point.y);
	}
	
	
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		// protects when looking inside WindowBuilder
		if (model == null) {
			return;
		}
		
		graphics.drawString("test", 10, 10);
		
		// TODO: Draw entire puzzle here
		TrianglePuzzle puzzle = model.getPuzzle();

		// draw edges first
		for (Edge edge : puzzle.getEdges()) {
			// set start/end of Edge to middle of each Node
			graphics.setColor(edge.getColor());
			graphics.drawLine(
					edge.getNodes().get(0).getX() + edge.getNodes().get(0).getSize()/2,
					edge.getNodes().get(0).getY() + edge.getNodes().get(0).getSize()/2,
					edge.getNodes().get(1).getX() + edge.getNodes().get(0).getSize()/2,
					edge.getNodes().get(1).getY() + edge.getNodes().get(0).getSize()/2);
		}
		
		// draw nodes over the edges
		for (Node node : puzzle.getNodes()) {
			if (node.isSelected()) {
				graphics.setColor(Color.BLACK);
			} else {
				graphics.setColor(Color.WHITE);
			}
			
			graphics.fillRect(
					node.getX(), 
					node.getY(), 
					node.getSize(), 
					node.getSize());
		}
	}
}
