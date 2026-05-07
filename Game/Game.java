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
		//gam.startMusic();
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
	
	public void startMusic()
	{
		//this is where the music will be put in
	}
}

class GameHolder extends JPanel
{
	public GameHolder()
	{
		CardLayout cards = new CardLayout(); //make card layout instance
		setLayout(cards); //set the layout to that instance
		
		//make all the panels in this CardLayout and pass in the parameters needed (holder instance, cardlayout instance, game data instance)
		GameData gamdat = new GameData(); //GameData holds information like name
		StartPanel startpanel = new StartPanel(this, cards, gamdat);
		TCPanel termspanel = new TCPanel(this, cards, gamdat);
		InstructionsPanel rulespanel = new InstructionsPanel(this, cards, gamdat);
		GameControlPanel controlspanel = new GameControlPanel(this, cards, gamdat);
		BioBasePanel bbpanel = new BioBasePanel(this, cards, gamdat);
		QuestionPanel qpanel = new QuestionPanel(this, cards, gamdat);
		LeaderboardPanel leadpanel = new LeaderboardPanel(this, cards, gamdat);
		
		//add all the panels with their string identifiers
		add(startpanel, "start");
		add(termspanel, "terms");
		add(rulespanel, "rules");
		add(controlspanel, "controls");
		add(bbpanel, "biobase");
		add(qpanel, "questions");
		add(leadpanel, "leaderboard");
		
	}
}

class StartPanel extends JPanel implements ActionListener, MouseListener
{
	//make field variables 
	private GameHolder holder;
	private CardLayout cards;
	private GameData gamdat;
	private Image backgroundImage; //used in paint component
	private JTextField tfName; //used in paint component
	
	public StartPanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		//set FV equal to parameters
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		setLayout(null); //this panel has a null layout
		
		//make fonts needed
		Font namefont = new Font("Monospaced", Font.PLAIN, 24);
		Font titlefont = new Font("Monospaced", Font.BOLD, 90);
		
		//load background image with try-catch
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
		JLabel titleLabel = new JLabel("<html><center> BioBase </center> </html>" );
		titleLabel.setFont(titlefont);
		titleLabel.setForeground(Color.WHITE); //so text is white
		titleLabel.setBounds(300, 80, 400, 100);
		add(titleLabel); //add title label
		
		//Name Text Field
		tfName = new JTextField("enter name");
		tfName.setFont(namefont);
		tfName.setHorizontalAlignment(JTextField.CENTER);
		tfName.setBounds(350, 250, 300, 50);
		tfName.addMouseListener(this);
		add(tfName);
		
		// Start Button
		JButton startBtn = new JButton(""); //no text because it is an image
		startBtn.setActionCommand("start"); //set action command so we can use it in actionPerformed
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
		if(command.equals("start") && !(text.equals("")) && !(text.equals(" "))) //if the text field isn't empty or space...
		{
			//...then call setName and pass in whatever the user entered and then show the next panel
			gamdat.setName(text);
			cards.show(holder, "terms");
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (backgroundImage != null) //only draw image if there is actually an image 
		{
			g.drawImage(backgroundImage, 0, 0, 1000, 600, this); //fills the whole background
		}
		else
		{
			System.out.println("background image not found"); //if not found print error message to terminal
		}
	}
	
	public void mouseClicked(MouseEvent mousevt)
	{
		String entered = tfName.getText();
		
		if(entered.equals("enter name")) //if the text field says enter name and it is clicked then erase the text
			tfName.setText("");
	}
	
	//the rest of the mouse methods
	public void mousePressed(MouseEvent mousevt){}
	public void mouseReleased(MouseEvent mousevt){}
	public void mouseEntered(MouseEvent mousevt){}
	public void mouseExited(MouseEvent mousevt){}
}

class TCPanel extends JPanel implements ActionListener
{
	//make field variables (FV)
	private GameHolder holder;
	private CardLayout cards;
	private GameData gamdat;
	private JLabel welcomelabel; //so it can be used in paintComponent()
	
	public TCPanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		//set FV equal to the parameters
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
		
		//make all fonts needed
		Font agreefont = new Font("Monospaced", Font.BOLD, 36);
		Font termsfont = new Font("Monospaced", Font.BOLD, 20);
		Font welcomefont = new Font("Monospaced", Font.BOLD, 48);
		
