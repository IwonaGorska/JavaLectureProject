import java.awt.*;
import java.awt.image.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.sun.corba.se.impl.orbutil.ObjectWriter;

//import boxlayouttutorial.BoxLayoutTutorialFrame;

import java.net.*; 
import java.io.*;    //biblioteki potrzebne klientowi do komunikacji z serwerem 
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * 
 * @author Iwona G�rska
 * The class represents the main window of the application. 
 *
 */
public class client extends JFrame implements Serializable
{ 
	private static final int MIN_VAL = 2;
    private static final int MAX_VAL = 10;
    
    //public static final int PORT = 8080;
    //static final String ADDRESS="127.0.0.1";
    
    Container mainPanel;
    static JSpinner sp;
    //boolean pointsAdded;
    public static JButton seeButton, buttonOK, colourButton, buttonAdd;
    static JComboBox cb, kindChooser;
    static JTextField titleX, titleY, titleChart, TextA, TextB, TextC, TextD;
    JFormattedTextField number;
    JLabel greyLabel, numberLabel;
     //boolean isYet;//w initComponents dostanie false na wej�cie, a gdy utworzy si� okno dodawania
    //punkt�w, dostanie true, �eby by�o wiadomo, �e by�o ju� otwarte i �eby po klikni�ciu na 
    //przycisk nie tworzy� nowych, tylko te otwiera�, u�ywa� tego samego ca�y czas i mie�
    //wci�� te same dane w nim wprowadzone, mie� podgl�d na nie po pnownym otworzeniu
	JLabel letterA,letterB, letterC, letterD;
	
    //static ObjectOutputStream outToServer;
    
	/**
	 * constructor
	 */
	public client()
	{
		super("Wykresy R->R");// lub setTitle("Wykresy R->R");
		initComponents();
		
	}
	
	/**
	 * 
	 * @param c 
	 * The method can discover or cover the borders between rows
	 */
	void setDebugBorder(JComponent c)
    {
        //Odkomentowac, zeby widziec granice
        //c.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }
	
	/**
	 * 
	 * @param c - main component 
	 * @param width 
	 * @param height
	 */
	void setPrefferedMaxAndMinSize(Component c, int width, int height)
    {
        Dimension rozmiar = new Dimension(width, height);
        c.setPreferredSize(rozmiar);
        c.setMaximumSize(rozmiar);
        c.setMinimumSize(rozmiar);
    }
	
	/**
	 * Method adds rows and sets Layout and Background color, size etc
	 */
	private void initComponents() 
	{
		setLocation(300,20);
		//setLocationRelativeTo(null);// centrowanie na pulpicie
		//this.setIconImage(new ImageIcon("wykresliniowy.png").getImage());//!!!!!!!!!! nie dzia�a
		//setForeground(Color.green); //nie dzia�a!!!!!!
		//isYet=false;
		
		/*GirdLayout gird = new GirdLayout();
		client.setLayout(gird);*/ //nie implementujesz interfejsu LayoutManager, dlatego wyrzuca b��d	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
        
        //Container mainPanel = getContentPane();
		mainPanel = getContentPane();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(255,248,220));
        
        //mainPanel.setForeground(Color.green);//nie dzia�a!!!!!!!!!!!!!!!
       

        mainPanel.add(getRow1());
        mainPanel.add(getRow2());
        mainPanel.add(getRow3());
        mainPanel.add(getRow4());
        mainPanel.add(getRow5());
        mainPanel.add(getRow6());
        mainPanel.add(getRow7());
        mainPanel.add(getRow8());
        mainPanel.add(getRow9());
        mainPanel.add(getRow10());
        mainPanel.add(getRow11());
        mainPanel.add(getRow12());
        mainPanel.add(getRow13());
        mainPanel.add(getRow14());
        mainPanel.add(getRow15());
        // Sprezynka, zeby guziki byly zawsze na dole
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(getRow16());
        mainPanel.add(getRow17());
       
        //z ikonk� zamiast kubka javy zr�b tak jak w przyk�adzie 10A z labork�w
        
        setSize(750,650);//width, height
        
    }
	
	/** 
	 * 
	 * @param height
	 * @return prepared here box of type Box
	 */
	private Box getBox(int height)
    {
        Box box = Box.createHorizontalBox();
        //box.setForeground(Color.green);//te� nie dzia�a
        setPrefferedMaxAndMinSize(box, 4096, height);
        setDebugBorder(box);
        return box;
    }
	
