//Sanvitti Shah
//03-30-26
//PutItTogether.java
//Per.2

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PutItTogether
{	
	public PutItTogether()
	{
	}
	
	public static void main(String [] args)
	{
		PutItTogether pit = new PutItTogether();
		pit.run();
	}
	
	public void run()
	{
		JFrame frame = new JFrame("PutItTogether");
		frame.setSize(800, 800);				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setLocation(100, 50);
		frame.setResizable(true);
		PutItTogetherHolder pith = new PutItTogetherHolder(); 		
		frame.getContentPane().add(pith);		
		frame.setVisible(true);		
	}
}

class PutItTogetherHolder extends JPanel 
{	
	public PutItTogetherHolder()
	{
		setBackground(Color.CYAN);

		CardLayout cards = new CardLayout();
		setLayout(cards);
		
		Information info = new Information();
		FirstPagePanel fpp = new FirstPagePanel(this, cards, info);
		FixedPanelHolder fph = new FixedPanelHolder(info);
		
		add(fpp, "First");
		add(fph, "Home");
	}
}

class FirstPagePanel extends JPanel
{
	private PutItTogetherHolder panelCards;
	private CardLayout cards;
	private Information info;
	private JTextField tfName;
	
	public FirstPagePanel(PutItTogetherHolder panelCardsIn, CardLayout cardsIn, Information infoIn)
	{
		String intro = new String("Welcome to Put It Together!\n\nPages "+
			"included:\n-Home: Navigation Hub\n\n-Picture Page: Interactive "+
			"image of two people\n-Info Pages: Specifics about each person\n\n-Draw Page: "+
			"Interactive color and shape drawing tool.\n\n\tThe two people in the "+
			"picture panel are Phineas and Ferb from the TV show, \n-They go on many "+
			"adventures!\n\n\nThis program is pretty much a mini game and it preps for the actual game!");
		panelCards = panelCardsIn;
		cards = cardsIn;
		info = infoIn;
		
		setLayout(null);
		
		JTextArea introText = new JTextArea(intro);
		introText.setEditable(false);
		introText.setLineWrap(true);
		introText.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(introText);
		scrollPane.setBounds(150, 50, 500, 200);
		add(scrollPane);
		
		JLabel nameLabel = new JLabel("Type in your name:");
		nameLabel.setBounds(200, 300, 150, 30);
		add(nameLabel);
		
		tfName = new JTextField();
		tfName.setBounds(350, 300, 200, 30);
		add(tfName);
		
		JCheckBox confirmBox = new JCheckBox("I understand the directions");
		confirmBox.setBounds(250, 400, 350, 30);
		add(confirmBox);
		
		JLabel errorLabel = new JLabel("");
		errorLabel.setBounds(250, 450, 400, 30);
		errorLabel.setForeground(Color.RED);
		add(errorLabel);
		
		JButton nextBtn = new JButton("Next");
		nextBtn.setBounds(350, 500, 100, 40);
		add(nextBtn);
		
		nextBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (confirmBox.isSelected() && !tfName.getText().trim().isEmpty()) 
				{
					info.setName(tfName.getText().trim());
					cards.show(panelCards, "Home");
				} 
				else 
				{
					errorLabel.setText("Please enter your name and agree to the terms.");
				}
			}
		});
	}
}

class FixedPanelHolder extends JPanel
{
	private Information info;
	private JButton homeButton;
	private HomePanelHolder hph;
	
	public FixedPanelHolder(Information infoIn)
	{
		info = infoIn;
		setLayout(new BorderLayout());
		
		hph = new HomePanelHolder(info);
		add(hph, BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel();
		homeButton = new JButton("Home");
		southPanel.add(homeButton);
		add(southPanel, BorderLayout.SOUTH);
		
		homeButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				hph.getCardLayout().show(hph, "HomeMenu");
			}
		});
	}
}

class HomePanelHolder extends JPanel
{
	private Information info;
	private CardLayout cards;
	
