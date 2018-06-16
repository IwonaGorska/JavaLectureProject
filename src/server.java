import java.awt.Color;
import java.io.*;
import java.net.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * 
 * @author Iwona Górska
 * @see ServerThread
 * @see Data
 * Derived class of ServerThread. Wider with new fields and own implementations of 2 methods. Participates in creating "another" chart.
 *
 */
class CreatorAnother extends ServerThread
{
	static double [] X = new double [10]; 
	static double [] Y = new double [10];
	
	static XYSeries dataSet= new XYSeries("seria 1");	            
    static XYSeriesCollection xySeriesCollection = new XYSeriesCollection(dataSet);
	
	public CreatorAnother(Socket s) throws IOException 
	{
		super(s);
	}
	
	/**
	 * @see Data
	 * setting fields with values from the object of class Data which was gotten thanks of the socket
	 */
	public static void addFieldsValues()
	{
		X[0]=dataFromClient.x1;
		System.out.println(X[0]);
		Y[0]=dataFromClient.y1;
		System.out.println(Y[0]);
		X[1]=dataFromClient.x2;
		System.out.println(X[1]);
		Y[1]=dataFromClient.y2;
		System.out.println(Y[1]);
		X[2]=dataFromClient.x3;
		Y[2]=dataFromClient.y3;
		X[3]=dataFromClient.x4;
		Y[3]=dataFromClient.y4;
		X[4]=dataFromClient.x5;
		Y[4]=dataFromClient.y5;
		X[5]=dataFromClient.x6;
		Y[5]=dataFromClient.y6;
		X[6]=dataFromClient.x7;
		Y[6]=dataFromClient.y7;
		X[7]=dataFromClient.x8;
		Y[7]=dataFromClient.y8;
		X[8]=dataFromClient.x9;
		Y[8]=dataFromClient.y9;
		X[9]=dataFromClient.x10;
		Y[9]=dataFromClient.y10;	
	}
	
	/**
	 * Method adds data to dataSet.
	 */
	//public static void createDataSet(XYSeries dataSet)
	public static void createDataSet()
	{

		dataSet.clear();//Trzeba wyczyœciæ zawsze, bo siê cuda dziej¹, nak³ada siê stare na nowo tworzony wykres, jeœli bez 
		//wy³¹czania aplikacji chce siê nastêpny wykres zobaczyæ ;) 
		System.out.println("createDataSetAnother");
		
		//wypelnianie serii 1 - dodawanie kolejnych punktow 
		System.out.println(numberOfPoints);
        
        for(int i=0; i<numberOfPoints; i++) 
        {          	
        	dataSet.add(X[i], Y[i]); 
        	System.out.println("dodany");
        	//System.out.println("dataSet.add  " +  X[i]+ " " + Y[i]);
        	//System.out.println("Y[i] w add  "+ Y[i]);
        }
	}	
}

/**
 * 
 * @author Iwona Górska
 * @see ServerThread
 * @see Data
 * Derived class of ServerThread. Wider with new fields and own implementations of 2 methods. Participates in creating mathematics chart.
 *
 */
class CreatorFx extends ServerThread
{

	static double a;
    static double b;
    static double c;
    static double d;
    
    static XYSeries dataSet= new XYSeries("seria 1");	            
    static XYSeriesCollection xySeriesCollection = new XYSeriesCollection(dataSet);
	
	public CreatorFx(Socket s) throws IOException 
	{
		super(s);
	}
	
	/**
	 * @see Data
	 * setting fields with values from the object of class Data which was gotten thanks of the socket
	 */
	public static void addFieldsValues()
	{
		a=dataFromClient.a;
	    b=dataFromClient.b; 
		if(dataFromClient.kindOfChart=="f(x)=a*x^2+b*x+c=0")
    		{	    			
        	    c=dataFromClient.c;//tylko przy kwadratowej mamy c
        	}
		if(dataFromClient.kindOfChart=="f(x)=a*x^3+b*x^2+c*x+d=0")
		{	    			
    	    c=dataFromClient.c;//tylko przy kwadratowej mamy c
    	    d=dataFromClient.d;
    	}
	}
	
