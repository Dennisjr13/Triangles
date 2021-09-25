package triangles.controller;

import triangles.model.Model;
import triangles.view.TrianglesApp;

public class UnselectAllController {
	
	TrianglesApp app;
	Model model;
	
	public UnselectAllController(Model model, TrianglesApp app) {
		this.model = model;
		this.app = app;
	}
	
	public void process() {
		// TODO: implement unselect all logic here
		System.out.println("You clicked Unselect All!");
	}
}
