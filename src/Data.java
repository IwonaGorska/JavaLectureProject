import java.awt.Color;
import java.io.Serializable;

import org.jfree.chart.JFreeChart;

/**
 * 
 * @author Iwona Górska
 * The class which is communication medium between client and server. Each of them has it's own object and fulfill some data
 * using it's fields. Consists of two constructors.
 * 
 */
public class Data implements Serializable
{
	
	public double x1, x2, x3, x4, x5, x6, x7, x8, x9, x10;
	public double y1, y2, y3, y4, y5, y6, y7, y8, y9, y10;
	public int numberOfPoints;
	public String orientation;
	public String chartTitle;
	public String xTitle;
	public String yTitle;
	public Color colour;
	public JFreeChart lineGraph;
	double a, b,  c, d;
	String kindOfChart;
    
	/**
	 * Constructor for the chart "Inna" - function another than mathematics
	 * @param nr number of points to add
	 * @param orien orientation of chart
	 * @param chartT chart's title
	 * @param xT x axis' title
	 * @param yT y axis' title
	 * @param col line's color
	 * @param kindChooser kond of our chart
	 */
	//konstruktor dla wykresu "Inna"
    public Data(int nr, String orien, String chartT, String xT, String yT, Color col, String kindChooser)
    {
    	numberOfPoints=nr;
    	orientation=orien;
    	chartTitle=chartT;
    	xTitle=xT;
    	yTitle=yT;
    	colour=col;
    	//wstêpna inicjalizacja. Potrzebne userowi zostan¹ zast¹pione innymi wartoœciami.
    	x1=0;
    	y1=0;
    	x2=0;
    	y2=0;
    	x3=0;
    	y3=0;
    	x4=0;
    	y4=0;
    	x5=0;
    	y5=0;
    	x6=0;
    	y6=0;
    	x7=0;
    	y7=0;
    	x8=0;
    	y8=0;
    	x9=0;
    	y9=0;
    	x10=0;
    	y10=0;
    	this.kindOfChart=kindChooser;
    }
    
    /**
     * Constructor for the chart of mathematics function
     * @param orien orientation of chart
	 * @param chartT chart's title
	 * @param xT x axis' title
	 * @param yT y axis' title
     * @param col line's color
     * @param a 
     * @param b
     * @param c
     * @param kindChooser kond of our chart
     */
    //konstruktor dla wykresu f(x)
    public Data( String orien, String chartT, String xT, String yT, Color col, double a, double b, double c, double d, String kindChooser)
    {
    	
    	orientation=orien;
    	chartTitle=chartT;
    	xTitle=xT;
    	yTitle=yT;
    	colour=col;
    	this.a=a;
    	this.b=b;
    	this.c=c;
    	this.d=d;
    	this.kindOfChart=kindChooser;
    }
}
