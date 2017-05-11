package Menu_Toolbar;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame extends JFrame {
	private Panel myPanel;
	private Dimension dimension;
	
	public Frame() {
		
		dimension = new Dimension();
		myPanel = new Panel();
	}
	
	public void init() {
		dimension.height = 500;
		dimension.width = 500;
		this.setSize(dimension);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.add(myPanel);
	}
}
