import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

/**
 * 
 * @author Iwona Górska
 * @see client
 * The class creates a new window where user can choose color of the line for his chart.
 */
public class MoreColours  /*extends JFrame*/ implements ActionListener
{
	public Container c;
	static Color color;
	
	/**
	 * 
	 * @param c 
	 * Typical constructor
	 */
	public MoreColours(Container c) 
	{
		this.c = c;
	}
	
	/**
	 * The method sets parameters and takes the color which is chosen by user to later work. 
	 */
	public void actionPerformed(ActionEvent e) 
	{    
		Color initialcolor = Color.BLACK;    
		//Color color = JColorChooser.showDialog(c,"Wybierz kolor",initialcolor);
		color = JColorChooser.showDialog(c,"Wybierz kolor",initialcolor);
		client.colourButton.setBackground(color); 
		//c.setBackground(color);    
	}
	
	/*public void setColour(JButton button) 
	{    
		   
		button.setBackground(color);    
	}*/
		    
	public static void main(String[] args) 
	{    
	    /*MoreColours ch=new MoreColours();    
	    ch.setSize(400,400);    
	    ch.setVisible(true);    
	    ch.setDefaultCloseOperation(EXIT_ON_CLOSE);  */  
	}    
	
}
