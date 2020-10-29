package com.jacob.periodictable.v2;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiPeriodicTableBottomPanel extends JPanel {

	private static final long serialVersionUID = -4051546297395443217L;
	
	public GuiPeriodicTableBottomPanel() {
		
		setupPanel();
		
	}
	
	public void setupPanel() {
		
		setLayout(null);
		setBackground(new Color(255, 255, 255, 50));
		
		JLabel lbl1 = new JLabel("");
		lbl1.setBounds(10, 57, 60, 69);
		lbl1.setIcon(new ImageIcon("J:\\1. WITPOL\\2. Projects\\OS MARK 1\\1. Periodic Table\\NewElements6\\elementbackground3.png"));
		add(lbl1);
		
		JLabel lbl2 = new JLabel("");
		lbl2.setBounds(80, 57, 60, 69);
		lbl2.setIcon(new ImageIcon("J:\\1. WITPOL\\2. Projects\\OS MARK 1\\1. Periodic Table\\NewElements6\\plussign.png"));
		add(lbl2);
		
		JLabel lbl3 = new JLabel("");
		lbl3.setBounds(150, 57, 60, 69);
		lbl3.setIcon(new ImageIcon("J:\\1. WITPOL\\2. Projects\\OS MARK 1\\1. Periodic Table\\NewElements6\\elementbackground3.png"));
		add(lbl3);
		
		JLabel lbl4 = new JLabel("");
		lbl4.setBounds(220, 57, 60, 69);
		add(lbl4);
		
		JLabel lbl5 = new JLabel("");
		lbl5.setBounds(290, 57, 60, 69);
		add(lbl5);
		
		JLabel lbl6 = new JLabel("");
		lbl6.setBounds(360, 57, 60, 69);
		add(lbl6);
		
		JLabel lbl7 = new JLabel("");
		lbl7.setBounds(430, 57, 60, 69);
		add(lbl7);
		
		JLabel lbl8 = new JLabel("");
		lbl8.setBounds(500, 57, 60, 69);
		add(lbl8);
		
		JLabel lbl9 = new JLabel("");
		lbl9.setBounds(570, 57, 60, 69);
		add(lbl9);
		
		JLabel lbl10 = new JLabel("");
		lbl10.setBounds(640, 57, 60, 69);
		add(lbl10);
		
	}
	
}