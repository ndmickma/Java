//Sanvitti Shah
// date: 02-26-26
// ShowImage.java
// This program shows:
//
//		1. Using a null layout
//		2. loading an image from a file and displays it to the screen.
//		3. implementing a JLabel component
//		4. uses Mouse and Key events
// 2. Add imports for classes File, IOExcaption, ImageIO
//
import java.awt.Color;			// for classes Graphics, Color, Font, Image
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Font;

import java.awt.event.KeyListener;	// for classes KeyListener, MouseListener
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;		// for classes JFrame, JPanel, JLabel
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.io.File;			// for classes File, IOException, ImageIO
import java.io.IOException;

import javax.imageio.ImageIO;


public class ShowImage
{
	public ShowImage ( )   
	{
	}

	public static void main (String[] args) 
	{
		ShowImage si = new ShowImage();
		si.run();
	}

	
	public void run()
	{
		JFrame frame = new JFrame ( "ShowImage" );
		
		// To close the JFrame
		frame.setDefaultCloseOperation( frame.EXIT_ON_CLOSE );
		
		////////////////////////////////////////////////////////
		// 1. Set the JFrame to a null layout
		frame.setLayout(null);
		
						
		////////////////////////////////////////////////////////
		// 2. Declare and initialize a JLabel object and add to frame
		JLabel label = new JLabel("Calvin");
		Font font = new Font("Arial", Font.BOLD, 40);
		label.setFont(font);
		frame.getContentPane().add(label); //or frame.add(label);
		
				
		// 3. Set the location and size of the label
		label.setBounds(355,0,300,100); //location is 335, 0 and size is 300 by 100

		// Create the JPanel canvas,  add to frame
		DrawingArea canvas = new DrawingArea ( );
		
		frame.getContentPane().add(canvas);
				
		frame.setBackground(Color.GRAY);
		frame.setSize( 800, 750 );
		frame.setLocation( 300, 0 );		//moves the frame to the middle of the screen
		frame.setResizable(false);
		frame.setVisible(true);
	}
} // closes ShowImage class

// canvas-remeber that we need all of the events with these listeners
class DrawingArea extends JPanel implements MouseListener, KeyListener 
{
	////////////////////////////////////////////////////////
	// 2. Declare image object
	private Image image; //the image
	
	private int xpos, ypos;
	private boolean keyClear;

	private int sizeX, sizeY; // Calvin

	private String imageName;
	
	public DrawingArea ( )   
	{
		////////////////////////////////////////////////////////
		// 2. image
		image = null;
	
		xpos = ypos = 220;		// center the picture in the frame
		keyClear = true;
	
		sizeX = 217;	// Calvin pict 
		sizeY = 301;

		////////////////////////////////////////////////////////
		// 2. Provide Filename and load the image from the file
		imageName = "calvin.jpg";
		getMyImage();

		// Give panel its color 
		setBackground(Color.GRAY);
		
		////////////////////////////////////////////////////////
		// 1. Set the location and size of the canvas
		setLocation(0,100);
		setSize(800,650);
	
		///////////////////////////////////////////////////////////
		// 4. add listeners for mouse and key
		addMouseListener(this);
		addKeyListener(this);

	}

public void getMyImage() 
{
	///////////////////////////////////////////////////
	// 2. Create a try-catch block for loading the image
	File imageFile = new File(imageName);
	try
	{
		image= ImageIO.read(imageFile);
	}
	catch(IOException e)
	{
		System.err.println("\n\n\n" + imageName+ " can't be found.\n\n");
		e.printStackTrace();
		//since there is no System.exit(1); program does not stop!
	}
	
}
	public void paintComponent ( Graphics g ) 
	{
		if ( keyClear ) 
			super.paintComponent ( g );	// blank the canvas
		///////////////////////////////////////////////////////////
		// 2. Draw the image that was loaded
		else
			g.drawImage(image, xpos, ypos, sizeX, sizeY, this);
		keyClear = false;
	}

	///////////////////////////////////////////////////////////
	// 4. add all mouse methods
	public void mousePressed(MouseEvent evt)
	{
		requestFocusInWindow();
		xpos = evt.getX() - 110;		//these numbers put the click about
		ypos = evt.getY() - 150;			//the center of the picture.
		repaint();
	}
	
	public void mouseClicked(MouseEvent evt){}	
	public void mouseReleased(MouseEvent evt){}
	public void mouseEntered(MouseEvent evt){}
	public void mouseExited(MouseEvent evt){}
	
	///////////////////////////////////////////////////////////
	// 4. add all key methods	
	public void keyPressed(KeyEvent evt)
	{
		int code = evt.getKeyCode();
		//pressing space or shift will clear the screen
		if(code == KeyEvent.VK_SPACE || code == KeyEvent.VK_SHIFT)
		{
			keyClear = true;
			repaint();
		}
	}
	public void keyTyped(KeyEvent evt){}
	public void keyReleased(KeyEvent evt){}
	
} // closes DrawingArea

