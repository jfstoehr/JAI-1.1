package testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.jacob.periodictable.v2.GuiPeriodicTableBottomPanel;
import com.jacob.periodictable.v2.GuiPeriodicTablePanel;

public class GuiTesting extends JFrame {
	
	private static final long serialVersionUID = -2889071416664578527L;
	private GuiPeriodicTablePanel currentPanel;
	private GuiPeriodicTableBottomPanel bottomPanel;
	
	public GuiTesting(int type, String title) {
		
		super(title);
		
		if (type == 1) {
			
			setBackground(new Color(0,0,0,0));
			setSize(new Dimension(1286, 845));
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			currentPanel = new GuiPeriodicTablePanel() {
				
				private static final long serialVersionUID = 7548209929965394584L;
				
				@Override
				protected void paintComponent(Graphics g) {
					
					if (g instanceof Graphics2D) {
						
						final int R = 0;
						final int G = 0;
						final int B = 0;
						
						Paint p = new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 150), 0.0f, getHeight(), new Color(R, G, B, 150 ), true);
						Graphics2D g2d = (Graphics2D)g;
						g2d.setPaint(p);
						g2d.fillRect(0, 0, getWidth(), getHeight());
						
					}
					
				}
				
			};
			
			setContentPane(currentPanel);
			setLayout(null);
			
		} else if (type == 2) {
			
			setBackground(new Color(0,0,0,0));
			setSize(new Dimension(1286, 190));
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			bottomPanel = new GuiPeriodicTableBottomPanel() {
				
				private static final long serialVersionUID = 7548209929965394584L;
				
				@Override
				protected void paintComponent(Graphics g) {
					
					if (g instanceof Graphics2D) {
						
						final int R = 0;
						final int G = 0;
						final int B = 0;
						
						Paint p = new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 150), 0.0f, getHeight(), new Color(R, G, B, 150 ), true);
						Graphics2D g2d = (Graphics2D)g;
						g2d.setPaint(p);
						g2d.fillRect(0, 0, getWidth(), getHeight());
						
					}
					
				}
				
			};
			
			setContentPane(bottomPanel);
			setLayout(null);
			
		}
		
	}

	public static void launch(int type, String title) {

		JFrame.setDefaultLookAndFeelDecorated(true);

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				GuiTesting gtw = new GuiTesting(type, title);
				gtw.setVisible(true);
				
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		
		launch(1, "Periodic Volume");
		launch(2, "Periodic Analysis");
		
	}
	
}