	public HomePanelHolder(Information infoIn)
	{
		info = infoIn;
		cards = new CardLayout();
		setLayout(cards);
		
		HomePanel homeMenu = new HomePanel(this, info);
		BothPictPanel bothPict = new BothPictPanel(this);
		MyPictPanel myPict = new MyPictPanel(this);
		FriendPictPanel friendPict = new FriendPictPanel(this);
		DrawPanel drawPanel = new DrawPanel();
		
		add(homeMenu, "HomeMenu");
		add(bothPict, "BothPict");
		add(myPict, "MyPict");
		add(friendPict, "FriendPict");
		add(drawPanel, "DrawPanel");
	}

	public CardLayout getCardLayout()
	{
		return cards;
	}
}

class HomePanel extends JPanel
{
	private HomePanelHolder parent;
	private Information info;
	private JLabel welcomeLabel;
	
	public HomePanel(HomePanelHolder parentIn, Information infoIn) 
	{
		parent = parentIn;
		info = infoIn;
		setLayout(new BorderLayout());
		
		JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		welcomeLabel = new JLabel("Welcome!");
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
		titlePanel.add(welcomeLabel);
		add(titlePanel, BorderLayout.NORTH);
		
		JPanel centerContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 100));
		JPanel optionsPanel = new JPanel();
		optionsPanel.setLayout(new GridLayout(4, 1, 0, 10));
		
		JLabel promptLabel = new JLabel("Please select which page you would like to see.");
		JRadioButton rb1 = new JRadioButton("To see information about a Phineas and Ferb.");
		JRadioButton rb2 = new JRadioButton("To make some colors and draw some shapes.");
		JRadioButton rbDummy = new JRadioButton(); 
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rbDummy);
		
		optionsPanel.add(promptLabel);
		optionsPanel.add(new JLabel("")); 
		optionsPanel.add(rb1);
		optionsPanel.add(rb2);
		
		centerContainer.add(optionsPanel);
		add(centerContainer, BorderLayout.CENTER);
		
		rb1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				parent.getCardLayout().show(parent, "BothPict");
				rbDummy.setSelected(true); 
			}
		});
		
		rb2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				parent.getCardLayout().show(parent, "DrawPanel");
				rbDummy.setSelected(true); 
			}
		});
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (info.getName() != null && !welcomeLabel.getText().equals("Welcome " + info.getName())) 
		{
			welcomeLabel.setText("Welcome " + info.getName());
		}
	}
}

class BothPictPanel extends JPanel 
{
	private HomePanelHolder parent;
	private Image picture;
	
	public BothPictPanel(HomePanelHolder parentIn) 
	{
		parent = parentIn;
		setLayout(new BorderLayout());
		
		JPanel dirPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel directions = new JLabel("Click on a person to see info about them");
		directions.setFont(new Font("Arial", Font.BOLD, 18));
		dirPanel.add(directions);
		add(dirPanel, BorderLayout.NORTH);
		
		try 
		{
			picture = ImageIO.read(new File("finneasandferb.jpg"));
		} 
		catch (Exception e) 
		{
			System.out.println("Image not found");
		}
		
		addMouseListener(new MouseAdapter() 
		{
			public void mousePressed(MouseEvent e) 
			{
				if (e.getX() < getWidth() / 2) 
				{
					parent.getCardLayout().show(parent, "MyPict");
				} 
				else 
				{
					parent.getCardLayout().show(parent, "FriendPict");
				}
			}
		});
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		if (picture != null) 
		{
			g.drawImage(picture, 50, 50, getWidth() - 100, getHeight() - 100, null);
		} 
		else 
		{
			g.drawString("Image not found.", 200, 300);
		}
	}
}

class MyPictPanel extends JPanel 
{
	private HomePanelHolder parent;
	private Image picture;
	
