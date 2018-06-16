
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Iwona Górska
 * @see client
 * This class shows a little information about how to use my aplication.
 */
  class ShortHelp implements ActionListener
  {
	  public String longMessage = "Aby zobaczyæ wykres funkcji, \n"
			  + "nale¿y wybraæ rodzaj wykresu \n"
			  + "i wprowadziæ odpowiednie wspó³czynniki \n"
			  + "b¹dŸ wspo³rzêdne punktów. \n"
			  + "Kolejne dane nie s¹ wymagane. \n"
	      	  //+ "wspó³rzêdne chce siê dodaæ do wykresu,\n"
	      	  //+ "nastêpnie klikn¹æ przycisk -Add points- \n"
	      	  //+ "i wprowadziæ wymagane dane: x,y.\n"
	      	  + "Mo¿na rówwnie¿ wybraæ z listy kolor, \n"
	      	  + "jaki ma mieæ linia wykresu lub,\n"
	      	  + "jeœli koloru nie ma na liœcie,\n"
	      	  + "wybraæ go z kolorów niestandardowych.\n";
	      	  //+ "Nastêpnie w polu tekstowym wprowadziæ\n"
	      	  //+ "nazwê dla wykresu.\n";
      	   
	  
	  JFrame frame;
	  
	  /**
	   * 
	   * @param frame - the main frame from class client
	   */
	  
	  public ShortHelp(JFrame frame)
	  {
		  this.frame = frame;
	  }
	  
	  /**
	   * This method uses showMessageDialog and scrollPane 
	   */
	  
	  public void actionPerformed(ActionEvent e)
		{
		  // utworzenie JTextArea
		  JTextArea textArea = new JTextArea(8, 25); //(height, width)
		  textArea.setText(longMessage);
		  textArea.setName("Pomoc");//SAMA ODKRY£AM TÊ METODÊ! NIE BY£O O NIEJ NIC W NECIE XDDDDDDD
		  //Font f = 12px;
		  int fontSize = 12;
		  textArea.setFont(new Font("Helvetica", Font.BOLD, fontSize));
		  textArea.setEditable(false);
		  
		  // wrap a scrollpane around it
		  JScrollPane scrollPane = new JScrollPane(textArea);
		  
		  // display them in a message dialog
		  JOptionPane.showMessageDialog(frame, scrollPane);//w kolejnych argumentach powinno siê móc 
		  //dodaæ m.in. tytu³ okna, ale nie pozwala kompilator chyba przez tego scrolla
		  
		  //JOptionPane.showConfirmDialog(frame, scrollPane, "Pomoc");
		}
  }
//}