	/**
	 * Method adds data to dataSet.
	 */
	//public static void createDataSet(XYSeries dataSet)
	public static void createDataSet()
	{
		int time;
	    boolean draw;
	    double bound1, bound2,x;  		
	    time=1;
	    draw=true;	    
	    bound1=-8;
	    bound2=8;		    
		x=bound1;
		
		dataSet.clear();
		
	    while(x<=bound2)
       {
	       if(dataFromClient.kindOfChart.equals("f(x)=a*x+b=0"))
	    	   dataSet.add(x, a*x+b);
	    	   
	       if(dataFromClient.kindOfChart.equals("f(x)=a*sin(bx)=0"))
	          dataSet.add(x, a*Math.sin(b*x));
	       
	       if(dataFromClient.kindOfChart.equals("f(x)=a*cos(bx)=0"))
	          dataSet.add(x, a*Math.cos(b*x));
	       
	       if(dataFromClient.kindOfChart.equals("f(x)=a*x^2+b*x+c=0"))
	         dataSet.add(x, a*x*x+b*x+c);
	       
	       if(dataFromClient.kindOfChart.equals("f(x)=a*x^3+b*x^2+c*x+d=0"))
		         dataSet.add(x, a*x*x*x+b*x*x+c*x+d);
	       
	       
	       x=x+0.008;
	       System.out.println("Nastepny punkt jest");			   
       }
	}
	
	
}

/**
 * 
 * @author Iwona Górska
 * @see Data
 * @see server
 * The class is the mother class of CreatorFx and CreatorAnother, is called in class server and creates the chart to present 
 * by the side of client - also sends it to client when it's ready.
 *
 */
class ServerThread extends Thread
{
    protected Socket socket;
    protected ObjectOutputStream outToClient;
    protected ObjectInputStream inFromClient; 
    //new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream())); - DRUGA MOZLIWOSC
    
    static int numberOfPoints;
    
    String orientation;
    String chartTitle;
    String xTitle;
    String yTitle;
    
  //Color colour;
    
    protected static Data dataFromClient = null;
     
    /**
     * @see Data
     * @param s socket made in server
     * @throws IOException
     * This method is a constructor.
     */
    public ServerThread(Socket s) throws IOException
    {
    	
    	socket = s;
    	outToClient = new ObjectOutputStream(socket.getOutputStream());
        inFromClient = new ObjectInputStream(socket.getInputStream());
        start();
    }
    
