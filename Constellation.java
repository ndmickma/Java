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
		//setBackground(Color.BLUE);	//set background color
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawGrid(g);
		drawPlanet(g);
		drawConstellation(g);
		drawRocket(g);
		drawMoon(g);
		drawText(g);
		
	}
	
	public void drawPlanet(Graphics g)
	{
		//g.setColor(Color.BROWN);
		//g.fillArc();
		
	}
	
	public void drawConstellation(Graphics g)
	{
		g.setColor(Color.BLACK);	 //set color to black
		g.drawLine(40,240,180,180);  //draw first constellation line
		g.fillOval(34,234,11,11);    //draw dot #1
		g.drawLine(180,180,240,200); //draw second constellation line
		g.fillOval(174,174,11,11);	 //draw dot #2
		g.drawLine(240,200,360,220); //draw third constellation line
		g.fillOval(234,194,11,11);	 //draw dot #3
		g.drawLine(360,220,540,140); //draw fourth constellation line
		g.fillOval(354,216,11,11);   //draw dot #4
		g.drawLine(540,140,560,240); //draw fifth constellation line
		g.drawLine(560,240,400,300); //draw sixth contellation line
		g.drawLine(400,300,360,220); //draw seventh constellation line
	}
	
	public void drawRocket(Graphics g)
	{
	}
	
	public void drawMoon(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.fillOval(-7,-7,120,120);	//draw yellow circle for moon "base"
		g.setColor(Color.BLUE);
		g.fillOval(-21,-21,115,115);	//draw another circle in blue to overlap the yellow circle to make right shape
	}
	
	public void drawText(Graphics g)
	{
		g.setColor(Color.BLACK);
		Font writing = new Font("serif",Font.ITALIC, 46);	//custom font
		g.setFont(writing);
		g.drawString("The Big Dipper",150,80);
		g.drawRect(140,35,320,65);
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
