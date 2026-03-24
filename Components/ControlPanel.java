// Sanvitti Shah
// Per. 2
//03-23-26
// ControlPanel.java
// This program gives an example of using several components in order to change the
// different components and/or images.

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Image;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;	
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlPanel
{
	public static void main(String[] args) 
	{
		ControlPanel ce = new ControlPanel();
		ce.run();
	}
	
	public void run() 
	{
		JFrame frame = new JFrame ("Control Panel for Picture");
		frame.setSize(800, 600);
		frame.setLocation(10, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		CpPanelHolder cph = new CpPanelHolder();
		frame.getContentPane().add(cph);
		frame.setVisible(true);
	}
}

class CpPanelHolder extends JPanel
{
	private int selected;  // the index for the picture selected to draw
	private JTextArea tAComponentInfo;	// text area in the PictPanel, but changed in RightControlPanel2
	private JLabel welcome;	// label in the PictPanel, but changed in RightControlPanel2
	private Font font;  // most fonts are the same, so there is one
	private PictPanel pp; // the variables in the RightControlPanel2 need access to use repaint
	private int val; // value of the slider to change the picture size
	private int width;
	private int height;
	private int [] widthOfImages;  // stores the width of each image
	private int [] heightOfImages;  // stores the height of each image
	
	public CpPanelHolder()
	{
		setLayout(new BorderLayout(0,0));
		pp = new PictPanel;
		add(pp, BorderLayout.CENTER);
		
	}
	
	
	/* PictPanel, which has a border layout,  has a label and a text area, both declared above.
	*	most of the code for loading the images is given.  add the rest for the images
	*	plus add the code for the text area, label and font (not necessarily in that order).
	*	the fonts, unless otherwise stated are size 20, bold and Serif.  
	*/
	class PictPanel extends JPanel
	{
		private String[] names;	// the names of the pictures
		private Image[] images;	// array of images to be drawn
		
		public PictPanel()
		{
			setLayout(new BorderLayout(0,0);
			names = new String[] {"mountains.jpg", "shanghai.jpg", "trees.jpg", "water.jpg"};
			images = new Image[names.length];
			widthOfImages = new int[names.length];
			heightOfImages = new int[names.width]  // create the array for the heights
			
			// load all of the pictures
			for (int i = 0; i < names.length; i++)
			{	// since all of the images are in a directory called pictures, each file
				// name needs the following before the file name:   "pictures/" + 
				// e.g. it could be:  pictures/mountains.jpg
				images[i] = 	// finish this line  
				
				widthOfImages[i] = images[i].getWidth(this);
				heightOfImages[i] = images[i].getHeight(this); // find the heights of each picture
			}
			
		
		}
		
		// this has been started for you
		public Image getMyImage(String pictName) 
		{
			Image picture = null;
			
			
			return picture
		}
		
		// draw the image on a blank screen with the top left corner at (20,20)
		public void paintComponent(Graphics g)
		{
			
		}
	}	
		
	/* Make all panels on the right be cyan.
	* RightControlPanel has a border layout.
	* On this panel are:  label, which font size already done, the text field, the menu,
	* the radio buttons and the slider.
	* You will have to determine the layouts in order to make them show up like the sample
	* run provided.
	*/
	class RightControlPanel extends JPanel
	{
		private JTextField tfName; // text field for user to type in their name
		private ButtonGroup bg;	// to select the color so only one is selected
		private JRadioButton color1, color2, color3;	// color choices
		private JSlider sSize;	// slider for changing the size of the picture
		
		public RightControlPanel()
		{
			setLayout(new BorderLayout(0,0);
		}
	
		// There are a some more classes that you will need here to add to RightControlPanel
		// You will need to figure them out based on the directions/prompt and the 
		// sample run in the prompt.  You can figure them out based on your drawing of the
		// layout, i.e. your pseudocode for this.
		
		public JMenuBar makePictureMenuBar()
		{
			
		}
	
		
		// Write the Listener/Handler class for the menu
		
		
	
		// write the Listener/Handler class for the text field
		
		
		

		// write the Listener/Handler class for the slider
	
		// write Listener/Handler class for the JRadioButtons
		
	}
}	// end class ControlPanel
