// Sanvitti Shah
// 03-30-26
// Game.java
// Per.2

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

public class Game
{	
	public Game()
	{
	}
	
	public static void main(String [] args)
	{
		Game g = new Game();
		g.run();
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
		
		Information info = new Information();
		FirstPagePanel fpp = new FirstPagePanel(this, cards, info);
		TCPanel tc = new TCPanel(this, cards, info);
	//	HomePanel home = new HomePanel(this, info);
		
		add(fpp, "First");
		add(tc, "TC");
		//add(home, "Home");
	}
}

class FirstPagePanel extends JPanel
{
	private GameHolder panelCards;
	private CardLayout cards;
	private Information info;
	private JTextField tfName;
	private Image backgroundImage;
	
	public FirstPagePanel(GameHolder panelCardsIn, CardLayout cardsIn, Information infoIn)
	{
		panelCards = panelCardsIn;
		cards = cardsIn;
		info = infoIn;
		
		//load the background image
		try 
		{
			backgroundImage = ImageIO.read(new File("frontbackground.jpg"));
		} 
		catch(IOException e) 
		{
			System.out.println("Error: 'frontbackground.jpg' not found.");
		}
		
		//use null layout 
		setLayout(null);
		
		//make JLabel title
		JLabel titleLabel = new JLabel("BioBase", SwingConstants.CENTER);
		titleLabel.setFont(new Font("Monospaced", Font.BOLD, 90));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(300, 80, 400, 100);
		add(titleLabel);
		
		// Name Input field
		tfName = new JTextField("enter name");
		tfName.setFont(new Font("Monospaced", Font.PLAIN, 24));
		tfName.setHorizontalAlignment(JTextField.CENTER);
		tfName.setBounds(350, 250, 300, 50);
		add(tfName);
		
		// Start Button
		JButton startBtn = new JButton("");
		startBtn.setFont(new Font("Monospaced", Font.BOLD, 36));
		startBtn.setBounds(350, 380, 300, 80);
		startBtn.setIcon(new ImageIcon("startbutton.jpg")); //use imageIcon library to put an image on the button
		add(startBtn); //add button
		repaint(); //so image shows up
		
		
		startBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String nameInput = tfName.getText().trim();
				// Basic check to ensure a name was entered
				if (!nameInput.isEmpty() && !nameInput.equals("enter name")) 
				{
					info.setName(nameInput);
					cards.show(panelCards, "TC");
				}
				else
				{
					tfName.setBackground(Color.PINK);
				}
			}
		});
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (backgroundImage != null) 
		{
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
		else
		{
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}
}

class TCPanel extends JPanel  //TCPanel is the terms and conditions panel
{
	private GameHolder parent;
	private Information info;
	private CardLayout cards;
	private JLabel welcomeLabel;
	
	public TCPanel(GameHolder parentIn, CardLayout cardsIn, Information infoIn) 
	{
		parent = parentIn;
		info = infoIn;
		cards = cardsIn;
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		//NORTH: Welcome label
		welcomeLabel = new JLabel("Welcome!", SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Monospaced", Font.BOLD, 48));
		add(welcomeLabel, BorderLayout.NORTH);
		
		//CENTER:Text area containing terms and conditions
		JTextArea terms = new JTextArea("hi how are you, this is where the terms and conditions will go, fill this out later");
		terms.setFont(new Font("Monospaced", Font.PLAIN, 24));
		terms.setEditable(false);
		terms.setLineWrap(true);
		
		JScrollPane scrollterms = new JScrollPane(terms);
		add(scrollterms, BorderLayout.CENTER);
		
		//SOUTH: I agree button
		JPanel iagreesouth = new JPanel();
		iagreesouth.setBackground(Color.WHITE);
		
		JButton agreeBtn = new JButton("I AGREE");
		agreeBtn.setFont(new Font("Monospaced", Font.BOLD, 36));
		iagreesouth.add(agreeBtn);
		add(iagreesouth, BorderLayout.SOUTH);
		
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// Update label once the name is captured from FirstPagePanel
		if (info.getName() != null && !welcomeLabel.getText().equals("Welcome " + info.getName())) 
		{
			welcomeLabel.setText("Welcome " + info.getName());
		}
	}
}

class Information
{
	private String name;
	
	public Information()
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
