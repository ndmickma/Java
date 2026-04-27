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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

class StartPanel extends JPanel implements ActionListener
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
		JLabel titleLabel = new JLabel("BioBase", SwingConstants.CENTER);
		titleLabel.setFont(new Font("Monospaced", Font.BOLD, 90));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(300, 80, 400, 100);
		add(titleLabel);
		
		//Name Text Field
		tfName = new JTextField("enter name");
		tfName.setFont(namefont);
		tfName.setHorizontalAlignment(JTextField.CENTER);
		tfName.setBounds(350, 250, 300, 50);
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
		
		Font agreefont = new Font("Monospaced", Font.BOLD, 36);
		Font termsfont = new Font("Monospaced", Font.PLAIN, 24);
		Font welcomefont = new Font("Monospaced", Font.BOLD, 48);
		
		Color turquoise = new Color(51, 187, 222);
		Color skyblue = new Color(151, 223, 249);
		Color brightblue = new Color(56, 174, 220);
		
		setLayout(new BorderLayout());
		setBackground(skyblue);
		
		//NORTH: Welcome label
		welcomelabel = new JLabel("Welcome!", SwingConstants.CENTER);
		welcomelabel.setFont(welcomefont);
		add(welcomelabel, BorderLayout.NORTH);
		
		//Agree button (SOUTH)
		JPanel iagreesouth = new JPanel();
		iagreesouth.setBackground(skyblue);
		
		JButton agreeBtn = new JButton("I AGREE");
		agreeBtn.setFont(agreefont);
		agreeBtn.setBackground(turquoise);
		agreeBtn.addActionListener(this);
		iagreesouth.add(agreeBtn);
		add(iagreesouth, BorderLayout.SOUTH);
		
		//Terms TextArea (CENTER)
		JTextArea terms = new JTextArea("hi how are you, fill this out later");
		terms.setFont(termsfont);
		terms.setBackground(brightblue);
		terms.setEditable(false);
		terms.setLineWrap(true);
		
		JScrollPane scrollterms = new JScrollPane(terms);
		add(scrollterms, BorderLayout.CENTER);
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
	
	public InstructionsPanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		Font instructionsrulesfont = new Font("Monospaced", Font.PLAIN, 24);
		Font nextfont = new Font("Monospaced", Font.BOLD, 36);
		Font labelfont = new Font("Monospaced", Font.BOLD, 26);
		
		Color lightblue = new Color(181, 233, 245);
		Color medblue = new Color(111, 167, 240);
		Color darkblue = new Color(17, 44, 128);
		
		setLayout(new GridLayout(1, 3, 20, 20));
		setBackground(lightblue);
		
		JPanel col1 = new JPanel(); //this the panel in the first column 
		col1.setLayout(new BorderLayout());
		
		//Instructions label (NORTH)
		JLabel howtoplay = new JLabel("How to Play:", SwingConstants.CENTER);
		howtoplay.setFont(labelfont);
		howtoplay.setBackground(darkblue);
		howtoplay.setForeground(Color.WHITE);
		howtoplay.setOpaque(true); //so label background is visible
		col1.add(howtoplay, BorderLayout.NORTH);
		
		//Instructions TextArea (CENTER)
		JTextArea instructions = new JTextArea("fill this with simple instructions on how to play");
		instructions.setBackground(medblue);
		instructions.setLineWrap(true);
		instructions.setFont(instructionsrulesfont);
		col1.add(instructions, BorderLayout.CENTER);
		add(col1);
		
		JPanel col2 = new JPanel(); //this is the panel in the the second column 
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
		JLabel ruleslabel = new JLabel("Rules:", SwingConstants.CENTER);
		ruleslabel.setFont(labelfont);
		ruleslabel.setBackground(darkblue);
		ruleslabel.setForeground(Color.WHITE);
		ruleslabel.setOpaque(true); //so label background is visible
		col3.add(ruleslabel, BorderLayout.NORTH);
		
		//Rules TextArea (CENTER)
		JTextArea rules = new JTextArea("put in rules here");
		rules.setFont(instructionsrulesfont);
		rules.setBackground(medblue);
		rules.setLineWrap(true);
		col3.add(rules, BorderLayout.CENTER);
		
		//Next button (SOUTH)
		JButton next = new JButton("NEXT");
		next.setBackground(darkblue);
		next.setForeground(Color.WHITE);
		next.setFont(nextfont);
		next.addActionListener(this);
		col3.add(next, BorderLayout.SOUTH);
		add(col3);
		
		
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
			g.drawImage(instructionsImage, 20, 353, 293, 560, this);
		}
		else
		{
			System.out.println("instructions image not found"); //if not found print error message to terminal
		}
	}
		
}

class GameControlPanel extends JPanel implements ActionListener
{
	private GameHolder holder;
	private CardLayout cards;
	private GameData gamdat;
	
	public GameControlPanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		setLayout(new BorderLayout());
		
		Font playfont = new Font("Monospaced", Font.BOLD, 36);
		Font controlfont = new Font("Monospaced", Font.BOLD, 38);
		
		//Controls label (NORTH)
		JLabel controls = new JLabel("Controls", SwingConstants.CENTER);
		controls.setFont(controlfont);
		add(controls, BorderLayout.NORTH);
		
		//Menu Bar (WEST)
		JMenuItem dnadna, dnarna, rnadna, rnarna;
		JMenu sequences;
		JMenuBar menuBar;
		
		dnadna = new JMenuItem("DNA -> DNA");
		dnarna = new JMenuItem("DNA -> RNA");
		rnadna = new JMenuItem("RNA -> DNA");
		rnarna = new JMenuItem("RNA -> RNA");
		sequences = new JMenu("Sequences");
		menuBar = new JMenuBar();
		
		sequences.add(dnadna);
		sequences.add(dnarna);
		sequences.add(rnadna);
		sequences.add(rnarna);
		menuBar.add(sequences);
		
		add(menuBar, BorderLayout.WEST);
		
		//Play Button (SOUTH)
		JButton play = new JButton("PLAY"); //make this an image but for now keep it as text
		play.setActionCommand("play");
		play.setFont(playfont);
		play.addActionListener(this);
		add(play, BorderLayout.SOUTH);
		
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		String command = evt.getActionCommand();
		if(command.equals("play"))
			cards.show(holder, "biobase");
	}	
}

class BioBasePanel extends JPanel
{
	private GameHolder holder;
	private CardLayout cards;
	private GameData gamdat;
	
	public BioBasePanel(GameHolder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		//This will be finished later 	
	}
	
	public void paintComponent(Graphics g)
		{
			Font font = new Font("Monospaced", Font.BOLD, 36);
			g.setFont(font);
			g.drawString("THIS IS WHERE THE GAME WILL BE PLAYED!", 40,50);
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