	public MyPictPanel(HomePanelHolder parentIn) 
	{
		parent = parentIn;
		setLayout(new GridLayout(1, 2));
		
		try 
		{ 
			picture = ImageIO.read(new File("finneasandferb.jpg")); 
		} 
		catch (Exception e) 
		{
		}
		
		JPanel imageDrawPanel = new JPanel() 
		{
			public void paintComponent(Graphics g) 
			{
				super.paintComponent(g);
				if (picture != null) 
				{
					g.drawImage(picture, 0, 0, getWidth(), getHeight(),
								0, 0, picture.getWidth(null) / 2, picture.getHeight(null), null);
				}
			}
		};
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(6, 1));
		infoPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
		
		infoPanel.add(new JLabel("Name: Phineas Flynn"));
		infoPanel.add(new JLabel("Date of Birth: July 9th, 2015"));
		infoPanel.add(new JLabel("Age: 10"));
		infoPanel.add(new JLabel("Hobbies: Building rollercoasters, inventing, having fun"));
		infoPanel.add(new JLabel("")); 
		
		JButton switchBtn = new JButton("<html> <center> See info for <br> the other person </center> </html>");
		switchBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				parent.getCardLayout().show(parent, "FriendPict");
			}
		});
		infoPanel.add(switchBtn);
		
		add(imageDrawPanel);
		add(infoPanel);
	}
}

class FriendPictPanel extends JPanel 
{
	private HomePanelHolder parent;
	private Image picture;
	
	public FriendPictPanel(HomePanelHolder parentIn) 
	{
		parent = parentIn;
		setLayout(new GridLayout(1, 2));
		
		try 
		{ 
			picture = ImageIO.read(new File("finneasandferb.jpg")); 
		} 
		catch (Exception e) 
		{
		}
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(6, 1));
		infoPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
		
		infoPanel.add(new JLabel("Name: Ferb Fletcher"));
		infoPanel.add(new JLabel("Date of Birth: June 10th, 2015"));
		infoPanel.add(new JLabel("Age: 10"));
		infoPanel.add(new JLabel("Hobbies: Engineering, playing instruments, assisting Phineas"));
		infoPanel.add(new JLabel("")); 
		
		JButton switchBtn = new JButton("<html> <center> See info for <br> the other person </center> </html>");
		switchBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				parent.getCardLayout().show(parent, "MyPict");
			}
		});
		infoPanel.add(switchBtn);
		
		JPanel imageDrawPanel = new JPanel() 
		{
			public void paintComponent(Graphics g) 
			{
				super.paintComponent(g);
				if (picture != null) 
				{
					g.drawImage(picture, 0, 0, getWidth(), getHeight(),
								picture.getWidth(null) / 2, 0, picture.getWidth(null), picture.getHeight(null), null);
				}
			}
		};
		
		add(infoPanel);
		add(imageDrawPanel);
	}
}

class DrawPanel extends JPanel
{
	private RightPanel rp;
	private LeftPanel lp;
	private int amtRed, amtGreen, amtBlue;
	private int size;
	private String currentShape;
	
