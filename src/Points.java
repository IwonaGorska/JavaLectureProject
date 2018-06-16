import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * @see client
 * @author Iwona Górska
 * The class represents new window with text fields where user key in ext points which will the chart consist of
 *
 */
public class Points extends JFrame  
{
	Container pointsPanel;
	
	static JTextField x1, x2, x3, x4, x5, x6, x7, x8, x9, x10;
	static JTextField y1, y2, y3, y4, y5, y6, y7, y8, y9, y10;
	//JTextField x[];
	//JTextField y[];
	public int numberOfPoints;
	
	/**
	 * 
	 * @param nr number of points which user wants to add to the chart
	 * 
	 */
	public Points(int nr)
	{
		super("Dodawanie punktów do wykresu");// lub setTitle("Wykresy R->R");
		initComponents();
		this.numberOfPoints = nr;
		/*for(int j=0; j<numberOfPoints; j++)
		{
			x[j] = new JTextField();
		}
		//x[] = new  JTextField [];
		for(int j=0; j<numberOfPoints; j++)
		{
			y[j] = new JTextField();
		}*/
	}
	
	/**
	 * Method covers or discovers the borders between rows
	 */
	void setDebugBorder(JComponent c)
    {
        //Odkomentowac, zeby widziec granice
        c.setBorder(BorderFactory.createLineBorder(new Color(230,230,250)));
    }
	
	/**
	 * 
	 * @param c component
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
	 * Method adds rows and sets Layout and Background color
	 */
	private void initComponents() 
	{
		setLocation(300,70);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(false);
        		 
		pointsPanel = getContentPane();
		pointsPanel.setLayout(new BoxLayout(pointsPanel, BoxLayout.Y_AXIS));
		pointsPanel.setBackground(new Color(255,248,220));
        
		pointsPanel.add(getRow1());
		pointsPanel.add(getRow2());
		pointsPanel.add(getRow3());
		pointsPanel.add(getRow4());
		pointsPanel.add(getRow5());
		pointsPanel.add(getRow6());
		pointsPanel.add(getRow7());
		pointsPanel.add(getRow8());
		pointsPanel.add(getRow9());
		pointsPanel.add(getRow10());
		pointsPanel.add(getRow11());
		pointsPanel.add(Box.createVerticalGlue());
		pointsPanel.add(getRow12());
		pointsPanel.add(getRow13());
        
        setSize(700,300);    
    }
	
	/** 
	 * 
	 * @param height
	 * @return prepared here box of type Box
	 */
	private Box getBox(int height)
    {
        Box box = Box.createHorizontalBox();
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
        return Box.createVerticalStrut(1);
    }

	/**
	 * 
	 *  @return prepared here box of type Box
	 */
	//rozporki (struts) oraz sprê¿yny (glue)	
    private Component  getRow2()
    {
        Box box = getBox(23);
        buildRow2(box);
        return box;
    }

    /**
     *  @return prepared here box of type Box
     */
	private Component  getRow3()
    {
        Box box = getBox(23);
        buildRow3(box);
        return box;
    }

	/**
	 * 
	 * @return prepared here box of type Box
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
    	Box box = getBox(23);
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
     *  @return prepared here box of type Box
     */
    private Component getRow7()
    {
    	Box box = getBox(23);
        buildRow7(box);
        return box;
    }
    
    /**
     * 
     *  @return prepared here box of type Box
     */
    private Component getRow8()
    {
        Box box = getBox(23);
        buildRow8(box);
        return box;
    }
    
    /**
     * 
     *  @return prepared here box of type Box
     */
    private Component  getRow9()
    {
        Box box = getBox(23);
        buildRow9(box);
        return box;
    }
    
    /**
     * 
     *  @return prepared here box of type Box
     */
    private Component  getRow10()
    {
        Box box = getBox(23);
        buildRow10(box);
        return box;
    }

    /**
     * 
     *  @return prepared here box of type Box
     */
    private Component  getRow11()
    {
    	Box box = getBox(23);
        buildRow11(box);
        return box;
    }
    
    /**
     * 
     *  @return prepared here box of type Box
     */
    private Component  getRow12()
    {
    	Box box = getBox(23);
        buildRow12(box);
        return box;
    }
    