		//make all colors needed
		Color turquoise = new Color(51, 187, 222);
		Color skyblue = new Color(151, 223, 249);
		Color brightblue = new Color(56, 174, 220);
		
		setLayout(new BorderLayout()); //set layout to border
		
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
		
		JScrollPane scrollterms = new JScrollPane(terms); //make scroll pane and pass in text area terms
		add(scrollterms, BorderLayout.CENTER); //add scroll pane to center

		//Agree button (SOUTH)
		JPanel iagreesouth = new JPanel();
		iagreesouth.setBackground(skyblue);
		
		JButton agreeBtn = new JButton("I AGREE");
		agreeBtn.setFont(agreefont);
		agreeBtn.setForeground(Color.WHITE);
		agreeBtn.setBackground(turquoise);
		agreeBtn.addActionListener(this);
		iagreesouth.add(agreeBtn); //add button to panel
		add(iagreesouth, BorderLayout.SOUTH); //add agree panel to south
		
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
		//so welcome label says Welcome WHATEVER USER ENTERED !
	}
}

class InstructionsPanel extends JPanel implements ActionListener
{
	//make field variables
	private GameHolder holder;
	private CardLayout cards;
	private GameData gamdat;
	private Image instructionsImage; //this is used in paint component
	private JPanel col2; //this is a field variable so we can use it in paint component
	
	public InstructionsPanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		//set FV equal to the parameters
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		//make all fonts needed
		Font textareasfont = new Font("Monospaced", Font.BOLD, 25);
		Font nextfont = new Font("Monospaced", Font.BOLD, 36);
		Font labelfont = new Font("Monospaced", Font.BOLD, 28);
		
		//make all colors needed
		Color lightblue = new Color(181, 233, 245);
		Color medblue = new Color(111, 167, 240);
		Color darkblue = new Color(17, 44, 128);
		
		//Grid layout 1 row 3 cols
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
		how.add(howtoplay); //add label to panel
		col1.add(how, BorderLayout.NORTH); //add how to play panel to col1 north
		
		//Instructions TextArea (CENTER)
		JPanel instructionspanel = new JPanel();
		JTextArea instructions = new JTextArea("\n Match the moving \n genetic "
		+ "sequences\n by typing in the\n correct base pair\n before they "
		+ "leave\n the box to earn a\n high score! If you  miss one or get it\n wrong "
		+ "you will have to answer a\n genetics question.");
		instructions.setBackground(medblue);
		instructions.setLineWrap(true); //so text wraps
		instructions.setEditable(false); //so user can't edit the text
		instructions.setFont(textareasfont);
		instructions.setForeground(Color.WHITE); //make text white
		col1.add(instructions, BorderLayout.CENTER);
		add(col1);
		
