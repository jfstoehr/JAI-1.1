package com.jacob.periodictable;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class GuiPeriodicTableFrame extends JFrame {

	private static final long serialVersionUID = -5444048342827821476L;
	private GuiPeriodicTablePanel currentPanel;
	
	public GuiPeriodicTableFrame() {
		
		currentPanel = new GuiPeriodicTablePanel();
		setupFrame();
		
	}
	
	private void setupFrame() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\8. Images\\icon.png"));
		setTitle("JAI Periodic Table");
		
		this.setContentPane(currentPanel);
		
	}
	
	public void start() {
		
		this.setSize(1805, 1132);
		this.setVisible(true);
		
	}

}