    /**
     * 
     *  @return vertical strut
     */
    private Component  getRow13()
    {
        return  Box.createVerticalStrut(10);
    }

    /**
     * 
     * @param panel main panel where the elements will be set in
     * Method builds place where user can key in data of first point for his chart
     */
    private void buildRow2(JComponent panel) 
    {
        
        panel.add(Box.createHorizontalStrut(30));//pozioma rozpórka - szerokoœæ wiersza jakby

        JLabel label = new JLabel("Wspó³rzêdne pierwszego punktu:");
        setPrefferedMaxAndMinSize(label, 300, 90);//tu okreœlasz wielkoœæ obszaru, na którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
  
        panel.add(Box.createHorizontalStrut(15));
        
        label = new JLabel("x");
        setPrefferedMaxAndMinSize(label, 20, 20);
        panel.add(label);
        
        x1 = new JTextField();
        x1.setEditable(true);
        setPrefferedMaxAndMinSize(x1, 50, 50);
        panel.add(x1);
        
        panel.add(Box.createHorizontalStrut(30));
        
        label = new JLabel("y");
        setPrefferedMaxAndMinSize(label, 20, 20);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
        
        y1 = new JTextField();
        y1.setEditable(true);
        setPrefferedMaxAndMinSize(y1, 50, 50);
        panel.add(y1);
     }
    
    /**
     * 
     * @param panel main panel where the elements will be set in
     * Method builds place where user can key in data of second point for his chart
     */
    private void buildRow3(JComponent panel) 
    {
        
        panel.add(Box.createHorizontalStrut(30));//pozioma rozpórka - szerokoœæ wiersza jakby

        JLabel label = new JLabel("Wspó³rzêdne drugiego punktu:");
        setPrefferedMaxAndMinSize(label, 300, 90);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
  
        panel.add(Box.createHorizontalStrut(15));
        
        label = new JLabel("x");
        setPrefferedMaxAndMinSize(label, 20, 20);
        panel.add(label);
        
        x2 = new JTextField();
        x2.setEditable(true);
        setPrefferedMaxAndMinSize(x2, 50, 50);
        panel.add(x2);
        
        panel.add(Box.createHorizontalStrut(30));
        
        label = new JLabel("y");
        setPrefferedMaxAndMinSize(label, 20, 20);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
        
        y2 = new JTextField();
        y2.setEditable(true);
        setPrefferedMaxAndMinSize(y2, 50, 50);
        panel.add(y2);
     }
    
    /**
     * 
     * @param panel main panel where the elements will be set in
     * Method builds place where user can key in data of third point for his chart
     */
    private void buildRow4(JComponent panel) 
    {
        
        panel.add(Box.createHorizontalStrut(30));//pozioma rozpórka - szerokoœæ wiersza jakby

        JLabel label = new JLabel("Wspó³rzêdne trzeciego punktu:");
        setPrefferedMaxAndMinSize(label, 300, 90);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
  
        panel.add(Box.createHorizontalStrut(15));
        
        label = new JLabel("x");
        setPrefferedMaxAndMinSize(label, 20, 20);
        panel.add(label);
        
        x3 = new JTextField();
        x3.setEditable(true);
        setPrefferedMaxAndMinSize(x3, 50, 50);
        panel.add(x3);
        
        panel.add(Box.createHorizontalStrut(30));
        
        label = new JLabel("y");
        setPrefferedMaxAndMinSize(label, 20, 20);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
        
        y3 = new JTextField();
        y3.setEditable(true);
        setPrefferedMaxAndMinSize(y3, 50, 50);
        panel.add(y3);
     }
    
