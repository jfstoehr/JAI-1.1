package com.jacob.gui;

import javax.swing.JFrame;

import java.awt.Toolkit;

public class GuiFrame extends JFrame {
	
	private static final long serialVersionUID = 7938243520811222154L;
	private GuiPanel currentPanel;
	private GuiRunningNOON noonPanel;
	private GuiRunningELLIS ellisPanel;
	
	public GuiFrame() {
		
		currentPanel = new GuiPanel(this);
		noonPanel = new GuiRunningNOON(this);
		ellisPanel = new GuiRunningELLIS(this);
		setupFrame();
		
	}
	
	private void setupFrame() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\8. Images\\icon.png"));
		setTitle("JAI Terminal");
		this.setContentPane(currentPanel);
		
	}
	
	public void start() {
		
		this.setSize(460, 344);
		this.setVisible(true);
		
	}
	
	public void runNOON() {
		
		this.currentPanel.setVisible(false);
		this.ellisPanel.setVisible(false);
		this.setContentPane(noonPanel);
		this.noonPanel.setVisible(true);
		
	}
	
	public void runELLIS() {
		
		this.currentPanel.setVisible(false);
		this.noonPanel.setVisible(false);
		this.setContentPane(ellisPanel);
		this.ellisPanel.setVisible(true);
		
	}
	
	public void resetApplication() {
		
		this.noonPanel.setVisible(false);
		this.ellisPanel.setVisible(false);
		this.setContentPane(currentPanel);
		this.currentPanel.setVisible(true);
		
	}

}