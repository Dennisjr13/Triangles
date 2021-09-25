package triangles.controller;

import triangles.model.Model;
import triangles.view.TrianglesApp;

public class SwapEdgesController {
	
	TrianglesApp app;
	Model model;
	
	public SwapEdgesController(Model model, TrianglesApp app) {
		this.model = model;
		this.app = app;
	}
	
	public void process() {
		// TODO: implement swap edges logic here
		System.out.println("You clicked Swap Edges!");
	}
}
