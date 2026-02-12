//Sanvitti Shah
//02-10-26
//Per. 2
//Masterpiece.java
/*
 * Multiply everything by 27 to scale so it is big
 * 
 */
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Masterpiece
{
	public static void main(String [] args)
	{
		Masterpiece mp = new Masterpiece();
		mp.runEverything();
	}
	
	public void runEverything()
	{
		JFrame frame = new JFrame("Summer Vacation");	//make a JFrame and give it a name for the top of the file
		frame.setSize(999,648);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocation(0,0);
		frame.setResizable(true);
		MyPanel pan = new MyPanel();
		frame.getContentPane().add(pan);		
		frame.setVisible(true);
	}
}

class MyPanel extends JPanel
{
	public MyPanel()
	{
		Color LIGHTBLUE = new Color(176,253,255);
		setBackground(LIGHTBLUE);
	}
	
	public void PaintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawSun(g);
		drawBigBird(g);
		drawSmallBird(g);
		drawUmbrella(g);
		drawGround(g);
		drawFlag(g);
		drawText(g);
	}
	
	public void drawSun(Graphics g)
	{
		g.fillOval(27,27,216,216);
	}
	
	public void drawBigBird(Graphics g)
	{
		
	}
	
	public void drawSmallBird(Graphics g)
	{
		
	}
	
	public void drawUmbrella(Graphics g)
	{
		
	}
	
	public void drawGround(Graphics g)
	{
		
	}
	
	public void drawFlag(Graphics g)
	{
		
	}
	
	public void drawText(Graphics g)
	{
		
	}
	
	
}
