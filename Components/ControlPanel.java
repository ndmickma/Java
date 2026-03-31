// Sanvitti Shah
//Per 2.
// 03-17-26
// SneezePanels.java
/*  IDEA of this program:  PanelHolder, which is added to the frame, holds two panels,
LeftPanel and RightPanel, which are added to PanelHolder in a GridLayout. The 
LeftHolder has a BorderLayout and has two panels-a direction panel, with a FlowLayout 
that has a the button, and a textField panel that contains the textField.  When
the button is pressed, Achoo and a yellow oval are drawn on the Right Panel.  
When the user types in "Bless you" in the textField, the RightPanel is erased
and variables are reset.
*/
/// Testing:  Only clicking on the button will draw on the right panel.  Only typing 
/// in "Bless you" will clear it.
/// Try clicking anywhere other that the button.  This should will not change anything.  
/// Typing anything other than "Bless you" will not reset the panels.

import java.awt.event.ActionListener;	
import java.awt.event.ActionEvent;

import javax.swing.JFrame;	
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;		
import java.awt.Graphics;
import java.awt.Font;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class SneezePanels
{	
	public static void main( String[] args )
	{
		SneezePanels sp = new SneezePanels();
		sp.run();
	}
	
	public SneezePanels()
	{	
	}

	public void run()
	{
		JFrame sneezeFrame = new JFrame ("Sneeze and Bless you.");
		
		sneezeFrame.setSize( 600, 400);				
		sneezeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		sneezeFrame.setLocation(400,50);
		sneezeFrame.setResizable(true);
		PanelHolder pHolder = new PanelHolder(); 
		sneezeFrame.add( pHolder );		

		sneezeFrame.setVisible(true);	
	}

// This panel holds two panels-one on the left and one on the right, aptly named
class PanelHolder extends JPanel
{
	private RightPanel rp;	// these are field variables so the nested classes have access to them
	private boolean nosePressed;	// otherwise, we have to use getter-setter methods
	private Font font;
	
	public PanelHolder()
	{
		setLayout( new GridLayout(1, 2) );
		nosePressed = false;
		font = new Font("Serif", Font.BOLD, 20);

		LeftPanel lp = new LeftPanel();
		add(lp);
		rp = new RightPanel();
		add( rp );
	}

	// This panel will have a BorderLayout
	//  It will have the directions panel in the center, and the 
	// textField panel in the south. 
	class LeftPanel extends JPanel
	{	
		public LeftPanel()
		{	
			setLayout(new BorderLayout());
		
			DirectionPanel dirP = new DirectionPanel (); //panel that has directions
			TFPanel tfp = new TFPanel(); //text field panel
			
			add ( dirP, BorderLayout.CENTER );
			add ( tfp, BorderLayout.SOUTH );
		}
	
	}
	
	// DirectionPanel will print the directions and contain the 
	// nose button.  It has a FlowLayout.  It will use a 
	// ButtonHandler for actionPerformed.
 	class DirectionPanel extends JPanel
 	{
		private JButton nosebutton;
 		public DirectionPanel()
 		{
			Color blueish = new Color(197,227,237);
			setBackground(blueish);
			setLayout(new FlowLayout(FlowLayout.CENTER,0,80));
			nosebutton = new JButton("Nose");
			Button1Handler b1h = new Button1Handler();
			nosebutton.addActionListener(b1h);
			add(nosebutton);
		
		}	
 		
 		public void paintComponent( Graphics g )
 		{
			super.paintComponent(g);
			setFont(font);
			g.setColor(Color.BLACK);
			g.drawString("Directions: Press button ",40,30);
			g.drawString("to tickle the nose", 55,55);
			 
		}
 	}

	// The TFPanel will have a FlowLayout and contain a text field
	// that will be on the left.  It uses a handler class for 
	// actionPerformed
 	class TFPanel extends JPanel
 	{
		JTextField tf;
 		public TFPanel()
 		{
			Color greenish = new Color(222,232,201);
			setBackground(greenish);
			setLayout(new FlowLayout(FlowLayout.LEFT));
			tf = new JTextField("Type: Bless you.",20);
			TextFieldHandler tfh = new TextFieldHandler();
			tf.addActionListener(tfh);
			add(tf);
 		}
 	}
 	
	// The RightPanel is used to draw "Achoo" and a yellow oval when the
	// button is pressed and cleared when "Bless you" is typed in
	// the textField
 	class RightPanel extends JPanel
 	{
 		public RightPanel()
 		{
			Color pinkish = new Color(245,227,225);
			setBackground(pinkish);
 		}
 		
 		public void paintComponent(Graphics g)
 		{
			super.paintComponent(g);
			if(nosePressed)
			{
				g.setFont(font);
				g.setColor(Color.YELLOW);
				g.fillOval(100,80,90,110);
				
				g.setColor(Color.BLACK);
				g.drawString("Achoo!", 110,40);
			}
		}

 	}

	// When the button is pressed, the method actionPerformed is 
	// used to call paintComponent in RightPanel
 	class Button1Handler implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			String command = e.getActionCommand();
			if(command.equals("Nose"))
			{
				nosePressed = true;
				rp.repaint();
			}
		}
	}	// end class Button1Handler	

	// When the user types in "Bless you" in the textField, the 
	// boolean is reset	and RightPanel's paintComponent is called
	class TextFieldHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			String text = e.getActionCommand();
			if(text.equals("Bless you"))
			{
				nosePressed = false;
				rp.repaint();
			}
		}
	}	// end class TextFieldHandler
}
}
