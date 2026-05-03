//Sanvitti Shah
//per 2
//04/22/26
//Game.java
//BioBase!

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Timer;
import javax.swing.JSlider;


public class Game
{	
	public Game()
	{
	}
	
	public static void main(String [] args)
	{
		Game gam = new Game();
		gam.run();
	}
	
	public void run()
	{
		JFrame frame = new JFrame("BioBase!"); //make JFrame and give it name
		frame.setSize(1000, 600);	//set frame size			
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 
		frame.setLocation(200, 50); //set location of frame
		frame.setResizable(true);
		
		GameHolder gh = new GameHolder(); 		
		frame.getContentPane().add(gh);		
		frame.setVisible(true);	
		frame.setResizable(false);	
	}
}

class GameHolder extends JPanel
{
	public GameHolder()
	{
		CardLayout cards = new CardLayout();
		setLayout(cards);
		
		GameData gamdat = new GameData(); //GameData holds information like name
		StartPanel startpanel = new StartPanel(this, cards, gamdat);
		TCPanel termspanel = new TCPanel(this, cards, gamdat);
		InstructionsPanel rulespanel = new InstructionsPanel(this, cards, gamdat);
		GameControlPanel controlspanel = new GameControlPanel(this, cards, gamdat);
		BioBasePanel bbpanel = new BioBasePanel(this, cards, gamdat);
		
		add(startpanel, "start");
		add(termspanel, "terms");
		add(rulespanel, "rules");
		add(controlspanel, "controls");
		add(bbpanel, "biobase");
		
	}
}

class StartPanel extends JPanel implements ActionListener, MouseListener
{
	private GameHolder holder;
	private CardLayout cards;
	private GameData gamdat;
	private Image backgroundImage;
	private JTextField tfName;
	
	public StartPanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		setLayout(null);
		
		Font namefont = new Font("Monospaced", Font.PLAIN, 24);
		Font titlefont = new Font("Monospaced", Font.BOLD, 90);
		
		//Background Image
		try 
		{
			backgroundImage = ImageIO.read(new File("frontbackground.jpg"));
		} 
		catch(IOException except) 
		{
			System.out.println("Error: 'frontbackground.jpg' not found.");
			except.printStackTrace();
		}
		
		//make JLabel title
		JPanel title = new JPanel();
		JLabel titleLabel = new JLabel("<html><center> BioBase </center> </html>" );
		titleLabel.setFont(titlefont);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(300, 80, 400, 100);
		add(titleLabel);
		add(title);
		
		//Name Text Field
		tfName = new JTextField("enter name");
		tfName.setFont(namefont);
		tfName.setHorizontalAlignment(JTextField.CENTER);
		tfName.setBounds(350, 250, 300, 50);
		tfName.addMouseListener(this);
		add(tfName);
		
		// Start Button
		JButton startBtn = new JButton("");
		startBtn.setActionCommand("start");
		startBtn.setFont(namefont);
		startBtn.setBounds(350, 380, 300, 80);
		startBtn.addActionListener(this);
		startBtn.setIcon(new ImageIcon("startbutton.jpg")); //use imageIcon library to put an image on the button
		add(startBtn); //add button
		repaint(); //so image shows up
	}

	public void actionPerformed(ActionEvent evt)
	{
		String command = evt.getActionCommand();
		String text = tfName.getText();
		if(command.equals("start") && !(text.equals("")) && !(text.equals(" ")) && !(text.equals("enter name")))
		{
			gamdat.setName(text);
			cards.show(holder, "terms");
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (backgroundImage != null) //only draw image if there is actually an image 
		{
			g.drawImage(backgroundImage, 0, 0, 1000, 600, this);
		}
		else
		{
			System.out.println("background image not found"); //if not found print error message to terminal
		}
	}
	public void mouseClicked(MouseEvent mousevt)
	{
		String entered = tfName.getText();
		
		if(entered.equals("enter name"))
			tfName.setText("");
	}
	
	public void mousePressed(MouseEvent mousevt){}
	public void mouseReleased(MouseEvent mousevt){}
	public void mouseEntered(MouseEvent mousevt){}
	public void mouseExited(MouseEvent mousevt){}
}

