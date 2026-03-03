//Sanvitti Shah
//Per.2
//03-02-26
//GardenGrows.java
/*Program description
 * This program will interact with the user (mouse/keyboard) 
 * and when the user clicks certain things, ground is watered flowers grow
 * 
 * Working on:
 * GUI
 * Keyboard
 * Mouse
 * JFrame
 * JPanel
 * 
 * 
 */
/**Pseudocode
 * import everything
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GardenGrows
{
	public static void main(String [] args)
	{
		GardenGrows gg = new GardenGrows();
		gg.runEverything();
	}
	
	public void runEverything()
	{
		JFrame frame = new JFrame("GardenGrows");
		frame.setSize(1100,600);
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
	private boolean watered;
	private boolean clicked;
	private boolean sun;
	
	public MyPanel()
	{
		watered = false;
		clicked = false;
		sun = false;
		setBackground(Color.GRAY);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawPinkDirt(g);
		if(watered)
			drawGreen(g);
		
		if(sun)
			drawFlowers(g);
	}
	
	public void drawPinkDirt(Graphics g)
	{
		g.setColor(Color.PINK);
		g.fillRect(50,50,1000,500);
	}
	
	public void drawGreen(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.fillRect(50,50,1000,500);
	}
	
	public void drawFlowers(Graphics g)
	{
		g.setColor(Color.YELLOW);
		for(int x = 50; x<1000; x+=200)
		{
			g.fillOval(x,50,50,50);
		}
	}
	
	
	
}
