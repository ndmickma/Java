// Sanvitti Shah
// Per. 2
// 03/23/26
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
import javax.swing.JScrollPane;

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
		setLayout(new BorderLayout());
		
		pp = new PictPanel();
		RightControlPanel rcp = new RightControlPanel();
		
		// set the width of the right control panel to 300 (less than half of the whole screen)
		rcp.setPreferredSize(new Dimension(300, 600));
		
		add(pp, BorderLayout.CENTER);
		add(rcp, BorderLayout.EAST);
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
			setLayout(new BorderLayout());
			font = new Font("Serif", Font.BOLD, 20);
			welcome = new JLabel("Welcome", JLabel.CENTER);
			welcome.setFont(font);
			add(welcome, BorderLayout.NORTH);
			tAComponentInfo = new JTextArea("");		
			JScrollPane scroll = new JScrollPane(tAComponentInfo);
			scroll.setPreferredSize(new Dimension(100, 150));
			add(scroll, BorderLayout.SOUTH);
			names = new String[] {"mountains.jpg", "shanghai.jpg", "trees.jpg", "water.jpg"};
			images = new Image[names.length];
			widthOfImages = new int[names.length];
			heightOfImages = new int[names.length]; // create the array for the heights
			selected = 0;
			
			// load all of the pictures
			for (int i = 0; i < names.length; i++)
			{	// since all of the images are in a directory called pictures, each file
				// name needs the following before the file name:   "pictures/" + 
				// e.g. it could be:  pictures/mountains.jpg
				images[i] = getMyImage("pictures/" + names[i]);	// finish this line
				
				width = widthOfImages[i] = images[i].getWidth(this)/3;   //widths of each picture
				height = heightOfImages[i] = images[i].getHeight(this)/3; // find the heights of each picture
			}
		}
		
		// this has been started for you
		public Image getMyImage(String pictName) 
		{
			Image picture = null;
			String pictNameIn = pictName;
			try
			{
				picture = ImageIO.read(new File(pictNameIn));
			}
			catch(IOException e)
			{
				System.err.println("\n\n"+ pictNameIn+ " can't be found.\n\n");
				e.printStackTrace();
			}
			
			return picture;
		}
		
		// draw the image on a blank screen with the top left corner at (20,30)
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			if (images[selected] != null)
			{
				width = widthOfImages[selected] + val;
				height = heightOfImages[selected] + val;
				
				int maxWidth = getWidth() - 20;
				int maxHeight = getHeight() - 250;
				
				if (width > maxWidth) 
					width = maxWidth;
				if (height > maxHeight) 
					height = maxHeight;
				
				g.drawImage(images[selected], 20, 30, width, height, this);
			}
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
			setLayout(new BorderLayout());
			setBackground(Color.CYAN);
			
		    JPanel northSection = new JPanel(new GridLayout(2, 1));
			northSection.setBackground(Color.CYAN);

			JLabel cpLabel = new JLabel("Control Panel", JLabel.CENTER);
			cpLabel.setFont(font);
			northSection.add(cpLabel);
			
			JPanel nameInput = new JPanel();
			nameInput.setBackground(Color.CYAN);
			nameInput.add(new JLabel("Enter your Name"));
			tfName = new JTextField(10);
			tfName.addActionListener(new tfHandler());
			nameInput.add(tfName);
			northSection.add(nameInput);
			add(northSection, BorderLayout.NORTH);
			
			JPanel center = new JPanel(new GridLayout(2,1));
			center.setBackground(Color.CYAN);
			
			JPanel options = new JPanel(new GridLayout(1, 2));
			options.setBackground(Color.CYAN);
			
			JPanel menu = new JPanel();
			add(menu);
			menu.setBackground(Color.CYAN);
			menu.add(makePictureMenuBar());
			
			JPanel radio = new JPanel(new GridLayout(4, 1, 0, 0)); 
			radio.setBackground(Color.CYAN);
			radio.add(new JLabel("Select color of label"));
			
			color1 = new JRadioButton("Red");
			color2 = new JRadioButton("Blue");
			color3 = new JRadioButton("Magenta");
			color1.setBackground(Color.CYAN);
			color2.setBackground(Color.CYAN);
			color3.setBackground(Color.CYAN);
			
			color1.addActionListener(new redRadioHandler());
			color2.addActionListener(new blueRadioHandler());
			color3.addActionListener(new magentaRadioHandler());
			
			bg = new ButtonGroup();
			bg.add(color1); 
			bg.add(color2); 
			bg.add(color3);
			radio.add(color1); 
			radio.add(color2); 
			radio.add(color3);
			
			options.add(menu);
			options.add(radio);
			center.add(options);
			
			sSize = new JSlider(0, 200, 0);
			sSize.setMajorTickSpacing(20);
			sSize.setPaintTicks(true);
			sSize.setPaintLabels(true);
			sSize.setBackground(Color.CYAN);
			sSize.addChangeListener(new sliderHandler());
			
			center.add(sSize);
			add(center, BorderLayout.CENTER);
		}
	
		// There are a some more classes that you will need here to add to RightControlPanel
		// You will need to figure them out based on the directions/prompt and the 
		// sample run in the prompt.  You can figure them out based on your drawing of the
		// layout, i.e. your pseudocode for this.
		
		public JMenuBar makePictureMenuBar()
		{
			JMenuBar bar = new JMenuBar();
			JMenu menu = new JMenu("Picture");
			for (int i = 0; i < pp.names.length; i++)
			{
				String displayName = pp.names[i].replace(".jpg", "");
				JMenuItem item = new JMenuItem(displayName);
				item.setActionCommand("" + i);
				item.addActionListener(new MenuHandler());
				menu.add(item);
			}
			bar.add(menu);
			return bar;
		}
	
		
		// Write the Listener/Handler class for the menu
		class MenuHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent evt)
			{
				selected = Integer.parseInt(evt.getActionCommand());
				val = sSize.getValue();
				pp.repaint();
				tAComponentInfo.append("The picture \"" + pp.names[selected] + "\" was selected.\n");
			}
		}
		
	
		// write the Listener/Handler class for the text field
		class tfHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent evt)
			{
				welcome.setText("Welcome " + tfName.getText());
				tAComponentInfo.setText("\"" + tfName.getText() + "\" was entered in the text field.\n");
			}
		}
		
		

		// write the Listener/Handler class for the slider
		class sliderHandler implements ChangeListener
		{
			public void stateChanged(ChangeEvent evt)
			{
				val = sSize.getValue();
				pp.repaint();
				
				String currentText = tAComponentInfo.getText();
				String sliderSizeText = "The size of the picture was changed by";
				
				if (currentText.contains(sliderSizeText))
				{
					int sliderTextIndex = currentText.lastIndexOf(sliderSizeText);
					tAComponentInfo.setText(currentText.substring(0, sliderTextIndex));
				}
				tAComponentInfo.setText(sliderSizeText + " " + val + ".\n");
			}
		}
	
		// write Listener/Handler class for the JRadioButtons
		class redRadioHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent evt)
			{
				welcome.setForeground(Color.RED);
				tAComponentInfo.setText("The color of the label was changed to Red.\n");
			}
		}
		
		class blueRadioHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent evt)
			{
				welcome.setForeground(Color.BLUE);
				tAComponentInfo.setText("The color of the label was changed to Blue.\n");
			}
		}
		
		class magentaRadioHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent evt)
			{
				welcome.setForeground(Color.MAGENTA);
				tAComponentInfo.setText("The color of the label was changed to Magenta.\n");
			}
		}
		
	}
}	// end class ControlPanel