class TCPanel extends JPanel implements ActionListener
{
	private GameHolder holder;
	private CardLayout cards;
	private GameData gamdat;
	private JLabel welcomelabel;
	
	public TCPanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		//make string variable for terms and conditions
		String termsandconditions = new String(" Welcome to BioBase. Before you continue "
		+ "please read through these terms and \n click the agree button to move on.\n\n"
        + " 1. OWNERSHIP OF INTELLECTUAL PROPERTY\n"
        + " The Software, including all original source code and designs, "
        + "is the property\n of the Developer (Sanvitti Shah). This Software is protected by copyright laws.\n\n"
        + " 2. GRANT OF LICENSE\n"
        + " The Developer grants you personal, non-exclusive, non-transferable license to\n use the "
        + "Software for educational purposes. Commercial use is prohibited.\n\n"
        + " 3. THIRD-PARTY CONTENT & ATTRIBUTIONS\n"
        + " BioBase contains mechanics inspired by Google Doodle Champion Island. All\n "
        + "rights to third-party IP belong to their respective owners. This "
        + "project uses\n standard Java libraries.\n\n"
        + " 4. RESTRICTIONS ON USE\n"
        + " The User agrees not to reverse engineer the Software or use automated "
        + "scripts\n to interfere with the gameplay experience.\n\n"
        + " 5. LIMITATION OF LIABILITY\n"
        + " The Developer is not responsible for any damages or data loss "
        + "resulting from\n the use of this Software.\n\n"
        + " By clicking 'I AGREE', you acknowledge these terms as well as "
        + "the contributions of original creators.");
		
		Font agreefont = new Font("Monospaced", Font.BOLD, 36);
		Font termsfont = new Font("Monospaced", Font.BOLD, 20);
		Font welcomefont = new Font("Monospaced", Font.BOLD, 48);
		
		Color turquoise = new Color(51, 187, 222);
		Color skyblue = new Color(151, 223, 249);
		Color brightblue = new Color(56, 174, 220);
		
		setLayout(new BorderLayout());
		
		//Welcome label (NORTH)
		JPanel welcome = new JPanel();
		welcome.setBackground(skyblue);
		welcomelabel = new JLabel("<html> <center> Welcome! </center> </html>");
		welcomelabel.setFont(welcomefont);
		welcomelabel.setForeground(Color.WHITE); 
		welcome.add(welcomelabel);
		add(welcome, BorderLayout.NORTH);
		
		
		//Terms TextArea (CENTER)
		JTextArea terms = new JTextArea(termsandconditions);
		terms.setFont(termsfont);
		terms.setForeground(Color.WHITE);
		terms.setBackground(brightblue);
		terms.setEditable(false);
		terms.setLineWrap(true);
		
		JScrollPane scrollterms = new JScrollPane(terms);
		add(scrollterms, BorderLayout.CENTER);

		//Agree button (SOUTH)
		JPanel iagreesouth = new JPanel();
		iagreesouth.setBackground(skyblue);
		
		JButton agreeBtn = new JButton("I AGREE");
		agreeBtn.setFont(agreefont);
		agreeBtn.setForeground(Color.WHITE);
		agreeBtn.setBackground(turquoise);
		agreeBtn.addActionListener(this);
		iagreesouth.add(agreeBtn);
		add(iagreesouth, BorderLayout.SOUTH);
		
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		String command = evt.getActionCommand();
		if(command.equals("I AGREE"))
			cards.show(holder, "rules");
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		welcomelabel.setText("Welcome " + gamdat.getName() + "!");
	}
}

class InstructionsPanel extends JPanel implements ActionListener
{
	private GameHolder holder;
	private CardLayout cards;
	private GameData gamdat;
	private Image instructionsImage;
	private JPanel col2;
	
	public InstructionsPanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		Font textareasfont = new Font("Monospaced", Font.BOLD, 25);
		Font nextfont = new Font("Monospaced", Font.BOLD, 36);
		Font labelfont = new Font("Monospaced", Font.BOLD, 28);
		
		Color lightblue = new Color(181, 233, 245);
		Color medblue = new Color(111, 167, 240);
		Color darkblue = new Color(17, 44, 128);
		