	/**
	 * 
	 * @return vertical strut
	 */
	private Component  getRow1()
    {
        return Box.createVerticalStrut(10);
    }

	//rozporki (struts) oraz spr�yny (glue)
	/**
	 * 
	 *  @return prepared here box of type Box
	 */
	private Component  getRow2()//tu dodaj wybor rodzaju wykresu
    {
        Box box = getBox(23);
        buildRow2(box);
        return box;
    }
    
	/**
	 * 
	 * @return vertical strut
	 */
    private Component  getRow3()
    {
       return  Box.createVerticalStrut(78);
    }
	
    /**
	 * 
	 *  @return prepared here box of type Box
	 */
	private Component  getRow4()
    {
        Box box = getBox(23);
        buildRow4(box);
        return box;
    }

	/**
	 * 
	 *  @return prepared here box of type Box
	 */
	private Component  getRow5()
    {
        Box box = getBox(31);
        buildRow5(box);
        return box;
    }

	/**
	 * 
	 *  @return prepared here box of type Box
	 */
    private Component  getRow6()
    {
        Box box = getBox(23);
        buildRow6(box);
        return box;
    }
    
    /**
	 * 
	 * @return vertical strut
	 */
    private Component  getRow7()
    {
       return  Box.createVerticalStrut(78);
    }
    
    /**
	 * 
	 *  @return prepared here box of type Box
	 */
    private Component  getRow8()
    {
        Box box = getBox(30);
        buildRow8(box);
        return box;
    }
    
    /**
	 * 
	 * @return vertical strut
	 */
    private Component getRow9()
    {
       return  Box.createVerticalStrut(78);
    }
    
    /**
	 * 
	 *  @return prepared here box of type Box
	 */
    private Component getRow10()
    {
        Box box = getBox(30);
        buildRow10(box);
        return box;
    }
    
    /**
	 * 
	 *  @return prepared here box of type Box
	 */
    private Component  getRow11()
    {
        Box box = getBox(30);
        buildRow11(box);
        return box;
    }
    
    /**
	 * 
	 *  @return prepared here box of type Box
	 */
    private Component  getRow12()
    {
        Box box = getBox(30);
        buildRow12(box);
        return box;
    }

    /**
	 * 
	 * @return vertical strut
	 */
    private Component  getRow13()
    {
       return  Box.createVerticalStrut(28);
    }
    
    /**
	 * 
	 *  @return prepared here box of type Box
	 */
    private Component  getRow14()
    {
        Box box = getBox(30);
        buildRow14(box);
        return box;
    }

    /**
	 * 
	 * @return vertical strut
	 */
    private Component  getRow15()
    {
       return  Box.createVerticalStrut(28);
    }
    
    /**
	 * 
	 *  @return prepared here box of type Box
	 */
    private Component  getRow16()
    {
        Box box = getBox(30);
        buildRow16(box);
        return box;
    }

    /**
	 * 
	 * @return vertical strut
	 */
    private Component  getRow17()
    {
       return  Box.createVerticalStrut(28);
    }
   
