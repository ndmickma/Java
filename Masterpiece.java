//Sanvitti Shah
//02-10-26
//Per. 2
//Masterpiece.java
/*
 * Working on:
 * graphics
 * GUI
 * JFrame
 * JPanel
 * class in a class
 * custom colors/drawings
 * 
 * Program description:
 * Write code that will draw the hand drawn picture to the computer screen.
 * 
 */
 
 /**
  * Psuedocode
  * import everything
  * make Masterpiece class
  * main
  * 	instance of class to call fake main
  * fake main
  * 	create new JFrame and give it name "Summer Vacation"
  * 	set size and location
  * 	create instance of class Panel 
  * 	set visible
  * in Panel class
  * constructor
  * 	set background color to custom light blue
  * in paintComponent method make parameter Graphics g
  * 	use super keyword to get paintComponent
  * 	call all drawing methods
  * 
  * **IN ALL DRAWING METHODS PASS Graphics g AS PARAMETER
  * 
  * drawSun
  * 	make custom yellow
  * 	use fillOval to draw sun 
  * drawBigBird
  * 	use drawArc to make one side of bigger bird
  * 	use drawArc again(with different values) to make the other side of the bigger bird
  * drawSmallBird
  * 	use drawArc to make one side of bigger bird
  * 	use drawArc again(with different values) to make the other side of the bigger bird
  * drawUmbrella
  * 	make custom pink and set color 
  * 	use fillArc to draw top of umbrella
  * 	use fillRect to draw bottom of umbrella
  * drawGround
  * 	make custom brown and set color
  * 	use fillRect to make ground
  * drawFlag
  * 	make two arrays with three values each for the three points of the triangle
  * 	set color to red and draw polygon
  * 	draw line for the flag stick
  * drawText
  * 	make a new font object and set it to font SansSerif, bold, and size 40
  * 	make custom color DARKBLUE
  * 	set color
  *		set font
  * 	drawString to write the text
  * 	
  */
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;

public class Masterpiece
{
	public static void main(String [] args)
	{
		Masterpiece mp = new Masterpiece();	//make instance of class
		mp.runEverything();	//instance of class calls fake main
	}
	
	public void runEverything()
	{
		JFrame frame = new JFrame("Summer Vacation");	//make a JFrame and give it a name for the top of the file
		frame.setSize(999,648);	//set size of frame
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
		Color LIGHTBLUE = new Color(176,253,255); //custom color using RGB
		setBackground(LIGHTBLUE);	//set background color
	}
	
	public void paintComponent(Graphics g)
	{
		//call all draw methods
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
		Color SUNYELLOW = new Color(255,238,49); //custom color using RGB
		g.setColor(SUNYELLOW);	//set color 
		g.fillOval(27,27,216,216); //circle for sun
	}
	
	public void drawBigBird(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawArc(297,81,108,27,0,180);	//draw first arc for big bird
		g.drawArc(405,81,108,27,0,180);	//draw second arc for big bird
	}
	
	public void drawSmallBird(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawArc(405,135,81,27,0,180);	//draw first arc for small bird
		g.drawArc(486,135,81,27,0,180);	//draw second arc for small bird
	}
	
	public void drawUmbrella(Graphics g)
	{
		Color BROWNISH = new Color(155,93,51);	//custom color using RGB
		Color LIGHTPINK = new Color(255,192,195);	//custom color using RGB
		g.setColor(LIGHTPINK);	//set color
		g.fillArc(540,135,351,378,0,180); //draw top of umbrella
		g.setColor(BROWNISH); //set color
		g.fillRect(702,324,27,243); //draw umbrella stick	
		
	}
	
	public void drawGround(Graphics g)
	{
		Color GROUND = new Color(219,177,97);	//custom color using RGB
		g.setColor(GROUND);	//set color
		g.fillRect(0,540,999,81);	//draw a filled rectangle for ground
	}
	
	public void drawFlag(Graphics g)
	{
		int arr1 [] = {135,189,135};	//make custom x val points 
		int arr2 [] = {459,486,513};	//make custom y val points
		g.setColor(Color.RED);			//set color to red
		g.fillPolygon(arr1, arr2, 3);	//draw triangle part of flag
		g.setColor(Color.BLACK);
		g.drawLine(135,459,135,540);		
	}
	
	public void drawText(Graphics g)
	{
		Font beachFont = new Font("SansSerif",Font.BOLD, 40);	//custom font
		Color DARKBLUE = new Color(0,9,92);	//custom color using RGB
		g.setColor(DARKBLUE);	//set color
		g.setFont(beachFont);	//set font
		g.drawString("Beach!",135,351);	//draw the text
	}	
}