		setLayout(new GridLayout(1, 3, 20, 20));
		setBackground(lightblue);
		
		JPanel col1 = new JPanel(); //this the panel in the first column 
		col1.setLayout(new BorderLayout());
		
		//Instructions label (NORTH)
		JPanel how = new JPanel();
		how.setBackground(darkblue);
		JLabel howtoplay = new JLabel("<html> <center> How to Play: </center> </html>");
		howtoplay.setFont(labelfont);
		howtoplay.setBackground(darkblue);
		howtoplay.setForeground(Color.WHITE);
		howtoplay.setOpaque(true); //so label background is visible
		how.add(howtoplay);
		col1.add(how, BorderLayout.NORTH);
		
		//Instructions TextArea (CENTER)
		JPanel instructionspanel = new JPanel();
		JTextArea instructions = new JTextArea("\n Match the moving \n genetic "
		+ "sequences\n by typing in the\n correct base pair\n before they "
		+ "leave\n the box to earn a\n high score! If you  miss one or get it\n wrong "
		+ "you will have to answer a\n genetics question.");
		instructions.setBackground(medblue);
		instructions.setLineWrap(true);
		instructions.setEditable(false);
		instructions.setFont(textareasfont);
		instructions.setForeground(Color.WHITE); //make text white
		col1.add(instructions, BorderLayout.CENTER);
		add(col1);
		
		col2 = new JPanel(); //this is the panel in the the second column 
		col2.setOpaque(false); //make panel transparent so image is seen
		try 
		{
			instructionsImage = ImageIO.read(new File("instructionsimage.jpg"));
		} 
		catch(IOException except) 
		{
			System.out.println("Error: 'instructionsimage.jpg' not found.");
			except.printStackTrace();
		}
		add(col2);
		
		JPanel col3 = new JPanel();
		col3.setLayout(new BorderLayout());
		
		//Rules Label (NORTH)
		JPanel rulespan = new JPanel();
		rulespan.setBackground(darkblue);
		JLabel ruleslabel = new JLabel("<html> <center> Rules: </center> </html>");
		ruleslabel.setFont(labelfont);
		ruleslabel.setBackground(darkblue);
		ruleslabel.setForeground(Color.WHITE);
		ruleslabel.setOpaque(true); //so label background is visible
		rulespan.add(ruleslabel);
		col3.add(rulespan, BorderLayout.NORTH);
		
		//Rules TextArea (CENTER)
		JTextArea rules = new JTextArea("\n Don't Break the\n Chain: Missing "
		+ "a\n base or typing the  wrong one will\n lower your score. "
		+ "\n\n High Score: Get as  many correct\n pairings as you can in 75 "
		+ "seconds to\n climb up the\n leaderboard!");
		
		rules.setFont(textareasfont);
		rules.setForeground(Color.WHITE);
		rules.setBackground(medblue);
		rules.setLineWrap(true);
		rules.setEditable(false);
		col3.add(rules, BorderLayout.CENTER);
		
		//Next button (SOUTH)
		JButton next = new JButton("NEXT");
		next.setBackground(darkblue);
		next.setForeground(Color.WHITE); //so that text is white
		next.setFont(nextfont);
		next.addActionListener(this);
		col3.add(next, BorderLayout.SOUTH);
		add(col3); //this will add the col3 panel to the third column
		
		
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		String command = evt.getActionCommand();
		if(command.equals("NEXT"))
			cards.show(holder, "controls");
	}
	
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		if (instructionsImage != null) //only draw image if there is actually an image 
		{
			int x = col2.getX();
			int y = col2.getY();
			int width = col2.getWidth();
			int height = col2.getHeight();
			
			g.drawImage(instructionsImage, x, y, width, height, this);
		}
		else
		{
			System.out.println("instructions image not found"); //if not found print error message to terminal
		}
	}
		
}

class GameControlPanel extends JPanel implements ActionListener, ChangeListener
{
	private GameHolder holder;
	private CardLayout cards;
	private GameData gamdat;
	
	public GameControlPanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		//set FV equal to the parameters
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		//set layout to BorderLayout
		setLayout(new BorderLayout());
		