    /**
     * 
     * @param panel
     * This method builds JComboBox, where user should choose the kind of chart.  According to this choose, 
     * method set enabled appropriate components of another rows.
     */
    private void buildRow2(JComponent panel) 
    {
    	panel.add(Box.createHorizontalStrut(30));//pozioma rozp�rka - szeroko�� wolna od brzegu
    	JLabel kindChooserLab=new JLabel(" Rodzaj funkcji: ");
    	setPrefferedMaxAndMinSize(kindChooserLab, 170, 70);
        panel.add(kindChooserLab);
        
        /*JComboBox kindChooser=new JComboBox();
        kindChooser.addItem("f(x)=a*sin(bx)=0");
        kindChooser.addItem("f(x)=a*cos(bx)=0");
        kindChooser.addItem("f(x)=a*x^2+b*x+c=0");
        kindChooser.addItem("f(x)=a*x+b=0");
        kindChooser.addItem("Inna");*/
        kindChooser=new JComboBox(new Object[]{"--","f(x)=a*sin(bx)=0","f(x)=a*cos(bx)=0","f(x)=a*x^2+b*x+c=0", "f(x)=a*x^3+b*x^2+c*x+d=0", "f(x)=a*x+b=0","Inna"} );
        kindChooser.setPreferredSize(new Dimension(70, 70));
        kindChooser.setBackground(Color.white);
        panel.add(kindChooser);
        
        kindChooser.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent e) 
        	{
        		
        		if((String)kindChooser.getSelectedItem()=="--")
        		{
        			letterA.setEnabled(false);
        			letterB.setEnabled(false);
        			letterC.setEnabled(false);
        			TextA.setEnabled(false);
        			TextB.setEnabled(false);
        			TextC.setEnabled(false);
        			TextA.setText("");//czyszczenie p�l
        			TextB.setText("");
        			TextC.setText("");
        			numberLabel.setEnabled(false);
        			sp.setEnabled(false);
        			number.setEnabled(false);
        			buttonAdd.setEnabled(false);
        			buttonOK.setEnabled(false);
        		}
        		else
        		{
        			if((String)kindChooser.getSelectedItem()=="Inna")
            		{
        				letterA.setEnabled(false);
            			letterB.setEnabled(false);
            			letterC.setEnabled(false);
            			TextA.setEnabled(false);
            			TextB.setEnabled(false);
            			TextC.setEnabled(false);
            			TextA.setText("");
            			TextB.setText("");
            			TextC.setText("");
            			numberLabel.setEnabled(true);
            			sp.setEnabled(true);
            			number.setEnabled(true);
            			buttonAdd.setEnabled(true);
            			buttonOK.setEnabled(false);
            		}
            		else
            		{
            			if((String)kindChooser.getSelectedItem()=="f(x)=a*x^3+b*x^2+c*x+d=0")
            			{
            				letterA.setEnabled(true);
                			letterB.setEnabled(true);
                			letterC.setEnabled(true);
                			letterD.setEnabled(true);//d tylko przy sze�ciennej si� podaje
                			TextA.setEnabled(true);
                			TextB.setEnabled(true);
                			TextC.setEnabled(true);
                			TextD.setEnabled(true);
                			TextA.setText("");
                			TextB.setText("");
                			TextC.setText("");
                			TextD.setText("");
                			numberLabel.setEnabled(false);
                			sp.setEnabled(false);
                			number.setEnabled(false);
                			buttonAdd.setEnabled(false);
                			buttonOK.setEnabled(true);
            			}
            			else
            			{
            				if((String)kindChooser.getSelectedItem()=="f(x)=a*x^2+b*x+c=0")
                			{
                				letterA.setEnabled(true);
                    			letterB.setEnabled(true);
                    			letterC.setEnabled(true);
                    			letterD.setEnabled(false);
                    			TextA.setEnabled(true);
                    			TextB.setEnabled(true);
                    			TextC.setEnabled(true);//c tylko przy kwadratowej si� podaje
                    			TextD.setEnabled(false);
                    			TextA.setText("");
                    			TextB.setText("");
                    			TextC.setText("");
                    			TextD.setText("");
                    			numberLabel.setEnabled(false);
                    			sp.setEnabled(false);
                    			number.setEnabled(false);
                    			buttonAdd.setEnabled(false);
                    			buttonOK.setEnabled(true);
                			}
                			else
                			{
                				letterA.setEnabled(true);
                    			letterB.setEnabled(true);
                    			letterC.setEnabled(false);
                    			letterD.setEnabled(false);
                    			TextA.setEnabled(true);
                    			TextB.setEnabled(true);
                    			TextC.setEnabled(false);
                    			TextD.setEnabled(false);
                    			TextA.setText("");
                    			TextB.setText("");
                    			TextC.setText("");
                    			TextD.setText("");
                    			numberLabel.setEnabled(false);
                    			sp.setEnabled(false);
                    			number.setEnabled(false);
                    			buttonAdd.setEnabled(false);
                    			buttonOK.setEnabled(true);
                			} 
            			}
            			
            			
            			        			
            		}
        		}
        		
        	}
        	});
        
        panel.add(Box.createHorizontalStrut(30));//pozioma rozp�rka - szeroko�� wolna od brzegu
        
    }
    
    /**
     * 
     * @param panel
     * Method lets user to key in values of a,b,c or the number of ponts - according to the earlier choose of chart's kind
     */
    private void buildRow4(JComponent panel) 
    {
        
        panel.add(Box.createHorizontalStrut(30));//pozioma rozp�rka - szeroko�� wiersza jakby

        letterA=new JLabel(" a "); 
        letterA.setEnabled(false);
        panel.add(letterA);
        
        TextA =new JTextField();
        setPrefferedMaxAndMinSize(TextA, 40, 23);
        TextA.setEnabled(false);
        panel.add(TextA);
        
        panel.add(Box.createHorizontalStrut(6));
        
        letterB=new JLabel(" b ");
        letterB.setEnabled(false);
        panel.add(letterB);
        
        TextB =new JTextField();
        setPrefferedMaxAndMinSize(TextB, 40, 23);
        TextB.setEnabled(false);
        panel.add(TextB);
        
        panel.add(Box.createHorizontalStrut(6));
        
        letterC=new JLabel(" c ");////wyszarzone, je�li to ma by� funkcja liniowa
        letterC.setEnabled(false);
        panel.add(letterC);
        
        TextC =new JTextField();
        setPrefferedMaxAndMinSize(TextC, 40, 23);
        TextC.setEnabled(false);
        panel.add(TextC);
        
        letterD=new JLabel(" d ");
        letterD.setEnabled(false);
        panel.add(letterD);
        
        TextD =new JTextField();
        setPrefferedMaxAndMinSize(TextD, 40, 23);
        TextD.setEnabled(false);
        panel.add(TextD);
        
        panel.add(Box.createHorizontalStrut(127));
        
        
        
        numberLabel = new JLabel("Podaj liczb� punkt�w:");
        setPrefferedMaxAndMinSize(numberLabel, 140, 90);//tu okre�lasz wielko�� obszaru, w kt�rym ma si� zmie�ci� napis: "Podaj..."
        numberLabel.setEnabled(false);
        panel.add(numberLabel);
        
        sp = new JSpinner();
        sp.setModel(new javax.swing.SpinnerNumberModel(MIN_VAL, MIN_VAL, MAX_VAL, 1));
        //sp.setBackground(new Color(240,230,140));
        sp.setBackground(Color.white);
        sp.setEnabled(false);
        number = ((JSpinner.DefaultEditor)sp.getEditor()).getTextField();
        number.setEditable(false);//a mo�e zmie� na true i te� si� spodoba komu� wpisanie r�czne?
        //lepiej false, bo tak to dziwne rzeczy si� dziej�, gdy kto� wpisze z klawki co� spoza zakresu
        number.setEnabled(false);
        number.setBackground(Color.white);
        setPrefferedMaxAndMinSize(sp, 40, 23);
        panel.add(sp);
        
        panel.add(Box.createHorizontalStrut(15));
     }
    
    /**
     * 
     * @param panel
     * The method lets user to enter the values of a, b and c if c is also needed and check if all necessary text fields are filled.
     * If no, shows the error information and doesn't allow to go further.
     */
    private void buildRow5(JComponent panel) 
    {
    	panel.add(Box.createHorizontalStrut(87));
    	buttonOK = new JButton ("OK");
    	buttonOK.setToolTipText("Zatwerd� warto�ci wsp�czynnik�w");
        setPrefferedMaxAndMinSize(buttonOK, 60, 33);
        buttonOK.setBackground(Color.white);
        buttonOK.setForeground(new Color(218,165,32));
        if((String)kindChooser.getSelectedItem()=="Inna" || (String)kindChooser.getSelectedItem()=="--")
        {
        	buttonOK.setEnabled(false);
        }      
        else
        {
        	buttonOK.setEnabled(true);
        }
        buttonOK.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent e) 
        	{
        		
        		if(  ( (TextA.isEnabled()==true) && (TextA.getText().isEmpty()==true) ) 
        		||   ( (TextB.isEnabled()==true) && (TextB.getText().isEmpty()==true) ) 
        		||   ( (TextC.isEnabled()==true) && (TextC.getText().isEmpty()==true) )
        		||   ( (TextD.isEnabled()==true) && (TextD.getText().isEmpty()==true) )
        		  )
        		{
        			//wy�wietl okno z komunikatem, �e zosta�y takie pola i je zamknij i na czerwono podkre�l t�o tych p�l
        			JOptionPane.showMessageDialog(panel, "Uzupe�nij wszystkie wymagane pola!", "B��d!", JOptionPane.ERROR_MESSAGE);
        			client.seeButton.setEnabled(false);
        		}
        		else
        		{
        			client.seeButton.setEnabled(true);
        		}        		
        	}
        	});
        panel.add(buttonOK);
    	
    	panel.add(Box.createHorizontalStrut(173));
        greyLabel = new JLabel("(Dla tylu punkt�w b�dziesz musia�(a) p�niej wprowadzi� wsp�rz�dne.)");
        greyLabel.setForeground(Color.GRAY);
        greyLabel.setEnabled(false);
        panel.add(greyLabel);
        panel.add(Box.createHorizontalGlue());
    }
    
    /**
     * 
     * @param panel
     * @see Points
     * Method creates button to add points and bring user to a new window concluded with class Points
     */
    private void buildRow6(JComponent panel) 
    {
    	panel.add(Box.createHorizontalGlue());

    	buttonAdd = new JButton("Dodaj punkty");
    	//buttonAdd = new JButton("Add points"); // po klikni�ciu zostanie otworzone okno
        //wprowadzania wsp�rz�dnych kolejnych punkt�w
        //gdy klika na to, to pobierasz aktualn� warto�� ze Spinera, w�a�nie wtedy trzeba zna� warto�� tamt�
        buttonAdd.setToolTipText("Dodaj wsp�rz�dne punkt�w");
        //setPrefferedMaxAndMinSize(buttonAdd, 100, 90);
        setPrefferedMaxAndMinSize(buttonAdd, 115, 90);
        buttonAdd.setBackground(Color.white);
        buttonAdd.setForeground(new Color(218,165,32));
        //colourButton.addActionListener(new ToPoints());
        //Points P = new Points((int)sp.getValue());
        buttonAdd.setEnabled(false);
        buttonAdd.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent e) 
        	{
        		
        		/*if(isYet)
        		{
        			P.numberOfPoints=(int)sp.getValue();//na nowo podajemy, ile ma by� punkt�w
        			P.setEnable();//na nowo ustalamy, kt�re pola s� aktywne, bo mo�e user zmieni� 
        			//ju� liczb�  punkt�w do wprowadzenia       			
        			P.setVisible(true);
        		}
        		else
        		{
        			isYet=true;*/
        			Points P = new Points((int)sp.getValue());
            		P.setEnable();
            		P.setVisible(true);
        		//}
        		
        	}
        	});
        
       panel.add(buttonAdd);

        panel.add(Box.createHorizontalStrut(6));
    }
    
    /**
     * 
     * @param panel
     * Method lets user choose the orientation of the chart
     */
    private void buildRow8(JComponent panel) 
    {
    	panel.add(Box.createHorizontalStrut(30));

        JLabel label = new JLabel("Wybierz orientacj� wykresu:");
        setPrefferedMaxAndMinSize(label, 170, 70);
        panel.add(label);
        
        cb = new JComboBox(new Object[]{"pionowa","pozioma"});
        cb.setPreferredSize(new Dimension(70, 70));
        cb.setBackground(Color.white);
        panel.add(cb);
        
        panel.add(Box.createHorizontalStrut(30));//pozioma rozp�rka - szeroko�� wolna od brzegu
    }
    
    /**
     * 
     * @param panel
     * Keying in the chart's title - not necessary option.
     */
    private void buildRow10(JComponent panel) 
    {
    	panel.add(Box.createHorizontalStrut(30));//pozioma rozp�rka - szeroko�� wiersza jakby

        JLabel label = new JLabel("Podaj tytu� wykresu:");
        setPrefferedMaxAndMinSize(label, 120, 90);//tu okre�lasz wielko�� obszaru, n kt�rym ma si� zmie�ci� napis: "Podaj..."
        panel.add(label);
        
        titleChart = new JTextField();
        titleChart.setEditable(true);//a mo�e zmie� na true i te� si� spodoba komu� wpisanie r�czne?
        setPrefferedMaxAndMinSize(titleChart, 300, 23);
        panel.add(titleChart);
        
        
    }
    
    /**
     * 
     * @param panel
     * Keying in the x axis' title - not necessary option.
     */
    private void buildRow11(JComponent panel) 
    {
    	panel.add(Box.createHorizontalStrut(30));//pozioma rozp�rka - szeroko�� wiersza jakby

        
        JLabel label = new JLabel("Podaj tytu� osi X:");
        setPrefferedMaxAndMinSize(label, 120, 90);//tu okre�lasz wielko�� obszaru, n kt�rym ma si� zmie�ci� napis: "Podaj..."
        panel.add(label);
        
        titleX = new JTextField();
        titleX.setEditable(true);//a mo�e zmie� na true i te� si� spodoba komu� wpisanie r�czne?
        setPrefferedMaxAndMinSize(titleX, 300, 23);
        panel.add(titleX);
        
    }
    
    /**
     * 
     * @param panel
     * Keying in the y axis' title - not necessary option.
     */
    private void buildRow12(JComponent panel) 
    {
    	panel.add(Box.createHorizontalStrut(30));//pozioma rozp�rka - szeroko�� wiersza jakby

        
        JLabel label = new JLabel("Podaj tytu� osi Y:");
        setPrefferedMaxAndMinSize(label, 120, 90);//tu okre�lasz wielko�� obszaru, n kt�rym ma si� zmie�ci� napis: "Podaj..."
        panel.add(label);
        
        titleY = new JTextField();
        titleY.setEditable(true);//a mo�e zmie� na true i te� si� spodoba komu� wpisanie r�czne?
        setPrefferedMaxAndMinSize(titleY, 300, 23);
        panel.add(titleY);
        
    }

    /**
     * 
     * @param panel
     * Changing color is not necessary, default is set black, but user can choose another, if he likes more.
     */
    private void buildRow14(JComponent panel) 
    {
    	panel.add(Box.createHorizontalStrut(30));//pozioma rozp�rka - szeroko�� wiersza jakby
        //panel.add(Box.createVerticalStrut(178));
        
        JLabel label = new JLabel("Wybierz kolor:");
        setPrefferedMaxAndMinSize(label, 120, 90);//tu okre�lasz wielko�� obszaru, n kt�rym ma si� zmie�ci� napis: "Podaj..."
        panel.add(label);
        
        //Container c = getContentPane();
        //JButton button = new JButton("");
        colourButton = new JButton("");
        colourButton.setBackground(Color.black);
        colourButton.setToolTipText("Kliknij, aby zmieni� domy�lny kolor linii wykresu");
        colourButton.addActionListener(new MoreColours(mainPanel));
        
        //MoreColours.setColour(button);
        setPrefferedMaxAndMinSize(colourButton, 170, 70);
        panel.add(colourButton);
       
        panel.add(Box.createHorizontalStrut(15));
    }
    
    
    /**
     * 
     * @param panel
     * Method adds to main panel new buttons and new properties - see ready chart, read help informations and close the window
     */
    private void buildRow16(JComponent panel)
    {
    	panel.add(Box.createHorizontalStrut(30));
    	
    	panel.add(Box.createHorizontalGlue());  	

    	seeButton = new JButton("Zobacz");
        //seeButton = new JButton("See");
        //setPrefferedMaxAndMinSize(seeButton, 60, 24);
    	setPrefferedMaxAndMinSize(seeButton, 82, 24);
        seeButton.setToolTipText("Wy�wietl wykres");
        seeButton.setBackground(Color.white);
        seeButton.setEnabled(false);
        seeButton.setForeground(new Color(32,178,170));
        panel.add(seeButton);
        //po klikni�ciu trzeba zebra� z g��wnego okna informacje o ustawionych 
        //danych dotycz�cych wykresu i wys�a� je na serwer
        
        seeButton.addActionListener(new Sending());
        //progressBar.setVisible(false);
        
 
        panel.add(Box.createHorizontalStrut(6));
        
        JButton button = new JButton("Pomoc");
        //JButton button = new JButton("Help");
        //setPrefferedMaxAndMinSize(button, 60, 24);
        setPrefferedMaxAndMinSize(button, 80, 24);
        button.setToolTipText("Wy�wietl kr�tk� pomoc");
        button.setBackground(Color.white);
        button.setForeground(new Color(50,205,50));
        
        button.addActionListener(new ShortHelp(this));
        panel.add(button);
        
        
        panel.add(Box.createHorizontalStrut(6));

        button = new JButton("Wyj�cie");
        //button = new JButton("Close");
        //setPrefferedMaxAndMinSize(button, 70, 24);
        setPrefferedMaxAndMinSize(button, 85, 24);
        button.setToolTipText("Zamknij okno programu");
        button.setBackground(Color.white);
        button.setForeground(new Color(178,34,34));
        
        button.addActionListener(new CloseWindow()); 
        panel.add(button);

        panel.add(Box.createHorizontalStrut(15));
    }
    
	/**
	 * 	
	 * @param args
	 * main method turn on the class
	 */
	public static void main(String[] args) //throws IOException, ClassNotFoundException
    { 
		SwingUtilities.invokeLater(new Runnable() 
	    {
	        public void run() 
	        {
	            new client().setVisible(true);
	        }
	    });
		
		
    }
}