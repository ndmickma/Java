//Sanvitti Shah
//Per.2
//02-23-26
//Constellation.java
/*Working on:
 * graphics
 * GUI
 * JPanel
 * JFrame
 * class in class
 * custom colors/drawing
 * 
 * Program description
 * Draw the big dipper picture from the paper to the computer screen
 */
/**Pseudocode
 * 
 * 
 * 
 */

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;

public class Constellation
{
	public static void main(String [] args)
	{
		Constellation con = new Constellation();
		con.runEverything();
	}
		
	public void runEverything()
	{
		JFrame frame = new JFrame("The Big Dipper");	//make a JFrame and give it a name for the top of the file
		frame.setSize(630,450);	//set size of frame
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocation(0,0);	//set location of frame
		frame.setResizable(true);
		MyPanel pan = new MyPanel();	//make instance of panel class
		frame.getContentPane().add(pan);		
		frame.setVisible(true);
	}
}

class MyPanel extends JPanel
{
	public MyPanel()
	{
		setBackground(Color.BLUE);	//set background color
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawPlanet(g);
		drawConstellation(g);
		drawRocket(g);
		drawMoon(g);
		drawText(g);
		drawGrid(g);
		
	}
	
	public void drawPlanet(Graphics g)
	{
		g.setColor(Color.BROWN);
		
	}
	
	public void drawConstellation(Graphics g)
	{
	}
	
	public void drawRocket(Graphics g)
	{
	}
	
	public void drawMoon(Graphics g)
	{
	}
	
	public void drawText(Graphics g)
	{
	}
	
	public void drawGrid(Graphics g)
	{
		int size = 20;
		g.setFont(new Font("serif", Font.PLAIN, 15));
		for(int x = 0; x <= 640; x += size)
		{
			g.setColor(new Color(165, 200, 233));
			g.drawLine(x, 0, x, 440);
			if(x%100 == 0)
			{
				g.setColor(Color.BLACK);
				g.drawString(x + "", x-12, 12);
			}
		}

		for(int y = 0; y <= 450; y += size)
		{
			g.setColor(new Color(165, 200, 233));
			g.drawLine(0, y, 640, y);
			if(y%100 == 0)
			{
				g.setColor(Color.BLACK);
				g.drawString(y + "", 0, y+3);
			}
		}
	}

}
