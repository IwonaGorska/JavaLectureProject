
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Iwona G�rska
 * @see client
 * This class shows a little information about how to use my aplication.
 */
  class ShortHelp implements ActionListener
  {
	  public String longMessage = "Aby zobaczy� wykres funkcji, \n"
			  + "nale�y wybra� rodzaj wykresu \n"
			  + "i wprowadzi� odpowiednie wsp�czynniki \n"
			  + "b�d� wspo�rz�dne punkt�w. \n"
			  + "Kolejne dane nie s� wymagane. \n"
	      	  //+ "wsp�rz�dne chce si� doda� do wykresu,\n"
	      	  //+ "nast�pnie klikn�� przycisk -Add points- \n"
	      	  //+ "i wprowadzi� wymagane dane: x,y.\n"
	      	  + "Mo�na r�wwnie� wybra� z listy kolor, \n"
	      	  + "jaki ma mie� linia wykresu lub,\n"
	      	  + "je�li koloru nie ma na li�cie,\n"
	      	  + "wybra� go z kolor�w niestandardowych.\n";
	      	  //+ "Nast�pnie w polu tekstowym wprowadzi�\n"
	      	  //+ "nazw� dla wykresu.\n";
      	   
	  
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
		  textArea.setName("Pomoc");//SAMA ODKRY�AM T� METOD�! NIE BY�O O NIEJ NIC W NECIE XDDDDDDD
		  //Font f = 12px;
		  int fontSize = 12;
		  textArea.setFont(new Font("Helvetica", Font.BOLD, fontSize));
		  textArea.setEditable(false);
		  
		  // wrap a scrollpane around it
		  JScrollPane scrollPane = new JScrollPane(textArea);
		  
		  // display them in a message dialog
		  JOptionPane.showMessageDialog(frame, scrollPane);//w kolejnych argumentach powinno si� m�c 
		  //doda� m.in. tytu� okna, ale nie pozwala kompilator chyba przez tego scrolla
		  
		  //JOptionPane.showConfirmDialog(frame, scrollPane, "Pomoc");
		}
  }
//}
