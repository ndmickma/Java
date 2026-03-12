//Sanvitti Shah\
//3-12-26
//Per 2
//Pills2Panel.java

/*This program:
 * 	1. This has a button handler class to respond to the action.
 * 	2. Two panels are added to one panel, which is added to the frame.
 * 	3. The panels use common info
 * 	4. The button is added to the panel which has the default FlowLayout
 *  5. Try different layouts
 */
 
 //This assues we already did Pillsbury. Imports on same line have already been done.
 
import java.awt.Color; 	import java.awt.Graphics; 	import java.awt.Font;
import java.awt.Dimension; 	//add in this library to set size of button for null layout

///////// add Classes needed for Layouts ///////////////
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame; 	import javax.swing.JPanel;

/////////////
//1. import libraries for JButton
import javax.swing.JButton;  import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pillsbury2Panel
{
	public static void main(String [] args)
	{
		Pillsbury2Panel p2P = new Pillsbury2Panel();
		p2P.runIt();
	}
	
	public void runIt()
	{
		JFrame frame = new JFrame("Pillsbury Dough Boy");
		frame.setSize(400,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(400,50);
		frame.setResizable(true);
		Pills2Panel pills2Panel = new Pills2Panel();
		frame.setContentPane().add(pills2Panel);
		frame.setVisible(true);
	}
}

class Pills2Panel extends JPanel
{
	private drawPanel drawP;
	private PressPanel pressP;
	private boolean pressed;
	
	public Pills2Panel()
	{
		setLayout(new GridLayout(1,2));
		pressP = new PressPanel();
		add(pressP);
		drawP = new DrawPanel();
		add(drawP);
	}
}

public class PressPanel extends JPanel
{
	private JButton button;
	
	public PressPanel()
	{
		
	}
}
