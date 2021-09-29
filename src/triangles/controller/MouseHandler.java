package triangles.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import triangles.model.Coordinate;
import triangles.model.Model;
import triangles.model.Node;
import triangles.model.TrianglePuzzle;
import triangles.view.TrianglesApp;

public class MouseHandler extends MouseAdapter {
	
	TrianglesApp app;
	Model model;
	
	public MouseHandler(Model model, TrianglesApp app) {
		this.model = model;
		this.app = app;
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
		Coordinate coord = app.getPuzzlePanel().pointToCoordinate(event.getPoint());
		TrianglePuzzle puzzle = model.getPuzzle();
		
		if (model.isGameOver()) { 
			System.out.println("ERROR: Invalid select. "
					+ "You've already won the game, try resetting first..");
			return; 
		}
		
		for (Node node : puzzle.getNodes()) {
			if (node.contains(coord)) {
				if (node.isSelected()) {
					node.setSelected(false);
				} else {
					node.setSelected(true);
				}
				app.repaint();
			}
		}
	}
}
