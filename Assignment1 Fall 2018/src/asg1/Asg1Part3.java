package asg1;

import java.util.Scanner;

public class Asg1Part3 
{ 
	public static boolean isOdd (int aNumber)
	{
		boolean retValue = true; 
		
		if (!(aNumber % 2 == 0)) 
		{
			retValue = false; 
			
		}
		
	return retValue; 
	} //End of method that check for odd or even. 
	
	public static String getCategory(double value)
	{
		String s = "";  
		
		if(value > 100.0) 
		{
			s = "over"; 
		}
		
		else if (value <= 100.0 && value >= 25.0) 
		{
			s = "average"; 
			
		}
		
		else if (value < 25.0)
		{
			s = "below"; 
		}
		
		else
		{
			System.out.println("Nothing here!");
		}
	
	return s; 	
	}
	
	
	public static void main (String[] args) 
	{
		Scanner scanner = new Scanner (System.in);
		
		boolean checkNumber; 
		String getNumber1 = "";
		// Asking for the number. 
		System.out.println("Enter an integer here to check if Odd or Even: ");
		int n = scanner.nextInt(); 
		
		checkNumber = isOdd(n);
		if(checkNumber == true) 
		{
			System.out.println("Even number: " + n);
		}
		
		else 
		{
			System.out.println("Odd number: " + n);
		} // End of checking for odd or even number. 
		
		//Asking for the number. 
		System.out.println("Enter another interger to check for its value: ");
		double n3 = scanner.nextDouble(); 
		getNumber1 = getCategory(n3);
		
		System.out.println(getNumber1);
		
	} 
}
