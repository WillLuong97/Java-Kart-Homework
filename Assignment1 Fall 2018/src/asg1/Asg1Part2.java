package asg1;

import java.util.Scanner;

public class Asg1Part2 
{
	public static void main (String[] args) 
	{
		Scanner scanner = new Scanner (System.in);
		
		// calculating the sum from 1 to 100 and print the sum with a message. 
		int s = 0; 
		for ( int index = 1; index <= 100; index ++) 
		{
			s += index; 
			
		}
		
		// Display message. 
		System.out.println("The sum from 1 to 100 is: " + s);
		
		// The number from 1 to 2000 that evenly divisible by 13. 
		int s1 = 0;
		for (int i = 1; i <= 2000; i ++)
		{
			if (i % 13 == 0)
			{
				s1 += i;
			}
		}
		
		//Display message. 
		System.out.println("The sum of numbers from 1 to 2000 that is also evenly divisible by 13 is: " + s1);
		
		//The sum of all the squares from 1 to 50. 
		int s2 = 0; 
		for (int t = 1; t <= 50; t++) 
		{
			s2+= (t*t);
			
		}
		
		// Display message. 
		System.out.print("The sum of the squares of all numbers from 1 to 50 is: " + s2);
		
		
	}
	
	
	
	
}
