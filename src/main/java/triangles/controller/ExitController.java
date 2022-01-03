package triangles.controller;

import javax.swing.JOptionPane;

import triangles.view.TrianglesApp;

public class ExitController {
	TrianglesApp app;
	
	public ExitController(TrianglesApp app) {
		this.app = app;
	}

	public void exit() {
		int c = JOptionPane.showConfirmDialog(app, "Do you wish to exit application?");
		if (c == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}
	
}
