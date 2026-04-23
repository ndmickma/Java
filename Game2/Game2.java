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
		frame.getContentPane().add(gh);		
		frame.setVisible(true);		
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
		Instructions rulespanel = new Instructions(this, cards, gamdat);
		GameControlPanel controlspanel = new GameControlPanel(this, cards, gamdat);
		BioBase bbpanel = new BioBase(this, cards, gamdat);
		
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
		
		// Start Button
		JButton startBtn = new JButton("");
		startBtn.setFont(new Font("Monospaced", Font.BOLD, 36));
		startBtn.setBounds(350, 380, 300, 80);
		startBtn.setIcon(new ImageIcon("startbutton.jpg")); //use imageIcon library to put an image on the button
		add(startBtn); //add button
		repaint(); //so image shows up
	}
}

class StartButtonHandler implements ActionListener
{
	public void actionPerformed(ActionEvent evt)
	{
		
	}
}
