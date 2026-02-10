//Sanvitti Shah
//Per. 2
//02-10-26
//Ex1A.java
/*
 * Program from graphics notes
 * Makes pink background, writes hello, draws line, yellow triangle, filled arc (sector)
 */
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex1A extends JFrame
{
	public static void main(String [] args)
	{
		Ex1A ex = new Ex1A(); //need to run constructor
	}
	public Ex1A()
	{
		super("Pink Panel in Frame");
		setSize(200,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(400,400);
		setResizable(true);
		Panel pan = new Panel();
		setContentPane(pan);
		setVisible(true);
	}
}
class Panel extends JPanel
{
	public Panel()
	{
		setBackground(Color.PINK);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawString("hello", 50, 100);
		g.drawLine(50,100,100,200);
		g.fillArc(40,10,100,60,-45,90);
		int [] arr1 = {50,100,100};
		int [] arr2 = {100,50,100};
		g.setColor(Color.YELLOW);
		g.drawPolygon(arr1, arr2, 3);
	}
}
