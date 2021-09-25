package triangles.controller;

import triangles.model.Model;
import triangles.view.TrianglesApp;

public class ResetController {
	
	TrianglesApp app;
	Model model;
	
	public ResetController(Model model, TrianglesApp app) {
		this.model = model;
		this.app = app;
	}
	
	public void process() {
		// TODO: implement reset logic here
		System.out.println("You clicked Reset!");
	}
}
