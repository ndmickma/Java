//Sanvitti Shah
//AccessibilityRunner.java


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AccessibilityRunner
{
	public AccessibilityRunner(){}
	public static void main(String [] args)
	{
		AcessibilityRunner ar = new AccessibilityRunner();
		ar.run();
	}
	
	public void run()
	{
		JFrame frame = new JFrame(AccessibilityRunner);
		frame.setSize(1000,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(0,0);
		frame.setResizeable(false);
		Accessibility pan = new Accessibility();
		frame.getContentPane().add(pan);
	}
}

class Accessibility extends JPanel implements MouseListener, KeyListener
{
	private Color backgroundColor;
	private int fontSize;
	private int colorParameterVar;
	public Accessibility()
	{
		colorParameterVar = 100;
		backgroundColor = new Color(colorParameterVar, colorParameterVar, colorParameterVar);
		setBackground(backgroundColor);
		fontSize = 12;
		addMouseListener(this);
		addKeyListener(this);
	}
	
	public void drawRectanglesWithLabels(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(10,10,100,20);
		g.fillRect(115,10,100,20);
		g.setColor(Color.BLACK);
		g.drawString("brighter", 15, 80);
		g.drawString("darker", 115, 80);
	}
	public void writeDirections(Graphics g) 
	{
        g.drawString("Press mouse on the panel. To increase the font size, press the UP arrow. " +
			"To decrease the font size, press the DOWN arrow. " +
            "To make the screen brighter, click the box labelled brighter " +
            "To make the screen darker, click the box labelled darker", 50, 300);
    }
    
    public void paintComponent(Graphics g)
    {
		
	}
}
