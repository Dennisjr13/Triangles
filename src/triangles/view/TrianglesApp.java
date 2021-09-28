package triangles.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import triangles.controller.MouseHandler;
import triangles.controller.ResetController;
import triangles.controller.SwapEdgesController;
import triangles.controller.UnselectAllController;
import triangles.model.Model;

public class TrianglesApp extends JFrame {

	private JPanel contentPane;
	TrianglesDrawer panel;
	
	Model model;
	JButton btnSwapEdges, btnUnselectAll, btnReset;
	JLabel actualMoves, actualScore;
	
	public TrianglesDrawer getPuzzlePanel() { return panel; }
	public JButton getSwapEdgesButton() { return btnSwapEdges; }
	public JButton getUnselectAllButton() { return btnUnselectAll; }
	public JButton getResetButton() { return btnReset; }
	
	public JLabel getActualMovesLabel() { return actualMoves; }
	public JLabel getActualScoreLabel() { return actualScore; }
	
	/**
	 * Create the frame.
	 */
	public TrianglesApp(Model model) {
		this.model = model;
		setTitle("Triangles Application");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new TrianglesDrawer(model);
		
		// connects mouse events
		panel.addMouseListener(new MouseHandler(model, this));
		
		JButton btnSwapEdges = new JButton("Swap Edges");
		btnSwapEdges.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent event) {
				new SwapEdgesController(model, TrianglesApp.this).process();
			}
		});
		
		JButton btnUnselectAll = new JButton("Unselect All");
		btnUnselectAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent event) {
				new UnselectAllController(model, TrianglesApp.this).process();
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent event) {
				new ResetController(model, TrianglesApp.this).process();
			}
		});
		
		JLabel lblMoves = new JLabel("Moves:");
		
		JLabel lblScore = new JLabel("Score:");
		
		actualMoves = new JLabel("" + model.getNumMoves());
		
		actualScore = new JLabel("" + model.getScore());

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnUnselectAll, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSwapEdges))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMoves)
								.addComponent(lblScore))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(actualScore)
								.addComponent(actualMoves))))
					.addContainerGap(155, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMoves)
								.addComponent(actualMoves))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblScore)
								.addComponent(actualScore))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnReset)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnUnselectAll)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSwapEdges))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
