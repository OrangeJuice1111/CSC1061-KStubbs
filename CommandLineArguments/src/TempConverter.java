/*
 * Copyright (c) Kyle Stubbs 2026
 * 
 * 
 */

/**
 * Methods to convert Temperature from one system to another
 * 
 * @author kstu1
 */
import java.util.Arrays;

public class TempConverter {

	public final double FREEZING_TIME_IN_CELCIUS = 0;
	public final double FREEZING_TIME_IN_FAHRENHEIT = 32;
	
	
	public static void main(String[] args) {
		double answer = 0.0;
		if(args.length < 2) {
			System.out.println("Usage:");
			System.out.println("\t-f <temp> to convert to Fahrenheit");
			System.out.println("\t-c <temp> to convert to Celcius");
			System.exit(-1);
		}
		
		
		System.out.println(Arrays.toString(args));
		System.exit(0);
		
		if(args[0].equals("-f")) {
			answer = ConvertCelToFah(Double.parseDouble(args[1]));
			System.out.println("The Fahrenheit value is " + answer);
			
		}else if(args[0].equals("-c")) {
			answer = ConvertFahToCel(Double.parseDouble(args[1]));
			System.out.println("The Celcius value is " + answer);
		}
		
		
		
		double temp = 32;
		System.out.println("The Fahrenheit value is " + ConvertCelToFah(temp));
		
		double fah = 89.6;
		System.out.println("The Celcius vlaue is " + ConvertFahToCel(fah));
		
	}
	/**
	 * Converts a temp from fahrenheit to celcius
	 * @param temp in fahrenheit
	 * @return tempature in celcius
	 */
	public static double ConvertFahToCel(double input) {
		return((input - 32) * (5.0/9.0));
	}
	/**
	 * Converts a temp form ceclius to fahrenheit 
	 * @param tempature in celcius
	 * @return temp in fahreheit
	 */
	public static double ConvertCelToFah(double input) {
		return(input * (9.0/5.0)) + 32;
	}

}
