package triangles.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import triangles.model.Model;

public class TrianglesDrawer extends JPanel {

	Model model;
	
	/**
	 * Create the panel.
	 */
	public TrianglesDrawer(Model model) {
		this.model = model;
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		// protects when looking inside WindowBuilder
		if (model == null) {
			return;
		}
		
		// TODO: do the math and figure out WHERE to draw all the boxes (nodes), lines (edges)

		// TODO: Draw entire puzzle here
		graphics.drawString("test", 100, 100);
	}

}
