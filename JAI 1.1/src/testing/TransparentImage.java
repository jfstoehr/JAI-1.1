package testing;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.event.*;
 
public class TransparentImage extends JPanel
{
    
	private static final long serialVersionUID = 1L;
	private BufferedImage backImage, frontImage;
    private float alpha = 1;
 
    public TransparentImage()
    {
        try
        {
            backImage = ImageIO.read(new File("J:\\1. WITPOL\\2. Projects\\OS MARK 1\\1. Periodic Table\\Elements\\1.png") );
            frontImage = ImageIO.read(new File("J:\\1. WITPOL\\2. Projects\\OS MARK 1\\1. Periodic Table\\Elements\\2.png") );
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
 
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(backImage.getWidth(), backImage.getHeight());
    }
 
    public void setAlpha(float alpha)
    {
        this.alpha = alpha;
        repaint();
    }
 
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
 
        //  Paint background image
 
        Graphics2D g2 = (Graphics2D) g;
        int x = (getWidth() - backImage.getWidth())/2;
        int y = (getHeight()- backImage.getHeight())/2;
        g2.drawRenderedImage(backImage, AffineTransform.getTranslateInstance(x, y));
 
        //  Paint foreground image with appropriate alpha value
 
        Composite old = g2.getComposite();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        x = (getWidth() - frontImage.getWidth())/2;
        y = (getHeight()- frontImage.getHeight())/2;
        g2.drawRenderedImage(frontImage, AffineTransform.getTranslateInstance(x, y));
        g2.setComposite(old);
    }
 
    private static void createAndShowUI()
    {
        final TransparentImage app = new TransparentImage();
 
        JSlider slider = new JSlider();
        slider.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                JSlider source = (JSlider) e.getSource();
                app.setAlpha(source.getValue()/100f);
            }
        });
        slider.setValue(100);
 
        JFrame frame = new JFrame("Transparent Image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( app );
        frame.add(slider, BorderLayout.SOUTH);
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }
 
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}