		//make all fonts needed
		Font playfont = new Font("Monospaced", Font.BOLD, 60);
		Font controlfont = new Font("Monospaced", Font.BOLD, 70);
		Font labelFont = new Font("Monospaced", Font.BOLD, 30);
		Font itemfont = new Font("Monospaced", Font.BOLD, 32);
		Font menufont = new Font("Monospaced", Font.BOLD, 45);
		Font speedlabelfont = new Font("Monospaced", Font.BOLD, 50);
		
		//make all colors needed
		Color slidercolor = new Color(67, 93, 222);
		Color controllabelcolor = new Color(25, 0, 110);
		Color row3color = new Color(103, 115, 224);
		Color menucolor = new Color(83, 57, 196);
		Color menuitemcolor = new Color(53, 33, 133);
		Color sequencescolor = new Color(91, 70, 170);
		Color speedlabelcolor = new Color(47, 62, 186);
		
		//Make all the dimensions needed for setPreferredSize
		Dimension speedsize = new Dimension(500, 0);
		Dimension slidersize = new Dimension(400, 100);
		Dimension menupanelsize = new Dimension(500, 80);
		Dimension menusize = new Dimension(500, 80);
		
		
		//Controls label (NORTH)
		JPanel controls = new JPanel();
		controls.setBackground(controllabelcolor);
		JLabel controlslabel = new JLabel("<html> <center> Controls </center> </html>");
		controlslabel.setFont(controlfont);
		controlslabel.setForeground(Color.WHITE);
		controls.add(controlslabel);
		add(controls, BorderLayout.NORTH);
		
		//Speed panel (EAST);
		JPanel speedpanel = new JPanel(); //panel with grid layout for all the speed changing
		speedpanel.setLayout(new GridLayout(3,1));
		speedpanel.setBackground(speedlabelcolor);
		speedpanel.setPreferredSize(speedsize); //setPreferredSize so that is takes up half the panel
		
		//The first row has the JLabel "Speed"
		JPanel row1 = new JPanel();
		row1.setBackground(speedlabelcolor);
		
		//make the speed label
		JLabel speedLabel = new JLabel("Speed");
		speedLabel.setFont(speedlabelfont);
		speedLabel.setForeground(Color.WHITE); //make the text white
		speedLabel.setBackground(speedlabelcolor);
		speedLabel.setOpaque(true); //so background is visible
		row1.add(speedLabel); //add the label to row1
		speedpanel.add(row1); //add row1 to the speed panel
		
		//The second row has the JSlider to change the speed
		JPanel row2 = new JPanel();
		row2.setBackground(slidercolor);
		JSlider speedslider = new JSlider( 1, 3, 1); //min is 1, max is 3, starting point is 1
		speedslider.setPreferredSize(slidersize); //set size so that it fills the width of the panel
		speedslider.setMajorTickSpacing(1);
		speedslider.setPaintTicks(true);
		speedslider.setPaintLabels(true);
		speedslider.setFont(labelFont);
		speedslider.setForeground(Color.WHITE); //so that the numbers are white
		speedslider.setBackground(slidercolor);
		speedslider.addChangeListener(this);
		row2.add(speedslider);
		speedpanel.add(row2); //add row2 to the speed panel
		
		//The third row has the JLabels that indicate what 1, 2, and 3 mean
		JPanel row3 = new JPanel();
		row3.setBackground(row3color); 
		row3.setLayout(new GridLayout(1,3)); //row3 has a grid layout of 1 row and 3 cols
		
		//make the three labels
		JLabel one = new JLabel("1 = slow ", SwingConstants.CENTER);
		JLabel two = new JLabel("2 = med ", SwingConstants.CENTER);
		JLabel three = new JLabel("3 = fast", SwingConstants.CENTER);
		
		//set font of each label
		one.setFont(labelFont);
		two.setFont(labelFont);
		three.setFont(labelFont);
		
		//set foreground of each label to white
		one.setForeground(Color.WHITE);
		two.setForeground(Color.WHITE);
		three.setForeground(Color.WHITE);
		
		//add the labels to row 3 in the correct order
		row3.add(one);
		row3.add(two);
		row3.add(three);
		
