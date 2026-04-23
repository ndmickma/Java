//Sanvitti Shah
//per 2
//04/22/26
//Game2.java
//just making card layout 


import java.awt.BorderLayout;
import java.awt.CardLayout;
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

public class Game2
{	
	public Game2()
	{
	}
	
	public static void main(String [] args)
	{
		Game2 gam2 = new Game2();
		gam.run();
	}
	
	public void run()
	{
		JFrame frame = new JFrame("BioBase!"); //make JFrame and give it name
		frame.setSize(1000, 600);	//set frame size			
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 
		frame.setLocation(200, 50); //set location of frame
		frame.setResizable(true);
		
		Game2Holder gh2 = new Game2Holder(); 		
		frame.getContentPane().add(gh2);		
		frame.setVisible(true);	
		frame.setResizeable(false);	
	}
}

class Game2Holder extends JPanel
{
	public Game2Holder()
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

class StartPanel extends JPanel
{
	private Game2Holder holder;
	private CardLayout cards;
	private GameData gamdat;
	
	public StartPanel(Game2Holder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		//Name Text Field
		tfName = new JTextField("enter name");
		tfName.setFont(new Font("Monospaced", Font.PLAIN, 24));
		tfName.setHorizontalAlignment(JTextField.CENTER);
		tfName.setBounds(350, 250, 300, 50);
		add(tfName);
		
		// Start Button
		JButton startBtn = new JButton("");
		startBtn.setActionCommand("start");
		startBtn.setFont(new Font("Monospaced", Font.BOLD, 36));
		startBtn.setBounds(350, 380, 300, 80);
		startBtn.setIcon(new ImageIcon("startbutton.jpg")); //use imageIcon library to put an image on the button
		add(startBtn); //add button
		repaint(); //so image shows up
	}

	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getActionCommand("start") && !(evt.getText("")) && !(evt.getText(" ")))
			cards.show(holder, "terms");
	}
}

class TCPanel extends JPanel
{
	private Game2Holder holder;
	private CardLayout cards;
	private GameData gamdat;
	
	public TCPanel(Game2Holder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		Color turquoise = new Color(51, 187, 222):
		Color skyblue = new Color(151, 223, 249);
		
		setLayout(new BorderLayout());
		setBackground(turquoise);
		
		//Agree button (SOUTH)
		JPanel iagreesouth = new JPanel();
		iagreesouth.setBackground(skyblue);
		
		JButton agreeBtn = new JButton("I AGREE");
		agreeBtn.setFont(new Font("Monospaced", Font.BOLD, 36));
		iagreesouth.add(agreeBtn);
		add(iagreesouth, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource("I AGREE"))
			cards.show(holder, "terms");
	}
}

class IntructionsPanel extends JPanel
{
	private Game2Holder holder;
	private CardLayout cards;
	private GameData gamdat;
	
	public TCPanel(Game2Holder holderIn, CardLayout cardsIn, GameData gamdatIn)
	{
		holder = holderIn;
		cards = cardsIn;
		gamdat = gamdatIn;
		
		Color lightblue = new Color(181, 233, 245);
		
		setLayout(new GridLayout(3,1));
		setBackground(lightblue);
	}
		
}
