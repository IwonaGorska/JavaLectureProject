import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * 
 * @author Iwona Górska
 * @see client
 * The class implements the closing of main window of client.
 */
public class CloseWindow  implements ActionListener 
{

	public CloseWindow(){}
	
	/**
	 * This method uses showConfirmDialog with YES_NO_OPTION to help user to close the main window of application.
	 */
	public void actionPerformed(ActionEvent e) 
	{
		int val = JOptionPane.showConfirmDialog(null, "Really exit?", "Really exit?", JOptionPane.YES_NO_OPTION);
//1. argument - okno macierzyste, 2.- tekst komuniatu, 3.- tytu³ okna, 4. - typ okna (przyciski) JOptionPane.YES_NO_OPTION ( YES_NO_CANCEL_OPTION,   OK_CANCEL_OPTION, ...)
		switch(val)
		{
			case JOptionPane.YES_OPTION: 
				System.exit(0);
			case JOptionPane.NO_OPTION: 
				break;
		}
	}
}