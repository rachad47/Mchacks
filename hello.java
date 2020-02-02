import java.util.StringTokenizer;
import java.util.Scanner;
//import java.io.IOException;
//import java.io.PrintWriter;
// 
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

//@WebServlet("/loginServlet")

public class hello {

	public hello() {
		// TODO Auto-generated constructor stub
	}
	
	public final static int bigNumber = 1000000000;
	
	public static void main(String[] args) {
		
		Scanner reader = new Scanner (System.in);
		
		City Calgary = new City("Calgary", 1239220, 3.3, 428, 0.3);
		City Vancouver = new City("Vancouver", 675218, 9.3, 1283, 0.27);
		City Winnipeg = new City("Winnipeg", 749534, 1.9, 519, 0.37);
		City Moncton = new City("Moncton", 85198, 5.5, 1146, 0.3876);
		City St_Johns = new City("St. John's", 113948, 5.3, 1440, 0.41);
		City Yellowknife = new City("Yellowknife", 19569, -5.7, 280, 0.25);
		City Halifax = new City("Halifax", 431479, 6.5, 1410, 0.28);
		City Iqaluit = new City("Iqaluit", 7740, -10, 422, 0.25);
		City Toronto = new City("Toronto", 2731571, 8.3, 760, 0.23);
		City Charlottetown = new City("Charlottetown", 36094, 5.8, 1127, 0.32);
		City Montreal = new City("Montreal", 1704694, 6.4, 975, 0.34);
		City Saskatoon = new City("Saskatoon", 273010, 2, 354, 0.32);
		City Whitehorse = new City("Whitehorse", 25085, -0.9, 273, 0.25);
		City Edmonton = new City("Edmonton", 981280, 2.8, 459, 0.31);
		City Ottowa = new City("Ottowa", 994837, 6, 868, 0.33);
		City Quebec_City = new City("Quebec City", 542298, 4.8, 1101, 0.34);
		City Waterloo = new City("Waterloo", 535554, 6.6, 926, 0.37);
		City London = new City("London", 404699, 7.4, 946, 0.41);
		
	    City [] Cities = {Calgary, Vancouver, Winnipeg, Moncton, St_Johns, Yellowknife, Halifax, 
				Iqaluit, Toronto, Charlottetown, Montreal, Saskatoon, Whitehorse, Edmonton,
				Ottowa, Quebec_City, Waterloo, London}; //Length 18
	    
	    ////////////////////////////////////////////////////////////////////////////////////////
	    
	    //User Inputs Stuff
	    
	    String trueinput = "";
	    int beginIndex = 0;
	    //String input = trueinput.substring(beginIndex);
	    
	    System.out.println("Enter Query String: ");
	    String input = reader.nextLine();
	    
	    //String input = "temp=verycold&rain=wet&city=big&skill=a&french=on";
	    
	    //String Tokenizer stuff
	    String [] inputs = new String [10]; //Actually length 5 or 6
	    
	    StringTokenizer s = new StringTokenizer(input, "&");
	    for (int i = 0; i < inputs.length; i++) {
	    	if (s.hasMoreTokens()) {
	    		inputs[i] = s.nextToken();
	    	}
	    }
	    
	    double iPopulation = 0;
	    double iMean_temp = 0;
	    double iPrecipitation = 0;
	    double iJob_Level = 0;
	    boolean iEnglish = true;
	    boolean iFrench = true;
	    
	    
	    //System.out.println("<html> HELLLLOOOO </html>");
	    

	    //Population
	    if (inputs[2].equals("city=big")) { //Large Population
	    	iPopulation = 900000*1.25;
	    }
	    else if (inputs[2].equals("city=medium")) { //Medium Population
	    	iPopulation = 500000;
	    }
	    else { //city=small
	    	iPopulation = 100000*0.75; //Small Population
	    }
	    
	    //Mean_Temp
	    if (inputs[0].equals("temp=medium")) { //Medium
	    	iMean_temp = 7*1.25;
	    }
	    else if (inputs[0].equals("temp=cold")) { //Cold
	    	iMean_temp = 4.5;
	    }
	    else { //temp=verycold
	    	iMean_temp = 2*0.75; //Extremely Cold
	    }
	    
	    //Precipitation
	    if (inputs[1].equals("rain=wet")) { //Rainy
	    	iPrecipitation = 780*1.25;
	    }
	    else { //rain=dry
	    	iPrecipitation = 780*0.75;
	    }
	    
	    //Job Level
	    if (inputs[3].equals("skill=c") || inputs[3].equals("skill=d")) { //Type C or D
	    	iJob_Level = 0.38*1.25;
	    }
	    else if (inputs[3].equals("skill=b")) { //Type B
	    	iJob_Level = 0.345;
	    }
	    else { //skill=0 || skill=b
	    	iJob_Level = 0.31*0.75; //Type 0 or A
	    }
	    
	    //French
	    if (inputs[4].equals("french=on")) {
	    	iFrench = true;
	    }
	    else if (inputs[4].equals("english=on")) {
	    	iEnglish = true;
	    	iFrench = false;
	    }
	    else { //
	    	iFrench = false;
	    }
	    
	    //English
	    if (inputs[5] != null && inputs[5].equals("english=on")) {
	    	iEnglish = true;
	    }
	    else {
	    	iEnglish = false;
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    City iCity = new City("iCity", iPopulation, iMean_temp, iPrecipitation, iJob_Level); //Ideal City, chosen by user
	    
		String answer = getCity(iCity, Cities, iEnglish, iFrench);
	    
		System.out.println(answer);
		
		
		
	}
	
	public static String getCity(City c1, City [] c, boolean english, boolean french) { //c1 is made by user's choices
		int min = bigNumber;
		String minCity = "";
		for (int i = 0; i < c.length; i++) {
			if (Cost(c[i], c1) <= min) {
				if (english && french) {
					min = Cost(c[i], c1);
					minCity = c[i].getName();
				}
				else if (english && !french) {
					if (c[i].getName().equals("Quebec City")) {
						
					}
					else {
						min = Cost(c[i], c1);
						minCity = c[i].getName();
					}
				}
				else if (!english && french) {
					if (c[i].getName().equals("Montreal") || c[i].getName().equals("Ottawa") || c[i].getName().equals("Quebec City")) {
						min = Cost(c[i], c1);
						minCity = c[i].getName();
					}
				}
				else {
					//Don't come to Canada.. jk
				}
			}
		}
		return minCity;
	}
	
	public static int Cost(City c1, City c2) {
		int d1 = Population_Size(c1.getPopulation()) - Population_Size(c2.getPopulation());
		int d2 = Temperature_Size(c1.getMean_temp()) - Temperature_Size(c2.getMean_temp());
		int d3 = Precipitation_Size(c1.getPrecipitation()) - Precipitation_Size(c2.getPrecipitation());
		int d4 = Job_Level_Size(c1.getJob_Level()) - Job_Level_Size(c2.getJob_Level());
		return d1*d1 + d2*d2 + d3*d3 + d4*d4; //Outputs a not-weighted cost function...
	}

	//Size (Low, Medium, High)
	public static int Population_Size(double num) {
		if (num >= 900000) {
			return 3; //High Population
		} 
		else if (num >= 100000) {
			return 2; //Medium Population
		}
		else if (num >= 0) {
			return 1; //Small Population
		}
		else {
			throw new IllegalArgumentException("Invalid Population");
		}
	}
	
	//Size (Extremely Cold, Cold, Medium)
	public static int Temperature_Size(double num) {
		if (num >= 7) {
			return 3; //Medium
		}
		else if (num >= 2) {
			return 2; //Cold
		}
		else {
			return 1; //Extremely Cold 
		}
	}
	
	//Size (Dry, Rainy)
	public static int Precipitation_Size(double num) {
		if (num >= 780) {
			return 2; //Rainy
		}
		else {
			return 1; //Dry
		}
	}
	
	//Size (Type 0 or A, Type B, Type C or D)
	public static int Job_Level_Size(double num) {
		if (num >= 0.38) {
			return 3; //Type C or D
		}
		else if (num >= 0.31) {
			return 2; //Type B
		}
		else {
			return 1; //Type 0 or A
		}
	}
	
	
}	



class City {

	//Instance Variables
	private String Name;
	private double Population;
	private double Mean_temp;
	private double Precipitation;
	private double Job_Level;
	
	//Constructors
	public City() {
		
	}

	public City(String Name, double Population, double Mean_temp, double Precipitation, double Job_Level) {
		this.Name = Name;
		this.Population = Population;
		this.Mean_temp = Mean_temp;
		this.Precipitation = Precipitation;
		this.Job_Level = Job_Level;
	}
	
	//Getters
	public String getName() {
		return Name;
	}
	
	public double getPopulation() {
		return Population;
	}
	
	public double getMean_temp() {
		return Mean_temp;
	}
	
	public double getPrecipitation() {
		return Precipitation;
	}
	
	public double getJob_Level() {
		return Job_Level;
	}
	
	
	
	
	
	
	
	


}