    /**
     * 
     * @param panel main panel where the elements will be set in
     * Method builds place where user can key in data of forth point for his chart
     */
    private void buildRow5(JComponent panel) 
    {
        
    	panel.add(Box.createHorizontalStrut(30));//pozioma rozpórka - szerokoœæ wiersza jakby

        JLabel label = new JLabel("Wspó³rzêdne czwartego punktu:");
        setPrefferedMaxAndMinSize(label, 300, 90);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
  
        panel.add(Box.createHorizontalStrut(15));
        
        label = new JLabel("x");
        setPrefferedMaxAndMinSize(label, 20, 20);
        panel.add(label);
        
        x4 = new JTextField();
        x4.setEditable(true);
        setPrefferedMaxAndMinSize(x4, 50, 50);
        panel.add(x4);
        
        panel.add(Box.createHorizontalStrut(30));
        
        label = new JLabel("y");
        setPrefferedMaxAndMinSize(label, 20, 20);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
        
        y4 = new JTextField();
        y4.setEditable(true);
        setPrefferedMaxAndMinSize(y4, 50, 50);
        panel.add(y4);
     }
    
    /**
     * 
     * @param panel main panel where the elements will be set in
     * Method builds place where user can key in data of fifth point for his chart
     */
    private void buildRow6(JComponent panel) 
    {
    	panel.add(Box.createHorizontalStrut(30));//pozioma rozpórka - szerokoœæ wiersza jakby

        JLabel label = new JLabel("Wspó³rzêdne pi¹tego punktu:");
        setPrefferedMaxAndMinSize(label, 300, 90);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
  
        panel.add(Box.createHorizontalStrut(15));
        
        label = new JLabel("x");
        setPrefferedMaxAndMinSize(label, 20, 20);
        panel.add(label);
        
        x5 = new JTextField();
        x5.setEditable(true);
        setPrefferedMaxAndMinSize(x5, 50, 50);
        panel.add(x5);
        
        panel.add(Box.createHorizontalStrut(30));
        
        label = new JLabel("y");
        setPrefferedMaxAndMinSize(label, 20, 20);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
        
        y5 = new JTextField();
        y5.setEditable(true);
        setPrefferedMaxAndMinSize(y5, 50, 50);
        panel.add(y5);
    }
    
    /**
     * 
     * @param panel main panel where the elements will be set in
     * Method builds place where user can key in data of sixth point for his chart
     */
    private void buildRow7(JComponent panel) 
    {
    	panel.add(Box.createHorizontalStrut(30));//pozioma rozpórka - szerokoœæ wiersza jakby

        JLabel label = new JLabel("Wspó³rzêdne szóstego punktu:");
        setPrefferedMaxAndMinSize(label, 300, 90);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
  
        panel.add(Box.createHorizontalStrut(15));
        
        label = new JLabel("x");
        setPrefferedMaxAndMinSize(label, 20, 20);
        panel.add(label);
        
        x6 = new JTextField();
        x6.setEditable(true);
        setPrefferedMaxAndMinSize(x6, 50, 50);
        panel.add(x6);
        
        panel.add(Box.createHorizontalStrut(30));
        
        label = new JLabel("y");
        setPrefferedMaxAndMinSize(label, 20, 20);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
        
        y6 = new JTextField();
        y6.setEditable(true);
        setPrefferedMaxAndMinSize(y6, 50, 50);
        panel.add(y6);
    }
    
    /**
     * 
     * @param panel main panel where the elements will be set in
     * Method builds place where user can key in data of seventh point for his chart
     */
    private void buildRow8(JComponent panel) 
    {
    	panel.add(Box.createHorizontalStrut(30));//pozioma rozpórka - szerokoœæ wiersza jakby

        JLabel label = new JLabel("Wspó³rzêdne siódmego punktu:");
        setPrefferedMaxAndMinSize(label, 300, 90);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
  
        panel.add(Box.createHorizontalStrut(15));
        
        label = new JLabel("x");
        setPrefferedMaxAndMinSize(label, 20, 20);
        panel.add(label);
        
        x7 = new JTextField();
        x7.setEditable(true);
        setPrefferedMaxAndMinSize(x7, 50, 50);
        panel.add(x7);
        
        panel.add(Box.createHorizontalStrut(30));
        
        label = new JLabel("y");
        setPrefferedMaxAndMinSize(label, 20, 20);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
        
        y7 = new JTextField();
        y7.setEditable(true);
        setPrefferedMaxAndMinSize(y7, 50, 50);
        panel.add(y7);
    }
    
