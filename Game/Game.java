//Sanvitti Shah
//per 2
//04/22/26
//Game.java
//BioBase!

import java.util.Scanner;

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
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;



public class Game
{	
	public Game()
	{
	}
	
	public static void main(String [] args)
	{
		Game gam = new Game();
		gam.run();
		gam.startMusic();
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
		frame.requestFocusInWindow(); //so that text field doesn't start with cursor in it

	}
	
	public void startMusic()
	{
		File soundFile;
		
		try
		{
			soundFile = new File("gamesound.wav");
			AudioInputStream audio = AudioSystem.getAudioInputStream(soundFile);
			Clip soundclip = AudioSystem.getClip();
			soundclip.open(audio);
			soundclip.start();
			soundclip.loop(Clip.LOOP_CONTINUOUSLY);
			Thread.sleep(5000);
		}
		catch(Exception except)
		{
			except.printStackTrace();
		}
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
		BioBasePanel bbpanel = new BioBasePanel(this, cards, gamdat);
		GameControlPanel controlspanel = new GameControlPanel(this, cards, gamdat, bbpanel);
		QuestionPanel qpanel = new QuestionPanel(this, cards, gamdat);
		LeaderboardPanel leadpanel = new LeaderboardPanel(this, cards, gamdat, bbpanel);
		
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
		tfName.setHorizontalAlignment(JTextField.CENTER); //so text is centered inside text field
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
		if(command.equals("start") && !(text.equals("")) && !(text.equals(" ")) && !(text.equals("enter name"))) //if the text field isn't empty or space...
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
		JTextArea instructions = new JTextArea(" -Match the moving \n genetic "
		+ "sequences\n by typing in the\n correct base pair\n before they "
		+ "leave\n the box to earn a\n high score!\n -Every 16 points\n or if you miss a\n base/get it wrong "
		+ "\n you will have to\n answer a genetics\n question but your\n timer won't stop so be fast!!");
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
		+ "\n\n High Score: Get as  many correct\n pairings as you can in 75 "
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
	private BioBasePanel bbPanel;
	
	//this is used in action performed to let the user know what they selected in the menu bar
	private JLabel selectionlabel;
	
	public GameControlPanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn, BioBasePanel bbPanelIn)
	{
		//set FV equal to the parameters
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		bbPanel = bbPanelIn;
		
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
		{
			bbPanel.generateStrand(); //so that strand is updated to what user picked
			
			cards.show(holder, "biobase");
			
		}
		else if(command.equals("DNA -> DNA") || command.equals("DNA -> RNA") || command.equals("RNA -> DNA") || command.equals("RNA -> RNA"))
		{
			selectionlabel.setText("The sequence selected is: " + command);
			gamdat.setSequenceType(command); //to save the selected sequence
		}
	}	
	
	
	public void stateChanged(ChangeEvent changevt)
	{
		JSlider source = (JSlider)changevt.getSource(); //gets what the user selected 
		gamdat.setSpeed(source.getValue()); //saves the speed the user selected
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
	private boolean questionTriggered; //boolean to prevent every 16 points question from repeating

	public BioBasePanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		//make parameters equal to FV
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		questionTriggered = false; 
		
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

		count = 75; //count starts at 75
		score = 0; //score starts at 0
		strandPosX = -14000; //so that strand doesn't just appear
		isRunning = false; //so that game doesn't start when code is run


		//Timer and Score Labels (NORTH)
		JPanel toppanel = new JPanel();
		toppanel.setLayout(new GridLayout(1,2)); //so that the label panels are centered
		
		//make timer label
		JPanel timerlabelpanel = new JPanel(); //so that label is centered
		timerlabelpanel.setBackground(lightBlue); //set panel background
		timerlabel = new JLabel("Time Left: 75"); //initial time is 75
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
		
		//Input text Field
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
		if(command.equals("countdown"))
		{
			if(count > 0) //if time remaining, subtract 1 second and update time label
			{
				count--;
				timerlabel.setText("Time Left: " + count);
			} 
			else //if no time left stop the countdown and animations
			{
				timer.stop();
				animationTimer.stop();
				gamdat.setScore(score);
				cards.show(holder, "leaderboard");
			}
		}
		
		//Animation
		else if(command.equals("animation"))
		{
			int currentSpeed = gamdat.getSpeed();
			
			if(currentSpeed == 1) //if 1 is selected speed
				strandPosX += 3; //move the strand 3px to the right
			else if(currentSpeed == 2) //if 2 is selected speed
				strandPosX += 5; //move the strand 5px to the right
			else if(currentSpeed == 3) //if 3 is selected speed
				strandPosX += 7; //move the strand 7px to the right

			for(int i = 0; i < 100; i++) //goes through 100 bases
			{
				int charX = strandPosX + (i * 140); //add the strand position to (i*140)
					//since each base is 140px and i is the number of bases passed apart adding i*140 to strand position
					//this gives us the x position of the current character (base)
				
				if(charX > 530 && activebases[i] == false) //if the base is "active"...
				{			//...(the base can be interacted with) after 530 (outside of box -> user missed it or typed wrong)), the user loses points	
					activebases[i] = true; //then make it inactive so it disappears
					score = score - 4; //subtract from the score
					cards.show(holder, "questions"); //if...then user needs to answer a question
					
					if(score < 0) //if the score is less than 0 the score just stays 0
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
				if(charX >= 450 && charX <= 530 && activebases[i] == false) //if in the target box and the base can be interacted with
				{
					targetIndex = i; //then the target index is whatever i is
					i = 100; //since one base has been found stop the loop because only go one letter at a time
				}
			}
			
			if(targetIndex != -1) //if the targetIndex has a valid value 
			{
				//get the actual base at the targetIndex
				char targetChar = currentStrand.charAt(targetIndex);
				boolean correct = false; //start with correct as false
				String seqType = gamdat.getSequenceType();
				
				//check the user input with nested if statements
				if (seqType.equals("DNA -> DNA"))
				{
					//if base is A and input is T, correct is true
					if(targetChar == 'A' && input.equals("T")) 
						correct = true;
					//if base is T and input is A, correct is true
					else if(targetChar == 'T' && input.equals("A")) 
						correct = true;
					//if base is C and input is G, correct is true
					else if(targetChar == 'C' && input.equals("G")) 
						correct = true;
					//if base is G and input is C, correct is true
					else if(targetChar == 'G' && input.equals("C")) 
						correct = true;
				}
				else if (seqType.equals("DNA -> RNA"))
				{
					//if base is A and input is U, correct is true
					if(targetChar == 'A' && input.equals("U")) 
						correct = true;
					//if base is T and input is A, correct is true
					else if(targetChar == 'T' && input.equals("A")) 
						correct = true;
					//if base is C and input is G, correct is true
					else if(targetChar == 'C' && input.equals("G")) 
						correct = true;
					//if base is G and input is C, correct is true
					else if(targetChar == 'G' && input.equals("C")) 
						correct = true;
				}
				else if (seqType.equals("RNA -> DNA"))
				{
					//if base is A and input is T, correct is true
					if(targetChar == 'A' && input.equals("T")) 
						correct = true;
					//if base is U and input is A, correct is true
					else if(targetChar == 'U' && input.equals("A")) 
						correct = true;
					//if base is C and input is G, correct is true
					else if(targetChar == 'C' && input.equals("G")) 
						correct = true;
					//if base is G and input is C, correct is true
					else if(targetChar == 'G' && input.equals("C")) 
						correct = true;
				}
				else if (seqType.equals("RNA -> RNA"))
				{
					//if base is A and input is U, correct is true
					if(targetChar == 'A' && input.equals("U")) 
						correct = true;
					//if base is U and input is A, correct is true
					else if(targetChar == 'U' && input.equals("A")) 
						correct = true;
					//if base is C and input is G, correct is true
					else if(targetChar == 'C' && input.equals("G")) 
						correct = true;
					//if base is G and input is C, correct is true
					else if(targetChar == 'G' && input.equals("C")) 
						correct = true;
				}
				
				if(correct == false)
					cards.show(holder, "questions"); //if incorrect user needs to answer a question
					
					
				activebases[targetIndex] = true; //set the base at targetIndex to active
				if(correct) //if correct add 4 to the score
					score = score + 4; 
				else //if wrong subtract 4
				{
					score = score - 4;
					if(score < 0) //if less than 0 score is just 0
						score = 0;
				}
				
				scorelabel.setText("Score: " + score); //update scorelabel
			}
		}
		
		if(score % 16 == 0 && score !=0) //user needs to answer a question every 16 points
		{
			if(questionTriggered == false) //if the question isn't "triggered" for this score
			{
				questionTriggered = true; //mark as triggered for this score so it doesn't loop
				cards.show(holder, "questions");
			}
		}
		else
			questionTriggered = false; //if score isn't a multiple of 16 then the question is triggered
			
		if(this.isShowing()) //if the game is actually seen, the bases should move
			animationTimer.start();
		else
			animationTimer.stop(); //if the game isn't seen (question panel is shown) the animations should stop
		repaint(); //call repaint() so changes are seen
	}

	public void generateStrand()
	{
		String type = gamdat.getSequenceType();
		String bases = "ATCG";
		
		//if the starting sequence is RNA use AUCG instead
		if(type.equals("RNA -> DNA") || type.equals("RNA -> RNA"))
			bases = "AUCG";
		
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
		Color colorU = new Color(255, 140, 0);
		
		//make strand font
		Font strandFont = new Font("Monospaced", Font.BOLD, 60);

		//since paintComponent is triggered when the panel is visible start the animations and timer here
		if(isRunning == false) //if game not started:
		{
			timer.start(); //start the game
			inputField.requestFocusInWindow(); //so that text field starts with cursor in it
			animationTimer.start(); //start the animation
			isRunning = true; //set isRunning to true
		}
		
		g.setColor(darkBlue); //set color to darkBlue
		
		// Target Box
		g.drawRect(465, 180, 70, 90); //draw the target box

		if(currentStrand != null) //white currentStrand has something in it
		{
			g.setFont(strandFont); //set the font to strandFont
			for(int i = 0; i < 100; i++) //go through 100 bases
			{
				int charX = strandPosX + (i * 140); //get the x position of the current base
				if(charX > -50 && charX < 1050 && activebases[i] == false) //if base is on screen (with extra padding) and base is active
				{
					char base = currentStrand.charAt(i); //get the specific char at index i
					
					//if the base is A make the color blue
					if(base == 'A') 
						g.setColor(colorA); 
					//if the base is T make the color green
					else if(base == 'T') 
						g.setColor(colorT);  
					//if the base is C make the color purple 
					else if(base == 'C') 
						g.setColor(colorC); 
					//if the base is G make the color pink
					else if(base == 'G') 
						g.setColor(colorG);
					//if the base is U make the color orange 
					else if(base == 'U')
						g.setColor(colorU);
					
					//draw the base at the charX position and 250 as the baseline
					g.drawString("" + base, charX, 250); 
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
	
	private ButtonGroup group; //so that only one radio button can be selected
	private JTextArea questionArea; //this is where the question will be displayed
	private JRadioButton[] answer; //array of the answer radio buttons
	private JButton submit, nextQuestion, backToGame; //buttons to control where to go next and submit
	
	public QuestionPanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		//loads the question so panel isn't blank when it first appears
		gamdat.grabQuestionFromFile();
		
		//make all fonts needed
		Font font = new Font("Monospaced", Font.BOLD, 22);
		
		//make all colors needed
		Color backgroundcolor = new Color(181, 233, 245);
		Color questionbuttoncolor = new Color(17, 44, 128);
		Color answercolor = new Color(111, 167, 240);
		Color buttonpanelcolor = new Color(181, 233, 245);
		Color radiocolor = new Color(16, 22, 82);
		
		setBackground(backgroundcolor); //set the background color
		setLayout(new BorderLayout(10, 10)); //make the layout border with 10 vgap and 10 hgap
		
		answer = new JRadioButton[4]; //array can hold the 4 answer buttons
		
		//make the question JPanel to hold question text (NORTH)
		JPanel question = new JPanel();
		question.setLayout(new BorderLayout()); //set layout
		question.setBackground(questionbuttoncolor);
		
		//use border factory like in GameModuleFiles so that there is a border around the question text
		question.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); 
		add(question, BorderLayout.NORTH); //add to NORTH
		
		//make the actual text area for the question (CENTER(of the question panel))
		questionArea = new JTextArea(gamdat.getQuestion(), 3, 30); //set text to whatever getQuestion will randomly return
		questionArea.setFont(font);
		questionArea.setForeground(Color.WHITE); //make text white
		questionArea.setLineWrap(true); //makes text move to next line when needed
		questionArea.setWrapStyleWord(true); //
		questionArea.setOpaque(false); //make it transparent so that only text is visible
		questionArea.setEditable(false); //so user can't edit it
		question.add(questionArea, BorderLayout.CENTER); //add it to the center of question
		
		//make panel to hold the answer choices (CENTER) 
		JPanel answers = new JPanel();
		answers.setBackground(answercolor);
		answers.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //make the padding for the answers
		answers.setLayout(new GridLayout(2, 2, 20, 20)); //make a 2rows x 2cols grid layout
		add(answers, BorderLayout.CENTER); //add it to CENTER
		
		group = new ButtonGroup(); //initialize the button group
		
		for(int i = 0; i < answer.length; i++) //loop will run 4 times to 
			//create each radio button, add it to the group, set its 
			//color, add action listener, and add it to the answers panel
		{
			answer[i] = new JRadioButton(gamdat.getAnswer(i)); 
			group.add(answer[i]);
			answer[i].setBackground(radiocolor);
			answer[i].setFont(font);
			answer[i].addActionListener(this);
			answer[i].setForeground(Color.WHITE);
			answers.add(answer[i]);
		}
		
		//make panel that holds all the buttons (SOUTH)
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(buttonpanelcolor);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
		add(buttonPanel, BorderLayout.SOUTH);
		
		//make the submit button
		submit = new JButton("SUBMIT");
		submit.setFont(font);
		submit.addActionListener(this);
		submit.setEnabled(false); //button starts disabled
		submit.setForeground(Color.WHITE);
		submit.setBackground(questionbuttoncolor);
		buttonPanel.add(submit); //add to button panel
		
		//make the next question button (used when user gets a question wrong)
		nextQuestion = new JButton("NEXT QUESTION");
		nextQuestion.setFont(font);
		nextQuestion.addActionListener(this);
		nextQuestion.setEnabled(false); //button starts disabled
		nextQuestion.setForeground(Color.WHITE);
		nextQuestion.setBackground(questionbuttoncolor);
		buttonPanel.add(nextQuestion); //add to button panel
		
		//make the back to game button (used when user gets question correct)
		backToGame = new JButton("BACK TO GAME");
		backToGame.setFont(font);
		backToGame.addActionListener(this);
		backToGame.setEnabled(false); //button starts disabled 
		backToGame.setForeground(Color.WHITE);
		backToGame.setBackground(questionbuttoncolor);
		buttonPanel.add(backToGame); //add to button panel
	}
	
	public void actionPerformed(ActionEvent evt) 
	{
		Color correctcolor = new Color(56, 196, 95);
		Color wrongcolor = new Color(196, 0 ,3);
		
		String command = evt.getActionCommand(); //get action command
		
		if(group.getSelection() != null) //makes sure a radio button is actually clicked
			submit.setEnabled(true); //then submit can be clicked
		
		if(command.equals("SUBMIT")) //if submitted then check if its right
		{	
			boolean isCorrect = false; //boolean to keep track of correct vs. incorrect 
			int correctIndex = gamdat.getCorrectAnswer(); //use getter method to check the answer
			
			answer[correctIndex].setBackground(correctcolor); //highlight the correct answer in green no matter what
			
			for(int i = 0; i < answer.length; i++)
			{
				if(answer[i].isSelected()) //if the button at i is selected
				{
					if(i != correctIndex) //if it's wrong set background to red
						answer[i].setBackground(wrongcolor);
					else
						isCorrect = true; //if it is not incorrect it is automatically correct
				}
			}
			
			group.clearSelection(); //"unclick" radio buttons
			
			for(int i = 0; i < answer.length; i++) //go through loop and make everything disabled
			{
				answer[i].setEnabled(false);
			}
			submit.setEnabled(false); //make submit disabled
			
			if(isCorrect) //if it is correct make the back to game button clickable
				backToGame.setEnabled(true);
			else
				nextQuestion.setEnabled(true); //if incorrect the user has to answer another question
								//so make next question button clickable
		}
		else if(command.equals("NEXT QUESTION")) //if next question is clicked
		{
			resetQuestion(); //reset everything
			nextQuestion.setEnabled(false); //next question is no longer clickable
		}
		else if(command.equals("BACK TO GAME")) //if back to game is clicked
		{
			resetQuestion(); //still reset questions so that nexr time user gets something wrong everythign is reset
			backToGame.setEnabled(false); //back to game is no longer clickable
			cards.show(holder, "biobase"); //show the game panel 
		}
	}
	
	public void resetQuestion() //this method resets everything so that it is ready for another use
	{
		//make colors needed
		Color radiocolor = new Color(16, 22, 82);
		
		gamdat.grabQuestionFromFile(); //pull a new random question from file
		questionArea.setText(gamdat.getQuestion()); //update text area
		
		for(int i = 0; i < answer.length; i++)
		{
			answer[i].setText(gamdat.getAnswer(i)); //update radio buttons
			answer[i].setEnabled(true); //make them clickable
			answer[i].setBackground(radiocolor); //make the background back to normal
		}
	}
}

class LeaderboardPanel extends JPanel implements ActionListener
{
	//make field variables
	private GameHolder holder;
	private CardLayout cards;
	private GameData gamdat;
	private BioBasePanel gamepanel;
	
	private JTextArea leaderboardArea; //the text area where the actual names are
	private boolean scoreSaved; //boolean to check if score is saved or not to prevent multiple saves due to repaint()
	
	public LeaderboardPanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn, BioBasePanel gamepanelIn)
	{
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		gamepanel = gamepanelIn;
		
		scoreSaved = false; //score is intially not saved
		
		//make all fonts needed
		Font titleFont = new Font("Monospaced", Font.BOLD, 42);
		Font congratsFont = new Font("Monospaced", Font.BOLD, 22);
		Font boardFont = new Font("Monospaced", Font.BOLD, 20);
		Font buttonsFont = new Font("Monospaced", Font.BOLD, 22);
		
		//make all colors needed
		Color titleBgColor = new Color(17, 44, 128);
		Color sideBgColor = new Color(24, 61, 179);
		Color areaBgColor = new Color(181, 233, 245);
		Color buttonColor = new Color(111, 167, 240);
		
		//make all sizes needed
		Dimension titleSize = new Dimension(1000, 80);
		Dimension sideSize = new Dimension(500, 510);
		
		setLayout(new BorderLayout()); //set layout to border
		setBackground(sideBgColor);
		
		//Make "Time's Up!" label (NORTH)
		JLabel titleLabel = new JLabel("Time's Up!", SwingConstants.CENTER);
		titleLabel.setFont(titleFont); //set the font 
		titleLabel.setOpaque(true); //so that background is visible
		titleLabel.setBackground(titleBgColor); //set the background
		titleLabel.setForeground(Color.WHITE); //so the text is white
		titleLabel.setPreferredSize(titleSize); //set the size so it is the right size
		add(titleLabel, BorderLayout.NORTH);//add the label to NORTH
		
		//Make congrats label (WEST)
		//use HTML to add breaks in the text
		int finalScore = gamdat.getScore(); //stores final score
		System.out.println(finalScore);
		//temp string to hold text for congrats label
		String congratsHolder = new String("<html><center>Congrats on finishing<br>the game!<br><br>Below " 
		+"you'll see the<br>leaderboard, try and<br>find your name!<br><br>Play another round and " 
		+"try a different sequence or speed to challenge yourself!<br><br>Your current score is: " + finalScore + "</center></html>" );
		JLabel congratsLabel = new JLabel(congratsHolder, SwingConstants.CENTER);
		congratsLabel.setFont(congratsFont); //set font
		congratsLabel.setOpaque(true); //so the background is visible
		congratsLabel.setBackground(sideBgColor); //set color
		congratsLabel.setForeground(Color.WHITE); //so text os white
		congratsLabel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30)); //so there is space on the sides of the text
		congratsLabel.setPreferredSize(sideSize); //set size so it takes half the screen
		add(congratsLabel, BorderLayout.WEST); //add panel to WEST
		
		//Make the text area where the names will be displayed (CENTER)
		leaderboardArea = new JTextArea(); //initialize the text area
		leaderboardArea.setFont(boardFont); //set font
		leaderboardArea.setEditable(false); //make it uneditable so that player can't change the text
		leaderboardArea.setBackground(sideBgColor); //set background
		leaderboardArea.setForeground(Color.WHITE); //set the text to white
		leaderboardArea.setBorder(BorderFactory.createEmptyBorder(15, 40, 15, 40)); //create space between the text
		
		JScrollPane scrollPane = new JScrollPane(leaderboardArea); //make a scroll pane for the text area so that if there are too many names player can scroll down
		add(scrollPane, BorderLayout.CENTER); //add the scroll pane to CENTER
		
		//make the panel where the 3 buttons will be (SOUTH)
		JPanel buttonspanel = new JPanel();
		buttonspanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //set layout to flow with hgap 40, vgap 15
		buttonspanel.setBackground(areaBgColor); //set background
		
		//Make PLAY AGAIN button (it will take user back to BioBasePanel to play the game with the same controls as the previous round)
		JButton playagain = new JButton("PLAY AGAIN");
		playagain.setFont(buttonsFont); //set font
		playagain.setForeground(Color.WHITE); //so text is white
		playagain.setBackground(buttonColor); //set background
		playagain.addActionListener(this); //add action listener 
		buttonspanel.add(playagain); //add playagain button to the buttons panel
		
		//Make INSTRUCTIONS button (it will take the user back to InstructionPanel to review the rules, change the settings, and play again)
		JButton instructionsBtn = new JButton("INSTRUCTIONS");
		instructionsBtn.setFont(buttonsFont); //set font
		instructionsBtn.setForeground(Color.WHITE); //so the text is white
		instructionsBtn.setBackground(buttonColor); //set background
		instructionsBtn.addActionListener(this); //add action listener
		buttonspanel.add(instructionsBtn); //add instructions button to the button panel
		
		//Make EXIT button (closes everything)
		JButton exitBtn = new JButton("EXIT");
		exitBtn.setFont(buttonsFont); //set font
		exitBtn.setForeground(Color.WHITE); //so text is white
		exitBtn.setBackground(buttonColor); //set background
		exitBtn.addActionListener(this); //add action listener
		buttonspanel.add(exitBtn); //add exit button to the buttons panel
		
		//add buttonspanel to SOUTH
		add(buttonspanel, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent evt)
	{
		String command = evt.getActionCommand(); //get the action command to see what was pressed
		
		if (command.equals("EXIT"))
		{
			System.exit(7); //if exit is pressed exit program with code '7'
		}
		
		else if (command.equals("PLAY AGAIN") || command.equals("INSTRUCTIONS"))
		{ //if play again or instructions pressed
			gamdat.resetAll();  //reset everything
			scoreSaved = false; //the score is no longer saved
			
			BioBasePanel freshGamePanel = new BioBasePanel(holder, cards, gamdat); //make a new instance of the game panel
			holder.remove(gamepanel); //remove the old game panel
			gamepanel = freshGamePanel; //set the original gamepanel variable equal to the new one
			
			holder.add(gamepanel, "biobase"); //add the new panel back into the card layout
			holder.repaint(); //refresh so changes are visible
						
			if (command.equals("PLAY AGAIN")) //if play again is clicked
			{
				cards.show(holder, "biobase"); //go directly to game panel
			}
			else //if instructions was clicked
			{
				cards.show(holder, "rules"); //go to instructions panel
			}
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if (!scoreSaved) //if the score isn't saved
		{
			String scoreboardText = gamdat.updateAndGetLeaderboard(); //make a string variable to hold whatever updateAndGetLeaderboard() returns (fresh leaderboard)
			leaderboardArea.setText(scoreboardText); //set the text of the textarea to that variable
			scoreSaved = true; //now the score is saved
		}
	}
}

class GameData 
{
	private String name; //to store the name of the user for the leaderboard and TCPanel
	private String question; //holds the current question
	private String[] answerSet; //holds 4 strings (multiple choice answers)
	private int correctAnswer; //this is basically the secret code that will get the correct answer
	private boolean[] chosenQuestions; //tracks which questions have already been used
	private int questionCount; //this keeps track of how many questions the user has attempted in one "session"
	private int scoretrack; //keeps track of user's score for the leaderboard
	private int speed; //tracks the speed that the user selected
	private String sequenceType; //tracks the seuqence the user selected

	public GameData() 
	{
		name = ""; 
		answerSet = new String[4]; //it can hold the 4 answers
		sequenceType = "DNA -> DNA";
		speed = 1; 
		
		for(int i = 0; i < answerSet.length; i++) //go through each slot and initialize them
		{
			answerSet[i] = "";
		}
		chosenQuestions = new boolean[200]; //it can hold the 200 questions
		resetAll(); //make sure everything starts at the baseline
	}
	
	public void resetAll() 
	{
		questionCount = 0; //each new session the user has answered 0 questions, regardless of their previous attempts
		scoretrack = 0; //each new game the user's score resets
		for(int i = 0; i < chosenQuestions.length; i++) //go through to make every question not used
		{
			chosenQuestions[i] = false;
		}
	}

	public void grabQuestionFromFile() 
	{
		Scanner inFile = null; //to read text file
		String fileName = "geneticsquestions.txt"; //this is what the text file is called
		File inputFile = new File(fileName); //makes the file

		//use a try catch to make sure the program doesn't crash if file not found
		try 
		{
			inFile = new Scanner(inputFile);
		} 
		catch (FileNotFoundException e) 
		{
			System.err.printf("ERROR: Cannot open %s\n", fileName);
			System.exit(1);
		}

		int questionNumber = (int) (Math.random() * 200); //picks random number from 0 to 199
		while (chosenQuestions[questionNumber] == true) //while the number has been used, pick another number
		{
			questionNumber = (int) (Math.random() * 200);
		}

		chosenQuestions[questionNumber] = true; //set the question chosen to true (used)
		questionCount++; //add one to the number of questions

		for(int i = 0; i < 6 * questionNumber; i++) //since each question has 6 lines, the loop skips 12 lines to land on the start of the third question
		{
			if(inFile.hasNext()) //if therer is a next line
				inFile.nextLine(); //read the next line
		}
		
		if(inFile.hasNext()) 
			question = inFile.nextLine(); //reads the first line of the set of 6 and saves it as the question
		
		for(int i = 0; i < 4; i++) //reads the next 4 lines to get the answer choices and put them into the array
		{
			if(inFile.hasNext())
				answerSet[i] = inFile.nextLine();
		}
		
		if(inFile.hasNext()) //this is the 6th and final line which is a
		{
			String lastLine = inFile.nextLine().trim(); //read the last line and get the secret code number
			//The secret number tells which answer is correct, starting at 0 being the 1st answer
			correctAnswer = Integer.parseInt(lastLine); //make the string into an int
		}
		
		inFile.close(); //close the file and save
	}
	
	//updates leaderboard.txt with the current player performance, sorts it, and returns final leaderboard string
	public String updateAndGetLeaderboard()
	{
		String fileName = "leaderboard.txt";
		File file = new File(fileName); //the file
		Scanner inFile = null; //to read from text file
		PrintWriter outFile = null; //to write to text file
		
		//make the two parallel arrays
		String[] names = new String[1000]; //array to store the names
		int[] scores = new int[1000]; //array to store the corresponding scores
		
		int count = 0; //tracks how many places are succesfully loaded
		
		//use try catch to make sure file exists
		try
		{
			inFile = new Scanner(file); //initialize the reader
			
			// Read lines if file is not empty
			while (inFile.hasNext()) //while there is a next line
			{
				String line = inFile.nextLine().trim(); //line is the variable that will hold the text from the line without extra spaces
				
				//ignore header or empty rows
				if (!line.equals("Leaderboard:") && !line.equals(""))
				{
					int colonIdx = line.lastIndexOf(":"); //searches through the entire current line to find the index of the colon
					if (colonIdx != -1) //if the colon is found
								//in leaderboard.txt the format is name : score, so the colon acts as an easy marker
								//to indicate where the name ends and score starts
					{
						String oldName = line.substring(0, colonIdx).trim(); //"cuts" the name out of the line and removes extra spaces
						String scoreStr = line.substring(colonIdx + 1).trim(); //"cuts" the score out of the line and removes extra spaces
						int oldScore = Integer.parseInt(scoreStr); //turns the string score into a integer so it can be numerically sorted 
						
						names[count] = oldName; //set the index count to the name
						scores[count] = oldScore; //set the index count to the score
						count++; //add one to count to move to the space
					}
				}
			}
			inFile.close(); //saves the work
		}
		
		catch (FileNotFoundException e) //if file not found
		{
			System.err.printf("ERROR: Cannot open %s\n", fileName);
		}
		
		//add the cuurent name and score to the next slot
		names[count] = name;
		scores[count] = scoretrack;
		count++; //add one to the count
		setScore(scoretrack);
		System.out.println(scoretrack);
		System.out.println(getScore());
		
		//nested for loop to sort the scores
		for (int i = 0; i < count - 1; i++) //this loop tells how many passes are made through the list
		{
			for (int j = 0; j < count - (i + 1); j++) //this loop goes through the rows one by one to compare values
			{
				if (scores[j] < scores[j + 1]) //if the score at the current index is less than the score one below it
				{
					//swap scores
					int tempScore = scores[j]; //temporary variable so the value of scores[i] isn't lost
					scores[j] = scores[j + 1]; //the new value of scores[j] is scores[j+1]
					scores[j + 1] = tempScore; //the new value of scores[j+1] is the temp variable (old scores[j] value)
					
					//swap matching names
					String tempName = names[j]; //make temp variable to hold value of names[j] so it is not lost
					names[j] = names[j + 1]; //new value of names[j] is names[j+1]
					names[j + 1] = tempName; //new value of names[j+1] is the temp variable (old names[j])
				}
			}
		}
		
		//try catch to make sure file is there
		try
		{
			outFile = new PrintWriter(file); //opens leaderboard.txt for writing
			outFile.println("Leaderboard:"); //writes header
			
			for (int i = 0; i < count; i++) //loops through the length of the two parallel arrays
			{
				outFile.printf("%s: %d\n", names[i], scores[i]); //write each place in the name : score format and add a new line after each index
			}
			outFile.close(); //saves written work
		}
		catch (IOException e) //if file not found
		{
			System.err.printf("ERROR: Cannot write to %s\n", fileName);
		}
		
		//make the string that holds the text for the actual leaderboard being displayed
		String displayedLeaderboard = "";
		for (int i = 0; i < count; i++) //goes through the length of the parallel arrays
		{
			//set the string variable equal to the #place name - score and then a new line
			displayedLeaderboard += "#" + (i + 1) + " " + names[i] + " - " + scores[i] + "\n"; 
		}
		//int currentScoreIndex = scores[findArrayIndex(names, getName())]; //find the value of the index of the name entered to get the current score
		//setScore(scores[currentScoreIndex]);
		return displayedLeaderboard; //return the leaderboard that needs to be displayed
	}
	
	
	//the following methods are getter and setter methods so that the other classes can use this info
	public String getName()
	{
		return name; 
	}

	public void setName(String nameIn) 
	{ 
		name = nameIn;
	}
	
	public String getQuestion() 
	{ 
		return question; 
	}
	
	public String getAnswer(int index) 
	{ 
		return answerSet[index]; 
	}
	
	public int getCorrectAnswer() 
	{ 
		return correctAnswer; 
	}
	
	public int getQuestionCount() 
	{ 
		return questionCount; 
	}
	
	public int getScore()
	{
		return scoretrack; 
	}
	
	public void setScore(int scoreTrackIn)
	{
		scoretrack = scoreTrackIn;
	}
	
	public int getSpeed() 
	{
		return speed;
	}
	
	public void setSpeed(int speedIn)
	{
		speed = speedIn;
	}
	
	public String getSequenceType()
	{
		return sequenceType;
	}
	
	public void setSequenceType(String typeIn)
	{
		sequenceType = typeIn;
	}	
}
