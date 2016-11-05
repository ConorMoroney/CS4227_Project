package Java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import SQL.Connect;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class BarChart extends ApplicationFrame
{

	private BarChart(String applicationTitle, String chartTitle)
	{
		super( applicationTitle );
		JFreeChart barChart = ChartFactory.createBarChart(
				chartTitle,           
				"Category",            
				"Score",            
				createDataset(),          
				PlotOrientation.VERTICAL,           
				true, true, false);
		setDefaultCloseOperation(ApplicationFrame.DISPOSE_ON_CLOSE);
		ChartPanel chartPanel = new ChartPanel( barChart );        
		chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
		
		setContentPane( chartPanel );
		
	}
	private CategoryDataset createDataset( )
	{
		String [] Types = {"pen","pencil","paper","folder","copy","paperclip","ruler","evelope"};
		int[] quantities = new int[7];
		
		try
		{	
			//Java.Connect to database
			   Connect con = new Connect();
    		   Connection mycon =  con.getconnection();
    		   Statement mystat = mycon.createStatement();
    		   
			//Get ID for Java.user
			for(int i = 0 ; i < Types.length;i++)
			{
				String sql = "select * from creationary..items where type = '" + Types[i] + "'";
				System.out.println(sql);
				ResultSet myRe = mystat.executeQuery(sql);

				//get db data
				while (myRe.next())
				{
					System.out.println(myRe.getInt(7));
					//type = myRe.getString(2);
					quantities[i] += Integer.parseInt(myRe.getString(7));
				}
				System.out.println("quantity"+ quantities[i]);
			}
		}
		catch(Exception ex){
			System.out.println("Error cant connect to database");
		}
		final String Item = "Item Type";
		      
		final DefaultCategoryDataset dataset = 
				new DefaultCategoryDataset( );  


		for(int j = 0 ; j <Types.length-1 ;j++){
			dataset.addValue( quantities[j] , Item , Types[j]); 
		}
		

		return dataset; 
	}
	public static void reports()
	{
		BarChart chart = new BarChart("Manger Reports", "Manager reports:");
		chart.pack( );        
		RefineryUtilities.centerFrameOnScreen( chart );        
		chart.setVisible( true ); 
	}
}