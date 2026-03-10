//Sanvitti Shah
//AccessibilityRunner.java


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
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
		AccessibilityRunner ar = new AccessibilityRunner();
		ar.run();
	}
	
	public void run()
	{
		JFrame frame = new JFrame("AccessibilityRunner");
		frame.setSize(1000,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(0,0);
		frame.setResizable(false);
		Accessibility pan = new Accessibility();
		frame.getContentPane().add(pan);
		frame.setVisible(true);
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
		super.paintComponent(g);
		drawRectanglesWithLabels(g);
		g.setColor(Color.BLACK);
		Font font = new Font("Serif", Font.PLAIN,fontSize);
		g.setFont(font);
		writeDirections(g);
	}
	
	public void keyPressed(KeyEvent evt)
	{
		int arrowCode = evt.getKeyCode();
		if(arrowCode == KeyEvent.VK_UP)
		{
			if(fontSize+5>80)
				fontSize = 80;
			else
				fontSize +=5;
			repaint();
		}
		else if(arrowCode == KeyEvent.VK_DOWN)
		{
			if(fontSize-5<8)
				fontSize = 8;
			else
				fontSize -=5;
			repaint();
		}
	}
	
	public void keyTyped(KeyEvent evt){}
	public void keyReleased(KeyEvent evt){}
	
	public void mousePressed(MouseEvent evt)
	{
		requestFocusInWindow();
	}
	
	public void mouseClicked(MouseEvent evt)
	{
		int xMouse, yMouse;
		xMouse = evt.getX();
		yMouse = evt.getY();
		
		if((xMouse >=10 && xMouse<= 110) && (yMouse >= 10 && yMouse <=30))
		{
			if(colorParameterVar+3>255)
				colorParameterVar = 255;
			else
				colorParameterVar +=3;
			repaint();
		}
		
		else if((xMouse >=115 && xMouse<= 215) && (yMouse >= 10 && yMouse <=30))
		{
			if(colorParameterVar-3 <34)
				colorParameterVar=34;
			else
				colorParameterVar -=3;
			repaint();
		}
	}
	
	public void mouseReleased(MouseEvent evt){}
	public void mouseEntered(MouseEvent evt){}
	public void mouseExited(MouseEvent evt){}
}