    /**
     * 
     * @param panel main panel where the elements will be set in
     * Method builds place where user can key in data of eigth point for his chart
     */
    private void buildRow9(JComponent panel) 
    {
    	panel.add(Box.createHorizontalStrut(30));//pozioma rozpórka - szerokoœæ wiersza jakby

        JLabel label = new JLabel("Wspó³rzêdne ósmego punktu:");
        setPrefferedMaxAndMinSize(label, 300, 90);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
  
        panel.add(Box.createHorizontalStrut(15));
        
        label = new JLabel("x");
        setPrefferedMaxAndMinSize(label, 20, 20);
        panel.add(label);
        
        x8 = new JTextField();
        x8.setEditable(true);
        setPrefferedMaxAndMinSize(x8, 50, 50);
        panel.add(x8);
        
        panel.add(Box.createHorizontalStrut(30));
        
        label = new JLabel("y");
        setPrefferedMaxAndMinSize(label, 20, 20);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
        
        y8 = new JTextField();
        y8.setEditable(true);
        setPrefferedMaxAndMinSize(y8, 50, 50);
        panel.add(y8);
    }
    
    /**
     * 
     * @param panel main panel where the elements will be set in
     * Method builds place where user can key in data of ninth point for his chart
     */
    private void buildRow10(JComponent panel) 
    {
    	panel.add(Box.createHorizontalStrut(30));//pozioma rozpórka - szerokoœæ wiersza jakby

        JLabel label = new JLabel("Wspó³rzêdne dziewi¹tego punktu:");
        setPrefferedMaxAndMinSize(label, 300, 90);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
  
        panel.add(Box.createHorizontalStrut(15));
        
        label = new JLabel("x");
        setPrefferedMaxAndMinSize(label, 20, 20);
        panel.add(label);
        
        x9 = new JTextField();
        x9.setEditable(true);
        setPrefferedMaxAndMinSize(x9, 50, 50);
        panel.add(x9);
        
        panel.add(Box.createHorizontalStrut(30));
        
        label = new JLabel("y");
        setPrefferedMaxAndMinSize(label, 20, 20);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
        
        y9 = new JTextField();
        y9.setEditable(true);
        setPrefferedMaxAndMinSize(y9, 50, 50);
        panel.add(y9);
    }
    
    /**
     * 
     * @param panel main panel where the elements will be set in
     * Method builds place where user can key in data of tenth point for his chart
     */
    private void buildRow11(JComponent panel) 
    {
    	panel.add(Box.createHorizontalStrut(30));//pozioma rozpórka - szerokoœæ wiersza jakby

        JLabel label = new JLabel("Wspó³rzêdne dziesi¹tego punktu:");
        setPrefferedMaxAndMinSize(label, 300, 90);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
  
        panel.add(Box.createHorizontalStrut(15));
        
        label = new JLabel("x");
        setPrefferedMaxAndMinSize(label, 20, 20);
        panel.add(label);
        
        x10 = new JTextField();
        x10.setEditable(true);
        setPrefferedMaxAndMinSize(x10, 50, 50);
        panel.add(x10);
        
        panel.add(Box.createHorizontalStrut(30));
        
        label = new JLabel("y");
        setPrefferedMaxAndMinSize(label, 20, 20);//tu okreœlasz wielkoœæ obszaru, n którym ma siê zmieœciæ napis: "Podaj..."
        panel.add(label);
        
        y10 = new JTextField();
        y10.setEditable(true);
        setPrefferedMaxAndMinSize(y10, 50, 50);
        panel.add(y10);
    }
	