	public DrawPanel()
	{
		amtRed = 255;
		amtGreen = 0;
		amtBlue = 255;
		size = 100;
		currentShape = "Rectangle"; 
		
		setLayout(new BorderLayout());
		
		JMenuBar menuBar = new JMenuBar();
		JMenu shapeMenu = new JMenu("Shapes");
		JMenuItem circleItem = new JMenuItem("Circle");
		JMenuItem ovalItem = new JMenuItem("Oval");
		JMenuItem rectItem = new JMenuItem("Rectangle");
		JMenuItem squareItem = new JMenuItem("Square");
		
		circleItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentShape = "Circle";
				rp.repaint();
			}
		});
		
		ovalItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentShape = "Oval";
				rp.repaint();
			}
		});
		
		rectItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentShape = "Rectangle";
				rp.repaint();
			}
		});
		
		squareItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentShape = "Square";
				rp.repaint();
			}
		});
		
		shapeMenu.add(circleItem);
		shapeMenu.add(ovalItem);
		shapeMenu.add(rectItem);
		shapeMenu.add(squareItem);
		menuBar.add(shapeMenu);
		
		rp = new RightPanel();
		lp = new LeftPanel(menuBar);
		
		JPanel northContainer = new JPanel(new BorderLayout());
		JLabel shapeTitle = new JLabel("Shape Drawing Area", JLabel.CENTER);
		shapeTitle.setFont(new Font("Arial", Font.BOLD, 18));
		northContainer.add(shapeTitle, BorderLayout.CENTER);
		
		add(northContainer, BorderLayout.NORTH);
		add(lp, BorderLayout.WEST);
		add(rp, BorderLayout.CENTER);
	}
	
	public class LeftPanel extends JPanel
	{
		private JSlider redSlider, greenSlider, blueSlider;
		private JScrollBar sizeScrollBar;
		
		public LeftPanel(JMenuBar mb)
		{
			setLayout(new GridLayout(6, 2, 10, 40));
			setBorder(new EmptyBorder(20, 20, 20, 20));
			setPreferredSize(new Dimension(300, 800));
			
			redSlider = new JSlider(0, 255, 255);
			greenSlider = new JSlider(0, 255, 0);
			blueSlider = new JSlider(0, 255, 255);
			
			redSlider.setMajorTickSpacing(50);
			redSlider.setPaintTicks(true);
			redSlider.setPaintLabels(true);
			
			greenSlider.setMajorTickSpacing(50);
			greenSlider.setPaintTicks(true);
			greenSlider.setPaintLabels(true);
			
			blueSlider.setMajorTickSpacing(50);
			blueSlider.setPaintTicks(true);
			blueSlider.setPaintLabels(true);
			
			sizeScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 100, 10, 0, 110);
			
			ChangeListener colorListener = new ChangeListener() 
			{
				public void stateChanged(ChangeEvent e) 
				{
					amtRed = redSlider.getValue();
					amtGreen = greenSlider.getValue();
					amtBlue = blueSlider.getValue();
					rp.repaint();
				}
			};
			
			redSlider.addChangeListener(colorListener);
			greenSlider.addChangeListener(colorListener);
			blueSlider.addChangeListener(colorListener);
			
			sizeScrollBar.addAdjustmentListener(new AdjustmentListener() 
			{
				public void adjustmentValueChanged(AdjustmentEvent e) 
				{
					size = sizeScrollBar.getValue();
					rp.repaint();
				}
			});
			
			add(new JLabel("Shape Menu:"));
			add(mb);
			add(new JLabel("Red:"));
			add(redSlider);
			add(new JLabel("Green:"));
			add(greenSlider);
			add(new JLabel("Blue:"));
			add(blueSlider);
			add(new JLabel("Size:"));
			add(sizeScrollBar);
		}
	}
	
	public class RightPanel extends JPanel
	{
		public RightPanel() 
		{
			setBackground(Color.WHITE);
		}
		
		public void paintComponent(Graphics g) 
		{
			super.paintComponent(g);
			g.setColor(new Color(amtRed, amtGreen, amtBlue));
			
			int w = getWidth();
			int h = getHeight();
			
			if (currentShape.equals("Rectangle")) 
				g.fillRect((w - (size * 2)) / 2, (h - size) / 2, size * 2, size);
			else if (currentShape.equals("Circle")) 
				g.fillOval((w - size) / 2, (h - size) / 2, size, size);
			else if (currentShape.equals("Oval")) 
				g.fillOval((w - (size * 2)) / 2, (h - size) / 2, size * 2, size);
			else if (currentShape.equals("Square")) 
				g.fillRect((w - size) / 2, (h - size) / 2, size, size);
		}
	}
}

class Information
{
	private String name;
	
	public Information()
	{
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String nameIn)
	{
		name = nameIn;
	}
}