		col2 = new JPanel(); //this is the panel in the the second column 
		col2.setOpaque(false); //make panel transparent so image is seen
		try 
		{
			instructionsImage = ImageIO.read(new File("instructionsimage.png"));
		} 
		catch(IOException except) 
		{
			System.out.println("Error: 'instructionsimage.png' not found.");
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
		rulespan.add(ruleslabel); //add label to panel
		col3.add(rulespan, BorderLayout.NORTH); //add rules panel to col3 north
		
		//Rules TextArea (CENTER)
		JTextArea rules = new JTextArea("\n Don't Break the\n Chain: Missing "
		+ "a\n base or typing the  wrong one will\n lower your score. "
		+ "\n\n High Score: Get as  many correct\n pairings as you can in 60 "
		+ "seconds to\n climb up the\n leaderboard!");
		
		rules.setFont(textareasfont); //set font
		rules.setForeground(Color.WHITE); //so text is white
		rules.setBackground(medblue); //make bakcground blue
		rules.setLineWrap(true);
		rules.setEditable(false); //so user can't edit the text
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
	//make field variables (FV) that will be needed
	private GameHolder holder;
	private CardLayout cards;
	private GameData gamdat;
	
	//this is used in action performed to let the user know what they selected in the menu bar
	private JLabel selectionlabel;
	
	public GameControlPanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		//set FV equal to the parameters
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		//set layout to BorderLayout
		setLayout(new BorderLayout());
		
		//make all fonts needed
		Font controlfont = new Font("Monospaced", Font.BOLD, 70);
		Font labelFont = new Font("Monospaced", Font.BOLD, 30);
		Font itemfont = new Font("Monospaced", Font.BOLD, 32);
		Font menufont = new Font("Monospaced", Font.BOLD, 45);
		Font speedlabelfont = new Font("Monospaced", Font.BOLD, 50);
		Font selectionfont = new Font("Monospaced", Font.BOLD, 20);
		
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
		JLabel one = new JLabel("1 = slow ");
		JLabel two = new JLabel("2 = med ");
		JLabel three = new JLabel("3 = fast");
		
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
		menu.setPreferredSize(menupanelsize); //use setPreferred size to make it 
		//so that it takes up half the panel b/c there will automatically be a center spcae if no component
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
		
		//addActionListener to all of the JMenuBar so selected string can update
		dnadna.addActionListener(this);
		dnarna.addActionListener(this);
		rnadna.addActionListener(this);	
		rnarna.addActionListener(this);
		
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
	
		//add the menu bar to the menu panel
		menu.add(menuBar, BorderLayout.NORTH); 
		
		//JLabel for showing what is selected (CENTER)
		selectionlabel = new JLabel("The sequence selected is: NONE");
		selectionlabel.setFont(selectionfont);
		selectionlabel.setForeground(Color.WHITE);
		
		//add the label to center
		menu.add(selectionlabel, BorderLayout.CENTER);
		
		
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
		else if(command.equals("DNA -> DNA") || command.equals("DNA -> RNA") || command.equals("RNA -> DNA") || command.equals("RNA -> RNA"))
		{
			selectionlabel.setText("The sequence selected is: " + command);
		}
	}	
	
	
	public void stateChanged(ChangeEvent changevt)
	{
		//this is where what the user picked on the slider will affect the speed of the game
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
}

class BioBasePanel extends JPanel implements ActionListener
{
	//Make field variables
	private GameHolder holder;
	private CardLayout cards;
	private GameData gamdat;
	
	private Timer timer; //for the visible countdown (goes down every second)
	private Timer animationTimer; //updates the screen for smooth animation
	private JLabel timerlabel; //shows time left used in action performed
	private JLabel scorelabel; //shows score used in action performed
	private JTextField inputField; //this is where user can enter the base
	
	private int count; //keeps track of seconds remaining
	private int score; //keeps track of score
	private int strandPosX; //the x coordinate of the entire DNA/RNA strand
	private String currentStrand; //string with the randomly generated bases
	private boolean[] activebases; //boolean array that makes sure that base is active
	private boolean isRunning; //boolean to make sure game is only played once

	public BioBasePanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		//make parameters equal to FV
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		//make all colors needed
		Color lightBlue = new Color(181, 233, 245);
		Color darkBlue = new Color(17, 44, 128);
		Color medBlue = new Color(111, 167, 240);
		
		//make all fonts needed
		Font timerFont = new Font("Monospaced", Font.BOLD, 34);
		Font scoreFont = new Font("Monospaced", Font.BOLD, 30);
		Font promptFont = new Font("Monospaced", Font.BOLD, 24);
		Font inputFont = new Font("Monospaced", Font.BOLD, 50);
		
		//make all dimensions needed for setPreferredSize
		Dimension inputareasize = new Dimension(1000, 120);
		
		//set layout to border
		setLayout(new BorderLayout());
		setBackground(lightBlue); //set background to light blue

		count = 60; //count starts at 60 
		score = 0; //score starts at 0
		strandPosX = -14000; //so that strand doesn't just appear
		isRunning = false; //so that game doesn't start when code is run


		//Timer and Score Labels (NORTH)
		JPanel toppanel = new JPanel();
		toppanel.setLayout(new GridLayout(1,2)); //so that the label panels are centered
		
		//make timer label
		JPanel timerlabelpanel = new JPanel(); //so that label is centered
		timerlabelpanel.setBackground(lightBlue); //set panel background
		timerlabel = new JLabel("Time Left: 60"); //initial time is 60
		timerlabel.setFont(timerFont);
		timerlabel.setBackground(lightBlue); //set label background
		timerlabel.setOpaque(true); //so background is visible
		timerlabel.setForeground(darkBlue); //so text is dark blue
		timerlabelpanel.add(timerlabel);
		