    /**
     * 
     * @param panel main panel where the elements will be set in
     * Method lets user to enter changes and leave this window.
     * If method checkAddition() returns true (it means - all necessary fields have been filled),
     * this method change button "Zobacz" on main window to be enabled. 
     */
    private void buildRow12(JComponent panel) 
    {
    	panel.add(Box.createHorizontalGlue());
    	
        JButton button = new JButton("OK");
        setPrefferedMaxAndMinSize(button, 60, 24);
        button.setToolTipText("ZatwierdŸ");
        button.setBackground(Color.white);
        button.setForeground(new Color(32,178,170));
        
        //button.addActionListener(new CloseWindow());//tu nie mo¿e byæ CloseWindow, bo ono zamyka program, tak¹ ma w³aœciwoœæ 
        button.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent e) 
        	{
        		if(checkAddition())//jeœli dodano wymagane wartoœci do pól, to udostêpnij przycisk patrzenia na wykres
        			client.seeButton.setEnabled(true);
        		else
        			client.seeButton.setEnabled(false);//bo mo¿e poprzednio wpisa³am i ju¿
        		//siê podœwietli³ przycisk, a teraz drugi raz w to wesz³am i usunê³am wartoœci z pól
        		//dispose();
        		setVisible(false);// mo¿e to lepiej ni¿ dispose, bo nie mogê zabiæ tego okna ca³kiem
        		//ma byæ mo¿liwœæ ponownego otwarcia i zobaczenia wprowadzonych danych poprzednich
        	}
        	});
        
        panel.add(button);

        panel.add(Box.createHorizontalStrut(10));
    }
    
    /**
     * 
     *  The method keeps active only these text fields, which are enough for the number of points needed to key in by user.	 
     */
    public void setEnable()
    {
    	switch(numberOfPoints)
    	{
    		case 1: {x2.setEditable(false);   y2.setEditable(false);}; // bez break'ów, ¿eby w³aœnie te poni¿ej te¿ siê wykonywa³y
    		case 2: {x3.setEditable(false);   y3.setEditable(false);};
    		case 3: {x4.setEditable(false);   y4.setEditable(false);};
    		case 4: {x5.setEditable(false);   y5.setEditable(false);};
    		case 5: {x6.setEditable(false);   y6.setEditable(false);};
    		case 6: {x7.setEditable(false);   y7.setEditable(false);};
    		case 7: {x8.setEditable(false);   y8.setEditable(false);};
    		case 8: {x9.setEditable(false);   y9.setEditable(false);};
    		case 9: {x10.setEditable(false);  y10.setEditable(false);};
    		//default niepotrzebne
    	}
    }
    
    /**
     * 
     * @return true if all necessary text fields have been filled or false in the opposite case
     */
    private boolean checkAddition() // sprawdzam, czy wszystkie wymagane pola s¹ wype³nione
    //bo póŸniej muszê wiedzieæ, czy mo¿na ju¿ zobaczyæ wykres, czy jeszcze nie
    {
    	/*for(int i=0; i<numberOfPoints; i++)
    	{
    		if(x[i].getText()==null || y[i].getText()==null)
    			return false;
    	}
    	return true;*/
    	
    	//Jeœli powinno byæ wype³nione, a nie jest, to zwróæ false, a tym samym nie zezwalaj 
    	// na dostêp do pzycisku pokazuj¹cego wykres. Wystarczy spr. x czy by³ Editable,
    	//bo jego y z pary ma tak¹ sam¹ wartoœæ w Editable.
    	if((x1.isEditable()==true) && (x1.getText().isEmpty() || y1.getText().isEmpty()))
    		return false;
    	if((x2.isEditable()==true) && (x2.getText().isEmpty() || y2.getText().isEmpty()))
    		return false;
    	if((x3.isEditable()==true) && (x3.getText().isEmpty() || y3.getText().isEmpty()))
    		return false;
    	if((x4.isEditable()==true) && (x4.getText().isEmpty() || y4.getText().isEmpty()))
    		return false;
    	if((x5.isEditable()==true) && (x5.getText().isEmpty() || y5.getText().isEmpty()))
    		return false;
    	if((x6.isEditable()==true) && (x6.getText().isEmpty() || y6.getText().isEmpty()))
    		return false;
    	if((x7.isEditable()==true) && (x7.getText().isEmpty() || y7.getText().isEmpty()))
    		return false;
    	if((x8.isEditable()==true) && (x8.getText().isEmpty() || y8.getText().isEmpty()))
    		return false;
    	if((x9.isEditable()==true) && (x9.getText().isEmpty() || y9.getText().isEmpty()))
    		return false;
    	if((x10.isEditable()==true) && (x10.getText().isEmpty() || y10.getText().isEmpty()))
    		return false;
    	//if((x10.isEditable()==true) && (x10.getText()=="" || y10.getText()==""))
    	//	return false;
    	
    	return true;
    	
    }
	
	
	public static void main(String[] args) //throws IOException
    { 
		
		//setDebugBorder();
		
    }

}
