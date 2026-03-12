//Sanvitti Shah
//Per 2.
//03-10-26
/*Pillsbury2.java
 * A panel in which a button is used to make the panel giggle.
 * Pillsbury Dough Boy - poke his belly ad he giggles.
 * User interacts with a button labeled "press my belly." Upon pressing, "tee hee" 
 * is drawn and the button gets relabled to "reset." Upon pressing, ,screen refreshes
 * and the text goes away, button goes back to "press my belly."
 * 
 * This has a seperate class to handle the button action. 
 * ButtonHandler then implements ActionListener, not the JPanel
 * 
 * This is OUR STANDARD!!!!!!!!!!!
 */
import java.awt.Color;	
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.JFrame;	
import javax.swing.JPanel;

//import libraries for JButton
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pillsbury2
{	
	public static void main( String[] args )
	{
		Pillsbury2 pills2 = new Pillsbury2();
		pills2.runIt();
	}
	
	public Pillsbury2()
	{
	}
	
	public void runIt()
	{
		JFrame frame = new JFrame("Pillsbury Dough Boy");
		frame.setSize( 400, 300);				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setLocation(400,50);
		frame.setResizable(true);
		PillsburyP2 pillsPanel2 = new PillsburyP2(); 		
		frame.getContentPane().add( pillsPanel2 );	
		frame.setVisible(true);		
	}
}


class PillsburyP2 extends JPanel 
{
	private boolean pressed;
	private JButton button;
	private Font font;
	
	public PillsburyP2()
	{
		pressed = false;
		font = new Font("Serif", Font.BOLD,30);
		button = new JButton("Press my belly.");		//construct button
		ButtonHandler bhandler = new ButtonHandler();	//this is so the 
						//actionPerformed is dedicated to this button only
		button.addActionListener(bhandler);
		add(button); 	//add button to panel(Pillsbury2)
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setFont(font);
		if(pressed)
		{
			g.drawString("tee hee", 100, 100);
		}
	}
	
	class ButtonHandler implements ActionListener	//nested ot have access to button
	{
		public void actionPerformed(ActionEvent evt)	//but doesn't need to be nested, you
		{
			String command = evt.getActionCommand();	//could take this class out and pass in
			if(command.equals("Press my belly."))		//the button as a parameter
			{
				pressed = true;
				button.setText("reset");
			}
			else
			{
				button.setText("Press my belly.");
				pressed = false;
			}
			repaint();
		}
	}	//end class ButttonHandler
}