		//make score label
		JPanel scorelabelpanel = new JPanel();
		scorelabelpanel.setBackground(lightBlue); //set panel background
		scorelabel = new JLabel("Score: 0"); //initial score is 0
		scorelabel.setFont(scoreFont);
		scorelabel.setBackground(lightBlue); //set label background
		scorelabel.setOpaque(true); //so background is visible
		scorelabel.setForeground(darkBlue);  //so text is dark blue
		scorelabelpanel.add(scorelabel);
		
		
		toppanel.add(timerlabelpanel); //add timer label panel to top panel
		toppanel.add(scorelabelpanel); //add score label panel to top panel
		add(toppanel, BorderLayout.NORTH); //add top panel to NORTH

		//inputArea (SOUTH)
		JPanel inputArea = new JPanel();
		inputArea.setBackground(medBlue); 
		inputArea.setPreferredSize(inputareasize);
		inputArea.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
		
		JLabel prompt = new JLabel("Match the Base:");
		prompt.setFont(promptFont);
		prompt.setForeground(Color.WHITE);
		
		inputField = new JTextField(2); //text field that's 2 characters wide
		inputField.setFont(inputFont);
		inputField.addActionListener(this); //add action listener
		
		inputArea.add(prompt); //add prompt label to inputArea panel
		inputArea.add(inputField); //add the actual text field to the inputArea panel
		add(inputArea, BorderLayout.SOUTH); //add inputArea to SOUTH

		
		timer = new Timer(1000, this); //increments every 1000 ms (1 second)
		timer.setActionCommand("countdown");
		
		animationTimer = new Timer(20, this); //inscrements every 20ms
		animationTimer.setActionCommand("animation");
		
		generateStrand(); //call generate strand method here so that the strand is set up
	}

	public void actionPerformed(ActionEvent evt)
	{
		String command = evt.getActionCommand(); //get action command 
		
		//Countdown 
		if (command.equals("countdown"))
		{
			if (count > 0) //if time remaining, subtract 1 second and update time label
			{
				count--;
				timerlabel.setText("Time Left: " + count);
			} 
			else //if no time left stop the countdown and animations
			{
				timer.stop();
				animationTimer.stop();
				cards.show(holder, "leaderboard");
			}
		}
		
		//Animation
		else if (command.equals("animation"))
		{
			strandPosX += 3; //moves the strand 3px to the right

			for (int i = 0; i < 100; i++) //goes through 100 bases
			{
				int charX = strandPosX + (i * 140); //add the strand position to (i*140)
					//since each base is 140px and i is the number of bases passed apart adding i*140 to strand position
					//this gives us the x position of the current character (base)
				
				if (charX > 530 && activebases[i] == false) //if the base is "active"...
				{			//...(the base can be interacted with) after 530 (outside of box -> user missed it or typed wrong)), the user loses points	
					activebases[i] = true; //then make it inactive so it disappears
					score = score - 4; //subtract from the score
					cards.show(holder, "questions"); //if...then user needs to answer a question
					
					if (score < 0) //if the score is less than 0 the score just stays 0
						score = 0;
					scorelabel.setText("Score: " + score); //update score label
				}
			}
		}
		
		//Input Field
		else
		{
			//get user input and set it to uppercase
			String input = inputField.getText().toUpperCase(); 
			inputField.setText(""); //once text is stored make text field empty
			
			int targetIndex = -1; //targetIndex is the index of the base that is inside the target box
			for (int i = 0; i < 100; i++) //goes through all 100 bases searching for one that is in the target box and active
			{
				int charX = strandPosX + (i * 140);  //get the x position of the current base
				if (charX >= 450 && charX <= 530 && activebases[i] == false) //if in the target box and the base can be interacted with
				{
					targetIndex = i; //then the target index is whatever i is
					i = 100; //since one base has been found stop the loop because only go one letter at a time
				}
			}
			
			if (targetIndex != -1) //if the targetIndex has a valid value 
			{
				//get the actual base at the targetIndex
				char targetChar = currentStrand.charAt(targetIndex);
				boolean correct = false; //start with correct as false
				
				//if base is A and input is T, correct is true
				if (targetChar == 'A' && input.equals("T")) 
					correct = true;
				//if base is T and input is A, correct is true
				else if (targetChar == 'T' && input.equals("A")) 
					correct = true;
				//if base is C and input is G, correct is true
				else if (targetChar == 'C' && input.equals("G")) 
					correct = true;
				//if base is G and input is C, correct is true
				else if (targetChar == 'G' && input.equals("C")) 
					correct = true;
				else
					cards.show(holder, "questions"); //if incorrect user needs to answer a question
				
				activebases[targetIndex] = true; //set the base at targetIndex to active
				if (correct) //if correct add 4 to the score
					score = score + 4; 
				else //if wrong subtract 4
				{
					score = score - 4;
					if (score < 0) //if less than 0 score is just 0
						score = 0;
				}
				
				scorelabel.setText("Score: " + score); //update scorelabel
			}
		}
		repaint(); //call repaint() so changes are seen
	}

