/* Sanvitti Shah
 * date: 02-24-26
 * per 2.
 * ImageFirstEx.java

This program shows:
	1. loading an image from a file
	2. three ways to display the image to the screen.
Working on: loading and drawing images
*/

////////////////////////////////////////////////////////
// 1. Add imports for classes Graphics, Image; JPanel, JFrame; and File, IOExcaption, ImageIO
//
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO; 

public class ImageFirstEx
{
	public static void main (String [] args)
	{
		ImageFirstEx ife = new ImageFirstEx();
		ife.run();
	}
	
	public ImageFirstEx()
	{
	}
	
	public void run()	
	{					
		JFrame frame = new JFrame("Draw image to panel");
		frame.setSize( 700, 600);				
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 		
		frame.setLocation(300,50);
		frame.setResizable(true);
		
		ImageFirstExPanel ifePanel = new ImageFirstExPanel(); 		
		frame.getContentPane().add( ifePanel ); 
		frame.setVisible(true);	
	}
}
// Note, ImageFirstExPanel is not nested.
class ImageFirstExPanel extends JPanel
{
	private String pictName;	/// file name of picture
	private Image picture;	/// Image obj to be drawn
	
	public ImageFirstExPanel()
	{
		picture = null; 
		pictName = new String("beckenbauer.jpg");
		getMyImage();		//get the image from a file
	}
	
	public void getMyImage() 
	{
		///////////////////////////////////////////////////
		// 1. Create a try-catch block for loading the image
		try
		{
			picture = ImageIO.read(new File(pictName));
		}
		catch(IOException e)
		{
			System.err.println("\n\n"+ pictName+ " can't be found.\n\n");
			e.printStackTrace();
		}
		
	}
	
	public void paintComponent ( Graphics g )
	{
		///////////////////////////////////////////////////
		// 2.Draw the Image onto the panel.  Examples will use all three methods.
		//g.drawImage(picture, 20, 10, this);
		//g.drawImage(picture, 20, 10, x, y, this);	//change x, y to resize!
		//g.drawImage(picture, 30, 450, 110, 550, 240, 40, 32, 125, this);
		
		//g.drawImage(picture, 50, 30, 600, 500, this);
		//g.drawImage(picture, 500, 00, 200, 150, this);
		//g.drawImage(picture, 00, 400, 100, 75, this);
		
		//g.drawString("Draw Image Here:", 550, 100);
		//g.drawImage(picture, 10 ,50, 310, 300, 100, 50, 400, 300, this);
	}
}