    /**
     * @see Data
     * Method takes values for it's fields from object of class Data, calls CreatorFx or CreatorAnother and later creates 
     * the chart and sends it to client.
     */
	public void run()
    {
		try
        {    		
    		// definiowanie serii:
		            //XYSeries dataSet= new XYSeries("seria 1");	            
		            //XYSeriesCollection xySeriesCollection = new XYSeriesCollection(dataSet);	       	   
            //W RAZIE CZEGO ODKOMENTUJ PONI¯SZ¥ LINIJKÊ
      	    //xySeriesCollection.addSeries(dataSet);
					
			try 
			{				
				dataFromClient = (Data)inFromClient.readObject();
			} 
			catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Zawiod³o pobieranie danych z clienta w public Watek");
			}
			
			
			XYSeriesCollection xySeriesCollection=null;//!!!!!!!!!!!!null dodane mze usunac
			
           //DataSet to obiekt przechowujacy dane. Wszystkie zbiory danych (ang. dataset) s¹ reprezentowane za pomoc¹ klas implementuj¹cych interfejs Dataset. 
            // tworzenie XYDataSet 
            ////XYDataset xyDataset = xySeriesCollection;                      
            JFreeChart lineGraph=null;//tak tylko, ¿eby nie krzycza³o may not have been initialized	            
            orientation=dataFromClient.orientation; 
            System.out.println(orientation);
            System.out.println("wypisales orientation?");
    	    chartTitle=dataFromClient.chartTitle;
    	    xTitle=dataFromClient.xTitle;
    	    yTitle=dataFromClient.yTitle;
    	    numberOfPoints=dataFromClient.numberOfPoints;//!!!!!!!!!!!!!!!!!!!
    	    
    	    System.out.println(dataFromClient.kindOfChart);
    	      
    	    if(dataFromClient.kindOfChart.equals("Inna"))
    	    {
    	    	CreatorAnother.addFieldsValues();
    	    	//CreatorAnother.createDataSet(dataSet);
    	    	CreatorAnother.createDataSet();
    	    	//xySeriesCollection.removeAllSeries();//!!!!!!!!!!!!!!
    	    	xySeriesCollection=CreatorAnother.xySeriesCollection; 
    	    	   
    	    }
            else
        	{
        		CreatorFx.addFieldsValues();
        		//CreatorFx.createDataSet(dataSet);
        		CreatorFx.createDataSet();
        		//xySeriesCollection.removeAllSeries();//!!!!!!!!!!!!!!
        		xySeriesCollection=CreatorFx.xySeriesCollection;
        		
     	       
       	}
    	    

    	    // tworzenie wykresu 
            if(orientation.equals("pozioma"))
            {
            	lineGraph = ChartFactory.createXYLineChart 
	                    ( chartTitle,                 // Title 
	                      xTitle,           	    // X-Axis label 
	                      yTitle,                  // Y-Axis label 
	                      ////xyDataset,        	  // Dataset  
	                      xySeriesCollection,
	                      PlotOrientation.HORIZONTAL,  //Plot orientation 
	                      true,                 //show legend 
	                      true,                // Show tooltips 
	                      false               //url show 
	                     );
            	
            	//wysy³ka grafu do clienta
            	//dataFromClient.lineGraph=lineGraph;
                //outToClient.writeObject(dataFromClient);
            }
    	            
            if(orientation.equals("pionowa"))
            {
            	lineGraph = ChartFactory.createXYLineChart 
	                    (chartTitle,                 // Title 
	                      xTitle,                   // X-Axis label 
	                      yTitle,                  // Y-Axis label 
	                      ////xyDataset,        	  // Dataset  
	                      xySeriesCollection,
	                      PlotOrientation.VERTICAL,        //Plot orientation 
	                      true,                 //show legend 
	                      true,                // Show tooltips 
	                      false               //url show 
	                     ); 
            }
    				
            	
        	lineGraph.setBackgroundPaint(Color.white);

            XYPlot plot = lineGraph.getXYPlot();
            plot.setBackgroundPaint(Color.lightGray);
            plot.setDomainGridlinePaint(Color.white);
            plot.setRangeGridlinePaint(Color.white);

            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            renderer.setSeriesLinesVisible(0, true);
            renderer.setSeriesShapesVisible(0, false);//jak tu by³o 1, to siê zaznacza³y punkty bardzo kwadratowe du¿e
            renderer.setSeriesPaint( 0, dataFromClient.colour);
            plot.setRenderer(renderer);
                      	
        	//wysy³ka grafu do clienta
        	dataFromClient.lineGraph=lineGraph;
            outToClient.writeObject(dataFromClient);
            
        }
    catch (IOException e) {}
    finally
    {
        try
        {
            socket.close();
        }
        catch(IOException e) {System.out.println("coœ posz³o nie tak w serwerze");}
    }	
    }
}

/**
 * 
 * @author Iwona Górska
 * The class which takes part in networking java.
 *
 */
public class server implements Serializable
{
    public static final int PORT = 8080;
    
    /**
     * 
     * @param args
     * @throws IOException
     * Method opens socket and communicate with client. All notifications brings to new thread.
     */
    public static void main(String[] args) throws IOException
    {
        ServerSocket s = new ServerSocket(PORT);
        
        try
        {
            while(true)
                {
                    Socket socket = s.accept();
                    //System.out.println("tu coœ jest");
                    try
                    {
                        new ServerThread(socket);
                    }
                    catch(IOException e)
                    {
                    	socket.close();
                    }
                }
        }
        finally
        {
            s.close();
        }
    }
}