	private void generateStrand()
	{
		String bases = "ATCG";
		currentStrand = "";
		activebases = new boolean[100]; //it is 100 long because 100 bases in a strand
		for(int i = 0; i < 100; i++) //goes through all 100 bases 
		{
			int index = (int)(Math.random() * 4); //random number from 0 to 3
			
			//add the base at the random index generated (use charAt()) onto current strand
			currentStrand = currentStrand + bases.charAt(index); 
			activebases[i] = false; //every base is active because game hasn't started
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//make all colors needed
		Color darkBlue = new Color(17, 44, 128);
		Color colorA = new Color(25, 25, 112);
		Color colorT = new Color(0, 100, 0);
		Color colorC = new Color(128, 0, 128);
		Color colorG = new Color(255, 105, 180);
		
		//make strand font
		Font strandFont = new Font("Monospaced", Font.BOLD, 60);

		//since paintComponent is triggered when the panel is visible start the animations and timer here
		if (isRunning == false) //if game not started:
		{
			timer.start(); //start the game
			animationTimer.start(); //start the animation
			isRunning = true; //set isRunning to true
		}
		
		g.setColor(darkBlue); //set color to darkBlue
		
		// Target Box
		g.drawRect(465, 180, 70, 90); //draw the target box

		if (currentStrand != null) //white currentStrand has something in it
		{
			g.setFont(strandFont); //set the font to strandFont
			for (int i = 0; i < 100; i++) //go through 100 bases
			{
				int charX = strandPosX + (i * 140); //get the x position of the current base
				if (charX > -50 && charX < 1050 && activebases[i] == false) //if base is on screen (with extra padding) and base is active
				{
					char b = currentStrand.charAt(i); //get the specific char at index i
					
					//if the base is A make the color blue
					if (b == 'A') 
						g.setColor(colorA); 
					//if the base is T make the color green
					else if (b == 'T') 
						g.setColor(colorT);  
					//if the base is C make the color purple 
					else if (b == 'C') 
						g.setColor(colorC); 
					//if the base is G make the color pink
					else if (b == 'G') 
						g.setColor(colorG); 
					
					//draw the base at the charX position and 250 as the baseline
					g.drawString("" + b, charX, 250); 
				}
			}
		}
	}
}

class QuestionPanel extends JPanel implements ActionListener
{
	//make field variables
	private GameHolder holder;
	private CardLayout cards;
	private GameData gamdat; 
	private JButton submit;
	
	public QuestionPanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		setLayout(new BorderLayout());
		
		//Make question area (NORTH)
		
		JTextArea questionAsked = new JTextArea("Question placeholder");
		//questionAsked.setText(getQuestion());
		
		add(questionAsked, BorderLayout.NORTH);
		
		
		//make SUBMIT button in SOUTH
		submit = new JButton("SUBMIT");
		submit.addActionListener(this);
		
		
		
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		String command = evt.getActionCommand();
		if(command.equals("SUBMIT")) //if command is submit then check answer
		{
		}
	}
}

class LeaderboardPanel extends JPanel
{
	private GameHolder holder;
	private CardLayout cards;
	private GameData gamdat;
	
	public LeaderboardPanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		setLayout(new BorderLayout());
		
		//Make JLabel with congrats message (NORTH)
		JLabel congrats = new JLabel("Congrats");
		
		//add congrats label to north
		add(congrats, BorderLayout.NORTH);
	}
}

class GameData
{
	private String name;
	private boolean [] chosenQuestions;
	private int questionCount;
	
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
	
	public void getQuestion()
	{
		//Scanner inFile = null;
		String questionFileName = "geneticsquestions.txt";
		File questionFile = new File(questionFileName);
		
		//try
		//{
			//inFile = new Scanner(questionFileName);
		//}
		
		//catch(FileNotFoundException except)
		{
			System.err.printf("ERROR: Cannot open %s/n", questionFileName);
			//System.out.println(except);
			System.exit(1);
		}
		
		int questionNumber = (int)(Math.random()*30);
	}
}
