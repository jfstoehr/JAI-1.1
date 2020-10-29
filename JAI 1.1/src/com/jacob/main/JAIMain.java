package com.jacob.main;

import javax.swing.JOptionPane;

import com.jacob.gui.GuiFrame;

public class JAIMain {
	
	public static void main(String[] args) {
		
		GuiFrame g = new GuiFrame();
		g.start();
		
		g.addWindowListener(new java.awt.event.WindowAdapter() {
			
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	
		        if (JOptionPane.showConfirmDialog(g, "Are you sure you want to close this window?", "Close JAI Terminal?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        	
		        	System.out.println("Application terminated.");
		            System.exit(0);
		            
		        }
		        
		    }
		    
		});
		
	}
	
}