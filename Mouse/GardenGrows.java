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
 * KeyListener
 * 
 */
/**Pseudocode
 * import everything neeeded 
 * 	not MouseMotionListener because we are not tracking the mouse as it moves
 * main
 * 	instance of class to call fake main
 * fake main
 * 	create new JFrame and name it "GardenGrows"
 * 	set size and location
 * 	create instance of Panel class
 * 	set visible
 * 
 * in class Panel
 * constructor
 * 	set background color to gray
 * paintComponent
 * 	use super to get paintComponent
 * 	call the drawing methods
 * 	for making green dirt put it in an if statement so it will only be drawn
 * 	when watered is true
 * 		inside this if statment make another one so that flowers will only be drawn
 * 		when watered and sun is true
 * 	request focus so that keyboard focus stays on panel
 * 
 * drawPinkDirt(Graphics g)
 * 	draw filled pink rectangle with appropriate measurements
 *
 * drawGreen(Graphics g)
 * 	draw same exact rectangle except it is green
 * 
 * drawFlowers(Graphics g)
 * 	in a nested for loop, draw yellow filled circles (flowers) that are spaced and sized correctly
 * 
 * write all the mouse methods
 * mousePressed
 * 	get mouse location and set garden x and y location to 50
 * 	if the mouse location is in the range of the garden then clickedInside is true
 * write the key methods
 * keyPressed
 * 	get char and key pressed
 * 	if(clickedInside)
 * 		if % is pressed watered is true
 * 		if up arrow key is pressed sun is true
 * 	if space is pressed
 * 		everything is set to false (resets)
 * 
 * 	repaint to do a fresh coat
 */
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

class MyPanel extends JPanel implements MouseListener, KeyListener
{
	private boolean watered;
	private boolean clickedInside;
	private boolean sun;
	
	public MyPanel()
	{
		watered = false;
		clickedInside = false;
		sun = false;
		setBackground(Color.GRAY);
		addMouseListener(this); //add listeners so mouse and keyboard can be used
		addKeyListener(this);
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawPinkDirt(g); //draw orignal pink dirt
		if(watered) //if it is watered make green
		{
			drawGreen(g);
			if(sun)	//if watered as well as if sun draw flowers
				drawFlowers(g);
		}
		requestFocusInWindow(); //keyboard focus to specific component
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
		for(int x = 120; x<=1120; x+=200)	//make nested for loop to print flowers in a grid
		{
				
			for(int y =70; y<=500; y+=200)
			{
				g.fillOval(x,y,50,50);
			}
		}
	}
	
	public void mouseClicked(MouseEvent evt){} 	//allthe mouse methods need to be written
	public void mouseReleased(MouseEvent evt){}
	public void mousePressed(MouseEvent evt)
	{
		requestFocusInWindow();	//lets focus stay
		
		int xMouse, yMouse, xloc, yloc;
		
		xMouse = evt.getX(); //get mouse location
		yMouse = evt.getY();
		xloc = yloc = 50;	//dirt/garden location
		
		if(xloc < xMouse && xMouse <(xloc+1000) && yloc < yMouse && yMouse < (yloc+500)) //if mouse is in garden
			clickedInside=true;	
	}
	public void mouseEntered(MouseEvent evt){}
	public void mouseExited(MouseEvent evt){}
	public void keyPressed(KeyEvent evt) //key methods 
	{
		int code = evt.getKeyCode(); 
		char letter = evt.getKeyChar();
		
		if(clickedInside)
		{
			if(letter == '%')	//if it has already been clicked and '%' is pressed watered is true
				watered = true;
				
			if(code == KeyEvent.VK_UP)	//if already clicked and up arrow key is pressed, sun is true
				sun = true;
		}
		
		if(code == KeyEvent.VK_SPACE) //if space is pressed, clear everything
		{
			watered = false;
			sun = false;
			clickedInside = false;
		}
		repaint();	//fresh coat
	}
	public void keyTyped(KeyEvent evt){}
	public void keyReleased(KeyEvent evt){}
	
	
	
}
