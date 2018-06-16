import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JProgressBar;

/**
 * @see client
 * @author Iwona Górska
 * This class implements sending information about needed chart to the server. Is alive after clicking on the button "Zobacz" 
 * of main window of class client. Uses java programming network.
 *
 */
public class Sending implements ActionListener, Serializable
{
	public static final int PORT = 8080;
    static final String ADDRESS="127.0.0.1";
   
    /**
     * 
     * @throws IOException
     * @throws ClassNotFoundException
     * This method uses ObjectInputStream and ObjectOutputStream to send and receive an object - object of class Data.
     * In the end it create a chart and presents it in new window.
     */
    public void send() throws IOException, ClassNotFoundException
    {
    	InetAddress addr = InetAddress.getByName(ADDRESS);
        Socket socket = new Socket(addr, PORT);
        
        System.out.println("Zyje");
        
        //BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream()));
        //PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter( socket.getOutputStream())),true);
        ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
        
       
        Data D = null;//sztuccznie tylko dajê null, ¿eby nie krzycza³o, ¿e nie widzi inicjalizacji, bo ona jest w ifie
        //i gdyby nie to, musia³abym ca³y kod upchn¹æ do ifów a przecie¿ od po³owy jest taki sam dla obu, to po co
        
        if((String)client.kindChooser.getSelectedItem()=="Inna")
        {
        	//D = new Data((int)client.sp.getValue(), (String)client.cb.getSelectedItem(), client.titleChart.getText(), client.titleX.getText(), client.titleY.getText(), MoreColours.color, (String)client.kindChooser.getSelectedItem());
        	D = new Data((int)client.sp.getValue(), (String)client.cb.getSelectedItem(), client.titleChart.getText(), client.titleX.getText(), client.titleY.getText(), client.colourButton.getBackground(), (String)client.kindChooser.getSelectedItem());
   		
        	
            switch((int)client.sp.getValue())
             	{
             		//w odwrotnej kolejnoœci musi byæ, ¿eby wykorzystaæ to, ¿e bez break po case'ie 
                 	//wykona siê wszystko, co poni¿ej te¿, tylko odczytywaæ serwer te¿ bêdzie 
                 	//odwrotnie, wiêc musi sobie to poprzek³adaæ 
             	    case 10: {D.x10=Double.parseDouble(Points.x10.getText()); D.y10=Double.parseDouble(Points.y10.getText());}; // bez break'ów, ¿eby w³aœnie te poni¿ej te¿ siê wykonywa³y
             		case 9: {D.x9=Double.parseDouble(Points.x9.getText()); D.y9=Double.parseDouble(Points.y9.getText());};
             		case 8: {D.x8=Double.parseDouble(Points.x8.getText()); D.y8=Double.parseDouble(Points.y8.getText());};
             		case 7: {D.x7=Double.parseDouble(Points.x7.getText()); D.y7=Double.parseDouble(Points.y7.getText());};
             		case 6: {D.x6=Double.parseDouble(Points.x6.getText()); D.y6=Double.parseDouble(Points.y6.getText());};
             		case 5: {D.x5=Double.parseDouble(Points.x5.getText()); D.y5=Double.parseDouble(Points.y5.getText());};
             		case 4: {D.x4=Double.parseDouble(Points.x4.getText()); D.y4=Double.parseDouble(Points.y4.getText());};
             		case 3: {D.x3=Double.parseDouble(Points.x3.getText()); D.y3=Double.parseDouble(Points.y3.getText());};
             		case 2: {D.x2=Double.parseDouble(Points.x2.getText()); D.y2=Double.parseDouble(Points.y2.getText());};
             		case 1: {D.x1=Double.parseDouble(Points.x1.getText()); D.y1=Double.parseDouble(Points.y1.getText());};
             		//default niepotrzebne
             	}

        }
        
        if(!client.kindChooser.getSelectedItem().equals("Inna") && !client.kindChooser.getSelectedItem().equals("--"))
        {
        	if(client.kindChooser.getSelectedItem().equals("f(x)=a*x^3+b*x^2+c*x+d=0"))
        	{
        		D = new Data( (String)client.cb.getSelectedItem(), client.titleChart.getText(), client.titleX.getText(), client.titleY.getText(), client.colourButton.getBackground(), Double.parseDouble(client.TextA.getText()), Double.parseDouble(client.TextB.getText()), Double.parseDouble(client.TextC.getText()), Double.parseDouble(client.TextD.getText()),  (String)client.kindChooser.getSelectedItem());
        	}
        	else
        	{
        		if(client.kindChooser.getSelectedItem().equals("f(x)=a*x^2+b*x+c=0"))
           		 //D = new Data( (String)client.cb.getSelectedItem(), client.titleChart.getText(), client.titleX.getText(), client.titleY.getText(), MoreColours.color, Double.parseDouble(client.TextA.getText()), Double.parseDouble(client.TextB.getText()), Double.parseDouble(client.TextC.getText()), (String)client.kindChooser.getSelectedItem());
        			D = new Data( (String)client.cb.getSelectedItem(), client.titleChart.getText(), client.titleX.getText(), client.titleY.getText(), client.colourButton.getBackground(), Double.parseDouble(client.TextA.getText()), Double.parseDouble(client.TextB.getText()), Double.parseDouble(client.TextC.getText()),1, (String)client.kindChooser.getSelectedItem());
         	        	 
        		else
           		 //tu zamiast c przeka¿ê 1, tak tylko, ¿eby nie stwarzaæ trzeciego konstruktora 
           		 //i ¿eby nie by³o b³êdu, ¿e c nie istnieje, ¿e pole by³o dla usera nieaktywne do wprowadzenia c 
           		 //D = new Data( (String)client.cb.getSelectedItem(), client.titleChart.getText(), client.titleX.getText(), client.titleY.getText(), MoreColours.color, Double.parseDouble(client.TextA.getText()), Double.parseDouble(client.TextB.getText()), 1, (String)client.kindChooser.getSelectedItem());
           		 D = new Data( (String)client.cb.getSelectedItem(), client.titleChart.getText(), client.titleX.getText(), client.titleY.getText(), client.colourButton.getBackground(), Double.parseDouble(client.TextA.getText()), Double.parseDouble(client.TextB.getText()), 1,1, (String)client.kindChooser.getSelectedItem());

        	}
        	
        	
        }
		
		
         
        /*try {
			outToServer.writeObject(D);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
        
        try
        {          
        	outToServer.writeObject(D);
        	//pobieranie wykresu z serwera i rzutowanie z Object na JFreeChart
            JFreeChart lineGraph = null;
			try 
			{
				Data DD=(Data)inFromServer.readObject();
				lineGraph = DD.lineGraph;
			} catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("nie dosz³y dane");
			}
			
           // WYSWIETLANIE WYKRESU W OKNIE SWING 
           // Tworzenie okienka Swing: 
            JFrame jframe = new JFrame("Przygotowany wykres");
            jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
            //jframe.getContentPane().setLayout(new GridLayout( 2,2));
            /////jframe.setSize(640,480);
            jframe.setLocation(300,70);
            jframe.setBackground(new Color(255,248,220));
            
            // Dodawanie wykresu przy pomocy klasy ChartPanel
            ChartPanel chartPanel = new ChartPanel(lineGraph);
            jframe.getContentPane().add(chartPanel);
            
            //client.progressBar.setValue(client.progressBar.getValue()+5);
            
            //Metoda pack() ustala rozmiar okna tak, aby mieœci³y siê w nim wszystkie widoczne komponenty. Rozmiar okna mo¿na 
            //równie¿ okreœliæ samemu przy pomocy metody setSize(int szerokoœæ, int wysokoœæ). 
            jframe.pack();
            jframe.setVisible(true); 
            
            
        }
        finally
        {
            socket.close();
        }
    }

    /**
     * Call send() and catch exceptions.
     */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try {
			send();
			 
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("b³¹d 1 w Sending z³apany.");
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("b³¹d 2 w Sending z³apany.");
			e1.printStackTrace();
		}
	}
}
