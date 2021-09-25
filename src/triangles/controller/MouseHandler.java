package triangles.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import triangles.model.Model;
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
		// TODO: implement Node selection logic here
		System.out.println("You pressed on " + event.getPoint());
	}
}