		speedpanel.add(row3); //add row3 to speed panel
		add(speedpanel, BorderLayout.EAST); //add speed panel to east

		//Menu panel (WEST)
		JPanel menu = new JPanel();
		menu.setLayout(new BorderLayout());
		menu.setBackground(menucolor);
		menu.setPreferredSize(menupanelsize); //use setPreferred size to make it so that it takes up half the panel
		menu.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); //to center bar in panel
		
		//Menu Bar (CENTER)
		JMenuItem dnadna, dnarna, rnadna, rnarna;
		JMenu sequences;
		JMenuBar menuBar;
		
		//make all the JMenuItems
		dnadna = new JMenuItem("DNA -> DNA"); 
		dnarna = new JMenuItem("DNA -> RNA");
		rnadna = new JMenuItem("RNA -> DNA");
		rnarna = new JMenuItem("RNA -> RNA");
		
		//set the background of all the menuitems to the menucolor
		dnadna.setBackground(menuitemcolor);
		dnarna.setBackground(menuitemcolor);
		rnadna.setBackground(menuitemcolor);
		rnarna.setBackground(menuitemcolor);
		
		//set the font of all the JMenuItems
		dnadna.setFont(itemfont);
		dnarna.setFont(itemfont);
		rnadna.setFont(itemfont);
		rnarna.setFont(itemfont);
		
		//set the foreground of all the JMenuItems to white
		dnadna.setForeground(Color.WHITE);
		dnarna.setForeground(Color.WHITE);
		rnadna.setForeground(Color.WHITE);
		rnarna.setForeground(Color.WHITE);
		
		//make the JMenu and JMenuBar
		sequences = new JMenu("Sequences");
		sequences.setFont(menufont);
		sequences.setForeground(Color.WHITE); //make text white
		
		menuBar = new JMenuBar(); 
		menuBar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); 
						//makes the bar center it's own content
						//no horizontal or vertical gap
		menuBar.setPreferredSize(menusize); //set preferred size of bar
		menuBar.setBackground(sequencescolor);
		
		//add all the items to the menu
		sequences.add(dnadna);
		sequences.add(dnarna);
		sequences.add(rnadna);
		sequences.add(rnarna);
		
		//add the menu to the menubar
		menuBar.add(sequences);
		
		//add the menubar to the menu panel
		menu.add(menuBar, BorderLayout.CENTER); //this is in center for now because something will be added later
		
		//THIS WHOLE PART WILL BE FIXED LATER 
		//Make label that says which sequence the user picked (SOUTH)
		//JLabel whatsequence = new JLabel("The Sequence Picked is: ");
		//menu.add(whatsequence, BorderLayout.SOUTH); 
		
		//add the menu panel to WEST
		add(menu, BorderLayout.WEST);
		
		//Play Button (SOUTH)
		JButton play = new JButton(""); //make this an image but for now keep it as text
		play.setActionCommand("play");
		play.addActionListener(this);
		play.setIcon(new ImageIcon("playbutton.jpg")); //use imageIcon library to put an image on the button
		repaint(); //so image shows up
		add(play, BorderLayout.SOUTH); //add button to south
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		String command = evt.getActionCommand();
		if(command.equals("play"))
			cards.show(holder, "biobase");
	}	
	
	
	public void stateChanged(ChangeEvent changevt)
	{
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
}

class BioBasePanel extends JPanel implements ActionListener
{
	private GameHolder holder;
	private CardLayout cards;
	private GameData gamdat;
	private Timer timer;
	private JLabel timerlabel;
	private int count;
	
	public BioBasePanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		Font timerfont = new Font("Monospaced", Font.BOLD, 34);
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		timer = new Timer(1000,this);
		timer.addActionListener(this);
		timerlabel = new JLabel("holder");
		timerlabel.setFont(timerfont);
		timer.start();
		count = 75;
		add(timerlabel);
		
	}
	
	public void paintComponent(Graphics g)
	{
			
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if (count > 0)
		{
			count -=1;
			timerlabel.setText("Time Left: "+count);
			repaint();
		} 
		else
		{
			timer.stop();
		}
	}
}

class GameData
{
	private String name;
	
	public GameData()
	{
		name = "";
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
